package driverFactorySetUp;

import org.openqa.selenium.WebDriver;

import context.TestContextSetup;
<<<<<<< HEAD
=======
import pageObjects.BatchPage;
>>>>>>> Ravali
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
<<<<<<< HEAD
=======
	private BatchPage batchPage;
>>>>>>> Ravali
	
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
<<<<<<< HEAD
	public ProgramPage getProgramPage() {
		if(programPage == null) {
			programPage = new ProgramPage(driver, context);
=======
	
	public BatchPage getBatchPage() {
		if(batchPage == null) {
			batchPage= new BatchPage(driver);
>>>>>>> Ravali
		}
		return batchPage;
	}
	
<<<<<<< HEAD
	public LogoutPage getLogoutPage() {
		if(logoutPage == null) {
			logoutPage = new LogoutPage(driver);
		}
		return logoutPage;
	}
}
=======
}
>>>>>>> Ravali
