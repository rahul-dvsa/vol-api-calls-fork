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
        "emailAddress",
        "person",
        "fao",
        "phone_primary",
        "address"
})
public class ContactDetailsModel {

    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("person")
    private PersonModel PersonModel;
    @JsonProperty("fao")
    private String fao;
    @JsonProperty("phone_primary")
    private String phoneNumber;
    @JsonProperty("address")
    private AddressModel address;

    @JsonProperty("phone_primary")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ContactDetailsModel withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ContactDetailsModel withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @JsonProperty("person")
    public PersonModel getPersonModel() {
        return PersonModel;
    }

    @JsonProperty("person")
    public void setPersonModel(PersonModel PersonModel) {
        this.PersonModel = PersonModel;
    }

    public ContactDetailsModel withPerson(PersonModel PersonModel) {
        this.PersonModel = PersonModel;
        return this;
    }

    @JsonProperty("fao")
    public String getFao() {
        return fao;
    }

    @JsonProperty("fao")
    public void setFao(String fao) {
        this.fao = fao;
    }

    public ContactDetailsModel withFao(String fao) {
        this.fao = fao;
        return this;
    }

    @JsonProperty("address")
    public AddressModel getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public ContactDetailsModel withAddress(AddressModel address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("emailAddress", getEmailAddress())
                .append("fao", getFao())
                .append("phone_primary", getPhoneNumber())
                .append("person", getPersonModel())
                .append("address", getAddress())
                .toString();
    }

}
