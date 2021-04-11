package starter.stepdefinitions;

import static org.assertj.core.api.Java6Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.home.HomePageActions;
import static starter.utilities.Constants.Colors.RED;
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
		
	@Then("the {string} menu along with {string} submenu are selected")
	public void the_menu_along_with_submenu_are_selected(String menuItem, String subMenuItem) {
		assertThat(homePageActions.validatePageStyle(menuItem, subMenuItem)).isEqualTo(RED);
	}
	
	@When("User tries to verify Worldwide Country specific Sogeti links")
	public void user_tries_to_verify_worldwide_country_specific_sogeti_links() {
		homePageActions.selectWorldWideLink();
	}

	@Then("all Worldwide Country specific Sogeti links are working")
	public void all_worldwide_country_specific_sogeti_links_are_working() {
		assertThat(homePageActions.verifyCountrySpecificLinks()).isTrue();
	}

}
