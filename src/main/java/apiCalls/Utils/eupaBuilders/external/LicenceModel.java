package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.external.enums.TachographIns;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import apiCalls.Utils.eupaBuilders.enums.Boolean;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "safetyInsVehicles",
        "safetyInsTrailers",
        "safetyInsVaries",
        "tachographIns",
        "version"
})
public class LicenceModel {

    @JsonProperty("id")
    private String licenceNumber;
    @JsonProperty("version")
    private Integer version = 1;
    @JsonProperty("safetyInsVehicles")
    private String safetyInsVehicles;
    @JsonProperty("safetyInsTrailers")
    private String safetyInsTrailers;
    @JsonProperty("safetyInsVaries")
    private Boolean safetyInsVaries;
    @JsonProperty("tachographIns")
    private TachographIns tachographIns;

    @JsonProperty("id")
    public String getLicenceNumber() {
        return licenceNumber;
    }

    @JsonProperty("id")
    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public LicenceModel withLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
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

    public LicenceModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @JsonProperty("safetyInsVehicles")
    public String getSafetyInsVehicles() {
        return safetyInsVehicles;
    }

    @JsonProperty("safetyInsVehicles")
    public void setSafetyInsVehicles(String safetyInsVehicles) {
        this.safetyInsVehicles = safetyInsVehicles;
    }

    public LicenceModel withSafetyInsVehicles(String safetyInsVehicles) {
        this.safetyInsVehicles = safetyInsVehicles;
        return this;
    }

    @JsonProperty("safetyInsTrailers")
    public String getSafetyInsTrailers() {
        return safetyInsTrailers;
    }

    @JsonProperty("safetyInsTrailers")
    public void setSafetyInsTrailers(String safetyInsTrailers) {
        this.safetyInsTrailers = safetyInsTrailers;
    }

    public LicenceModel withSafetyInsTrailers(String safetyInsTrailers) {
        this.safetyInsTrailers = safetyInsTrailers;
        return this;
    }

    @JsonProperty("safetyInsVaries")
    public Boolean getSafetyInsVaries() {
        return safetyInsVaries;
    }

    @JsonProperty("safetyInsVaries")
    public void setSafetyInsVaries(Boolean safetyInsVaries) {
        this.safetyInsVaries = safetyInsVaries;
    }

    public LicenceModel withSafetyInsVaries(Boolean safetyInsVaries) {
        setSafetyInsVaries(safetyInsVaries);
        return this;
    }

    @JsonProperty("tachographIns")
    public TachographIns getTachographIns() {
        return tachographIns;
    }

    @JsonProperty("tachographIns")
    public void setTachographIns(TachographIns tachographIns) {
        this.tachographIns = tachographIns;
    }

    public LicenceModel withTachographIns(TachographIns tachographIns) {
        this.tachographIns = tachographIns;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getLicenceNumber())
                .append("version",getVersion())
                .append("safetyInsVehicles", getSafetyInsVehicles())
                .append("safetyInsVaries", getSafetyInsVaries())
                .append("safetyInsTrailers", getSafetyInsTrailers())
                .append("tachographIns:", getTachographIns())
                .toString();
    }

}
