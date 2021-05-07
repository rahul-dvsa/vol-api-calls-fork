package apiCalls.eupaActions.internal;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.eupaBuilders.external.StandardResponseModel;
import apiCalls.Utils.eupaBuilders.internal.GrantApplicationModel;
import apiCalls.Utils.eupaBuilders.internal.OverviewModel;
import apiCalls.Utils.generic.Utils;
import apiCalls.eupaActions.BaseAPI;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

public class CaseWorkerAPI extends BaseAPI {

    private static ValidatableResponse response;
    private static String apiHeader = Utils.config.getString("apiHeader");

    public static void overview(@NotNull OverviewModel overview) {
        String oldXPID = getHeader("x-pid"); // Needed as other calls might expect an external x-pid
        updateHeader("x-pid", apiHeader);
        URL.build(EnvironmentType.getEnum(Properties.get("env", true)), String.format("application/%s/overview/", overview.getApplicationId()));
        Integer version = 1;

        do {
            if (overview.getVersion() == null)
                overview.setVersion(version);

            response = RestUtils.put(overview, URL.getURL().toString(), getHeaders());

            if (response.extract().statusCode() == HttpStatus.SC_CONFLICT)
                overview.setVersion(++version);

        } while (response.extract().statusCode() == HttpStatus.SC_CONFLICT && version <= 20);

        System.out.print("\n\nRESPONSE:\n\n");
        prettyPrintJson(response.extract().asString());

        response.statusCode(HttpStatus.SC_OK);
        updateHeader("x-pid", oldXPID);
    }

    public static StandardResponseModel grantApplication(@NotNull GrantApplicationModel grantApplication) {
        String oldXPID = getHeader("x-pid"); // Needed as other calls might expect an external x-pid
        updateHeader("x-pid", apiHeader);
        URL.build(EnvironmentType.getEnum(Properties.get("env", true)), String.format("application/%s/grant/", grantApplication.getId()));

        response = RestUtils.put(grantApplication, String.valueOf(URL.getURL()), getHeaders());

        System.out.print("\n\nRESPONSE:\n\n");
        prettyPrintJson(response.extract().asString());

        response.statusCode(HttpStatus.SC_OK);
        updateHeader("x-pid", oldXPID);
        return response.extract().body().as(StandardResponseModel.class);
    }

}
