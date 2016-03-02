package com.demo.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserProfile {

//    @JsonIgnore
//    private List<DumpCircle> dumpSubscribedCircles; // old

    private List<Circle> newSubscribedCircles; // new

//    public List<DumpCircle> getDumpSubscribedCircles() {
//        return dumpSubscribedCircles;
//    }

    @JsonProperty("subscribedCircles")
    public void setDumpSubscribedCircles(List<DumpCircle> dumpSubscribedCircles) {
        System.out.println("fuck");
        newSubscribedCircles = DumpCircle.parseCircles(dumpSubscribedCircles);
    }

    public List<Circle> getNewSubscribedCircles() {
        return newSubscribedCircles;
    }

    public void setNewSubscribedCircles(List<Circle> newSubscribedCircles) {
        this.newSubscribedCircles = newSubscribedCircles;
    }

    @Override
    public String toString() {
        return "UserProfile [newSubscribedCircles=" + newSubscribedCircles + "]";
    }
}
