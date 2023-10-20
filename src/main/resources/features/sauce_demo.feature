Feature: Saucedemo Login Test

  Scenario: User logs in with valid credentials
    Given user is on the Saucedemo login page
    When user enters valid username and password
    And clicks the login button
    Then user is redirected to the products page

  Scenario: User login with empty username
    Given user is on the Saucedemo login page
    When user not input username
    When user input valid password
    And clicks the login button
    Then error message showing
