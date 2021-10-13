package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ss.ita.greencity.ui.locators.CreateNewsPageLocators;
import static com.ss.ita.greencity.ui.locators.EcoNewsLocators.*;

public class EcoNewsPage extends BasePage {

	private Label mainHeader;
	private Label createdNewsTitle;
	private Button createNewsButton;
	private Button filterByNews;
	private Label newsTitle;
	private Button newsButton;

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
			createNewsButton = new Button(driver, CREATE_NEWS_BUTTON);

		}
		return createNewsButton;
	}

	public CreateNewsPage clickCreateNewsButton() {
		WebElement createNewsButton = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(CreateNewsPageLocators.CREATE_BUTTON.getPath()));
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

	public Label getNewsTitle() {
		if (newsTitle == null) {
			newsTitle = new Label(driver, TEST_NEWS_TITLE);
		}

		return newsTitle;
	}

	public Button getNewsButton(){
		if(newsButton == null){
			newsButton = new Button(driver,TEST_NEWS_TITLE);
		}

		return newsButton;
	}

	public NewsPage clickNewsButton(){
		getNewsButton().clickButton();
		return new NewsPage(driver);
	}

	public Button getFffNewsButton(){
		if(newsButton == null){
			newsButton = new Button(driver,FFFFFFFFFF_NEWS_TITLE);
		}

		return newsButton;
	}

	public NewsPage clickFffNewsButton(){
		getFffNewsButton().clickButton();
		return new NewsPage(driver);
	}
}