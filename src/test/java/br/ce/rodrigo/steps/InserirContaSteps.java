package br.ce.rodrigo.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;


public class InserirContaSteps {
	
	WebDriver driver;
	
	@Dado("^que estou acessando a aplicacao$")
	public void queEstouAcessandoAAplicacao() throws Throwable {
		driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com");
	}

	@Quando("^informe o usuario \"([^\"]*)\"$")
	public void informeOUsuario(String arg1) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void aSenha(String arg1) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(arg1);
	}

	@Quando("^selecionar entrar$")
	public void selecionarEntrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Entao("^visualizo a pagina inicial$")
	public void visualizoAPaginaInicial() throws Throwable {
		Assert.assertEquals("Bem vindo, Rodrigo!", driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
		driver.findElement(By.linkText("Contas")).click();
	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Entao("^a conta eh inserida com sucesso$")
	public void aContaEhInseridaComSucesso() throws Throwable {
		Assert.assertEquals("Conta adicionada com sucesso!", driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
	}
	
	@Entao("^sou notificado que o nome da conta eh obrigatorio$")
	public void souNotificadoQueONomeDaContaEhObrigatorio() throws Throwable {
		Assert.assertEquals("Informe o nome da conta", driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText());
	}
	
	@Entao("^sou notificado que ja existe uma com esse nome$")
	public void souNotificadoQueJaExisteUmaComEsseNome() throws Throwable {
		Assert.assertEquals("Informe o nome da conta", driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText());
	}
	
	@Entao("^recebo a mensagem \"([^\"]*)\"$")
	public void receboMensagem(String arg1) throws Throwable {
		Assert.assertEquals(arg1, driver.findElement(By.xpath("//div[starts-with(@class='alert alert-')]")).getText());
	}

	@After(order = 1, value = {"@funcionais"})
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0, value = {"@funcionais"})
	public void fecharBrowser() {			
		driver.quit();
	}

}
