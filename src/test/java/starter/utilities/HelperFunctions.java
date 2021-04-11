package starter.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import net.serenitybdd.core.pages.PageObject;

public class HelperFunctions extends PageObject{

	public String getWebElementColor(By selector) {
		return Color.fromString(($(selector).getCssValue("color"))).asHex();
	}
	
	public void scrollToElement(By selector) {
		withAction().moveToElement($(selector));
	}
	
	public void handleReCaptcha() {
		withAction().sendKeys(Keys.TAB).perform();
		withAction().sendKeys(Keys.ENTER).perform();
		waitABit(5000);
	}
	
	public String checkURL(WebElement element) {
		String response = null;	
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(element.getAttribute("href")).openConnection();
			connection.connect();
			response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println($(element).getAttribute("href") + "========>" + response);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}
