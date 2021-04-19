package apiCalls.Utils.eupaBuilders;

import apiCalls.Utils.eupaBuilders.enums.permits.Section;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "licence",
        "emissions",
        "cabotage",
        "internationalJourneys",
        "trips",
        "permitsRequired",
        "checkedAnswers",
        "sectors",
        "countrys",
        "totalSections",
        "totalCompleted",
        "allCompleted"
})
public class SectionCompletionModel {

    @JsonProperty("licence")
    private Section licence;
    @JsonProperty("emissions")
    private Section emissions;
    @JsonProperty("cabotage")
    private Section cabotage;
    @JsonProperty("internationalJourneys")
    private Section internationalJourneys;
    @JsonProperty("trips")
    private Section trips;
    @JsonProperty("permitsRequired")
    private Section permitsRequired;
    @JsonProperty("checkedAnswers")
    private String checkedAnswers;
    @JsonProperty("sectors")
    private Section sectors;
    @JsonProperty("countrys")
    private Section countrys;
    @JsonProperty("totalSections")
    private Integer totalSections;
    @JsonProperty("totalCompleted")
    private Integer totalCompleted;
    @JsonProperty("allCompleted")
    private Boolean allCompleted;

    @JsonProperty("licence")
    public Section getLicence() {
        return licence;
    }

    @JsonProperty("licence")
    public void setLicence(Section licence) {
        this.licence = licence;
    }

    public SectionCompletionModel withLicence(Section licence) {
        this.licence = licence;
        return this;
    }

    @JsonProperty("emissions")
    public Section getEmissions() {
        return emissions;
    }

    @JsonProperty("emissions")
    public void setEmissions(Section emissions) {
        this.emissions = emissions;
    }

    public SectionCompletionModel withEmissions(Section emissions) {
        this.emissions = emissions;
        return this;
    }

    @JsonProperty("cabotage")
    public Section getCabotage() {
        return cabotage;
    }

    @JsonProperty("cabotage")
    public void setCabotage(Section cabotage) {
        this.cabotage = cabotage;
    }

    public SectionCompletionModel withCabotage(Section cabotage) {
        this.cabotage = cabotage;
        return this;
    }

    @JsonProperty("internationalJourneys")
    public Section getInternationalJourneys() {
        return internationalJourneys;
    }

    @JsonProperty("internationalJourneys")
    public void setInternationalJourneys(Section internationalJourneys) {
        this.internationalJourneys = internationalJourneys;
    }

    public SectionCompletionModel withInternationalJourneys(Section internationalJourneys) {
        this.internationalJourneys = internationalJourneys;
        return this;
    }

    @JsonProperty("trips")
    public Section getTrips() {
        return trips;
    }

    @JsonProperty("trips")
    public void setTrips(Section trips) {
        this.trips = trips;
    }

    public SectionCompletionModel withTrips(Section trips) {
        this.trips = trips;
        return this;
    }

    @JsonProperty("permitsRequired")
    public Section getPermitsRequired() {
        return permitsRequired;
    }

    @JsonProperty("permitsRequired")
    public void setPermitsRequired(Section permitsRequired) {
        this.permitsRequired = permitsRequired;
    }

    public SectionCompletionModel withPermitsRequired(Section permitsRequired) {
        this.permitsRequired = permitsRequired;
        return this;
    }

    @JsonProperty("checkedAnswers")
    public String getCheckedAnswers() {
        return checkedAnswers;
    }

    @JsonProperty("checkedAnswers")
    public SectionCompletionModel setCheckedAnswers(String checkedAnswers) {
        this.checkedAnswers = checkedAnswers;
        return this;
    }

    @JsonProperty("sectors")
    public Section getSectors() {
        return sectors;
    }

    @JsonProperty("sectors")
    public void setSectors(Section sectors) {
        this.sectors = sectors;
    }

    public SectionCompletionModel withSectors(Section sectors) {
        this.sectors = sectors;
        return this;
    }

    @JsonProperty("countrys")
    public Section getCountrys() {
        return countrys;
    }

    @JsonProperty("countrys")
    public void setCountrys(Section countrys) {
        this.countrys = countrys;
    }

    public SectionCompletionModel withCountrys(Section countrys) {
        this.countrys = countrys;
        return this;
    }

    @JsonProperty("totalSections")
    public Integer getTotalSections() {
        return totalSections;
    }

    @JsonProperty("totalSections")
    public void setTotalSections(Integer totalSections) {
        this.totalSections = totalSections;
    }

    public SectionCompletionModel withTotalSections(Integer totalSections) {
        this.totalSections = totalSections;
        return this;
    }

    @JsonProperty("totalCompleted")
    public Integer getTotalCompleted() {
        return totalCompleted;
    }

    @JsonProperty("totalCompleted")
    public void setTotalCompleted(Integer totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    public SectionCompletionModel withTotalCompleted(Integer totalCompleted) {
        this.totalCompleted = totalCompleted;
        return this;
    }

    @JsonProperty("allCompleted")
    public Boolean getAllCompleted() {
        return allCompleted;
    }

    @JsonProperty("allCompleted")
    public void setAllCompleted(Boolean allCompleted) {
        this.allCompleted = allCompleted;
    }

    public SectionCompletionModel withAllCompleted(Boolean allCompleted) {
        this.allCompleted = allCompleted;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("licence", licence)
                .append("emissions", emissions)
                .append("cabotage", cabotage)
                .append("internationalJourneys", internationalJourneys)
                .append("trips", trips)
                .append("permitsRequired", permitsRequired)
                .append("checkedAnswers", checkedAnswers)
                .append("sectors", sectors)
                .append("countrys", countrys)
                .append("totalSections", totalSections)
                .append("totalCompleted", totalCompleted)
                .append("allCompleted", allCompleted)
                .toString();
    }

}
