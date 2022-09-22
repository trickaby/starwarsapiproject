package com.sparta.timin.framework.dtotest;

import com.sparta.timin.framework.Endpoints;
import com.sparta.timin.framework.Injector;
import com.sparta.timin.framework.NoPageException;
import com.sparta.timin.framework.dtos.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StarWarsListDTOTest {

    static FilmListDTO filmListDTO;
    static PersonListDTO personListDTO;
    static PlanetListDTO planetListDTO;
    static SpeciesListDTO speciesListDTO;
    static StarshipListDTO starshipListDTO;
    static VehicleListDTO vehicleListDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        filmListDTO = (FilmListDTO) Injector.injectStarWarsListDTO(Endpoints.FILM.getEndpoint());
        personListDTO = (PersonListDTO) Injector.injectStarWarsListDTO(Endpoints.PERSON.getEndpoint());
        planetListDTO = (PlanetListDTO) Injector.injectStarWarsListDTO(Endpoints.PLANET.getEndpoint());
        speciesListDTO = (SpeciesListDTO) Injector.injectStarWarsListDTO(Endpoints.SPECIES.getEndpoint());
        starshipListDTO = (StarshipListDTO) Injector.injectStarWarsListDTO(Endpoints.STARSHIP.getEndpoint());
        vehicleListDTO = (VehicleListDTO) Injector.injectStarWarsListDTO(Endpoints.VEHICLE.getEndpoint());
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

}
