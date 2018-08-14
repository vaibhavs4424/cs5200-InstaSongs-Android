
package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.artists;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "#text",
    "role",
    "searchTerms",
    "startPage"
})
public class OpensearchQuery {

    @JsonProperty("#text")
    private String text;
    @JsonProperty("role")
    private String role;
    @JsonProperty("searchTerms")
    private String searchTerms;
    @JsonProperty("startPage")
    private String startPage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("#text")
    public String getText() {
        return text;
    }

    @JsonProperty("#text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("searchTerms")
    public String getSearchTerms() {
        return searchTerms;
    }

    @JsonProperty("searchTerms")
    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    @JsonProperty("startPage")
    public String getStartPage() {
        return startPage;
    }

    @JsonProperty("startPage")
    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
