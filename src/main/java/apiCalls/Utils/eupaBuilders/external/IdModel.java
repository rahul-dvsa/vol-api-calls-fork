package apiCalls.Utils.eupaBuilders.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdModel {

    @JsonProperty("address")
    private Integer addressId;
    @JsonProperty("licence")
    private Integer licenceId;
    @JsonProperty("application")
    private Integer applicationId;
    @JsonProperty("fee")
    private Integer feeId;
    @JsonProperty("transportManagerApplicationId")
    private Integer transportManagerApplicationId;
    @JsonProperty("transportManager")
    private Integer transportManagerId;
    @JsonProperty("person")
    private Integer personId;
    @JsonProperty("contactDetails")
    private Integer contactDetailsId;
    @JsonProperty("user")
    private Integer userId;
    @JsonProperty("queue")
    private Integer queueId;
    @JsonProperty("organisatonPerson")
    private Integer organisatonPersonId;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("assignedToUser")
    private Integer assignedToUser;
    @JsonProperty("task")
    private Integer task;
    @JsonProperty("document")
    private Integer document;
    @JsonProperty("publicationLink")
    private Integer publicationLink;

    @JsonProperty("address")
    public Integer getAddressId() {
        return addressId;
    }

    @JsonProperty("address")
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public IdModel withaddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    @JsonProperty("licence")
    public Integer getLicenceId() {
        return licenceId;
    }

    @JsonProperty("licence")
    public void setLicenceId(Integer licenceId) {
        this.licenceId = licenceId;
    }

    public IdModel withLicenceId(Integer licenceId) {
        this.licenceId = licenceId;
        return this;
    }

    @JsonProperty("application")
    public Integer getApplicationId() {
        return applicationId;
    }

    @JsonProperty("application")
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public IdModel withApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    @JsonProperty("fee")
    public Integer getFeeId() {
        return feeId;
    }

    @JsonProperty("fee")
    public void setFee(Integer feeId) {
        this.feeId = feeId;
    }

    public IdModel withFeeId(Integer feeId) {
        this.feeId = feeId;
        return this;
    }

    @JsonProperty("transportManagerApplicationId")
    public Integer getTransportManagerApplicationId() {
        return transportManagerApplicationId;
    }

    @JsonProperty("transportManagerApplicationId")
    public void setTransportManagerApplicationId(Integer transportManagerApplicationId) {
        this.transportManagerApplicationId = transportManagerApplicationId;
    }

    public IdModel withTransportManagerApplicationId(Integer transportManagerApplicationId) {
        this.transportManagerApplicationId = transportManagerApplicationId;
        return this;
    }

    @JsonProperty("transportManager")
    public Integer getTransportManagerId() {
        return transportManagerId;
    }

    @JsonProperty("transportManager")
    public void setTransportManagerId(Integer transportManagerId) {
        this.transportManagerId = transportManagerId;
    }

    public IdModel withTransportManagerId(Integer transportManagerId) {
        this.transportManagerId = transportManagerId;
        return this;
    }

    @JsonProperty("person")
    public Integer getPersonId() {
        return personId;
    }

    @JsonProperty("person")
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public IdModel withPersonId(Integer personId) {
        this.personId = personId;
        return this;
    }

    @JsonProperty("contactDetails")
    public Integer getContactDetailsId() {
        return contactDetailsId;
    }

    @JsonProperty("contactDetails")
    public void setContactDetailsId(Integer contactDetailsId) {
        this.contactDetailsId = contactDetailsId;
    }

    public IdModel withContactDetailsId(Integer contactDetailsId) {
        this.contactDetailsId = contactDetailsId;
        return this;
    }

    @JsonProperty("user")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public IdModel withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @JsonProperty("queue")
    public Integer getQueueId() {
        return queueId;
    }

    @JsonProperty("queue")
    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public IdModel withQueueId(Integer queueId) {
        this.queueId = queueId;
        return this;
    }

    @JsonProperty("organisatonPerson")
    public Integer getOrganisatonPerson() {
        return organisatonPersonId;
    }

    @JsonProperty("organisatonPerson")
    public void setOrganisatonPerson(Integer organisatonPersonId) {
        this.organisatonPersonId = organisatonPersonId;
    }

    public IdModel withOrganisatonPerson(Integer organisatonPersonId) {
        this.organisatonPersonId = organisatonPersonId;
        return this;
    }

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("assignedToUser")
    public Integer getAssignedToUser() {
        return assignedToUser;
    }

    @JsonProperty("task")
    public Integer getTask(){
        return task;
    }

    @JsonProperty("document")
    public Integer getDocument() {
        return document;
    }

    @JsonProperty("publicationLink")
    public Integer getPublicationLink() {
        return publicationLink;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("transportManagerApplicationId", transportManagerApplicationId)
                .append("transportManagerId", transportManagerId)
                .append("personId", personId)
                .append("contactDetailsId", contactDetailsId)
                .append("userId", userId)
                .append("queue", queueId)
                .toString();
    }

}