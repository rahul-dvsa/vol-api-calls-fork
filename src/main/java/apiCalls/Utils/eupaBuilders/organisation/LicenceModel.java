package apiCalls.Utils.eupaBuilders.organisation;

import apiCalls.Utils.eupaBuilders.LicenceTypeModel;
import apiCalls.Utils.eupaBuilders.StatusModel;
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
        "licNo",
        "licenceType",
        "status",
        "safetyInsVehicles",
        "totAuthVehicles",
        "safetyInsTrailers",
        "totAuthTrailers",
        "safetyInsVaries",
        "tachographIns",
        "ecmtApplications",
        "trafficArea",
        "version"
})
public class LicenceModel {

    @JsonProperty("id")
    private Integer licenceId;
    @JsonProperty("licNo")
    private String licNo;
    @JsonProperty("licenceType")
    private LicenceTypeModel licenceType;
    @JsonProperty("status")
    private StatusModel status;
    @JsonProperty("version")
    private Integer version = 1;
    @JsonProperty("safetyInsVehicles")
    private Integer safetyInsVehicles;
    @JsonProperty("totAuthVehicles")
    private Integer totAuthVehicles;
    @JsonProperty("safetyInsTrailers")
    private Integer safetyInsTrailers;
    @JsonProperty("totAuthTrailers")
    private Integer totAuthTrailers;
    @JsonProperty("safetyInsVaries")
    private Boolean safetyInsVaries;
    @JsonProperty("tachographIns")
    private TachographIns tachographIns;
    @JsonProperty("ecmtApplications")
    private Object ecmtApplications;
    @JsonProperty("trafficArea")
    private TrafficArea trafficArea;

    @JsonProperty("id")
    public Integer getLicenceId() {
        return licenceId;
    }

    @JsonProperty("id")
    public void setLicenceNumber(Integer licenceId) {
        this.licenceId = licenceId;
    }

    public LicenceModel withLicenceNumber(Integer licenceId) {
        this.licenceId = licenceId;
        return this;
    }

    @JsonProperty("licNo")
    public String getLicNo() {
        return licNo;
    }

    @JsonProperty("licNo")
    public LicenceModel setLicNo(String licNo) {
        this.licNo = licNo;
        return this;
    }

    @JsonProperty("licenceType")
    public LicenceTypeModel getLicenceType() {
        return licenceType;
    }

    @JsonProperty("licenceType")
    public LicenceModel setLicenceType(LicenceTypeModel licenceType) {
        this.licenceType = licenceType;
        return this;
    }

    @JsonProperty("status")
    public StatusModel getStatus() {
        return status;
    }

    @JsonProperty("status")
    public LicenceModel setStatus(StatusModel status) {
        this.status = status;
        return this;
    }

    @JsonProperty("totAuthVehicles")
    public Integer getTotAuthVehicles() {
        return totAuthVehicles;
    }

    @JsonProperty("totAuthVehicles")
    public LicenceModel setTotAuthVehicles(Integer  totAuthVehicles) {
        this.totAuthVehicles = totAuthVehicles;
        return this;
    }

    @JsonProperty("totAuthTrailers")
    public Integer getTotAuthTrailers() {
        return totAuthTrailers;
    }

    @JsonProperty("totAuthTrailers")
    public LicenceModel setTotAuthTrailers(Integer totAuthTrailers) {
        this.totAuthTrailers = totAuthTrailers;
        return this;
    }

    @JsonProperty("ecmtApplications")
    public Object getEcmtApplications() {
        return ecmtApplications;
    }

    @JsonProperty("ecmtApplications")
    public LicenceModel setEcmtApplications(Object ecmtApplications) {
        this.ecmtApplications = ecmtApplications;
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
    public Integer getSafetyInsVehicles() {
        return safetyInsVehicles;
    }

    @JsonProperty("safetyInsVehicles")
    public void setSafetyInsVehicles(Integer safetyInsVehicles) {
        this.safetyInsVehicles = safetyInsVehicles;
    }

    public LicenceModel withSafetyInsVehicles(Integer safetyInsVehicles) {
        this.safetyInsVehicles = safetyInsVehicles;
        return this;
    }

    @JsonProperty("safetyInsTrailers")
    public Integer getSafetyInsTrailers() {
        return safetyInsTrailers;
    }

    @JsonProperty("safetyInsTrailers")
    public void setSafetyInsTrailers(Integer safetyInsTrailers) {
        this.safetyInsTrailers = safetyInsTrailers;
    }

    public LicenceModel withSafetyInsTrailers(Integer safetyInsTrailers) {
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

    @JsonProperty("trafficArea")
    public TrafficArea getTrafficArea() {
        return trafficArea;
    }

    @JsonProperty("trafficArea")
    public void setTrafficArea(TrafficArea trafficArea) {
        this.trafficArea = trafficArea;
    }

    public LicenceModel withTrafficArea(TrafficArea trafficArea) {
        this.trafficArea = trafficArea;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getLicenceId())
                .append("version",getVersion())
                .append("safetyInsVehicles", getSafetyInsVehicles())
                .append("safetyInsVaries", getSafetyInsVaries())
                .append("safetyInsTrailers", getSafetyInsTrailers())
                .append("tachographIns:", getTachographIns())
                .append("licNo", licNo)
                .append("licenceType", licenceType)
                .append("status", status)
                .append("totAuthVehicles", totAuthVehicles)
                .append("totAuthTrailers", totAuthTrailers)
                .append("ecmtApplications", ecmtApplications)
                .toString();
    }

}

