package com.sparta.timin.framework.dtotest;

import com.sparta.timin.framework.Injector;
import com.sparta.timin.framework.dtos.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmDTOTest {

    static FilmDTO filmDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        filmDTO = (FilmDTO) Injector.injectDTO("films/1/");

    }


    @Test
    void filmDtoSanityTest() {
        assertEquals("A New Hope",  filmDTO.getTitle());
        assertEquals(4, filmDTO.getEpisodeId());
        assertTrue(filmDTO.getOpeningCrawl().contains("It is a period of civil war."));
        assertEquals("George Lucas", filmDTO.getDirector());
        assertEquals("Gary Kurtz, Rick McCallum", filmDTO.getProducer());
        assertEquals("1977-05-25", filmDTO.getReleaseDate());
        assertEquals("https://swapi.dev/api/people/1/", filmDTO.getCharacters().get(0));
        assertEquals("https://swapi.dev/api/starships/2/", filmDTO.getStarships().get(0));
        assertEquals("https://swapi.dev/api/vehicles/4/", filmDTO.getVehicles().get(0));
        assertEquals("https://swapi.dev/api/species/1/", filmDTO.getSpecies().get(0));
        assertEquals("2014-12-10T14:23:31.880000Z", filmDTO.getCreated());
        assertEquals("2014-12-20T19:49:45.256000Z", filmDTO.getEdited());
        assertEquals("https://swapi.dev/api/films/1/", filmDTO.getUrl());

    }

    @Test
    void filmDtoCharacter() {
        assertEquals("Luke Skywalker", filmDTO.getCharacterDTO(0).getName());
    }

    @Test
    void filmDtoVehicle() {
        assertEquals("Luke Skywalker", filmDTO.getVehicleDTO(0).getName());
    }

    @Test
    void filmDtoStarship() {
        assertEquals("Luke Skywalker", filmDTO.getStarshipDTO(0).getName());
    }

    @Test
    void filmDtoPlanet() {
        assertEquals("Luke Skywalker", filmDTO.getPlanetDTO(0).getName());
    }



}
