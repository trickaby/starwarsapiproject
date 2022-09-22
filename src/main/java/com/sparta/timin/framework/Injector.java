package com.sparta.timin.framework;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.timin.framework.dtos.*;

import java.io.IOException;

public class Injector{


    public static StarWarsDTO injectDTOWithFullUrl(String URL) {
        ConnectionManager.setEndPoint(URL.replace(ConnectionManager.getBASEURL(), ""));
        executeRequest();
        return buildStarWarsDTO();
    }

    public static StarWarsDTO injectDTO(Endpoints endpoint, int id) {
        ConnectionManager.setEndPoint(endpoint.getEndpoint() + id + "/");
        executeRequest();
        return buildStarWarsDTO();
    }

    private static void executeRequest() {
        System.out.println("URL for request: " + ConnectionManager.getURL());
        DTOFactory.setDTOObject();


        ConnectionManager.buildHttpRequest();
        try {
            ConnectionManager.sendRequest();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static StarWarsDTO buildStarWarsDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        StarWarsDTO starWarsDTO = DTOFactory.setDTOObject();
        try {
            return objectMapper.readValue(ConnectionManager.getHttpResponse().body(), starWarsDTO.getClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static StarWarsListDTO injectStarWarsListDTOWithFullUrl(String URL) {
        ConnectionManager.setEndPoint(URL.replace(ConnectionManager.getBASEURL(), ""));
        executeRequest();
        return buildStarWarsListDTO();
    }

    public static StarWarsListDTO injectStarWarsListDTO(String endPoint) {
        ConnectionManager.setEndPoint(endPoint);
        executeRequest();
        return buildStarWarsListDTO();
    }

    private static StarWarsListDTO buildStarWarsListDTO() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
//                .allowIfSubType("com.")
//                .allowIfSubType("java.util.ArrayList")
//                .build();
//        objectMapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(ConnectionManager.getHttpResponse().body(), DTOFactory.setDTOListObject().getClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
