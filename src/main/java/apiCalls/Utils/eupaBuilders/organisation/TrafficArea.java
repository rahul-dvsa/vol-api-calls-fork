package apiCalls.Utils.eupaBuilders.organisation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "isEngland",
        "isNi",
        "isScotland",
        "isWales",
        "name",
        "salesPersonReference",
        "txcName"
})
public class TrafficArea {

    @JsonProperty("id")
    private String id;
    @JsonProperty("isEngland")
    private Boolean isEngland;
    @JsonProperty("isNi")
    private Boolean isNi;
    @JsonProperty("isScotland")
    private Boolean isScotland;
    @JsonProperty("isWales")
    private Boolean isWales;
    @JsonProperty("name")
    private String name;
    @JsonProperty("salesPersonReference")
    private String salesPersonReference;
    @JsonProperty("txcName")
    private String txcName;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("isEngland")
    public Boolean getIsEngland() {
        return isEngland;
    }

    @JsonProperty("isEngland")
    public void setIsEngland(Boolean isEngland) {
        this.isEngland = isEngland;
    }

    @JsonProperty("isNi")
    public Boolean getIsNi() {
        return isNi;
    }

    @JsonProperty("isNi")
    public void setIsNi(Boolean isNi) {
        this.isNi = isNi;
    }

    @JsonProperty("isScotland")
    public Boolean getIsScotland() {
        return isScotland;
    }

    @JsonProperty("isScotland")
    public void setIsScotland(Boolean isScotland) {
        this.isScotland = isScotland;
    }

    @JsonProperty("isWales")
    public Boolean getIsWales() {
        return isWales;
    }

    @JsonProperty("isWales")
    public void setIsWales(Boolean isWales) {
        this.isWales = isWales;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("salesPersonReference")
    public String getSalesPersonReference() {
        return salesPersonReference;
    }

    @JsonProperty("salesPersonReference")
    public void setSalesPersonReference(String salesPersonReference) {
        this.salesPersonReference = salesPersonReference;
    }

    @JsonProperty("txcName")
    public String getTxcName() {
        return txcName;
    }

    @JsonProperty("txcName")
    public void setTxcName(String txcName) {
        this.txcName = txcName;
    }

}
