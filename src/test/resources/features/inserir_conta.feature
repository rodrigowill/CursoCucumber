# language: pt
@funcionais
Funcionalidade: inserir conta
	Como usuário
	Eu quero cadastrar contas
	Para poder distribuir meu dinheiro de uma forma mais organizada
	
Contexto:
	Dado que estou acessando a aplicacao
	Quando informe o usuario "rodrigo@soares.com"
	E a senha "123456789"
	E selecionar entrar
	Entao visualizo a pagina inicial
	Quando seleciono Contas
	E seleciono Adicionar

Esquema do Cenario: Deve validar regras cadastro contas
	Quando informo a conta "<conta>"
	E seleciono Salvar
	Entao recebo a mensagem "<mensagem>"
	
Exemplos:
| conta            | mensagem                           |
| Conta de Teste   | Conta adicionada com sucesso!      |
|                  | Informe o nome da conta            |
| Conta mesmo nome | Já existe uma conta com esse nome! |