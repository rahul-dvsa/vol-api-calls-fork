package apiCalls.Utils.eupaBuilders;

import apiCalls.Utils.eupaBuilders.enums.permits.Section;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "checkedAnswers",
        "declaration",
        "totalSections",
        "totalCompleted",
        "allCompleted"
})
public class ConfirmationSectionCompletionModel {

    @JsonProperty("checkedAnswers")
    private Section checkedAnswers;
    @JsonProperty("declaration")
    private Section declaration;
    @JsonProperty("totalSections")
    private Integer totalSections;
    @JsonProperty("totalCompleted")
    private Integer totalCompleted;
    @JsonProperty("allCompleted")
    private Boolean allCompleted;

    @JsonProperty("checkedAnswers")
    public Section getCheckedAnswers() {
        return checkedAnswers;
    }

    @JsonProperty("checkedAnswers")
    public void setCheckedAnswers(Section checkedAnswers) {
        this.checkedAnswers = checkedAnswers;
    }

    public ConfirmationSectionCompletionModel withCheckedAnswers(Section checkedAnswers) {
        this.checkedAnswers = checkedAnswers;
        return this;
    }

    @JsonProperty("declaration")
    public Section getDeclaration() {
        return declaration;
    }

    @JsonProperty("declaration")
    public void setDeclaration(Section declaration) {
        this.declaration = declaration;
    }

    public ConfirmationSectionCompletionModel withDeclaration(Section declaration) {
        this.declaration = declaration;
        return this;
    }

    @JsonProperty("totalSections")
    public Integer getTotalSections() {
        return totalSections;
    }

    @JsonProperty("totalSections")
    public void setTotalSections(Integer totalSections) {
        this.totalSections = totalSections;
    }

    public ConfirmationSectionCompletionModel withTotalSections(Integer totalSections) {
        this.totalSections = totalSections;
        return this;
    }

    @JsonProperty("totalCompleted")
    public Integer getTotalCompleted() {
        return totalCompleted;
    }

    @JsonProperty("totalCompleted")
    public void setTotalCompleted(Integer totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    public ConfirmationSectionCompletionModel withTotalCompleted(Integer totalCompleted) {
        this.totalCompleted = totalCompleted;
        return this;
    }

    @JsonProperty("allCompleted")
    public Boolean getAllCompleted() {
        return allCompleted;
    }

    @JsonProperty("allCompleted")
    public void setAllCompleted(Boolean allCompleted) {
        this.allCompleted = allCompleted;
    }

    public ConfirmationSectionCompletionModel withAllCompleted(Boolean allCompleted) {
        this.allCompleted = allCompleted;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("checkedAnswers", checkedAnswers)
                .append("declaration", declaration)
                .append("totalSections", totalSections)
                .append("totalCompleted", totalCompleted)
                .append("allCompleted", allCompleted)
                .toString();
    }

}
