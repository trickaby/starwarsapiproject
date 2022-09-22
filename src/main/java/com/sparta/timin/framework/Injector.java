package com.sparta.timin.framework;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.timin.framework.dtos.*;

import java.io.IOException;

public class Injector{


    public static StarWarsDTO injectDTOWithFullUrl(String URL) {
        ConnectionManager.setEndPoint(URL.replace(ConnectionManager.getBASEURL(), ""));
        return executeRequest();
    }

    public static StarWarsDTO injectDTO(String endPoint) {
        ConnectionManager.setEndPoint(endPoint);
        return executeRequest();
    }

    private static StarWarsDTO executeRequest() {
        System.out.println("URL for request: " + ConnectionManager.getURL());
        StarWarsDTO starWarsDTO = DTOFactory.setDTOObject(ConnectionManager.getEndPoint());

        ObjectMapper objectMapper = new ObjectMapper();
        ConnectionManager.buildHttpRequest();
        try {
            ConnectionManager.sendRequest();
            starWarsDTO = objectMapper.readValue(ConnectionManager.getHttpResponse().body(), starWarsDTO.getClass());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return starWarsDTO;
    }





}
