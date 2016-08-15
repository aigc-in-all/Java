package com.demo.json;

public class CircleCategory extends Circle {
    private boolean joined;
    private OrganizationType mobileOrganizationType;

    public CircleCategory(String id, String name) {
        super(id, name);
    }

    public boolean isJoined() {
        return joined;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    public OrganizationType getMobileOrganizationType() {
        return mobileOrganizationType;
    }

    public void setMobileOrganizationType(OrganizationType mobileOrganizationType) {
        this.mobileOrganizationType = mobileOrganizationType;
    }

    @Override
    public String toString() {
        return "CircleCategory [mobileOrganizationType=" + mobileOrganizationType + "]" + super.toString();
    }

}
