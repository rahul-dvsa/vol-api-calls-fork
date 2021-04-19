package apiCalls.Utils.eupaBuilders.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "application",
        "licence",
        "isExternal",
        "contactDetails"
})
public class SafetyInspectorModel {

    @JsonProperty("application")
    private String applicationNumber;
    @JsonProperty("licence")
    private String licenceNumber;
    @JsonProperty("isExternal")
    private String isExternal;
    @JsonProperty("contactDetails")
    private ContactDetailsModel contactDetails;

    @JsonProperty("application")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("application")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public SafetyInspectorModel withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("licence")
    public String getLicenceNumber() {
        return licenceNumber;
    }

    @JsonProperty("licence")
    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public SafetyInspectorModel withLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
        return this;
    }

    @JsonProperty("isExternal")
    public String getIsExternal() {
        return isExternal;
    }

    @JsonProperty("isExternal")
    public void setIsExternal(Boolean isExternal) {
        this.isExternal = isExternal.toString();
    }

    public SafetyInspectorModel withIsExternal(Boolean isExternal) {
        this.isExternal = isExternal.toString();
        return this;
    }

    @JsonProperty("contactDetails")
    public ContactDetailsModel getContactDetails() {
        return contactDetails;
    }

    @JsonProperty("contactDetails")
    public void setContactDetails(ContactDetailsModel contactDetails) {
        this.contactDetails = contactDetails;
    }

    public SafetyInspectorModel withContactDetails(ContactDetailsModel contactDetails) {
        this.contactDetails = contactDetails;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("application", getApplicationNumber())
                .append("licence", getLicenceNumber())
                .append("isExternal", getIsExternal())
                .append("contactDetails", getContactDetails())
                .toString();
    }
    
}
