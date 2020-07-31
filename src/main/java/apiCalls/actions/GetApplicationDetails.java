package apiCalls.actions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.generic.Headers;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.apache.logging.log4j.Logger;


import javax.xml.ws.http.HTTPException;


public class GetApplicationDetails {

    private ValidatableResponse apiResponse;
    private Headers apiHeaders = new Headers();

    private String applicationNumber;
    private EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));
    private static Logger LOGGER = LogManager.getLogger(GetApplicationDetails.class);

    public ValidatableResponse getApplicationLicenceDetails() {
        String getApplicationResource = URL.build(env, String.format("application/%s", applicationNumber)).toString();
        apiResponse = RestUtils.get(getApplicationResource, apiHeaders.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }
}