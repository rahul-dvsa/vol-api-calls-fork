package apiCalls.actions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.generic.Utils;
import apiCalls.Utils.volBuilders.TokenRequestBuilder;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

import java.util.HashMap;

public class AccessToken {

    EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));

    public String getToken(String username, String password, String realm) {
        String jwtTokenResource;
        HashMap<String, String> header = new HashMap<>();

        jwtTokenResource = URL.build(env).toString().concat("auth/login");
        TokenRequestBuilder tokenBody = new TokenRequestBuilder().withUsername(username).withPassword(password).withRealm(realm);
        ValidatableResponse tokenResponse = RestUtils.post(tokenBody, jwtTokenResource, header);

        Utils.checkHTTPStatusCode(tokenResponse, HttpStatus.SC_CREATED);

        return tokenResponse.extract().body().jsonPath().getString("flags.identity.Token.access_token");
    }
}