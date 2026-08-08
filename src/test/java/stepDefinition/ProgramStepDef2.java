package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.ExcelUtils;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import context.TestContextSetup;


public class ProgramStepDef2 {


	@Given("Admin is on Program page")
	public void admin_is_on_program_page() {
		TestContextSetup.getPom().getLoginPage().enterUser("Lmshackathon@gmail.com");
		TestContextSetup.getPom().getLoginPage().enterPassword("lmsAug@2026");
		TestContextSetup.getPom().getLoginPage().selectRole();
		TestContextSetup.getPom().getLoginPage().clickLoginBtn();
		TestContextSetup.getPom().getProgramPage2().clickprogram();
		
	}
	@When("Admin enters the program name in search box")
	public void admin_enters_the_program_name_in_search_box() {
		TestContextSetup.getPom().getProgramPage2().searchbox();
		
	}
	@Then("Admin should  see Program name, description, and status for searched program name")
	public void admin_should_see_program_name_description_and_status_for_searched_program_name() {
         String expout=TestContextSetup.getPom().getProgramPage2().searchp();
         String actout=TestContextSetup.getPom().getProgramPage2().searchtx();
         String actout2=TestContextSetup.getPom().getProgramPage2().progdescriptxt();
         String expout2=TestContextSetup.getPom().getProgramPage2().progtxt();
         String actout3=TestContextSetup.getPom().getProgramPage2().progdestatustxt();
         String expout3=TestContextSetup.getPom().getProgramPage2().progsttxt();
	     Assert.assertEquals(actout,expout, "Program name is not matching");
	     Assert.assertEquals(actout2,expout2, "Program description is not matching");
	     Assert.assertEquals(actout3,expout3, "Program status is not matching");
	}
}
