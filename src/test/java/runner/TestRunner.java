package runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import driverFactorySetUp.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/WaitUntilVisible.html",
		"json:target/cucumber-reports/WaitUntilVisible.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"rerun:target/failed_scenarios.txt" }, monochrome = false, publish = true, dryRun = false,
		 tags = "@Program",
		features = { "src/test/resources/features/03_Program.feature" }, glue = { "stepDefinition","hooks"})


public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeTest
	@Parameters({ "browser" })
	public void defineBrowser(@Optional String browser) {
		DriverFactory.setBrowserName(browser);
		System.out.println("browser" + browser );
	}

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
