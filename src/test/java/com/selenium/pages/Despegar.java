package com.selenium.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;

import org.openqa.selenium.Keys;

public class Despegar extends DriverFactory { 
	
	@Test(description = "Registrar un alojamiento")
	

	public void ValidarBusquedaWikipedia() throws Exception {  
	WebDriver driver = null;
	driver = LevantarBrowser(driver, "FIREFOX", "https://www.despegar.com.ar/"); 
	
	
	WebDriverWait wait = new WebDriverWait(driver, 5);
	WebElement validarTitulo = driver.findElement(By.xpath("//a[@class='header-logo-container']"));
	Assert.assertTrue(validarTitulo.isDisplayed());
	
	
	WebElement clickEnAlojamiento = driver.findElement(By.xpath("//ul[@class='header-list-products']//a[@class='shifu-3-button-circle HOTELS paint-circle ']"));
	Assert.assertTrue(clickEnAlojamiento.isDisplayed(), "Error al cargar pagina");
	clickEnAlojamiento.click(); 
	
	WebElement ingresarLugar = driver.findElement(By.xpath("//div[@class='sbox-places-destination--1xd0k']//input[@class='input-tag']"));
	Assert.assertTrue(ingresarLugar.isDisplayed(), "Error al hacer click en Lugar");
	ingresarLugar.click();
	ingresarLugar.sendKeys("la plata, buenos aires");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac-container']//div[@class='ac-group-container'][1]//ul[@class='ac-group-items']//span[@class='item-text']")));
	ingresarLugar.sendKeys(Keys.CONTROL);  
	ingresarLugar.sendKeys(Keys.ENTER); 
	
	List<WebElement> lugares = driver.findElements(By.xpath("//div[@class='ac-container']//div[@class='ac-group-container'][1]//ul[@class='ac-group-items']//span[@class='item-text']"));
	WebElement seleccionarLugar = lugares.get(0); 
	Thread.sleep(3000); 
	seleccionarLugar.click();       
	 
	WebElement clickEnEntrada = driver.findElement(By.xpath("//input[@placeholder='Entrada']"));
	Assert.assertTrue(clickEnEntrada.isDisplayed(), "Error al hacer click en Entrada");
	clickEnEntrada.click(); 
	wait.until(ExpectedConditions.elementToBeClickable(clickEnEntrada));
	
	 
	WebElement seleccionarFechaEntrada = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber -today']"));
	seleccionarFechaEntrada.click();  
	wait.until(ExpectedConditions.elementToBeClickable(seleccionarFechaEntrada));
	
    WebElement seleccionarFechaSalida = driver.findElement(By.xpath("//[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@data-month='2022-06']//[text()='11']"));
	seleccionarFechaSalida.click(); 
	wait.until(ExpectedConditions.elementToBeClickable(seleccionarFechaSalida));
	
	WebElement clickAplicar = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='calendar-footer-cta-container']/button[@class='sbox5-3-btn -primary -md']"));
	clickAplicar.click();

	WebElement ingresarHabitacion = driver.findElement(By.xpath("//div[@class='sbox5-distributionPassengers sbox5-box-distributionPassengers-ovr']"));
	ingresarHabitacion.click(); 
	
	List<WebElement> cantidadAdultos = driver.findElements(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room']//div[@class='stepper__room__row']//div[@class='sbox5-3-steppers -md']/button[@class='steppers-icon-right stepper__icon']")); 
	WebElement seleccionarAdultos = cantidadAdultos.get(0);
	seleccionarAdultos.click(); 
	wait.until(ExpectedConditions.elementToBeClickable(seleccionarAdultos));
	
	List<WebElement> cantidadNinos = driver.findElements(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room']//div[@class='stepper__room__row']//div[@class='sbox5-3-steppers -md']/button[@class='steppers-icon-right stepper__icon']")); 
	WebElement seleccionarNinos = cantidadNinos.get(1);
	seleccionarNinos.click(); 
	
	WebElement seleccionarEdad = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__row']/div['select__row__options__container']//div[@class='select-container']"));
	seleccionarEdad.click();
	
	WebElement ingresarEdad = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__row']/div['select__row__options__container']//div[@class='select-container']//option[@value='5']"));
	ingresarEdad.click();  
	wait.until(ExpectedConditions.elementToBeClickable(ingresarEdad));
	
	WebElement clickAplicarB = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__footer ']/a[@class='sbox5-3-btn -md -primary']"));
	clickAplicarB.click();
	wait.until(ExpectedConditions.elementToBeClickable(clickAplicarB)); 
  
	WebElement clickBuscar = driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']"));
	clickBuscar.click();
	wait.until(ExpectedConditions.elementToBeClickable(clickBuscar));   
	
	WebElement validarTituloB = driver.findElement(By.xpath("//a[@class='header-logo-container']"));
	Assert.assertTrue(validarTituloB.isDisplayed(), "Error al validar titulo Alojamiento");
	
	driver.close();
	 

	}
}