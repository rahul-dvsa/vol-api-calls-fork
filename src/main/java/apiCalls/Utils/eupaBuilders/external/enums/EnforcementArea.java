package apiCalls.Utils.eupaBuilders.external.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

// TODO: Identify what the different enforcement areas are and what their corresponding codes are.
// TODO: Update enumeration Unknown to what the code 'D' represent.
public enum EnforcementArea {

    Unknown("EA-D");

    private String enforcementArea;

    EnforcementArea(String enforcementArea) {
        this.enforcementArea = enforcementArea;
    }

    public static EnforcementArea getEnum(@NotNull String enforcementArea) {
        enforcementArea = StringUtils.deleteWhitespace(enforcementArea).toLowerCase();
        EnforcementArea enforcementAreaEnum;

        switch (enforcementArea) {
            case "ea-d":
                enforcementAreaEnum = Unknown;
                break;
            default:
                throw new IllegalArgumentException("Unsupported enforcement area: ".concat(enforcementArea));
        }

        return enforcementAreaEnum;
    }

    @Override
    @JsonValue
    public String toString() {
        return enforcementArea;
    }

}
