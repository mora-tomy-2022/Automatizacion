package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarResultadoPage {
	
	@FindBy(xpath="//a[@class='header-logo-container']")
	WebElement tituloResultado;
	
	private WebDriver driver = null;
	public  DespegarResultadoPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validarTituloResultado() {
		return this.tituloResultado.isDisplayed();
	} 
 

}
 