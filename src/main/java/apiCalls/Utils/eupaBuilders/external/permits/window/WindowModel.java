package apiCalls.Utils.eupaBuilders.external.permits.window;

import apiCalls.Utils.eupaBuilders.deserialiser.DateISO8601Deserialiser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "createdOn",
        "daysForPayment",
        "endDate",
        "id",
        "startDate",
        "version",
        "emissionsCategory"
})
public class WindowModel {

    @JsonProperty("createdOn")
    @JsonDeserialize(using = DateISO8601Deserialiser.class)
    private LocalDateTime createdOn;
    @JsonProperty("daysForPayment")
    private Integer daysForPayment;
    @JsonProperty("endDate")
    @JsonDeserialize(using = DateISO8601Deserialiser.class)
    private LocalDateTime endDate;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("startDate")
    @JsonDeserialize(using = DateISO8601Deserialiser.class)
    private LocalDateTime startDate;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("emissionsCategory")
    private EmissionsCategoryModel emissionsCategory;

    @JsonProperty("createdOn")
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("daysForPayment")
    public Integer getDaysForPayment() {
        return daysForPayment;
    }

    @JsonProperty("daysForPayment")
    public void setDaysForPayment(Integer daysForPayment) {
        this.daysForPayment = daysForPayment;
    }

    @JsonProperty("endDate")
    public LocalDateTime getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("startDate")
    public LocalDateTime getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("emissionsCategory")
    public EmissionsCategoryModel getEmissionsCategory() {
        return emissionsCategory;
    }

    @JsonProperty("emissionsCategory")
    public void setEmissionsCategory(EmissionsCategoryModel emissionsCategory) {
        this.emissionsCategory = emissionsCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("createdOn", createdOn)
                .append("daysForPayment", daysForPayment)
                .append("endDate", endDate)
                .append("id", id)
                .append("startDate", startDate)
                .append("version", version)
                .append("emissionsCategory", emissionsCategory)
                .toString();
    }

}
