package com.sparta.timin.framework.dtotest;

import com.sparta.timin.framework.Endpoints;
import com.sparta.timin.framework.Injector;
import com.sparta.timin.framework.NoPageException;
import com.sparta.timin.framework.dtos.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StarWarsListDTOTest {

    static FilmListDTO filmListDTO;
    static PersonListDTO personListDTO;
    static PlanetListDTO planetListDTO;
    static SpeciesListDTO speciesListDTO;
    static StarshipListDTO starshipListDTO;
    static VehicleListDTO vehicleListDTO;

//    TODO - Handle missing IDs in the API - eg no starships/1/


    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        filmListDTO = (FilmListDTO) Injector.injectStarWarsListDTO(Endpoints.FILM);
        personListDTO = (PersonListDTO) Injector.injectStarWarsListDTO(Endpoints.PERSON);
        planetListDTO = (PlanetListDTO) Injector.injectStarWarsListDTO(Endpoints.PLANET);
        speciesListDTO = (SpeciesListDTO) Injector.injectStarWarsListDTO(Endpoints.SPECIES);
        starshipListDTO = (StarshipListDTO) Injector.injectStarWarsListDTO(Endpoints.STARSHIP);
        vehicleListDTO = (VehicleListDTO) Injector.injectStarWarsListDTO(Endpoints.VEHICLE);
    }

    @Test
    void checkNext()  {
        assertEquals(PersonDTO.class,  personListDTO.getResults().get(0).getClass());
        try {
            assertEquals("Boba Fett",personListDTO.getNextDTO().getNextDTO().getResults().get(0).getName());
        } catch (NoPageException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    void checkNoPrevious() {
        try {
            personListDTO.getPreviousDTO();
        } catch (NoPageException e) {
            assertEquals("No previous page!", e.getMessage());
        }
    }



    @Test
    void checkCount() {
        assertEquals(82 ,personListDTO.getCount());
    }

    @Test
    void previousFromFirstPage() {
        System.out.println(personListDTO.getPrevious());
    }

    @Test
    void checkEachDTO() {
        assertEquals(6, filmListDTO.getCount());
        assertEquals(82, personListDTO.getCount());
        assertEquals(60, planetListDTO.getCount());
        assertEquals(37, speciesListDTO.getCount());
        assertEquals(36, starshipListDTO.getCount());
        assertEquals(39, vehicleListDTO.getCount());
    }

}
