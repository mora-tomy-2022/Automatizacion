package com.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;

public class WikiTests2 extends DriverFactory{ 
	
	@Test(description = "Validar pagina de Wikipedia")
	public void ValidarBusquedaWikipedia() throws Exception {  
	WebDriver driver = null;
	driver = LevantarBrowser(driver, "CHROME", "https://es.wikipedia.org/wiki/Wikipedia:Portada");
	
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
