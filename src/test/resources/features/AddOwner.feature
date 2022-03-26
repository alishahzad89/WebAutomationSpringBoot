@Regression

Feature: Validate add owner details along with pet details

  @Owner @Sanity
  Scenario: Validate owner details along with cat pet
    Given Navigate to owner page
    When Add new owner details along with pet
    Then Verify newly added owner details
    And Add pet cat details for owner
    And Verify added pet details

  @Owner
  Scenario: Validate owner details along with dog pet
    Given Navigate to owner page
    When Add new owner details along with pet
    Then Verify newly added owner details
    And Add pet dog details for owner
    And Verify added pet details

  @Owner
  Scenario: Validate owner details along with bird pet
    Given Navigate to owner page
    When Add new owner details along with pet
    Then Verify newly added owner details
    And Add pet bird details for owner
    And Verify added pet details