package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class DriverFactory { 
	 
	private enum browsers {CHROME, 	FIREFOX};
	
	public static WebDriver LevantarBrowser(WebDriver driver, String browserName, String URL) {
		
		switch (browsers.valueOf(browserName)) {
		case CHROME:
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/maria/eclipse-workspace/test/src/resources/Recursos/chromedriver.exe");
			Reporter.log("Abro Browser");
			driver = new ChromeDriver(); 
			break;
		} 
		case FIREFOX: 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\maria\\eclipse-workspace\\test\\src\\resources\\Recursos\\geckodriver.exe");
			Reporter.log("Abro Browser");
			driver = new FirefoxDriver();
			break;
		}
		default:
			Reporter.log("No seleccionamos ningun navegador, se abrira Chrome");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\maria\\eclipse-workspace\\test\\src\\resources\\Recursos\\chromedriver.exe");
			Reporter.log("abro browser");
			driver = new ChromeDriver();
			break;
		
		}
		
		driver.manage().window().maximize(); 
		driver.get(URL);
		return driver;
		
	}
	

}
