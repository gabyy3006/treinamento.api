package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.DadosMeteorologicosFunc;
import br.com.etech.commons.VariaveisEstaticas;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class DadosMeteorologicosStep {

    DadosMeteorologicosFunc dadosMeteorologicosFunc = new DadosMeteorologicosFunc();

    @Dado("^recuperar os parametros necessarios para localização pelo nome \"([^\"]*)\"$")
    public void recuperarOsParametrosNecessarios(String nome){
        dadosMeteorologicosFunc.getParamsByCountry(nome);
    }

    @Quando("^realizar uma requisição GET no serviço pelo nome do país$")
    public void realizarUmaRequisiçãoGETNoServiçoPeloNomeDoPaís() {
        dadosMeteorologicosFunc.requisicaoByCountry();
    }

    @Então("^devo validar o nome \"([^\"]*)\" no retorno do serviço$")
    public void devoValidarONomeNoRetornoDoServiço(String nome) {
        Assert.assertEquals(nome, VariaveisEstaticas.getBody());
    }


}
