package driverFactorySetUp;

import org.openqa.selenium.WebDriver;

import context.TestContextSetup;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ProgramPage;

public class PageObjectMgr {
	
	private WebDriver driver;
	private TestContextSetup context;

	private LoginPage loginPage;
	private HomePage homePage;
	private ProgramPage programPage;
	private LogoutPage logoutPage;
	
	public PageObjectMgr(WebDriver driver, TestContextSetup context) {
		this.driver = driver;
		this.context = context;
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
			programPage = new ProgramPage(driver, context);
		}
		return programPage;
	}
	
	public LogoutPage getLogoutPage() {
		if(logoutPage == null) {
			logoutPage = new LogoutPage(driver);
		}
		return logoutPage;
	}
}
