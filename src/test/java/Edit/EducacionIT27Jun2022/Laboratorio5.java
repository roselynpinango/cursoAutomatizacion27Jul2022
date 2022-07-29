package Edit.EducacionIT27Jun2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Opción Contáctanos", priority=1)
	public void irAContactanos() {
		// Hacer clic en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		// Completar Formulario		
		Select list = new Select(driver.findElement(By.tagName("select")));
		list.selectByValue("2");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("correo01@micorreo.com");
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		
		// Campo para subir archivos
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Comentarios del Contacto");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
	}
	
	@Test(description="CP02 - Buscar Palabra",priority=2)
	public void buscarPalabra() {
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		driver.findElement(By.name("submit_search")).click();
		
		// Compruebe que despues de hacer clic, el título cambia a Search - My Store
		String tituloEsperado = "Search - My Store";
		String tituloActual = driver.getTitle();
		
		Assert.assertEquals(tituloActual, tituloEsperado);
		
		/* validacion de elementos
		WebElement elementEsperado = null;
		
		try {
			elementEsperado = driver.findElement(By.id("myID"));
		} catch (NoSuchElementException e) {
			// codigo a ejecutar en caso que el try de la excepcion
		}
		
		Assert.assertNotNull(elementEsperado); 
		*/
	}
}
