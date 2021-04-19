package apiCalls.Utils.eupaBuilders;

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
        "id",
        "refDataCategoryId"
})
public class PermitTypeModel {

    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private String id;
    @JsonProperty("refDataCategoryId")
    private String refDataCategoryId;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public PermitTypeModel withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public PermitTypeModel withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("refDataCategoryId")
    public String getRefDataCategoryId() {
        return refDataCategoryId;
    }

    @JsonProperty("refDataCategoryId")
    public void setRefDataCategoryId(String refDataCategoryId) {
        this.refDataCategoryId = refDataCategoryId;
    }

    public PermitTypeModel withRefDataCategoryId(String refDataCategoryId) {
        this.refDataCategoryId = refDataCategoryId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("description", description)
                .append("id", id)
                .append("refDataCategoryId", refDataCategoryId)
                .toString();
    }

}