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
        "id",
        "irhpPermitStock",
        "version"
})
public class OpenWindowModel {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("irhpPermitStock")
    private IrhpPermitStockModel irhpPermitStockModel;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("irhpPermitStock")
    public IrhpPermitStockModel getIrhpPermitStockModel() {
        return irhpPermitStockModel;
    }

    @JsonProperty("irhpPermitStock")
    public void setIrhpPermitStockModel(IrhpPermitStockModel irhpPermitStockModel) {
        this.irhpPermitStockModel = irhpPermitStockModel;
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
                .append("id", id)
                .append("irhpPermitStock", irhpPermitStockModel)
                .append("version", version)
                .toString();
    }

}