package pageObjects;

import org.openqa.selenium.*;

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
