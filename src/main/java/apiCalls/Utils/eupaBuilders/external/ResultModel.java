package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.EligibleEcmtLicencesResultModel;
import apiCalls.Utils.eupaBuilders.enums.TrafficArea;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "result",
})
public class ResultModel {

    @JsonProperty("result")
    private List<EligibleEcmtLicencesResultModel> results;


    @JsonProperty("result")
    public List<EligibleEcmtLicencesResultModel> getResults(){
        return results;
    }

    @JsonProperty("result")
    public void setResults(List<EligibleEcmtLicencesResultModel> results){
        this.results = results;
    }

    public ResultModel withResults(List<EligibleEcmtLicencesResultModel> results){
        setResults(results);
        return this;
    }

    public EligibleEcmtLicencesResultModel eligibleEcmtLicence(String licenceNumber){
        return results.stream()
                .filter((licence) -> StringUtils.deleteWhitespace(licence.getLicNo().toLowerCase())
                        .equals(StringUtils.deleteWhitespace(licenceNumber.toLowerCase())))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<EligibleEcmtLicencesResultModel> licencesWithTrafficArea(TrafficArea trafficArea) {
        return results.stream().filter(
                (licence) -> TrafficArea.getEnum(licence.getTrafficArea()) == trafficArea
        ).collect(Collectors.toList());
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("result", results)
                .toString();
    }

}
