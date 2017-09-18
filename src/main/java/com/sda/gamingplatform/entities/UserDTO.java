package com.sda.gamingplatform.entities;


//TODO finish here
public class UserDTO {

	private String username;
	private String userEmail;
	private String password;
	private String confirmPassword;

	public UserDTO() {	}

	public UserDTO(String username, String userEmail, String password, String confirmPassword) {
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.confirmPassword = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = password;
	}
}
