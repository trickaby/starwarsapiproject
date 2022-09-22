package com.sparta.timin.framework.util;

public enum Endpoints {

    FILM("films/"),
    PERSON("people/"),
    PLANET("planets/"),
    SPECIES("species/"),
    STARSHIP("starships/"),
    VEHICLE("vehicles/");


    private String endpoint;

    Endpoints(String s) {
        this.endpoint = s;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
