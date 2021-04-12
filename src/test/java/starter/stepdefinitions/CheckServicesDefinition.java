package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import static org.assertj.core.api.Java6Assertions.assertThat;
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
}
