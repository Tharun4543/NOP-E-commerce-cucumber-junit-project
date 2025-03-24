Feature: Login Test with multiple test data
  I want to validate login functionality with multiple test data is working as expected

  @sanity
  Scenario Outline: Verify user is able to login into the app with valid and invalid credentials
    Given user is on login page
    Then the user should be redirected to the MyAccount Page by passing email "<email>", password "<password>", and status "<status>"

    Examples:
      | email                | password   | status  |
      | Test54321@gmail.com  | Test@1234  | valid   |
      | Test456@gmail.com  | Junnu@312  | invalid |
