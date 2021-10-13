package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.elements.Input;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.greencity.ui.locators.SignInLoacators.*;

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

    public SignInPage setEmail(String email) {
        getEmail().clickInput();
        getEmail().clearInput();
        getEmail().sendKeys(email);
        return this;
    }

    public Input getPassword() {
        if (password == null) {
            password = new Input(driver, PASSWORD);
        }

        return password;
    }

    public SignInPage setPassword(String pass) {
        getPassword().clickInput();
        getPassword().clearInput();
        getPassword().sendKeys(pass);
        return this;

    }

    public MySpacePage goToMySpacePage() {
        getSignInButton().clickButton();
        return new MySpacePage(driver);

    }

}
