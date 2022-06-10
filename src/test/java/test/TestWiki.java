package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;
import pagesObjects.WikiPrincipalPage;
import pagesObjects.WikiResultadoPage;

public class TestWiki extends DriverFactory{
	
	private static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void setup(ITestContext context) {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		driver = LevantarBrowser(driver, navegador, "https://es.wikipedia.org/wiki/Wikipedia:Portada" );
		}
	

	@Test(groups= {"Validar busqueda en Wikipedia", "Navegar entre los difentes botones"}, description = "Validar busqueda en Wikipedia")
	public void ValidarBusquedaWikipedia() throws Exception {  
	WikiPrincipalPage wikiPage = new WikiPrincipalPage(driver);
	Assert.assertTrue(wikiPage.validarTituloBienvenido(), "El titulo no es visible");
	wikiPage.compararTitulo();
	Assert.assertTrue(wikiPage.validarBotonLeer(), "El boton no es visible");
	wikiPage.buscarPagina();
	WikiResultadoPage wikiPageResult = new WikiResultadoPage(driver);
	Assert.assertTrue(wikiPageResult.validarTituloResultado(), "El titulo no es visible"); 

	} 
	@AfterMethod(alwaysRun = true)
    public void endSetup(){
        driver.close(); 
    }  
}  
 