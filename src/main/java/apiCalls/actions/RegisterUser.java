package apiCalls.actions;

import activesupport.faker.FakerUtils;
import activesupport.number.Int;
import apiCalls.Utils.builders.ContactDetailsBuilder;
import apiCalls.Utils.builders.PersonBuilder;
import apiCalls.Utils.builders.SelfServeUserRegistrationDetailsBuilder;
import apiCalls.Utils.generic.Headers;
import activesupport.http.RestUtils;

import activesupport.system.Properties;

import apiCalls.enums.BusinessType;
import apiCalls.enums.UserTitle;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.*;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;


import javax.xml.ws.http.HTTPException;


public class RegisterUser {

    private String title;
    private String foreName;
    private String familyName;
    private String loginId;
    private String birthDate;
    private String emailAddress;
    private String organisationName;
    private String businessType;
    private String userId;
    private String pid;
    private String organisationId;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getForeName() {
        return foreName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    private static final Logger LOGGER = LogManager.getLogger(RegisterUser.class);

    private EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    private ValidatableResponse apiResponse;

    private Headers apiHeaders = new Headers();

    public RegisterUser() {
        FakerUtils faker = new FakerUtils();
        String firstName = faker.generateFirstName().concat(String.valueOf(Int.random(100, 999)));
        String lastName = faker.generateLastName().concat(String.valueOf(Int.random(100, 999)));
        String dateOfBirth = Int.random(1900, 2018) + "-" + Int.random(1, 12) + "-" + Int.random(1, 28);
        String loginName = String.format("%s.%s%s", firstName, lastName, Int.random(1000,9999));
        String email = String.format("%s_%s%s.tester@dvsa.com", firstName, lastName, Int.random(10000, 99999));

        this.loginId = loginId == null ? loginName : getLoginId();
        this.title = title == null ? UserTitle.MR.asString() : getTitle();
        this.emailAddress = emailAddress == null ? email : getEmailAddress();
        this.foreName = foreName == null ? firstName : getForeName();
        this.familyName = familyName == null ? lastName : getFamilyName();
        this.organisationName = organisationName == null ? faker.generateCompanyName() : getOrganisationName();
        this.businessType = businessType == null ? BusinessType.LIMITED_COMPANY.asString() : getBusinessType();
        this.birthDate = birthDate == null ? dateOfBirth : getBirthDate();
    }

    public ValidatableResponse registerUser() {
        String registerResource = URL.build(env, "user/selfserve/register").toString();
        apiHeaders.getHeaders().put("api", "dvsa");

        PersonBuilder personBuilder = new PersonBuilder().withTitle(getTitle()).withForename(getForeName()).withFamilyName(getFamilyName()).withBirthDate(getBirthDate());
        ContactDetailsBuilder contactDetailsBuilder = new ContactDetailsBuilder().withEmailAddress(getEmailAddress()).withPerson(personBuilder);

        SelfServeUserRegistrationDetailsBuilder selfServeUserRegistrationDetailsBuilder = new SelfServeUserRegistrationDetailsBuilder().withLoginId(getLoginId()).withContactDetails(contactDetailsBuilder)
                .withOrganisationName(getOrganisationName()).withBusinessType(getBusinessType());

        apiResponse = RestUtils.post(selfServeUserRegistrationDetailsBuilder, registerResource, apiHeaders.getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        } else {
            userId = apiResponse.extract().jsonPath().getString("id.user");
        }
        return apiResponse;
    }
}