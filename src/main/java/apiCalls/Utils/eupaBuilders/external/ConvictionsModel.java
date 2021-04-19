package apiCalls.Utils.eupaBuilders.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "prevConviction",
        "convictionsConfirmation",
        "version"
})
public class ConvictionsModel {

    @JsonProperty("id")
    private String applicationNumber;
    @JsonProperty("prevConviction")
    private Boolean prevConviction;
    @JsonProperty("convictionsConfirmation")
    private Boolean convictionsConfirmation;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("id")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("id")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public ConvictionsModel withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("prevConviction")
    public Boolean getPrevConviction() {
        return prevConviction;
    }

    @JsonProperty("prevConviction")
    public void setPrevConviction(Boolean prevConviction) {
        this.prevConviction = prevConviction;
    }

    public ConvictionsModel withPrevConviction(Boolean prevConviction) {
        this.prevConviction = prevConviction;
        return this;
    }

    @JsonProperty("convictionsConfirmation")
    public Boolean getConvictionsConfirmation() {
        return convictionsConfirmation;
    }

    @JsonProperty("convictionsConfirmation")
    public void setConvictionsConfirmation(Boolean convictionsConfirmation) {
        this.convictionsConfirmation = convictionsConfirmation;
    }

    public ConvictionsModel withConvictionsConfirmation(Boolean convictionsConfirmation) {
        this.convictionsConfirmation = convictionsConfirmation;
        return this;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    public ConvictionsModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationNumber())
                .append("prevConviction", getPrevConviction())
                .append("convictionsConfirmation", getConvictionsConfirmation())
                .append("version", getVersion())
                .toString();
    }
    
}
