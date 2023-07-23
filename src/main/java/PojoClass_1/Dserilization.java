package PojoClass_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.GetCourses;

public class Dserilization {

	@Test
	public void dSerilization() throws Throwable {
		String[] expexted = { "Selenium Webdrier Java", "Cypress", "Protractor" };
		// Creating the object of ObjectMapper
		ObjectMapper obj = new ObjectMapper();
		// Converting JSON file to javaObject
		PojoClass_1.GetCourses ob = obj.readValue(new File(System.getProperty("user.dir") + "\\2024.json"),
				PojoClass_1.GetCourses.class);
		// getting the price of the SOUP UI
		List<Api> api = ob.getCourses().getApi();
		for (Api lv : api) {
			if (lv.getCourseTitle().equals("SoapUI Webservices teting")) {
				System.out.println(lv.getPrice());
			}
		}
		// or
		System.out.println(ob.getCourses().getApi().get(1).getPrice());
		// creating new ArrayList to store all webAutomation course title
		ArrayList<String> a = new ArrayList<String>();
		// print all course title of webAutomation
		List<WebAutomation> webAutomation = ob.getCourses().getWebAutomation();
		for (WebAutomation lv : webAutomation) {
			System.out.println(lv.getCourseTitle());
			a.add(lv.getCourseTitle());
		}
		// converting array to array List
		List<String> expectedTiele = Arrays.asList(expexted);
		// validating using Assert
		Assert.assertTrue(a.equals(expectedTiele));
	}
}
