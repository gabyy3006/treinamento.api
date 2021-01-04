package br.com.etech.api.funcionalidades;

import br.com.etech.commons.VariaveisEstaticas;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ReqresFuncionalidade {

    Faker faker = new Faker(new Locale("pt-BR"));
    Map<String, String> params = new HashMap<>();
    String job = faker.job().field();
    String url = "https://reqres.in/api/users/";



    //listar Usuarios

    public void getParamsListUsers(String page) {
        Map<String, String> params = new HashMap<>();
        params.put("page", page);

        VariaveisEstaticas.setParams(params);

    }

    public void requisicaoListUsers(){
        Response response =
                given()
                    .pathParams(VariaveisEstaticas.getParams())
                .when()
                    .get("https://reqres.in/api/users?page={page}")
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response();

//        VariaveisEstaticas.setBody(response.getBody().path("data").toString());
        VariaveisEstaticas.setResponseBody(response.getBody());
    }

    public void retornoChave(String chave) {
        Assert.assertNotNull(VariaveisEstaticas.getResponseBody().path(chave));
    }


//=====================================================================================================================
//=================================================================================================================


    //Single User

    public void getParamsSingleUser(String id){
        Map<String, String> params = new HashMap<>();
        params.put("id", id);

        VariaveisEstaticas.setParams(params);
    }

    public void requisicaoSingleUser() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://reqres.in/api/users/{id}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());

    }


//=====================================================================================================================
//=================================================================================================================


    //Single User Not Found

    public void getParamsSingleUserNotFound(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);

        VariaveisEstaticas.setParams(params);
    }

    public void requisicaoSingleUserNotFound() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://reqres.in/api/users/{id}")
                .then()
                        .log().all()
                        .statusCode(404)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());

    }

    public void retornoNuloChave(String chave) {
        Assert.assertNull(VariaveisEstaticas.getResponseBody().path(chave));
    }

   

//=======================================================================================================================
//=================================================================================================================


    //List Resource

    public void getParamsListResource(String page) {
        Map<String, String> params = new HashMap<>();
        params.put("page", page);

        VariaveisEstaticas.setParams(params);
    }


    public void requisicaoListResource() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://reqres.in/api/unknown?page={page}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());

    }

    

//=======================================================================================================================
//=================================================================================================================


    //Single Resource
    
    public void getParamsSingleResource(String page) {
        Map<String, String> params = new HashMap<>();
        params.put("page", page);

        VariaveisEstaticas.setParams(params);
    }


    public void requisicaoSingleResource() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://reqres.in/api/unknown/2?page={page}")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());

    }




//=======================================================================================================================
//=================================================================================================================


    //Single Resource Not Found

    public void getParamsSingleResourceNotFound(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);

        VariaveisEstaticas.setParams(params);
    }


    public void requisicaoSingleResourceNotFound() {
        Response response =
                given()
                        .pathParams(VariaveisEstaticas.getParams())
                .when()
                        .get("https://reqres.in/api/unknown/{id}")
                .then()
                        .log().all()
                        .statusCode(404)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());

    }




//=======================================================================================================================
//=================================================================================================================


    //Post User

    public void getBodyUser(){
        params.put("name", faker.name().firstName());
        params.put("job", job);

        VariaveisEstaticas.setRequestBody(params);
    }

    public void requisicaoPostUser(){
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                .when()
                        .post(url)
                .then()
                        .log().all()
                        .statusCode(201)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("id").toString());
    }





//=======================================================================================================================
//=================================================================================================================


    //put User

    public void putBodyUser(){
        params.put("name", faker.name().firstName());
        params.put("job", job);

        VariaveisEstaticas.setRequestBody(params);
    }

    public void requisicaoPutUser(){
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                .when()
                        .put(url + "3")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setBody(response.getBody().path("updatedAt").toString());
    }


//=======================================================================================================================
//=================================================================================================================


    //delete User

    public void requisicaoDeleteUser(){
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                .when()
                        .delete(url + "2")
                .then()
                        .log().all()
                        .statusCode(204)
                        .extract().response();

        VariaveisEstaticas.setCookie(response.getCookie("__cfduid"));
    }




//=======================================================================================================================
//=================================================================================================================


    //Register Successful

    public void postRegisterSuccessful(String email, String senha) {
        params.put("email",email);
        params.put("password",senha);

        VariaveisEstaticas.setRequestBody(params);
    }

    public void requisicaoRegisterSuccessful() {
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                .when()
                        .post("https://reqres.in/api/register")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());
    }




//=======================================================================================================================
//=================================================================================================================


    //Register Unsuccessful

    public void postRegisterUnsuccessful(String email) {
        params.put("email",email);

        VariaveisEstaticas.setRequestBody(params);
    }

    public void requisicaoRegisterUnsuccessful() {
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                .when()
                        .post("https://reqres.in/api/register")
                .then()
                        .log().all()
                        .statusCode(400)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());
    }




//=======================================================================================================================
//=================================================================================================================


    //Login Successful

    public void postLoginSuccessful(String email, String senha) {
        params.put("email",email);
        params.put("password",senha);

        VariaveisEstaticas.setRequestBody(params);
    }

    public void requisicaoLoginSuccessful() {
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                .when()
                        .post("https://reqres.in/api/login")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());
    }

    

//=======================================================================================================================
//=================================================================================================================


    //Login Unsuccessful

    public void postLoginUnsuccessful(String email) {
        params.put("email",email);

        VariaveisEstaticas.setRequestBody(params);
    }

    public void requisicaoLoginUnsuccessful() {
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(VariaveisEstaticas.getRequestBody())
                .when()
                        .post("https://reqres.in/api/login")
                .then()
                        .log().all()
                        .statusCode(400)
                        .extract().response();

        VariaveisEstaticas.setResponseBody(response.getBody());
    }

//=======================================================================================================================
//=================================================================================================================


    //Delayed Response

}



