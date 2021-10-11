package com.ss.ita.pages;

import com.ss.ita.elements.*;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.locators.EcoNewsLocators.*;

public class EcoNewsPage extends BasePage {

	private Label mainHeader;
	private Label newsTitle;
	private Button createNewsButton;

	public EcoNewsPage(WebDriver driver) {
		super(driver);
	}

	public Label getMainHeader() {
		if (mainHeader == null) {
			mainHeader = new Label(driver, ECO_NEWS_MAIN_HEADER);
		}
		return mainHeader;
	}

	public Label getNewsTitle() {
		if (newsTitle == null) {
			newsTitle = new Label(driver, TEST_NEWS_TITLE);
		}

		return newsTitle;
	}

	public Button getCreateNewsButton() {
		if (createNewsButton == null) {
			createNewsButton = new Button(driver, CREATE_NEW_BUTTON);

		}
		return createNewsButton;
	}

	public CreateNewsPage clickCreateNewsButton() {
		getCreateNewsButton().clickButton();
		return new CreateNewsPage(driver);
	}
}