Feature: Login Test
  I want to validate login functionality is working as expected
  @regression
  Scenario: Verify user is able to login into the app with valid credentials
    Given user is on login page
    When user enters email as "Test54321@gmail.com" and password as "Test@1234"
    And click on login button
    Then verify my account header exists