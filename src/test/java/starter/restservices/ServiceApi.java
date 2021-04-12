package starter.restservices;

import net.serenitybdd.rest.SerenityRest;
import starter.utilities.ConfigReader;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

import java.util.concurrent.TimeUnit;

public class ServiceApi {

	ConfigReader configReader = new ConfigReader();
	
	public void getURI() {
		SerenityRest.given().when().get(configReader.prop.getProperty("API_BASE_URI"));
	}
	
	public int getResponseStatus() {
		System.out.println("REPONSE CODE++++++++++++++" + lastResponse().getStatusCode());
		return lastResponse().getStatusCode();
	}

	public String getContentType() {
		System.out.println("CONTENT TYPE++++++++++++++" + lastResponse().contentType());
		return lastResponse().contentType();
	}

	public long getResponseTime() {
		System.out.println("RESPONSE TIME+++++++++++++" + lastResponse().getTimeIn(TimeUnit.SECONDS));
		return lastResponse().getTimeIn(TimeUnit.SECONDS);
	}
	

}
