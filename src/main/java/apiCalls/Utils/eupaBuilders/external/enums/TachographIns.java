package apiCalls.Utils.eupaBuilders.external.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public enum TachographIns {

    NONE("tach_na");

    String tachograph;

    TachographIns(String tachograph) {
        this.tachograph = tachograph;
    }

    public static TachographIns getEnum(@NotNull String tachograph) {
        TachographIns tachographEnum;

        switch(StringUtils.deleteWhitespace(tachograph.toLowerCase())) {
            case "tach_na":
                tachographEnum = NONE;
                break;
            default:
                throw new IllegalArgumentException("Unsupported tachograph value: ".concat(tachograph));
        }

        return tachographEnum;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.tachograph;
    }

}
