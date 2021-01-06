#language: pt
#enconding: UTF-8
#Author: Gabriele Regina

Funcionalidade: Validar a chamada dos dados meteorologicos atuais para um local

  @localByCountry
  Cenário: Validar a chamada dos dados meteorologicos para um local pelo nome do país
    Dado recuperar os parametros necessarios para localização pelo nome "Brazil"
    Quando realizar uma requisição GET no serviço pelo nome do país
    Então devo validar o nome "Brazil" no retorno do serviço

  @ByCityName
  Cenario: Validar a chamada dos dados meteorologicos para um local pelo nome da cidade
    Dado recuperar os parametros necessarios para localização pelo nome "Itanhaém"
    Quando realizar uma requisição GET no serviço pelo nome da cidade
    Então devo validar o nome "Itanhaém" no retorno do serviço

  @ByCityID
  Cenario: Validar a chamada dos dados meteorologicos para um local pelo ID
    Dado recuperar os parametros necessarios para localização pelo id "3460791"
    Quando realizar uma requisição GET no serviço pelo id
    Então devo validar o nome da cidade "Itanhaém" no retorno do serviço

  @ByGeographicCoordinates
  Cenario: Validar a chamada dos dados meteorologicos para um local pelas Geographic Coordinates
    Dado recuperar os parametros pela lat "-24.18306" e lon "-46.788891"
    Quando realizar uma requisição GET no serviço para coordenadas
    Então devo validar as coordenadas da cidade "Itanhaém" no retorno do serviço

  @ByZipCode
  Cenario: Validar a chamada dos dados meteorologicos para um local pelo zip code
    Dado recuperar os os parametros pelo zip "66756"
    Quando realizar uma requisição GET no serviço para zip code
    Então devo validar os zip code da cidade "Mulberry" no retorno do serviço

  @RectangleZone
  Cenario: Validar a chamada dos dados dentro do retangulo definido
    Dado recuperar os parametros necessarios para dados da cidade dentro do retangulo "12,32,15,37,10"
    Quando realizar uma requisição GET no serviço para retanculo
    Então devo validar a zona de retangulo "list" no retorno do serviço

  @CitiesInCircle
  Cenario: Validar a chamada dos dados dentro do circulo definido
    Dado recuperar os parametros pela lat "50" lon "100" e cnt "8"
    Quando realizar uma requisição GET no serviço para circulo
    Então devo validar a zona do circulo "weather" no retorno do serviço