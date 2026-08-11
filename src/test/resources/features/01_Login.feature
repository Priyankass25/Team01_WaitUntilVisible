@Login
Feature:Login
<<<<<<< HEAD

    Scenario: Login page navigation (valid URL)  	
    When User enters the url "https://lms-frontend-hackathon-6dcccb9dd0fa.herokuapp.com/login"
    Then LMS page should be launched
      
    Scenario: InValid Login 	
   	When: User enters Invalid URL "https://lms-frontend-hackatho"
    Then LMS Page should not open

	  Scenario: Broken link 
  	When: User enters Broken link "https://lms-frontend-hackathon-"
=======
    Scenario: Login page navigation (valid URL)  	
    When User enters the url "https://lms-frontend-hackathon-6dcccb9dd0fa.herokuapp.com/login"
    Then LMS page should be launched


		Scenario: Invalid URL 
  	When User enters Invalid URL "https://www.google.com/"
>>>>>>> main
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

  Scenario: “Forgot password?” link presence
   When User clicks logIn button
    Then “Forgot password?” link should be visible

  Scenario: “Sign Up” link visibility
    Then “Sign Up” link should be visible and navigates to the Sign-Up page

  Scenario: Right panel content (Transform Your Weight Loss Journey)
    Then The right section should display “Cycle-Synced Plans”, “Blood Work Analysis”, and “Personalized Dashboard” content

  Scenario: Testimonial section presence
    Then A testimonial with text and name (e.g., “Sarah, 34”) should be displayed

  Scenario: Total number of tabs
    Then There should be exactly 2 tabs — “Login” and “Sign Up”

  Scenario: Input field alignment and spacing
    Then Email ID and Password fields should be properly aligned vertically with equal spacing

  Scenario: Two input field
    Then There should be exactly 2 input field

  Scenario: Radio button for show password
    Then Radio button for show password
    
   ###########################Login Page - Functional Verification########################

  Scenario: Successful login with valid credentials
   
    When Admin enters valid username, valid password, selects valid role and clicks login button
    Then Admin should land on home page


  Scenario: Login with special character in username
    When Admin enters special character in username, valid password, selects valid role and clicks login button
    Then Admin should see invalid credential error


  Scenario: Login attempt with empty username
    When Admin enters valid password, selects valid role and clicks login button without entering username
    Then Admin should see empty username error


  Scenario: Login attempt with empty password
    When Admin enters valid username, selects valid role and clicks login button without entering password
    Then Admin should see empty password error


  Scenario: Login attempt with wrong password
    When Admin enters valid username, wrong password, selects valid role and clicks login button
    Then Admin should see invalid credential error on login page


  Scenario: Login attempt without selecting any role
    When Admin enters valid username and valid password and clicks login button without selecting role
    Then Admin should see no role selected error


  Scenario: Login attempt with invalid role
    When Admin enters valid username, valid password, selects invalid role and clicks login button
    Then Admin should see invalid role error


 Scenario: Login attempt using keyboard
    When Admin enters valid credentials, selects valid role and submits login using keyboard
    Then Admin should land on the home page


  Scenario: Login attempt using mous e
    When Admin enters valid credentials, selects valid role and submits login using mouse
    

 

