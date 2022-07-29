package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaContactUs;
import paginas.PaginaHome;
import paginas.PaginaLogin;

public class Laboratorio7a {
	String url = "http://automationpractice.com";
	String firefoxDriverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		// Clic en Sign In
		PaginaHome home = new PaginaHome(driver);
		home.hacerClicEnSignIn();
		
		// Completar las credenciales para iniciar sesión
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo01@gmail.com");
		login.escribirContrasenia("1q2w3e4r5t");
		login.hacerClicEnElBotonLogin();
	}
	
	@Test
	public void irAContactanos() {
		PaginaHome home = new PaginaHome(driver);
		home.hacerClicEnContactUs();
		
		PaginaContactUs contacto = new PaginaContactUs(driver);
		contacto.seleccionarSubject("Webmaster");
		contacto.escribirEmail("correo02@gmail.com");
		contacto.escribirOrder("3B");
		contacto.adjuntarArchivo("C:\\addIntegerData.txt");
		contacto.escribirMensaje("Mensaje de Contacto");
		contacto.hacerClicEnElBotonSend();
	}
}
