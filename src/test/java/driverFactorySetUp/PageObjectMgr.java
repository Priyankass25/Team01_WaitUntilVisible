package driverFactorySetUp;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;
import pageObjects.ProgramPage2;

public class PageObjectMgr {

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private ProgramPage programPage;
	private ProgramPage2 programPage2;
	
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
	public ProgramPage2 getProgramPage2() {
		if(programPage2 == null) {
			programPage2 = new ProgramPage2(driver);
		}
		return programPage2;
	}
}
