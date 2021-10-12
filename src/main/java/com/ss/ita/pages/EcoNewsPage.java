package com.ss.ita.pages;

import com.ss.ita.elements.Button;
import com.ss.ita.elements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.locators.EcoNewsLocators.*;

public class EcoNewsPage extends BasePage {

	private Label mainHeader;
	private Button createNewsButton;
	private Button changeViewButton;

	public EcoNewsPage(WebDriver driver) {
		super(driver);
	}

	public Label getMainHeader() {
		if (mainHeader == null) {
			mainHeader = new Label(driver, ECO_NEWS_MAIN_HEADER);
		}
		return mainHeader;
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


	public Button getChangeViewButton() {
		if (changeViewButton == null) {
			changeViewButton = new Button(driver, CHANGE_VIEW_BUTTON);

		}
		return changeViewButton;
	}

	public EcoNewsPage clickChangeViewButton() {
		getChangeViewButton().clickButton();
		return this;
	}
}
