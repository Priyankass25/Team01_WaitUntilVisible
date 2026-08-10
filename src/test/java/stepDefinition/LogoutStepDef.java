package stepDefinition;

import org.testng.Assert;

import context.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;

public class LogoutStepDef {

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		TestContextSetup.getPom().getLogoutPage().logoutBtnClick();
	    LoggerLoad.info("Admin clicked on logout button");
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		Assert.assertTrue(TestContextSetup.getPom().getLoginPage().isLoginPageLoaded(),
				"Admin is not in login page");
		LoggerLoad.info("Admin is on the login page");
	}
}
