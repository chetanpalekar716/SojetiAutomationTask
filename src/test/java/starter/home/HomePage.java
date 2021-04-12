package starter.home;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;


public class HomePage extends PageObject{
	
	public static By BUTTON_ALLOW_ALL_COOKIES = By.xpath("//button[@class='acceptCookie']");
	public static String MENU_PREFIX = "//li[@data-levelname='level2']/div[@class='wrapper']/span[text()='";
	
	
	public void acceptCookies() {
		$(BUTTON_ALLOW_ALL_COOKIES).click();
	}
	
	public void hoverOver(String menuItem) {
		withAction().moveToElement($(By.xpath(MENU_PREFIX + menuItem + "']"))).perform();
		waitABit(10000);
	}
}
