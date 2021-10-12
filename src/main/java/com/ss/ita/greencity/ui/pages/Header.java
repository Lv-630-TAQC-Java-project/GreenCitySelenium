package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Link;

import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.elements.LanguageSwitcher;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static com.ss.ita.greencity.ui.locators.HeaderLocators. ECO_NEWS_LINK;
import static com.ss.ita.greencity.ui.locators.HeaderLocators.LANGUAGE_SWITCHER;
import static com.ss.ita.greencity.ui.locators.HeaderLocators.LANGUAGE_SWITCHER_EN;
import static com.ss.ita.greencity.ui.locators.HeaderLocators.SIGN_IN_BUTTON;


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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		return new SignInPage(driver);

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

		return new MySpacePage(driver); 

	}

}
