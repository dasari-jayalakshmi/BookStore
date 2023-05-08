#Author: dasari.jayalakshmi17@gmail.com
@Login
Feature: Login to the application
  As a registered user
  I want to log in to the application
  So that I can access bookstore

  @UnitTest
  Scenario: Login page should have login button
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    Then I should see a login button with the text "Login"

  @UnitTest
  Scenario: Login page should have New User button
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    Then I should see a Newuser button with the text "New User"

  @UnitTest
  Scenario: Login Page header text
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    Then It should have header with the text "Login"

  @UnitTest
  Scenario: Login Page left panel
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    Then It should have left panel

  @UnitTest @LoginSuccess
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    And User enters Email as "dasari.jayalakshmi17@gmail.com" and Password as "Welcome@823"
    And Click on Login
    Then Page Title should be "Profile"

  @UnitTest @LoginFailure
  Scenario: Unsuccessful Login with in valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    And User enters Email as "dasari.jayalakshmi17@gmail.com" and wrong Password as "WrongPassword"
    And Click on Login
    Then It should display error message as "Invalid username or password!"
