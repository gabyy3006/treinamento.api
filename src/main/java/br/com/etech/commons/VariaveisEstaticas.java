package br.com.etech.commons;

import io.restassured.response.ResponseBody;

import java.util.Map;

public class VariaveisEstaticas {

    static Map<String, String> params;
    static String body;
    static ResponseBody responseBody;
    static Map<String, String> requestBody;
    static String cookie;

    public static String getCookie() {
        return cookie;
    }

    public static void setCookie(String cookie) {
        VariaveisEstaticas.cookie = cookie;
    }

    public static Map<String, String> getRequestBody() {
        return requestBody;
    }

    public static void setRequestBody(Map<String, String> requestBody) {
        VariaveisEstaticas.requestBody = requestBody;
    }

    public static String getBody() {
        return body;
    }

    public static ResponseBody getResponseBody() {
        return responseBody;
    }

    public static void setBody(String body) {
        VariaveisEstaticas.body = body;
    }

    public static void setResponseBody(ResponseBody body) {
        VariaveisEstaticas.responseBody = body;
    }

    public static Map<String, String> getParams() {
        return params;
    }

    public static void setParams(Map<String, String> getParams) {
        VariaveisEstaticas.params = getParams;
    }
}
