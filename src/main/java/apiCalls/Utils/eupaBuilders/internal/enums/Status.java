package apiCalls.Utils.eupaBuilders.internal.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    // TODO: Identify what the status values mean and update the enumeration names to reflect this
    Unknown(1);

    private int status;

    Status(int status) {
        this.status = status;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(status);
    }

}
