package starter.automation;


import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import starter.utilities.HelperFunctions;

public class AutomationPage extends PageObject{
	
	private static String TEXT_AUTOMATION = "//h1/span[text()='";
	private static By INPUT_FIRST_NAME = By.xpath("//label[text()='First Name*']/following-sibling::input");
	private static By INPUT_LAST_NAME = By.xpath("//label[text()='Last Name*']/following-sibling::input");
	private static By INPUT_EMAIL = By.xpath("//label[text()='Email*']/following-sibling::input");
	private static By INPUT_PHONE = By.xpath("//label[text()='Phone']/following-sibling::input");
	private static By DROPDOWN_COUNTRY = By.xpath("//label[text()='Country*']/following-sibling::select");
	private static By INPUT_MESSAGE = By.xpath("//label[text()='Message*']/following-sibling::textarea");
	private static By CHECKBOX_AGREE = By.xpath("//input[@value='I agree']");
	private static By BUTTON_SUBMIT = By.xpath("//img[@alt='Submit']");
	private static By TEST_SUCCESS_MESSAGE = By.xpath("//div[@class='Form__Status__Message Form__Success__Message']");
	
	HelperFunctions helperFunctions;
	
	public String fetchPageTitle() {
		return getDriver().getTitle();
	}
	
	public boolean checkPageTextDisplayed(String pageText) {
		return $(By.xpath(TEXT_AUTOMATION + pageText + "']")).isEnabled();
	}
	
	public void inputFirstName(String firstName) {
		$(INPUT_FIRST_NAME).sendKeys(firstName);
	}
	
	public void inputLastName(String lastName) {
		$(INPUT_LAST_NAME).sendKeys(lastName);
	}
	
	public void inputEmail(String email) {
		$(INPUT_EMAIL).sendKeys(email);
	}
	
	public void inputPhone(String phone) {
		$(INPUT_PHONE).sendKeys(phone);
	}
	
	public void selectCountry(String country) {
		$(DROPDOWN_COUNTRY).selectByValue(country);
	}
	
	public void inputMessage(String message) {
		$(INPUT_MESSAGE).sendKeys(message);
	}
	
	public void selectCheckBoxAgree() {
		$(CHECKBOX_AGREE).click();
	}
	
	public void selectCheckBoxCaptcha() {
		System.out.println("***************************inside captcha");
		helperFunctions.handleReCaptcha();
		
	}
	
	public void submitForm() {
		System.out.println("***************************inside submit");
		$(BUTTON_SUBMIT).submit();
	}
	
	public boolean checkSuccessMessage() {
		return $(TEST_SUCCESS_MESSAGE).isDisplayed();
	}
}
