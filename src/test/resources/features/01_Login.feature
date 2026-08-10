@Login
Feature:Login
  @Login
Feature:Login
    Scenario: Login page navigation (valid URL)  	
    When User enters the url "https://lms-frontend-hackathon-6dcccb9dd0fa.herokuapp.com/login"
    Then LMS page should be launched

		Scenario: Invalid URL 
  	When User enters Invalid URL "https://www.google.com/"
    Then LMS Page should not open
	
	    Scenario: Broken URL 
  	When User enters Broken link "https://lms-frontend-hackathon-"
    Then LMS Page should not open with broken link
	
	 Scenario: LMS Text verification
    Then Admin should see  LMS - Learning Management System  
   
   	Scenario: Logo Verifivcation
    Then Application logo should be present 

		Scenario: Company name Verification--------------not working
    Then Company name "Numpy Ninja" is displayed below the Application title
   
   	Scenario: Text verification
    Then Admin should see "Please login to LMS application"
	
	Scenario: Input field presence
    Then Admin should see two text field

  	Scenario: Role dropdown is displayed
    Then  One dropdown with values such as Admin, Staff, Student should be displayed

  	Scenario: Text presence on the first field
    Then Admin should see "User" in the first text field

  	Scenario: Text presence on the second field
    Then Admin should see "Password" in the second text field

 		Scenario: Asterisk is displayed for user field
    Then Admin should see asterisk mark(*) symbol next to text for user field


 		Scenario: Asterisk is displayed for password field
    Then Admin should see asterisk mark(*) symbol next to text for pwd field

  	Scenario: Placeholder presence in dropdown
    Then Admin should see "select the role " placeholder in dropdown

  	Scenario: Dropdown options to select role
    Then Admin should see "Admin", "staff" ,"student" options in dropdown