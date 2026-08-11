package driverFactorySetUp;

import org.openqa.selenium.WebDriver;

import context.TestContextSetup;


import pageObjects.BatchPage;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ProgramPage;
import utilities.CommonMethods;

public class PageObjectMgr {
	
	private WebDriver driver;
	private TestContextSetup context;

    private CommonMethods common;

	private LoginPage loginPage;
	private HomePage homePage;
	private ProgramPage programPage;
	private LogoutPage logoutPage;

	private BatchPage batchPage;

	
	public PageObjectMgr(WebDriver driver, TestContextSetup context) {
		this.driver = driver;
		this.context = context;
	}
	
	public CommonMethods getCommon() {
	     if (common == null) {
	          common = new CommonMethods(driver);
	        }
	        return common;
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
		}return programPage;
	}
	
	public BatchPage getBatchPage() {
		if(batchPage == null) {
			batchPage= new BatchPage(driver);

		}
		return batchPage;
	}
	

	public LogoutPage getLogoutPage() {
		if(logoutPage == null) {
			logoutPage = new LogoutPage(driver);
		}
		return logoutPage;
	}
}




