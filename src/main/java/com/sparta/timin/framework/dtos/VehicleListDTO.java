package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.timin.framework.util.Injector;
import com.sparta.timin.framework.util.NoPageException;

import java.util.List;

public class VehicleListDTO extends StarWarsListDTO {

    @JsonProperty("results")
    private List<VehicleDTO> results;

    public List<VehicleDTO> getResults() {
        return results;
    }

    public void setResults(List<VehicleDTO> results) {
        this.results = results;
    }
    @Override
    public VehicleListDTO getNextDTO() throws NoPageException {
        if (!hasNext()) throw new NoPageException("No next page!");
        else return (VehicleListDTO) Injector.injectStarWarsListDTOWithFullUrl(getNext());
    }

    @Override
    public VehicleListDTO getPreviousDTO() throws NoPageException {
        if(!hasPrevious())  throw new NoPageException("No previous page!");
        else return (VehicleListDTO) Injector.injectStarWarsListDTOWithFullUrl(getPrevious());
    }
}
