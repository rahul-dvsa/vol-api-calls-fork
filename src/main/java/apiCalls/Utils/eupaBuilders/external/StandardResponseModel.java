package apiCalls.Utils.eupaBuilders.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "messages",
        "id"
})
public class StandardResponseModel {

    @JsonProperty("messages")
    private List<String> messages = null;
    @JsonProperty("id")
    private IdModel id;

    @JsonProperty("messages")
    public List<String> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public StandardResponseModel withMessages(List<String> messages) {
        this.messages = messages;
        return this;
    }

    @JsonProperty("id")
    public IdModel getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(IdModel id) {
        this.id = id;
    }

    public StandardResponseModel withId(IdModel id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("messages", messages)
                .append("id", id)
                .toString();
    }

}