package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.ModelUtil;
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
        "bankrupt",
        "liquidation",
        "receivership",
        "administration",
        "disqualified",
        "insolvencyDetails",
        "insolvencyConfirmation"
})
public class FinancialHistoryModel {

    @JsonProperty("id")
    private String applicationNumber;
    @JsonProperty("version")
    private String version;
    @JsonProperty("bankrupt")
    private Boolean bankrupt;
    @JsonProperty("liquidation")
    private Boolean liquidation;
    @JsonProperty("receivership")
    private Boolean receivership;
    @JsonProperty("administration")
    private Boolean administration;
    @JsonProperty("disqualified")
    private Boolean disqualified;
    @JsonProperty("insolvencyDetails")
    private String insolvencyDetails;
    @JsonProperty("insolvencyConfirmation")
    private String insolvencyConfirmation;

    @JsonProperty("id")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("id")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public void setApplicationNumber(int applicationNumber) {
        setApplicationNumber(String.valueOf(applicationNumber));
    }

    public FinancialHistoryModel withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    public FinancialHistoryModel withApplicationNumber(int applicationNumber) {
        return withApplicationNumber(String.valueOf(applicationNumber));
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return ModelUtil.defaultVersion(version);
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = String.valueOf(version);
    }

    public FinancialHistoryModel withVersion(Integer version) {
        setVersion(version);
        return this;
    }

    @JsonProperty("bankrupt")
    public Boolean getBankrupt() {
        return bankrupt;
    }

    @JsonProperty("bankrupt")
    public void setBankrupt(Boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public FinancialHistoryModel withBankrupt(Boolean bankrupt) {
        this.bankrupt = bankrupt;
        return this;
    }

    @JsonProperty("liquidation")
    public Boolean getLiquidation() {
        return liquidation;
    }

    @JsonProperty("liquidation")
    public void setLiquidation(Boolean liquidation) {
        this.liquidation = liquidation;
    }

    public FinancialHistoryModel withLiquidation(Boolean liquidation) {
        this.liquidation = liquidation;
        return this;
    }

    @JsonProperty("receivership")
    public Boolean getReceivership() {
        return receivership;
    }

    @JsonProperty("receivership")
    public void setReceivership(Boolean receivership) {
        this.receivership = receivership;
    }

    public FinancialHistoryModel withReceivership(Boolean receivership) {
        this.receivership = receivership;
        return this;
    }

    @JsonProperty("administration")
    public Boolean getAdministration() {
        return administration;
    }

    @JsonProperty("administration")
    public void setAdministration(Boolean administration) {
        this.administration = administration;
    }

    public FinancialHistoryModel withAdministration(Boolean administration) {
        this.administration = administration;
        return this;
    }

    @JsonProperty("disqualified")
    public Boolean getDisqualified() {
        return disqualified;
    }

    @JsonProperty("disqualified")
    public void setDisqualified(Boolean disqualified) {
        this.disqualified = disqualified;
    }

    public FinancialHistoryModel withDisqualified(Boolean disqualified) {
        this.disqualified = disqualified;
        return this;
    }

    @JsonProperty("insolvencyDetails")
    public String getInsolvencyDetails() {
        return insolvencyDetails;
    }

    @JsonProperty("insolvencyDetails")
    public void setInsolvencyDetails(boolean insolvencyDetails) {
        this.insolvencyDetails = String.valueOf(insolvencyDetails);
    }

    public FinancialHistoryModel withInsolvencyDetails(boolean insolvencyDetails) {
        this.insolvencyDetails = String.valueOf(insolvencyDetails);
        return this;
    }

    @JsonProperty("insolvencyConfirmation")
    public String getInsolvencyConfirmation() {
        return insolvencyConfirmation;
    }

    @JsonProperty("insolvencyConfirmation")
    public void setInsolvencyConfirmation(boolean insolvencyConfirmation) {
        this.insolvencyConfirmation = String.valueOf(insolvencyConfirmation);
    }

    public FinancialHistoryModel withInsolvencyConfirmation(boolean insolvencyConfirmation) {
        setInsolvencyConfirmation(insolvencyConfirmation);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationNumber())
                .append("version", getVersion())
                .append("bankrupt", getBankrupt())
                .append("liquidation", getLiquidation())
                .append("receivership", getReceivership())
                .append("administration", getAdministration())
                .append("disqualified", getDisqualified())
                .append("insolvencyDetails", getInsolvencyDetails())
                .append("insolvencyConfirmation", getInsolvencyConfirmation())
                .toString();
    }
    
}
