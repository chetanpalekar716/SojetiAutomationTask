package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.home.HomePageActions;

public class HomePageDefinitions {
	
	@Steps
	HomePageActions homePageActions;
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		homePageActions.launchHomePage();
	}
	
	@When("User hovers on {string} menu")
	public void user_hovers_on_menu(String menuItem) {
		homePageActions.hoverMenu(menuItem);
	}

	@When("selects {string} submenu")
	public void selects_submenu(String subMenuItem) {
	    homePageActions.selectSubMenu(subMenuItem);
	}
}
