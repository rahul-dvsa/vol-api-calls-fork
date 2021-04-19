package apiCalls.Utils.eupaBuilders.internal.irhp.permit.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "countries"
})
public class AvailableCountriesModel {

    @JsonProperty("countries")
    private List<CountryModel> countries = null;

    @JsonProperty("countries")
    public List<CountryModel> getCountries() {
        return countries;
    }

    @JsonProperty("countries")
    public AvailableCountriesModel setCountries(List<CountryModel> countries) {
        this.countries = countries;
        return this;
    }

    public List<String> getAllCountryIds() {
        return getCountries().stream()
                .map(CountryModel::getId).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("countries", countries)
                .toString();
    }

}