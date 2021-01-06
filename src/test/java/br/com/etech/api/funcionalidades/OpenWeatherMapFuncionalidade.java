package br.com.etech.api.funcionalidades;

import br.com.etech.commons.PropertiesManager;
import br.com.etech.commons.VariaveisEstaticas;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class OpenWeatherMapFuncionalidade {

    //@local By Country

    public static void getParamsByCountry(String nome) {
        Map<String, String> params = new HashMap<>();
        params.put("q", nome);
        params.put("appid", "cc7d547753a20fb8fd136a18c5e22eff");

        VariaveisEstaticas.setParams(params);

    }

    public static void requisicaoByCountry() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("name").toString());

    }


//=======================================================================================================================
//=================================================================================================================


    //By City Name

    //    public static void getParamsByCityName(String city) {
//        Map<String, String> params = new HashMap<>();
//        params.put("q", city);
//        params.put("appid", "cc7d547753a20fb8fd136a18c5e22eff");
//
//        VariaveisEstaticas.setParams(params);
//    }
//
    public static void requisicaoByCityName() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                        .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("name").toString());

    }


//=======================================================================================================================
//=================================================================================================================


    //By City ID

    public static void getParamsByCityID(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("appid", PropertiesManager.getPropertiesValue("TOKEN"));

        VariaveisEstaticas.setParams(params);
    }

    public static void requisicaoByCityID() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?id={id}&appid={appid}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("name").toString());
    }



//=======================================================================================================================
//=======================================================================================================================


    //By Geographic Coordinates

    public static void getParamsGeographicCoordinates(String lat, String lon) {
        Map<String, String> params = new HashMap<>();
        params.put("lat", lat);
        params.put("lon", lon);
        params.put("appid", PropertiesManager.getPropertiesValue("TOKEN"));

        VariaveisEstaticas.setParams(params);
    }

    public static void requisicaoGeographicCoordinates() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={appid}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("name").toString());
    }



//=======================================================================================================================
//=======================================================================================================================


    //By ZIP code

    public static void getParamsByZIPCode(String zip) {
        Map<String, String> params = new HashMap<>();
        params.put("zip", zip);
        params.put("appid", PropertiesManager.getPropertiesValue("TOKEN"));

        VariaveisEstaticas.setParams(params);
    }

    public static void requisicaoByZIPCode() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?zip={zip}&appid={appid}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("name").toString());
    }



//=======================================================================================================================
//=======================================================================================================================


    // Rectangle Zone

    public static void getParamsRectangleZone(String bbox) {
        Map<String, String> params = new HashMap<>();
        params.put("bbox", bbox);
        params.put("appid", PropertiesManager.getPropertiesValue("TOKEN"));

        VariaveisEstaticas.setParams(params);
    }


    public static void requisicaoRectangleZone() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://api.openweathermap.org/data/2.5/box/city?bbox={bbox}&appid={appid}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("list").toString());
        VariaveisEstaticas.setResponseBody(response.getBody());

    }

//=======================================================================================================================
//=======================================================================================================================


    //Cities In Circle


    public static void getCitieInCircle(String lat, String lon, String cnt) {
        Map<String, String> params = new HashMap<>();
        params.put("lat", lat);
        params.put("lon", lon);
        params.put("cnt", cnt);
        params.put("appid", PropertiesManager.getPropertiesValue("TOKEN"));

        VariaveisEstaticas.setParams(params);
    }

    public static void requisicaoCitieInCircle() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&cnt={cnt}&appid={appid}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());
    }
}
