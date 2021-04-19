package apiCalls.Utils.eupaBuilders.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus {

    @JsonProperty("Outstanding")
    OUTSTANDING("Outstanding");

    private String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    @JsonValue
    @Override
    public String toString() {
        return status;
    }

}
