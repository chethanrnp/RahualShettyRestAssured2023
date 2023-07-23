package JsonComplexPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParser {

	@Test
	public void complexJson() {
		// converting string into json format
		JsonPath js = new JsonPath(new Payload().coursePrice());
		// print number of course
		int count = js.getInt("courses.size()");
		System.out.println("Number of course = " + count);
		// print purchase amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		// print the title of the first course
		String titleFirstCourse = js.getString("courses[0].title");
		System.out.println(titleFirstCourse);
		// print all course tile and respective prices
		for (int i = 0; i < count; i++) {
			String courseTitles = js.getString("courses[" + i + "].title");
			String coursePrices = js.getString("courses[" + i + "].price");
			System.out.println(courseTitles + "=" + coursePrices);
		}
		// number of copies sold by RPA
		for (int i = 0; i < count; i++) {
			String courseTitles = js.getString("courses[" + i + "].title");
			if (courseTitles.equals("RPA")) {
				System.out.println("Number of copies sold by RPA = " + js.getInt("courses[" + i + "].copies"));
				break;
			}
		}
		// verify sum of all cources prices matches with purchase amount
		int purchaseAmoun = js.getInt("dashboard.purchaseAmount");
		int cousreAmount = 0;
		for (int i = 0; i < count; i++) {
			cousreAmount = cousreAmount
					+ (js.getInt("courses[" + i + "].price") * js.getInt("courses[" + i + "].copies"));
		}
		// valiade using assert
		Assert.assertEquals(cousreAmount, purchaseAmoun);
	}
}
