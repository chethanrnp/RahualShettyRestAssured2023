package PojoClass_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serilization {

	@Test
	public void serilization() throws Throwable {
		WebAutomation w1 = new WebAutomation("Selenium Webdrier Java", "50");
		WebAutomation w2 = new WebAutomation("Cypress", "40");
		WebAutomation w3 = new WebAutomation("Protractor", "40");
		ArrayList<WebAutomation> webAutomation = new ArrayList<WebAutomation>();
		webAutomation.add(w1);
		webAutomation.add(w2);
		webAutomation.add(w3);
		Api a1 = new Api("Rest Assured Automation using Java", "50");
		Api a2 = new Api("SoapUI Webservices teting", "40");
		ArrayList<Api> api = new ArrayList<Api>();
		api.add(a1);
		api.add(a2);
		Mobile m1 = new Mobile("Appium_Mobile Automation using Java", "50");
		ArrayList<Mobile> mobile = new ArrayList<Mobile>();
		mobile.add(m1);

		// Adding all the list to Courses
		Courses courses = new Courses(webAutomation, api, mobile);
		// creating object of getCourses
		GetCourses getCourses = new GetCourses("RahulShetty", "rahulshettyacademy.com", "projectSSupport", "Automation",
				courses, "https://in.linkedin.com/");
		// creating object of ObjectMapper
		ObjectMapper obj = new ObjectMapper();
		// creating JSON file using Object Mapper
		obj.writeValue(new File("2024.json"), getCourses);
	}
}
