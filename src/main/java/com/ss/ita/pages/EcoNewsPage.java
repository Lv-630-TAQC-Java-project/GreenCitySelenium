package com.ss.ita.pages;

import com.ss.ita.elements.Button;
import com.ss.ita.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.locators.EcoNewsLocators.*;

public class EcoNewsPage extends BasePage {

	private Label mainHeader;
	private Label createdNewsTitle;
	private Button createNewsButton;
	private Button filterByNews;

	public EcoNewsPage(WebDriver driver) {
		super(driver);
	}

	public Label getMainHeader() {
		if (mainHeader == null) {
			mainHeader = new Label(driver, ECO_NEWS_MAIN_HEADER);
		}
		return mainHeader;
	}

	public Label getCreatedNewsTitle(){
		if (createdNewsTitle == null) {
			createdNewsTitle = new Label(driver, TEST_NEWS_TITLE);
		}
		return createdNewsTitle;
	}

	public Button getCreateNewsButton() {
		if (createNewsButton == null) {
			createNewsButton = new Button(driver, CREATE_NEW_BUTTON);

		}
		return createNewsButton;
	}

	public CreateNewsPage clickCreateNewsButton() {
		WebElement createNewsButton = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("create-button")));
		getCreateNewsButton().clickButton();
		return new CreateNewsPage(driver);
	}

	public Button getFilterByNews(){
		if(filterByNews == null) {
			filterByNews = new Button(driver, FILTER_BY_NEWS);
		}
		return filterByNews;
	}
	public EcoNewsPage clickFilterByNews() {
		getFilterByNews().clickButton();
		return new EcoNewsPage(driver);
	}
}
