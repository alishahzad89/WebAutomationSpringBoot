@Regression

Feature: Validate home page features

  @WebAutomation @Sanity @Image
  Scenario: Validate home page logo
    Given Navigate to home page
    When Capture home logo
    Then Validate home logo is correct

  @WebAutomation
  Scenario: Validate verterin details
    Given Navigate to veterin page
    When Capture veterin along with specialities
    Then Print vetrin details on console

  @WebAutomation
  Scenario: Validate owner details
    Given Navigate to owner page
    When Capture all owners
    Then Print owner details on console

  @WebAutomation @Pet
  Scenario: Validate owner details
    Given Navigate to owner page
    When Add new owner details along with pet
    Then Verify newly added owner details
    And Add pet cat details for owner
    And Verify added pet details