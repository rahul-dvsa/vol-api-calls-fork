package apiCalls.enums;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public enum OperatorType {
    GOODS("lcat_gv"),
    PUBLIC("lcat_psv");

    private final String operatorTypes;

    private OperatorType(String operatorType) {
        this.operatorTypes = operatorType;
    }

    public String asString() {
        return operatorTypes;
    }

    public static OperatorType getEnum(@NotNull String name) {
        return Arrays.stream(OperatorType.values()).filter(status -> status.asString().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Unable to convert to enum, name: ".concat(name)));
    }
}