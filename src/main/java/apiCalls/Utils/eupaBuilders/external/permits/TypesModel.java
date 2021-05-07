package apiCalls.Utils.eupaBuilders.external.permits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "types"
})
public class TypesModel {

    @JsonProperty("types")
    private List<TypeModel> types = null;

    @JsonProperty("types")
    public List<TypeModel> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public TypesModel setTypes(List<TypeModel> types) {
        this.types = types;
        return this;
    }

    public TypeModel permit(String type) {
        return getTypes().stream()
                .filter(typeModel -> typeModel.getName().getDescription().toLowerCase().contains(type.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] Unable to find a permit of type: " + type));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("types", types).toString();
    }
}
