package apiCalls.Utils.eupaBuilders.internal.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethod {

    Cash("fpm_cash");

    private String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.method;
    }

}
