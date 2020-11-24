package apiCalls.Utils.builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class CaseConvictionsPenaltiesBuilder {

    @JsonProperty("id")
    private String id;
    @JsonProperty("prevConviction")
    private String prevConviction;
    @JsonProperty("convictionsConfirmation")
    private String convictionsConfirmation;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public CaseConvictionsPenaltiesBuilder withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("prevConviction")
    public String getPrevConviction() {
        return prevConviction;
    }

    @JsonProperty("prevConviction")
    public void setPrevConviction(String prevConviction) {
        this.prevConviction = prevConviction;
    }

    public CaseConvictionsPenaltiesBuilder withPrevConviction(String prevConviction) {
        this.prevConviction = prevConviction;
        return this;
    }

    @JsonProperty("convictionsConfirmation")
    public String getConvictionsConfirmation() {
        return convictionsConfirmation;
    }

    @JsonProperty("convictionsConfirmation")
    public void setConvictionsConfirmation(String convictionsConfirmation) {
        this.convictionsConfirmation = convictionsConfirmation;
    }

    public CaseConvictionsPenaltiesBuilder withConvictionsConfirmation(String convictionsConfirmation) {
        this.convictionsConfirmation = convictionsConfirmation;
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

    public CaseConvictionsPenaltiesBuilder withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
                .append("id", getId())
                .append("prevConviction", getPrevConviction())
                .append("convictionsConfirmation", getConvictionsConfirmation())
                .append("version", getVersion()).toString();
    }
}