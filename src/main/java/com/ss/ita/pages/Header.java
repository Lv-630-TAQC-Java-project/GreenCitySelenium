package com.ss.ita.pages;

import com.ss.ita.elements.Link;

import com.ss.ita.elements.Button;
import com.ss.ita.elements.LanguageSwitcher;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import static com.ss.ita.locators.HeaderLocators. ECO_NEWS_LINK;
import static com.ss.ita.locators.HeaderLocators.LANGUAGE_SWITCHER;
import static com.ss.ita.locators.HeaderLocators.LANGUAGE_SWITCHER_EN;
import static com.ss.ita.locators.HeaderLocators.SIGN_IN_BUTTON;
import static com.ss.ita.data.UserSignInData.* ;

public class Header extends BasePage {

  private Link ecoNewsLink;
	private LanguageSwitcher lngSwitcher;
	private Button signInButton;

	public Header(WebDriver driver) {
		super(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public Link getEcoNewsLink() {
		if (ecoNewsLink == null) {
			ecoNewsLink = new Link(driver, ECO_NEWS_LINK);
		}
		return ecoNewsLink;
	}

	public EcoNewsPage clickEcoNewsLink() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getEcoNewsLink().click();
		return new EcoNewsPage(driver);
	}

	public LanguageSwitcher getLngSwitcher() {
		lngSwitcher = new LanguageSwitcher(driver, LANGUAGE_SWITCHER);
		return lngSwitcher;
	}

	public Header clickLanguageSwitcher() {
		getLngSwitcher().click();
		return new Header(driver);
	}

	public LanguageSwitcher getLngSwitcherEn() {
		lngSwitcher = new LanguageSwitcher(driver, LANGUAGE_SWITCHER_EN);
		return lngSwitcher;
	}

	public Header clickLanguageSwitcherEn() {
		getLngSwitcherEn().click();
		return new Header(driver);
	}

	public Button getSignInButton() {
		signInButton = new Button(driver, SIGN_IN_BUTTON);
		return signInButton;
	}

	public SignInPage goToSignPage() {
		getSignInButton().clickButton();
		return new SignInPage(driver);// what object must return??

	}
	
	
	public MySpacePage login(String email, String password) {
		getHeader()
		.clickLanguageSwitcher()
		.clickLanguageSwitcherEn()
		.goToSignPage()
		.setEmail(email)
		.setPassword(password)
		.goToMySpacePage();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // ONLY FOR PRESENTATION

		return new MySpacePage(driver); // or this???

	}

}
