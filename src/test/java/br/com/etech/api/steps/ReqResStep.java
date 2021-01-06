package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.ReqresFuncionalidade;
import br.com.etech.commons.VariaveisEstaticas;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class ReqResStep {

    ReqresFuncionalidade reqresFuncionalidade = new ReqresFuncionalidade();

    //listar Usuarios

    @Dado("^recuperar as informações da lista de usuario$")
    public void recuperarAsInformaçõesDaListaDeUsuario() {
        reqresFuncionalidade.getParamsListUsers("2");
    }

    @Quando("^realizar a requisição GET no serviço para listar os usuarios$")
    public void realizarARequisiçãoGETNoServiçoParaListarOsUsuarios() {
        reqresFuncionalidade.requisicaoListUsers();
    }

    @Então("^devo receber a chave \"([^\"]*)\" no retorno do serviço$")
    public void devoReceberAChaveNoRetornoDoServiço(String chave) {
        reqresFuncionalidade.retornoChave(chave);
    }



//=====================================================================================================================
//=================================================================================================================


    //Single User

    @Dado("^recuperar as informações de um unico usuario com id \"([^\"]*)\"$")
    public void recuperarAsInformaçõesDeUmUnicoUsuarioComId(String id) {
        reqresFuncionalidade.getParamsSingleUser(id);
    }

    @Quando("^realizar a requisição GET no serviço para um unico usuario$")
    public void realizarARequisiçãoGETNoServiçoParaUmUnicoUsuario() {
        reqresFuncionalidade.requisicaoSingleUser();
    }



//=====================================================================================================================
//=================================================================================================================


   //Single User Not Found

    @Dado("^recuperar as informações de um usuario nao encontrado$")
    public void recuperarAsInformaçõesDeUmUsuarioNaoEncontrado(String id) {
        reqresFuncionalidade.getParamsSingleUserNotFound(id);
    }

    @Quando("^realizar a requisição GET no serviço para usuario nao encontrado$")
    public void realizarARequisiçãoGETNoServiçoParaUsuarioNaoEncontrado() {
        reqresFuncionalidade.requisicaoSingleUserNotFound();
    }


    @Entao("^não devo receber a chave \"([^\"]*)\" no retorno do serviço$")
    public void nãoDevoReceberAChaveNoRetornoDoServiço(String chave) {
        reqresFuncionalidade.retornoNuloChave(chave);
    }



//=====================================================================================================================
//=================================================================================================================


    //List Resource

    @Dado("^recuperar as informações da lista unknown$")
    public void recuperarAsInformaçõesDaListaUnknown() {
        reqresFuncionalidade.getParamsListResource("1");
    }

    @Quando("^realizar a requisição GET no serviço para listar unknown$")
    public void realizarARequisiçãoGETNoServiçoParaListarUnknown() {
        reqresFuncionalidade.requisicaoListResource();
    }




//=====================================================================================================================
//=================================================================================================================


    //Single Resource

    @Dado("^recuperar as informações da um unico unknown$")
    public void recuperarAsInformaçõesDaUmUnicoUnknown() {
        reqresFuncionalidade.getParamsSingleResource("2");
    }

    @Quando("^realizar a requisição GET no serviço para um unico unknown$")
    public void realizarARequisiçãoGETNoServiçoParaUmUnicoUnknown() {
        reqresFuncionalidade.requisicaoSingleResource();
    }



//=======================================================================================================================
//=================================================================================================================


    //Single Resource Not Found

    @Dado("^recuperar as informações da um unico usuario nao encontrado com id \"([^\"]*)\"$")
    public void recuperarAsInformaçõesDaUmUnicoUsuarioNaoEncontradoComId(String id) {
        reqresFuncionalidade.getParamsSingleResourceNotFound(id);

    }

    @Quando("^realizar a requisição GET no serviço para um unico usuario nao encontrado$")
    public void realizarARequisiçãoGETNoServiçoParaUmUnicoUsuarioNaoEncontrado() {
        reqresFuncionalidade.requisicaoSingleResourceNotFound();
    }


//=======================================================================================================================
//=================================================================================================================


    //Post User

    @Dado("^recuperar as informações de um novo usuario$")
    public void recuperarAsInformacoesDeUmNovoUsuario() {
        reqresFuncionalidade.getBodyUser();
    }

    @Quando("^realizar a requisição POST no serviço para criar um novo usuario$")
    public void realizarARequisiçãoPOSTNoServiçoParaCriarUmNovoUsuario() {
        reqresFuncionalidade.requisicaoPostUser();
    }

    @Então("^validar que usuário foi criado com sucesso$")
    public void validarQueUsuárioFoiCriadoComSucesso() {
        Assert.assertNotNull(VariaveisEstaticas.getBody());
    }


//=======================================================================================================================
//=================================================================================================================


    //put User

    @Dado("^recuperar as informações de alteração de um usuário$")
    public void recuperarAsInformaçõesDeAlteraçãoDeUmUsuário() {
        reqresFuncionalidade.putBodyUser();
    }

    @Quando("^realizar uma requisição PUT no serviço para alterar um usuário$")
    public void realizarUmaRequisiçãoPUTNoServiçoParaAlterarUmUsuário() {
        reqresFuncionalidade.requisicaoPutUser();
    }

    @Então("^validar que as informações de usuário foi alterado com sucesso$")
      public void validarQueAsInformaçõesDeUsuárioFoiAlteradoComSucesso() {
       Assert.assertNotNull(VariaveisEstaticas.getBody());
   }


//=======================================================================================================================
//=================================================================================================================


    //delete User

    @Quando("^realizar uma requição DELETE no serviço para exclusão de um usuário$")
    public void realizarUmaRequiçãoDELETENoServiçoParaExclusãoDeUmUsuário() {
        reqresFuncionalidade.requisicaoDeleteUser();

    }

    @Então("^validar que o usuário foi excluido com sucesso$")
    public void validarQueOUsuárioFoiExcluidoComSucesso() {
        Assert.assertNotNull(VariaveisEstaticas.getCookie());
    }



//=======================================================================================================================
//=================================================================================================================


    //Register Successful

    @Dado("^recuperar as informações de um novo usuario para registro com email \"([^\"]*)\" e senha \"([^\"]*)\"$")
    public void recuperarAsInformaçõesDeUmNovoUsuarioParaRegistroComEmailESenha(String email, String senha) {
        reqresFuncionalidade.postRegisterSuccessful(email, senha);
    }

    @Quando("^realizar a requisição POST no serviço para o registro de um novo usuario$")
    public void realizarARequisiçãoPOSTNoServiçoParaORegistroDeUmNovoUsuario() {
        reqresFuncionalidade.requisicaoRegisterSuccessful();
    }




//=======================================================================================================================
//=================================================================================================================


    //Register Unsuccessful

    @Dado("^recuperar as informações de senha nao inserido com email \"([^\"]*)\"$")
    public void recuperarAsInformaçõesDeSenhaNaoInseridoComEmail(String email) {
        reqresFuncionalidade.postRegisterUnsuccessful(email);
    }

    @Quando("^realizar a requisição POST no serviço de senha nao inserido$")
    public void realizarARequisiçãoPOSTNoServiçoDeSenhaNaoInserido() {
        reqresFuncionalidade.requisicaoRegisterUnsuccessful();
    }




//=======================================================================================================================
//=================================================================================================================


    //Login Successful

    @Dado("^recuperar as informações do login de usuario com email \"([^\"]*)\" e senha \"([^\"]*)\"$")
    public void recuperarAsInformaçõesDoLoginDeUsuarioComEmailESenha(String email, String senha){
        reqresFuncionalidade.postLoginSuccessful(email, senha);
    }

    @Quando("^realizar a requisição POST no serviço de login de usuario$")
    public void realizarARequisiçãoPOSTNoServiçoDeLoginDeUsuario() {
        reqresFuncionalidade.requisicaoLoginSuccessful();
    }


//=======================================================================================================================
//=================================================================================================================


    //Login Unsuccessful

    @Dado("^recuperar as informações de senha nao inserido com email \"([^\"]*)\" no login$")
    public void recuperarAsInformaçõesDeSenhaNaoInseridoComEmailNoLogin(String email) {
        reqresFuncionalidade.postLoginUnsuccessful(email);
    }

    @Quando("^realizar a requisição POST no serviço de senha nao inserido no login$")
    public void realizarARequisiçãoPOSTNoServiçoDeSenhaNaoInseridoNoLogin() {
        reqresFuncionalidade.requisicaoLoginUnsuccessful();
    }


}
