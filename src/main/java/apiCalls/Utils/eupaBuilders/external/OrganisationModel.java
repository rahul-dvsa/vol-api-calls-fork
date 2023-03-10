package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.EligibleEcmtLicencesResultModel;
import apiCalls.Utils.eupaBuilders.enums.Boolean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "hasInforceLicences",
        "allowEmail",
        "companyCertSeen",
        "confirmShareTrailerInfo",
        "confirmShareVehicleInfo",
        "id",
        "name",
        "eligibleEcmtLicences"
})
public class OrganisationModel {

    @JsonProperty("hasInforceLicences")
    private java.lang.Boolean hasInforceLicences;
    @JsonProperty("allowEmail")
    private Boolean allowEmail;
    @JsonProperty("companyCertSeen")
    private Boolean companyCertSeen;
    @JsonProperty("confirmShareTrailerInfo")
    private Boolean confirmShareTrailerInfo;
    @JsonProperty("confirmShareVehicleInfo")
    private Boolean confirmShareVehicleInfo;
    @JsonProperty("id")
    private Integer organisationId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("eligibleEcmtLicences")
    private List<EligibleEcmtLicencesResultModel> eligibleEcmtLicences = null;

    @JsonProperty("hasInforceLicences")
    public java.lang.Boolean getHasInforceLicences() {
        return hasInforceLicences;
    }

    @JsonProperty("hasInforceLicences")
    public void setHasInforceLicences(java.lang.Boolean hasInforceLicences) {
        this.hasInforceLicences = hasInforceLicences;
    }

    public OrganisationModel withHasInforceLicences(java.lang.Boolean hasInforceLicences) {
        setHasInforceLicences(hasInforceLicences);
        return this;
    }

    @JsonProperty("allowEmail")
    public Boolean getAllowEmail() {
        return allowEmail;
    }

    @JsonProperty("allowEmail")
    public void setAllowEmail(Boolean allowEmail) {
        this.allowEmail = allowEmail;
    }

    public OrganisationModel withAllowEmail(Boolean allowEmail) {
        this.allowEmail = allowEmail;
        return this;
    }

    @JsonProperty("companyCertSeen")
    public Boolean getCompanyCertSeen() {
        return companyCertSeen;
    }

    @JsonProperty("companyCertSeen")
    public void setCompanyCertSeen(Boolean companyCertSeen) {
        this.companyCertSeen = companyCertSeen;
    }

    public OrganisationModel withCompanyCertSeen(Boolean companyCertSeen) {
        setCompanyCertSeen(companyCertSeen);
        return this;
    }

    @JsonProperty("confirmShareTrailerInfo")
    public Boolean getConfirmShareTrailerInfo() {
        return confirmShareTrailerInfo;
    }

    @JsonProperty("confirmShareTrailerInfo")
    public void setConfirmShareTrailerInfo(Boolean confirmShareTrailerInfo) {
        this.confirmShareTrailerInfo = confirmShareTrailerInfo;
    }

    public OrganisationModel withConfirmShareTrailerInfo(Boolean confirmShareTrailerInfo) {
        setConfirmShareTrailerInfo(confirmShareTrailerInfo);
        return this;
    }

    @JsonProperty("confirmShareVehicleInfo")
    public Boolean getConfirmShareVehicleInfo() {
        return confirmShareVehicleInfo;
    }

    @JsonProperty("confirmShareVehicleInfo")
    public void setConfirmShareVehicleInfo(Boolean confirmShareVehicleInfo) {
        this.confirmShareVehicleInfo = confirmShareVehicleInfo;
    }

    public OrganisationModel withConfirmShareVehicleInfo(Boolean confirmShareVehicleInfo) {
        setConfirmShareVehicleInfo(confirmShareVehicleInfo);
        return this;
    }

    @JsonProperty("id")
    public Integer getOrganisationId() {
        return organisationId;
    }

    @JsonProperty("id")
    public void setId(Integer organisationId) {
        this.organisationId = organisationId;
    }

    public OrganisationModel withOrganisationId(Integer organisationId) {
        this.organisationId = organisationId;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public OrganisationModel withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("eligibleEcmtLicences")
    public List<EligibleEcmtLicencesResultModel> getEligibleEcmtLicences(){
        return eligibleEcmtLicences;
    }

    @JsonProperty("eligibleEcmtLicences")
    public void setEligibleEcmtLicences(List<EligibleEcmtLicencesResultModel> eligibleEcmtLicences){
        this.eligibleEcmtLicences = eligibleEcmtLicences;
    }

    public OrganisationModel withEligibleEcmtLicences(List<EligibleEcmtLicencesResultModel> eligibleEcmtLicences){
        setEligibleEcmtLicences(eligibleEcmtLicences);
        return this;
    }

    public EligibleEcmtLicencesResultModel eligibleEcmtLicence(String licenceNumber){
        return eligibleEcmtLicences.stream()
                .filter((licence) -> StringUtils.deleteWhitespace(licence.getLicNo().toLowerCase())
                        .equals(StringUtils.deleteWhitespace(licenceNumber.toLowerCase())))
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("hasInforceLicences", hasInforceLicences)
                .append("allowEmail", allowEmail)
                .append("companyCertSeen", companyCertSeen)
                .append("confirmShareTrailerInfo", confirmShareTrailerInfo)
                .append("confirmShareVehicleInfo", confirmShareVehicleInfo)
                .append("id", organisationId)
                .append("name", name)
                .toString();
    }

}