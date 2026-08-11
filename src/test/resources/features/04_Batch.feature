@batch
Feature: Batch Page Navigation

    Background:
      Given Admin is logged in to LMS Portal and landed on home page
 # Rule: Admin can navigate to the Manage Batch page

    Scenario: Navigate to Manage Batch page
      When Admin clicks the "Batch" on the navigation bar
      Then Admin should be redirected to the Manage Batch Page
#Rule: Admin can navigate to the Manage Batch page
    Scenario: Verify Batch submenu options
      Then Admin should see the submenu option "Add New Batch"

    Scenario: Verify Manage Batch page heading
      Then Admin should see the "Manage Batch" heading

    Scenario: Verify disabled Delete button before selecting batches
      Then Admin should see the disabled Delete icon under the header

    Scenario: Verify pagination controls on Batch page
      Then Admin should see pagination controls below the data table

    Scenario: Verify edit icon availability for batch records
      Then Admin should see the edit icon for each batch record

    Scenario: Verify delete icon availability for batch records
      Then Admin should see the delete icon for each batch record

    Scenario: Verify checkbox availability for batch records
      Then Admin should see checkboxes for each batch record

    Scenario: Verify batch data table headers
      Then Admin should see the following batch table headers:
       # | Headers      |
        | Batch Name        |
        | Batch Description |
        | Batch Status      |
        | No Of Classes     |
        | Program Name      |
        |  Edit / Delete       |
        Scenario: Verify sorting icons in batch table
      Then Admin should see sort icons next to all batch table headers
      
#######-----ADD NEW BATCH
  Scenario Outline: Verify fields displayed on Add New Batch page
    When Admin clicks on "Add New Batch" under the "Batch" menu bar
    Then Admin should see the "<field>" on the Add New Batch page

    Examples:
      | field                    |
      | Batch Name         |
      | Number of Classes field  |
      | Description field        |
      | Program Name dropdown    |
      | Status radio buttons     |


  

  Scenario: Select program name
  Given Admin is on the Batch Details dialog box
    When Admin selects program name from the dropdown
    Then Admin should see selected program name as the batch name prefix

  
####-----------Delete BATCH DETAILS-------------------
Scenario Outline: Verify delete batch functionality
    Given Admin is on the Batch page
    When Admin performs "<action>"
    Then Admin should see "<expected result>" on the batch page

Examples:
    | action                                  | expected result                                      |
    | clicks delete icon on any batch row     | confirmation popup with Yes and No buttons           |
    | clicks delete icon and clicks Yes       | success message and batch is deleted                 |
    | clicks delete icon and clicks No        | popup closes and batch is not deleted                |
    | clicks delete icon and clicks close     | popup closes                                         |
           #==============DELETE MULTIPLE BATCH DETAILS================
 # Rule: Admin should be able to delete multiple batches

    Scenario: Verify multiple delete button is enabled
      When Admin selects multiple batches by clicking the checkboxes
      Then Admin should see the multiple delete button enabled

    Scenario: Verify multiple batch delete confirmation
      Given Admin has selected multiple batches
      When Admin clicks the multiple delete button
      Then Admin should see the delete confirmation dialog
      #===============
    ## Batch Page - Pagination

#### Scenario: Navigate to Next Page


Scenario: Admin navigates to the next page
  Given Admin is on the batch page with multiple records
  When Admin clicks the Next page ">" option
  Then Admin should see the next page of the batch table


#### Scenario: Navigate to Last Page

Scenario: Admin navigates to the last page
  Given Admin is on any batch page except the last page
  When Admin clicks the Last page ">>" option
  Then Admin should see the last page with the Next page ">" option disabled


#### Scenario: Navigate to Previous Page


Scenario: Admin navigates to the previous page
  Given Admin is on any batch page except the first page
  When Admin clicks the Previous page "<" option
  Then Admin should see the previous page of the batch table


#### Scenario: Navigate to First Page


Scenario: Admin navigates to the first page
  Given Admin is on any batch page except the first page on batch page
 
  When Admin clicks the First page "<<" option
  Then Admin should see the first page of the batch table


#### Scenario: Pagination Arrows Disabled on First Page


Scenario: Pagination arrows are disabled on the first page
  Given Admin is on the first page of a batch table with multiple pages
  When Admin views the pagination control
  Then the First page "<<" and Previous page "<" options should be disabled


#### Scenario: Pagination Arrows Enabled on First Page


Scenario: Pagination arrows are enabled on the first page
  Then the Next page ">" and Last page ">>" options should be enabled

