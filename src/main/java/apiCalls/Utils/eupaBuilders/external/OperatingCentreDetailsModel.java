package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.enums.TrafficArea;
import apiCalls.Utils.eupaBuilders.external.enums.EnforcementArea;
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
        "totAuthVehicles",
        "totAuthTrailers",
        "trafficArea",
        "totCommunityLicences",
        "enforcementArea",
        "version"
})
public class OperatingCentreDetailsModel {

    @JsonProperty("id")
    private String applicationNumber;
    @JsonProperty("totAuthVehicles")
    private Integer totAuthVehicles;
    @JsonProperty("totAuthTrailers")
    private Integer totAuthTrailers;
    @JsonProperty("trafficArea")
    private TrafficArea trafficArea;
    @JsonProperty("enforcementArea")
    private EnforcementArea enforcementArea;
    @JsonProperty("totCommunityLicences")
    private Integer totCommunityLicences;
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

    public OperatingCentreDetailsModel withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("totAuthVehicles")
    public Integer getTotAuthVehicles() {
        return totAuthVehicles;
    }

    @JsonProperty("totAuthVehicles")
    public void setTotAuthVehicles(Integer totAuthVehicles) {
        this.totAuthVehicles = totAuthVehicles;
    }

    public OperatingCentreDetailsModel withTotAuthVehicles(Integer totAuthVehicles) {
        this.totAuthVehicles = totAuthVehicles;
        return this;
    }

    @JsonProperty("totAuthTrailers")
    public Integer getTotAuthTrailers() {
        return totAuthTrailers;
    }

    @JsonProperty("totAuthTrailers")
    public void setTotAuthTrailers(Integer totAuthTrailers) {
        this.totAuthTrailers = totAuthTrailers;
    }

    public OperatingCentreDetailsModel withTAuthTrailers(Integer totAuthTrailers) {
        this.totAuthTrailers = totAuthTrailers;
        return this;
    }

    @JsonProperty("trafficArea")
    public TrafficArea getTrafficArea() {
        return trafficArea;
    }

    @JsonProperty("trafficArea")
    public void setTrafficArea(TrafficArea trafficArea) {
        this.trafficArea = trafficArea;
    }

    public OperatingCentreDetailsModel withTrafficArea(TrafficArea trafficArea) {
        setTrafficArea(trafficArea);
        return this;
    }

    @JsonProperty("enforcementArea")
    public EnforcementArea getEnforcementArea() {
        return enforcementArea;
    }

    @JsonProperty("enforcementArea")
    public void setEnforcementArea(EnforcementArea enforcementArea) {
        this.enforcementArea = enforcementArea;
    }

    public OperatingCentreDetailsModel withEnforcementArea(EnforcementArea enforcementArea) {
        setEnforcementArea(enforcementArea);
        return this;
    }
    @JsonProperty("totCommunityLicences")
    public Integer getTotCommunityLicences() {
        return totCommunityLicences;
    }

    @JsonProperty("totCommunityLicences")
    public void setTotCommunityLicences(Integer totCommunityLicences) {
        this.totCommunityLicences = totCommunityLicences;
    }

    public OperatingCentreDetailsModel withTotCommunityLicences(Integer totCommunityLicences) {
        this.totCommunityLicences = totCommunityLicences;
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

    public OperatingCentreDetailsModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationNumber())
                .append("totAuthVehicles", getTotAuthVehicles())
                .append("totAuthTrailers", getTotAuthTrailers())
                .append("trafficArea", getTrafficArea())
                .append("enforcementArea", getEnforcementArea())
                .append("totCommunityLicences", getTotCommunityLicences())
                .append("version", getVersion())
                .toString();
    }
}
