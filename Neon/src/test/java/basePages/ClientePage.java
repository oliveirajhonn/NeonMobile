package basePages;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import interacoes.mobile.OrquestradorGestos;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.Hook;

public class ClientePage extends OrquestradorGestos
{
	private AndroidDriver<?> driver;
	private String btnCadastro;
	private String txtNome;
	private String txtTelefone;
	private String txtEmail;
	private String txtCpf;
	private String txtDescricao;
	private String dtData;
	private String dtOk;
	private String txtObservacao;
	private String btnSalvar;
	private String btnVoltar;
	private String txtNomeConsulta;
	private String txtExcluir;
	private String lblTelaInicial;
		
	public ClientePage() 
		{
			this.driver = Hook.getDriver();
			this.driver = driver;
			this.btnCadastro = "br.com.wagner.cadastrodeclientes:id/imageView7";
			this.txtNome = "br.com.wagner.cadastrodeclientes:id/txtNome";
			this.txtTelefone = "br.com.wagner.cadastrodeclientes:id/txtTelefone";
			this.txtEmail = "br.com.wagner.cadastrodeclientes:id/txtEmail";
			this.txtCpf = "br.com.wagner.cadastrodeclientes:id/txtCpf";
			this.txtDescricao = "br.com.wagner.cadastrodeclientes:id/txtDescricao";
			this.dtData = "br.com.wagner.cadastrodeclientes:id/chooseDateButton";
			this.dtOk = "android:id/button1";
			this.txtObservacao = "edtObs";
			this.btnSalvar = "br.com.wagner.cadastrodeclientes:id/imageView12";
			this.btnVoltar = "br.com.wagner.cadastrodeclientes:id/ibVoltar";
			this.txtNomeConsulta = "br.com.wagner.cadastrodeclientes:id/txvExNome";
			this.txtExcluir = "br.com.wagner.cadastrodeclientes:id/imageView9";
			this.lblTelaInicial = "br.com.wagner.cadastrodeclientes:id/textView4";
		
		}
		
		
	
	public void validarTelaInicial()
	{
		if(!validarPresencaElemento(lblTelaInicial))
		{
			Assert.fail("tela inicial não encontrada");
		}
	}
	public void clicarNoBotaoCadastrar()
	{
		clicarEm(btnCadastro);
	}

		public void cadastrar(String nome, String telefone, String email, String cpf, String desc, String obs) 
		{		
			esconderTeclado();
			inserirTexto(txtNome, nome);
			inserirTexto(txtTelefone, telefone);
			inserirTexto(txtEmail, email);
			inserirTexto(txtCpf, cpf);
			inserirTexto(txtDescricao, desc);

			clicarEm(dtData);
			clicarEm(dtOk);
			inserirTexto(txtObservacao, obs);
			clicarEm(btnSalvar);
			
		}
		
		public void clicarNomeNaLista(String nome)
		{
			buscarNomeNaLista(nome).click();
		}
		
		public void consultar(String nome)
		{
			if(!obterTexto(txtNomeConsulta).equalsIgnoreCase(nome))
			{
				Assert.fail();
			}
			clicarEm(btnVoltar);
		}
		
		public boolean validarNomeNaLista(String nome)
		{	
			if(!(buscarNomeNaLista(nome) == null))
			{
				return true;
			}
			return false;
		}
		
		public void validarCadastro(String nome)
		{
			if(!(validarNomeNaLista(nome)))
			{
				Assert.fail();
			}
		}
		public void pressionar_excluir(String nome)
		{
			pressionar(buscarNomeNaLista(nome));
		}
		
		public void excluir(String nome)
		{
			esconderTeclado();
			aguardarElementoPor(txtExcluir, 2);
			clicarEm(txtExcluir);
			if(!(validarNomeNaLista(nome)))
			{
				Assert.fail();
			}
		}
		
		public WebElement buscarNomeNaLista(String nome)
		{
			int i = 1;
			while(driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[" + i +"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[4]")).size() > 0)
				{	
					WebElement valorTela = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[" + i +"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[4]"));
					if(valorTela.getText().equalsIgnoreCase(nome))
					{
						return valorTela;
					}
					
					i++;
					
				}
				return null;
			
		}
}
