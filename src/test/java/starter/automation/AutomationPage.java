package starter.automation;


import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class AutomationPage extends PageObject{
	
	private static String TEXT_AUTOMATION = "//h1/span[text()='";
	
	public String fetchPageTitle() {
		return getDriver().getTitle();
	}
	
	public boolean checkPageTextDisplayed(String pageText) {
		return $(By.xpath(TEXT_AUTOMATION + pageText + "']")).isEnabled();
	}
}
