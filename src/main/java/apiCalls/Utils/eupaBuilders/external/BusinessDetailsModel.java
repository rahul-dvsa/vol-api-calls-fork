package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.ModelUtil;
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
        "natureOfBusiness",
        "version",
        "name",
        "licence",
        "companyOrLlpNo",
        "registeredAddress"
})
public class BusinessDetailsModel {

    @JsonProperty("id")
    private String applicationId;
    @JsonProperty("natureOfBusiness")
    private String natureOfBusiness;
    @JsonProperty("version")
    private String version;
    @JsonProperty("name")
    private String name;
    @JsonProperty("licence")
    private String licenceId;
    @JsonProperty("companyOrLlpNo")
    private String companyOrLlpNo;
    @JsonProperty("registeredAddress")
    private AddressModel address;

    @JsonProperty("id")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("id")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public BusinessDetailsModel withApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    @JsonProperty("natureOfBusiness")
    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    @JsonProperty("natureOfBusiness")
    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public BusinessDetailsModel withNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
        return this;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return ModelUtil.defaultVersion(version);
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = String.valueOf(version);
    }

    public BusinessDetailsModel withVersion(Integer version) {
        setVersion(version);
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public BusinessDetailsModel withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("licence")
    public String getLicenceId() {
        return licenceId;
    }

    @JsonProperty("licence")
    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }

    public BusinessDetailsModel withLicence(String licence) {
        this.licenceId = licence;
        return this;
    }

    @JsonProperty("companyOrLlpNo")
    public String getCompanyOrLlpNo() {
        return companyOrLlpNo;
    }

    @JsonProperty("companyOrLlpNo")
    public void setCompanyOrLlpNo(String companyOrLlpNo) {
        this.companyOrLlpNo = companyOrLlpNo;
    }

    public BusinessDetailsModel withCompanyNumber(String companyNumber) {
        this.companyOrLlpNo = companyNumber;
        return this;
    }

    @JsonProperty("registeredAddress")
    public AddressModel getAddress() {
        return address;
    }

    @JsonProperty("registeredAddress")
    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public BusinessDetailsModel withAddress(AddressModel address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationId())
                .append("natureOfBusiness", getNatureOfBusiness())
                .append("version", getVersion())
                .append("name", getName())
                .append("licenceId", getLicenceId())
                .append("companyOrLlpNo", getCompanyOrLlpNo())
                .append("registeredAddress", getAddress())
                .toString();
    }

}
