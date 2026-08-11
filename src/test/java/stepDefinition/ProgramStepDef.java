package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.LoggerLoad;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import context.TestContextSetup;


public class ProgramStepDef {

	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {
		TestContextSetup.getPom().getLoginPage().enterUser("Lmshackathon@gmail.com");
		TestContextSetup.getPom().getLoginPage().enterPassword("lmsAug@2026");
		TestContextSetup.getPom().getLoginPage().selectRole();
		TestContextSetup.getPom().getLoginPage().clickLoginBtn();
		LoggerLoad.info("Admin is on home page after login");
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	    TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
	    LoggerLoad.info("Admin clicked on program navigation bar");
	}

	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() {
	    String currentURL = TestContextSetup.getPom().getHomePage().getcurrentURL();
	    Assert.assertEquals(true, currentURL.contains("program"), "Admin is not in the program page");
	    LoggerLoad.info("Admin is on Program page");
	}

	@Then("Admin should see the heading Manage Program")
	public void admin_should_see_the_heading_manage_program(){
		boolean actual = TestContextSetup.getPom().getProgramPage().isManageProgramHeadingDisplayed();
	    Assert.assertEquals(true, actual, "Manage Program Heading is not displayed");
	    LoggerLoad.info("Admin able to see the heading Manage Program");
	}

