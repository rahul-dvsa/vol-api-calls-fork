package apiCalls.Utils.eupaBuilders.internal;

import apiCalls.Utils.eupaBuilders.internal.enums.Status;
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
        "version",
        "addressesStatus",
        "businessDetailsStatus",
        "businessTypeStatus",
        "communityLicencesStatus",
        "conditionsUndertakingsStatus",
        "convictionsPenaltiesStatus",
        "discsStatus",
        "financialEvidenceStatus",
        "financialHistoryStatus",
        "licenceHistoryStatus",
        "operatingCentresStatus",
        "peopleStatus",
        "safetyStatus",
        "taxiPhvStatus",
        "transportManagersStatus",
        "typeOfLicenceStatus",
        "declarationsInternalStatus",
        "vehiclesDeclarationsStatus",
        "vehiclesPsvStatus",
        "vehiclesStatus"
})
public class TrackingModel {

    @JsonProperty("id")
    private String trackingId;
    @JsonProperty("version")
    private Integer version = 1;
    @JsonProperty("addressesStatus")
    private Status addressesStatus;
    @JsonProperty("businessDetailsStatus")
    private Status businessDetailsStatus;
    @JsonProperty("businessTypeStatus")
    private Status businessTypeStatus;
    @JsonProperty("communityLicencesStatus")
    private Status communityLicencesStatus;
    @JsonProperty("conditionsUndertakingsStatus")
    private Status conditionsUndertakingsStatus;
    @JsonProperty("convictionsPenaltiesStatus")
    private Status convictionsPenaltiesStatus;
    @JsonProperty("discsStatus")
    private Status discsStatus;
    @JsonProperty("financialEvidenceStatus")
    private Status financialEvidenceStatus;
    @JsonProperty("financialHistoryStatus")
    private Status financialHistoryStatus;
    @JsonProperty("licenceHistoryStatus")
    private Status licenceHistoryStatus;
    @JsonProperty("operatingCentresStatus")
    private Status operatingCentresStatus;
    @JsonProperty("peopleStatus")
    private Status peopleStatus;
    @JsonProperty("safetyStatus")
    private Status safetyStatus;
    @JsonProperty("taxiPhvStatus")
    private Status taxiPhvStatus;
    @JsonProperty("transportManagersStatus")
    private Status transportManagersStatus;
    @JsonProperty("typeOfLicenceStatus")
    private Status typeOfLicenceStatus;
    @JsonProperty("declarationsInternalStatus")
    private Status declarationsInternalStatus;
    @JsonProperty("vehiclesDeclarationsStatus")
    private Status vehiclesDeclarationsStatus;
    @JsonProperty("vehiclesPsvStatus")
    private Status vehiclesPsvStatus;
    @JsonProperty("vehiclesStatus")
    private Status vehiclesStatus;

    @JsonProperty("id")
    public String getTrackingId() {
        return trackingId;
    }

    @JsonProperty("id")
    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public TrackingModel withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    public TrackingModel withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @JsonProperty("addressesStatus")
    public Status getAddressesStatus() {
        return addressesStatus;
    }

    @JsonProperty("addressesStatus")
    public void setAddressesStatus(Status addressesStatus) {
        this.addressesStatus = addressesStatus;
    }

    public TrackingModel withAddressesStatus(Status addressesStatus) {
        this.addressesStatus = addressesStatus;
        return this;
    }

    @JsonProperty("businessDetailsStatus")
    public Status getBusinessDetailsStatus() {
        return businessDetailsStatus;
    }

    @JsonProperty("businessDetailsStatus")
    public void setBusinessDetailsStatus(Status businessDetailsStatus) {
        this.businessDetailsStatus = businessDetailsStatus;
    }

    public TrackingModel withBusinessDetailsStatus(Status businessDetailsStatus) {
        this.businessDetailsStatus = businessDetailsStatus;
        return this;
    }

    @JsonProperty("businessTypeStatus")
    public Status getBusinessTypeStatus() {
        return businessTypeStatus;
    }

    @JsonProperty("businessTypeStatus")
    public void setBusinessTypeStatus(Status businessTypeStatus) {
        this.businessTypeStatus = businessTypeStatus;
    }

    public TrackingModel withBusinessTypeStatus(Status businessTypeStatus) {
        this.businessTypeStatus = businessTypeStatus;
        return this;
    }

    @JsonProperty("communityLicencesStatus")
    public Status getCommunityLicencesStatus() {
        return communityLicencesStatus;
    }

    @JsonProperty("communityLicencesStatus")
    public void setCommunityLicencesStatus(Status communityLicencesStatus) {
        this.communityLicencesStatus = communityLicencesStatus;
    }

    public TrackingModel withCommunityLicencesStatus(Status communityLicencesStatus) {
        this.communityLicencesStatus = communityLicencesStatus;
        return this;
    }

