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

    private TrafficArea(String trafficAreas) {
        this.trafficAreas = trafficAreas;
    }

    public String asString() {
        return trafficAreas;
    }

    static Random random = new Random();

    public static String getPostCode(TrafficArea trafficArea) {
        String postCode;
        switch (trafficArea) {
            case NORTH_EAST:
                postCode = "BD".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case NORTH_WEST:
                postCode = "M".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case MIDLANDS:
                postCode = "B".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case EAST:
                postCode = "IP".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case WALES:
                postCode = "CF".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case WEST:
                postCode = "OX".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case LONDON:
                postCode = "E".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case SCOTLAND:
                postCode = "EH".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case NORTHERN_IRELAND:
                postCode = "BT".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + trafficArea);
        }
        return postCode;
    }

    public static String randomString() {
        return RandomStringUtils.randomAlphabetic(2);
    }

    public static int randomTwoDigitInt() {
        return random.nextInt(99);
    }

    public static int randomOneDigitInt() {
        return random.nextInt(9);
    }
}