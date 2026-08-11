@Program
Feature: Program

  Background: 
    Given Admin is on home page after Login

  #---Navigation Feature---
  
  Scenario: Program page navigation
    When Admin clicks "Program" on the navigation bar
    Then Admin should be navigated to Program page

  #---Menu bar Feature---
 
  Scenario: Manage program heading presence
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the heading Manage Program

  #---Manage Program - UI validation Feature---
  
  Scenario: Manage program heading alignment
    When Admin clicks "Program" on the navigation bar
    Then Admin should see manage program heading aligned on the left side

  
  Scenario: Multiple Delete button state
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a Delete button in left top is disabled

 
  Scenario: Search box is displayed
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Search bar

  
  Scenario: Search placeholder presence
    When Admin clicks "Program" on the navigation bar
    Then Admin should see search... placeholder text

  
  Scenario Outline: Column header name of data table "<columnHeaders>"
    When Admin clicks "Program" on the navigation bar
    Then Admin should see data table with column headers "<columnHeaders>" on the Manage Program Page

    Examples: 
      | columnHeaders       |
      | Program Name        |
      | Program Description |
      | Program Status      |
      | Edit / Delete       |

  
  Scenario: Checkbox default state - header
    When Admin clicks "Program" on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header

  
  Scenario: Checkbox default state - datatable each rows
    When Admin clicks "Program" on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name

  
  Scenario: Sort icon presence
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  
  Scenario: Edit and delete icon presence
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table

  @yetTodo
  Scenario: Pagination controls are displayed
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination controls below the table.

  #x- starting record number on that page
  #y-ending record number on that page
  #z-Total number of records
  
  @yetTodo
  Scenario: Footer message is displayed
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the footer as "In total there are z programs".
  #z- Total number of records
  
  #---Add New Program - UI Validation Feature---
  
  Scenario: Add New Program dialog is displayed
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Add New Program dialog

  
  Scenario: Program Details dialog title
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see  title as Program Details

 
  Scenario Outline: Mandatory fields indicator
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see red  asterisk mark  beside mandatory field Name and Status

  
  Scenario: Name field is displayed
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see the Name text box

  
  Scenario: Description field is displayed
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see the Description text box

 
  Scenario: Status radio buttons are displayed
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see Active and Inactive radio buttons

  #---Add New Program - Functional Validation Feature---
  
  Scenario Outline: "<scenarioName>" Add new program validations
    Given Admin is on Program details dialog box
    When Admin clicks save button for scenario "<scenarioName>"
    Then Admin gets message "<scenarioName>"

    Examples: 
      | scenarioName         |
      | EmptyMandatoryFields |
      | ValidMandatoryFields |
      | NumericProgramName   |

  
  Scenario: Cancel button functionality
    Given Admin is on Program details dialog box
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears

  
  Scenario: Close button (X) functionality
    Given Admin is on Program details dialog box
    When Admin clicks X button
    Then Admin can see Program Details form disappears

  
  Scenario: Verify added Program is created
    Given Admin is on Program page
    When Admin searches with newly created Program Name
    Then Admin should see the Records of the newly created Program details

  #--- Edit Program - Functional validation Feature ---

  Scenario: Edit icon functionality
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see Program details dialog box

  Scenario Outline: Edit Program fields "<fields>"
    Given Admin is on Program details dialog box for edit
    When Admin clicks save button after editing the fields "<fields>"
    Then Admin should see success message "<fields>"

    Examples: 
      | fields       |
      | Name 				 |
      | Description  |
      | Status       |

  #---Delete Program Feature ---
  
  Scenario: Display Delete Confirmation
    Given Admin is on Program page
    When Admin clicks on delete icon for a program
    Then Admin will get confirm deletion dialog box

  Scenario: Delete Program Successfully
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin clicks on Yes button
    Then Admin can see success delete message

  Scenario: Deleted Program visibility
    Given Admin is on Program page
    When Admin Searches for Deleted Program name
    Then There should be zero results

  Scenario: Cancel Program Deletion
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin clicks on No button
    Then Admin can see Confirmation form disappears

  Scenario: Close Delete Confirmation
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin Click on X button
    Then Admin can see Confirm Deletion form disappear

  #--- Delete Multiple Program Feature ---
  
  Scenario: Select multiple programs
    Given Admin is on Program page
    When Admin selects more than one program by clicking on the checkbox
    Then Mulitple delete box under manage program must be enabled

  Scenario: Delete Multiple programs
    Given Admin is on Program page
    When Admin clicks on the delete button on the left top of the program page
    Then Admin will get confirm deletion dialog box
    

  Scenario: Delete selected program
    Given Admin is on Confirmation form
    When Admin clicks on Yes button
    Then Admin can see success delete message

