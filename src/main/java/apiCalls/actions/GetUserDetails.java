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
import org.jetbrains.annotations.NotNull;


import javax.xml.ws.http.HTTPException;

public class GetUserDetails {


    private String jwtToken;
    private String pid;
    private String organisationId;

    public void setJwtToken(String jwtToken){
        this.jwtToken = jwtToken;
    }

    public String getJwtToken(){
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

    private final EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    private ValidatableResponse apiResponse;

    public ValidatableResponse getUserDetails(@NotNull String username, @NotNull String password, String userType, String userId) {
        String userDetailsResource;
        Headers apiHeaders = new Headers();
        GetJWTToken jwtToken = new GetJWTToken();
        RegisterUser user = new RegisterUser();


        apiHeaders.headers.put("Authorization",jwtToken.getAPIToken(Utils.config.getString("adminUser"),Utils.config.getString("adminPassword"),UserType.INTERNAL.asString()));

        if (userType.equals(UserType.EXTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType,userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
            String token = jwtToken.getAPIToken(username,password,UserType.EXTERNAL.asString());
            setJwtToken(token);
            setOrganisationId(apiResponse.extract().jsonPath().prettyPeek().getString("organisationUsers.organisation.id"));
        } else if (userType.equals(UserType.INTERNAL.asString())) {
            userDetailsResource = URL.build(env, String.format("user/%s/%s", userType, userId)).toString();
            apiResponse = RestUtils.get(userDetailsResource, apiHeaders.getHeaders());
        }
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }
}