package apiCalls.Utils.generic;

import apiCalls.enums.TrafficAreaPostCodes;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class TrafficAreas {

    Random random = new Random();
    public String getPostCode(TrafficAreaPostCodes postCodes) {
        var result = switch (postCodes) {
            case NORTH_EAST:
                yield TrafficAreaPostCodes.NORTH_EAST.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case NORTH_WEST:
                yield TrafficAreaPostCodes.NORTH_WEST.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case MIDLANDS:
                yield TrafficAreaPostCodes.MIDLANDS.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case EAST:
                yield TrafficAreaPostCodes.EAST.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case WALES:
                yield TrafficAreaPostCodes.WALES.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case WEST:
                yield TrafficAreaPostCodes.WEST.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case LONDON:
                yield TrafficAreaPostCodes.LONDON.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case SCOTLAND:
                yield TrafficAreaPostCodes.SCOTLAND.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
            case NORTHERN_IRELAND:
                yield TrafficAreaPostCodes.NORTHERN_IRELAND.asString().concat(String.format("%s%s%s", randomTwoDigitInt(), randomOneDigitInt(), randomString()));
        };
        return String.valueOf(result);
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