package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	  WebDriver driver;
//	    CommonMethods common;
//	    ExcelUtils excel;

	    public LoginPage(WebDriver driver){
	        this.driver = driver;
//	        this.common = new CommonMethods(driver);
//	        this.excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
	    }
	    
	    public By user = By.id("username");
	    public By password = By.id("password");
	    public By selectRoleDropdown = By.id("mat-select-0");
	    public By loginBtn = By.id("login");
	    public By adminOption = By.xpath("//mat-option//span[normalize-space()='Admin']");

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
		
}
