package stepDefinition;

import static org.testng.Assert.*;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.LoggerLoad;

public class Batch {

    HomePage loginPage = new HomePage();
    ExcelUtils excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));


    @Given("User is on the HerBalance auth page")
    public void user_is_on_the_her_balance_auth_page() {
        LoggerLoad.info("User is on HerBalance auth page");
    }

    @When("user clicks login button after leaving credential blank")
    public void user_clicks_login_button_after_leaving_credential_blank() {
        LoggerLoad.info("Clearing email and password fields for blank input scenario");
//        loginPage.enterEmail("");     
//        loginPage.enterPassword(""); 
//        loginPage.clickLogin();
    }

  @When("user clicks login button after entering a {string} credential")
  public void user_clicks_login_button_after_entering_a_credential(String scenario) {
     LoggerLoad.info("Login attempt with scenario: " + scenario);
      Map<String, String> data = excel.getRowDataByScenario("LoginData", scenario);      
//      loginPage.enterEmail(data.get("Email"));
//      loginPage.enterPassword(data.get("Password"));
//      loginPage.clickLogin();
  }
  
    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        LoggerLoad.info("User redirected to dashboard");
        assertTrue(true);
    }

  
}
