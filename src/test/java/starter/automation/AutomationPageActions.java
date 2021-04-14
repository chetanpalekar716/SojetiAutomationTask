package starter.automation;

import net.thucydides.core.annotations.Step;

public class AutomationPageActions {

	AutomationPage automationPage;
	
	@Step("Validate '{0}' page title")
	public boolean validatePageTitle(String pageTitle) {
		return automationPage.fetchPageTitle().equals(pageTitle);
	}
	
	@Step("Validate '{0}' page text")
	public boolean validatePageText(String pageText) {
		return automationPage.checkPageTextDisplayed(pageText);
	}
}
