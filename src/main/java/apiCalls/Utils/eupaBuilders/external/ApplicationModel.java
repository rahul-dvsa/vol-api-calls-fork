package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.external.enums.LicenceType;
import apiCalls.Utils.eupaBuilders.external.enums.OperatorType;
import apiCalls.Utils.eupaBuilders.enums.Boolean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "operatorType",
        "licenceType",
        "niFlag",
        "organisation",
        "appliedVia"
})
public class ApplicationModel {

    @JsonProperty("operatorType")
    private OperatorType operatorType;
    @JsonProperty("licenceType")
    private LicenceType licenceType;
    @JsonProperty("niFlag")
    private Boolean niFlag;
    @JsonProperty("organisation")
    private String organisation;
    @JsonProperty("appliedVia")
    private String appliedVia;

    @JsonProperty("operatorType")
    public OperatorType getOperatorType() {
        return operatorType;
    }

    @JsonProperty("operatorType")
    public void setOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public ApplicationModel withOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
        return this;
    }

    @JsonProperty("licenceType")
    public LicenceType getLicenceType() {
        return licenceType;
    }

    @JsonProperty("licenceType")
    public void setLicenceType(LicenceType licenceType) {
        this.licenceType = licenceType;
    }

    public ApplicationModel withLicenceType(LicenceType licenceType) {
        setLicenceType(licenceType);
        return this;
    }

    @JsonProperty("niFlag")
    public Boolean getNiFlag() {
        return niFlag;
    }

    @JsonProperty("niFlag")
    public void setNiFlag(Boolean niFlag) {
        this.niFlag = niFlag;
    }

    public ApplicationModel withNiFlag(Boolean niFlag) {
        setNiFlag(niFlag);
        return this;
    }

    @JsonProperty("organisation")
    public String getOrganisation() {
        return organisation;
    }

    @JsonProperty("organisation")
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public ApplicationModel withOrganisation(String organisation) {
        this.organisation = organisation;
        return this;
    }

    @JsonProperty("appliedVia")
    public String getAppliedVia() {
        return appliedVia;
    }

    @JsonProperty("appliedVia")
    public void setAppliedVia(String appliedVia) {
        this.appliedVia = appliedVia;
    }

    public ApplicationModel withAppliedVia(String appliedVia) {
        this.appliedVia = appliedVia;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("operatorType", getOperatorType())
                .append("licenceType", getLicenceType())
                .append("niFlag", getNiFlag())
                .append("organisation", getOrganisation())
                .append("appliedVia", getAppliedVia())
                .toString();
    }

}
