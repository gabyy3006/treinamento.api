package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.UsuariosFunc;
import br.com.etech.commons.VariaveisEstaticas;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class UsuariosStep {

    UsuariosFunc usuariosFunc = new UsuariosFunc();

    @Dado("^recuperar as informações de um novo usuario$")
    public void recuperarAsInformacoesDeUmNovoUsuario() {
        usuariosFunc.getBodyUser();
    }

    @Dado("^recuperar as informações de alteração de um usuário$")
    public void recuperarAsInformaçõesDeAlteraçãoDeUmUsuário() {
        usuariosFunc.putBodyUser();
    }

    @Quando("^realizar a requisição POST no serviço para criar um novo usuario$")
    public void realizarARequisiçãoPOSTNoServiçoParaCriarUmNovoUsuario() {
        usuariosFunc.requisicaoPostUser();
    }

    @Quando("^realizar uma requisição PUT no serviço para alterar um usuário$")
    public void realizarUmaRequisiçãoPUTNoServiçoParaAlterarUmUsuário() {
        usuariosFunc.requisicaoPutUser();
    }

    @Quando("^realizar uma requição DELETE no serviço para exclusão de um usuário$")
    public void realizarUmaRequiçãoDELETENoServiçoParaExclusãoDeUmUsuário() {
        usuariosFunc.requisicaoDeleteUser();

    }

    @Então("^validar que usuário foi criado com sucesso$")
    public void validarQueUsuárioFoiCriadoComSucesso() {
        Assert.assertNotNull(VariaveisEstaticas.getBody());
    }

    @Então("^validar que as informações de usuário foi alterado com sucesso$")
    public void validarQueAsInformaçõesDeUsuárioFoiAlteradoComSucesso() {
        Assert.assertNotNull(VariaveisEstaticas.getBody());
    }

    @Então("^validar que o usuário foi excluido com sucesso$")
    public void validarQueOUsuárioFoiExcluidoComSucesso() {
        Assert.assertNotNull(VariaveisEstaticas.getCookie());
    }
}
