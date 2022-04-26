package apiCalls.actions;

import activesupport.http.RestUtils;
import apiCalls.Utils.generic.BaseAPI;
import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import apiCalls.enums.UserRoles;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;


public class InternalDetails extends BaseAPI {

    private final Headers apiHeaders = new Headers();

    public InternalDetails () {
        apiHeaders.getHeaders().put("Authorization", "Bearer " + AccessToken.getToken(Utils.config.getString("adminUser"),Utils.config.getString("adminPassword"), UserRoles.INTERNAL.asString()));
    }


    public ValidatableResponse getFinancialStandingRates () {
        String financialStandingRateEndpoint = URL.build(env, "financial-standing-rate").toString();
        ValidatableResponse apiResponse = RestUtils.get(financialStandingRateEndpoint, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }
}
