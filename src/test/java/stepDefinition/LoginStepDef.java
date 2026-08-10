package stepDefinition;

import context.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;

public class LoginStepDef {

	// Scenario#1
	@When("User enters the url {string}")
	public void user_enters_the_url(String string) {
		TestContextSetup.getPom().getLoginPage().enterUser("Lmshackathon@gmail.com");
		TestContextSetup.getPom().getLoginPage().enterPassword("lmsAug@2026");
		TestContextSetup.getPom().getLoginPage().selectRole();
		TestContextSetup.getPom().getLoginPage().clickLoginBtn();
		LoggerLoad.info("Admin has entered login details");
	}

	@Then("LMS page should be launched")
	public void lms_page_should_be_launched() {
		TestContextSetup.getPom().getLoginPage().isDashboardTextDisplayed();
		LoggerLoad.info("Admin is on home page after login");
	}

	// Scenario#2
	@When("User enters Invalid URL {string}")
	public void user_enters_invalid_url(String string) {
		TestContextSetup.getPom().getLoginPage().enterinvalidurl();
	}

	@Then("LMS Page should not open")
	public void lms_page_should_not_open() {
		LoggerLoad.info("Admin has entered Invalid URL");

	}

	// Scenario#3
	@When("User enters Broken link {string}")
	public void user_enters_broken_url(String string) {
		TestContextSetup.getPom().getLoginPage().enterbrokenurl();
		LoggerLoad.info("Navigating...");
	}

	@Then("LMS Page should not open with broken link")
	public void lms_page_should_not_open_with_broken_link() {
		LoggerLoad.info("Admin has entered Broken URL");

	}

	// Scenario#4
	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		TestContextSetup.getPom().getLoginPage().isLMSTextDisplayed();
	}

	// Scenario#5
	@Then("Application logo should be present")
	public void application_logo_should_be_present() {
		TestContextSetup.getPom().getLoginPage().isLogoDisplayed();
	}

	// Scenario#6
	@Then("Company name {string} is displayed below the Application title")
	public void company_name_is_displayed_below_the_application_title(String string) {
		TestContextSetup.getPom().getLoginPage().isCompanynameDisplayed();
	}

	// Scenario#7
	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		TestContextSetup.getPom().getLoginPage().isloginmsgDisplayed();
	}

	// Scenario#8
	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		TestContextSetup.getPom().getLoginPage().textfieldPresence();
	}

	//Scenario#9
	@Then("One dropdown with values such as Admin, Staff, Student should be displayed")
	public void one_dropdown_with_values_such_as_admin_staff_student_should_be_displayed() {
		TestContextSetup.getPom().getLoginPage().roledropdown();
	}

//Scenario#10
	@Then("Admin should see {string} in the first text field")
	public void admin_should_see_in_the_first_text_field(String string) {
		TestContextSetup.getPom().getLoginPage().textname();
	}

//Scenario#11
	@Then("Admin should see {string} in the second text field")
	public void admin_should_see_in_the_second_text_field(String string) {
		TestContextSetup.getPom().getLoginPage().pwdname();
	}

//Scenario#12
	@Then("Admin should see asterisk mark\\(*) symbol next to text for user field")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_user_field() {
		TestContextSetup.getPom().getLoginPage().textnameasterisk();
	}

//Scenario#13
	@Then("Admin should see asterisk mark\\(*) symbol next to text for pwd field")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_pwd_field() {
		TestContextSetup.getPom().getLoginPage().pwdnameasterisk();
	}

//Scenario#14
	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String string) {
		TestContextSetup.getPom().getLoginPage().selectPlaceholder();
	}

//Scenario#15
	@Then("Admin should see {string}, {string} ,{string} options in dropdown")
	public void a_admin_should_see_options_in_dropdown(String string, String string2, String string3) {
		TestContextSetup.getPom().getLoginPage().selectPlaceholdervalues();
	}

}
