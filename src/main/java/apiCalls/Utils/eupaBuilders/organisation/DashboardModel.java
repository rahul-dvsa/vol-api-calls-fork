package apiCalls.Utils.eupaBuilders.organisation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "licences"
})
public class DashboardModel {

    @JsonProperty("licences")
    private List<LicenceModel> licences;

    @JsonProperty("licences")
    public List<LicenceModel> getLicences() {
        return licences;
    }

    @JsonProperty("licences")
    public DashboardModel setLicences(List<LicenceModel> licences) {
        this.licences = licences;
        return this;
    }

    public Optional<LicenceModel> getLicence(String licenceNumber) {
        return getLicences().stream().filter((licence) -> licence.getLicNo().equals(licenceNumber))
                .findFirst();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("licences", getLicences())
                .toString();
    }

}
