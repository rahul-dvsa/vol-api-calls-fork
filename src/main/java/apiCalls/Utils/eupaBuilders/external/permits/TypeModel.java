package apiCalls.Utils.eupaBuilders.external.permits;


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
        "name"
})
public class TypeModel {

    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private NameModel name;

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
    public TypeModel setId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public NameModel getName() {
        return name;
    }

    @JsonProperty("name")
    public TypeModel setName(NameModel name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("description", description)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
