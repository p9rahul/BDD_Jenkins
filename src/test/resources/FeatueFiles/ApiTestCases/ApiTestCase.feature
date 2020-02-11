Feature: Api service test

  @Smoke
  Scenario: 1.Verify service response and content
    Given Send a get request
    When user has a valid URL
    Then verify the status code
    Then verify the email id
    And verify the first name and last name

  @Smoke
  Scenario: 2.Verify service response and content
    Given Send a get request
    When user has a valid URL
    Then verify the status code
    Then verify the email id
    And verify the first name and last name
