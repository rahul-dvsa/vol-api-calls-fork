package apiCalls.Utils.eupaBuilders.external.enums;

import activesupport.number.Int;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public enum LicenceType {

    Restricted("ltyp_r"),
    StandardInternational("ltyp_si"),
    StandardNational("ltyp_sn"),
    SpecialRestricted("ltyp_sr");

    private String licenceType;

    LicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public static LicenceType getEnum(@NotNull String licenceType) {
        licenceType = StringUtils.deleteWhitespace(licenceType);
        LicenceType licenceTypeEnum;

        switch(licenceType) {
            case "ltyp_r":
                licenceTypeEnum = Restricted;
                break;
            case "ltyp_sn":
                licenceTypeEnum = StandardInternational;
                break;
            case "ltyp_si":
                licenceTypeEnum = StandardNational;
                break;
            case "ltyp_sr":
                licenceTypeEnum = SpecialRestricted;
            default:
                throw new IllegalArgumentException("Unsupported licence type: ".concat(licenceType));
        }

        return licenceTypeEnum;
    }

    public static LicenceType random(){
        int length = LicenceType.values().length - 1;
        return LicenceType.values()[Int.random(0, length)];
    }

    @Override
    @JsonValue
    public String toString() {
        return licenceType;
    }

}
