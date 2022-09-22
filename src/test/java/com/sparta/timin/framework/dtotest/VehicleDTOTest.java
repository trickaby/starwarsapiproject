package com.sparta.timin.framework.dtotest;

import com.sparta.timin.framework.Endpoints;
import com.sparta.timin.framework.Injector;
import com.sparta.timin.framework.dtos.VehicleDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleDTOTest {

    static VehicleDTO vehicleDTO;

    @BeforeAll
    @DisplayName("Setup")
    static void setup() {
        vehicleDTO = (VehicleDTO) Injector.injectDTO(Endpoints.VEHICLE, 4);

    }


    @Test
    void filmDtoSanityTest() {
        assertEquals("Sand Crawler", vehicleDTO.getName());
        assertEquals("Digger Crawler", vehicleDTO.getModel());
        assertEquals("Corellia Mining Corporation", vehicleDTO.getManufacturer());
        assertEquals("150000", vehicleDTO.getCostInCredits());
        assertEquals("36.8", vehicleDTO.getLength());
        assertEquals("30", vehicleDTO.getMaxAtmospheringSpeed());
        assertEquals("46", vehicleDTO.getCrew());
        assertEquals("30", vehicleDTO.getPassengers());
        assertEquals("50000", vehicleDTO.getCargoCapacity());
        assertEquals("2 months", vehicleDTO.getConsumables());
        assertEquals("wheeled", vehicleDTO.getVehicleClass());
        assertEquals(0, vehicleDTO.getPilots().size());
        assertEquals("https://swapi.dev/api/films/1/", vehicleDTO.getFilms().get(0));
        assertEquals("2014-12-10T15:36:25.724000Z", vehicleDTO.getCreated());
        assertEquals("2014-12-20T21:30:21.661000Z", vehicleDTO.getEdited());
        assertEquals("https://swapi.dev/api/vehicles/4/", vehicleDTO.getUrl());
    }

    @Test
    void vehicleDtoFilm() {
        assertEquals("A New Hope", vehicleDTO.getFilmsDTO(0).getTitle());
    }

}
