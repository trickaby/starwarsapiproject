package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.timin.framework.Injector;
import com.sparta.timin.framework.NoPageException;

import java.util.List;

public class PersonListDTO extends StarWarsListDTO {




    @JsonProperty("results")
    private List<PersonDTO> results;

    public List<PersonDTO> getResults() {
        return results;
    }

    public void setResults(List<PersonDTO> results) {
        this.results = results;
    }

    @Override
    public PersonListDTO getNextDTO() throws NoPageException {
        if (!hasNext()) throw new NoPageException("No next page!");
        else return (PersonListDTO) Injector.injectStarWarsListDTOWithFullUrl(getNext());
    }

    @Override
    public PersonListDTO getPreviousDTO() throws NoPageException {
        if(!hasPrevious())  throw new NoPageException("No previous page!");
        else return (PersonListDTO) Injector.injectStarWarsListDTOWithFullUrl(getPrevious());
    }
}
