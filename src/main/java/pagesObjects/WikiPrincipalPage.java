package pagesObjects;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WikiPrincipalPage { 
	
	@FindBy(id="Bienvenidos_a_Wikipedia,")
	WebElement tituloBienvenido; 
	
	@FindBy(xpath="//div[@class='main-footer-actions main-plainlist nomobile']/ul/li[1]")
	WebElement botonLeer; 
	
	private WebDriver driver = null;
	
	public WikiPrincipalPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validarTituloBienvenido() {
		return this.tituloBienvenido.isDisplayed();
	}
	
	public void compararTitulo () {
		Object titulo = "Bienvenidos a Wikipedia,"; 
		this.tituloBienvenido.equals(titulo);
	}
	
	public boolean validarBotonLeer() {
		return this.botonLeer.isDisplayed();
	}
	
	public WikiResultadoPage buscarPagina() {
		this.botonLeer.click(); 
		return new WikiResultadoPage(this.driver);
	} 
	 
}