	@Then("Admin should see manage program heading aligned on the left side")
	public void admin_should_see_manage_program_heading_aligned_on_the_left_side() {
		boolean actualPosition = TestContextSetup.getPom().getProgramPage().isManageProgramHeadingLeftAligned();
	   Assert.assertTrue(actualPosition, "Manage Program heading is not left aligned.");
	   LoggerLoad.info("Admin able to see the heading Manage Program");
	}

	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
	   Assert.assertFalse(TestContextSetup.getPom().getProgramPage().isTopDeleteButtonEnabled(), 
			   "Top-level Delete button should be disabled.");
	   LoggerLoad.info("Admin is on Manage Program page wihtout selecting the program");
	}

	@Then("Admin should see Search bar")
	public void admin_should_see_search_bar() {
	   Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isSearchBarVisible(),
			   "Search bar is not visible.");
	   LoggerLoad.info("Admin able to see Search Bar");
	}

	@Then("Admin should see search... placeholder text")
	public void admin_should_see_search_placeholder_text() {
		Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isSearchPlaceHolderTextDisplayed(),
				   "Search placeholder text 'Search...' is not visible.");
		   LoggerLoad.info("Admin able to see search placeholder text.");
	}

	@Then("Admin should see data table with column headers {string} on the Manage Program Page")
	public void admin_should_see_data_table_with_column_headers_on_the_manage_program_page(String string) {
	   Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isDataTableColumnHeadersDisplayed(string),
				   "Program data table column header " +string+" is not visible.");
		   LoggerLoad.info("Program data table column header " +string+ " is not visible.");
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
		 Assert.assertFalse(TestContextSetup.getPom().getProgramPage().isDataTableColumnHeaderCheckBoxEnabled(),
				   "Program data table checkbox is enabled.");
		   LoggerLoad.info("Program data table checkbox is disabled.");
	}

	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		Assert.assertFalse(TestContextSetup.getPom().getProgramPage().isBodyCheckboxesChecked(),
				   "Program page body checkboxes are checked.");
		   LoggerLoad.info("Program page body checkboxes are unchecked.");
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isDataTableColumnHeaderSortDisplayed(),
				   "Sort Option is not displayed for ProgramName,Status and description.");
		   LoggerLoad.info("Sort Option is displayed for ProgramName,Status and description.");
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table(){
	    Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isEditDeleteBtnsDisplayed(),
				   "Edit Delete buttons are not displayed on all rows.");
		   LoggerLoad.info("Edit Delete buttons are displayed on all rows.");
	}

	@Then("Admin should see the text as {string} along with Pagination controls below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_controls_below_the_table(String string) {
	   
	}

	@Then("Admin should see the footer as {string}.")
	public void admin_should_see_the_footer_as(String string) {
	    
	}

	@Given("Admin is on Program page")
	public void admin_is_on_program_page(){
		 TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
		    LoggerLoad.info("Admin clicked on program navigation bar");
	}

	@When("Admin clicks on Add New Program under the Program menu bar")
	public void admin_clicks_on_add_new_program_under_the_program_menu_bar() {
	    TestContextSetup.getPom().getProgramPage().addProgramBtnClick();
	    LoggerLoad.info("Admin clicked add program button");
	}

	@Then("Admin should see Add New Program dialog")
	public void admin_should_see_add_new_program_dialog() {
		Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isAddProgramDialogDisplayed(),
				   "Add New Program dialog is not visible.");
		   LoggerLoad.info("Add New Program dialog is visible.");
	}

	@Then("Admin should see  title as Program Details")
	public void admin_should_see_title_as_program_details() {
		Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isProgramDetailsTitleDisplayed(),
				   "Admin is not in the ProgramD Details.");
		   LoggerLoad.info("Admin able to see Program Details Title.");
	}

	@Then("Admin should see red  asterisk mark  beside mandatory field Name and Status")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field_name_and_status() {
		Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isNameStatusAsteriskDisplayed(),
				   "Asterisk mark is not displayed for Name and Status field");
		   LoggerLoad.info("Asterisk mark is displayed for Name and Status field");
	}

	@Then("Admin should see the Name text box")
	public void admin_should_see_the_name_text_box() {
		Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isNameTextBoxDisplayed(),
				   "Admin unable to see the name text box");
		   LoggerLoad.info("Admin able to see the name text box");
	}
	
	@Then("Admin should see the Description text box")
	public void admin_should_see_the_description_text_box() {
		Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isDescriptionTextBoxDisplayed(),
				   "Admin unable to see the description text box");
		   LoggerLoad.info("Admin able to see the description text box");
	}

	@Then("Admin should see Active and Inactive radio buttons")
	public void admin_should_see_active_and_inactive_radio_buttons() {
		Assert.assertTrue(TestContextSetup.getPom().getProgramPage().isStatusRadioBtnsDisplayed(),
				   "Admin unable to see the active and inactive status radio buttons");
		   LoggerLoad.info("Admin able to see the active and inactive status radio buttons");
	}

	@Given("Admin is on Program details dialog box")
	public void admin_is_on_program_details_dialog_box() {
	    
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
	    
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String string) {
	    
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
	    
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {
	   
	}

	@When("Admin clicks X button")
	public void admin_clicks_x_button() {
	  
	}

	@When("Admin searches with newly created {string}")
	public void admin_searches_with_newly_created(String string) {
	    
	}

	@Then("Admin should see the Records of the newly created Program details")
	public void admin_should_see_the_records_of_the_newly_created_program_details() {
	   
	}

	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() {
	    
	}

	@When("Admin clicks save button after editing the fields {string}")
	public void admin_clicks_save_button_after_editing_the_fields(String string) {
	    
	}

	@Then("Admin should see {string} message")
	public void admin_should_see_message(String string) {
	   
	}

	@When("Admin clicks on delete icon for a program")
	public void admin_clicks_on_delete_icon_for_a_program() {
	   
	}

	@Then("Admin will get confirm deletion dialog box")
	public void admin_will_get_confirm_deletion_dialog_box() {
	    
	}

	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() {
	 
	}

	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String string) {
	   
	}

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String string) {
	   
	}

	@When("Admin Searches for {string}")
	public void admin_searches_for(String string) {
	   
	}

	@Then("There should be zero results")
	public void there_should_be_zero_results() {
	  
	}

	@Then("Admin can see Confirmation form disappears")
	public void admin_can_see_confirmation_form_disappears() {
	   
	}

	@When("Admin Click on {string} button")
	public void admin_click_on_button(String string) {
	  
	}

	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
	    
	}

	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
	    
	}

	@Then("Mulitple delete box under manage program must be enabled")
	public void mulitple_delete_box_under_manage_program_must_be_enabled() {
	   
	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
	  
	}

	@Then("Admin lands on Confirmation form")
	public void admin_lands_on_confirmation_form() {

	}

	@Given("Admin is on Confirmation form")
	public void admin_is_on_confirmation_form() {

	}

	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {

	}
 
	@When("Admin enters the program name in search box")
	public void admin_enters_the_program_name_in_search_box() {
	
			TestContextSetup.getPom().getProgramPage().searchboxenter();
			
		}
	
	
	@Then("Admin should see {string} for searched program name")
	public void admin_should_see_for_searched_program_name(String field) {
     switch (field.toLowerCase()) {
     case "program name":Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progname(),"Program name is not displayed");
	 break;
     case "description":Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progdes(),"Program description is not displayed");
	 break;
     case "status":Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progstatus(),"Program status is not displayed");
	 break;
     default:
	 Assert.fail("Invalid field: " + field);}
	}
	
	@When("Admin enters the program description in search box")
	public void admin_enters_the_program_description_in_search_box() {
		TestContextSetup.getPom().getProgramPage().dismissOverlay();
		TestContextSetup.getPom().getProgramPage().searchboxdes();
	}

	@Then("Admin should see {string} for searched program description")
	public void admin_should_see_for_searched_program_description(String field) {
    switch (field.toLowerCase()) {
    case "program name":Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progname(),"Program name is not displayed");
	break;
    case "description":Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progdes(),"Program description is not displayed");
	break;
    case "status":Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progstatus(),"Program status is not displayed");
	break;
	default:Assert.fail("Invalid field: " + field);
	    }
	}
	
	@When("Admin enters the program that does not exist in search box")
	public void admin_enters_the_program_that_does_not_exist_in_search_box() {
		TestContextSetup.getPom().getProgramPage().searchboxnotex();
	}

	@Then("There should be zero results .")
	public void there_should_be_zero_results_() {
		String expout=TestContextSetup.getPom().getProgramPage().entries();
        String actout=TestContextSetup.getPom().getProgramPage().zeroentries();
        Assert.assertEquals(actout,expout, "entries not showing 0");


}
	@When("Admin enters the partial name of program in search box")
	public void admin_enters_the_partial_name_of_program_in_search_box() {
		TestContextSetup.getPom().getProgramPage().searchboxpar();
	}

	@Then("Admin should be able to see {string} for searched program name")
	public void admin_should_be_able_to_see_for_searched_program_name(String field) {
    switch (field.toLowerCase()) {  
    case "program name":
    Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progname(),"Program name is not displayed");
	break;
    case "description":
    Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progdes(),"Program description is not displayed");
	break;
	case "status":
    Assert.assertTrue(TestContextSetup.getPom().getProgramPage().progstatus(),"Program status is not displayed");
	break;
    default:Assert.fail("Invalid field: " + field);
	    }
	}
	
	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
		TestContextSetup.getPom().getProgramPage().dismissOverlay();
		TestContextSetup.getPom().getProgramPage().clickprogramname();
	//	TestContextSetup.getPom().getProgramPage().clickprogramname();
	}
	
	@Then("Admin should  See the Program Name is sorted in Ascending order")
	public void admin_should_see_the_program_name_is_sorted_in_ascending_order() {
      boolean actual = TestContextSetup.getPom().getProgramPage().isProgramNameSortedAscending();
   Assert.assertTrue(actual,"Program names are not sorted in ascending order");
   }

	@Given("Admin is in program page where Program names are sorted in ascending order")
	public void admin_is_in_program_page_where_program_names_are_sorted_in_ascending_order() {
		TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
	    LoggerLoad.info("Admin clicked on program navigation bar");
	    TestContextSetup.getPom().getProgramPage().dismissOverlay();
		TestContextSetup.getPom().getProgramPage().clickprogramname();
		
	}
	
	@When("Admin clicks on Arrow next to program Name.")
	public void admin_clicks_on_arrow_next_to_program_name_() {
		//TestContextSetup.getPom().getProgramPage().dismissOverlay();
		TestContextSetup.getPom().getProgramPage().clickprogramname();	
	}
	@When("Admin clicks on Arrow next to Program Description")
		 public void admin_clicks_on_arrow_next_to_program_description() {
		TestContextSetup.getPom().getProgramPage().dismissOverlay();
			 TestContextSetup.getPom().getProgramPage().programdescriptionclick();
		 }
		 @Then("Admin should See the program Description is sorted in Ascending order")
		 public void admin_should_see_the_program_description_is_sorted_in_ascending_order() {
			 boolean actual = TestContextSetup.getPom()
			            .getProgramPage()
			            .isProgramDescriptionSortedAscending();

			    Assert.assertTrue(
			            actual,
			            "Program Description is not sorted in ascending order"
			    );
		 }	
	
	@Then("Admin should See the Program Name is sorted in Descending order")
	public void admin_should_see_the_program_name_is_sorted_in_descending_order() {
		boolean actual = TestContextSetup.getPom().getProgramPage().isProgramNameSortedDescending();
     Assert.assertTrue(actual,"Program names are not sorted in descending order");
	}
	@Given("Admin is in program page where Program description are sorted in ascending order")
	public void admin_is_in_program_page_where_program_description_are_sorted_in_ascending_order() {
		TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
	    LoggerLoad.info("Admin clicked on program navigation bar");
	    TestContextSetup.getPom().getProgramPage().dismissOverlay();
	    TestContextSetup.getPom().getProgramPage().programdescriptionclick();
	}
	@When("Admin clicks on Arrow next to Program Description.")
	public void admin_clicks_on_arrow_next_to_program_description_() {
	//TestContextSetup.getPom().getProgramPage().dismissOverlay();
		 TestContextSetup.getPom().getProgramPage().programdescriptionclick();
	 }
	@Then("Admin  should See the program Description is sorted in Descending order")
	public void admin_should_see_the_program_description_is_sorted_in_descending_order() {
		 boolean actual = TestContextSetup.getPom()
		            .getProgramPage()
		            .isProgramDescriptionSortedDescending();

		    Assert.assertTrue(
		            actual,
		            "Program Description is not sorted in descending order"
		    );
	}
	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
		TestContextSetup.getPom().getProgramPage().dismissOverlay();
		 TestContextSetup.getPom().getProgramPage().programstatusclick();
	}
	@Then("Admin should see the Program status sorted in Ascending order")
	public void admin_should_see_the_program_status_sorted_in_ascending_order() {
		 boolean actual = TestContextSetup.getPom()
		            .getProgramPage()
		            .isProgramstatusSortedAscending();

		    Assert.assertTrue(
		            actual,
		            "Program status is not sorted in descending order"
		    );
	}
	@Given("Admin is in program page where Program status are sorted in ascending order")
	public void admin_is_in_program_page_where_program_status_are_sorted_in_ascending_order() {
		 TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
	}
	@Then("Admin should see the Program status sorted in Descending order")
	public void admin_should_see_the_program_status_sorted_in_descending_order() {
		 boolean actual = TestContextSetup.getPom().getProgramPage()
		            .isProgramstatusSortedAscending();
		    Assert.assertTrue(actual,"Program status is not sorted in descending order");
	}
	@Given("Admin is on Program page with multiple program records")
	public void admin_is_on_program_page_with_multiple_program_records() {
		 TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
	}
	@When("Admin clicks the next page option \\(>) in the pagination control")
	public void admin_clicks_the_next_page_option_in_the_pagination_control() {
		TestContextSetup.getPom().getProgramPage().dismissOverlay();
		TestContextSetup.getPom().getProgramPage().nextarrowclick();
	}
	@Then("Admin should navigate to the next page and see the next set of program records")
	public void admin_should_navigate_to_the_next_page_and_see_the_next_set_of_program_records() {
		  String selectedPage = TestContextSetup.getPom().getProgramPage().getslectednum();
         int expectedPage = Integer.parseInt(selectedPage) + 1;
		    String actualPage = TestContextSetup.getPom().getProgramPage().getafterarrowclk();
         Assert.assertEquals(Integer.parseInt(actualPage),expectedPage,"Page is not navigated to next page");
	}
	@Given("Admin is on any page except the last page of Program table")
	public void admin_is_on_any_page_except_the_last_page_of_program_table() {
		TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
	}
	@When("Admin clicks the last page option \\(>>) in the pagination control")
	public void admin_clicks_the_last_page_option_in_the_pagination_control() {
		TestContextSetup.getPom().getProgramPage().dismissOverlay();
		TestContextSetup.getPom().getProgramPage().lastarrowclick();
	}
	@Then("Admin should see the last page record on the table")
	public void admin_should_see_the_last_page_record_on_the_table() {
		int actualTotalPrograms = TestContextSetup.getPom().getProgramPage().getTotalPrograms();
		int actualDisplayedEntries = TestContextSetup.getPom().getProgramPage().getDisplayedEntries();
        Assert.assertEquals(actualTotalPrograms,actualDisplayedEntries,"not navigated to lastpage");
	}

