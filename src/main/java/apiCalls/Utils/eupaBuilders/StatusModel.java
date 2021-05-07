package apiCalls.Utils.eupaBuilders;

import apiCalls.Utils.eupaBuilders.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "description"
})
public class StatusModel {

    @JsonProperty("description")
    private Status status;

    @JsonProperty("description")
    public Status getDescription() {
        return status;
    }

    @JsonProperty("description")
    public void setDescription(Status description) {
        this.status = description;
    }

    public StatusModel withDescription(Status description) {
        this.status = description;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("description", status).toString();
    }

}