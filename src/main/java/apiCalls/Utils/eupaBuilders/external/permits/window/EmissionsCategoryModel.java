package apiCalls.Utils.eupaBuilders.external.permits.window;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "description",
        "displayOrder",
        "id",
        "refDataCategoryId",
        "version"
})
public class EmissionsCategoryModel {

    @JsonProperty("description")
    private String description;
    @JsonProperty("displayOrder")
    private Integer displayOrder;
    @JsonProperty("id")
    private String id;
    @JsonProperty("refDataCategoryId")
    private String refDataCategoryId;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("displayOrder")
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    @JsonProperty("displayOrder")
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("refDataCategoryId")
    public String getRefDataCategoryId() {
        return refDataCategoryId;
    }

    @JsonProperty("refDataCategoryId")
    public void setRefDataCategoryId(String refDataCategoryId) {
        this.refDataCategoryId = refDataCategoryId;
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
                .append("description", description)
                .append("displayOrder", displayOrder)
                .append("id", id)
                .append("refDataCategoryId", refDataCategoryId)
                .append("version", version)
                .toString();
    }

}
