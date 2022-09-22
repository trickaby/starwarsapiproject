package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParentDTO {

    @JsonProperty("count")
    private int count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
//    @JsonTypeInfo(
//            use = JsonTypeInfo.Id.NAME,
//            include = JsonTypeInfo.As.PROPERTY,
//            property
//    )
    private List<StarWarsDTO> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<StarWarsDTO> getResults() {
        return results;
    }

    public void setResults(List<StarWarsDTO> results) {
        this.results = results;
    }
}
