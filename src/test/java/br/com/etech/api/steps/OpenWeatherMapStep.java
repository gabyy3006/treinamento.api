package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.OpenWeatherMapFuncionalidade;
import br.com.etech.commons.VariaveisEstaticas;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class OpenWeatherMapStep {

    OpenWeatherMapFuncionalidade openWeatherMapFuncionalidade = new OpenWeatherMapFuncionalidade();

    //@local By Country

    @Dado("^recuperar os parametros necessarios para localização pelo nome \"([^\"]*)\"$")
    public void recuperarOsParametrosNecessarios(String nome){
        OpenWeatherMapFuncionalidade.getParamsByCountry(nome);
    }

    @Quando("^realizar uma requisição GET no serviço pelo nome do país$")
    public void realizarUmaRequisiçãoGETNoServiçoPeloNomeDoPaís() {
        OpenWeatherMapFuncionalidade.requisicaoByCountry();
    }

    @Então("^devo validar o nome \"([^\"]*)\" no retorno do serviço$")
    public void devoValidarONomeNoRetornoDoServiço(String nome) {
        Assert.assertEquals(nome, VariaveisEstaticas.getBody());
    }



//=======================================================================================================================
//=================================================================================================================


    //By City Name

//    @Dado("^recuperar os parametros necessarios para localização pelo nome Itanhaém$")
//    public void recuperarOsParametrosNecessariosParaLocalizaçãoPeloNomeItanhaém(String city) {
//        OpenWeatherMapFuncionalidade.getParamsByCityName(city);
//    }
//
//
    @Quando("^realizar uma requisição GET no serviço pelo nome da cidade$")
    public void realizarUmaRequisiçãoGETNoServiçoPeloNomeDaCidade() {
        OpenWeatherMapFuncionalidade.requisicaoByCityName();
    }


//
//    @Então("^devo validar o nome Itanhaém no retorno do serviço$")
//    public void devoValidarONomeItanhaémNoRetornoDoServiço(String city) {
//        Assert.assertEquals(city, VariaveisEstaticas.getBody());
//    }


//=======================================================================================================================
//=================================================================================================================

    //By City ID

    @Dado("^recuperar os parametros necessarios para localização pelo id \"([^\"]*)\"$")
    public void recuperarOsParametrosNecessariosParaLocalizaçãoPeloId(String id){
        OpenWeatherMapFuncionalidade.getParamsByCityID(id);
    }

    @Quando("^realizar uma requisição GET no serviço pelo id$")
    public void realizarUmaRequisiçãoGETNoServiçoPeloId() {
        OpenWeatherMapFuncionalidade.requisicaoByCityID();
    }

    @Então("^devo validar o nome da cidade \"([^\"]*)\" no retorno do serviço$")
    public void devoValidarONomeDaCidadeNoRetornoDoServiço(String id) {
        Assert.assertEquals(id, VariaveisEstaticas.getBody());
    }


//=======================================================================================================================
//=======================================================================================================================


    //By Geographic Coordinates

    @Dado("^recuperar os parametros pela lat \"([^\"]*)\" e lon \"([^\"]*)\"$")
    public void recuperarOsParametrosPelaLatELon(String lat, String lon) {
        OpenWeatherMapFuncionalidade.getParamsGeographicCoordinates(lat, lon);

    }

    @Quando("^realizar uma requisição GET no serviço para coordenadas$")
    public void realizarUmaRequisiçãoGETNoServiçoParaCoordenadas() {
        OpenWeatherMapFuncionalidade.requisicaoGeographicCoordinates();
    }

    @Então("^devo validar as coordenadas da cidade \"([^\"]*)\" no retorno do serviço$")
    public void devoValidarAsCoordenadasDaCidadeNoRetornoDoServiço(String name) {
        Assert.assertEquals(name, VariaveisEstaticas.getBody());

    }



//=======================================================================================================================
//=======================================================================================================================


    //By ZIP code

    @Dado("^recuperar os os parametros pelo zip \"([^\"]*)\"$")
    public void recuperarOsOsParametrosPeloZip(String zip){
        OpenWeatherMapFuncionalidade.getParamsByZIPCode(zip);
    }

    @Quando("^realizar uma requisição GET no serviço para zip code$")
    public void realizarUmaRequisiçãoGETNoServiçoParaZipCode() {
        OpenWeatherMapFuncionalidade.requisicaoByZIPCode();
    }

    @Então("^devo validar os zip code da cidade \"([^\"]*)\" no retorno do serviço$")
    public void devoValidarOsZipCodeDaCidadeNoRetornoDoServiço(String name) {
        Assert.assertEquals(name, VariaveisEstaticas.getBody());
    }



//=======================================================================================================================
//=======================================================================================================================


    //Rectangle Zone

    @Dado("^recuperar os parametros necessarios para dados da cidade dentro do retangulo \"([^\"]*)\"$")
    public void recuperarOsParametrosNecessariosParaDadosDaCidadeDentroDoRetangulo(String bbox) {
        OpenWeatherMapFuncionalidade.getParamsRectangleZone(bbox);
    }

    @Quando("^realizar uma requisição GET no serviço para retanculo$")
    public void realizarUmaRequisiçãoGETNoServiçoParaRetanculo() {
        OpenWeatherMapFuncionalidade.requisicaoRectangleZone();
    }


    @Então("^devo validar a zona de retangulo \"([^\"]*)\" no retorno do serviço$")
    public void devoValidarAZonaDeRetanguloNoRetornoDoServiço(String list) {
        Assert.assertNotNull( VariaveisEstaticas.getResponseBody().path(list));
    }



//=======================================================================================================================
//=======================================================================================================================


    //Cities In Circle

    @Dado("^recuperar os parametros pela lat \"([^\"]*)\" lon \"([^\"]*)\" e cnt \"([^\"]*)\"$")
    public void recuperarOsParametrosPelaLatLonECnt(String lat, String lon, String cnt) {
        OpenWeatherMapFuncionalidade.getCitieInCircle(lat, lon, cnt);
    }

    @Quando("^realizar uma requisição GET no serviço para circulo$")
    public void realizarUmaRequisiçãoGETNoServiçoParaCirculo() {
        OpenWeatherMapFuncionalidade.requisicaoCitieInCircle();
    }

    @Então("^devo validar a zona do circulo \"([^\"]*)\" no retorno do serviço$")
    public void devoValidarAZonaDoCirculoNoRetornoDoServiço(String list) {
        Assert.assertNotNull(VariaveisEstaticas.getResponseBody().path(list));
    }
}
