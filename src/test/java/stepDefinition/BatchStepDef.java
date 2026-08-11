package stepDefinition;

import static org.testng.Assert.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import context.TestContextSetup;
import driverFactorySetUp.DriverFactory;
import driverFactorySetUp.PageObjectMgr;
import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.BatchPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
//import pageObjects.Then;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.LoggerLoad;
import utilities.TestDataManager;

public class BatchStepDef {
	
	
	private CommonMethods common;

	private static ThreadLocal<PageObjectMgr> pom = new ThreadLocal<>();

	    WebDriver driver;	   
	    BatchPage Batch = new BatchPage(DriverFactory.getDriver());

	    public BatchStepDef() {
	    	Batch = new BatchPage(TestContextSetup.getDriver());
	        this.driver = DriverFactory.getDriver();
	        this.common = new CommonMethods(driver);
	}
 
	@Given("Admin is logged in to LMS Portal and landed on home page")
	public void admin_is_logged_in_to_lms_portal_and_landed_on_home_page() {
		//TestContextSetup.getPom().getLoginPage().validLoginCredentials();

		common.validLogin();
		
	}
	
	@When("Admin clicks the {string} on the navigation bar")
	public void admin_clicks_the_on_the_navigation_bar(String batch) {
		Batch.TitleBatch1(batch);
		/*String actualTitle =Batch.getPageTitle();
        Assert.assertEquals(batch ,actualTitle);*/
		
	}
	
	@Then("Admin should be redirected to the Manage Batch Page")
	public void admin_should_be_redirected_to_the_manage_batch_page() { 
    Batch.TitleManageBatch();
    
    //Batch.AddNewBatch();
		
	}

	@Then("Admin should see the submenu option {string}")
	public void admin_should_see_the_submenu_option(String addNewBatch) {
		//Batch.TitleBatch1(addNewBatch);
		Batch.batchSelect();
        Batch.Addassertions(addNewBatch);
		//Batch.AddNewBatch();	
	    
	}

	@Then("Admin should see the {string} heading")
	public void admin_should_see_the_heading(String manageBatch) {
		TestContextSetup.getPom().getBatchPage().TitleBatch1(manageBatch);
		TestContextSetup.getPom().getBatchPage().TitleManageBatch();
	}

	@Then("Admin should see the disabled Delete icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
		
		
		TestContextSetup.getPom().getBatchPage().TitleBatchAll();
		 //Batch.DeleteEN_DIS();
		TestContextSetup.getPom().getBatchPage().DeleteDisable1();
	}

	@Then("Admin should see pagination controls below the data table")
	public void admin_should_see_pagination_controls_below_the_data_table() {
		TestContextSetup.getPom().getBatchPage().TitleBatchAll();

		TestContextSetup.getPom().getBatchPage().verifyPaginationControls();
	}

	@Then("Admin should see the edit icon for each batch record")
	public void admin_should_see_the_edit_icon_for_each_batch_record() {
		TestContextSetup.getPom().getBatchPage().TitleBatchAll();
		TestContextSetup.getPom().getBatchPage().EditBatch();
	}

	@Then("Admin should see the delete icon for each batch record")
	public void admin_should_see_the_delete_icon_for_each_batch_record() {
		TestContextSetup.getPom().getBatchPage().TitleBatchAll();
		TestContextSetup.getPom().getBatchPage().verifyDeleteButton();
	}

	@Then("Admin should see checkboxes for each batch record")
	public void admin_should_see_checkboxes_for_each_batch_record() {
		TestContextSetup.getPom().getBatchPage().TitleBatchAll();
		TestContextSetup.getPom().getBatchPage().verifyBatchCheckbox();
	}

	@Then("Admin should see the following batch table headers:")
	public void admin_should_see_the_following_batch_table_headers(DataTable expectedHeaders) {
		TestContextSetup.getPom().getBatchPage().TitleBatchAll();
        List<String> headers = expectedHeaders.asList(String.class);
        TestContextSetup.getPom().getBatchPage().verifyBatchTableHeaders(headers);
	}

