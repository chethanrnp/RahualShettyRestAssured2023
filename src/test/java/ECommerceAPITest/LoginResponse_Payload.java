package ECommerceAPITest;

public class LoginResponse_Payload {

	private String token;
	private String userId;
	private String message;

	public LoginResponse_Payload() {

	}

	public LoginResponse_Payload(String token, String userId, String message) {
		this.token = token;
		this.userId = userId;
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
