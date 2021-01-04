#language: pt
#enconding: UTF-8
#Author: Gabriele Regina

Funcionalidade: Validar as requisições de usuario

  @listarUsuarios
  Cenario: Validar a lista de usuarios
    Dado recuperar as informações da lista de usuario
    Quando realizar a requisição GET no serviço para listar os usuarios
    Então devo receber a chave "data" no retorno do serviço

  @SingleUser
  Cenario: Validar unico usuario
    Dado recuperar as informações de um unico usuario com id "2"
    Quando realizar a requisição GET no serviço para um unico usuario
    Entao devo receber a chave "data" no retorno do serviço

  @SingleUserNotFound
  Cenario: Validar usuario nao encontrado
    Dado recuperar as informações de um unico usuario com id "23"
    Quando realizar a requisição GET no serviço para usuario nao encontrado
    Entao não devo receber a chave "data" no retorno do serviço

  @ListResource
  Cenario: Validar lista unknown
    Dado recuperar as informações da lista unknown
    Quando realizar a requisição GET no serviço para listar unknown
    Então devo receber a chave "data" no retorno do serviço

  @SingleResource
  Cenario: Validar unico unknown
    Dado recuperar as informações da um unico unknown
    Quando realizar a requisição GET no serviço para um unico unknown
    Entao devo receber a chave "data" no retorno do serviço

  @SingleResourceNotFound
  Cenario: Validar usuario unico nao encontrado
    Dado recuperar as informações da um unico usuario nao encontrado com id "23"
    Quando realizar a requisição GET no serviço para um unico usuario nao encontrado
    Entao não devo receber a chave "data" no retorno do serviço

  @postUser
  Cenário: Validar a criação de um novo usuário
    Dado recuperar as informações de um novo usuario
    Quando realizar a requisição POST no serviço para criar um novo usuario
    Então validar que usuário foi criado com sucesso

  @putUser
  Cenário: Validar a alteração do nome de usuario
    Dado recuperar as informações de alteração de um usuário
    Quando realizar uma requisição PUT no serviço para alterar um usuário
    Então validar que as informações de usuário foi alterado com sucesso

  @deleteUser
  Cenário: Validar a exclusão de um usuário
    Quando realizar uma requição DELETE no serviço para exclusão de um usuário
    Então validar que o usuário foi excluido com sucesso

  @RegisterSuccessful
  Cenario: Validar registro de um novo usuario
    Dado recuperar as informações de um novo usuario para registro com email "eve.holt@reqres.in" e senha "pistol"
    Quando realizar a requisição POST no serviço para o registro de um novo usuario
    Então devo receber a chave "id" no retorno do serviço

  @RegisterUnsuccessful
  Cenario: Valiadar senha nao inserido 
    Dado recuperar as informações de senha nao inserido com email "sydney@fife"
    Quando realizar a requisição POST no serviço de senha nao inserido
    Então devo receber a chave "error" no retorno do serviço

  @LoginSuccessful
  Cenario: Validar login de usuario com sucesso
    Dado recuperar as informações do login de usuario com email "eve.holt@reqres.in" e senha "cityslicka"
    Quando realizar a requisição POST no serviço de login de usuario
    Então devo receber a chave "token" no retorno do serviço

  @LoginUnsuccessful
  Cenario: Valiadar senha nao inserido no login
    Dado recuperar as informações de senha nao inserido com email "peter@klaven" no login
    Quando realizar a requisição POST no serviço de senha nao inserido no login
    Então devo receber a chave "error" no retorno do serviço

  @DelayedResponse
  