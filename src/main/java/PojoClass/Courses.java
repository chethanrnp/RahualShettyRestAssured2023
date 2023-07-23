package PojoClass;

public class Courses {

	private Object[] webAutomation;
	private Object[] api;
	private Object[] mobile;

	public Courses() {

	}

	public Courses(Object[] webAutomation, Object[] api, Object[] mobile) {
		this.webAutomation = webAutomation;
		this.api = api;
		this.mobile = mobile;
	}

	public Object[] getWebAutomation() {
		return webAutomation;
	}

	public void setWebAutomation(Object[] webAutomation) {
		this.webAutomation = webAutomation;
	}

	public Object[] getApi() {
		return api;
	}

	public void setApi(Object[] api) {
		this.api = api;
	}

	public Object[] getMobile() {
		return mobile;
	}

	public void setMobile(Object[] mobile) {
		this.mobile = mobile;
	}

	
}
