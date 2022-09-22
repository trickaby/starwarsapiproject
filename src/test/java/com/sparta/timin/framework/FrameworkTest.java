package com.sparta.timin.framework;

import com.sparta.timin.framework.dtos.*;
import com.sparta.timin.framework.util.ConnectionManager;
import com.sparta.timin.framework.util.Endpoints;
import com.sparta.timin.framework.util.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class FrameworkTest {
    static FilmDTO filmDTO;
    static PersonDTO personDTO;
    static PlanetDTO planetDTO;
    static SpeciesDTO speciesDTO;
    static StarshipDTO starshipDTO;
    static VehicleDTO vehicleDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        filmDTO = (FilmDTO) Injector.injectDTO(Endpoints.FILM, 1);
        personDTO = (PersonDTO) Injector.injectDTO( Endpoints.PERSON, 1);
        planetDTO = (PlanetDTO) Injector.injectDTO(Endpoints.PLANET, 3);
        speciesDTO = (SpeciesDTO) Injector.injectDTO(Endpoints.SPECIES,3);
        starshipDTO = (StarshipDTO) Injector.injectDTO(Endpoints.STARSHIP,9);
        vehicleDTO = (VehicleDTO) Injector.injectDTO(Endpoints.VEHICLE, 4);
    }


    @Test
    @DisplayName("Connection Test")
    void connectionTest() {
        assertEquals(200, ConnectionManager.getStatusCode());
    }

    @Test
    @DisplayName("Person get name")
    void getName() {
        assertEquals("Luke Skywalker", personDTO.getName());
    }


    @Test
    @DisplayName("Header test")
    void connectionType() {
        System.out.println(ConnectionManager.getHeaders().allValues("content-type"));
        Assertions.assertNotNull(ConnectionManager.getHeaders());
    }

    @Test
    @DisplayName("Test all the DTOs")
    void getAnotherDTO() {
        assertEquals("1977-05-25", filmDTO.getReleaseDate());
        System.out.println(filmDTO.getOpeningCrawl());
        assertEquals("blue", personDTO.getEyeColor());
        assertEquals("temperate, tropical", planetDTO.getClimate());

        ArrayList<String> listOfPeople = new ArrayList<>();
        listOfPeople.add("https://swapi.dev/api/people/13/");
        listOfPeople.add("https://swapi.dev/api/people/80/");
        assertEquals(listOfPeople, speciesDTO.getPeople());
        assertEquals(HashMap.class, starshipDTO.getAdditionalProperties().getClass());

        assertEquals("wheeled", vehicleDTO.getVehicleClass());
    }

    @Test
    @DisplayName("Film check list contents")
    void filmCheckListContents() {
        Assertions.assertTrue(filmDTO.doFilmListsReturnCorrectLinks("vehicles"));
    }

    //Note: species list is empty
    @Test
    @DisplayName("Person check list contents")
    void personCheckListContents() {
        Assertions.assertTrue(personDTO.doFilmListsReturnCorrectLinks("species"));
    }

    @Test
    @DisplayName("Name Format")
    void nameFormat() {
        assertTrue(personDTO.isNameInCorrectFormat());
    }

    @Test
    @DisplayName("Incorrect Name")
    void incorrectName() {
        PersonDTO beruWhitesunlars = (PersonDTO) Injector.injectDTO(Endpoints.PERSON, 7);
        assertFalse(beruWhitesunlars.isNameInCorrectFormat());
    }

    @Test
    @DisplayName("Test Nested DTO Objects")
    void testNestedDtoObjects() {
        assertEquals("Alderaan",filmDTO.getPlanetDTO(1).getName());
        assertEquals(filmDTO.getTitle(), filmDTO.getPlanetDTO(1).getFilmsDTO(0).getTitle());
    }



}
