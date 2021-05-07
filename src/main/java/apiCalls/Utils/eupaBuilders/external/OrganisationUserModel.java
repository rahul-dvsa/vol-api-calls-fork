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
        "id",
        "isAdministrator",
        "organisation"
})
public class OrganisationUserModel {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("isAdministrator")
    private String isAdministrator;
    @JsonProperty("organisation")
    private OrganisationModel organisationModel;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public OrganisationUserModel withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("isAdministrator")
    public String getIsAdministrator() {
        return isAdministrator;
    }

    @JsonProperty("isAdministrator")
    public void setIsAdministrator(String isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    public OrganisationUserModel withIsAdministrator(String isAdministrator) {
        this.isAdministrator = isAdministrator;
        return this;
    }

    @JsonProperty("organisation")
    public OrganisationModel getOrganisationModel() {
        return organisationModel;
    }

    @JsonProperty("organisation")
    public void setOrganisationModel(OrganisationModel organisationModel) {
        this.organisationModel = organisationModel;
    }

    public OrganisationUserModel withOrganisation(OrganisationModel organisationModel) {
        this.organisationModel = organisationModel;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("isAdministrator", isAdministrator)
                .append("organisationModel", organisationModel)
                .toString();
    }

}
