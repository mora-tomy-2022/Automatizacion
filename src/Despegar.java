import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class Despegar { 
	
	@Test(description = "Registrar un alojamiento")
	
	
	public void ValidarBusquedaWikipedia() throws Exception {  System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe"); 
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.despegar.com.ar/");
	
	driver.manage().window().maximize(); //maximiza el navegador

	WebElement validarTitulo = driver.findElement(By.xpath("//a[@class='header-logo-container']"));
	Assert.assertTrue(validarTitulo.isDisplayed());
	
	
	WebElement clickEnAlojamiento = driver.findElement(By.xpath("//ul[@class='header-list-products']//a[@class='shifu-3-button-circle HOTELS paint-circle ']"));
	Assert.assertTrue(clickEnAlojamiento.isDisplayed());
	clickEnAlojamiento.click(); 
	
	WebElement ingresarLugar = driver.findElement(By.xpath("//div[@class='sbox-places-destination--1xd0k']//input[@class='input-tag']"));
	Assert.assertTrue(ingresarLugar.isDisplayed());
	ingresarLugar.click();
	ingresarLugar.sendKeys("la plata, buenos aires");
	Thread.sleep(1000); 
	ingresarLugar.sendKeys(Keys.CONTROL); 
	ingresarLugar.sendKeys(Keys.ENTER);
	
	List<WebElement> lugares = driver.findElements(By.xpath("//div[@class='ac-container']//div[@class='ac-group-container'][1]//ul[@class='ac-group-items']//span[@class='item-text']"));
	WebElement seleccionarLugar = lugares.get(0); 
	Thread.sleep(3000); 
	seleccionarLugar.click();      
	 
	WebElement clickEnEntrada = driver.findElement(By.xpath("//input[@placeholder='Entrada']"));
	Assert.assertTrue(clickEnEntrada.isDisplayed());
	clickEnEntrada.click();  
	Thread.sleep(3000);  
	 
	WebElement seleccionarFechaEntrada = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber -today']"));
	seleccionarFechaEntrada.click();  
	Thread.sleep(3000); 
	
    WebElement seleccionarFechaSalida = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='calendar-container ']//div[@class='sbox5-monthgrid-datenumber sbox5-monthgrid-datenumber-28 -weekday']"));
	seleccionarFechaSalida.click(); 
	Thread.sleep(3000); 
	
	WebElement clickAplicar = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='calendar-footer-cta-container']/button[@class='sbox5-3-btn -primary -md']"));
	clickAplicar.click();

	WebElement ingresarHabitacion = driver.findElement(By.xpath("//div[@class='sbox5-distributionPassengers sbox5-box-distributionPassengers-ovr']"));
	ingresarHabitacion.click(); 
	
	List<WebElement> cantidadAdultos = driver.findElements(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room']//div[@class='stepper__room__row']//div[@class='sbox5-3-steppers -md']/button[@class='steppers-icon-right stepper__icon']")); 
	WebElement seleccionarAdultos = cantidadAdultos.get(0);
	seleccionarAdultos.click(); 
	Thread.sleep(3000); 
	
	List<WebElement> cantidadNiños = driver.findElements(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room']//div[@class='stepper__room__row']//div[@class='sbox5-3-steppers -md']/button[@class='steppers-icon-right stepper__icon']")); 
	WebElement seleccionarNiños = cantidadNiños.get(1);
	seleccionarNiños.click(); 
	
	WebElement seleccionarEdad = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__row']/div['select__row__options__container']//div[@class='select-container']"));
	seleccionarEdad.click();
	
	WebElement ingresarEdad = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__row']/div['select__row__options__container']//div[@class='select-container']//option[@value='5']"));
	ingresarEdad.click();  
	Thread.sleep(3000); 
	
	WebElement clickAplicarB = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__footer ']/a[@class='sbox5-3-btn -md -primary']"));
	clickAplicarB.click();
	Thread.sleep(3000);   
  
	WebElement clickBuscar = driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']"));
	clickBuscar.click();
	Thread.sleep(5000);  
	
	WebElement validarTituloB = driver.findElement(By.xpath("//a[@class='header-logo-container']"));
	Assert.assertTrue(validarTituloB.isDisplayed());
	
	driver.close();
	 

	}
}