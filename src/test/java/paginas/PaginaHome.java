package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaHome {
	// Elementos de la Página que voy a utilizar
	@FindBy(partialLinkText="Sign")
	WebElement lnkSignIn;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	// Constructor: Es lo que permite utilizar estos elementos y sus acciones
	// Lo que hace es iniciar los elementos para su uso
	public PaginaHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre los elementos de la página que voy a utilizar
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void hacerClicEnContactUs() {
		lnkContactUs.click();
	}
}
