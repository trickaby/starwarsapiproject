package com.sparta.timin.framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.timin.framework.Injector;

import java.util.ArrayList;
import java.util.List;

public abstract class StarWarsDTO {

    @JsonProperty("characters")
    private List<String> characters = null;
    @JsonProperty("planets")
    private List<String> planets = null;
    @JsonProperty("starships")
    private List<String> starships = null;
    @JsonProperty("vehicles")
    private List<String> vehicles = null;
    @JsonProperty("species")
    private List<String> species = null;
    @JsonProperty("films")
    private List<String> films = null;
    @JsonProperty("pilots")
    private List<String> pilots = null;
    @JsonProperty("residents")
    private List<String> residents = null;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("people")
    private List<String> people = null;

    public PersonDTO getResidentsDTO(int index) {
        return (PersonDTO) Injector.injectDTOWithFullUrl(getResidents().get(index));

    }

    public PersonDTO getPeopleDTO(int index) {
        return (PersonDTO) Injector.injectDTOWithFullUrl(getPeople().get(index));
    }

    public PersonDTO getCharacterDTO(int index) {
        return (PersonDTO) Injector.injectDTOWithFullUrl(getCharacters().get(index));
    }

    public PersonDTO getPilotDTO(int index) {
        return (PersonDTO) Injector.injectDTOWithFullUrl(getPilots().get(index));
    }

    public VehicleDTO getVehicleDTO(int index) {
        return (VehicleDTO) Injector.injectDTOWithFullUrl(getVehicles().get(index));
    }

    public StarshipDTO getStarshipDTO(int index) {
        return (StarshipDTO) Injector.injectDTOWithFullUrl(getStarships().get(index));
    }

    public PlanetDTO getPlanetDTO(int index) {
        return (PlanetDTO) Injector.injectDTOWithFullUrl(getPlanets().get(index));
    }

    public FilmDTO getFilmsDTO(int index) {
        return (FilmDTO) Injector.injectDTOWithFullUrl(getFilms().get(index));
    }

    public SpeciesDTO getSpeciesDTO(int index) {
        return (SpeciesDTO) Injector.injectDTOWithFullUrl(getSpecies().get(index));
    }

    public PlanetDTO getHomeworldDTO() {
        return (PlanetDTO) Injector.injectDTOWithFullUrl(getHomeworld());
    }


    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public List<String> getPlanets() {
        return planets;
    }

    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }


    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

/*
   check if e.g. getCharacters only contains links to people
   category input is same as that which is returned by

 */
    public boolean doFilmListsReturnCorrectLinks(String category) {
        List<String> listToCheck = new ArrayList<>();
        String urlContentToCheck;
        switch(category) {
            case "characters":
                listToCheck = getCharacters();
                urlContentToCheck = "people";
                break;
            case "pilots":
                listToCheck = getPilots();
                urlContentToCheck = "people";
                break;
            case "residents":
                listToCheck = getResidents();
                urlContentToCheck = "people";
                break;
            case "planets":
                listToCheck = getPlanets();
                urlContentToCheck = "planets";
                break;
            case "starships":
                listToCheck = getStarships();
                urlContentToCheck = "starships";
                break;
            case "species":
                listToCheck = getSpecies();
                urlContentToCheck = "species";
                break;
            case "vehicles":
                listToCheck = getVehicles();
                urlContentToCheck = "vehicles";
                break;
            case "films":
                listToCheck = getFilms();
                urlContentToCheck = "films";
                break;
            default:
                return false;
        }
        if(listToCheck.isEmpty()) {return true;}
        System.out.println("List to check: " + listToCheck);
        for (String listContents : listToCheck)
            if(!listContents.contains(urlContentToCheck)) {
                System.out.println("URL: " + listContents);
                System.out.println("Expected: " + urlContentToCheck);
                return false;
            }
        return true;
    }
}
