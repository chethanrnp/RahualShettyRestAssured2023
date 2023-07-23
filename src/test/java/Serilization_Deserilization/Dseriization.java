package Serilization_Deserilization;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.GetCourses;

public class Dseriization {

	@Test
	public void dSerilization() throws Throwable {
		ObjectMapper obj = new ObjectMapper();
		GetCourses ob = obj.readValue(new File(System.getProperty("user.dir") + "\\2023.json"),
				PojoClass.GetCourses.class);
		System.out.println(ob.getCourses().getApi()[0]);

	}
}
