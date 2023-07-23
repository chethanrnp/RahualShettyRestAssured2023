package ECommerceAPITest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Practise {

	@Test
	public void practise() {
		// creating the request specbuilder
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).log(LogDetail.BODY).build();
		// creating login Request object
		LoginRequest_Payload login = new LoginRequest_Payload("chethan.supernova@gmail.com", "Chethan@17");
		// creating login request and fetching loginID and Token
		RequestSpecification reqLogin = given().spec(req).body(login);
		LoginResponse_Payload loginResponse = reqLogin.post("/api/ecom/auth/login").then().log().all().extract()
				.response().as(LoginResponse_Payload.class);
        System.out.println(loginResponse.getToken());
        
	}

}
