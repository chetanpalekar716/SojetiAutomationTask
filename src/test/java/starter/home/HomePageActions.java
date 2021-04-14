package starter.home;

import net.thucydides.core.annotations.Step;

public class HomePageActions {

	HomePage homePage;
	
	@Step("Launch the HomePage URL and Accept Cookies")
	public void launchHomePage() {
		homePage.open();
		homePage.acceptCookies();
	}
	
	@Step("Hover over '{0}' Menu")
	public void hoverMenu(String menuItem) {
		homePage.hoverOverMenu(menuItem);
	}
	
	@Step("Select '{0}' Sub-Menu")
	public void selectSubMenu(String subMenuItem) {
		homePage.selectSubMenu(subMenuItem);
	}
	
	@Step("Validate if '{0}' menu and '{1}' submenu are selected")
	public String validatePageStyle(String menuItem, String subMenuItem) {
		homePage.hoverOverMenu(menuItem);
		
		if(homePage.getMenuFontColor(menuItem).equals(homePage.getSubMenuFontColor(subMenuItem))) {
			return homePage.getMenuFontColor(menuItem);
		}
		else return null;
		
	}
}
