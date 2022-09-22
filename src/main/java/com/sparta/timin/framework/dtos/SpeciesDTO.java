package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "average_height",
        "average_lifespan",
        "classification",
        "created",
        "designation",
        "edited",
        "eye_colors",
        "hair_colors",
        "homeworld",
        "language",
        "name",
        "people",
        "films",
        "skin_colors",
        "url"
})
public class SpeciesDTO extends StarWarsDTO {

    public SpeciesDTO() {}

    @JsonProperty("average_height")
    private String averageHeight;
    @JsonProperty("average_lifespan")
    private String averageLifespan;
    @JsonProperty("classification")
    private String classification;
    @JsonProperty("created")
    private String created;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("eye_colors")
    private String eyeColors;
    @JsonProperty("hair_colors")
    private String hairColors;
    @JsonProperty("language")
    private String language;
    @JsonProperty("name")
    private String name;
    @JsonProperty("skin_colors")
    private String skinColors;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("average_height")
    public String getAverageHeight() {
        return averageHeight;
    }

    @JsonProperty("average_height")
    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    @JsonProperty("average_lifespan")
    public String getAverageLifespan() {
        return averageLifespan;
    }

    @JsonProperty("average_lifespan")
    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    @JsonProperty("classification")
    public String getClassification() {
        return classification;
    }

    @JsonProperty("classification")
    public void setClassification(String classification) {
        this.classification = classification;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("designation")
    public String getDesignation() {
        return designation;
    }

    @JsonProperty("designation")
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @JsonProperty("edited")
    public String getEdited() {
        return edited;
    }

    @JsonProperty("edited")
    public void setEdited(String edited) {
        this.edited = edited;
    }

    @JsonProperty("eye_colors")
    public String getEyeColors() {
        return eyeColors;
    }

    @JsonProperty("eye_colors")
    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    @JsonProperty("hair_colors")
    public String getHairColors() {
        return hairColors;
    }

    @JsonProperty("hair_colors")
    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("skin_colors")
    public String getSkinColors() {
        return skinColors;
    }

    @JsonProperty("skin_colors")
    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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