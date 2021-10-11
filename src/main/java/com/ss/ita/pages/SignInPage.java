package com.ss.ita.pages;

import org.openqa.selenium.WebDriver;

import com.ss.ita.elements.Button;
import com.ss.ita.elements.Input;


import static com.ss.ita.locators.SignInLoacators.SIGN_IN_BUTTON;
import static com.ss.ita.locators.SignInLoacators.EMAIL;
import static com.ss.ita.locators.SignInLoacators.PASSWORD;

public class SignInPage extends BasePage {
	private Button signInButton;
	private Input email;
	private Input password;

	public SignInPage(WebDriver driver) {
		super(driver);

	}

	public Button getSignInButton() {
		if (signInButton == null) {
			signInButton = new Button(driver, SIGN_IN_BUTTON);
		}
		return signInButton;
	}

	public Input getEmail() {
		if (email == null) {
			email = new Input(driver, EMAIL);
		}
		return email;
	}

	public Input getPassword() {
		if (password == null) {
			password = new Input(driver, PASSWORD);
		}
		
		return password;
	}

	public  SignInPage setEmail(String email) {
		getEmail().clickInput();
		getEmail().clearInput();
		getEmail().sendKeys(email);
		return this;
	}
	
	public  SignInPage setPassword(String pass) {
		getPassword().clickInput();
		getPassword().clickInput();
		getPassword().sendKeys(pass);
		return this;
		
	}
	
	public MySpacePage goToMySpacePage() {
			getSignInButton().clickButton();
			return new MySpacePage(driver);
		
	}

}
