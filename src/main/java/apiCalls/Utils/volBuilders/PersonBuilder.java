package apiCalls.Utils.volBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class PersonBuilder {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("forename")
    private String forename;
    @JsonProperty("familyName")
    private String familyName;
    @JsonProperty("birthDate")
    private String birthDate;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String title) {
        this.id = id;
    }

    public PersonBuilder withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public PersonBuilder withTitle(String title) {
        this.title = title;
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

    public PersonBuilder withForename(String forename) {
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

    public PersonBuilder withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public PersonBuilder withBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
        .append("person"," ")
        .append("title",  getTitle())
                .append("forename",  getForename())
                .append("familyName", getFamilyName())
                .append("birthDate", getBirthDate())
                .append("id", getId()).toString();
    }
}