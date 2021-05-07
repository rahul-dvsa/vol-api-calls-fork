package apiCalls.Utils.eupaBuilders.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("Under Consideration")
    UNDER_CONSIDERATION("Under Consideration"),
    @JsonProperty("Cancelled")
    CANCELLED("Cancelled"),
    @JsonProperty("Not Yet Submitted")
    NOT_YET_SUBMITTED("Not Yet Submitted"),
    @JsonProperty("Valid")
    VALID("Valid"),
    @JsonProperty("Curtailed")
    CURTAILED("Curtailed"),
    @JsonProperty("Suspended")
    SUSPENDED("Suspended");

    private String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

}
