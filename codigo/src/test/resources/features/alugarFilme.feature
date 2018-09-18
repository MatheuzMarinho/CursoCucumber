# language: pt
Funcionalidade: Alugar Filme
  Como um usuario 
  Eu quero cadastrar alugueis de filmes
  Para controlar precos e datas de entrega

  Cenario: Deve alugar um filme com sucesso
    Dado um filme com estoque de 2 unidades
    E que o preço de aluguel seja R$ 3.0
    Quando alugar
    Entao o preco do aluguel sera R$ 3.0

  Cenario: Deve criar e alugar um filme com sucesso
    Dado um filme
      | estoque | 2 |
      | preco   | 3 |
    Quando alugar
    Entao o preco do aluguel sera R$ 3

  Cenario: Nao deve alugar filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar
    Entao nao sera possivel por falta de estoque
