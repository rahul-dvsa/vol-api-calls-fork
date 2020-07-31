package apiCalls.enums;

public enum TrafficAreaPostCodes {

    NORTH_EAST("BD162UA"),
    NORTH_WEST("M446TL"),
    MIDLANDS("B440TA"),
    EAST("IP138ES"),
    WALES("CF116EE"),
    WEST("OX11BY"),
    LONDON("E72EW"),
    SCOTLAND("EH139DY"),
    NORTHERN_IRELAND("BT28HQ");

    private final String trafficAreas;

    private TrafficAreaPostCodes(String trafficAreas) {
        this.trafficAreas = trafficAreas.toUpperCase();
    }

    public String asString() {
        return trafficAreas;
    }
}