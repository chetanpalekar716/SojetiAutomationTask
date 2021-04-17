#API Tests 1 and 2
@APITest @SogetiTask
Feature: Check for Response Status Code, Content Type, Response Time and other other basic response validation
	@Test1
  Scenario: Verify response for a city
    Given an API Get Request is triggered with endpoint "/de/bw/stuttgart"
    Then API service response code is 200
    And content type is "JSON"
    And response time is less than 5 second
    And country is "Germany" state is "Baden-Württemberg"
    And for post code "70597" the place name has "Stuttgart Degerloch" 
    
  @Test2
  Scenario Outline: Verify response for multiple cities
  	Given an API Get Request is triggered with "<Country>" and "<PostalCode>" details
  	Then API service response code is 200
  	And content type is "JSON"
  	And response time is less than 5 second
  	And place name is "<PlaceName>"
  	
  	Examples:
			|Country|PostalCode	|PlaceName					|
			|de			|70597			|Stuttgart Degerloch|
			|us		  |90210		 	|Beverly Hills			|
			|us		  |12345		 	|Schenectady				|
			|ca		  |B2R			 	|Waverley						|