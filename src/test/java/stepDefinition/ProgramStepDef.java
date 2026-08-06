package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.ExcelUtils;

import java.util.List;
import java.util.Map;

import context.TestContextSetup;


public class ProgramStepDef {

	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {
		TestContextSetup.getPom().getLoginPage().enterUser("Lmshackathon@gmail.com");
		TestContextSetup.getPom().getLoginPage().enterPassword("lmsAug@2026");
		TestContextSetup.getPom().getLoginPage().selectRole();
		TestContextSetup.getPom().getLoginPage().clickLoginBtn();
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	   
	}

	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() {
	    
	}
}
