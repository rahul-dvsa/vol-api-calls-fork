package apiCalls.Utils.eupaBuilders.internal;

import apiCalls.enums.TrafficArea;
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
        "leadTcArea",
        "receivedDate",
        "targetCompletionDate",
        "overrideOppositionDate",
        "TrackingModel"
})
public class OverviewModel {

    @JsonProperty("id")
    private String applicationId;
    @JsonProperty("version")
    private Integer version = 1;
    @JsonProperty("leadTcArea")
    private TrafficArea leadTcArea;
    @JsonProperty("receivedDate")
    private String receivedDate;
    @JsonProperty("targetCompletionDate")
    private String targetCompletionDate;
    @JsonProperty("overrideOppositionDate")
    private Boolean overrideOppositionDate = Boolean.TRUE;
    @JsonProperty("tracking")
    private TrackingModel TrackingModel;

    @JsonProperty("id")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("id")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public OverviewModel withApplicationId(String applicationId) {
        this.applicationId = applicationId;
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

    public OverviewModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @JsonProperty("leadTcArea")
    public TrafficArea getLeadTcArea() {
        return leadTcArea;
    }

    @JsonProperty("leadTcArea")
    public void setLeadTcArea(TrafficArea leadTcArea) {
        this.leadTcArea = leadTcArea;
    }

    public OverviewModel withLeadTcArea(TrafficArea leadTcArea) {
        this.leadTcArea = leadTcArea;
        return this;
    }

    @JsonProperty("receivedDate")
    public String getReceivedDate() {
        return receivedDate;
    }

    @JsonProperty("receivedDate")
    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public OverviewModel withReceivedDate(String receivedDate) {
        setReceivedDate(receivedDate);
        return this;
    }

    @JsonProperty("targetCompletionDate")
    public String getTargetCompletionDate() {
        return targetCompletionDate;
    }

    @JsonProperty("targetCompletionDate")
    public void setTargetCompletionDate(String targetCompletionDate) {
        this.targetCompletionDate = targetCompletionDate;
    }

    public OverviewModel withTargetCompletionDate(String targetCompletionDate) {
        setTargetCompletionDate(targetCompletionDate);
        return this;
    }

    @JsonProperty("overrideOppositionDate")
    public Boolean getOverrideOppositionDate() {
        return overrideOppositionDate;
    }

    @JsonProperty("overrideOppositionDate")
    public void setOverrideOppositionDate(Boolean overrideOppositionDate) {
        this.overrideOppositionDate = overrideOppositionDate;
    }

    public OverviewModel withOverrideOppositionDate(Boolean overrideOppositionDate) {
        setOverrideOppositionDate(overrideOppositionDate);
        return this;
    }

    @JsonProperty("tracking")
    public TrackingModel getTrackingModel() {
        return TrackingModel;
    }

    @JsonProperty("tracking")
    public void setTrackingModel(TrackingModel TrackingModel) {
        this.TrackingModel = TrackingModel;
    }

    public OverviewModel withTrackingModel(TrackingModel TrackingModel) {
        this.TrackingModel = TrackingModel;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getApplicationId())
                .append("version", getVersion())
                .append("leadTcArea", getLeadTcArea())
                .append("receivedDate", getReceivedDate())
                .append("targetCompletionDate", getTargetCompletionDate())
                .append("overrideOppositionDate", getOverrideOppositionDate())
                .append("tracking", getTrackingModel())
                .toString();
    }
    
}
