#Test Case 2
@SubmitContactForm
Feature: Fill and Submit Contact Us Form on Automation Page under Services

  Scenario Outline: Fill and Submit Contact Us Form
    Given User is on Home Page
    And User hovers on "Services" menu
    And selects "Automation" submenu
		And User is navigated to "Automation" Page
		When User submits "<FirstName>","<LastName>","<Email>","<Phone>","<Country>","<Message>" in the Contact Form
		Then the form is successfully submitted
			
		Examples:
			|FirstName|LastName	|Email			|Phone|Country|Message			|
			|abc			|def			|abc@def.com|12345|Belgium|hello sojeti |