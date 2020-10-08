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
        switch (trafficAreas) {
            case "B" :
                 "BD".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                 break;
            case "C":
                 "M".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case "D":
                "B".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case "F":
                "IP".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case "G":
               "CF".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case "H":
                "OX".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case "K":
                "E".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case "M":
                 "EH".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            case "N":
                "BT".concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + trafficAreas);
        };
        return getPostCode();
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