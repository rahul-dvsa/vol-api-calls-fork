package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.external.enums.BusinessType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "loginId",
        "contactDetails",
        "organisationName",
        "businessType"
})
public class UserRegistrationDetailsModel {

    @JsonProperty("loginId")
    private String username;
    @JsonProperty("contactDetails")
    private ContactDetailsModel ContactDetailsModel;
    @JsonProperty("organisationName")
    private String organisationName;
    @JsonProperty("businessType")
    private BusinessType businessType;

    @JsonProperty("loginId")
    public String getUsername() {
        return username;
    }

    @JsonProperty("loginId")
    public void setUsername(String username) {
        this.username = username;
    }

    public UserRegistrationDetailsModel withUsername(String username) {
        this.username = username;
        return this;
    }

    @JsonProperty("contactDetails")
    public ContactDetailsModel getContactDetailsModel() {
        return ContactDetailsModel;
    }

    @JsonProperty("contactDetails")
    public void setContactDetailsModel(ContactDetailsModel ContactDetailsModel) {
        this.ContactDetailsModel = ContactDetailsModel;
    }

    public UserRegistrationDetailsModel withContactDetails(ContactDetailsModel ContactDetailsModel) {
        this.ContactDetailsModel = ContactDetailsModel;
        return this;
    }

    @JsonProperty("organisationName")
    public String getOrganisationName() {
        return organisationName;
    }

    @JsonProperty("organisationName")
    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public UserRegistrationDetailsModel withOrganisationName(String organisationName) {
        this.organisationName = organisationName;
        return this;
    }

    @JsonProperty("businessType")
    public BusinessType getBusinessType() {
        return businessType;
    }

    @JsonProperty("businessType")
    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public UserRegistrationDetailsModel withBusinessType(BusinessType businessType) {
        this.businessType = businessType;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("loginId", getUsername())
                .append("contactDetails", getContactDetailsModel())
                .append("organisationName", getOrganisationName())
                .append("businessType", getBusinessType())
                .toString();
    }
    
}
