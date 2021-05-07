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
        "version",
        "financialEvidenceUploaded"
})
public class FinancialEvidenceModel {

    @JsonProperty("id")
    private String applicationNumber;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("financialEvidenceUploaded")
    private Integer financialEvidenceUploaded;

    @JsonProperty("id")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("id")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public FinancialEvidenceModel withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    public FinancialEvidenceModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @JsonProperty("financialEvidenceUploaded")
    public Integer getFinancialEvidenceUploaded() {
        return financialEvidenceUploaded;
    }

    @JsonProperty("financialEvidenceUploaded")
    public void setFinancialEvidenceUploaded(Integer financialEvidenceUploaded) {
        this.financialEvidenceUploaded = financialEvidenceUploaded;
    }

    public FinancialEvidenceModel withFinancialEvidenceUploaded(Integer financialEvidenceUploaded) {
        this.financialEvidenceUploaded = financialEvidenceUploaded;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationNumber())
                .append("version", getVersion())
                .append("financialEvidenceUploaded", getFinancialEvidenceUploaded())
                .toString();
    }
    
}
