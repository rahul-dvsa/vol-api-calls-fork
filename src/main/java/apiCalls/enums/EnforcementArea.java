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

    private static final Map<String, EnforcementArea> map = new HashMap<>(values().length, 1);

    static {
        for (EnforcementArea ea: values()) map.put(ea.codes, ea);
    }

    public String asString() {
        return codes;
    }

    public static EnforcementArea getEnforcementArea(String code) {
        EnforcementArea ea = map.get(code);
        if (ea == null) {
            throw new IllegalArgumentException("Enforcement Area Code Invalid");
        }
        return ea;
    }

}