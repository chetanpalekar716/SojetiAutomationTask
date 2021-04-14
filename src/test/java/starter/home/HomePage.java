package starter.home;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import starter.utilities.HelperFunctions;


public class HomePage extends PageObject{
	
	HelperFunctions helperFunctions;
	private static By BUTTON_ALLOW_ALL_COOKIES = By.xpath("//button[@class='acceptCookie']");
	private static String MENU_PREFIX = "//li[@data-levelname='level2']/div[@class='wrapper']/span[text()='";
	private static String LINK_SUBMENU_PREFIX = "//div[contains(@class,'mega-navbar refreshed')]//a[text()='";
	
	public void acceptCookies() {
		$(BUTTON_ALLOW_ALL_COOKIES).click();
	}
	
	public void hoverOverMenu(String menuItem) {
		withAction().moveToElement($(By.xpath(MENU_PREFIX + menuItem + "']"))).perform();
	}
	
	public void selectSubMenu(String subMenuItem) {
		$(By.xpath(LINK_SUBMENU_PREFIX + subMenuItem + "']")).click();
	}

	public String getMenuFontColor(String menuItem) {
		return helperFunctions.getWebElementColor(By.xpath(MENU_PREFIX + menuItem + "']"));
	}
	
	public String getSubMenuFontColor(String subMenuItem) {
		return helperFunctions.getWebElementColor(By.xpath(LINK_SUBMENU_PREFIX + subMenuItem + "']"));
	}
	
}
