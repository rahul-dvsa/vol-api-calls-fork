package Utils.generic;

import activesupport.config.Configuration;
import com.typesafe.config.Config;

import java.util.HashMap;

public class Headers {

    private Config config = new Configuration().getConfig();

    private String API_HEADER = config.getString("api.header");

    public HashMap<String, String> headers = new HashMap<>();

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public String getAPI_HEADER() {
        return API_HEADER;
    }
}