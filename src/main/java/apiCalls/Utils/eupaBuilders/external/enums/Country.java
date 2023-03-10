package apiCalls.Utils.eupaBuilders.external.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public enum Country {
    GB("GB");

    private String countryCode;

    Country(String countryCode) {
        this.countryCode = countryCode;
    }

    public static Country getEnum(@NotNull String countryCode) {
        countryCode = StringUtils.deleteWhitespace(countryCode).toLowerCase();
        Country countryEnum;

        switch (countryCode) {
            case "gb":
                countryEnum = GB;
                break;
            default:
                throw new IllegalArgumentException("Unsupported country code: ".concat(countryCode));
        }

        return countryEnum;
    }

    @Override
    @JsonValue
    public String toString() {
        return countryCode;
    }

}
