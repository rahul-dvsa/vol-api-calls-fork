package apiCalls.actions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;

import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import apiCalls.Utils.volBuilders.TokenRequestBuilder;
import apiCalls.enums.UserType;
import io.restassured.response.ValidatableResponse;

import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;


import javax.xml.ws.http.HTTPException;

public class GetUserDetails {

    private String pid;
    private String organisationId;

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

    private EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    private ValidatableResponse apiResponse;
    private Headers apiHeaders = new Headers();

    public ValidatableResponse getUserDetails(String username, String password, String userType) {
        String userDetailsResource;
        GetJWTToken jwtToken = new GetJWTToken();
        String token = jwtToken.getAPIToken(username,password,userType);
        apiHeaders.getHeaders().put("Authorization",token);

        RegisterUser user = new RegisterUser();

        if (userType.equals(UserType.EXTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType,user.getUserId())).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
            setPid(apiResponse.extract().jsonPath().getString("pid"));
            setOrganisationId(apiResponse.extract().jsonPath().prettyPeek().getString("organisationUsers.organisation.id"));
        } else if (userType.equals(UserType.INTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, user.getUserId())).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
        }

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }
}