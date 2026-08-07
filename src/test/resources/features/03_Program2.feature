@Program2
Feature: Testing Program module in LMS
  
  Background: Admin navigates to program page after logged in
    Given Admin is on Program page
    
  @ManageProgramSearchbar
  Scenario: Search by program name
    When Admin enters the program name in search box 
    Then Admin should  see Program name, description, and status for searched program name
 
  
 