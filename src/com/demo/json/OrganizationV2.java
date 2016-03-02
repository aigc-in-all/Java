package com.demo.json;

public class OrganizationV2 extends Circle {

    private OrganizationType type;
    private CircleStatus circleStatus;

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public CircleStatus getCircleStatus() {
        return circleStatus;
    }

    public void setCircleStatus(CircleStatus circleStatus) {
        this.circleStatus = circleStatus;
    }

    @Override
    public String toString() {
        return "OrganizationV2 [type=" + type + "]" + super.toString();
    }

}
