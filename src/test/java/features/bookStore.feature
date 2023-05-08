@BookStore
Feature: BookStore page
  I want to access BookStore page
  So that I can see different collection of books

  @UnitTest 
  Scenario: After successful login I can see three buttons in profile page
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    And User enters Email as "dasari.jayalakshmi17@gmail.com" and Password as "Welcome@823"
    And Click on Login
    Then after successul login redirected to book store page
    And can see list of books
    
  @UnitTest 
  Scenario: Search should work on book store
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    And User enters Email as "dasari.jayalakshmi17@gmail.com" and Password as "Welcome@823"
    And Click on Login
    Then after successul login redirected to book store page
    And enter "Git" in search box 
    Then it should display "Git Pocket Guide" book in results
    
    
  @UnitTest
  Scenario: Book details view 
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    And User enters Email as "dasari.jayalakshmi17@gmail.com" and Password as "Welcome@823"
    And Click on Login
    Then after successul login redirected to book store page
    And user click book with name "Git Pocket Guide"
    Then it should show book details page
    
  @UnitTest
  Scenario: Add book to collection 
    Given User Launch Chrome browser
    When User opens URL "https://demoqa.com/login"
    And User enters Email as "dasari.jayalakshmi17@gmail.com" and Password as "Welcome@823"
    And Click on Login
    Then after successul login redirected to book store page
    And user click book with name "Git Pocket Guide"
    Then it should show book details page
    And user click on AddToYourCollection button
    Then it should display popupMessage "Book added to your collection"
   
   