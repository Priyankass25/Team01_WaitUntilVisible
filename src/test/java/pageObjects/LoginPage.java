package pageObjects;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.LoggerLoad;

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
	public By errorMessageEMT = By.xpath("//mat-error[@role='alert' and normalize-space()='Please enter your user name']");
	public By errorMessageEMTPASS =
	        By.cssSelector("mat-error[role='alert']");
	public By errorMessageRole =
	        By.cssSelector("mat-error[role='alert']");
	private final By roleDropdown = By.id("role");
	public By selectTheRole=By.xpath("//span[text()='Select the role']");
    public By staff=By.id("mat-option-1");
    public By dropdownClose=By.tagName("body");
    private final By dashboardText =
	        By.xpath("//*[normalize-space()='Dashboard']");

	public void selectRole1(String role) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement dropdown = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(roleDropdown)
	    );

	    Select select = new Select(dropdown);
	    select.selectByVisibleText(role);
	}



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

	public void validLoginCredentials() {
		common.validLogin();
	}
	public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


	    String message = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    By.id("errormessage")
	            )
	    ).getText().trim();

	    System.out.println("Error Message: " + message);

	    return message;
	}
	public void clearUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	public String getEmptyUsernameErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(errorMessageEMT)
	    ).getText().trim();
	}
	public String getErrorMessagepass() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    String message = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(errorMessageEMTPASS)
	    ).getText().trim();

	    System.out.println("Error Message: " + message);

	    return message;
	}
	public void enterUserEMT() {
		driver.findElement(user).clear();
		
	}
	public void enterPassEMT() {
		driver.findElement(password).clear();
		//driver.findElement(password).sendKeys(pwd);
	}
	
	public String getErrorMessageRole() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    String message = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(errorMessageRole)
	    ).getText().trim();

	    System.out.println("Error Message: " + message);

	    return message;
	}
	public void selectRole2() {
		
		driver.findElement(selectTheRole).click();
		driver.findElement(staff).click();
		driver.findElement(dropdownClose).click();
		
	}
	public void submitLoginUsingKeyboard() {
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement loginButton = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(loginBtn)
	    );

	    loginButton.sendKeys(Keys.ENTER);
	    
	}
	public boolean isDashboardTextDisplayed1() {
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(dashboardText)
	    ).isDisplayed();
	}
		


}
