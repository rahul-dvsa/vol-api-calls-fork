package apiCalls.Utils.builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.platform.commons.util.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApplicationBuilder {

    @JsonProperty("operatorType")
    private String operatorType;
    @JsonProperty("licenceType")
    private String licenceType;
    @JsonProperty("niFlag")
    private String niFlag;
    @JsonProperty("organisation")
    private String organisation;
    @JsonProperty("appliedVia")
    private String appliedVia;

    @JsonProperty("operatorType")
    public String getOperatorType() {
        return operatorType;
    }

    @JsonProperty("operatorType")
    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public ApplicationBuilder withOperatorType(String operatorType) {
        this.operatorType = operatorType;
        return this;
    }

    @JsonProperty("licenceType")
    public String getLicenceType() {
        return licenceType;
    }

    @JsonProperty("licenceType")
    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public ApplicationBuilder withLicenceType(String licenceType) {
        this.licenceType = licenceType;
        return this;
    }

    @JsonProperty("niFlag")
    public String getNiFlag() {
        return niFlag;
    }

    @JsonProperty("niFlag")
    public void setNiFlag(String niFlag) {
        this.niFlag = niFlag;
    }

    public ApplicationBuilder withNiFlag(String niFlag) {
        this.niFlag = niFlag;
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

    public ApplicationBuilder withOrganisation(String organisation) {
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

    public ApplicationBuilder withAppliedVia(String appliedVia) {
        this.appliedVia = appliedVia;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
                .append("operatorType", getOperatorType())
                .append("licenceType", getLicenceType())
                .append("niFlag", getNiFlag())
                .append("organisation", getOrganisation())
                .append("appliedVia", getAppliedVia()).toString();
    }
}