package apiCalls.Utils.volBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class FinancialEvidenceBuilder {

    @JsonProperty("id")
    private String id;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("financialEvidenceUploaded")
    private Integer financialEvidenceUploaded;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public FinancialEvidenceBuilder withId(String id) {
        this.id = id;
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

    public FinancialEvidenceBuilder withVersion(Integer version) {
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

    public FinancialEvidenceBuilder withFinancialEvidenceUploaded(Integer financialEvidenceUploaded) {
        this.financialEvidenceUploaded = financialEvidenceUploaded;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("version", getVersion())
                .append("financialEvidenceUploaded", getFinancialEvidenceUploaded()).toString();
    }
}