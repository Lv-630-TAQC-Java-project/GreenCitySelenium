package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.elements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.greencity.ui.locators.EcoNewsLocators.*;

public class EcoNewsPage extends BasePage {

	private Label mainHeader;
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