@yetTodo
  Scenario: Deleted program Visibility
    Given Admin is on Program page
    When Admin Searches for Deleted Program names
    Then There should be zero results

@yetTodo
  Scenario: Cancel Multiple Deletion
    Given Admin is on Confirmation form
    When Admin clicks on No button
    Then Admin can see Programs are still selected and not deleted

  Scenario: Close Multiple deletion confirmation
    Given Admin is on Confirmation form
    When Admin Click on X button
    Then Admin can see Confirm Deletion form disappear

##--Sowmya
@ManageProgramSearchbar
Scenario Outline: Search by program name
    Given Admin is on Program page
    When Admin enters the program name in search box
    Then Admin should see "<field>" for searched program name
Examples:
    | field        |
    | Program name |
    | Description  |
    | Status       |
    
    
    @ManageProgramSearchbar
    Scenario Outline: Search by program description
    Given Admin is on Program page
    When Admin enters the program description in search box
    Then Admin should see "<field>" for searched program description
    Examples:
    | field        |
    | Program name |
    | Description  |
    | Status       |
    
     @ManageProgramSearchbar
  Scenario: Search by Non-Existent Program Name
    Given Admin is on Program page
    When Admin enters the program that does not exist in search box
    Then There should be zero results .

   @ManageProgramSearchbar
Scenario Outline: Search by partial program name
    Given Admin is on Program page
    When Admin enters the partial name of program in search box
    Then Admin should be able to see "<field>" for searched program name
    Examples:
    | field        |
    | Program name |
    | Description  |
    | Status       |
    
    @ManageProgram-Sorting
    Scenario: Sorting of  Program name in Ascending order
     Given Admin is on Program page
     When Admin clicks on Arrow next to program Name
     Then Admin should  See the Program Name is sorted in Ascending order
     
     
    @ManageProgram-Sorting1
    Scenario: Sorting of  Program name in Descending order
    Given Admin is in program page where Program names are sorted in ascending order
    When Admin clicks on Arrow next to program Name.
    Then Admin should See the Program Name is sorted in Descending order
     
     @ManageProgram-Sorting2
     Scenario: Sorting of  Program Description in Ascending order of  Program Description in Ascending order
     Given Admin is on Program page
     When Admin clicks on Arrow next to Program Description
     Then Admin should See the program Description is sorted in Ascending order
     
      @ManageProgram-Sorting3
     Scenario: Sorting of  Program Description in Descending order
     Given Admin is in program page where Program description are sorted in ascending order
     When  Admin clicks on Arrow next to Program Description.
     Then Admin  should See the program Description is sorted in Descending order
     
      @ManageProgram-Sorting4
     Scenario: Sorting of program status in Ascending order
     Given Admin is on Program page
     When  Admin clicks on Arrow next to Program status
     Then Admin should see the Program status sorted in Ascending order
     
       @ManageProgram-Sorting5
     Scenario: Sorting of Program status in Descending order
     Given Admin is in program page where Program status are sorted in ascending order
     When  Admin clicks on Arrow next to Program status
     Then Admin should see the Program status sorted in Descending order
     
     @ManageProgram-Pagination
     Scenario: Admin Next Page Navigation
     Given Admin is on Program page with multiple program records
     When  Admin clicks the next page option (>) in the pagination control
     Then Admin should navigate to the next page and see the next set of program records
     
        @ManageProgram-Pagination2
     Scenario: Admin Last Page Navigation
     Given Admin is on any page except the last page of Program table
     When  Admin clicks the last page option (>>) in the pagination control
     Then Admin should see the last page record on the table 
     
         @ManageProgram-Pagination3
     Scenario: AdminPrevious Page Navigation
     Given Admin is on the Program table on any page except the first page
     When  Admin clicks the previous page option (<) in the pagination control
     Then Admin should see the previous page record on the table  
     
             @ManageProgram-Pagination4
     Scenario: First Page Navigation
     Given Admin is on any page except the first page of Program table
     When  Admin clicks the first page option (<<) in the pagination control
     Then Admin should see the very first page record on the table  

     
  