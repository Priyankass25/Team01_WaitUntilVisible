package stepDefinition;

import context.TestContextSetup;
import io.cucumber.java.en.Then;

public class HomeStepDef {

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		TestContextSetup.getPom().getHomePage().verifyLMSTextPresence();
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		TestContextSetup.getPom().getHomePage().verifyLMSTextAlignment();
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
	   
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
	    
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	   
	}

	@Then("Admin should see home in the 1st place")
	public void admin_should_see_home_in_the_1st_place() {
		TestContextSetup.getPom().getHomePage().verifyHomeIsFirst();
	}

	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() {
		TestContextSetup.getPom().getHomePage().verifyProgramIsSecond();
	}

	@Then("Admin should see batch in the  3rd place")
	public void admin_should_see_batch_in_the_3rd_place() {
		TestContextSetup.getPom().getHomePage().verifyBatchISThird();
	}

	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() {
		TestContextSetup.getPom().getHomePage().verifyLogOutIsForth();
	}

	@Then("Admin should see welcome message with user name and role")
	public void admin_should_see_welcome_message_with_user_name_and_role() {
	    
	}

	@Then("Admin should see bar chart for Active and inactive user")
	public void admin_should_see_bar_chart_for_active_and_inactive_user() {
	   
	}

	@Then("Admin should see user count")
	public void admin_should_see_user_count() {
	    
	}

	@Then("Admin should see Program count")
	public void admin_should_see_program_count() {
	}

	@Then("Admin should see Staff count")
	public void admin_should_see_staff_count() {
	    
	}

	@Then("Admin should see batch  count")
	public void admin_should_see_batch_count() {
	  
	}

	@Then("Admin should see the Staff Data table")
	public void admin_should_see_the_staff_data_table() {
	   
	}

	@Then("Admin should see the headers First Name, Last Name, Phone in the Staff Data table")
	public void admin_should_see_the_headers_first_name_last_name_phone_in_the_staff_data_table() {
	   
	}



}
