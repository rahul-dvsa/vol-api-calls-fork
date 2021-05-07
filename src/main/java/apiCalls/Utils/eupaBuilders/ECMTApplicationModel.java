package apiCalls.Utils.eupaBuilders;

import apiCalls.Utils.eupaBuilders.organisation.ResultModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "count",
        "results"
})
public class ECMTApplicationModel {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("results")
    private List<ResultModel> results = null;

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    public ECMTApplicationModel withCount(Integer count) {
        this.count = count;
        return this;
    }

    @JsonProperty("results")
    public List<ResultModel> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<ResultModel> results) {
        this.results = results;
    }

    public ECMTApplicationModel withResults(List<ResultModel> results) {
        this.results = results;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("count", count)
                .append("results", results)
                .toString();
    }

}
