package com.sparta.timin.framework;

import com.sparta.timin.framework.dtos.PersonDTO;
import com.sparta.timin.framework.dtos.StarshipDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class FrameworkTest {
    PersonDTO personDTO;

    @Test
    @DisplayName("Connection Test")
    void connectionTest() {
        personDTO = Injector.injectPersonDTO(ConnectionManager.getURL());
        Assertions.assertEquals(200, ConnectionManager.getStatusCode());
    }

    @Test
    @DisplayName("get name")
    void getName() {
        personDTO = Injector.injectPersonDTO(ConnectionManager.getURL());
        System.out.println(personDTO.getName());
    }

    @Test
    @DisplayName("Header test")
    void connectionType() {
        personDTO = Injector.injectPersonDTO(ConnectionManager.getURL());
        System.out.println(ConnectionManager.getHeaders());
        Assertions.assertNotNull(ConnectionManager.getHeaders());
    }

    @Test
    @DisplayName("Get another DTO")
    void getAnotherDTO() {
        ConnectionManager.setEndPoint("starships/9/");
        System.out.println(ConnectionManager.getURL());
        StarshipDTO dto = (StarshipDTO) Injector.injectDTO(ConnectionManager.getEndPoint());
        System.out.println(dto.getName());
//        System.out.println(dto.getClass());
    }



}
