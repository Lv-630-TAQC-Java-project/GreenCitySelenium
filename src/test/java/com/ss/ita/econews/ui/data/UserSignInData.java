package com.ss.ita.econews.ui.data;

public enum UserSignInData {
	TARAS_KRASITSKYI("email_registration@ukr.net", "Password_2021"),
	TEST_USER("greencity.test.user@gmail.com", "LeVq3ucLZRVPJuA!");

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
