package apiCalls.Utils.volBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "totAuthHgvVehicles",
        "totAuthLgvVehicles",
        "totAuthTrailers",
        "trafficArea",
        "totCommunityLicences",
        "enforcementArea",
        "version"
})
public class OperatingCentreUpdater {

    @JsonProperty("id")
    private String id;
    @JsonProperty("totAuthHgvVehicles")
    private Integer totAuthHgvVehicles;
    @JsonProperty("totAuthLgvVehicles")
    private Integer totAuthLgvVehicles;
    @JsonProperty("totAuthTrailers")
    private Integer totAuthTrailers;
    @JsonProperty("trafficArea")
    private String trafficArea;
    @JsonProperty("enforcementArea")
    private String enforcementArea;
    @JsonProperty("totCommunityLicences")
    private Integer totCommunityLicences;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public OperatingCentreUpdater withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("totAuthHgvVehicles")
    public Integer getTotAuthHgvVehicles() {
        return totAuthHgvVehicles;
    }

    @JsonProperty("totAuthHgvVehicles")
    public void setTotAuthHgvVehicles(Integer totAuthHgvVehicles) {
        this.totAuthHgvVehicles = totAuthHgvVehicles;
    }

    public OperatingCentreUpdater withTotAuthHgvVehicles(Integer totAuthHgvVehicles) {
        this.totAuthHgvVehicles = totAuthHgvVehicles;
        return this;
    }

    @JsonProperty("totAuthLgvVehicles")
    public Integer getTotAuthLgvVehicles() {
        return totAuthLgvVehicles;
    }

    @JsonProperty("totAuthLgvVehicles")
    public void setTotAuthLgvVehicles(Integer totAuthLgvVehicles) {
        this.totAuthLgvVehicles = totAuthLgvVehicles;
    }

    public OperatingCentreUpdater withTotAuthLgvVehicles(Integer totAuthLgvVehicles) {
        this.totAuthLgvVehicles = totAuthLgvVehicles;
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

    public OperatingCentreUpdater withTotAuthTrailers(Integer totAuthTrailers) {
        this.totAuthTrailers = totAuthTrailers;
        return this;
    }

    @JsonProperty("trafficArea")
    public String getTrafficArea() {
        return trafficArea;
    }

    @JsonProperty("trafficArea")
    public void setTrafficArea(String trafficArea) {
        this.trafficArea = trafficArea;
    }

    public OperatingCentreUpdater withTrafficArea(String trafficArea) {
        this.trafficArea = trafficArea;
        return this;
    }

    @JsonProperty("enforcementArea")
    public String getEnforcementArea() {
        return enforcementArea;
    }

    @JsonProperty("enforcementArea")
    public void setEnforcementArea(String enforcementArea) {
        this.enforcementArea = enforcementArea;
    }

    public OperatingCentreUpdater withEnforcementArea(String enforcementArea) {
        this.enforcementArea = enforcementArea;
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

    public OperatingCentreUpdater withTotCommunityLicences(Integer totCommunityLicences) {
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

    public OperatingCentreUpdater withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return  new ToStringBuilder(ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("totAuthHgvVehicles", getTotAuthHgvVehicles())
                .append("totAuthLgvVehicles", getTotAuthLgvVehicles())
                .append("totAuthTrailers", getTotAuthTrailers())
                .append("trafficArea", getTrafficArea())
                .append("enforcementArea", getEnforcementArea())
                .append("totCommunityLicences", getTotCommunityLicences())
                .append("version", getVersion()).toString();
    }
}