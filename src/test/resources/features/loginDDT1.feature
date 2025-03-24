Feature: Login Test with multiple test data using excel file
  I want to validate login functionality with multiple test data is working as expected with excel file

  @sanity
  Scenario Outline: Verify user is able to login into the app with valid and invalid credentials with excel file
    Given user is on login page
    Then the user should be redirected to the MyAccount Page by passing email, password with row index "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
