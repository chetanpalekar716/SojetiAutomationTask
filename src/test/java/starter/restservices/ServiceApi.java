package starter.restservices;

import starter.utilities.ConfigReader;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;

public class ServiceApi {

	ConfigReader configReader = new ConfigReader();
	
	public void getURL(String endPoint) {
		RestAssured.baseURI = configReader.prop.getProperty("API_BASE_URI");
		RestAssured.basePath = endPoint;
		System.out.println("URL============> " + RestAssured.baseURI + RestAssured.basePath);
		SerenityRest.given().when().get();
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
		System.out.println("RESPONSE============> " + lastResponse().asString());
		ArrayList<LinkedHashMap<String,String>> places = lastResponse().then().extract().path("places");	
		
		for(LinkedHashMap<String,String> place_details : places) {
			if(place_details.containsValue(postCode)){
				System.out.println("MATCHED PLACE NAME============>" + place_details.get("place name"));
				matched_places.add(place_details.get("place name"));
			}
		}
		return matched_places;
	}

	public ArrayList<String> getPlaceName() {
		ArrayList<String> matched_places = new ArrayList<String>();
		System.out.println("RESPONSE============> " + lastResponse().asString());
		ArrayList<LinkedHashMap<String,String>> places = lastResponse().then().extract().path("places");	
		
		for(LinkedHashMap<String,String> place_details : places) {
			System.out.println("MATCHED PLACE NAME============>" + place_details.get("place name"));
			matched_places.add(place_details.get("place name"));
		}
		return matched_places;
	}
}
