package com.sparta.timin.framework.dtotest;

import com.sparta.timin.framework.util.Endpoints;
import com.sparta.timin.framework.util.Injector;
import com.sparta.timin.framework.dtos.StarshipDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StarshipDTOTest {

    static StarshipDTO starshipDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        starshipDTO = (StarshipDTO) Injector.injectDTO(Endpoints.STARSHIP, 9);

    }


    @Test
    void filmDtoSanityTest() {
        assertEquals("Death Star", starshipDTO.getName());
        assertEquals("DS-1 Orbital Battle Station", starshipDTO.getModel());
        assertEquals("Imperial Department of Military Research, Sienar Fleet Systems", starshipDTO.getManufacturer());
        assertEquals("1000000000000", starshipDTO.getCostInCredits());
        assertEquals("120000", starshipDTO.getLength());
        assertEquals("n/a", starshipDTO.getMaxAtmospheringSpeed());
        assertEquals("342,953", starshipDTO.getCrew());
        assertEquals("843,342", starshipDTO.getPassengers());
        assertEquals("1000000000000", starshipDTO.getCargoCapacity());
        assertEquals("3 years", starshipDTO.getConsumables());
        assertEquals("4.0", starshipDTO.getHyperdriveRating());
        assertEquals("10", starshipDTO.getMGLT());
        assertEquals("Deep Space Mobile Battlestation", starshipDTO.getStarshipClass());
        assertEquals(0, starshipDTO.getPilots().size());
        assertEquals("https://swapi.dev/api/films/1/", starshipDTO.getFilms().get(0));
        assertEquals("2014-12-10T16:36:50.509000Z", starshipDTO.getCreated());
        assertEquals("2014-12-20T21:26:24.783000Z", starshipDTO.getEdited());
        assertEquals("https://swapi.dev/api/starships/9/", starshipDTO.getUrl());
    }


    @Test
    void starshipDtoFilm() {
        assertEquals("A New Hope", starshipDTO.getFilmsDTO(0).getTitle());
    }


}
