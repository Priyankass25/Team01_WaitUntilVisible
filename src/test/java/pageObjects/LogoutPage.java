package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonMethods;

public class LogoutPage {

	WebDriver driver;
	CommonMethods common;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		this.common = new CommonMethods(driver);
	}
	
	public By logoutBtn = By.id("logout");
	
	public void logoutBtnClick() {
		common.click(logoutBtn);
	}

}


