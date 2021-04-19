package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.external.enums.Country;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "version",
        "addressLine1",
        "addressLine2",
        "town",
        "postcode",
        "countryCode"})

public class AddressModel {

    @JsonProperty("version")
    private String version;
    @JsonProperty("addressLine1")
    private String addressLine1;
    @JsonProperty("addressLine2")
    private String addressLine2;
    @JsonProperty("town")
    private String town;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("countryCode")
    private Country countryCode;

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public AddressModel withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }


    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public AddressModel withAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public AddressModel withAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public AddressModel withTown(String town) {
        this.town = town;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public AddressModel withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public Country getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Country country) {
        this.countryCode = country;
    }

    public AddressModel withCountryCode(Country countryCode) {
        setCountryCode(countryCode);
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("version", getVersion())
                .append("addressLine1", getAddressLine1())
                .append("addressLine2", getAddressLine2())
                .append("town", getTown())
                .append("postcode", getPostcode())
                .append("countryCode", getCountryCode())
                .toString();
    }

}
