package PojoClass;

public class GetCourses {

	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private Courses courses;
	private String linkedin;

	public GetCourses() {

	}

	public GetCourses(String instructor, String url, String services, String expertise, Courses courses,
			String linkedin) {
		this.instructor = instructor;
		this.url = url;
		this.services = services;
		this.expertise = expertise;
		this.courses = courses;
		this.linkedin = linkedin;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

}
