package Utils;

import Utils.Builders.ContactDetailsBuilder;
import Utils.Builders.PersonBuilder;
import Utils.Builders.SelfServeUserRegistrationDetailsBuilder;
import activesupport.http.RestUtils;

import activesupport.system.Properties;
import enums.UserRoles;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.*;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

import javax.xml.ws.http.HTTPException;

import static Utils.Headers.getHeaders;

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

    public void registerUser() {
        setTitle(getTitle());
        setForeName(getForeName());
        setFamilyName(getFamilyName());
        String registerResource = URL.build(env, "user/selfserve/register").toString();
        Headers.headers.put("api", "dvsa");
        setLoginId(getLoginId());

        PersonBuilder personBuilder = new PersonBuilder().withTitle(getTitle()).withForename(getForeName()).withFamilyName(getFamilyName()).withBirthDate(getBirthDate());
        ContactDetailsBuilder contactDetailsBuilder = new ContactDetailsBuilder().withEmailAddress(getEmailAddress()).withPerson(personBuilder);

        SelfServeUserRegistrationDetailsBuilder selfServeUserRegistrationDetailsBuilder = new SelfServeUserRegistrationDetailsBuilder().withLoginId(getLoginId()).withContactDetails(contactDetailsBuilder)
                .withOrganisationName(getOrganisationName()).withBusinessType(getBusinessType());

        apiResponse = RestUtils.post(selfServeUserRegistrationDetailsBuilder, registerResource, getHeaders());

        if (apiResponse.extract().statusCode() != HttpStatus.SC_CREATED) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        } else {
            userId = apiResponse.extract().jsonPath().getString("id.user");
        }
    }

    public ValidatableResponse getUserDetails(String userType, String userId, String header) {
        String userDetailsResource;
        Headers.headers.put("x-pid", header);

        if (userType.equals(UserRoles.EXTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, this.userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, getHeaders());
            setPid(apiResponse.extract().jsonPath().getString("pid"));
            setOrganisationId(apiResponse.extract().jsonPath().prettyPeek().getString("organisationUsers.organisation.id"));
        } else if (userType.equals(UserRoles.INTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, getHeaders());
        }

        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }
}