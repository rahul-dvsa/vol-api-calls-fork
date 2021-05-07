package apiCalls.Utils.eupaBuilders.organisation;

import apiCalls.Utils.eupaBuilders.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "cabotage",
        "checkedAnswers",
        "createdOn",
        "declaration",
        "emissions",
        "id",
        "internationalJourneys",
        "licence",
        "paymentStatus",
        "permitType",
        "permitsRequired",
        "status",
        "trips",
        "applicationRef",
        "canBeCancelled",
        "canBeSubmitted",
        "isNotYetSubmitted",
        "confirmationSectionCompletion",
        "sectionCompletion"
})
public class ResultModel {

    @JsonProperty("cabotage")
    private Boolean cabotage;
    @JsonProperty("checkedAnswers")
    private Boolean checkedAnswers;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("declaration")
    private Boolean declaration;
    @JsonProperty("emissions")
    private Boolean emissions;
    @JsonProperty("id")
    private Integer permitId;
    @JsonProperty("internationalJourneys")
    private Integer internationalJourneys;
    @JsonProperty("licence")
    private LicenceModel licence;
    @JsonProperty("paymentStatus")
    private PaymentStatusModel paymentStatus;
    @JsonProperty("permitType")
    private PermitTypeModel permitType;
    @JsonProperty("permitsRequired")
    private Integer permitsRequired;
    @JsonProperty("status")
    private StatusModel status;
    @JsonProperty("trips")
    private Integer trips;
    @JsonProperty("applicationRef")
    private String applicationRef;
    @JsonProperty("canBeCancelled")
    private Boolean canBeCancelled;
    @JsonProperty("canBeSubmitted")
    private Boolean canBeSubmitted;
    @JsonProperty("isNotYetSubmitted")
    private Boolean isNotYetSubmitted;
    @JsonProperty("confirmationSectionCompletion")
    private ConfirmationSectionCompletionModel confirmationSectionCompletion;
    @JsonProperty("sectionCompletion")
    private SectionCompletionModel sectionCompletion;

    @JsonProperty("cabotage")
    public Boolean getCabotage() {
        return cabotage;
    }

    @JsonProperty("cabotage")
    public void setCabotage(Boolean cabotage) {
        this.cabotage = cabotage;
    }

    public ResultModel withCabotage(Boolean cabotage) {
        this.cabotage = cabotage;
        return this;
    }

    @JsonProperty("checkedAnswers")
    public Boolean getCheckedAnswers() {
        return checkedAnswers;
    }

    @JsonProperty("checkedAnswers")
    public void setCheckedAnswers(Boolean checkedAnswers) {
        this.checkedAnswers = checkedAnswers;
    }

    public ResultModel withCheckedAnswers(Boolean checkedAnswers) {
        this.checkedAnswers = checkedAnswers;
        return this;
    }

