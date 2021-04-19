package apiCalls.Utils.eupaBuilders.internal;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "duePeriod",
        "caseworkerNotes",
        "grantAuthority"
})
public class GrantApplicationModel {
    @JsonProperty("id")
    private String id;
    @JsonProperty("duePeriod")
    private String duePeriod;
    @JsonProperty("caseworkerNotes")
    private String caseworkerNotes;
    @JsonProperty("grantAuthority")
    private String grantAuthority;
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    public GrantApplicationModel withId(String id) {
        this.id = id;
        return this;
    }
    @JsonProperty("duePeriod")
    public String getDuePeriod() {
        return duePeriod;
    }
    @JsonProperty("duePeriod")
    public void setDuePeriod(String duePeriod) {
        this.duePeriod = duePeriod;
    }
    public GrantApplicationModel withDuePeriod(String duePeriod) {
        this.duePeriod = duePeriod;
        return this;
    }
    @JsonProperty("caseworkerNotes")
    public String getCaseworkerNotes() {
        return caseworkerNotes;
    }
    @JsonProperty("caseworkerNotes")
    public void setCaseworkerNotes(String caseworkerNotes) {
        this.caseworkerNotes = caseworkerNotes;
    }
    public GrantApplicationModel withCaseworkerNotes(String caseworkerNotes) {
        this.caseworkerNotes = caseworkerNotes;
        return this;
    }
    @JsonProperty("grantAuthority")
    public String getGrantAuthority() {
        return grantAuthority;
    }
    @JsonProperty("grantAuthority")
    public void setGrantAuthority(String grantAuthority) {
        this.grantAuthority = grantAuthority;
    }
    public GrantApplicationModel withAuthority(String grantAuthority){
        this.grantAuthority = grantAuthority;
        return this;
    }
    @Override
    public String toString() {
        return "id:" + getId() + ",duePeriod:" + getDuePeriod() + ",caseworkerNotes:" + getCaseworkerNotes()
                + ",grantAuthority:" + getGrantAuthority();
    }
}