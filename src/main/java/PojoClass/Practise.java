package PojoClass;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Practise {

	@Test
	public void practise() throws Throwable {
		Mobile mobile = new Mobile("Appium_Mobile Automation using Java", "50");
		Mobile[] mobil = { mobile };
		Api a1 = new Api("Rest Assured Automation using Java", "50");
		Api a2 = new Api("SoapUI Webservices teting", "40");
		Api[] api = { a1, a2 };

		WebAutomation w1 = new WebAutomation("Selenium Webdrier Java", "50");
		WebAutomation w2 = new WebAutomation("Cypress", "40");
		WebAutomation w3 = new WebAutomation("Protractor", "40");
		WebAutomation[] webAutomation = { w1, w2, w3 };
		Courses courses = new Courses(webAutomation, api, mobil);

		GetCourses getCourses = new GetCourses("RahulShetty", "rahulshettyacademy.com", "projectSSupport", "Automation",
				courses, "https://in.linkedin.com/");
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("2023.json"), getCourses);

	}
}
