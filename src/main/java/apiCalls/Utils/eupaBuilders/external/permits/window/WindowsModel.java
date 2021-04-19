package apiCalls.Utils.eupaBuilders.external.permits.window;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "windows"
})
public class WindowsModel {

    @JsonProperty("windows")
    private List<WindowModel> windows = null;

    @JsonProperty("windows")
    public List<WindowModel> getWindows() {
        return windows;
    }

    @JsonProperty("windows")
    public void setWindows(List<WindowModel> windows) {
        this.windows = windows;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("windows", windows).toString();
    }
    
}
