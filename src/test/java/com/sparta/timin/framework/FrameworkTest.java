package com.sparta.timin.framework;

import com.sparta.timin.framework.dtos.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        filmDTO = (FilmDTO) Injector.injectDTO("films/1/");
        personDTO = (PersonDTO) Injector.injectDTO( "people/1/");
        planetDTO = (PlanetDTO) Injector.injectDTO("planets/3/");
        speciesDTO = (SpeciesDTO) Injector.injectDTO("species/3/");
        starshipDTO = (StarshipDTO) Injector.injectDTO("starships/9/");
        vehicleDTO = (VehicleDTO) Injector.injectDTO("vehicles/4/");
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
        listOfPeople.add("http://swapi.dev/api/people/13/");
        listOfPeople.add("http://swapi.dev/api/people/80/");
        assertEquals(listOfPeople, speciesDTO.getPeople());

        HashMap additionalProperties = new HashMap();
        assertEquals(additionalProperties.getClass(), starshipDTO.getAdditionalProperties().getClass());

        assertEquals("wheeled", vehicleDTO.getVehicleClass());
    }



}
