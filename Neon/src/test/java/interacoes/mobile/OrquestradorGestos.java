package interacoes.mobile;

import java.time.LocalDateTime;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utility.Hook;


public class OrquestradorGestos   {
	
	
	
	private Log logger = LogFactory.getLog(OrquestradorGestos.class);
	
	private AndroidDriver<?> driver;
	
	public OrquestradorGestos() {
		this.driver = Hook.getDriver();
	}
	
	protected void inserirTexto(String elemento, String valor) { 
		try { 
			logger.info(" -- Inserindo texto: '" + valor + "' no elemento: '" +elemento+ "', no dispositivo");
			clicarEm(elemento);
			if (driver.isKeyboardShown()) {
				esconderTeclado();
			}
		
			driver.findElement(By.id(elemento)).sendKeys(valor);
		} catch (NoSuchElementException exc) { 
			logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		}
	}
	protected void esconderTeclado()  {
		
		try
		{
			if (driver.isKeyboardShown()) {
		
				driver.hideKeyboard();
				//Thread.sleep(2000);
			}
		}catch(Exception e) {
			
		}
	
	}
	protected void clicarEm(String elemento) { 
		try { 
			logger.info(" -- Acionando elemento: '" +elemento+ "' no dispositivo");
			driver.findElement(By.id(elemento)).click();
		} catch (NoSuchElementException exc) { 
			logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		}
	}
	
	/*
	 * Valida se elemento existe,
	 * falha o cenario caso NAO exista.
	 * 
	 * Para somente validar presenca de elemento sem falhar o cenario, utilize: 'verificarElemento()'.
	 */
	public boolean validarPresencaElemento(String elemento) { 
		logger.info(" -- Verificando existencia de elemento: '"+elemento+"', no dispositivo");
			try { 
				driver.findElement(By.id(elemento));
				logger.info(" -- Elemento: '"+elemento+"' encontrado no dispositivo");
				return true;
			} catch (NoSuchElementException exc) {
				logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
				Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possa�vel localizar o elemento: '" + elemento + "' em tela.");
				return false;
			}
	}
	
	/*
	 * Somente informa se elemento existe ou nao existe
	 * 
	 * Para somente falhar o cenario caso elemento nao seja encontrado, utilize: 'validarPresencaElemento()'.
	 */
	public boolean verificarElemento(String elemento) { 
		logger.info(" -- Verificando existencia de elemento: '"+elemento+"', no dispositivo");
		try { 
			driver.findElement(By.id(elemento));
			logger.info(" -- Elemento: '"+elemento+"' encontrado no dispositivo");
			return true;
		} catch (NoSuchElementException exc) {
			logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
			return false;
		}
	}
	
	public String obterTexto(String elemento) { 
		try { 
			logger.info(" -- Verificando existencia de elemento: '"+elemento+"', no dispositivo");
			return driver.findElement(By.id(elemento)).getText();
		} catch (NoSuchElementException exc) { 
			logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
			return "";
		}
	}
	
	public void pressionar(WebElement elemento)
	
	{	
		TouchAction action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(elemento))).perform().release();
		//action.longPress(element(elemento));
		//action.tap(new TapOptions().withElement(new ElementOption().withElement(elemento))).perform();
	
	}
	@SuppressWarnings("unused")
	protected void aguardarElementoPor(String elemento, int tempo) {
			try { 
				WebElement elementoEsperado = (new WebDriverWait(driver, tempo))
						.until(ExpectedConditions.presenceOfElementLocated(By.id(elemento)));
			} catch (Exception exc) { 
				logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
				Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
			}
	}
	
	/*
	 * Replicando gestos anteriores, porem com utilizacao do 'Xpath' no lugar de 'ID'.
	 * Espera-se que estaa secao seja removida caso a Alelo ja trabalhe em Aplicoes que so utilizem IDs
	 */
	
	protected void inserirTextoPorXPath(String elemento, String valor) { 
		try { 
			logger.info(" -- Inserindo texto: '" + valor + "' no elemento: '" +elemento+ "', no dispositivo");
			driver.findElement(By.xpath(elemento)).sendKeys(valor);
		} catch (NoSuchElementException exc) { 
			logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		}
	}

	protected void clicarEmPorXpath(String elemento) { 
		try { 
			logger.info(" -- Acionando elemento: '" +elemento+ "' no dispositivo");
			driver.findElement(By.xpath(elemento)).click();
		} catch (NoSuchElementException exc) { 
			logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possa�vel localizar o elemento: '" + elemento + "' em tela.");
		}
	}
	
	/*
	 * Valida se elemento existe,
	 * falha o cenario caso NAO exista.
	 * 
	 * Para somente validar presenca de elemento sem falhar o cenario, utilize: 'verificarElementoPorXpath()'.
	 */
	public boolean validarPresencaElementoPorXpath(String elemento) { 
		logger.info(" -- Verificando existencia de elemento: '"+elemento+"', no dispositivo");
			try { 
				driver.findElement(By.xpath(elemento));
				logger.info(" -- Elemento: '"+elemento+"' encontrado no dispositivo");
				return true;
			} catch (NoSuchElementException exc) {
				logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
				Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possa�vel localizar o elemento: '" + elemento + "' em tela.");
				return false;
			}
	}
	
	/*
	 * Somente informa se elemento existe ou nao existe
	 * 
	 * Para somente falhar o cenario caso elemento nao seja encontrado, utilize: 'validarPresencaElementoPorXpath()'.
	 */
	public boolean verificarElementoPorXpath(String elemento) { 
		logger.info(" -- Verificando existencia de elemento: '"+elemento+"', no dispositivo");
		try { 
			driver.findElement(By.xpath(elemento));
			logger.info(" -- Elemento: '"+elemento+"' encontrado no dispositivo");
			return true;
		} catch (NoSuchElementException exc) {
			logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
			return false;
		}
	}
	
	
	public String obterTextoPorXpath(String elemento) { 
		try { 
			logger.info(" -- Verificando existencia de elemento: '"+elemento+"', no dispositivo");
			return driver.findElement(By.xpath(elemento)).getText();
		} catch (NoSuchElementException exc) { 
			logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
			return "";
		}
	}
	
	@SuppressWarnings("unused")
	protected void aguardarElementoPorXpath(String elemento, int tempo) {
			try { 
				WebElement elementoEsperado = (new WebDriverWait(driver, tempo))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elemento)));
			} catch (Exception exc) { 
				logger.warn(" -- Elemento: '"+elemento+"' NAO encontrado no dispositivo");
				Assert.fail(LocalDateTime.now() + " -- Teste falhado  NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
			}
	}
	

	

}