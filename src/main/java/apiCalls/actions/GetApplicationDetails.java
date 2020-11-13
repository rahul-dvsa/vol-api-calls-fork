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

import javax.swing.text.html.HTMLDocument;
import javax.xml.ws.http.HTTPException;

public class GetApplicationDetails {

    private ValidatableResponse apiResponse;

    private String applicationNumber;

    Headers headers = new Headers();

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    private EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));
    private static Logger LOGGER = LogManager.getLogger(GetApplicationDetails.class);

    public ValidatableResponse getApplicationLicenceDetails() {
        String getApplicationResource = URL.build(env, String.format("application/%s", applicationNumber)).toString();
        headers.getHeaders().put("x-pid",Headers.getAPI_HEADER());
        apiResponse = RestUtils.get(getApplicationResource, headers.getHeaders());
        if (apiResponse.extract().statusCode() != HttpStatus.SC_OK) {
            LOGGER.info("ERROR CODE: ".concat(Integer.toString(apiResponse.extract().statusCode())));
            LOGGER.info("RESPONSE MESSAGE: ".concat(apiResponse.extract().response().asString()));
            throw new HTTPException(apiResponse.extract().statusCode());
        }
        return apiResponse;
    }
}