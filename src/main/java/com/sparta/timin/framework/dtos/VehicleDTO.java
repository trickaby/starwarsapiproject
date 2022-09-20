package com.sparta.timin.framework.dtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cargo_capacity",
        "consumables",
        "cost_in_credits",
        "created",
        "crew",
        "edited",
        "length",
        "manufacturer",
        "max_atmosphering_speed",
        "model",
        "name",
        "passengers",
        "pilots",
        "films",
        "url",
        "vehicle_class"
})
public class VehicleDTO extends StarWarsDTO {

    public VehicleDTO() {}

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;
    @JsonProperty("consumables")
    private String consumables;
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    @JsonProperty("created")
    private String created;
    @JsonProperty("crew")
    private String crew;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("length")
    private String length;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @JsonProperty("model")
    private String model;
    @JsonProperty("name")
    private String name;
    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("url")
    private String url;
    @JsonProperty("vehicle_class")
    private String vehicleClass;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("cargo_capacity")
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    @JsonProperty("cargo_capacity")
    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @JsonProperty("consumables")
    public String getConsumables() {
        return consumables;
    }

    @JsonProperty("consumables")
    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    @JsonProperty("cost_in_credits")
    public String getCostInCredits() {
        return costInCredits;
    }

    @JsonProperty("cost_in_credits")
    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("crew")
    public String getCrew() {
        return crew;
    }

    @JsonProperty("crew")
    public void setCrew(String crew) {
        this.crew = crew;
    }

    @JsonProperty("edited")
    public String getEdited() {
        return edited;
    }

    @JsonProperty("edited")
    public void setEdited(String edited) {
        this.edited = edited;
    }

    @JsonProperty("length")
    public String getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(String length) {
        this.length = length;
    }

    @JsonProperty("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty("max_atmosphering_speed")
    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    @JsonProperty("max_atmosphering_speed")
    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("passengers")
    public String getPassengers() {
        return passengers;
    }

    @JsonProperty("passengers")
    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("vehicle_class")
    public String getVehicleClass() {
        return vehicleClass;
    }

    @JsonProperty("vehicle_class")
    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
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