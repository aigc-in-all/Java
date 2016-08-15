package com.demo.json;

public class DumpOrganizationV2 extends DumpCircle {

    private OrganizationType type;
    private CircleStatus circleStatus;

    public DumpOrganizationV2(String id, String name, OrganizationType type, CircleStatus circleStatus) {
        super(id, name);
        this.type = type;
        this.circleStatus = circleStatus;
    }

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
        return "DumpOrganizationV2 [type=" + type + "]" + super.toString();
    }

    public static OrganizationV2 parseOrganizationV2(DumpOrganizationV2 dumpOrganizationV2) {
        OrganizationV2 organizationV2 = new OrganizationV2();
        organizationV2.setId(dumpOrganizationV2.getId());
        organizationV2.setName(dumpOrganizationV2.getName());
        organizationV2.setCircleStatus(dumpOrganizationV2.getCircleStatus());
        organizationV2.setType(dumpOrganizationV2.getType());
        return organizationV2;
    }

}
