package apiCalls.Utils.eupaBuilders.internal.irhp.permit.stock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "results"
})
public class OpenByCountryModel {

    @JsonProperty("results")
    private List<OpenWindowModel> openWindowModels = null;

    @JsonProperty("results")
    public List<OpenWindowModel> getOpenWindowModels() {
        return openWindowModels;
    }

    @JsonProperty("results")
    public void setOpenWindowModels(List<OpenWindowModel> openWindowModels) {
        this.openWindowModels = openWindowModels;
    }

    public Optional<List<Window>> countries() {
        return openWindowModels == null ? Optional.empty() : Optional.of(
                openWindowModels.stream()
                .map(window -> new Window(
                        window.getIrhpPermitStockModel().getCountryModel().getCountryDesc(),
                        window.getIrhpPermitStockModel().getValidFrom(),
                        window.getIrhpPermitStockModel().getValidTo()
                        )
                )
                .collect(Collectors.toList())
        );
    }

    public Optional<Set<String>> countryNames() {
        return !countries().isPresent() ? Optional.empty() : Optional.of(countries().get().stream().map(Window::getCountry).collect(Collectors.toSet()));
    }

    public List<OpenWindowModel> openWindowsFor(String... country) {
        return Arrays.stream(country).flatMap(c -> getOpenWindowModels().stream().filter(w -> w.getIrhpPermitStockModel().getCountryModel().getCountryDesc().equalsIgnoreCase(c))).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("results", openWindowModels)
                .toString();
    }

    public class Window {
        private String country;
        private LocalDate validFrom;
        private LocalDate validTo;

        public Window(String country, LocalDate validFrom, LocalDate validTo) {
            this.country = country;
            this.validFrom = validFrom;
            this.validTo = validTo;
        }

        public String getCountry() {
            return country;
        }

        public LocalDate getValidFrom() {
            return validFrom;
        }

        public LocalDate getValidTo() {
            return validTo;
        }
    }

}
