package apiCalls.Utils.generic;

import java.util.HashMap;

public class Headers {

    private String API_HEADER;

    public HashMap<String, String> headers = new HashMap<>();

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public String getAPI_HEADER() {
        return API_HEADER;
    }

    public void setAPI_HEADER(String API_HEADER) {
        this.API_HEADER = API_HEADER;
    }
}