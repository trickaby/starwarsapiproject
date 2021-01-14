package com.sparta.timin.framework;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.timin.framework.dtos.*;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Injector{

    public static PersonDTO injectPersonDTO(String URL) {
        PersonDTO personDTO = new PersonDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            personDTO = objectMapper.readValue(httpResponse.body(), PersonDTO.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return personDTO;
    }

    public static StarWarsDTO injectDTO(String endPoint) {
        StarWarsDTO starWarsDTO = DTOFactory.dtoFactory(endPoint);
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(ConnectionManager.getURL())).build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            starWarsDTO = objectMapper.readValue(httpResponse.body(), starWarsDTO.getClass());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return starWarsDTO;
    }



//    factory pattern



}
