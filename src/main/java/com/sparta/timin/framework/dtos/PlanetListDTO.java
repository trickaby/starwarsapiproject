package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.timin.framework.util.Injector;
import com.sparta.timin.framework.util.NoPageException;

import java.util.List;

public class PlanetListDTO extends StarWarsListDTO {

    @JsonProperty("results")
    private List<PlanetDTO> results;

    public List<PlanetDTO> getResults() {
        return results;
    }

    public void setResults(List<PlanetDTO> results) {
        this.results = results;
    }
    @Override
    public PlanetListDTO getNextDTO() throws NoPageException {
        if (!hasNext()) throw new NoPageException("No next page!");
        else return (PlanetListDTO) Injector.injectStarWarsListDTOWithFullUrl(getNext());
    }

    @Override
    public PlanetListDTO getPreviousDTO() throws NoPageException {
        if(!hasPrevious())  throw new NoPageException("No previous page!");
        else return (PlanetListDTO) Injector.injectStarWarsListDTOWithFullUrl(getPrevious());
    }
}
