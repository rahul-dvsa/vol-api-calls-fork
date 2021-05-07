package apiCalls.Utils.eupaBuilders.internal.irhp.permit.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "countryDesc",
        "id",
        "isEcmtState",
        "isEeaState",
        "isMemberState",
        "version"
})
public class CountryModel {

    @JsonProperty("countryDesc")
    private String countryDesc;
    @JsonProperty("id")
    private String id;
    @JsonProperty("isEcmtState")
    private Boolean isEcmtState;
    @JsonProperty("isEeaState")
    private Boolean isEeaState;
    @JsonProperty("isMemberState")
    private String isMemberState;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("countryDesc")
    public String getCountryDesc() {
        return countryDesc;
    }

    @JsonProperty("countryDesc")
    public CountryModel setCountryDesc(String countryDesc) {
        this.countryDesc = countryDesc;
        return this;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public CountryModel setId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("isEcmtState")
    public Boolean getIsEcmtState() {
        return isEcmtState;
    }

    @JsonProperty("isEcmtState")
    public CountryModel setIsEcmtState(Boolean isEcmtState) {
        this.isEcmtState = isEcmtState;
        return this;
    }

    @JsonProperty("isEeaState")
    public Boolean getIsEeaState() {
        return isEeaState;
    }

    @JsonProperty("isEeaState")
    public CountryModel setIsEeaState(Boolean isEeaState) {
        this.isEeaState = isEeaState;
        return this;
    }

    @JsonProperty("isMemberState")
    public String getIsMemberState() {
        return isMemberState;
    }

    @JsonProperty("isMemberState")
    public CountryModel setIsMemberState(String isMemberState) {
        this.isMemberState = isMemberState;
        return this;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public CountryModel setVersion(Integer version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("countryDesc", countryDesc)
                .append("id", id)
                .append("isEcmtState", isEcmtState)
                .append("isEeaState", isEeaState)
                .append("isMemberState", isMemberState)
                .append("version", version)
                .toString();
    }

}