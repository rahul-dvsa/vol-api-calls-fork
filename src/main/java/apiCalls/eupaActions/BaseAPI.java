package apiCalls.eupaActions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.generic.Utils;
import apiCalls.actions.AccessToken;
import apiCalls.enums.UserRoles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseAPI {

    private static final Map<String, String> headers = new HashMap<>();

    static {
        AccessToken accessToken = new AccessToken();
        URL.build(EnvironmentType.getEnum(Properties.get("env", true)));
        setHeader( "Authorization", "Bearer " + accessToken.getToken(Utils.config.getString("adminUser"), Utils.config.getString("adminPassword"), UserRoles.INTERNAL.asString()));
    }

    public static Map<String, String> getHeaders() {
        return headers;
    }

    public static void setHeader(@NotNull String header, @NotNull String value) {
        BaseAPI.headers.put(header, value);
    }

    public static String getHeader(@NotNull String header) {
        return BaseAPI.headers.get(header);
    }

    public static void updateHeader(@NotNull String header, @NotNull String value) {
        BaseAPI.headers.replace(header, value);
    }

    protected static void prettyPrintJson(@NotNull String jsonString) {
        Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        try {
            System.out.println(gson.toJson(jp.parse(jsonString)));
        } catch (Exception ex) {}
    }
}
