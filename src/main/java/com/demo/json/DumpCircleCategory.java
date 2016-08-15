package com.demo.json;

import java.util.ArrayList;
import java.util.List;

public class DumpCircleCategory extends DumpCircle {

    private boolean joined;
    private OrganizationType organizationType;

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public boolean isJoined() {
        return joined;
    }

    @Override
    public String toString() {
        return "DumpCircleCategory [organizationType=" + organizationType + "]" + super.toString();
    }

    public static CircleCategory parseCircleCategory(DumpCircleCategory dumpCircleCategory) {
        if (dumpCircleCategory == null) {
            return null;
        }

        CircleCategory circleCategory = new CircleCategory(dumpCircleCategory.getId(), dumpCircleCategory.getName());
        circleCategory.setJoined(dumpCircleCategory.isJoined());
        circleCategory.setMobileOrganizationType(dumpCircleCategory.getOrganizationType());
        return circleCategory;
    }

    public static List<CircleCategory> parseCircleCategories(List<DumpCircleCategory> dumpCircleCategories) {
        List<CircleCategory> circleCategories = new ArrayList<>();
        if (dumpCircleCategories == null || dumpCircleCategories.isEmpty()) {
            return circleCategories;
        }

        for (DumpCircleCategory dumpCircleCategory : dumpCircleCategories) {
            CircleCategory circleCategory = parseCircleCategory(dumpCircleCategory);
            if (circleCategory != null) {
                circleCategories.add(circleCategory);
            }
        }

        return circleCategories;
    }

}
