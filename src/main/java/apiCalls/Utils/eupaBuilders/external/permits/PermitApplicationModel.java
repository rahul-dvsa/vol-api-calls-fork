package apiCalls.Utils.eupaBuilders.external.permits;

import apiCalls.Utils.eupaBuilders.SectionCompletionModel;
import apiCalls.Utils.eupaBuilders.deserialiser.CustomLocalDateDeserialiser;
import apiCalls.Utils.eupaBuilders.deserialiser.DateISO8601Deserialiser;
import apiCalls.Utils.eupaBuilders.organisation.LicenceModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "cancellationDate",
        "checkedAnswers",
        "createdOn",
        "dateReceived",
        "declaration",
        "id",
        "irhpPermitType",
        "lastModifiedOn",
        "licence",
        "applicationRef",
        "canBeCancelled",
        "canBeSubmitted",
        "canBeUpdated",
        "hasOutstandingFees",
        "outstandingFeeAmount",
        "sectionCompletion",
        "hasCheckedAnswers",
        "hasMadeDeclaration",
        "isNotYetSubmitted",
        "isValid",
        "isFeePaid",
        "isIssueInProgress",
        "isAwaitingFee",
        "isUnderConsideration",
        "isReadyForNoOfPermits",
        "isCancelled",
        "isBilateral",
        "isMultilateral",
        "canCheckAnswers",
        "canMakeDeclaration",
        "permitsRequired",
        "canUpdateCountries"
})
public class PermitApplicationModel {

    @JsonProperty("cancellationDate")
    private String cancellationDate;
    @JsonProperty("checkedAnswers")
    private Boolean checkedAnswers;
    @JsonProperty("createdOn")
    @JsonDeserialize(using = DateISO8601Deserialiser.class)
    private LocalDateTime createdOn;
    @JsonProperty("dateReceived")
    @JsonDeserialize(using = CustomLocalDateDeserialiser.class)
    private LocalDate dateReceived;
    @JsonProperty("declaration")
    private Boolean declaration;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("irhpPermitType")
    private PermitTypeModel irhpPermitType;
    @JsonProperty("lastModifiedOn")
    @JsonDeserialize(using = DateISO8601Deserialiser.class)
    private LocalDateTime lastModifiedOn;
    @JsonProperty("licence")
    private LicenceModel licence;
    @JsonProperty("applicationRef")
    private String applicationRef;
    @JsonProperty("canBeCancelled")
    private Boolean canBeCancelled;
    @JsonProperty("canBeSubmitted")
    private Boolean canBeSubmitted;
    @JsonProperty("canBeUpdated")
    private Boolean canBeUpdated;
    @JsonProperty("hasOutstandingFees")
    private Boolean hasOutstandingFees;
    @JsonProperty("outstandingFeeAmount")
    private Integer outstandingFeeAmount;
    @JsonProperty("sectionCompletion")
    private SectionCompletionModel sectionCompletion;
    @JsonProperty("hasCheckedAnswers")
    private Boolean hasCheckedAnswers;
    @JsonProperty("hasMadeDeclaration")
    private Boolean hasMadeDeclaration;
    @JsonProperty("isNotYetSubmitted")
    private Boolean isNotYetSubmitted;
    @JsonProperty("isValid")
    private Boolean isValid;
    @JsonProperty("isFeePaid")
    private Boolean isFeePaid;
    @JsonProperty("isIssueInProgress")
    private Boolean isIssueInProgress;
    @JsonProperty("isAwaitingFee")
    private Boolean isAwaitingFee;
    @JsonProperty("isUnderConsideration")
    private Boolean isUnderConsideration;
    @JsonProperty("isReadyForNoOfPermits")
    private Boolean isReadyForNoOfPermits;
    @JsonProperty("isCancelled")
    private Boolean isCancelled;
    @JsonProperty("isBilateral")
    private Boolean isBilateral;
    @JsonProperty("isMultilateral")
    private Boolean isMultilateral;
    @JsonProperty("canCheckAnswers")
    private Boolean canCheckAnswers;
    @JsonProperty("canMakeDeclaration")
    private Boolean canMakeDeclaration;
    @JsonProperty("permitsRequired")
    private Integer permitsRequired;
    @JsonProperty("canUpdateCountries")
    private Boolean canUpdateCountries;

    @JsonProperty("cancellationDate")
    public String getCancellationDate() {
        return cancellationDate;
    }

