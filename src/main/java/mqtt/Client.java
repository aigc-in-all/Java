package mqtt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月9日 上午10:07:28
 * @version V1.0
 */
public class Client {

    private static final String HOST = "tcp://127.0.0.1:61613";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    private static final String myTopic = "test/topic";

    private static MqttTopic topic;

    public static void main(String[] args) {

        try {
            MqttClient client = new MqttClient(HOST, "Server", new MemoryPersistence());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(USERNAME);
            options.setPassword(PASSWORD.toCharArray());

            options.setCleanSession(false);
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(20);

            client.setCallback(new MqttCallback() {

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("分发完成");
                }

                @Override
                public void connectionLost(Throwable t) {
                    System.out.println("连接断开：" + t.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("收到消息：" + new String(message.getPayload()));
                }
            });

            topic = client.getTopic(myTopic);

            client.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String content = reader.readLine();
                if (content.length() == 0) {
                    continue;
                }

                MqttMessage msg = new MqttMessage();
                msg.setQos(1);
                msg.setRetained(true);
                msg.setPayload(content.getBytes());

                try {
                    MqttDeliveryToken token = topic.publish(msg);
                    token.waitForCompletion();
                    System.out.println("发送成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("发送失败: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignore) {
                }
            }
        }

    }

}
