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
import com.sparta.timin.framework.ConnectionManager;
import com.sparta.timin.framework.Injector;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "episode_id",
        "opening_crawl",
        "director",
        "producer",
        "release_date",
        "characters",
        "planets",
        "starships",
        "vehicles",
        "species",
        "created",
        "edited",
        "url"
})
public class FilmDTO extends StarWarsDTO{

    public FilmDTO() {}

    @JsonProperty("title")
    private String title;
    @JsonProperty("episode_id")
    private int episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    @JsonProperty("director")
    private String director;
    @JsonProperty("producer")
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("episode_id")
    public int getEpisodeId() {
        return episodeId;
    }

    @JsonProperty("episode_id")
    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    @JsonProperty("opening_crawl")
    public String getOpeningCrawl() {
        return openingCrawl;
    }

    @JsonProperty("opening_crawl")
    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("director")
    public void setDirector(String director) {
        this.director = director;
    }

    @JsonProperty("producer")
    public String getProducer() {
        return producer;
    }

    @JsonProperty("producer")
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("edited")
    public String getEdited() {
        return edited;
    }

    @JsonProperty("edited")
    public void setEdited(String edited) {
        this.edited = edited;
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
        return additionalProperties;
    }
}