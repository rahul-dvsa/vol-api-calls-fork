package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.ModelUtil;
import apiCalls.Utils.eupaBuilders.external.enums.BusinessType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "businessType",
        "version",
        "id",
        "applicationId"
})
public class BusinessTypeModel {

    @JsonProperty("businessType")
    private BusinessType businessType;
    @JsonProperty("version")
    private String version;
    @JsonProperty("id")
    private String organisationId;
    @JsonProperty("application")
    private String applicationId;

    @JsonProperty("businessType")
    public BusinessType getBusinessType() {
        return businessType;
    }

    @JsonProperty("businessType")
    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public BusinessTypeModel withBusinessType(BusinessType businessType) {
        this.businessType = businessType;
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

    public BusinessTypeModel withVersion(Integer version) {
        setVersion(version);
        return this;
    }

    @JsonProperty("id")
    public String getOrganisationId() {
        return organisationId;
    }

    @JsonProperty("id")
    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public BusinessTypeModel withOrganisationId(String organisationId) {
        this.organisationId = organisationId;
        return this;
    }

    @JsonProperty("application")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("application")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public BusinessTypeModel withApplication(String application) {
        this.applicationId = application;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("businessType", getBusinessType())
                .append("version", getVersion())
                .append("id", getOrganisationId())
                .append("application", getApplicationId())
                .toString();
    }
}