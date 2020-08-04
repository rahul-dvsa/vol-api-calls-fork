package apiCalls.enums;

public enum TrafficAreaPostCodes {

    NORTH_EAST("BD"),
    NORTH_WEST("M"),
    MIDLANDS("B"),
    EAST("IP"),
    WALES("CF"),
    WEST("OX"),
    LONDON("E"),
    SCOTLAND("EH"),
    NORTHERN_IRELAND("BT");

    private final String trafficAreas;

    private TrafficAreaPostCodes(String trafficAreas) {
        this.trafficAreas = trafficAreas.toUpperCase();
    }

    public String asString() {
        return trafficAreas;
    }
}