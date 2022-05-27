import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class WikiTests1 { 

	@Test(description = "Validar que las busquedas en Wikipedia funcionan")
	
	public void ValidarBusquedaWikipedia() throws Exception {  System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe"); 
	WebDriver driver = new FirefoxDriver();
	driver.get("http://wikipedia.org");
	
	WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']")); 
	Assert.assertTrue(searchInput.isDisplayed());  
	searchInput.sendKeys("Selenium");
	searchInput.submit();
	
	 
	WebElement tituloResultado = driver.findElement(By.id("firstHeading"));   
	Assert.assertTrue(tituloResultado.isDisplayed());
	driver.close();
	} 
	}

	
 