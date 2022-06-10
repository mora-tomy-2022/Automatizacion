package pagesObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.driver.DriverFactory;

public class DespegarPrincipalPage  extends DriverFactory {
	
	private WebDriver driver = null;
	WebDriverWait wait = null;
	
	
    @FindBy(xpath="//a[@class='header-logo-container']")
	WebElement tituloDespegar; 
	
	
	@FindBy(xpath ="//li[@class='header-product-item ']")
	public List<WebElement> lista;
	

	 
	 public DespegarPrincipalPage (WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		 this.wait = new  WebDriverWait(driver,10);
	       	 
	    }	 
	
      public boolean validarTitulo() {
			return this.tituloDespegar.isDisplayed();
		}
      
      public void seleccionarBoton() {
    	  for (int i = 1; i < lista.size(); i++) {  
    		  WebElement boton = lista.get(i); 
    		  boton.click(); 
    	  } 
      }    
} 
