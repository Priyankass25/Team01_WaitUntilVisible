@Login
Feature: 
  	
    When User enters the url "https://lms-frontend-hackathon-6dcccb9dd0fa.herokuapp.com/login"
    Then LMS page should be launched

  	When: User enters Invalid URL "https://lms-frontend-hackatho"
    Then LMS Page should not open

  	When: User enters Broken link "https://lms-frontend-hackathon-"
    Then LMS Page should not open

   	Scenario: User enters the url "https://lms-frontend-hackathon-6dcccb9dd0fa.herokuapp.com/login"
    Then Admin should see  LMS - Learning Management System  
   
   	Scenario: User enters the url "https://lms-frontend-hackathon-6dcccb9dd0fa.herokuapp.com/login"
    Then Application logo should be present 

		Scenario: User enters the url "https://lms-frontend-hackathon-6dcccb9dd0fa.herokuapp.com/login"
    Then Company name "Numpy Ninja" is displayed below the Application title
   
   	Scenario: User enters the url "https://lms-frontend-hackathon-6dcccb9dd0fa.herokuapp.com/login"
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
    Then AAdmin should see "Admin", "staff" ,"student" options in dropdown

  	Scenario: Alignment of the login form
    Then Admin should see login form on the centre of the page

  	Scenario: Input field label alignment
    Then Username , Password labels and select the role should be left-aligned above their respective input fields

  	Scenario: Login button is displayed
    Then Admin should see login button 

  	Scenario: User field Placeholder text colour
    Then Admin should see user text in gray color

 	  Scenario: Password field Placeholder text colour
    Then Admin should see password text in gray color
