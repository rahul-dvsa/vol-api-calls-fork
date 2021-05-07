package apiCalls.Utils.eupaBuilders;

import apiCalls.Utils.eupaBuilders.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "description",
        "refDataCategoryId"
})
public class PaymentStatusModel {

    @JsonProperty("description")
    private PaymentStatus description;
    @JsonProperty("refDataCategoryId")
    private String refDataCategoryId;

    @JsonProperty("description")
    public PaymentStatus getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(PaymentStatus description) {
        this.description = description;
    }

    public PaymentStatusModel withDescription(PaymentStatus description) {
        this.description = description;
        return this;
    }

    @JsonProperty("refDataCategoryId")
    public String getRefDataCategoryId() {
        return refDataCategoryId;
    }

    @JsonProperty("refDataCategoryId")
    public void setRefDataCategoryId(String refDataCategoryId) {
        this.refDataCategoryId = refDataCategoryId;
    }

    public PaymentStatusModel withRefDataCategoryId(String refDataCategoryId) {
        this.refDataCategoryId = refDataCategoryId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("description", description).append("refDataCategoryId", refDataCategoryId).toString();
    }

}