package driverFactorySetUp;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;

public class PageObjectMgr {

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private ProgramPage programPage;
	
	public PageObjectMgr(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}
	
	public HomePage getHomePage() {
		if(homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}
	public ProgramPage getProgramPage() {
		if(programPage == null) {
			programPage = new ProgramPage(driver);
		}
		return programPage;
	}
}