	@Then("Admin should see sort icons next to all batch table headers")
	public void admin_should_see_sort_icons_next_to_all_batch_table_headers() {
		TestContextSetup.getPom().getBatchPage().TitleBatchAll();
		BatchPage batchPage =
	            new BatchPage(DriverFactory.getDriver());

	    batchPage.verifySortIcons();
	}
//++++++++++++++++++++++++ADDBATCH LIST
	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String batch, String addNewBatch) {
		TestContextSetup.getPom().getBatchPage().batchSelect();
		TestContextSetup.getPom().getBatchPage().clickAddNewBatch1();

	}

	@Then("Admin should see the {string} on the Add New Batch page")
	public void admin_should_see_the_on_the_add_new_batch_page(String field) {
	    //Batch.Addassertions(field);
	    Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isBatchNameDisplayed(),
                "Batch Name field is not displayed"
        );

        Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isNumberOfClassesDisplayed(),
                "Number of Classes field is not displayed"
        );

        Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isDescriptionDisplayed(),
                "Description field is not displayed"
        );

        Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isProgramDropdownDisplayed(),
                "Program Name dropdown is not displayed"
        );

        Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isStatusRadioButtonsDisplayed(),
                "Status radio buttons are not displayed"
        );
   
	}



	@Given("Admin is on the Manage Batch page")
	public void admin_is_on_the_manage_batch_page() {
		TestContextSetup.getPom().getBatchPage().TitleBatchAll();

	}

	@When("Admin opens the Add New Batch page")
	public void admin_opens_the_add_new_batch_page() {
		TestContextSetup.getPom().getBatchPage().batchSelect();
		TestContextSetup.getPom().getBatchPage().clickAddNewBatch1();
	}

	@Then("Admin should see all Add New Batch fields")
	public void admin_should_see_all_add_new_batch_fields() {
		Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isBatchNameDisplayed(),
                "Batch Name field is not displayed"
        );

        Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isNumberOfClassesDisplayed(),
                "Number of Classes field is not displayed"
        );

        Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isDescriptionDisplayed(),
                "Description field is not displayed"
        );

        Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isProgramDropdownDisplayed(),
                "Program Name dropdown is not displayed"
        );

        Assert.assertTrue(
                TestContextSetup.getPom()
                        .getBatchPage()
                        .isStatusRadioButtonsDisplayed(),
                "Status radio buttons are not displayed"
        );
    }
	@Given("Admin is on the Batch Details dialog box")
	public void admin_is_on_the_batch_details_dialog_box() {
		TestContextSetup.getPom().getBatchPage().batchSelect();
	}

	@When("Admin selects program name from the dropdown")
	public void admin_selects_program_name_from_the_dropdown() {
		TestContextSetup.getPom()
        .getBatchPage()
        .selectProgram(
                ConfigReader.getProperty("batch.program")
        );
	}

	@Then("Admin should see selected program name as the batch name prefix")
	public void admin_should_see_selected_program_name_as_the_batch_name_prefix() {
	   
	}

	


		

	
//=================================================================
	@Given("Admin is on the Batch page")
	public void admin_is_on_the_batch_page() {
		Batch.TitleBatchAll();
		//Batch.clickDeleteIcon1();
	}

	@When("Admin performs {string}")
	public void admin_performs(String action) {
		TestContextSetup.getPom().getBatchPage().clickDeleteIcon0();
		// Batch.clickDeleteIcon1();
		// Batch.doubleClickDeleteButton();
		// Batch.clickTrash();

		    if (action.contains("Yes")) {
		    	TestContextSetup.getPom().getBatchPage().clickYes1();
		    } 
		    else if (action.contains("No")) {
		    	TestContextSetup.getPom().getBatchPage().clickNo1();
		    } 
		    else if (action.contains("close")) {
		    	TestContextSetup.getPom().getBatchPage().clickClose1();
		    }
	}

	@Then("Admin should see {string} on the batch page")
	public void admin_should_see_on_the_batch_page(String expectedResult) {
	    
		

		    if (expectedResult.contains("confirmation popup")) {
		        Assert.assertTrue(
		        		TestContextSetup.getPom().getBatchPage().isConfirmationPopupDisplayed1(),
		            "Confirmation popup is not displayed"
		        );
		    } 
		    else if (expectedResult.contains("success message")) {
		        Assert.assertTrue(
		        		TestContextSetup.getPom().getBatchPage().isSuccessMessageDisplayed(),
		            "Success message is not displayed"
		        );
		    } else if (expectedResult.toLowerCase().contains("closed")) { 
		    	Assert.assertFalse(
		    			Batch.isConfirmationPopupDisplayed1(), "Confirmation popup is still displayed" );
		}
	}

		@When("Admin selects multiple batches by clicking the checkboxes")
		public void admin_selects_multiple_batches_by_clicking_the_checkboxes() {
			TestContextSetup.getPom().getBatchPage().TitleBatchAll();

			TestContextSetup.getPom().getBatchPage().selectMultipleBatches();
		}

		@Then("Admin should see the multiple delete button enabled")
		public void admin_should_see_the_multiple_delete_button_enabled() {
			Assert.assertTrue(
					TestContextSetup.getPom().getBatchPage().areMultipleBatchesSelected(),
			        "Multiple delete button is not enabled"
			    );
		}

			@Given("Admin has selected multiple batches")
			public void admin_has_selected_multiple_batches() {
				TestContextSetup.getPom().getBatchPage().TitleBatchAll();

				TestContextSetup.getPom().getBatchPage().selectMultipleBatches();
			}

			@When("Admin clicks the multiple delete button")
			public void admin_clicks_the_multiple_delete_button() {
				TestContextSetup.getPom().getBatchPage().multipleDelete();
			}

			@Then("Admin should see the delete confirmation dialog")
			public void admin_should_see_the_delete_confirmation_dialog() {
				Assert.assertTrue(
						TestContextSetup.getPom().getBatchPage().isDeleteConfirmationDialogDisplayed(),
				        "Delete confirmation dialog is not displayed"
				    );
			}
			//********************pagination NEXT PAGE
			@Given("Admin is on the batch page with multiple records")
			public void admin_is_on_the_batch_page_with_multiple_records() {
				TestContextSetup.getPom().getBatchPage().TitleBatchAll();

				TestContextSetup.getPom().getBatchPage().clickNextPage();
			}

			@When("Admin clicks the Next page {string} option")
			public void admin_clicks_the_next_page_option(String string) {
				TestContextSetup.getPom().getBatchPage().clickNextPage();}
			

			@Then("Admin should see the next page of the batch table")
			public void admin_should_see_the_next_page_of_the_batch_table() {
				TestContextSetup.getPom().getBatchPage().isNextPageDisplayed();
			}
