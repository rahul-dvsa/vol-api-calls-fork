package apiCalls.Utils.eupaBuilders.external;

import apiCalls.Utils.eupaBuilders.external.enums.Title;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "forename",
        "familyName",
        "birthDate"
})
public class PersonModel {

    @JsonProperty("id")
    private String userId;
    private String applicationId;
    @JsonProperty("title")
    private Title title;
    @JsonProperty("forename")
    private String forename;
    @JsonProperty("familyName")
    private String familyName;
    @JsonProperty("birthDate")
    private String birthDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PersonModel withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @JsonProperty("id")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("id")
    public void setApplicationId(@NotNull String applicationId) {
        this.applicationId = applicationId;
    }

    public PersonModel withApplicationId(@NotNull String applicationId) {
        setApplicationId(applicationId);
        return this;
    }

    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    public PersonModel withTitle(Title title) {
        setTitle(title);
        return this;
    }

    @JsonProperty("forename")
    public String getForename() {
        return forename;
    }

    @JsonProperty("forename")
    public void setForename(String forename) {
        this.forename = forename;
    }

    public PersonModel withForename(String forename) {
        this.forename = forename;
        return this;
    }

    @JsonProperty("familyName")
    public String getFamilyName() {
        return familyName;
    }

    @JsonProperty("familyName")
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public PersonModel withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(int year, int month, int date) {
        this.birthDate = String.format("%d-%d-%d", year, month, date);
    }

    public PersonModel withBirthDate(int year, int month, int date) {
        setBirthDate(year, month, date);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", applicationId)
                .append("title", title)
                .append("forename", forename)
                .append("familyName", familyName)
                .append("birthDate", birthDate)
                .toString();
    }

}