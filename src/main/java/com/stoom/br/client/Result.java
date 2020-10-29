
package com.stoom.br.client;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address_components",
    "formatted_address",
    "geometry",
    "place_id",
    "plus_code",
    "types"
})
public class Result {

    @JsonProperty("address_components")
    private List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("plus_code")
    private PlusCode plusCode;
    @JsonProperty("types")
    private List<String> types = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param types
     * @param formattedAddress
     * @param plusCode
     * @param addressComponents
     * @param placeId
     * @param geometry
     */
    public Result(List<AddressComponent> addressComponents, String formattedAddress, Geometry geometry, String placeId, PlusCode plusCode, List<String> types) {
        super();
        this.addressComponents = addressComponents;
        this.formattedAddress = formattedAddress;
        this.geometry = geometry;
        this.placeId = placeId;
        this.plusCode = plusCode;
        this.types = types;
    }

    @JsonProperty("address_components")
    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    @JsonProperty("address_components")
    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    @JsonProperty("formatted_address")
    public String getFormattedAddress() {
        return formattedAddress;
    }

    @JsonProperty("formatted_address")
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("place_id")
    public String getPlaceId() {
        return placeId;
    }

    @JsonProperty("place_id")
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @JsonProperty("plus_code")
    public PlusCode getPlusCode() {
        return plusCode;
    }

    @JsonProperty("plus_code")
    public void setPlusCode(PlusCode plusCode) {
        this.plusCode = plusCode;
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
