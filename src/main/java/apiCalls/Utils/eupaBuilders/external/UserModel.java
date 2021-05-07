package apiCalls.Utils.eupaBuilders.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import apiCalls.Utils.eupaBuilders.enums.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "userType",
        "loginId",
        "pid",
        "translateToWelsh",
        "organisationUsers",
        "permission"
})
public class UserModel {

    @JsonProperty("userType")
    private String userType;
    @JsonProperty("accountDisabled")
    private Boolean accountDisabled;
    @JsonProperty("loginId")
    private String loginId;
    @JsonProperty("pid")
    private String pid;
    @JsonProperty("translateToWelsh")
    private Boolean translateToWelsh;
    @JsonProperty("organisationUsers")
    private List<OrganisationUserModel> organisationUsersModel = null;
    @JsonProperty("permission")
    private String permission;

    @JsonProperty("userType")
    public String getUserType() {
        return userType;
    }

    @JsonProperty("userType")
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UserModel withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    @JsonProperty("accountDisabled")
    public Boolean getAccountDisabled() {
        return accountDisabled;
    }

    @JsonProperty("accountDisabled")
    public void setAccountDisabled(Boolean accountDisabled) {
        this.accountDisabled = accountDisabled;
    }

    public UserModel withAccountDisabled(Boolean accountDisabled) {
        setAccountDisabled(accountDisabled);
        return this;
    }

    @JsonProperty("loginId")
    public String getLoginId() {
        return loginId;
    }

    @JsonProperty("loginId")
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public UserModel withLoginId(String loginId) {
        this.loginId = loginId;
        return this;
    }

    @JsonProperty("pid")
    public String getPid() {
        return pid;
    }

    @JsonProperty("pid")
    public void setPid(String pid) {
        this.pid = pid;
    }

    public UserModel withPid(String pid) {
        this.pid = pid;
        return this;
    }

    @JsonProperty("translateToWelsh")
    public Boolean getTranslateToWelsh() {
        return translateToWelsh;
    }

    @JsonProperty("translateToWelsh")
    public void setTranslateToWelsh(Boolean translateToWelsh) {
        this.translateToWelsh = translateToWelsh;
    }

    public UserModel withTranslateToWelsh(Boolean translateToWelsh) {
        this.translateToWelsh = translateToWelsh;
        return this;
    }

    @JsonProperty("organisationUsers")
    public List<OrganisationUserModel> getOrganisationUserModels() {
        return organisationUsersModel;
    }

    @JsonProperty("organisationUsers")
    public void setOrganisationUserModels(List<OrganisationUserModel> organisationUsersModel) {
        this.organisationUsersModel = organisationUsersModel;
    }

    public UserModel withOrganisationUsers(List<OrganisationUserModel> organisationUsersModel) {
        this.organisationUsersModel = organisationUsersModel;
        return this;
    }

    @JsonProperty("permission")
    public String getPermission() {
        return permission;
    }

    @JsonProperty("permission")
    public void setPermission(String permission) {
        this.permission = permission;
    }

    public UserModel withPermission(String permission) {
        this.permission = permission;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("userType", userType)
                .append("loginId", loginId)
                .append("pid", pid)
                .append("translateToWelsh", translateToWelsh)
                .append("organisationUsers", organisationUsersModel)
                .append("permission", permission)
                .toString();
    }

}