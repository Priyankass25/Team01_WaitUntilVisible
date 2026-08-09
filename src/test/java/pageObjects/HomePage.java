package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactorySetUp.DriverFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public By programNavBar = By.id("program");
	
	public String getcurrentURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}
	
	public void prgmNavgationBarClick() {
		driver.findElement(programNavBar).click();
	}
}