    @JsonProperty("conditionsUndertakingsStatus")
    public Status getConditionsUndertakingsStatus() {
        return conditionsUndertakingsStatus;
    }

    @JsonProperty("conditionsUndertakingsStatus")
    public void setConditionsUndertakingsStatus(Status conditionsUndertakingsStatus) {
        this.conditionsUndertakingsStatus = conditionsUndertakingsStatus;
    }

    public TrackingModel withConditionsUndertakingsStatus(Status conditionsUndertakingsStatus) {
        this.conditionsUndertakingsStatus = conditionsUndertakingsStatus;
        return this;
    }

    @JsonProperty("convictionsPenaltiesStatus")
    public Status getConvictionsPenaltiesStatus() {
        return convictionsPenaltiesStatus;
    }

    @JsonProperty("convictionsPenaltiesStatus")
    public void setConvictionsPenaltiesStatus(Status convictionsPenaltiesStatus) {
        this.convictionsPenaltiesStatus = convictionsPenaltiesStatus;
    }

    public TrackingModel withConvictionsPenaltiesStatus(Status convictionsPenaltiesStatus) {
        this.convictionsPenaltiesStatus = convictionsPenaltiesStatus;
        return this;
    }

    @JsonProperty("discsStatus")
    public Status getDiscsStatus() {
        return discsStatus;
    }

    @JsonProperty("discsStatus")
    public void setDiscsStatus(Status discsStatus) {
        this.discsStatus = discsStatus;
    }

    public TrackingModel withDiscsStatus(Status discsStatus) {
        this.discsStatus = discsStatus;
        return this;
    }

    @JsonProperty("financialEvidenceStatus")
    public Status getFinancialEvidenceStatus() {
        return financialEvidenceStatus;
    }

    @JsonProperty("financialEvidenceStatus")
    public void setFinancialEvidenceStatus(Status financialEvidenceStatus) {
        this.financialEvidenceStatus = financialEvidenceStatus;
    }

    public TrackingModel withFinancialEvidenceStatus(Status financialEvidenceStatus) {
        this.financialEvidenceStatus = financialEvidenceStatus;
        return this;
    }

    @JsonProperty("financialHistoryStatus")
    public Status getFinancialHistoryStatus() {
        return financialHistoryStatus;
    }

    @JsonProperty("financialHistoryStatus")
    public void setFinancialHistoryStatus(Status financialHistoryStatus) {
        this.financialHistoryStatus = financialHistoryStatus;
    }

    public TrackingModel withFinancialHistoryStatus(Status financialHistoryStatus) {
        this.financialHistoryStatus = financialHistoryStatus;
        return this;
    }

    @JsonProperty("licenceHistoryStatus")
    public Status getLicenceHistoryStatus() {
        return licenceHistoryStatus;
    }

    @JsonProperty("licenceHistoryStatus")
    public void setLicenceHistoryStatus(Status licenceHistoryStatus) {
        this.licenceHistoryStatus = licenceHistoryStatus;
    }

    public TrackingModel withLicenceHistoryStatus(Status licenceHistoryStatus) {
        this.licenceHistoryStatus = licenceHistoryStatus;
        return this;
    }

    @JsonProperty("operatingCentresStatus")
    public Status getOperatingCentresStatus() {
        return operatingCentresStatus;
    }

    @JsonProperty("operatingCentresStatus")
    public void setOperatingCentresStatus(Status operatingCentresStatus) {
        this.operatingCentresStatus = operatingCentresStatus;
    }

    public TrackingModel withOperatingCentresStatus(Status operatingCentresStatus) {
        this.operatingCentresStatus = operatingCentresStatus;
        return this;
    }

    @JsonProperty("peopleStatus")
    public Status getPeopleStatus() {
        return peopleStatus;
    }

    @JsonProperty("peopleStatus")
    public void setPeopleStatus(Status peopleStatus) {
        this.peopleStatus = peopleStatus;
    }

    public TrackingModel withPeopleStatus(Status peopleStatus) {
        this.peopleStatus = peopleStatus;
        return this;
    }

    @JsonProperty("safetyStatus")
    public Status getSafetyStatus() {
        return safetyStatus;
    }

    @JsonProperty("safetyStatus")
    public void setSafetyStatus(Status safetyStatus) {
        this.safetyStatus = safetyStatus;
    }

    public TrackingModel withSafetyStatus(Status safetyStatus) {
        this.safetyStatus = safetyStatus;
        return this;
    }

    @JsonProperty("taxiPhvStatus")
    public Status getTaxiPhvStatus() {
        return taxiPhvStatus;
    }

    @JsonProperty("taxiPhvStatus")
    public void setTaxiPhvStatus(Status taxiPhvStatus) {
        this.taxiPhvStatus = taxiPhvStatus;
    }

