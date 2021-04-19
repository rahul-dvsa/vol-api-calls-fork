package apiCalls.Utils.eupaBuilders.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "application",
        "noOfVehiclesRequired",
        "noOfTrailersRequired",
        "permission",
        "address"
})
public class OperatingCentreModel {

    @JsonProperty("application")
    private String applicationId;
    @JsonProperty("noOfVehiclesRequired")
    private String noOfVehiclesRequired;
    @JsonProperty("noOfTrailersRequired")
    private String noOfTrailersRequired;
    @JsonProperty("permission")
    private String permission;
    @JsonProperty("address")
    private AddressModel address;

    @JsonProperty("application")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("application")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public OperatingCentreModel withApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    @JsonProperty("noOfVehiclesRequired")
    public String getNoOfVehiclesRequired() {
        return noOfVehiclesRequired;
    }

    @JsonProperty("noOfVehiclesRequired")
    public void setNoOfVehiclesRequired(int noOfVehiclesRequired) {
        this.noOfVehiclesRequired = String.valueOf(noOfVehiclesRequired);
    }

    public OperatingCentreModel withNoOfVehiclesRequired(int noOfVehiclesRequired) {
        this.noOfVehiclesRequired = String.valueOf(noOfVehiclesRequired);
        return this;
    }

    @JsonProperty("noOfTrailersRequired")
    public String getNoOfTrailersRequired() {
        return noOfTrailersRequired;
    }

    @JsonProperty("noOfTrailersRequired")
    public void setNoOfTrailersRequired(int noOfTrailersRequired) {
        this.noOfTrailersRequired = String.valueOf(noOfTrailersRequired);
    }

    public OperatingCentreModel withNoOfTrailersRequired(int noOfTrailersRequired) {
        this.noOfTrailersRequired = String.valueOf(noOfTrailersRequired);
        return this;
    }

    @JsonProperty("permission")
    public String getPermission() {
        return permission;
    }

    @JsonProperty("permission")
    public void setPermission(Boolean permission) {
        this.permission = permission.toString();
    }

    public OperatingCentreModel withPermission(Boolean permission) {
        this.permission = permission.toString();
        return this;
    }

    @JsonProperty("address")
    public AddressModel getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public OperatingCentreModel withAddress(AddressModel address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("application", getApplicationId())
                .append("noOfVehiclesRequired",getNoOfVehiclesRequired())
                .append("noOfTrailersRequired", getNoOfTrailersRequired())
                .append("permission", getPermission())
                .append("address", getAddress())
                .toString();
    }
}
