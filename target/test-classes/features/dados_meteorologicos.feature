#language: pt
#enconding: UTF-8
#Author: Guilherme Teixeira

Funcionalidade: Validar a chamada dos dados meteorológicos atuais para um local

  @localByCountry
  Cenário: Validar a chamada dos dados meteorológicos para um local pelo nome do país
    Dado recuperar os parâmetros necessários para localização pelo nome "London"
    Quando realizar um requisição GET no serviço pelo nome do país
    Então devo validar o nome "London" no retorno do serviço