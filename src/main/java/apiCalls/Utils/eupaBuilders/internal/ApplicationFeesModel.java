package apiCalls.Utils.eupaBuilders.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "outstandingFees"
})
public class ApplicationFeesModel {

    @JsonProperty("outstandingFees")
    private List<OutstandingFeeModel> outstandingFees = null;

    @JsonProperty("outstandingFees")
    public List<OutstandingFeeModel> getOutstandingFees() {
        return outstandingFees;
    }

    @JsonProperty("outstandingFees")
    public void setOutstandingFees(List<OutstandingFeeModel> outstandingFees) {
        this.outstandingFees = outstandingFees;
    }

    public ApplicationFeesModel withOutstandingFees(List<OutstandingFeeModel> outstandingFees) {
        this.outstandingFees = outstandingFees;
        return this;
    }

    public BigDecimal getTotalOutstanding(){
        return outstandingFees.stream()
                .map(OutstandingFeeModel::getOutstanding)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalGrossAmount(){
        return outstandingFees.stream()
                .map(OutstandingFeeModel::getGrossAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Integer> getOutstandingFeeIds(){
        return outstandingFees.stream()
                .map(OutstandingFeeModel::getId)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("outstandingFees", outstandingFees)
                .toString();
    }

}