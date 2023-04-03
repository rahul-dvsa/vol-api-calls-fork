package apiCalls.actions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.generic.Headers;
import apiCalls.Utils.generic.Utils;
import apiCalls.enums.UserRoles;
import io.restassured.response.ValidatableResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

public class GetApplicationDetails {

    private final CreateApplication application;
    private String applicationStatus;
    private String licenceId;
    private String licenceNumber;

    private final EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));
    Headers apiHeaders = new Headers();

    public GetApplicationDetails(CreateApplication application) {
        this.application = application;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public synchronized ValidatableResponse getApplicationLicenceDetails() throws HttpException {
        AccessToken accessToken = new AccessToken();
        String getApplicationResource = URL.build(env, String.format("application/%s", application.getApplicationId())).toString();
        apiHeaders.getHeaders().put("Authorization", "Bearer " + accessToken.getToken(Utils.config.getString("adminUser"),Utils.config.getString("adminPassword"), UserRoles.INTERNAL.asString()));
        ValidatableResponse apiResponse = RestUtils.get(getApplicationResource, apiHeaders.getHeaders());
        setLicenceId(apiResponse.extract().jsonPath().getString("licence.id"));
        setLicenceNumber(apiResponse.extract().jsonPath().getString("licence.licNo"));
        setApplicationStatus(apiResponse.extract().jsonPath().getString("licenceType.status.olbsKey"));
        Utils.checkHTTPStatusCode(apiResponse, HttpStatus.SC_OK);

        return apiResponse;
    }
}