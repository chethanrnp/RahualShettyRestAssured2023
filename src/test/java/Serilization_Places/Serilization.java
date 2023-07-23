package Serilization_Places;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class Serilization {

	@Test
	public void srilization() {
		// creating object of Location
		Location location = new Location(-38.383494, 33.427362);
		// creating array list
		ArrayList<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		// creating object of Add Place
		AddPlace addPlace = new AddPlace(location, 50, "Frontline house", "(+91) 983 893 3937",
				"29, side layout, cohen 09", types, "http://google.com", "French-IN");

		baseURI = "https://rahulshettyacademy.com";
		Response resp = given().queryParam("key", "qaclick123").body(addPlace).contentType(ContentType.JSON).when()
				.log().all().post("/maps/api/place/add/json").then().assertThat().statusCode(200).log().all().extract()
				.response();
		// printing the place ID
		System.out.println(resp.jsonPath().getString("place_id"));
	}
}
