@Program
Feature:Program

Background:
    Given Admin is on home page after Login
    
	Scenario: Program page navigation
    When Admin clicks "Program" on the navigation bar
    Then Admin should be navigated to Program page