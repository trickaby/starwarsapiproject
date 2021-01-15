package com.sparta.timin.framework.dtos;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class Counter {

    public static io.restassured.response.ValidatableResponse getCountAtRoot(int expected, String root) {
        Response response = RestAssured.get("https://swapi.dev/api/" + root);
        return response.then().assertThat().body("count", equalTo(expected));

    }


//    private void injectToRoot(String url) {
//        StarWarsDTO starWarsDTO = DTOFactory.dtoFactory(endPoint);
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
//        try {
//            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            starWarsDTO = objectMapper.readValue(httpResponse.body(), starWarsDTO.getClass());
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }


}
