package apiCalls.Utils.eupaBuilders.external.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public enum OperatorType {

    Goods("lcat_gv"),
    PublicService("lcat_psv");

    private String operatorType;

    OperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public static OperatorType getEnum(@NotNull String operatorType) {
        operatorType = StringUtils.deleteWhitespace(operatorType).toLowerCase();
        OperatorType operatorTypeEnum;

        switch(operatorType) {
            case "lcat_gv":
                operatorTypeEnum = Goods;
                break;
            case "lcat_psv":
                operatorTypeEnum = PublicService;
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: ".concat(operatorType));
        }

        return operatorTypeEnum;
    }

    @Override
    @JsonValue
    public String toString() {
        return operatorType;
    }

}
