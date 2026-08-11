package pageObjects;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.Assert;

import utilities.CommonMethods;

public class HomePage {

	WebDriver driver;
	CommonMethods common;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.common = new CommonMethods(driver);
	}

	public By LMS = By.xpath("//span[contains(text(),'LMS - Learning Management System')]");
	public By menuItems = By.xpath("//a[contains(@class,'menu-item')]");

	public By programNavBar = By.id("program");

	public String getcurrentURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}

	public void prgmNavgationBarClick() {
		driver.findElement(programNavBar).click();
	}

	public void verifyLMSTextAlignment() {
		String alignment = driver.findElement(LMS).getCssValue("text-align");

		Assert.assertEquals(alignment, "center", "Text is not center aligned");
	}

	public void verifyLMSTextPresence() {
		String txt = common.getText(LMS);

		Assert.assertEquals(txt, "LMS - Learning Management System", "Text doesn't match");
	}

	public void verifyHomeIsFirst() {

		List<WebElement> items = driver.findElements(menuItems);

		String firstItem = items.get(0).getText().trim();

		Assert.assertEquals(firstItem, "Home", "Home is not the first menu item");
	}

	public void verifyProgramIsSecond() {

		List<WebElement> items = driver.findElements(menuItems);

		String firstItem = items.get(1).getText().trim();

		Assert.assertEquals(firstItem, "Program", "Home is not the second menu item");
	}

	public void verifyBatchISThird() {

		List<WebElement> items = driver.findElements(menuItems);

		String firstItem = items.get(2).getText().trim();

		Assert.assertEquals(firstItem, "Batch", "Home is not the third menu item");
	}

	public void verifyLogOutIsForth() {

		List<WebElement> items = driver.findElements(menuItems);

		String firstItem = items.get(3).getText().trim();

		Assert.assertEquals(firstItem, "LogOut", "Home is not the forth menu item");
	}
}
