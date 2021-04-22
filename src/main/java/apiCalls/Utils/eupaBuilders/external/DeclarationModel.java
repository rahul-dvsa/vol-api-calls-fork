package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.ModelUtil;
import apiCalls.Utils.eupaBuilders.external.enums.SignatureType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import apiCalls.Utils.eupaBuilders.enums.Boolean;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "version",
        "id",
        "declarationConfirmation",
        "interimRequested",
        "signatureType",
        "interimReason"
})
public class DeclarationModel {

    @JsonProperty("version")
    private String version;
    @JsonProperty("id")
    private String applicationNumber;
    @JsonProperty("declarationConfirmation")
    private Boolean declarationConfirmation;
    @JsonProperty("interimRequested")
    private Boolean interimRequested;
    @JsonProperty("interimReason")
    private String interimReason;
    @JsonProperty("signatureType")
    private SignatureType signatureType;


    @JsonProperty("version")
    public Integer getVersion() {
        return ModelUtil.defaultVersion(version);
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = String.valueOf(version);
    }

    public DeclarationModel withVersion(Integer version) {
        setVersion(version);
        return this;
    }

    @JsonProperty("id")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("id")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public DeclarationModel withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("signatureType")
    public SignatureType getSignatureType() {
        return signatureType;
    }

    @JsonProperty("signatureType")
    public void setSignatureType(SignatureType signatureType) {
        this.signatureType = signatureType;
    }

    public DeclarationModel withSignatureType(SignatureType signatureType) {
        setSignatureType(signatureType);
        return this;
    }

    @JsonProperty("interimRequested")
    public Boolean getInterimRequested() {
        return interimRequested;
    }

    @JsonProperty("interimRequested")
    public void setInterimRequested(Boolean interimRequested) {
        this.interimRequested = interimRequested;
    }

    public DeclarationModel withInterimRequested(Boolean interimRequested) {
        this.interimRequested = interimRequested;
        return this;
    }

    @JsonProperty("interimReason")
    public String getInterimReason() {
        return interimReason;
    }

    @JsonProperty("goodsApplicationInterimReason")
    public void setGoodsApplicationInterimReason(String interimReason) {
        this.interimReason = interimReason;
    }

    public DeclarationModel withInterimReason(String interimReason) {
        this.interimReason = interimReason;
        return this;
    }

    @JsonProperty("declarationConfirmation")
    public Boolean getDeclarationConfirmation() {
        return declarationConfirmation;
    }

    @JsonProperty("declarationConfirmation")
    public void setDeclarationConfirmation(Boolean declarationConfirmation) {
        this.declarationConfirmation = declarationConfirmation;
    }

    public DeclarationModel withDeclarationConfirmation(Boolean declarationConfirmation) {
        this.declarationConfirmation = declarationConfirmation;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("version", getVersion())
                .append("id", getApplicationNumber())
                .append("signatureType", getSignatureType())
                .append("interimRequested", getInterimRequested())
                .append("interimReason", getInterimReason())
                .append("declarationConfirmation", getDeclarationConfirmation())
                .toString();
    }
    
}
