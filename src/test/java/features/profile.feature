@Profile
Feature: Profile page
  I want to access profile page
  So that I can see my collection

  @UnitTest @ProfileTest
  Scenario: After successful login I can see three buttons in profile page
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    And User enters Email as "dasari.jayalakshmi17@gmail.com" and Password as "Welcome@823"
    And Click on Login
    Then I can see "Log out" button and "Delete Account" button and "Go to Book Store" button
   