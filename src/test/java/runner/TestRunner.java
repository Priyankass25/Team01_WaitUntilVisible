package runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import driverFactorySetUp.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    plugin = {
        "pretty",
        "html:target/cucumber-reports/Team01_WaitUntilVisible.html",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "rerun:target/failed_scenarios.txt"
    },
    monochrome = false,
    publish = true,
    dryRun = false,
//    tags = "@Program",
    features = {"src/test/resources/features/"},
    glue = {"stepDefinition", "hooks"}
)



public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void defineBrowser(@Optional String browser) {
    	//Run from testng.xml for parallel and cross browser

        DriverFactory.setBrowserName(browser);

      }

    @Override
    @DataProvider(name = "scenarios", parallel = true)//false- non parallel
    public Object[][] scenarios() {
        return super.scenarios();
    }
}


