@Login
Feature: HerBalance Login Page UI Verification

  Background:
   # Given User is on the HerBalance launch page
    #When User clicks log in button

  Scenario: HerBalance logo visibility
    Then HerBalance logo should be visible on the top-left corner

  Scenario: Login and Sign Up tabs are displayed
    Then Both "Login" and "Sign Up" tabs should be visible

  Scenario: Default selected tab is “Login”
   When User clicks loginTab button
    Then Login tab should be active by default

  Scenario: Email ID input field presence on loginPage
    Then Email ID input field with placeholder "you@example.com" should be visible on loginPage

  Scenario: Password input field presence
    Then Password input field with masked entry should be visible on LoginPage

  Scenario: “Show Password” presence
    Then “Show password” should be visible

  Scenario: “Login” button presence and state
    Then “Login” button should be visible, enabled

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
    

 