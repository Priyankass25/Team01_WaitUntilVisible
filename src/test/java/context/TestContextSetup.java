package context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import driverFactorySetUp.DriverFactory;
import pageObjects.LoginPage;
import pageObjects.BatchPage;
import utilities.CommonMethods;

public class TestContextSetup {

	private WebDriver driver;
	private LoginPage dashboardPage;
	
	private CommonMethods commonMethods;
	private Map<String, Object> sharedData;
	public final String USERNAME = "firstName";
	public final String EMAIL = "email";
	public final String PASSWORD = "password";
	public final String HC = "healthcondition"; // HC-HealthCondition
	public final int AGE = 0;
	public final String BPSTATUS = "bpstatus";
	public final String MENSTRUAL_CYCLE_IFO = "menstrualCycleInfo";

	public TestContextSetup() {
		this.driver = DriverFactory.getDriver();

		this.commonMethods = new CommonMethods(driver);
		this.sharedData = new HashMap<>();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage dashboardPage() {
		return dashboardPage;
	}


	public CommonMethods commonMethods() {
		return commonMethods;
	}

	public void setScenarioData(String key, Object value) {
		sharedData.put(key, value);
	}

	public Object getScenarioData(String key) {
		return sharedData.get(key);
	}


}
