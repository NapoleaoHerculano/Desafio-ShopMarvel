# Desafio-ShopMarvel
Um aplicativo básico de e-commerce utilizando a API da MARVEL.

Para a realização do desafio, optei por utilizar as seguintes bibliotecas:
* Navigation - Para utilizar um Layout mais atual e alinhado aos padrões do Google;
* ROOM - Utilizada para realizar a persistência dos dados;
* Retrofit - Utilizada para permitir o consumo de API's via REST.

Sobre os requisitos estabelecidos, acredito que quase todos foram atendidos, com exceção dos testes (hehehe).

A implementação que utilizei na tela principal utilizou 5 "RecyclersViews", cada um com 10 quadrinhos, envolvendo 5 séries distintas. 
Por conta dessa decisão, implementei a regra dos cupons aplicando-a em cada série.

### Bugs conhecidos (dívidas técnicas):
* Ao adicionar mais de uma vez o mesmo quadrinho, as quantidades não são somadas, mas sim criado um novo registro;
* A tela inicial recarrega a cada clique. Assim realizando requisições a cada interação;

