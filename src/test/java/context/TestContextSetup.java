package context;

import org.openqa.selenium.WebDriver;
import driverFactorySetUp.PageObjectMgr;


public class TestContextSetup {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<PageObjectMgr> pom = new ThreadLocal<>();

	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
		pom.set(new PageObjectMgr(driverInstance));
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static PageObjectMgr getPom() {
	        return pom.get();
	}

	public static void clear() {
	        driver.remove();
	        pom.remove();
	}


//	private WebDriver driver;
//	
//	private CommonMethods commonMethods;
//
//
//	public TestContextSetup() {
//		this.driver = DriverFactory.getDriver();
//
//		this.commonMethods = new CommonMethods(driver);
//		
//	}
//	public WebDriver getDriver() {
//		return driver;
//	}
//
//	public LoginPage dashboardPage() {
//		return dashboardPage;
//	}
//
//
//	public CommonMethods commonMethods() {
//		return commonMethods;
//	}
//
//	public void setScenarioData(String key, Object value) {
//		sharedData.put(key, value);
//	}
//
//	public Object getScenarioData(String key) {
//		return sharedData.get(key);
//	}
}
