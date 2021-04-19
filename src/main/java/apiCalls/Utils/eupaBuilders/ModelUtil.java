package apiCalls.Utils.eupaBuilders;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public class ModelUtil {

    public static Integer defaultVersion(@NotNull String version) {
        return StringUtils.isEmpty(version) ? 1 : Integer.valueOf(version);
    }

}
