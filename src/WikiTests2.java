import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiTests2 { 
	
	@Test(description = "Validar pagina de Wikipedia")
	
	
	public void ValidarBusquedaWikipedia() throws Exception {  System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe"); 
	WebDriver driver = new FirefoxDriver();
	driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
	
	
	String validarBienvenido = driver.findElement(By.id("Bienvenidos_a_Wikipedia,")).getText(); 
	String titulo = "Bienvenidos a Wikipedia,";  
	Assert.assertEquals(validarBienvenido, titulo);
	
	WebElement clickEnLeer = driver.findElement(By.xpath("//div[@class='main-footer-actions main-plainlist nomobile']/ul/li[1]"));
	Assert.assertTrue(clickEnLeer.isDisplayed());
	clickEnLeer.click(); 
	
	WebElement validarTitulo = driver.findElement(By.id("firstHeading"));
	Assert.assertTrue(validarTitulo.isDisplayed());
	
	
	driver.close();
	

} 
}
