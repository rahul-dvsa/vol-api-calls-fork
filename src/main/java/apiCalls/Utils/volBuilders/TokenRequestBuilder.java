package apiCalls.Utils.volBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.platform.commons.util.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class TokenRequestBuilder {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("realm")
    private String realm;

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public TokenRequestBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public TokenRequestBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    @JsonProperty("realm")
    public String getRealm() {
        return realm;
    }

    @JsonProperty("realm")
    public void setRealm(String realm) {
        this.realm = realm;
    }

    public TokenRequestBuilder withRealm(String realm) {
        this.realm = realm;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
                .append("username", getUsername())
                .append("password", getPassword())
                .append("realm", getRealm())
                .toString();
    }
}