package apiCalls.actions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;

import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import apiCalls.enums.Realm;
import apiCalls.enums.UserType;
import io.restassured.response.ValidatableResponse;

import org.apache.hc.core5.http.HttpException;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;


public class UserDetails extends Token {
    private Headers apiHeaders = new Headers();
    private String jwtToken;

    private String adminToken;
    private String organisationId;

    EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    private ValidatableResponse apiResponse;


    public synchronized ValidatableResponse getUserDetails(String userType, String userId, String username, String password) throws HttpException {
        String userDetailsResource;
        if (getAdminToken() == null) {
            setAdminToken(generateAdminToken());
            apiHeaders
                    .headers
                    .put("Authorization", "Bearer " + getAdminToken());
        }
        if (userType.equals(UserType.EXTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
            setJwtToken(getToken(username, password, Realm.SELF_SERVE.asString()));
            setOrganisationId(apiResponse.extract().jsonPath().prettyPeek().getString("organisationUsers.organisation.id"));
        } else if (userType.equals(UserType.INTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
            setJwtToken(getToken(username, password, Realm.INTERNAL.asString()));
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

    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public String setAdminToken(String token) {
        this.adminToken = token;
        return token;
    }
}