package apiCalls.Utils.builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ContactDetailsBuilder {

    @JsonProperty("email")
    private String emailAddress;
    @JsonProperty("person")
    private PersonBuilder personBuilder;
    @JsonProperty("fao")
    private String fullName;
    @JsonProperty("phone_primary")
    private String phoneNumber;
    @JsonProperty("address")
    private AddressBuilder address;

    @JsonProperty("phone_primary")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ContactDetailsBuilder withPhoneNumber(String phoneNumber) {
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

    public ContactDetailsBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @JsonProperty("person")
    public PersonBuilder getPersonBuilder() {
        return personBuilder;
    }

    @JsonProperty("person")
    public void setPersonBuilder(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public ContactDetailsBuilder withPerson(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
        return this;
    }

    @JsonProperty("fao")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fao")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ContactDetailsBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @JsonProperty("address")
    public AddressBuilder getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(AddressBuilder address) {
        this.address = address;
    }

    public ContactDetailsBuilder withAddress(AddressBuilder address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
        .append("emailAddress", getEmailAddress())
                .append("fao", getFullName())
                .append("phone_primary", getPhoneNumber())
                .append("person", getPersonBuilder())
                .append("address", getAddress()).toString();
    }
}