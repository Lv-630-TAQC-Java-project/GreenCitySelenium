package com.ss.ita.pages;

import org.openqa.selenium.WebDriver;

import com.ss.ita.elements.Input;
import com.ss.ita.elements.Paragraph;
import com.ss.ita.elements.TextArea;
import static com.ss.ita.locators.CreateNewsPageLocators.*;

public class CreateNewsPage extends BasePage {

	public CreateNewsPage(WebDriver driver) {
		super(driver);
	
	}
	private TextArea content;
	private Paragraph textAreaDescription;
	
	public TextArea getTextArea() {
		if(content == null) {
			content = new TextArea(driver, CONTENT_TEXT_AREA);
		}
	
		return content;
	}
	
	public  CreateNewsPage setTextArea(String text) { 
		getTextArea().clicTextArea();
		getTextArea().clearTextArea();
		getTextArea().sendKeysTextArea(text);
		return this;
	}
		
	public Paragraph getParagraph() {
		if(textAreaDescription == null) {
			textAreaDescription = new Paragraph(driver,TEXT_AREA_DESCRIPTION);
		}
		
		return textAreaDescription;
		
	}
	public CreateNewsPage clickTextAreaDescription() {
		getParagraph().clickParagraph();
		return this;
	}

}
