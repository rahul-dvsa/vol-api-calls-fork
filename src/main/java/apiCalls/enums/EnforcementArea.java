package apiCalls.enums;

import java.util.HashMap;
import java.util.Map;

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

    private final String codes;

    private EnforcementArea(String codes) {
        this.codes = codes.toUpperCase();
    }

    public String value() {
        return codes;
    }

    public static EnforcementArea[] enforcementAreaList() {
        return new EnforcementArea[]{EnforcementArea.NORTH_EAST, EnforcementArea.NORTH_WEST, EnforcementArea.MIDLANDS,
                EnforcementArea.EAST, EnforcementArea.WALES, EnforcementArea.WEST, EnforcementArea.LONDON,
                EnforcementArea.SCOTLAND, EnforcementArea.NORTHERN_IRELAND};
    }
}