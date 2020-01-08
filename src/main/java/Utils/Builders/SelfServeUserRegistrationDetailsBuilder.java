package Utils.Builders;

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
public class SelfServeUserRegistrationDetailsBuilder {

    @JsonProperty("loginId")
    private String loginId;
    @JsonProperty("contactDetails")
    private ContactDetailsBuilder contactDetailsBuilder;
    @JsonProperty("organisationName")
    private String organisationName;
    @JsonProperty("businessType")
    private String businessType;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public SelfServeUserRegistrationDetailsBuilder withLoginId(String loginId) {
        this.loginId = loginId;
        return this;
    }

    public ContactDetailsBuilder getContactDetailsBuilder() {
        return contactDetailsBuilder;
    }

    public void setContactDetailsBuilder(ContactDetailsBuilder contactDetailsBuilder) {
        this.contactDetailsBuilder = contactDetailsBuilder;
    }

    public SelfServeUserRegistrationDetailsBuilder withContactDetails(ContactDetailsBuilder contactDetailsBuilder) {
        this.contactDetailsBuilder = contactDetailsBuilder;
        return this;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public SelfServeUserRegistrationDetailsBuilder withOrganisationName(String organisationName) {
        this.organisationName = organisationName;
        return this;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public SelfServeUserRegistrationDetailsBuilder withBusinessType(String businessType) {
        this.businessType = businessType;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
        .append("loginId", getLoginId())
                .append("contactDetails", getContactDetailsBuilder())
                .append("organisationName", getOrganisationName())
                .append("businessType", getBusinessType()).toString();
    }
}