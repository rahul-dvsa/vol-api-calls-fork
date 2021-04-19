package apiCalls.Utils.eupaBuilders.internal;

import apiCalls.Utils.eupaBuilders.internal.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "feeIds",
        "organisationId",
        "applicationId",
        "paymentMethod",
        "received",
        "receiptDate",
        "payer",
        "slipNo",
        "maxAmountForValidator"
})
public class FeesModel {

    @JsonProperty("feeIds")
    private List<Integer> feeIds = null;
    @JsonProperty("organisationId")
    private String organisationId;
    @JsonProperty("applicationId")
    private String applicationId;
    @JsonProperty("paymentMethod")
    private PaymentMethod paymentMethod;
    @JsonProperty("received")
    private BigDecimal received;
    @JsonProperty("receiptDate")
    private String receiptDate;
    @JsonProperty("payer")
    private String payer;
    @JsonProperty("slipNo")
    private String slipNo;

    @JsonProperty("feeIds")
    public List<Integer> getFeeIds() {
        return feeIds;
    }

    @JsonProperty("feeIds")
    public void setFeeIds(List<Integer> feeIds) {
        this.feeIds = feeIds;
    }

    public FeesModel withFeeIds(List<Integer> feeIds) {
        this.feeIds = feeIds;
        return this;
    }

    @JsonProperty("organisationId")
    public String getOrganisationId() {
        return organisationId;
    }

    @JsonProperty("organisationId")
    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public FeesModel withOrganisationId(String organisationId) {
        this.organisationId = organisationId;
        return this;
    }

    @JsonProperty("applicationId")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("applicationId")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public FeesModel withApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    @JsonProperty("paymentMethod")
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("paymentMethod")
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public FeesModel withPaymentMethod(PaymentMethod paymentMethod) {
        setPaymentMethod(paymentMethod);
        return this;
    }

    @JsonProperty("received")
    public BigDecimal getReceived() {
        return received;
    }

    @JsonProperty("received")
    public void setReceived(BigDecimal received) {
        this.received = received;
    }

    public FeesModel withReceived(BigDecimal received) {
        setReceived(received);
        return this;
    }

    @JsonProperty("receiptDate")
    public String getReceiptDate() {
        return receiptDate;
    }

    @JsonProperty("receiptDate")
    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public FeesModel withReceiptDate(String receiptDate) {
        setReceiptDate(receiptDate);
        return this;
    }

    @JsonProperty("payer")
    public String getPayer() {
        return payer;
    }

    @JsonProperty("payer")
    public void setPayer(String payer) {
        this.payer = payer;
    }

    public FeesModel withPayer(String payer) {
        this.payer = payer;
        return this;
    }

    @JsonProperty("slipNo")
    public String getSlipNo() {
        return slipNo;
    }

    @JsonProperty("slipNo")
    public void setSlipNo(String slipNo) {
        this.slipNo = slipNo;
    }

    public FeesModel withSlipNo(String slipNo) {
        this.slipNo = slipNo;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("feeIds", getFeeIds())
                .append("organisationId", getOrganisationId())
                .append("applicationId", getApplicationId())
                .append("paymentMethod:", getPaymentMethod())
                .append("received", getReceived())
                .append("receiptDate", getReceiptDate())
                .append("payer", getPayer())
                .append("slipNo", getSlipNo())
                .toString();
    }
    
}
