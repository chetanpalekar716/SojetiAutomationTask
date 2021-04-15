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

	public void submitContactForm(String fName, String lName, String email, String phone, String country,String message) {
		automationPage.inputFirstName(fName);
		automationPage.inputLastName(lName);
		automationPage.inputEmail(email);
		automationPage.inputPhone(phone);
		automationPage.selectCountry(country);
		automationPage.inputMessage(message);
		automationPage.selectCheckBoxAgree();
		automationPage.selectCheckBoxCaptcha();
		automationPage.submitForm();
	}

	public boolean validateSuccessfulSubmission() {
		return automationPage.checkSuccessMessage();
	}
	
}
