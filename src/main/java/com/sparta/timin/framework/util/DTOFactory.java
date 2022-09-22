package com.sparta.timin.framework.util;

import com.sparta.timin.framework.dtos.*;

public class DTOFactory {

    public static StarWarsDTO setDTOObject() {
        String endPoint = ConnectionManager.getEndPoint();
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

    public static StarWarsListDTO setDTOListObject() {
        String endPoint = ConnectionManager.getEndPoint();
        int slash = endPoint.indexOf('/');
        String input = endPoint.substring(0, slash);


        switch (input){
            case "films":
                return new FilmListDTO();
            case "people":
                return new PersonListDTO();
            case "planets":
                return new PlanetListDTO();
            case "species":
                return new SpeciesListDTO();
            case "starships":
                return new StarshipListDTO();
            case "vehicles":
                return new VehicleListDTO();
        }
        return null;
    }
}
