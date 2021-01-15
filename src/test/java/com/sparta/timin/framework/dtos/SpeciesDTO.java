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
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("language")
    private String language;
    @JsonProperty("name")
    private String name;
    @JsonProperty("people")
    private List<String> people = null;
    @JsonProperty("films")
    private List<String> films = null;
    @JsonProperty("skin_colors")
    private String skinColors;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public boolean doSpeciesListsReturnCorrectLinks(String category) {
        List<String> listToCheck = new ArrayList<>();
        String contentsToCheck;
        switch(category) {
            case "people":
                listToCheck = people;
                contentsToCheck = "people";
                break;
            case "films":
                listToCheck = films;
                contentsToCheck = "planets";
                break;
            default:
                return false;
        }
        if(listToCheck.isEmpty()) {return true;}
        for (String listContents : listToCheck) {
            if(!listContents.contains(contentsToCheck)) {return false;}
        }
        return true;
    }




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

    @JsonProperty("homeworld")
    public String getHomeworld() {
        return homeworld;
    }

    @JsonProperty("homeworld")
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
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

    @JsonProperty("people")
    public List<String> getPeople() {
        return people;
    }

    @JsonProperty("people")
    public void setPeople(List<String> people) {
        this.people = people;
    }

    @JsonProperty("films")
    public List<String> getFilms() {
        return films;
    }

    @JsonProperty("films")
    public void setFilms(List<String> films) {
        this.films = films;
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