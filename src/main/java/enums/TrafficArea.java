package enums;

public enum TrafficArea {

    NORTH_EAST("B"),
    NORTH_WEST("C"),
    MIDLANDS("D"),
    EAST("F"),
    WALES("G"),
    WEST("H"),
    LONDON("K"),
    SCOTLAND("M"),
    NORTHERN_IRELAND("N");

    private final String trafficAreas;

    private TrafficArea(String trafficAreas){
        this.trafficAreas = trafficAreas;
    }

    public String asString() {
        return trafficAreas;
    }
}