    public TrackingModel withTaxiPhvStatus(Status taxiPhvStatus) {
        this.taxiPhvStatus = taxiPhvStatus;
        return this;
    }

    @JsonProperty("transportManagersStatus")
    public Status getTransportManagersStatus() {
        return transportManagersStatus;
    }

    @JsonProperty("transportManagersStatus")
    public void setTransportManagersStatus(Status transportManagersStatus) {
        this.transportManagersStatus = transportManagersStatus;
    }

    public TrackingModel withTransportManagersStatus(Status transportManagersStatus) {
        this.transportManagersStatus = transportManagersStatus;
        return this;
    }

    @JsonProperty("typeOfLicenceStatus")
    public Status getTypeOfLicenceStatus() {
        return typeOfLicenceStatus;
    }

    @JsonProperty("typeOfLicenceStatus")
    public void setTypeOfLicenceStatus(Status typeOfLicenceStatus) {
        this.typeOfLicenceStatus = typeOfLicenceStatus;
    }

    public TrackingModel withTypeOfLicenceStatus(Status typeOfLicenceStatus) {
        this.typeOfLicenceStatus = typeOfLicenceStatus;
        return this;
    }

    @JsonProperty("declarationsInternalStatus")
    public Status getDeclarationsInternalStatus() {
        return declarationsInternalStatus;
    }

    @JsonProperty("declarationsInternalStatus")
    public void setDeclarationsInternalStatus(Status declarationsInternalStatus) {
        this.declarationsInternalStatus = declarationsInternalStatus;
    }

    public TrackingModel withDeclarationsInternalStatus(Status declarationsInternalStatus) {
        this.declarationsInternalStatus = declarationsInternalStatus;
        return this;
    }

    @JsonProperty("vehiclesDeclarationsStatus")
    public Status getVehiclesDeclarationsStatus() {
        return vehiclesDeclarationsStatus;
    }

    @JsonProperty("vehiclesDeclarationsStatus")
    public void setVehiclesDeclarationsStatus(Status vehiclesDeclarationsStatus) {
        this.vehiclesDeclarationsStatus = vehiclesDeclarationsStatus;
    }

    public TrackingModel withVehiclesDeclarationsStatus(Status vehiclesDeclarationsStatus) {
        this.vehiclesDeclarationsStatus = vehiclesDeclarationsStatus;
        return this;
    }

    @JsonProperty("vehiclesPsvStatus")
    public Status getVehiclesPsvStatus() {
        return vehiclesPsvStatus;
    }

    @JsonProperty("vehiclesPsvStatus")
    public void setVehiclesPsvStatus(Status vehiclesPsvStatus) {
        this.vehiclesPsvStatus = vehiclesPsvStatus;
    }

    public TrackingModel withVehiclesPsvStatus(Status vehiclesPsvStatus) {
        this.vehiclesPsvStatus = vehiclesPsvStatus;
        return this;
    }

    @JsonProperty("vehiclesStatus")
    public Status getVehiclesStatus() {
        return vehiclesStatus;
    }

    @JsonProperty("vehiclesStatus")
    public void setVehiclesStatus(Status vehiclesStatus) {
        this.vehiclesStatus = vehiclesStatus;
    }

    public TrackingModel withVehiclesStatus(Status vehiclesStatus) {
        this.vehiclesStatus = vehiclesStatus;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", getTrackingId())
                .append("version", getVersion())
                .append("addressesStatus", getAddressesStatus())
                .append("businessDetailsStatus", getBusinessDetailsStatus())
                .append("businessTypeStatus", getBusinessTypeStatus())
                .append("communityLicencesStatus", getCommunityLicencesStatus())
                .append("conditionsUndertakingsStatus", getConditionsUndertakingsStatus())
                .append("convictionsPenaltiesStatus", getConvictionsPenaltiesStatus())
                .append("discsStatus", getDiscsStatus())
                .append("financialEvidenceStatus", getFinancialEvidenceStatus())
                .append("financialHistoryStatus", getFinancialEvidenceStatus())
                .append("licenceHistoryStatus", getLicenceHistoryStatus())
                .append("operatingCentresStatus", getOperatingCentresStatus())
                .append("peopleStatus", getPeopleStatus())
                .append("safetyStatus", getSafetyStatus())
                .append("taxiPhvStatus", getTaxiPhvStatus())
                .append("transportManagersStatus", getTransportManagersStatus())
                .append("typeOfLicenceStatus", getTypeOfLicenceStatus())
                .append("declarationsInternalStatus", getDeclarationsInternalStatus())
                .append("vehiclesDeclarationsStatus", getVehiclesDeclarationsStatus())
                .append("vehiclesPsvStatus", getVehiclesPsvStatus())
                .append("vehiclesStatus", getVehiclesStatus())
                .toString();
    }
    
}
