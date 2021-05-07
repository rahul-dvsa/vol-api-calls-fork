package apiCalls.eupaActions.util;

import java.net.URL;

public class Utils {

    public static String removeLastSlash(URL url) {
        return removeLastSlash(url.toString());
    }

    public static String removeLastSlash(String url) {
        if (url.endsWith("/")) {
            int size = url.length();
            return url.substring(0, size - 1);
        }

        return url;
    }

}
