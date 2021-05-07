package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import apiCalls.Utils.eupaBuilders.enums.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "prevHasLicence",
        "prevHadLicence",
        "prevBeenRefused",
        "prevBeenRevoked",
        "prevBeenAtPi",
        "prevBeenDisqualifiedTc",
        "prevPurchasedAssets",
        "version"
})
public class LicenceHistoryModel extends BaseModel {

    @JsonProperty("id")
    private String applicationNumber;
    @JsonProperty("prevHasLicence")
    private String prevHasLicence;
    @JsonProperty("prevHadLicence")
    private String prevHadLicence;
    @JsonProperty("prevBeenRefused")
    private String prevBeenRefused;
    @JsonProperty("prevBeenRevoked")
    private String prevBeenRevoked;
    @JsonProperty("prevBeenAtPi")
    private String prevBeenAtPi;
    @JsonProperty("prevBeenDisqualifiedTc")
    private String prevBeenDisqualifiedTc;
    @JsonProperty("prevPurchasedAssets")
    private String prevPurchasedAssets;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("id")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("id")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public LicenceHistoryModel withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("prevHasLicence")
    public String getPrevHasLicence() {
        return prevHasLicence;
    }

    @JsonProperty("prevHasLicence")
    public void setPrevHasLicence(Boolean prevHasLicence) {
        this.prevHasLicence = prevHasLicence.toString();
    }

    public LicenceHistoryModel withPrevHasLicence(Boolean prevHasLicence) {
        this.prevHasLicence = prevHasLicence.toString();
        return this;
    }

    @JsonProperty("prevHadLicence")
    public String getPrevHadLicence() {
        return prevHadLicence;
    }

    @JsonProperty("prevHadLicence")
    public void setPrevHadLicence(Boolean prevHadLicence) {
        this.prevHadLicence = prevHadLicence.toString();
    }

    public LicenceHistoryModel withPrevHadLicence(Boolean prevHadLicence) {
        this.prevHadLicence = prevHadLicence.toString();
        return this;
    }

    @JsonProperty("prevBeenRefused")
    public String getPrevBeenRefused() {
        return prevBeenRefused;
    }

    @JsonProperty("prevBeenRefused")
    public void setPrevBeenRefused(Boolean prevBeenRefused) {
        this.prevBeenRefused = prevBeenRefused.toString();
    }

    public LicenceHistoryModel withPrevBeenRefused(Boolean prevBeenRefused) {
        this.prevBeenRefused = prevBeenRefused.toString();
        return this;
    }

    @JsonProperty("prevBeenRevoked")
    public String getPrevBeenRevoked() {
        return prevBeenRevoked;
    }

    @JsonProperty("prevBeenRevoked")
    public void setPrevBeenRevoked(Boolean prevBeenRevoked) {
        this.prevBeenRevoked = prevBeenRevoked.toString();
    }

    public LicenceHistoryModel withPrevBeenRevoked(Boolean prevBeenRevoked) {
        this.prevBeenRevoked = prevBeenRevoked.toString();
        return this;
    }

    @JsonProperty("prevBeenAtPi")
    public String getPrevBeenAtPi() {
        return prevBeenAtPi;
    }

    @JsonProperty("prevBeenAtPi")
    public void setPrevBeenAtPi(Boolean prevBeenAtPi) {
        this.prevBeenAtPi = prevBeenAtPi.toString();
    }

    public LicenceHistoryModel withPrevBeenAtPi(Boolean prevBeenAtPi) {
        this.prevBeenAtPi = prevBeenAtPi.toString();
        return this;
    }

    @JsonProperty("prevBeenDisqualifiedTc")
    public String getPrevBeenDisqualifiedTc() {
        return prevBeenDisqualifiedTc;
    }

    @JsonProperty("prevBeenDisqualifiedTc")
    public void setPrevBeenDisqualifiedTc(Boolean prevBeenDisqualifiedTc) {
        this.prevBeenDisqualifiedTc = prevBeenDisqualifiedTc.toString();
    }

    public LicenceHistoryModel withPrevBeenDisqualifiedTc(Boolean prevBeenDisqualifiedTc) {
        this.prevBeenDisqualifiedTc = prevBeenDisqualifiedTc.toString();
        return this;
    }

    @JsonProperty("prevPurchasedAssets")
    public String getPrevPurchasedAssets() {
        return prevPurchasedAssets;
    }

    @JsonProperty("prevPurchasedAssets")
    public void setPrevPurchasedAssets(Boolean prevPurchasedAssets) {
        this.prevPurchasedAssets = prevPurchasedAssets.toString();
    }

    public LicenceHistoryModel withPrevPurchasedAssets(Boolean prevPurchasedAssets) {
        this.prevPurchasedAssets = prevPurchasedAssets.toString();
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

    public LicenceHistoryModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationNumber())
                .append("prevHasLicence", getPrevHasLicence())
                .append("prevHadLicence", getPrevHadLicence())
                .append("prevBeenRefused", getPrevBeenRefused())
                .append("prevBeenRevoked", getPrevBeenRevoked())
                .append("prevBeenAtPi", getPrevBeenAtPi())
                .append("prevBeenDisqualifiedTc", getPrevBeenDisqualifiedTc())
                .append("prevPurchasedAssets", getPrevPurchasedAssets())
                .append("version", getVersion())
                .toString();
    }
    
}
