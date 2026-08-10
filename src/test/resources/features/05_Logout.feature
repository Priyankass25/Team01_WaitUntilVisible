@Logout
Feature: Logout

  Scenario:  Logout function
  	Given Admin is on home page after Login
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page