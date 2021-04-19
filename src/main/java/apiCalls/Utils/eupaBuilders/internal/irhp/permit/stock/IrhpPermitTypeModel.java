package apiCalls.Utils.eupaBuilders.internal.irhp.permit.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "createdOn",
        "description",
        "id",
        "lastModifiedOn",
        "name",
        "version"
})
public class IrhpPermitTypeModel {

    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("lastModifiedOn")
    private String lastModifiedOn;
    @JsonProperty("name")
    private NameModel nameModel;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("createdOn")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(String createdOn) {
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
    public String getLastModifiedOn() {
        return lastModifiedOn;
    }

    @JsonProperty("lastModifiedOn")
    public void setLastModifiedOn(String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @JsonProperty("name")
    public NameModel getNameModel() {
        return nameModel;
    }

    @JsonProperty("name")
    public void setNameModel(NameModel nameModel) {
        this.nameModel = nameModel;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("createdOn", createdOn)
                .append("description", description)
                .append("id", id)
                .append("lastModifiedOn", lastModifiedOn)
                .append("name", nameModel)
                .append("version", version)
                .toString();
    }

}