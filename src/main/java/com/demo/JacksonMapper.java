package com.demo;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JacksonMapper {
    private ObjectMapper objectMapper;

    private static final Pattern OLD_FORMAT_TIME = Pattern.compile("[0-9]+:[0-9]+:[0-9]");

    public JacksonMapper() {
        this(true, false);
    }

    public JacksonMapper(boolean failOnUnknownProperties) {
        this(failOnUnknownProperties, false);
    }

    public JacksonMapper(boolean failOnUnknownProperties, boolean supportDerivedClassInCollection) {
        objectMapper = createObjectMapper(supportDerivedClassInCollection);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public String toJson(Object value) throws JacksonException {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new JacksonException(value.toString(), e);
        } catch (IOException e) {
            throw new JacksonException(value.toString(), e);
        }
    }

    public <V> V fromJson(String json, Class<V> valueClass)
            throws JacksonException {
        return fromJson(json, toTypeRef(valueClass));
    }

    /**
     * This method is necessary for binding generic type containers, e.g.
     * List<T>, Map<K, V>.
     *
     * http://wiki.fasterxml.com/JacksonInFiveMinutes#Data_Binding_with_Generics
     * http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Generic_types
     */
    public <V> V fromJson(String json, TypeReference<V> valueTypeRef)
            throws JacksonException {
        try {
            return objectMapper.readValue(json, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new JacksonException(json, e);
        } catch (IOException e) {
            throw new JacksonException(json, e);
        }
    }

    public JsonNode createNode(String json) throws JacksonException {
        try {
            return objectMapper.readValue(json, JsonNode.class);
        } catch (JsonProcessingException e) {
            throw new JacksonException(json, e);
        } catch (IOException e) {
            throw new JacksonException(json, e);
        }
    }

    public <V> V fromJson(JsonNode node, Class<V> valueClass, String fieldName)
            throws JacksonException {
        return fromJson(node, toTypeRef(valueClass), fieldName);
    }

    public <V> V fromJson(JsonNode node, TypeReference<V> valueTypeRef, String fieldName)
            throws JacksonException {
        JsonNode target = node.get(fieldName);
        if (target == null) {
            return null;
        }

        try {
            return objectMapper.readValue(target, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new JacksonException(node.toString(), e);
        } catch (IOException e) {
            throw new JacksonException(node.toString(), e);
        }
    }

    public static <V> TypeReference<V> toTypeRef(final Class<V> clazz) {
        return new TypeReference<V>() {
            @Override
            public Type getType() {
                return clazz;
            }
        };
    }

    protected SimpleModule createModule() {
        return new SimpleModule("CacheModule", new Version(1, 0, 0, null))
                .addSerializer(DATE_SERIALIZER)
                .addDeserializer(Date.class, TIMESTAMP_DESERIALIZER)
                .addDeserializer(Timestamp.class, TIMESTAMP_DESERIALIZER);
    }

    private ObjectMapper createObjectMapper(boolean supportDerivedClassInCollection) {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = createModule();
        if (supportDerivedClassInCollection) {
            module.addSerializer(MAP_SERIALIZER).addSerializer(LIST_SERIALIZER);
        }
        mapper.registerModule(module);

        mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY)
                .setVisibility(JsonMethod.GETTER, Visibility.NONE)
                .setVisibility(JsonMethod.IS_GETTER, Visibility.NONE);

        mapper.setSerializationInclusion(Inclusion.NON_NULL);

        return mapper;
    }

    private static final JsonSerializer<Date> DATE_SERIALIZER = new ScalarSerializerBase<Date>(Date.class) {
        @Override
        public void serialize(Date value, JsonGenerator jgen,
                SerializerProvider provider) throws IOException,
                JsonGenerationException {
            if (!(value instanceof Timestamp)) {
                value = new Timestamp(value.getTime());
            }
            Timestamp ts = (Timestamp) value;
            long milliSeconds = ts.getTime();
            int nano = ts.getNanos();
            milliSeconds -= nano / 1000000;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(milliSeconds);
            jgen.writeString(seconds + ":" + nano);
        }
    };

    private static final JsonDeserializer<Timestamp> TIMESTAMP_DESERIALIZER = new FromStringDeserializer<Timestamp>(Timestamp.class) {
        @Override
        protected Timestamp _deserialize(String value,
                DeserializationContext ctxt) throws IOException,
                JsonProcessingException {
            if (OLD_FORMAT_TIME.matcher(value).find()) {
                return Timestamp.valueOf(value);
            }

            String[] formatStr = value.split(":");
            if (formatStr.length != 2) {
                throw new IllegalArgumentException("date format " + value +" is illegal");
            }

            long seconds = Long.parseLong(formatStr[0]);
            long milliSeconds = TimeUnit.SECONDS.toMillis(seconds);
            int nanoTime = Integer.parseInt(formatStr[1]);
            Timestamp ts = new Timestamp(milliSeconds);
            ts.setNanos(nanoTime);
            return ts;
        }
    };

    // XXX: Because jackson doesnot support derived class in collection(Map/List),
    //  and the form of data in Result between service and App was Map<String, Object> or List ,
    //  so we add special serializer for Map<String, Object> and List.
    //  the more information can see:
    //  https://shenzhen.wumii.net/reviewboard/r/14280/
    //  http://jira.codehaus.org/browse/JACKSON-544,
    //  and the content of "5. Known Issues" in : http://wiki.fasterxml.com/JacksonPolymorphicDeserialization
    private static final ScalarSerializerBase<Map<Object, Object>> MAP_SERIALIZER = new ScalarSerializerBase<Map<Object, Object>>(
            Map.class, false) {
        @Override
        public void serialize(Map<Object, Object> map,
                JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonGenerationException {
            jgen.writeStartObject();
            for (Map.Entry<Object, Object> e: map.entrySet()) {
                //  XXX: The serializer is a bit different from StdKeySerializer,
                //        And SimpleModule.setKeySerializers, SimpleModule.setKeyDeserializers may not produce a result.
                //        the Map to be json must be Map<String, Object> format, the Key of map must be String,
                //        which is standard json data format.
                //        the more information can see:
                //        http://stackoverflow.com/questions/11628698/can-we-make-object-as-key-in-map-when-using-json?rq=1
                jgen.writeFieldName(e.getKey().toString());
                jgen.writeObject(e.getValue());
            }
            jgen.writeEndObject();
        }
    };

    private static final ScalarSerializerBase<List<?>> LIST_SERIALIZER = new ScalarSerializerBase<List<?>>(List.class, false) {
        @Override
        public void serialize(List<?> list, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonGenerationException {
            jgen.writeStartArray();
            for (Object a : list) {
                jgen.writeObject(a);
            }
            jgen.writeEndArray();
        }
    };


    public static class JacksonException extends JsonProcessingException {

        private static final long serialVersionUID = 1023567556331673452L;

        public JacksonException(String msg) {
            super(msg);
        }

        protected JacksonException(String msg, Throwable rootCause) {
            super(msg, rootCause);
        }
    }
}
