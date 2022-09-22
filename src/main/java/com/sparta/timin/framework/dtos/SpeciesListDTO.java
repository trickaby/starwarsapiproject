package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.timin.framework.util.Injector;
import com.sparta.timin.framework.util.NoPageException;

import java.util.List;

public class SpeciesListDTO extends StarWarsListDTO {
    @JsonProperty("results")
    private List<SpeciesDTO> results;

    public List<SpeciesDTO> getResults() {
        return results;
    }

    public void setResults(List<SpeciesDTO> results) {
        this.results = results;
    }
    @Override
    public SpeciesListDTO getNextDTO() throws NoPageException {
        if (!hasNext()) throw new NoPageException("No next page!");
        else return (SpeciesListDTO) Injector.injectStarWarsListDTOWithFullUrl(getNext());
    }

    @Override
    public SpeciesListDTO getPreviousDTO() throws NoPageException {
        if(!hasPrevious())  throw new NoPageException("No previous page!");
        else return (SpeciesListDTO) Injector.injectStarWarsListDTOWithFullUrl(getPrevious());
    }
}
