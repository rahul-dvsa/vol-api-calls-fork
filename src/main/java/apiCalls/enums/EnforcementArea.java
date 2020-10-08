package apiCalls.enums;

public enum EnforcementArea {
    NORTH_EAST("EA-B"),
    NORTH_WEST("EA-C"),
    MIDLANDS("EA-D"),
    EAST("EA-F"),
    WALES("EA-E"),
    WEST("EA-J"),
    LONDON("EA-H"),
    SCOTLAND("EA-A"),
    NORTHERN_IRELAND("EA-N");

    private final String trafficAreas;

    private EnforcementArea(String trafficAreas) {
        this.trafficAreas = trafficAreas.toUpperCase();
    }

    public String asString() {
        return trafficAreas;
    }
}