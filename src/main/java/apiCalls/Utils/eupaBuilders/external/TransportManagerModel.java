package apiCalls.Utils.eupaBuilders.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import apiCalls.Utils.eupaBuilders.enums.Boolean;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "application",
        "firstName",
        "familyName",
        "hasEmail",
        "username",
        "emailAddress",
        "birthDate"
})
public class TransportManagerModel {

    @JsonProperty("application")
    private String application;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("familyName")
    private String familyName;
    @JsonProperty("hasEmail")
    private String hasEmail;
    @JsonProperty("username")
    private String username;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("birthDate")
    private String birthDate;

    @JsonProperty("application")
    public String getApplication() {
        return application;
    }

    @JsonProperty("application")
    public void setApplication(String application) {
        this.application = application;
    }

    public TransportManagerModel withApplication(String application) {
        this.application = application;
        return this;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public TransportManagerModel withFirstName(String firstName) {
        this.firstName = firstName;
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

    public TransportManagerModel withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    @JsonProperty("hasEmail")
    public String getHasEmail() {
        return hasEmail;
    }

    @JsonProperty("hasEmail")
    public void setHasEmail(Boolean hasEmail) {
        this.hasEmail = hasEmail.toString();
    }

    public TransportManagerModel withHasEmail(Boolean hasEmail) {
        this.hasEmail = hasEmail.toString();
        return this;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public TransportManagerModel withUsername(String username) {
        this.username = username;
        return this;
    }

    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public TransportManagerModel withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public TransportManagerModel withBirthDate(int year, int month, int date) {
        this.birthDate = String.format("%d-%d-%d", year, month, date);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("application", getApplication())
                .append("firstName", getFirstName())
                .append("familyName", getFamilyName())
                .append("hasEmail", getEmailAddress())
                .append("username", getUsername())
                .append("emailAddress", getEmailAddress())
                .append("birthDate", getBirthDate())
                .toString();
    }
    
}
