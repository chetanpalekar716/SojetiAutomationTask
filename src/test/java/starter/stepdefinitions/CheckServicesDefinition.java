package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.ArrayList;

import starter.restservices.ServiceApi;


public class CheckServicesDefinition {

	@Steps
	ServiceApi serviceApi;
		
	@Given("an API Get Request is triggered")
	public void an_api_get_request_is_triggered() {
		serviceApi.getURI();
	}
	
	@Given("API service response code is {int}")
	public void api_service_response_code_is(int responseCode) {
		assertThat(serviceApi.getResponseStatus()).isEqualTo(responseCode);
	}

	@Given("content type is {string}")
	public void content_type_is(String contentType) {
		assertThat(serviceApi.getContentType()).containsIgnoringCase(contentType);
	}

	@Given("response time is less than {long} second")
	public void response_time_is_less_than_second(long responseTime) {
		assertThat(serviceApi.getResponseTime()).isLessThan(responseTime);
	}
	
	@Then("country is {string} state is {string}")
	public void country_is_state_is(String country, String state) {
	    ArrayList<String> region = new ArrayList<String>();
	    region.add(country);
	    region.add(state);
		assertThat(serviceApi.getRegion().containsAll(region)).isTrue();
	}

	@Then("for post code {string} the place name has {string}")
	public void for_post_code_the_place_name_has(String postCode, String placeName) {
		assertThat(serviceApi.getPlaceNameForPostCode(postCode)).contains(placeName);
	}
}
