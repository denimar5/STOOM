
package com.stoom.br.client;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "long_name",
    "short_name",
    "types"
})
public class AddressComponent {

    @JsonProperty("long_name")
    private String longName;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("types")
    private List<String> types = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AddressComponent() {
    }

    /**
     * 
     * @param types
     * @param shortName
     * @param longName
     */
    public AddressComponent(String longName, String shortName, List<String> types) {
        super();
        this.longName = longName;
        this.shortName = shortName;
        this.types = types;
    }

    @JsonProperty("long_name")
    public String getLongName() {
        return longName;
    }

    @JsonProperty("long_name")
    public void setLongName(String longName) {
        this.longName = longName;
    }

    @JsonProperty("short_name")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("short_name")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
    }

}
