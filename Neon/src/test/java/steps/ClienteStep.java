package steps;

import basePages.ClientePage;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ClienteStep 
{
	private ClientePage page = new ClientePage();
	private String nome = "Jhonnatan";
	
	@Dado("^que estou na tela inicial$")
	public void que_estou_na_tela_inicial() throws Throwable {
		page.validarTelaInicial();
		

	}

	@Quando("^seleciono o botao cadastrar$")
	public void seleciono_o_botao_cadastrar() throws Throwable {
		page.clicarNoBotaoCadastrar();
	
	
	}


	@Entao("^Cadastro com sucesso um novo cliente$")
	public void cadastro_com_sucesso_um_novo_cliente() throws Throwable {
		page.validarCadastro(nome);
	
	}
	
	@Quando("^seleciono o \"([^\"]*)\"$")
	public void seleciono_o(String arg1) throws Throwable {
	   page.clicarNomeNaLista(arg1);
	}
	
	
	
	@Entao("^Consulto as informacoes do cliente$")
	public void consulto_as_informacoes_do_cliente() throws Throwable {
	    page.consultar(nome);
	  
	}
	
	
	@Quando("^pressiono o \"([^\"]*)\"$")
	public void pressiono_o(String arg1) throws Throwable {
		page.pressionar_excluir(arg1);
	}
	
	@Quando("^preencho os dados do cliente$")
	public void preencho_os_dados_do_cliente() throws Throwable {
		page.cadastrar(nome,"11982088952","jhonnatan@neon.com.br","000.000.000-00","futuro membro do time neon","campo de observacao");
	
		      
	}
	
	@Entao("^clico no botão excluir$")
	public void clico_no_botão_excluir() throws Throwable {
		page.excluir(nome);
	}
	

}
