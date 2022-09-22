package com.sparta.timin.framework.dtotest;

import com.sparta.timin.framework.Endpoints;
import com.sparta.timin.framework.Injector;
import com.sparta.timin.framework.dtos.SpeciesDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeciesDTOTest {
    static SpeciesDTO speciesDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        speciesDTO = (SpeciesDTO) Injector.injectDTO(Endpoints.SPECIES,1);

    }


    @Test
    void filmDtoSanityTest() {
        assertEquals("Human", speciesDTO.getName());
        assertEquals("mammal", speciesDTO.getClassification());
        assertEquals("sentient", speciesDTO.getDesignation());
        assertEquals("180", speciesDTO.getAverageHeight());
        assertEquals("caucasian, black, asian, hispanic", speciesDTO.getSkinColors());
        assertEquals("blonde, brown, black, red", speciesDTO.getHairColors());
        assertEquals("brown, blue, green, hazel, grey, amber", speciesDTO.getEyeColors());
        assertEquals("120", speciesDTO.getAverageLifespan());
        assertEquals("https://swapi.dev/api/planets/9/", speciesDTO.getHomeworld());
        assertEquals("Galactic Basic", speciesDTO.getLanguage());
        assertEquals("https://swapi.dev/api/people/66/", speciesDTO.getPeople().get(0));
        assertEquals("https://swapi.dev/api/films/1/", speciesDTO.getFilms().get(0));
        assertEquals("2014-12-10T13:52:11.567000Z", speciesDTO.getCreated());
        assertEquals("2014-12-20T21:36:42.136000Z", speciesDTO.getEdited());
        assertEquals("https://swapi.dev/api/species/1/", speciesDTO.getUrl());
    }

    @Test
    void speciesDtoPeople() {
        assertEquals("Dormé", speciesDTO.getPeopleDTO(0).getName());
    }

    @Test
    void speciesDtoFilm() {
        assertEquals("A New Hope", speciesDTO.getFilmsDTO(0).getTitle());
    }

    @Test
    void speciesDtohomeworld() {
        assertEquals("Coruscant", speciesDTO.getHomeworldDTO().getName());
    }

}
