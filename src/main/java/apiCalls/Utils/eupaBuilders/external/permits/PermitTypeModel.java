package apiCalls.Utils.eupaBuilders.external.permits;

import apiCalls.Utils.eupaBuilders.deserialiser.DateISO8601Deserialiser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "createdOn",
        "description",
        "id",
        "lastModifiedBy",
        "lastModifiedOn",
        "name",
        "isEcmtAnnual",
        "isEcmtShortTerm",
        "isBilateral",
        "isMultilateral"
})
public class PermitTypeModel {

    @JsonProperty("createdOn")
    @JsonDeserialize(using = DateISO8601Deserialiser.class)
    private LocalDateTime createdOn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("lastModifiedOn")
    @JsonDeserialize(using = DateISO8601Deserialiser.class)
    private LocalDateTime lastModifiedOn;
    @JsonProperty("name")
    private NameModel name;
    @JsonProperty("isEcmtAnnual")
    private Boolean isEcmtAnnual;
    @JsonProperty("isEcmtShortTerm")
    private Boolean isEcmtShortTerm;
    @JsonProperty("isBilateral")
    private Boolean isBilateral;
    @JsonProperty("isMultilateral")
    private Boolean isMultilateral;

    @JsonProperty("createdOn")
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("lastModifiedOn")
    public LocalDateTime getLastModifiedOn() {
        return lastModifiedOn;
    }

    @JsonProperty("lastModifiedOn")
    public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @JsonProperty("name")
    public NameModel getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(NameModel name) {
        this.name = name;
    }

    @JsonProperty("isEcmtAnnual")
    public Boolean getIsEcmtAnnual() {
        return isEcmtAnnual;
    }

    @JsonProperty("isEcmtAnnual")
    public void setIsEcmtAnnual(Boolean isEcmtAnnual) {
        this.isEcmtAnnual = isEcmtAnnual;
    }

    @JsonProperty("isEcmtShortTerm")
    public Boolean getIsEcmtShortTerm() {
        return isEcmtShortTerm;
    }

    @JsonProperty("isEcmtShortTerm")
    public void setIsEcmtShortTerm(Boolean isEcmtShortTerm) {
        this.isEcmtShortTerm = isEcmtShortTerm;
    }

    @JsonProperty("isBilateral")
    public Boolean getIsBilateral() {
        return isBilateral;
    }

    @JsonProperty("isBilateral")
    public void setIsBilateral(Boolean isBilateral) {
        this.isBilateral = isBilateral;
    }

    @JsonProperty("isMultilateral")
    public Boolean getIsMultilateral() {
        return isMultilateral;
    }

    @JsonProperty("isMultilateral")
    public void setIsMultilateral(Boolean isMultilateral) {
        this.isMultilateral = isMultilateral;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("createdOn", createdOn)
                .append("description", description)
                .append("id", id)
                .append("lastModifiedOn", lastModifiedOn)
                .append("name", name).append("isEcmtAnnual", isEcmtAnnual)
                .append("isEcmtShortTerm", isEcmtShortTerm)
                .append("isBilateral", isBilateral)
                .append("isMultilateral", isMultilateral)
                .toString();
    }

}
