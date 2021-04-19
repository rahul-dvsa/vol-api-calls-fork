package apiCalls.Utils.eupaBuilders.enums.permits;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Section {

    @JsonProperty("ecmt_section_sts_com")
    ECMT_COMPLETE("ecmt_section_sts_com"),
    @JsonProperty("ecmt_section_sts_nys")
    ECMT_INCOMPLETE("ecmt_section_sts_nys"),
    @JsonProperty("section_sts_com")
    COMPLETE("section_sts_com");

    private String status;

    Section(String status) {
        this.status = status;
    }

    @JsonValue
    @Override
    public String toString() {
        return status;
    }

}
