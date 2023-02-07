package apiCalls.actions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.generic.BaseAPI;
import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import apiCalls.enums.UserRoles;
import io.restassured.response.ValidatableResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

import java.util.HashMap;

public class InternalDetails {

    private final AccessToken accessToken = new AccessToken();
    private final Headers apiHeaders = new Headers();

    EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));
    public HashMap<String, String> header() throws HttpException {
        String header = accessToken.getToken(Utils.config.getString("adminUser"), Utils.config.getString("adminPassword"), UserRoles.INTERNAL.asString());
        apiHeaders.getHeaders().put("Authorization", "Bearer " + header);
        return apiHeaders.headers;
    }

    public ValidatableResponse getFinancialStandingRates () throws HttpException {
        String financialStandingRateEndpoint = URL.build(env, "financial-standing-rate").toString();
        ValidatableResponse apiResponse = RestUtils.get(financialStandingRateEndpoint, header());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }
}