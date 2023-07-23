package SpecBuilder;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import Serilization_Places.AddPlace;
import Serilization_Places.Location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Request_Response_SpecBuilder {
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
		// build common request using request specbuilder
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).log(LogDetail.BODY).build();
		// build common Response using Response specbuilder
		ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.BODY)
				.expectContentType(ContentType.JSON).build();
		// request Part
		RequestSpecification re = given().spec(req).body(addPlace);
		// response part
		Response response = re.when().post("/maps/api/place/add/json").then().spec(resp).extract().response();
		// printing the place ID
		System.out.println(response.jsonPath().getString("place_id"));
	}
}
