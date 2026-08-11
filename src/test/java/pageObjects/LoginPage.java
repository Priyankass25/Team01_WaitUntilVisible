package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.ConfigReader;


public class LoginPage {

	WebDriver driver;
	CommonMethods common;
	TestContextSetup context;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.common = new CommonMethods(driver);
	}

	public By user = By.id("username");
	public By password = By.id("password");
	public By selectRoleDropdown = By.id("mat-select-0");
	public By loginBtn = By.id("login");
	public By adminOption = By.xpath("//mat-option//span[normalize-space()='Admin']");
	public By Dashboard = By.name(" Dashboard");
	public By LMStext = By.xpath("//img[@src='assets/img/LMS-logo.jpg']");
	public By logo = By.xpath("//img[contains(@src, 'logo')]");
	public By loginmsg = By.xpath("//p[contains(text(),'Please login to LMS application')]");
	public By usertext = By.xpath("//span[contains(text(),'User')]");
	public By pwdtext = By.xpath("//span[contains(text(),'Password')]");
	public By userasterik = By.xpath("//span[contains(text(),'User')]/following::span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c159-14 ng-star-inserted']");
	public By pwdasterik = By.xpath("//span[contains(text(),'Password')]/following::span[contains(text(), ' *')][1]");
	public By selecttext = By.xpath("//span[@class='ng-tns-c159-16 ng-star-inserted']");
	public By Optionstaff = By.xpath("//mat-option//span[normalize-space()=' Staff ']");
	public By Optionstu = By.xpath("//mat-option//span[normalize-space()=' Student ']");

	public boolean isLoginPageLoaded() {
		return driver.getCurrentUrl().contains("login");
	}

	public void enterUser(String username) {
		driver.findElement(user).clear();
		driver.findElement(user).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
	}

	public void selectRole() {
		driver.findElement(selectRoleDropdown).click();
		driver.findElement(adminOption).click();
	}

	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}

	public boolean isDashboardTextDisplayed() {
		return common.isDisplayed(Dashboard);
	}

	public void enterinvalidurl() {
		String invalid_url = ConfigReader.getProperty("invalid_url");
		driver.get(invalid_url);
		// LoggerLoad.info("Create Program Name is " +programName);

	}

	public void enterbrokenurl() {
		String broken_url = ConfigReader.getProperty("broken_url");
		driver.get(broken_url);
	}

	public void isLMSTextDisplayed() {
		boolean LMS = common.isDisplayed(LMStext);
		Assert.assertTrue(LMS, "LMS header image is displayed on the login page!");
	}

	public void isCompanynameDisplayed() {
		String text = common.getText(LMStext);
		Assert.assertEquals(text, "Numpy Ninja");
	}

	public boolean isLogoDisplayed() {
		return common.isDisplayed(logo);

	}

	public void isloginmsgDisplayed() {
		String text = common.getText(loginmsg);
		Assert.assertEquals(text, "Please login to LMS application");
	}

	public void textfieldPresence() {
		common.isDisplayed(user);
	}

	public void roledropdown() {
		driver.findElement(selectRoleDropdown).click();
		common.waitForVisibility(adminOption);

	}

	public void textname() {
		common.isDisplayed(usertext);

	}

	public void pwdname() {
		common.isDisplayed(pwdtext);

	}

	public void textnameasterisk() {
		common.isDisplayed(userasterik);

	}

	public void pwdnameasterisk() {
		common.isDisplayed(pwdasterik);

	}

	public void selectPlaceholder() {
		common.isDisplayed(selecttext);

	}

	public void selectPlaceholdervalues() {
		common.isDisplayed(adminOption);
		common.isDisplayed(Optionstaff);
		common.isDisplayed(Optionstu);

	}
}
