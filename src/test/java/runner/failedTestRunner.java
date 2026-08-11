package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "@target/failed_scenarios.txt" }, glue = { "stepDefinition", "hooks" }, plugin = { "pretty",
		"html:target/cucumber-reports/Team01_WaitUntilVisible.html",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, monochrome = true, publish = true, dryRun = false

)

public class failedTestRunner extends AbstractTestNGCucumberTests {

}
