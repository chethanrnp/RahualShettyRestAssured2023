package CRUD_Operation_Library;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Random;

public class Create_Book {

	@Test(dataProvider = "getData")
	public void addBook(String isbn, String aisle) {

		Random r = new Random();
		int rand = r.nextInt(1000);
		String num = Integer.toString(rand);
		baseURI = "http://216.10.245.166";
		// adding book to library
		String resp = given().body(new Payload().addBook(isbn, aisle)).contentType(ContentType.JSON).log().all().when()
				.post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();
		// converting string to json
		JsonPath js = new JsonPath(resp);
		// gets the id of the respnse
		String id = js.get("ID");

		// delete the book and verify the response
		given().body("{\r\n" + " \r\n" + "\"ID\" : \"" + id + "\"\r\n" + " \r\n" + "} \r\n" + "")
				.contentType(ContentType.JSON).when().post("/Library/DeleteBook.php").then().log().all()
				.body("msg", equalTo("book is successfully deleted"));
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "CBZ", "137" }, { "CBZ", "46" }, { "CBZ", "79" } };
	}
}
