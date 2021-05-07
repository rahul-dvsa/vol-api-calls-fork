package apiCalls.Utils.eupaBuilders.internal.irhp.permit.stock;

import apiCalls.Utils.eupaBuilders.deserialiser.CustomLocalDateDeserialiser;
import apiCalls.Utils.eupaBuilders.serialisers.CustomLocalDateSerialiser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "country",
        "id",
        "initialStock",
        "irhpPermitType",
        "validFrom",
        "validTo",
        "version"
})
public class IrhpPermitStockModel {

    @JsonProperty("country")
    private CountryModel countryModel;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("initialStock")
    private Integer initialStock;
    @JsonProperty("irhpPermitType")
    private IrhpPermitTypeModel irhpPermitType;
    @JsonProperty("validFrom")
    @JsonDeserialize(using = CustomLocalDateDeserialiser.class)
    @JsonSerialize(using = CustomLocalDateSerialiser.class)
    private LocalDate validFrom;
    @JsonProperty("validTo")
    @JsonDeserialize(using = CustomLocalDateDeserialiser.class)
    @JsonSerialize(using = CustomLocalDateSerialiser.class)
    private LocalDate validTo;
    @JsonProperty("version")
    private Integer version;

    @JsonProperty("country")
    public CountryModel getCountryModel() {
        return countryModel;
    }

    @JsonProperty("country")
    public void setCountryModel(CountryModel countryModel) {
        this.countryModel = countryModel;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("initialStock")
    public Integer getInitialStock() {
        return initialStock;
    }

    @JsonProperty("initialStock")
    public void setInitialStock(Integer initialStock) {
        this.initialStock = initialStock;
    }

    @JsonProperty("irhpPermitType")
    public IrhpPermitTypeModel getIrhpPermitType() {
        return irhpPermitType;
    }

    @JsonProperty("irhpPermitType")
    public void setIrhpPermitType(IrhpPermitTypeModel irhpPermitType) {
        this.irhpPermitType = irhpPermitType;
    }

    @JsonProperty("validFrom")
    public LocalDate getValidFrom() {
        return validFrom;
    }

    @JsonProperty("validFrom")
    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    @JsonProperty("validTo")
    public LocalDate getValidTo() {
        return validTo;
    }

    @JsonProperty("validTo")
    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
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
                .append("country", countryModel)
                .append("id", id)
                .append("initialStock", initialStock)
                .append("irhpPermitType", irhpPermitType)
                .append("validFrom", validFrom)
                .append("validTo", validTo)
                .append("version", version)
                .toString();
    }

}