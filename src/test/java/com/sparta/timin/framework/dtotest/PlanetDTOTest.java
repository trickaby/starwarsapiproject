package com.sparta.timin.framework.dtotest;

import com.sparta.timin.framework.Endpoints;
import com.sparta.timin.framework.Injector;
import com.sparta.timin.framework.dtos.PlanetDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanetDTOTest {

    static PlanetDTO planetDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        planetDTO = (PlanetDTO) Injector.injectDTO(Endpoints.PLANET, 1);

    }


    @Test
    void filmDtoSanityTest() {
        assertEquals("Tatooine", planetDTO.getName());
        assertEquals("23", planetDTO.getRotationPeriod());
        assertEquals("10465", planetDTO.getDiameter());
        assertEquals("arid", planetDTO.getClimate());
        assertEquals("1 standard", planetDTO.getGravity());
        assertEquals("desert", planetDTO.getTerrain());
        assertEquals("1", planetDTO.getSurfaceWater());
        assertEquals("200000", planetDTO.getPopulation());
        assertEquals("https://swapi.dev/api/people/1/", planetDTO.getResidents().get(0));
        assertEquals("https://swapi.dev/api/films/1/", planetDTO.getFilms().get(0));
        assertEquals("2014-12-09T13:50:49.641000Z", planetDTO.getCreated());
        assertEquals("2014-12-20T20:58:18.411000Z", planetDTO.getEdited());
        assertEquals("https://swapi.dev/api/planets/1/", planetDTO.getUrl());
    }

    @Test
    void planetDtoResident() {
        assertEquals("Luke Skywalker", planetDTO.getResidentsDTO(0).getName());
    }

    @Test
    void planetDtoFilm() {
        assertEquals("A New Hope", planetDTO.getFilmsDTO(0).getTitle());
    }

}
