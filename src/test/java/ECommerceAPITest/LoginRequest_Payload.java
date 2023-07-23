package ECommerceAPITest;

public class LoginRequest_Payload {

	private String userEmail;
	private String userPassword;

	// creating empty construcor
	public LoginRequest_Payload() {

	}

	public LoginRequest_Payload(String userEmail, String userPassword) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
