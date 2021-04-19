package apiCalls.Utils.eupaBuilders.organisation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cabotage",
        "declaration",
        "emissions",
        "id",
        "internationalJourneys",
        "noOfPermits",
        "permitsRequired",
        "trips",
        "version",
        "eligibleEcmtLicences",
        "dashboard"
})
public class OrganisationModel {

    @JsonProperty("cabotage")
    private Boolean cabotage;
    @JsonProperty("declaration")
    private Boolean declaration;
    @JsonProperty("emissions")
    private Boolean emissions;
    @JsonProperty("id")
    private Integer organisationId;
    @JsonProperty("internationalJourneys")
    private Integer internationalJourneys;
    @JsonProperty("licence")
    private LicenceModel licence;
    @JsonProperty("noOfPermits")
    private Integer noOfPermits;
    @JsonProperty("permitsRequired")
    private Integer permitsRequired;
    @JsonProperty("trips")
    private Integer trips;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("eligibleEcmtLicences")
    private ResultModel eligibleEcmtLicences;
    @JsonProperty("dashboard")
    private DashboardModel dashboard;

    @JsonProperty("cabotage")
    public Boolean getCabotage() {
        return cabotage;
    }

    @JsonProperty("cabotage")
    public void setCabotage(Boolean cabotage) {
        this.cabotage = cabotage;
    }

    public OrganisationModel withCabotage(Boolean cabotage) {
        this.cabotage = cabotage;
        return this;
    }

    @JsonProperty("declaration")
    public Boolean getDeclaration() {
        return declaration;
    }

    @JsonProperty("declaration")
    public void setDeclaration(Boolean declaration) {
        this.declaration = declaration;
    }

    public OrganisationModel withDeclaration(Boolean declaration) {
        this.declaration = declaration;
        return this;
    }

    @JsonProperty("emissions")
    public Boolean getEmissions() {
        return emissions;
    }

    @JsonProperty("emissions")
    public void setEmissions(Boolean emissions) {
        this.emissions = emissions;
    }

    public OrganisationModel withEmissions(Boolean emissions) {
        this.emissions = emissions;
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

    public OrganisationModel withId(Integer organisationId) {
        this.organisationId = organisationId;
        return this;
    }

    @JsonProperty("internationalJourneys")
    public Integer getInternationalJourneys() {
        return internationalJourneys;
    }

    @JsonProperty("internationalJourneys")
    public void setInternationalJourneys(Integer internationalJourneys) {
        this.internationalJourneys = internationalJourneys;
    }

    public OrganisationModel withInternationalJourneys(Integer internationalJourneys) {
        this.internationalJourneys = internationalJourneys;
        return this;
    }

    @JsonProperty("licence")
    public LicenceModel getLicence() {
        return licence;
    }

    @JsonProperty("licence")
    public void setLicence(LicenceModel licence) {
        this.licence = licence;
    }

    public OrganisationModel withLicence(LicenceModel licence) {
        this.licence = licence;
        return this;
    }

    @JsonProperty("noOfPermits")
    public Integer getNoOfPermits() {
        return noOfPermits;
    }

    @JsonProperty("noOfPermits")
    public void setNoOfPermits(Integer noOfPermits) {
        this.noOfPermits = noOfPermits;
    }

    public OrganisationModel withNoOfPermits(Integer noOfPermits) {
        this.noOfPermits = noOfPermits;
        return this;
    }

    @JsonProperty("permitsRequired")
    public Integer getPermitsRequired() {
        return permitsRequired;
    }

    @JsonProperty("permitsRequired")
    public void setPermitsRequired(Integer permitsRequired) {
        this.permitsRequired = permitsRequired;
    }

    public OrganisationModel withPermitsRequired(Integer permitsRequired) {
        this.permitsRequired = permitsRequired;
        return this;
    }

    @JsonProperty("trips")
    public Integer getTrips() {
        return trips;
    }

    @JsonProperty("trips")
    public void setTrips(Integer trips) {
        this.trips = trips;
    }

    public OrganisationModel withTrips(Integer trips) {
        this.trips = trips;
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

    public OrganisationModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @JsonProperty("eligibleEcmtLicences")
    public ResultModel getEligibleEcmtLicences(){
        return this.eligibleEcmtLicences;
    }

    @JsonProperty("eligibleEcmtLicences")
    public void setEligibleEcmtLicences(ResultModel eligibleEcmtLicences){
        this.eligibleEcmtLicences = eligibleEcmtLicences;
    }

    public OrganisationModel withEligibleEcmtLicences(ResultModel relevantLicences){
        setEligibleEcmtLicences(relevantLicences);
        return this;
    }

    @JsonProperty("dashboard")
    public DashboardModel getDashboard() {
        return dashboard;
    }

    public OrganisationModel setDashboard(DashboardModel dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("cabotage", cabotage)
                .append("declaration", declaration)
                .append("emissions", emissions)
                .append("id", organisationId)
                .append("internationalJourneys", internationalJourneys)
                .append("licence", licence)
                .append("noOfPermits", noOfPermits)
                .append("permitsRequired", permitsRequired)
                .append("trips", trips)
                .append("version", version)
                .append("dashboard", dashboard)
                .toString();
    }

}