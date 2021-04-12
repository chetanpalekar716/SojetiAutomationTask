package starter.restservices;

import starter.utilities.ConfigReader;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import net.serenitybdd.rest.SerenityRest;

public class ServiceApi {

	ConfigReader configReader = new ConfigReader();
	
	public void getURI() {
		SerenityRest.given().when().get(configReader.prop.getProperty("API_BASE_URI"));
	}
	
	public int getResponseStatus() {
		System.out.println("REPONSE CODE============> " + lastResponse().getStatusCode());
		return lastResponse().getStatusCode();
	}

	public String getContentType() {
		System.out.println("CONTENT TYPE============> " + lastResponse().contentType());
		return lastResponse().contentType();
	}

	public long getResponseTime() {
		System.out.println("RESPONSE TIME============> " + lastResponse().getTimeIn(TimeUnit.SECONDS));
		return lastResponse().getTimeIn(TimeUnit.SECONDS);
	}

	public ArrayList<String> getRegion() {
		ArrayList<String> region = new ArrayList<String>();
		System.out.println("COUNTRY============> " + lastResponse().then().extract().path("country"));
		region.add(lastResponse().then().extract().path("country"));
		System.out.println("STATE============> " + lastResponse().then().extract().path("state"));
		region.add(lastResponse().then().extract().path("state"));
		return region;
	}

	public ArrayList<String> getPlaceNameForPostCode(String postCode) {
		ArrayList<String> matched_places = new ArrayList<String>();
		System.out.println("============> " + lastResponse().asString());
		ArrayList<LinkedHashMap<String,String>> places = lastResponse().then().extract().path("places");	
		
		for(LinkedHashMap<String,String> place_details : places) {
			if(place_details.containsValue(postCode)) {
				System.out.println("MATCHED PLACE NAME============>" + place_details.get("place name"));
				matched_places.add(place_details.get("place name"));
			}
		}
		return matched_places;
	}
}
