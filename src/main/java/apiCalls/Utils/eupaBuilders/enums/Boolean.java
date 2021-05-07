package apiCalls.Utils.eupaBuilders.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public enum Boolean {

    @JsonProperty("Y")
    TRUE("Y"),
    @JsonProperty("N")
    FALSE("N");

    private String answer;

    Boolean(@NotNull String answer) {
        this.answer = answer;
    }

    public static Boolean getEnum(@NotNull String answer) {
        Boolean myEnum;

        switch (StringUtils.deleteWhitespace(answer.toLowerCase())) {
            case "y":
                myEnum = TRUE;
                break;
            case "n":
                myEnum = FALSE;
                break;
            default:
                throw new IllegalArgumentException("Unsupported type '" + answer + "'");
        }

        return myEnum;
    }

    @Override
    @JsonValue
    public String toString() {
        return answer;
    }
}
