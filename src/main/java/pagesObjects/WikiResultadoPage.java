package pagesObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiResultadoPage {
	
	@FindBy(id="firstHeading")
	WebElement tituloResultado; 
    
	private WebDriver driver = null;
	public WikiResultadoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validarTituloResultado() {
		return this.tituloResultado.isDisplayed();
	}
} 
 