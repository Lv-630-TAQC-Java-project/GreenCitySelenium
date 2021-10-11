package com.ss.ita.data;

public enum UserSignInData {
	TARAS_KRASITSKYI("email_registration@ukr.net", "Password_2021");

	private String email;
	private String password;

	UserSignInData(String email, String password) {
		this.email = email;
		this.password = password;
		
	}
	public String getEmail() {
		return this.email;
	}
	public String getPassword() {
		return this.password;
	}

}
