package apiCalls.Utils.volBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "trafficArea"
})
public class PhvTaxiUpdateBuilder {

    @JsonProperty("id")
    private String id;
    @JsonProperty("trafficArea")
    private String trafficArea;


    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public PhvTaxiUpdateBuilder withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("trafficArea")
    public String getTrafficArea() {
        return trafficArea;
    }

    @JsonProperty("trafficArea")
    public void setTrafficArea(String trafficArea) {
        this.trafficArea = trafficArea;
    }

    public PhvTaxiUpdateBuilder withTrafficArea(String trafficArea) {
        this.trafficArea = trafficArea;
        return this;
    }

    @Override
    public String toString() {
        return "id" + getId() + ",trafficArea:" + getTrafficArea();
    }
}