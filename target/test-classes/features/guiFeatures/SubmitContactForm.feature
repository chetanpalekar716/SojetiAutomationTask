#Test Case 2
#PLEASE NOTE: the final "Then" step here which would be used
#for submitting the form has been commented out as subitting a 
#form on this site requires the the interaction with the ReCaptch.
#Since Selenium WebDriver does not provide the functionality of
#interacting with ReCaptcha elements, automating this step cannot be
#achieved via test automation.
#As a best practice it is always advisable to avoid automating web pages
#that requires a ReCaptch validation, since the main reason of having
#ReCaptcha in the first place, is to avoid creation of automated spam 
#requests.
#Therefore, one possible solution to automate this test case, is by 
#requesting the developers to disable the ReCaptcha validation on the Test
#environment, where automation testing is in practice.
#Other solution could be to use 3rd party tools to perform this validation.
#Although, this would not be advisable.

@SubmitContactForm @SogetiTask
Feature: Fill and Submit Contact Us Form on Automation Page under Services

  Scenario Outline: Fill and Submit Contact Us Form
    Given User is on Home Page
    And User hovers on "Services" menu
    And selects "Automation" submenu
		And User is navigated to "Automation" Page
		When User submits "<FirstName>","<LastName>","<Email>","<Phone>","<Country>","<Message>" in the Contact Form
		#Then the form is successfully submitted
		
		Examples:
			|FirstName|LastName	|Email			|Phone|Country|Message			|
			|abc			|def			|abc@def.com|12345|Belgium|hello sogeti |