package com.sparta.timin.framework;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.timin.framework.dtos.*;

import java.io.IOException;

public class Injector{

//    TODO - improve this class, tidy up the methods, have star wars DTO injected in 1 step? Remove any duplication. Also refactor existing DTO injecting methods to use the full URL method
    public static StarWarsDTO injectDTOWithFullUrl(String URL) {
        ConnectionManager.setURL(URL);
        System.out.println("URL for request: " + ConnectionManager.getURL());
        StarWarsDTO starWarsDTO = DTOFactory.setDTOObject(URL.substring(22));
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

    public static StarWarsDTO injectDTO(String endPoint) {
        ConnectionManager.setEndPoint(endPoint);
        System.out.println("URL for request: " + ConnectionManager.getURL());
        StarWarsDTO starWarsDTO = DTOFactory.setDTOObject(endPoint);
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