//*********************LAST PAGE
@Given("Admin is on any batch page except the last page")
public void admin_is_on_any_batch_page_except_the_last_page() {
	TestContextSetup.getPom().getBatchPage().TitleBatchAll();
	  
}

@When("Admin clicks the Last page {string} option")
public void admin_clicks_the_last_page_option(String string) {
	TestContextSetup.getPom().getBatchPage().clicklastPage();
}

@Then("Admin should see the last page with the Next page {string} option disabled")
public void admin_should_see_the_last_page_with_the_next_page_option_disabled(String string) {
	TestContextSetup.getPom().getBatchPage().isLastPageDisplayed();
}

//======================previousPAGE

@Given("Admin is on any batch page except the first page")
public void admin_is_on_any_batch_page_except_the_first_page() {
	TestContextSetup.getPom().getBatchPage().TitleBatchAll();
	assertTrue(Batch.isBatchPageDisplayed()); // Make sure Admin is not on the first page 
	if (Batch.isFirstPageDisplayed()) {
		Batch.clickNextPage(); 
		} 
	System.out.println( "Current page before Previous: " + Batch.getActivePageNumber() ); }


@When("Admin clicks the Previous page {string} option")
public void admin_clicks_the_previous_page_option(String string) {
    Batch.clickFIRSTPage();
}

@Then("Admin should see the previous page of the batch table")
public void admin_should_see_the_previous_page_of_the_batch_table() {
    
}
//==================first page
@Given("Admin is on any batch page except the first page on batch page")
public void admin_is_on_any_batch_page_except_the_first_page_on_batch_page() {
	Batch.TitleBatchAll();
	assertTrue(Batch.isBatchPageDisplayed()); // Make sure Admin is not on the first page 
	if (Batch.isFirstPageDisplayed()) {
		Batch.clickNextPage(); 
		} 
	System.out.println( "Current page before Previous: " + Batch.getActivePageNumber() ); }



@When("Admin clicks the First page {string} option")
public void admin_clicks_the_first_page_option(String string) {
	 Batch.clickFIRSTPage();
	}



@Then("Admin should see the first page of the batch table")
public void admin_should_see_the_first_page_of_the_batch_table() {
   Batch.isFirstPageDisplayed()
;}




//==================first page should be disable

@Given("Admin is on the first page of a batch table with multiple pages")
public void admin_is_on_the_first_page_of_a_batch_table_with_multiple_pages() {
   
}

@When("Admin views the pagination control")
public void admin_views_the_pagination_control() {
    
}

@Then("the First page {string} and Previous page {string} options should be disabled")
public void the_first_page_and_previous_page_options_should_be_disabled(String string, String string2) {
    
}
//===============LaST pAGE ENABLED
@Then("the Next page {string} and Last page {string} options should be enabled")
public void the_next_page_and_last_page_options_should_be_enabled(String string, String string2) {
    
}







}







	





	
  

