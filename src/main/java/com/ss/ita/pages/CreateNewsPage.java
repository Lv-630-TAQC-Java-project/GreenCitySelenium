package com.ss.ita.pages;

import com.ss.ita.elements.Button;
import com.ss.ita.elements.Link;
import org.openqa.selenium.WebDriver;

import com.ss.ita.elements.TextArea;
import static com.ss.ita.locators.CreateNewsPageLocators.*;

public class CreateNewsPage extends BasePage {

	public CreateNewsPage(WebDriver driver) {
		super(driver);
	
	}
	private TextArea content;
	private TextArea title_area;
	private Button news_button;
	private Button ads_button;
	private Button events_button;
	private Button initiatives_button;
	private Button education_button;
	private Button publish_button;
	
	public TextArea getTextArea() {
		if(content == null) {
			content = new TextArea(driver, CONTENT_TEXT_AREA);
		}
	
		return content;
	}

	public TextArea setContentArea() {
		getTextArea().sendKeysTextArea("Description for test Create News");
		return new TextArea(driver, CONTENT_TEXT_AREA);
	}

	public TextArea getTitle_area() {
		if(title_area == null) {
			title_area = new TextArea(driver, TITLE_TEXT_AREA);
		}
		return title_area;
	}

	public TextArea setTitleTextArea() {
		getTitle_area().sendKeysTextArea("Test News");
		return new TextArea(driver,TITLE_TEXT_AREA);
	}

	public Button getTag_News_button() {
		if(news_button == null) {
			news_button = new Button(driver, NEWS_TAG_BUTTON);
		}
		return news_button;
	}

	public CreateNewsPage clickTagNewsButton() {
		getTag_News_button().clickButton();
		return new CreateNewsPage(driver);
	}

	public Button getTag_Ads_button() {
		if(ads_button == null) {
			ads_button = new Button(driver, ADS_TAG_BUTTON);
		}
		return ads_button;
	}

	public CreateNewsPage clickTagAdsButton() {
		getTag_Ads_button().clickButton();
		return new CreateNewsPage(driver);
	}

	public Button getTag_Events_button() {
		if(events_button == null) {
			events_button = new Button(driver, EVENTS_TAG_BUTTON);
		}
		return events_button;
	}

	public CreateNewsPage clickTagEventsButton() {
		getTag_Events_button().clickButton();
		return new CreateNewsPage(driver);
	}

	public Button getTag_Initiatives_button() {
		if(initiatives_button == null) {
			initiatives_button = new Button(driver, INITIATIVES_TAG_BUTTON);
		}
		return initiatives_button;
	}

	public CreateNewsPage clickTagInitiativesButton() {
		getTag_Initiatives_button().clickButton();
		return new CreateNewsPage(driver);
	}

	public Button getTag_Education_button() {
		if(education_button == null) {
			education_button = new Button(driver, EDUCATION_TAG_BUTTON);
		}
		return education_button;
	}

	public CreateNewsPage clickTagEducationButton() {
		getTag_Education_button().clickButton();
		return new CreateNewsPage(driver);
	}

	public Button getPublishButton(){
		if(publish_button == null) {
			publish_button = new Button(driver, PUBLISH_BUTTON);
		}
		return publish_button;
	}

	public CreateNewsPage clickPublishButton() {
		getPublishButton().clickButton();
		return new CreateNewsPage(driver);
	}


	public  CreateNewsPage setTextArea() { 
		return this;
	}
}
