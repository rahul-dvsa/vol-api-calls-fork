package apiCalls.Utils.eupaBuilders.external.enums;

import activesupport.number.Int;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public enum Title {
    MR("title_mr");

    private String title;

    Title(String title) {
        this.title = title;
    }

    public static Title getEnum(@NotNull String title) {
        title = StringUtils.deleteWhitespace(title).toLowerCase();
        Title titleEnum;

        switch(title) {
            case "title_mr":
                titleEnum = MR;
                break;
            default:
                throw new IllegalArgumentException("Unsupported title: ".concat(title));
        }

        return titleEnum;
    }

    public static Title randomEnum() {
        return Title.values()[Int.random(0, Title.values().length - 1)];
    }

    @Override
    @JsonValue
    public String toString() {
        return title;
    }

}
