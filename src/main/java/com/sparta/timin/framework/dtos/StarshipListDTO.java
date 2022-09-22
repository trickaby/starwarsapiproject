package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.timin.framework.util.Injector;
import com.sparta.timin.framework.util.NoPageException;

import java.util.List;

public class StarshipListDTO extends StarWarsListDTO {

    @JsonProperty("results")
    private List<StarshipDTO> results;

    public List<StarshipDTO> getResults() {
        return results;
    }

    public void setResults(List<StarshipDTO> results) {
        this.results = results;
    }
    @Override
    public StarshipListDTO getNextDTO() throws NoPageException {
        if (!hasNext()) throw new NoPageException("No next page!");
        else return (StarshipListDTO) Injector.injectStarWarsListDTOWithFullUrl(getNext());
    }

    @Override
    public StarshipListDTO getPreviousDTO() throws NoPageException {
        if(!hasPrevious())  throw new NoPageException("No previous page!");
        else return (StarshipListDTO) Injector.injectStarWarsListDTOWithFullUrl(getPrevious());
    }
}
