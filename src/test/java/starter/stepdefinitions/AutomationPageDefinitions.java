package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.automation.AutomationPage;

public class AutomationPageDefinitions {
	
	@Steps
	AutomationPage automationPage;
	
	@Then("User is navigated to {string} Page")
	public void user_is_navigated_to_page(String pageTitle) {
	    
	}

	@Then("the text {string} is displayed")
	public void the_text_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
