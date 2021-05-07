package apiCalls.Utils.eupaBuilders.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import apiCalls.Utils.eupaBuilders.enums.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "hasEnteredReg",
        "version"
})
public class VehiclesModel {

    @JsonProperty("id")
    private String applicationNumber;
    @JsonProperty("hasEnteredReg")
    private String hasEnteredReg;
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

    public VehiclesModel withId(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("hasEnteredReg")
    public String getHasEnteredReg() {
        return hasEnteredReg;
    }

    @JsonProperty("hasEnteredReg")
    public void setHasEnteredReg(Boolean hasEnteredReg) {
        this.hasEnteredReg = hasEnteredReg.toString();
    }

    public VehiclesModel withHasEnteredReg(Boolean hasEnteredReg) {
        this.hasEnteredReg = hasEnteredReg.toString();
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

    public VehiclesModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationNumber())
                .append("hasEnteredReg", getHasEnteredReg())
                .append("version", getVersion())
                .toString();
    }

}
