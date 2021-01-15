package com.sparta.timin.framework;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final String BASEURL = "https://swapi.dev/api/";
    private static String endPoint = "people/1/";
    private String URL;
    private static HttpResponse<String> httpResponse = null;
    private static HttpClient httpClient = HttpClient.newHttpClient();
    private static HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(BASEURL + endPoint)).build();


    public static String getConnection() {
        return BASEURL;
    }

    public static int getStatusCode() {
        int statusCode = 0;
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public static String getURL() {
        return BASEURL + endPoint;
    }

    public static HttpHeaders getHeaders() {
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return httpResponse.headers();
    }

    public static void setEndPoint(String endPoint) {
        ConnectionManager.endPoint = endPoint;
    }

    public static String getEndPoint() {
        return endPoint;
    }

    public static String getBASEURL() {
        return BASEURL;
    }
}
