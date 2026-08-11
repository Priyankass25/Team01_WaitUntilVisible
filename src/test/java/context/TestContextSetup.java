package context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import driverFactorySetUp.PageObjectMgr;


public class TestContextSetup {
	public final static String PROGRAM_NAME = "pName";
	private Map<String, Object> sharedData = new HashMap<>();


	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<PageObjectMgr> pom = new ThreadLocal<>();

	public static void setDriver(WebDriver driverInstance, TestContextSetup context) {
		driver.set(driverInstance);
		pom.set(new PageObjectMgr(driverInstance, context));

	
	

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

	public void setScenarioData(String key, Object value) {
		sharedData.put(key, value);
	}


	public Object getScenarioData(String key) {
		return sharedData.get(key);
	}
	



}
