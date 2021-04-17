#Test Case 3
@ValidateLinks @SogetiTask
Feature: Verify all Worldwide Country specific Sogeti links

  Scenario: Check Country specific Sogeti links are working
    Given User is on Home Page
    When User tries to verify Worldwide Country specific Sogeti links
    Then all Worldwide Country specific Sogeti links are working