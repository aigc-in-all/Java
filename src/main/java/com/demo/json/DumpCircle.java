package com.demo.json;

import java.util.ArrayList;
import java.util.List;

public class DumpCircle {

    private String id;
    private String name;

    public DumpCircle() {}

    public DumpCircle(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DumpCircle [id=" + id + ", name=" + name + "]";
    }

    public static Circle parseCircle(DumpCircle dumpCircle) {
        if (dumpCircle == null) {
            return null;
        }

        if (dumpCircle instanceof DumpCircleCategory) {
            DumpCircleCategory dumpCircleCategory = (DumpCircleCategory) dumpCircle;
            return DumpCircleCategory.parseCircleCategory(dumpCircleCategory);
        }

        if (dumpCircle instanceof DumpOrganizationV2) {
            DumpOrganizationV2 dumpOrganizationV2 = (DumpOrganizationV2) dumpCircle;
            return DumpOrganizationV2.parseOrganizationV2(dumpOrganizationV2);
        }

        if (dumpCircle instanceof DumpCrowd) {
            DumpCrowd dumpCrowd = (DumpCrowd) dumpCircle;
            return DumpCrowd.parseCrowd(dumpCrowd);
        }

        return new Circle(dumpCircle.getId(), dumpCircle.getName());
    }

    public static List<Circle> parseCircles(List<DumpCircle> dumpCircles) {
        List<Circle> circles = new ArrayList<>();
        if (dumpCircles == null || dumpCircles.isEmpty()) {
            return circles;
        }

        for (DumpCircle dumpCircle : dumpCircles) {
            Circle circle = parseCircle(dumpCircle);
            if (circle != null) {
                circles.add(circle);
            }
        }

        return circles;
    }
}
