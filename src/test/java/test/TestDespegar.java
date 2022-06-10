package test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;
import pagesObjects.DespegarAlojamientosPage;
import pagesObjects.DespegarResultadoPage;

public class TestDespegar extends DriverFactory{ 
	private static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true) 
	public void setup(ITestContext context) { 
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "FIREFOX";
		driver = LevantarBrowser(driver, navegador, "https://www.despegar.com.ar/");
		} 
	
	@DataProvider(name="Ingresar diferentes lugares")
	public Object [][] providerLugares(){
		return new Object[][] {{"La Plata, Buenos Aires"},{"Tafí del Valle, Tucumán"}, {"Catamarca"}};	
	}
	
	@Test(groups= {"Registrar un alojamiento para diferentes lugares"}, dataProvider= "Ingresar diferentes lugares", description = "Registrar un alojamiento para diferentes lugares")
	public void ValidarRegistroDeAlojamiento (String providerLugares) throws Exception {   
		DespegarAlojamientosPage despegarPage = new DespegarAlojamientosPage(driver);
		Assert.assertTrue(despegarPage.validarTitulo(), "La pagina no es visible");
		despegarPage.validarBotonAlojamiento();
		despegarPage.clickBotonAlojamiento();
		despegarPage.ingresarLugar(providerLugares); 
		despegarPage.seleccionarPrimerLugar();
		despegarPage.clickEnEntrada();
		despegarPage.seleccionarFechaEntrada();  
		despegarPage.seleccionarFechaSalida(); 
		despegarPage.clickAplicar();
		despegarPage.ingresarHabitacion();
		despegarPage.seleccionarCantidadAdulto();
		despegarPage.seleccionarCantidadNiños();
		despegarPage.seleccionarEdad();
		despegarPage.ingresarEdad();
		despegarPage.clickAplicarHabitacion();	 
		despegarPage.buscarPagina();
		DespegarResultadoPage despegarPageResult = new DespegarResultadoPage(driver);
		Assert.assertTrue(despegarPageResult.validarTituloResultado(), "La pagina no es visible");
		

	} 
	 
	@AfterMethod(alwaysRun = true)
	    public void endSetup(){
	        driver.close();   
	    } 
	    

}
