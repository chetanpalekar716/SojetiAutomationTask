package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.automation.AutomationPageActions;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class AutomationPageDefinitions {
	
	@Steps
	AutomationPageActions automationPageActions;
	
	@Then("User is navigated to {string} Page")
	public void user_is_navigated_to_page(String pageTitle) {
	    assertThat(automationPageActions.validatePageTitle(pageTitle)).isTrue();
	}

	@Then("the text {string} is displayed")
	public void the_text_is_displayed(String pageText) {
		assertThat(automationPageActions.validatePageText(pageText)).isTrue();
	}
	
	@When("User submits {string},{string},{string},{string},{string},{string} in the Contact Form")
	public void user_submits_in_the_contact_form(String fName, String lName, String email, String phone, String country, String message) {
		automationPageActions.submitContactForm(fName,lName,email,phone,country,message);
	}

	@Then("the form is successfully submitted")
	public void the_form_is_successfully_submitted() {
		assertThat(automationPageActions.validateSuccessfulSubmission()).isTrue();;
	}
}
