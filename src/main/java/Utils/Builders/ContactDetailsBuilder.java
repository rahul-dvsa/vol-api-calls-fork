package Utils.Builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "emailAddress",
        "person",
        "fao",
        "phone_primary",
        "address"
})
public class ContactDetailsBuilder {

    @JsonProperty("email")
    private String emailAddress;
    @JsonProperty("person")
    private PersonBuilder personBuilder;
    @JsonProperty("fao")
    private String fao;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ContactDetailsBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public PersonBuilder getPersonBuilder() {
        return personBuilder;
    }

    public void setPersonBuilder(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public ContactDetailsBuilder withPerson(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
        return this;
    }

    public String getFao() {
        return fao;
    }

    public void setFao(String fao) {
        this.fao = fao;
    }

    public ContactDetailsBuilder withFao(String fao) {
        this.fao = fao;
        return this;
    }

    public AddressBuilder getAddress() {
        return address;
    }

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
                .append("fao", getFao())
                .append("phone_primary", getPhoneNumber())
                .append("person", getPersonBuilder())
                .append("address", getAddress()).toString();
    }
}