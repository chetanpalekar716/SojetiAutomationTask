#API Test 1
@APITest1
Feature: Verify basic service responses

  Scenario: Check for Response Status Code, Response Time and other other basic response validation
    Given an API Get Request is triggered
    Then API service response code is 200
    And content type is "JSON"
    And response time is less than 4 second