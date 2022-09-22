package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.timin.framework.util.Injector;
import com.sparta.timin.framework.util.NoPageException;

import java.util.List;

public class FilmListDTO extends StarWarsListDTO {


    @JsonProperty("results")
    private List<FilmDTO> results;

    public List<FilmDTO> getResults() {
        return results;
    }

    public void setResults(List<FilmDTO> results) {
        this.results = results;
    }
    @Override
    public FilmListDTO getNextDTO() throws NoPageException {
        if (!hasNext()) throw new NoPageException("No next page!");
        else return (FilmListDTO) Injector.injectStarWarsListDTOWithFullUrl(getNext());
    }

    @Override
    public FilmListDTO getPreviousDTO() throws NoPageException {
        if(!hasPrevious())  throw new NoPageException("No previous page!");
        else return (FilmListDTO) Injector.injectStarWarsListDTOWithFullUrl(getPrevious());
    }
}
