package apiCalls.actions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;

import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import apiCalls.Utils.s3.Configuration;
import apiCalls.enums.Realm;
import apiCalls.enums.UserType;
import io.restassured.response.ValidatableResponse;

import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

import static org.dvsa.testing.lib.url.utils.EnvironmentType.DAILY_ASSURANCE;


public class GetUserDetails {

    private String jwtToken;
    private String pid;
    private String organisationId;

    private final EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    private ValidatableResponse apiResponse;

    public ValidatableResponse getUserDetails(String userType, String userId, String emailAddress) {
        String userDetailsResource;
        Headers apiHeaders = new Headers();

        if (env == DAILY_ASSURANCE) {
            apiHeaders
                    .headers
                    .put("Authorization", "Bearer " + AccessToken.getToken(Utils.config.getString("adminUser"), Utils.config.getString("adminPassword"), UserType.INTERNAL.asString()));
        } else {
            apiHeaders.getHeaders().put("x-pid", Utils.config.getString("apiHeader"));
        }

        if (userType.equals(UserType.EXTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
            if (env == DAILY_ASSURANCE) {
                setJwtToken(AccessToken.getToken(userId, Configuration.getTempPassword(emailAddress), Realm.SELF_SERVE.asString()));
            } else {
                setPid(apiResponse.extract().jsonPath().getString("pid"));
            }
            setOrganisationId(apiResponse.extract().jsonPath().prettyPeek().getString("organisationUsers.organisation.id"));
        } else if (userType.equals(UserType.INTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
        }
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }
}