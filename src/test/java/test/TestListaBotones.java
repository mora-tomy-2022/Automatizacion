package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;

import pagesObjects.DespegarPrincipalPage;


public class TestListaBotones extends DriverFactory {
	
	private static WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = LevantarBrowser(driver, "FIREFOX", "https://www.despegar.com.ar/");
		}
	
	@Test(description = "Navegar entre los difentes botones")
	public void NavegacionPorBotones () throws Exception {   
		DespegarPrincipalPage despegarPrincipalPage = new DespegarPrincipalPage(driver);
		Assert.assertTrue(despegarPrincipalPage.validarTitulo(), "El titulo no es visible");
		despegarPrincipalPage.seleccionarBoton();   
		   
	}   
	  
	@AfterMethod
	    public void endSetup(){
	        driver.close();   
	    }  
 
}    
 