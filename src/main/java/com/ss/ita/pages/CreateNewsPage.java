package com.ss.ita.pages;

import org.openqa.selenium.WebDriver;

import com.ss.ita.elements.TextArea;
import static com.ss.ita.locators.CreateNewsPageLocators.*;

public class CreateNewsPage extends BasePage {

	public CreateNewsPage(WebDriver driver) {
		super(driver);
	
	}
	private TextArea content;
	
	public TextArea getTextArea() {
		if(content == null) {
			content = new TextArea(driver, CONTENT_TEXT_AREA);
		}
	
		return content;
	}
	
	public  CreateNewsPage setTextArea() { // public  TextArea setTextArea()???
		return this;
	}

}
