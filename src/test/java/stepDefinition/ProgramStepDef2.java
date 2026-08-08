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
//         String expout=TestContextSetup.getPom().getProgramPage2().searchp();
//         String actout=TestContextSetup.getPom().getProgramPage2().searchtx();
//         String actout2=TestContextSetup.getPom().getProgramPage2().progdescriptxt();
//         String expout2=TestContextSetup.getPom().getProgramPage2().progtxt();
//         String actout3=TestContextSetup.getPom().getProgramPage2().progdestatustxt();
//         String expout3=TestContextSetup.getPom().getProgramPage2().progsttxt();
//	     Assert.assertEquals(actout,expout, "Program name is not matching");
//	     Assert.assertEquals(actout2,expout2, "Program description is not matching");
//	     Assert.assertEquals(actout3,expout3, "Program status is not matching");
		boolean actout = TestContextSetup.getPom().getProgramPage2().progname();
		boolean actout2 = TestContextSetup.getPom().getProgramPage2().progdes();
		boolean actout3 = TestContextSetup.getPom().getProgramPage2(). progstatus();
		Assert.assertTrue(actout2, "programdescription is not displayed");
		Assert.assertTrue(actout3, "programdescription is not displayed");
		Assert.assertTrue(actout, "program name is not displayed");
	}
	
	@When("Admin enters the program description in search box")
	public void admin_enters_the_program_description_in_search_box() {
		TestContextSetup.getPom().getProgramPage2().searchboxdes();
	}

	@Then("Admin should  see Program name, description, and status for searched program description")
	public void admin_should_see_program_name_description_and_status_for_searched_program_description() {
//		 String expout=TestContextSetup.getPom().getProgramPage2().searchp();
//         String actout=TestContextSetup.getPom().getProgramPage2().searchtx();
//         String actout2=TestContextSetup.getPom().getProgramPage2().progdescriptxt();
//         String expout2=TestContextSetup.getPom().getProgramPage2().progtxt();
//         String actout3=TestContextSetup.getPom().getProgramPage2().progdestatustxt();
//         String expout3=TestContextSetup.getPom().getProgramPage2().progsttxt();
//	     Assert.assertEquals(actout,expout, "Program name is not matching");
//	     Assert.assertEquals(actout2,expout2, "Program description is not matching");
//	     Assert.assertEquals(actout3,expout3, "Program status is not matching");
		boolean actout = TestContextSetup.getPom().getProgramPage2().progname();
		boolean actout2 = TestContextSetup.getPom().getProgramPage2().progdes();
		boolean actout3 = TestContextSetup.getPom().getProgramPage2(). progstatus();
		Assert.assertTrue(actout2, "programdescription is not displayed");
		Assert.assertTrue(actout3, "programdescription is not displayed");
		Assert.assertTrue(actout, "program name is not displayed");
	}
	@When("Admin enters the program that does not exist in search box")
	public void admin_enters_the_program_that_does_not_exist_in_search_box() {
		TestContextSetup.getPom().getProgramPage2().searchboxnotex();
	}

	@Then("There should be zero results.")
	public void there_should_be_zero_results() {
		String expout=TestContextSetup.getPom().getProgramPage2().entries();
        String actout=TestContextSetup.getPom().getProgramPage2().zeroentries();
        Assert.assertEquals(actout,expout, "entries not showing 0");
	}
	@When("Admin enters the partial name of program in search box")
	public void admin_enters_the_partial_name_of_program_in_search_box() {
		TestContextSetup.getPom().getProgramPage2().searchboxpar();
	}

	@Then("Admin should be able to see Program name, description, and status for searched program name")
	public void admin_should_be_able_to_see_program_name_description_and_status_for_searched_program_name() {
		boolean actout = TestContextSetup.getPom().getProgramPage2().progname();
		boolean actout2 = TestContextSetup.getPom().getProgramPage2().progdes();
		boolean actout3 = TestContextSetup.getPom().getProgramPage2(). progstatus();
		Assert.assertTrue(actout2, "programdescription is not displayed");
		Assert.assertTrue(actout3, "programdescription is not displayed");
		Assert.assertTrue(actout, "program name is not displayed");
	}

	}


