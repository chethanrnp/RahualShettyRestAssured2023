package Serilization_Deserilization;

import org.testng.annotations.Test;

import PojoClass.GetCourses;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JsonResonseToJavaObject {

	@Test
	public void jsonToJavaObject() {
		// converting JSON respone to java Object
		given().body(new File(System.getProperty("user.dir") + "\\2024.json")).contentType(ContentType.JSON).get()
				.then().log().all();
		// getting course title of mobile

	}
}