    @JsonProperty("createdOn")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public ResultModel withCreatedOn(String createdOn) {
        this.createdOn = createdOn;
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

    public ResultModel withDeclaration(Boolean declaration) {
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

    public ResultModel withEmissions(Boolean emissions) {
        this.emissions = emissions;
        return this;
    }

    @JsonProperty("id")
    public Integer getPermitId() {
        return permitId;
    }

    @JsonProperty("id")
    public void setId(Integer permitId) {
        this.permitId = permitId;
    }

    public ResultModel withId(Integer permitId) {
        this.permitId = permitId;
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

    public ResultModel withInternationalJourneys(Integer internationalJourneys) {
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

    public ResultModel withLicence(LicenceModel licence) {
        setLicence(licence);
        return this;
    }

    @JsonProperty("paymentStatus")
    public PaymentStatusModel getPaymentStatus() {
        return paymentStatus;
    }

    @JsonProperty("paymentStatus")
    public void setPaymentStatus(PaymentStatusModel paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ResultModel withPaymentStatus(PaymentStatusModel paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    @JsonProperty("permitType")
    public PermitTypeModel getPermitType() {
        return permitType;
    }

    @JsonProperty("permitType")
    public void setPermitType(PermitTypeModel permitType) {
        this.permitType = permitType;
    }

    public ResultModel withPermitType(PermitTypeModel permitType) {
        this.permitType = permitType;
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

    public ResultModel withPermitsRequired(Integer permitsRequired) {
        this.permitsRequired = permitsRequired;
        return this;
    }

    @JsonProperty("status")
    public StatusModel getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(StatusModel status) {
        this.status = status;
    }

    public ResultModel withStatus(StatusModel status) {
        this.status = status;
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

    public ResultModel withTrips(Integer trips) {
        this.trips = trips;
        return this;
    }

    @JsonProperty("applicationRef")
    public String getApplicationRef() {
        return applicationRef;
    }

    @JsonProperty("applicationRef")
    public void setApplicationRef(String applicationRef) {
        this.applicationRef = applicationRef;
    }

    public ResultModel withApplicationRef(String applicationRef) {
        this.applicationRef = applicationRef;
        return this;
    }

    @JsonProperty("canBeCancelled")
    public Boolean getCanBeCancelled() {
        return canBeCancelled;
    }

    @JsonProperty("canBeCancelled")
    public void setCanBeCancelled(Boolean canBeCancelled) {
        this.canBeCancelled = canBeCancelled;
    }

    public ResultModel withCanBeCancelled(Boolean canBeCancelled) {
        this.canBeCancelled = canBeCancelled;
        return this;
    }

    @JsonProperty("canBeSubmitted")
    public Boolean getCanBeSubmitted() {
        return canBeSubmitted;
    }

    @JsonProperty("canBeSubmitted")
    public void setCanBeSubmitted(Boolean canBeSubmitted) {
        this.canBeSubmitted = canBeSubmitted;
    }

    public ResultModel withCanBeSubmitted(Boolean canBeSubmitted) {
        this.canBeSubmitted = canBeSubmitted;
        return this;
    }

    @JsonProperty("isNotYetSubmitted")
    public Boolean getIsNotYetSubmitted() {
        return isNotYetSubmitted;
    }

    @JsonProperty("isNotYetSubmitted")
    public void setIsNotYetSubmitted(Boolean isNotYetSubmitted) {
        this.isNotYetSubmitted = isNotYetSubmitted;
    }

    public ResultModel withIsNotYetSubmitted(Boolean isNotYetSubmitted) {
        this.isNotYetSubmitted = isNotYetSubmitted;
        return this;
    }

    @JsonProperty("confirmationSectionCompletion")
    public ConfirmationSectionCompletionModel getConfirmationSectionCompletion() {
        return confirmationSectionCompletion;
    }

    @JsonProperty("confirmationSectionCompletion")
    public void setConfirmationSectionCompletion(ConfirmationSectionCompletionModel confirmationSectionCompletion) {
        this.confirmationSectionCompletion = confirmationSectionCompletion;
    }

    public ResultModel withConfirmationSectionCompletion(ConfirmationSectionCompletionModel confirmationSectionCompletion) {
        this.confirmationSectionCompletion = confirmationSectionCompletion;
        return this;
    }

    @JsonProperty("sectionCompletion")
    public SectionCompletionModel getSectionCompletion() {
        return sectionCompletion;
    }

    @JsonProperty("sectionCompletion")
    public void setSectionCompletion(SectionCompletionModel sectionCompletion) {
        this.sectionCompletion = sectionCompletion;
    }

    public ResultModel withSectionCompletion(SectionCompletionModel sectionCompletion) {
        this.sectionCompletion = sectionCompletion;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("cabotage", cabotage)
                .append("checkedAnswers", checkedAnswers)
                .append("createdOn", createdOn)
                .append("declaration", declaration)
                .append("emissions", emissions)
                .append("id", permitId)
                .append("internationalJourneys", internationalJourneys)
                .append("licence", licence)
                .append("paymentStatus", paymentStatus)
                .append("permitType", permitType)
                .append("permitsRequired", permitsRequired)
                .append("status", status)
                .append("trips", trips)
                .append("applicationRef", applicationRef)
                .append("canBeCancelled", canBeCancelled)
                .append("canBeSubmitted", canBeSubmitted)
                .append("isNotYetSubmitted", isNotYetSubmitted)
                .append("confirmationSectionCompletion", confirmationSectionCompletion)
                .append("sectionCompletion", sectionCompletion)
                .toString();
    }

}