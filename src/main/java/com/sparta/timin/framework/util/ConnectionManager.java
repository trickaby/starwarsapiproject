package com.sparta.timin.framework.util;

import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final String BASEURL = "https://swapi.dev/api/";
    private static String endPoint;

    private static String URL;

    private static HttpResponse<String> httpResponse = null;
    private static HttpClient httpClient = HttpClient.newHttpClient();

    private static HttpRequest httpRequest;

    public static void buildHttpRequest() {
        setHttpRequest(HttpRequest.newBuilder().uri(URI.create(ConnectionManager.getURL())).build());
        System.out.println("Request: " + getHttpRequest().toString() + " " + getStatusCode());
    }

    public static void sendRequest() throws IOException, InterruptedException {
        setHttpResponse(ConnectionManager.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Response: " + gson.toJson(JsonParser.parseString(httpResponse.body())));
    }

    public static void setURL(String URL) {
        ConnectionManager.URL = URL;
    }


    public static HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }

    public static void setHttpResponse(HttpResponse<String> httpResponse) {
        ConnectionManager.httpResponse = httpResponse;
    }


    public static String getConnection() {
        return BASEURL;
    }

    public static HttpClient getHttpClient() {
        return httpClient;
    }

    public static void setHttpClient(HttpClient httpClient) {
        ConnectionManager.httpClient = httpClient;
    }

    public static HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public static void setHttpRequest(HttpRequest httpRequest) {
        ConnectionManager.httpRequest = httpRequest;
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
