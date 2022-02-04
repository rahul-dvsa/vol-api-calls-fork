package apiCalls.enums;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public enum LicenceType {
    RESTRICTED("ltyp_r"),
    STANDARD_NATIONAL("ltyp_sn"),
    STANDARD_INTERNATIONAL("ltyp_si"),
    SPECIAL_RESTRICTED("ltyp_sr");

    private final String licenceTypes;

    private LicenceType(String licenceTypes){
        this.licenceTypes = licenceTypes;
    }

    public String asString() {
        return licenceTypes;
    }

    public static LicenceType getEnum(@NotNull String name) {
        return Arrays.stream(LicenceType.values()).filter(status -> status.asString().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Unable to convert to enum, name: ".concat(name)));
    }
}