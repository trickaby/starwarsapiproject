package com.sparta.timin.framework.dtotest;

import com.sparta.timin.framework.Endpoints;
import com.sparta.timin.framework.Injector;
import com.sparta.timin.framework.dtos.PersonDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonDTOTest {

    static PersonDTO personDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        personDTO = (PersonDTO) Injector.injectDTO(Endpoints.PERSON, 1);

    }


    @Test
    void filmDtoSanityTest() {
        assertEquals("Luke Skywalker", personDTO.getName());
        assertEquals("172", personDTO.getHeight());
        assertEquals("77", personDTO.getMass());
        assertEquals("blond", personDTO.getHairColor());
        assertEquals("fair", personDTO.getSkinColor());
        assertEquals("blue", personDTO.getEyeColor());
        assertEquals("19BBY", personDTO.getBirthYear());
        assertEquals("male", personDTO.getGender());
        assertEquals("https://swapi.dev/api/planets/1/", personDTO.getHomeworld());
        assertEquals("https://swapi.dev/api/films/1/", personDTO.getFilms().get(0));
        assertEquals("https://swapi.dev/api/vehicles/14/", personDTO.getVehicles().get(0));
        assertEquals("https://swapi.dev/api/starships/12/", personDTO.getStarships().get(0));
        assertEquals("2014-12-09T13:50:51.644000Z", personDTO.getCreated());
        assertEquals("2014-12-20T21:17:56.891000Z", personDTO.getEdited());
        assertEquals("https://swapi.dev/api/people/1/", personDTO.getUrl());
    }

    @Test
    void personDtoPlanet() {
        assertEquals("Tatooine", personDTO.getPlanetDTO(0).getName());
    }

    @Test
    void personDtoFilm() {
        assertEquals("A New Hope", personDTO.getFilmsDTO(0).getTitle());
    }

    @Test
    void personDtoVehicle() {
        assertEquals("Snowspeeder", personDTO.getVehicleDTO(0).getName());
    }

    @Test
    void personDtoStarship() {
        assertEquals("X-wing", personDTO.getStarshipDTO(0).getName());
    }
}
