@Program
Feature: Program

  Background: 
    Given Admin is on home page after Login

  #---Navigation Feature---
  @baga
  Scenario: Program page navigation
    When Admin clicks "Program" on the navigation bar
    Then Admin should be navigated to Program page

  #---Menu bar Feature---
  @baga
  Scenario: Manage program heading presence
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the heading Manage Program

  #---Manage Program - UI validation Feature---
  @baga
  Scenario: Manage program heading alignment
    When Admin clicks "Program" on the navigation bar
    Then Admin should see manage program heading aligned on the left side
@baga
  Scenario: Multiple Delete button state
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a Delete button in left top is disabled
@baga
  Scenario: Search box is displayed
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Search bar

@baga  
  Scenario: Search placeholder presence
    When Admin clicks "Program" on the navigation bar
    Then Admin should see search... placeholder text
@baga
  Scenario Outline: Column header name of data table "<columnHeaders>"
    When Admin clicks "Program" on the navigation bar
    Then Admin should see data table with column headers "<columnHeaders>" on the Manage Program Page

    Examples: 
      | columnHeaders       |
      | Program Name        |
      | Program Description |
      | Program Status      |
      | Edit / Delete       |
@baga
  Scenario: Checkbox default state - header
    When Admin clicks "Program" on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header
@baga
  Scenario: Checkbox default state - datatable each rows
    When Admin clicks "Program" on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name
@baga
  Scenario: Sort icon presence
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete
@baga
  Scenario: Edit and delete icon presence
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table
@baga-similartoabove
  Scenario: Pagination controls are displayed
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination controls below the table.

  #x- starting record number on that page
  #y-ending record number on that page
  #z-Total number of records
  Scenario: Footer message is displayed
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the footer as "In total there are z programs".

  #z- Total number of records
  #---Add New Program - UI Validation Feature---
@baga
  Scenario: Add New Program dialog is displayed
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Add New Program dialog
@baga
  Scenario: Program Details dialog title
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see  title as Program Details
 @baga
  Scenario Outline: Mandatory fields indicator
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see red  asterisk mark  beside mandatory field Name and Status
@baga
  Scenario: Name field is displayed
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see the Name text box
@baga
  Scenario: Description field is displayed
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see the Description text box
@baga
  Scenario: Status radio buttons are displayed
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see Active and Inactive radio buttons

  #---Add New Program - Functional Validation Feature---
  Scenario Outline: "<scenarioName>" Add new program validations Empty form submission
    Given Admin is on Program details dialog box
    When Admin clicks save button without entering mandatory
    Then Admin gets message "<msg>"

    Examples: 
      | scenarioName          | msg                                                                                               |
      | Empty form submission | Program name is required and Status is required                                                   |
      | Valid details         | Successful Program created                                                                        |
      | Numeric program name  | This field should start with an alphabet, no special char other than a hyphen and have min 4 char |

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
    When Admin searches with newly created "Program Name"
    Then Admin should see the Records of the newly created Program details

  #--- Edit Program - Functional validation Feature ---
  Scenario: Edit icon functionality
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see Program Details dialog

  Scenario Outline: Edit Program fields "<fields>"
    Given Admin is on Program details dialog box
    When Admin clicks save button after editing the fields "<fields>"
    Then Admin should see "Successful Program Updated" message

    Examples: 
      | fields       |
      | Program Name |
      | Description  |
      | Status       |

  #---Delete Program Feature ---
  Scenario: Display Delete Confirmation
    Given Admin is on Program page
    When Admin clicks on delete icon for a program
    Then Admin will get confirm deletion dialog box

  #Put detele yes and no in a single case
  Scenario: Delete Program Successfully
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Program Deleted' message

  Scenario: Deleted Program visibility
    Given Admin is on Program page
    When Admin Searches for "Deleted Program name"
    Then There should be zero results

  Scenario: Cancel Program Deletion
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin clicks on "No" button
    Then Admin can see Confirmation form disappears

  Scenario: Close Delete Confirmation
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin Click on "X" button
    Then Admin can see Confirm Deletion form disappear

  #--- Delete Multiple Program Feature ---
  Scenario: Select multiple programs
    Given Admin is on Program page
    When Admin selects more than one program by clicking on the checkbox
    Then Mulitple delete box under manage program must be enabled

  Scenario: Delete Multiple programs
    Given Admin is on Program page
    When Admin clicks on the delete button on the left top of the program page
    Then Admin lands on Confirmation form

  #put delete yes and no in single test
  Scenario: Delete selected program
    Given Admin is on Confirmation form
    When Admin clicks on "Yes" button
    Then Admin can see "Successful  program deleted" message

  Scenario: Deleted program Visibility
    Given Admin is on Program page
    When Admin Searches for "Deleted Program names"
    Then There should be zero results

  Scenario: Cancel Multiple Deletion
    Given Admin is on Confirmation form
    When Admin clicks on "No" button
    Then Admin can see Programs are still selected and not deleted

  Scenario: Close Multiple deletion confirmation
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin Click on "X" button
    Then Admin can see Confirm Deletion form disappear
