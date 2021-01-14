package com.sparta.timin.framework;

import com.sparta.timin.framework.dtos.*;

public class DTOFactory {

    public static StarWarsDTO dtoFactory(String endPoint) {
        int slash = endPoint.indexOf('/');
        String input = endPoint.substring(0, slash);


        switch (input){
            case "films":
                return new FilmDTO();
            case "people":
                return new PersonDTO();
            case "planets":
                return new PlanetDTO();
            case "species":
                return new SpeciesDTO();
            case "starships":
                return new StarshipDTO();
            case "vehicles":
                return new VehicleDTO();
        }
        return null;
    }
}
