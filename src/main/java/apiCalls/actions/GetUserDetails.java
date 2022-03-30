package apiCalls.actions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;

import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import apiCalls.enums.Realm;
import apiCalls.enums.UserType;
import io.restassured.response.ValidatableResponse;

import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;


public class GetUserDetails {

    private String jwtToken;
    private String pid;
    private String organisationId;

    private final EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    private ValidatableResponse apiResponse;


    public ValidatableResponse getUserDetails(String userType, String userId, String username, String password) {
        String userDetailsResource;
        Headers apiHeaders = new Headers();

        apiHeaders
                .headers
                .put("Authorization", "Bearer " + AccessToken.getToken(Utils.config.getString("adminUser"), Utils.config.getString("adminPassword"), UserType.INTERNAL.asString()));

        if (userType.equals(UserType.EXTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
            setJwtToken(AccessToken.getToken(username, password, Realm.SELF_SERVE.asString()));
            setOrganisationId(apiResponse.extract().jsonPath().prettyPeek().getString("organisationUsers.organisation.id"));
        } else if (userType.equals(UserType.INTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
            if ((env == EnvironmentType.DAILY_ASSURANCE) || (env == EnvironmentType.QUALITY_ASSURANCE)) {
                setJwtToken(AccessToken.getToken(username, password, Realm.INTERNAL.asString()));
            } else {
                setPid(apiResponse.extract().jsonPath().getString("pid"));
            }
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