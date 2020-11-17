package apiCalls.Utils.generic;

import activesupport.MissingRequiredArgument;
import activesupport.http.RestUtils;
import activesupport.system.Properties;
import io.restassured.response.ValidatableResponse;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

public class BaseAPI {

    protected EnvironmentType env;

    public BaseAPI() {
        try {
            env = EnvironmentType.getEnum(Properties.get("env", true));
        } catch (MissingRequiredArgument missingRequiredArgument) {
            missingRequiredArgument.printStackTrace();
        }
    }

    public String fetchApplicationInformation(String applicationNumber, String jsonPath, String defaultReturn) {
        String url = URL.build(env, String.format("application/%s/overview/", applicationNumber)).toString();
        return retrieveAPIData(url, jsonPath, defaultReturn);
    }

    public String fetchTMApplicationInformation(String applicationNumber, String jsonPath, String defaultReturn) {
        String url = URL.build(env, String.format("transport-manager-application/%s", applicationNumber)).toString();
        return retrieveAPIData(url, jsonPath, defaultReturn);
    }

    public String fetchInternalUserInformation(String userId, String jsonPath, String defaultReturn){
        String url = URL.build(env, String.format("user/internal/%s", userId)).toString();
        return retrieveAPIData(url, jsonPath, defaultReturn);
    }

    public static String retrieveAPIData(String url, String jsonPath, String defaultReturn) {
        Headers headers = new Headers();
        headers.headers.put("x-pid", Headers.getAPI_HEADER());
        ValidatableResponse response = RestUtils.get(url, headers.getHeaders());
        try {
            return response.extract().response().jsonPath().getString(jsonPath);
        } catch (NullPointerException ne) {
            return defaultReturn;
        }
    }
}