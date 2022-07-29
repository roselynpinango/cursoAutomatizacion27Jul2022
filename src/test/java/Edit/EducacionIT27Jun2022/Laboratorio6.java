package Edit.EducacionIT27Jun2022;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Laboratorio6 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe";
	String dirEvidencias = "..\\EducacionIT27Jun2022\\Evidencias\\";
	String nombreDocumento = "Evidencias - AutomationPractice.docx";
	String nombreImg = "img.jpg";
	WebDriver driver;
	File screen;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Opción Contáctanos", priority=1)
	public void irAContactanos() throws IOException {
		// Captura de Evidencia
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "01_PaginaPrincipal.jpg"));
		
		// Hacer clic en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "02_EntrandoAContactUs.jpg"));
		
		// Completar Formulario		
		Select list = new Select(driver.findElement(By.tagName("select")));
		list.selectByValue("2");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("correo01@micorreo.com");
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		
		// Campo para subir archivos
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Comentarios del Contacto");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "03_FormularioLleno.jpg"));
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "04_ResultadoObtenido.jpg"));
	}
	
	@Test(description="CP02 - Opción Contáctanos con Documento de Evidencias", priority=1)
	public void irAContactanosConDocumento() throws IOException, InvalidFormatException, InterruptedException {
		// Capturar pantalla en documento
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Documento de Evidencias - AutomationPractice", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg, dirEvidencias + nombreDocumento, "Paso 1 - Página Principal");		
		
		// Hacer clic en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg, dirEvidencias + nombreDocumento, "Paso 2 - Luego de acceder a Contact Us");
		
		// Completar Formulario		
		Select list = new Select(driver.findElement(By.tagName("select")));
		list.selectByValue("2");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("correo01@micorreo.com");
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		
		// Campo para subir archivos
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Comentarios del Contacto");

		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg, dirEvidencias + nombreDocumento, "Paso 3 - Luego de completar el formulario");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg, dirEvidencias + nombreDocumento, "Paso 4 - Luego de hacer clic en Enviar");
	}
}
