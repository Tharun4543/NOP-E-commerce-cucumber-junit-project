Feature: Register Test
  I want to validate register functionality is working as expected
  @sanity
  Scenario: Verify user is able to register into the app with valid test data
    Given user is on register page
    When user provides test data with following inputs perform continue action
     | firstName | Junnu |
     | lastName  | Sheey |
     | password  | Test@123 |
     | confirmPass | Test@123 |
    Then verify account registration success message is displayed