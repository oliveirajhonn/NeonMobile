#language: pt
@Cliente
Funcionalidade: Cliente

Contexto:


  @cadastrar @sucesso
 		Cenario: Cadastrar Cliente
    Dado que estou na tela inicial
    Quando seleciono o botao cadastrar
		E preencho os dados do cliente
    Entao Cadastro com sucesso um novo cliente
    
  
 @consultar_nome @sucesso
  Esquema do Cenario: Consultar nome
    Dado que estou na tela inicial
    Quando seleciono o "<nome>" 
    Entao Consulto as informacoes do cliente
    
    Exemplos:
    |nome|
    |Jhonnatan|
 
 @deletar_cliente_por_nome
  Esquema do Cenario: deletar cliente por nome
 		Dado que estou na tela inicial
 		Quando pressiono o "<nome>"
 		Entao clico no botão excluir
 		
 		Exemplos:
 		|nome|
 		|Jhonnatan|
    