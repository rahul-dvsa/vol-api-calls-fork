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
        "id",
        "consultant",
        "contact",
        "correspondenceAddress"
})
public class ApplicationContactDetailsModel {

    @JsonProperty("id")
    private String applicationNumber;
    @JsonProperty("consultant")
    private String consultant;
    @JsonProperty("contact")
    private ContactDetailsModel contact;
    @JsonProperty("correspondenceAddress")
    private AddressModel correspondenceAddress;
    @JsonProperty("establishmentAddress")
    private AddressModel establishmentAddress;

    @JsonProperty("id")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("id")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public ApplicationContactDetailsModel withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("consultant")
    public String getConsultant() {
        return consultant;
    }

    @JsonProperty("consultant")
    public void setConsultant(String consultant) {
        this.consultant = consultant;
    }

    public ApplicationContactDetailsModel withConsultant(String consultant) {
        this.consultant = consultant;
        return this;
    }


    @JsonProperty("contact")
    public ContactDetailsModel getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(ContactDetailsModel contact) {
        this.contact = contact;
    }

    public ApplicationContactDetailsModel withContact(ContactDetailsModel contact) {
        this.contact = contact;
        return this;
    }

    @JsonProperty("correspondenceAddress")
    public AddressModel getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    @JsonProperty("correspondenceAddress")
    public void setCorrespondenceAddress(AddressModel correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public ApplicationContactDetailsModel withCorrespondenceAddress(AddressModel correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
        return this;
    }

    @JsonProperty("establishmentAddress")
    public AddressModel getEstablishmentAddress() {
        return establishmentAddress;
    }

    @JsonProperty("establishmentAddress")
    public void setEstablishmentAddress(AddressModel establishmentAddress) {
        this.establishmentAddress = establishmentAddress;
    }

    public ApplicationContactDetailsModel withEstablishmentAddress(AddressModel establishmentAddress) {
        this.establishmentAddress = establishmentAddress;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationNumber())
                .append("contact", getContact())
                .append("consultant", getConsultant())
                .append("correspondenceAddress", getCorrespondenceAddress())
                .append("establishmentAddress", getEstablishmentAddress())
                .toString();
    }
}
