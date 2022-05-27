package apiCalls.eupaActions.internal;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.generic.Utils;
import apiCalls.actions.AccessToken;
import apiCalls.enums.UserRoles;
import apiCalls.eupaActions.BaseAPI;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

public class LicenceAPI extends BaseAPI {

    private static final String baseResource = "licence/";
    private static ValidatableResponse response;
    private static String apiHeader = Utils.config.getString("apiHeader");

    public static String licenceNumber(@NotNull String licenceId){
        updateHeader( "Authorization", "Bearer " + AccessToken.getToken(Utils.config.getString("adminUser"), Utils.config.getString("adminPassword"), UserRoles.INTERNAL.asString()));

        String env = Properties.get("env", true);
        URL.build(EnvironmentType.getEnum(env), baseResource.concat(licenceId));

        response = RestUtils.get(String.valueOf(URL.getURL()), getHeaders());

        prettyPrintJson(response.extract().asString());

        response.statusCode(HttpStatus.SC_OK);
        return response.extract().path("licNo");
    }
}
