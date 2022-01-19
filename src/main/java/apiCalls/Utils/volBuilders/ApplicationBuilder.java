package apiCalls.Utils.volBuilders;

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
    @JsonProperty("vehicleType")
    private String vehicleType;
    @JsonProperty("lgvDeclarationConfirmation")
    private String lgvDeclarationConfirmation;
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

    @JsonProperty("vehicleType")
    public String getVehicleType() {
        return vehicleType;
    }

    @JsonProperty("vehicleType")
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ApplicationBuilder withVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    @JsonProperty("lgvDeclarationConfirmation")
    public String getLgvDeclarationConfirmation() {
        return lgvDeclarationConfirmation;
    }

    @JsonProperty("lgvDeclarationConfirmation")
    public void setLgvDeclarationConfirmation(String lgvDeclarationConfirmation) {
        this.lgvDeclarationConfirmation = lgvDeclarationConfirmation;
    }

    public ApplicationBuilder withLgvDeclarationConfirmation(String lgvDeclarationConfirmation) {
        this.lgvDeclarationConfirmation = lgvDeclarationConfirmation;
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
                .append("vehicleType", getVehicleType())
                .append("lgvDeclarationConfirmation", getLgvDeclarationConfirmation())
                .append("niFlag", getNiFlag())
                .append("organisation", getOrganisation())
                .append("appliedVia", getAppliedVia()).toString();
    }
}