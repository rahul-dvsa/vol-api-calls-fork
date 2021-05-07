package apiCalls.Utils.eupaBuilders.organisation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "result",
        "multipleWithApplications",
        "singleWithApplication"
})
public class EligibleEcmtLicencesModel {

    @JsonProperty("result")
    private List<ResultModel> result = null;
    @JsonProperty("multipleWithApplications")
    private Boolean multipleWithApplications;
    @JsonProperty("singleWithApplication")
    private Boolean singleWithApplication;

    @JsonProperty("result")
    public List<ResultModel> getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(List<ResultModel> result) {
        this.result = result;
    }

    public EligibleEcmtLicencesModel withResult(List<ResultModel> result) {
        this.result = result;
        return this;
    }

    @JsonProperty("multipleWithApplications")
    public Boolean getMultipleWithApplications() {
        return multipleWithApplications;
    }

    @JsonProperty("multipleWithApplications")
    public void setMultipleWithApplications(Boolean multipleWithApplications) {
        this.multipleWithApplications = multipleWithApplications;
    }

    public EligibleEcmtLicencesModel withMultipleWithApplications(Boolean multipleWithApplications) {
        this.multipleWithApplications = multipleWithApplications;
        return this;
    }

    @JsonProperty("singleWithApplication")
    public Boolean getSingleWithApplication() {
        return singleWithApplication;
    }

    @JsonProperty("singleWithApplication")
    public void setSingleWithApplication(Boolean singleWithApplication) {
        this.singleWithApplication = singleWithApplication;
    }

    public EligibleEcmtLicencesModel withSingleWithApplication(Boolean singleWithApplication) {
        this.singleWithApplication = singleWithApplication;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("result", result)
                .append("multipleWithApplications", multipleWithApplications)
                .append("singleWithApplication", singleWithApplication)
                .toString();
    }

}