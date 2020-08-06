package apiCalls.enums;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

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

    Random random = new Random();
    public String getPostCode() {
        var result = switch (trafficAreas) {
            case "B" :
                yield "BD".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case "C":
                yield "M".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case "D":
                yield "B".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case "F":
                yield "IP".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case "G":
                yield "CF".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case "H":
                yield "OX".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case "K":
                yield "E".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case "M":
                yield  "EH".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case "N":
                yield "BT".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            default:
                throw new IllegalStateException("Unexpected value: " + trafficAreas);
        };
        return result;
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(2);
    }

    public int randomTwoDigitInt() {
        return random.nextInt(99);
    }

    public int randomOneDigitInt() {
        return random.nextInt(9);
    }
}