    @JsonProperty("cancellationDate")
    public void setCancellationDate(String cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    @JsonProperty("checkedAnswers")
    public Boolean getCheckedAnswers() {
        return checkedAnswers;
    }

    @JsonProperty("checkedAnswers")
    public void setCheckedAnswers(Boolean checkedAnswers) {
        this.checkedAnswers = checkedAnswers;
    }

    @JsonProperty("createdOn")
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("dateReceived")
    public LocalDate getDateReceived() {
        return dateReceived;
    }

    @JsonProperty("dateReceived")
    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    @JsonProperty("declaration")
    public Boolean getDeclaration() {
        return declaration;
    }

    @JsonProperty("declaration")
    public void setDeclaration(Boolean declaration) {
        this.declaration = declaration;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("irhpPermitType")
    public PermitTypeModel getIrhpPermitType() {
        return irhpPermitType;
    }

    @JsonProperty("irhpPermitType")
    public void setIrhpPermitType(PermitTypeModel irhpPermitType) {
        this.irhpPermitType = irhpPermitType;
    }

    @JsonProperty("lastModifiedOn")
    public LocalDateTime getLastModifiedOn() {
        return lastModifiedOn;
    }

    @JsonProperty("lastModifiedOn")
    public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @JsonProperty("licence")
    public LicenceModel getLicence() {
        return licence;
    }

    @JsonProperty("licence")
    public void setLicence(LicenceModel licence) {
        this.licence = licence;
    }

    @JsonProperty("applicationRef")
    public String getApplicationRef() {
        return applicationRef;
    }

    @JsonProperty("applicationRef")
    public void setApplicationRef(String applicationRef) {
        this.applicationRef = applicationRef;
    }

    @JsonProperty("canBeCancelled")
    public Boolean getCanBeCancelled() {
        return canBeCancelled;
    }

    @JsonProperty("canBeCancelled")
    public void setCanBeCancelled(Boolean canBeCancelled) {
        this.canBeCancelled = canBeCancelled;
    }

    @JsonProperty("canBeSubmitted")
    public Boolean getCanBeSubmitted() {
        return canBeSubmitted;
    }

    @JsonProperty("canBeSubmitted")
    public void setCanBeSubmitted(Boolean canBeSubmitted) {
        this.canBeSubmitted = canBeSubmitted;
    }

    @JsonProperty("canBeUpdated")
    public Boolean getCanBeUpdated() {
        return canBeUpdated;
    }

    @JsonProperty("canBeUpdated")
    public void setCanBeUpdated(Boolean canBeUpdated) {
        this.canBeUpdated = canBeUpdated;
    }

    @JsonProperty("hasOutstandingFees")
    public Boolean getHasOutstandingFees() {
        return hasOutstandingFees;
    }

    @JsonProperty("hasOutstandingFees")
    public void setHasOutstandingFees(Boolean hasOutstandingFees) {
        this.hasOutstandingFees = hasOutstandingFees;
    }

    @JsonProperty("outstandingFeeAmount")
    public Integer getOutstandingFeeAmount() {
        return outstandingFeeAmount;
    }

    @JsonProperty("outstandingFeeAmount")
    public void setOutstandingFeeAmount(Integer outstandingFeeAmount) {
        this.outstandingFeeAmount = outstandingFeeAmount;
    }

    @JsonProperty("sectionCompletion")
    public SectionCompletionModel getSectionCompletion() {
        return sectionCompletion;
    }

    @JsonProperty("sectionCompletion")
    public void setSectionCompletion(SectionCompletionModel sectionCompletion) {
        this.sectionCompletion = sectionCompletion;
    }

    @JsonProperty("hasCheckedAnswers")
    public Boolean getHasCheckedAnswers() {
        return hasCheckedAnswers;
    }

    @JsonProperty("hasCheckedAnswers")
    public void setHasCheckedAnswers(Boolean hasCheckedAnswers) {
        this.hasCheckedAnswers = hasCheckedAnswers;
    }

    @JsonProperty("hasMadeDeclaration")
    public Boolean getHasMadeDeclaration() {
        return hasMadeDeclaration;
    }

    @JsonProperty("hasMadeDeclaration")
    public void setHasMadeDeclaration(Boolean hasMadeDeclaration) {
        this.hasMadeDeclaration = hasMadeDeclaration;
    }

    @JsonProperty("isNotYetSubmitted")
    public Boolean getIsNotYetSubmitted() {
        return isNotYetSubmitted;
    }

    @JsonProperty("isNotYetSubmitted")
    public void setIsNotYetSubmitted(Boolean isNotYetSubmitted) {
        this.isNotYetSubmitted = isNotYetSubmitted;
    }

    @JsonProperty("isValid")
    public Boolean getIsValid() {
        return isValid;
    }

    @JsonProperty("isValid")
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @JsonProperty("isFeePaid")
    public Boolean getIsFeePaid() {
        return isFeePaid;
    }

    @JsonProperty("isFeePaid")
    public void setIsFeePaid(Boolean isFeePaid) {
        this.isFeePaid = isFeePaid;
    }

    @JsonProperty("isIssueInProgress")
    public Boolean getIsIssueInProgress() {
        return isIssueInProgress;
    }

    @JsonProperty("isIssueInProgress")
    public void setIsIssueInProgress(Boolean isIssueInProgress) {
        this.isIssueInProgress = isIssueInProgress;
    }

    @JsonProperty("isAwaitingFee")
    public Boolean getIsAwaitingFee() {
        return isAwaitingFee;
    }

    @JsonProperty("isAwaitingFee")
    public void setIsAwaitingFee(Boolean isAwaitingFee) {
        this.isAwaitingFee = isAwaitingFee;
    }

    @JsonProperty("isUnderConsideration")
    public Boolean getIsUnderConsideration() {
        return isUnderConsideration;
    }

    @JsonProperty("isUnderConsideration")
    public void setIsUnderConsideration(Boolean isUnderConsideration) {
        this.isUnderConsideration = isUnderConsideration;
    }

    @JsonProperty("isReadyForNoOfPermits")
    public Boolean getIsReadyForNoOfPermits() {
        return isReadyForNoOfPermits;
    }

    @JsonProperty("isReadyForNoOfPermits")
    public void setIsReadyForNoOfPermits(Boolean isReadyForNoOfPermits) {
        this.isReadyForNoOfPermits = isReadyForNoOfPermits;
    }

    @JsonProperty("isCancelled")
    public Boolean getIsCancelled() {
        return isCancelled;
    }

    @JsonProperty("isCancelled")
    public void setIsCancelled(Boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @JsonProperty("isBilateral")
    public Boolean getIsBilateral() {
        return isBilateral;
    }

    @JsonProperty("isBilateral")
    public void setIsBilateral(Boolean isBilateral) {
        this.isBilateral = isBilateral;
    }

    @JsonProperty("isMultilateral")
    public Boolean getIsMultilateral() {
        return isMultilateral;
    }

    @JsonProperty("isMultilateral")
    public void setIsMultilateral(Boolean isMultilateral) {
        this.isMultilateral = isMultilateral;
    }

    @JsonProperty("canCheckAnswers")
    public Boolean getCanCheckAnswers() {
        return canCheckAnswers;
    }

    @JsonProperty("canCheckAnswers")
    public void setCanCheckAnswers(Boolean canCheckAnswers) {
        this.canCheckAnswers = canCheckAnswers;
    }

    @JsonProperty("canMakeDeclaration")
    public Boolean getCanMakeDeclaration() {
        return canMakeDeclaration;
    }

    @JsonProperty("canMakeDeclaration")
    public void setCanMakeDeclaration(Boolean canMakeDeclaration) {
        this.canMakeDeclaration = canMakeDeclaration;
    }

    @JsonProperty("permitsRequired")
    public Integer getPermitsRequired() {
        return permitsRequired;
    }

    @JsonProperty("permitsRequired")
    public void setPermitsRequired(Integer permitsRequired) {
        this.permitsRequired = permitsRequired;
    }

    @JsonProperty("canUpdateCountries")
    public Boolean getCanUpdateCountries() {
        return canUpdateCountries;
    }

    @JsonProperty("canUpdateCountries")
    public void setCanUpdateCountries(Boolean canUpdateCountries) {
        this.canUpdateCountries = canUpdateCountries;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cancellationDate", cancellationDate).append("checkedAnswers", checkedAnswers).append("createdOn", createdOn).append("dateReceived", dateReceived).append("declaration", declaration).append("id", id).append("irhpPermitType", irhpPermitType).append("lastModifiedOn", lastModifiedOn).append("licence", licence).append("applicationRef", applicationRef).append("canBeCancelled", canBeCancelled).append("canBeSubmitted", canBeSubmitted).append("canBeUpdated", canBeUpdated).append("hasOutstandingFees", hasOutstandingFees).append("outstandingFeeAmount", outstandingFeeAmount).append("sectionCompletion", sectionCompletion).append("hasCheckedAnswers", hasCheckedAnswers).append("hasMadeDeclaration", hasMadeDeclaration).append("isNotYetSubmitted", isNotYetSubmitted).append("isValid", isValid).append("isFeePaid", isFeePaid).append("isIssueInProgress", isIssueInProgress).append("isAwaitingFee", isAwaitingFee).append("isUnderConsideration", isUnderConsideration).append("isReadyForNoOfPermits", isReadyForNoOfPermits).append("isCancelled", isCancelled).append("isBilateral", isBilateral).append("isMultilateral", isMultilateral).append("canCheckAnswers", canCheckAnswers).append("canMakeDeclaration", canMakeDeclaration).append("permitsRequired", permitsRequired).append("canUpdateCountries", canUpdateCountries).toString();
    }

}
