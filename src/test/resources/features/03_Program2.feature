@Program2
Feature: Testing Program module in LMS
  
  Background: Admin navigates to program page after logged in
    Given Admin is on Program page
    
  @ManageProgramSearchbar
  Scenario: Search by program name
    When Admin enters the program name in search box 
    Then Admin should  see Program name, description, and status for searched program name
    
     @ManageProgramSearchbar2
  Scenario: Search by  program description
    When Admin enters the program description in search box 
    Then Admin should  see Program name, description, and status for searched program description


     @ManageProgramSearchbar3
  Scenario: Search by Non-Existent Program Name
    When Admin enters the program that does not exist in search box
    Then There should be zero results.

    @ManageProgramSearchbar4
  Scenario: Search by partial program name
    When Admin enters the partial name of program in search box
    Then Admin should be able to see Program name, description, and status for searched program name
 

 