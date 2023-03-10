package apiCalls.Utils.eupaBuilders.enums;

import activesupport.number.Int;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TrafficArea {
    NorthEast("B", "North East of England"),
    NorthWest("C", "North West of England"),
    Midlands("D", "West Midlands"),
    East("F", "East of England"),
    Wales("G", "Wales"),
    West("H", "West of England"),
    London("K", "London and the South East of England"),
    Scotland("M", "Scotland"),
    NorthernIreland("N", "Northern Ireland");

    private String id;
    private String name;

    TrafficArea(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TrafficArea getEnum(@NotNull String trafficArea) {
        trafficArea = StringUtils.trim(trafficArea).toLowerCase();
        TrafficArea trafficAreaEnum;

        switch(trafficArea) {
            case "west midlands":
            case "d":
                trafficAreaEnum = Midlands;
                break;
            case "north east of england":
            case "b":
                trafficAreaEnum = NorthEast;
                break;
            case "north west of england":
            case "c":
                trafficAreaEnum = NorthWest;
                break;
            case "east of england":
            case "f":
                trafficAreaEnum = East;
                break;
            case "wales":
            case "g":
                trafficAreaEnum = Wales;
                break;
            case "west of england":
            case "h":
                trafficAreaEnum = West;
                break;
            case "london and the south east of england":
            case "k":
                trafficAreaEnum = London;
                break;
            case "scotland":
            case "m":
                trafficAreaEnum = Scotland;
                break;
            case "northern ireland":
            case "n":
                trafficAreaEnum = NorthernIreland;
                break;
            default:
                throw new IllegalArgumentException("Unsupported traffic area: ".concat(trafficArea));
        }

        return trafficAreaEnum;
    }

    public static TrafficArea random() {
        return random(Arrays.asList(TrafficArea.values()));
    }

    public static TrafficArea randomExcept(TrafficArea... areas) {
        List<TrafficArea> desiredAreas = Stream.of(TrafficArea.values())
                .filter(area -> Stream.of(areas).noneMatch(invalidArea -> invalidArea == area)).collect(Collectors.toList());
        return random(desiredAreas);
    }

    public static TrafficArea random(List<TrafficArea> trafficAreas) {
        int idx = Int.random(0, trafficAreas.size() - 1);
        return trafficAreas.get(idx);
    }

    @Override
    @JsonValue
    public String toString() {
        return id;
    }

    public String getName(){
        return name;
    }
}
