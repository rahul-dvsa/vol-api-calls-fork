package apiCalls.eupaActions;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.generic.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseAPI {

    private static Map<String, String> headers = new HashMap<>();
    private static String apiHeader = Utils.config.getString("apiHeader");

    static {
        RestUtils.urlEncoding(false);
        URL.build(EnvironmentType.getEnum(Properties.get("env", true)));
        // TODO: Investigate how to retrieve this value from the system.
        setHeader("x-pid", apiHeader);
        setHeader("api", "dvsa");
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
            System.out.print("\nRESPONSE:\n");
            System.out.println(gson.toJson(jp.parse(jsonString)));
        } catch (Exception ex) {}
    }

}
