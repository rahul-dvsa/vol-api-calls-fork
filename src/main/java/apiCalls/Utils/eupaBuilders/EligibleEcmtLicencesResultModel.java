package apiCalls.Utils.eupaBuilders;

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
        "licNo",
        "trafficArea",
        "totAuthVehicles",
        "licenceType"
})
public class EligibleEcmtLicencesResultModel {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("licNo")
    private String licNo;
    @JsonProperty("trafficArea")
    private String trafficArea;
    @JsonProperty("totAuthVehicles")
    private Integer totAuthVehicles;
    @JsonProperty("licenceType")
    private LicenceTypeModel licenceType;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public EligibleEcmtLicencesResultModel withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("licNo")
    public String getLicNo() {
        return licNo;
    }

    @JsonProperty("licNo")
    public void setLicNo(String licNo) {
        this.licNo = licNo;
    }

    public EligibleEcmtLicencesResultModel withLicNo(String licNo) {
        this.licNo = licNo;
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

    public EligibleEcmtLicencesResultModel withTrafficArea(String trafficArea) {
        this.trafficArea = trafficArea;
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

    public EligibleEcmtLicencesResultModel withTotAuthVehicles(Integer totAuthVehicles) {
        this.totAuthVehicles = totAuthVehicles;
        return this;
    }

    @JsonProperty("licenceType")
    public LicenceTypeModel getLicenceType() {
        return this.licenceType;
    }

    @JsonProperty("licenceType")
    public void setLicenceType(LicenceTypeModel licenceType) {
        this.licenceType = licenceType;
    }

    public EligibleEcmtLicencesResultModel withLicenceType(LicenceTypeModel licenceType) {
        setLicenceType(licenceType);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("licNo", licNo)
                .append("trafficArea", trafficArea)
                .append("totAuthVehicles", totAuthVehicles)
                .toString();
    }

}