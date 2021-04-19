package apiCalls.Utils.eupaBuilders.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "amount",
        "outstanding",
        "netAmount",
        "grossAmount"
})
public class OutstandingFeeModel {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("outstanding")
    private BigDecimal outstanding;
    @JsonProperty("netAmount")
    private BigDecimal netAmount;
    @JsonProperty("grossAmount")
    private BigDecimal grossAmount;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public OutstandingFeeModel withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("amount")
    public BigDecimal getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OutstandingFeeModel withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    @JsonProperty("outstanding")
    public BigDecimal getOutstanding() {
        return outstanding;
    }

    @JsonProperty("outstanding")
    public void setOutstanding(BigDecimal outstanding) {
        this.outstanding = outstanding;
    }

    public OutstandingFeeModel withOutstanding(BigDecimal outstanding) {
        this.outstanding = outstanding;
        return this;
    }

    @JsonProperty("netAmount")
    public BigDecimal getNetAmount() {
        return netAmount;
    }

    @JsonProperty("netAmount")
    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public OutstandingFeeModel withNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
        return this;
    }

    @JsonProperty("grossAmount")
    public BigDecimal getGrossAmount() {
        return grossAmount;
    }

    @JsonProperty("grossAmount")
    public void setGrossAmount(BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
    }

    public OutstandingFeeModel withGrossAmount(BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("amount", amount)
                .append("outstanding", outstanding)
                .append("netAmount", netAmount)
                .append("grossAmount", grossAmount)
                .toString();
    }

}