@Given("Admin is on the Program table on any page except the first page")
public void admin_is_on_the_program_table_on_any_page_except_the_first_page() {
	TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
	TestContextSetup.getPom().getProgramPage().dismissOverlay();
	TestContextSetup.getPom().getProgramPage().nextarrowclick();
}
@When("Admin clicks the previous page option \\(<) in the pagination control")
public void admin_clicks_the_previous_page_option_in_the_pagination_control() {
	//TestContextSetup.getPom().getProgramPage().dismissOverlay();
	TestContextSetup.getPom().getProgramPage().prearrowclick();
	
}
@Then("Admin should see the previous page record on the table")
public void admin_should_see_the_previous_page_record_on_the_table() {
	 String selectedPage = TestContextSetup.getPom().getProgramPage().getslectednumb();
     int expectedPage = Integer.parseInt(selectedPage) - 1;
	    String actualPage = TestContextSetup.getPom().getProgramPage().getaprearrowclk();
     Assert.assertEquals(Integer.parseInt(actualPage),expectedPage,"Page is not navigated to next page");
}

@Given("Admin is on any page except the first page of Program table")
public void admin_is_on_any_page_except_the_first_page_of_program_table() {
	TestContextSetup.getPom().getHomePage().prgmNavgationBarClick();
	TestContextSetup.getPom().getProgramPage().dismissOverlay();
	TestContextSetup.getPom().getProgramPage().nextarrowclick();
}
@When("Admin clicks the first page option \\(<<) in the pagination control")
public void admin_clicks_the_first_page_option_in_the_pagination_control() {
	TestContextSetup.getPom().getProgramPage().firstarrowclick();
}
@Then("Admin should see the very first page record on the table")
public void admin_should_see_the_very_first_page_record_on_the_table() {
	int actual = TestContextSetup.getPom()
	        .getProgramPage()
	        .getFirstNumber();

	Assert.assertEquals(actual, 1, "First number is not matching");
}


	

}