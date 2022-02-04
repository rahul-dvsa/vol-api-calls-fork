package apiCalls.actions;

import activesupport.http.RestUtils;
import apiCalls.Utils.generic.BaseAPI;
import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;


public class InternalDetails extends BaseAPI {

    private final Headers apiHeaders = new Headers();

    public InternalDetails () {
        apiHeaders.headers.put("x-pid", Utils.config.getString("apiHeader"));
    }

    public ValidatableResponse getFinancialStandingRates () {
        String financialStandingRateEndpoint = URL.build(env, "financial-standing-rate").toString();
        ValidatableResponse apiResponse = RestUtils.get(financialStandingRateEndpoint, apiHeaders.getHeaders());

        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }
}
