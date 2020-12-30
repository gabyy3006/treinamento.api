package br.com.etech.api.funcionalidades;

import br.com.etech.commons.VariaveisEstaticas;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class DadosMeteorologicosFunc {

    public void getParamsByCountry(String nome){
        Map<String, String> params = new HashMap<>();
        params.put("q", nome);
        params.put("appid", "cc7d547753a20fb8fd136a18c5e22eff");

        VariaveisEstaticas.setParams(params);

    }


    public void requisicaoByCountry(){
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
}
