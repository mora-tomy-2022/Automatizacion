package pagesObjects;  
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import com.selenium.driver.DriverFactory;

public class DespegarAlojamientosPage extends DriverFactory { 
	
	@FindBy(xpath="//a[@class='header-logo-container']")
	WebElement tituloDespegar; 
	
	@FindBy(xpath="//ul[@class='header-list-products']//a[@class='shifu-3-button-circle HOTELS paint-circle ']")
	WebElement botonAlojamiento; 
	
	@FindBy(xpath="//div[@class='sbox-places-destination--1xd0k']//input[@class='input-tag']")
	WebElement campoLugar; 
	
	@FindBy(xpath ="//div[@class='ac-container']//div[@class='ac-group-container'][1]//ul[@class='ac-group-items']//span[@class='item-text']")
	public List<WebElement> listaLugar;

	@FindBy(xpath="//input[@placeholder='Entrada']")
	WebElement campoEntrada; 
	
	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber -today']")
	WebElement calendarioEntrada ; 
	
	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='calendar-container ']//div[@class='sbox5-monthgrid-datenumber sbox5-monthgrid-datenumber-28']")
	WebElement calendarioSalida; 
	
	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='calendar-footer-cta-container']/button[@class='sbox5-3-btn -primary -md']")
	WebElement botonAplicar; 
	
	@FindBy(xpath="//div[@class='sbox5-distributionPassengers sbox5-box-distributionPassengers-ovr']")
	WebElement campoHabitacion;
	
	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room']//div[@class='stepper__room__row']//div[@class='sbox5-3-steppers -md']/button[@class='steppers-icon-right stepper__icon']")
	public List<WebElement> botonMas; 
	
	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__row']/div['select__row__options__container']//div[@class='select-container']")
	WebElement campoEdad; 
	
	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__row']/div['select__row__options__container']//div[@class='select-container']//option[@value='5']")
	WebElement edad;
	
	@FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='stepper__room__footer ']/a[@class='sbox5-3-btn -md -primary']")
	WebElement botonAplicarHabitacion; 
	
	@FindBy(xpath="//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']")
	WebElement botonBuscar; 
	
   private WebDriver driver = null; 
   WebDriverWait wait = null;
    
    public DespegarAlojamientosPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new  WebDriverWait(driver,10);
    }	
	 
	
	public boolean validarTitulo() {
		return this.tituloDespegar.isDisplayed(); 
	}
	
	public boolean validarBotonAlojamiento() {
		return this.botonAlojamiento.isDisplayed();
	}
	 
	public void clickBotonAlojamiento() {
	    this.botonAlojamiento.click();
	}
	
	public void ingresarLugar(String providerLugares) {
		this.campoLugar.click();
		campoLugar.sendKeys(providerLugares);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac-container']//div[@class='ac-group-container'][1]//ul[@class='ac-group-items']//span[@class='item-text']")));
		campoLugar.sendKeys(Keys.CONTROL);
		campoLugar.sendKeys(Keys.ENTER);
	} 
	
	public void seleccionarPrimerLugar() {
		WebElement lugar = this.listaLugar.get(0);
		wait.until(ExpectedConditions.elementToBeClickable(lugar));
		lugar.click();
		
	}
	
	public void clickEnEntrada () {
		this.campoEntrada.click();
		wait.until(ExpectedConditions.elementToBeClickable(campoEntrada));	
	}
	
	public void seleccionarFechaEntrada() {
		this.calendarioEntrada.click();
	}
	
	public void seleccionarFechaSalida() {
		wait.until(ExpectedConditions.elementToBeClickable(calendarioSalida));
		this.calendarioSalida.click();	
	}
	
	public void clickAplicar() {
		this.botonAplicar.click();
	}
	
	public void ingresarHabitacion(){
		this.campoHabitacion.click();
	}
	
    public void seleccionarCantidadAdulto() {
    	WebElement botonMasAdulto = this.botonMas.get(0);
		wait.until(ExpectedConditions.elementToBeClickable(botonMasAdulto));
		botonMasAdulto.click();
	}
	
    public void seleccionarCantidadNiños() {
    	WebElement botonMasNiño= this.botonMas.get(1);
		wait.until(ExpectedConditions.elementToBeClickable(botonMasNiño));
		botonMasNiño.click(); 
	}
    
    public void seleccionarEdad() {
    	this.campoEdad.click();
    	wait.until(ExpectedConditions.elementToBeClickable(campoEdad));
    }
    
    public void ingresarEdad() {  
    	this.edad.click();
    	wait.until(ExpectedConditions.elementToBeClickable(edad));
    }
    
    public void clickAplicarHabitacion() {
    	this.botonAplicarHabitacion.click();
    }
    
    public DespegarResultadoPage buscarPagina() {
		this.botonBuscar.click(); 
		return new DespegarResultadoPage(this.driver);
	}
    
}
	
