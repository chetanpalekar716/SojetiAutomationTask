package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.automation.AutomationPageActions;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class AutomationPageDefinitions {
	
	@Steps
	AutomationPageActions automationPageActions;
	
	@Then("User is navigated to {string} Page")
	public void user_is_navigated_to_page(String pageTitle) {
	    assertThat(automationPageActions.validatePageTitle(pageTitle)).isTrue();;
	}

	@Then("the text {string} is displayed")
	public void the_text_is_displayed(String pageText) {
		assertThat(automationPageActions.validatePageText(pageText)).isTrue();
	}

}
