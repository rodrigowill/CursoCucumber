# language: pt
@unitarios
Funcionalidade: Locadora
	Como um usu�rio
	Eu quero cadastrar alugu�is de filmes
	Para Controlar pre�os e datas de entrega
	
Cen�rio: Deve alugar um filme com sucesso
	Dado um filme
		| estoque | 2     |
		| preco   | 3     |
		| tipo    | comum |
	Quando alugar
	Ent�o o pre�o do aluguel ser� R$ 3
	E a data de entrega ser� em 1 dia
	E o estoque do filme ser� 1 unidade
	
Cen�rio: N�o deve alugar um filme sem estoque
	Dado um filme com estoque de 0 unidades
	Quando alugar
	Ent�o n�o ser� poss�vel por falta de estoque
	E o estoque do filme ser� 0 unidade

Esquema do Cen�rio: Deve dar condi��es conforme tipo de aluguel																																																																																															 
	Dado um filme com estoque de 2 unidades
	E que o pre�o de aluguel seja R$ <preco>
	E que o tipo de aluguel seja <tipo>
	Quando alugar
	Ent�o o pre�o do aluguel ser� R$ <valor>
	E a data de entrega ser� em <qtdDias> dias
	E a pontua��o recebida ser� de <pontuacao> pontos

Exemplos:
	| preco | tipo      | valor | qtdDias | pontuacao |
	|   4   | extendido |   8   |    3    |     2     |
	|   4   | comum     |   4   |    1    |     1     |
	|   5   | semanal   |  15   |    7    |     3     |