package apiCalls.Utils.volBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class FeesBuilder {

    @JsonProperty("feeIds")
    private List<Integer> feeIds = null;
    @JsonProperty("organisationId")
    private String organisationId;
    @JsonProperty("applicationId")
    private String applicationId;
    @JsonProperty("cpmsRedirectUrl")
    private Object cpmsRedirectUrl;
    @JsonProperty("paymentMethod")
    private String paymentMethod;
    @JsonProperty("received")
    private Double received = null;
    @JsonProperty("receiptDate")
    private String receiptDate;
    @JsonProperty("payer")
    private String payer;
    @JsonProperty("slipNo")
    private String slipNo;
    @JsonProperty("maxAmountForValidator")
    private Integer maxAmountForValidator;

    @JsonProperty("feeIds")
    public List<Integer> getFeeIds() {
        return feeIds;
    }

    @JsonProperty("feeIds")
    public void setFeeIds(List<Integer> feeIds) {
        this.feeIds = feeIds;
    }

    public FeesBuilder withFeeIds(List<Integer> feeIds) {
        this.feeIds = feeIds;
        return this;
    }

    @JsonProperty("received")
    public Double getReceived() {
        return received;
    }

    @JsonProperty("received")
    public void setReceived(Double received) {
        this.received = received;
    }

    public FeesBuilder withReceived(Double received) {
        this.received = received;
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

    public FeesBuilder withOrganisationId(String organisationId) {
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

    public FeesBuilder withApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    @JsonProperty("cpmsRedirectUrl")
    public Object getCpmsRedirectUrl() {
        return cpmsRedirectUrl;
    }

    @JsonProperty("cpmsRedirectUrl")
    public void setCpmsRedirectUrl(Object cpmsRedirectUrl) {
        this.cpmsRedirectUrl = cpmsRedirectUrl;
    }

    public FeesBuilder withCpmsRedirectUrl(Object cpmsRedirectUrl) {
        this.cpmsRedirectUrl = cpmsRedirectUrl;
        return this;
    }

    @JsonProperty("paymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("paymentMethod")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public FeesBuilder withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public FeesBuilder withReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
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

    public FeesBuilder withPayer(String payer) {
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

    public FeesBuilder withSlipNo(String slipNo) {
        this.slipNo = slipNo;
        return this;
    }

    @JsonProperty("maxAmountForValidator")
    public Integer getMaxAmountForValidator() {
        return maxAmountForValidator;
    }

    @JsonProperty("maxAmountForValidator")
    public void setMaxAmountForValidator(Integer maxAmountForValidator) {
        this.maxAmountForValidator = maxAmountForValidator;
    }

    public FeesBuilder withMaxAmountForValidator(Integer maxAmountForValidator) {
        this.maxAmountForValidator = maxAmountForValidator;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
                .append("feeIds", getFeeIds())
                .append("organisationId", getOrganisationId())
                .append("applicationId", getApplicationId())
                .append("cpmsRedirectUrl", getCpmsRedirectUrl())
                .append("paymentMethod", getPaymentMethod())
                .append("received", getReceived())
                .append("receiptDate", getReceiptDate())
                .append("payer", getPayer())
                .append("slipNo", getSlipNo())
                .append("maxAmountForValidator", getMaxAmountForValidator()).toString();
    }
}