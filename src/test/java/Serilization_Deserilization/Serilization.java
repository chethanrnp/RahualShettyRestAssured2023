package Serilization_Deserilization;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.Api;
import PojoClass.Courses;
import PojoClass.GetCourses;
import PojoClass.Mobile;
import PojoClass.WebAutomation;

public class Serilization {

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
