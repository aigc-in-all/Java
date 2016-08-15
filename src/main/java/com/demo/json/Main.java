package com.demo.json;

import com.demo.JacksonMapper;

public class Main {

    private static JacksonMapper mapper = new JacksonMapper(false, true);

    public static void main(String args[]) throws Exception {
//        List<Circle> circles = new ArrayList<>();
//
//        Crowd crowd = new Crowd();
//        crowd.setName("crowd");
//        crowd.setId("id_crowd");
//
//        CircleCategory circleCategory = new CircleCategory();
//        circleCategory.setName("circle_category");
//        circleCategory.setId("id_circle_category");
//        circleCategory.setMobileOrganizationType(OrganizationType.COMPANY);
//
//        circles.add(crowd);
//        circles.add(circleCategory);
//
//        UserProfile profile = new UserProfile();
//        profile.setSubscribedCircles(circles);
//
//        String json = mapper.toJson(profile); // 老数据
//        System.out.println(json);

        String json = "{\"subscribedCircles\":[{\"id\":\"id_crowd\",\"name\":\"crowd\"},{\"id\":\"id_circle_category\",\"name\":\"circle_category\",\"mobileOrganizationType\":\"COMPANY\"}]}";

        UserProfile newProfile = mapper.fromJson(json, UserProfile.class);
        System.out.println(newProfile);
    }
}
