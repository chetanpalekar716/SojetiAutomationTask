package starter.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import net.serenitybdd.core.pages.PageObject;

public class HelperFunctions extends PageObject{

	public String getWebElementColor(By selector) {
		return Color.fromString(($(selector).getCssValue("color"))).asHex();
	}
}
