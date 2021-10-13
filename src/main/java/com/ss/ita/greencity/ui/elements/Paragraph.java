package com.ss.ita.greencity.ui.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.greencity.ui.locators.BaseLocator;

public class Paragraph extends BaseWebElement{

	public Paragraph(WebDriver driver, BaseLocator locator) {
		super(driver, locator);
		
	}
	
	public void clickParagraph() {
		this.webElement.click();
		
	}
	
	public String getColorTextParagraph() {
		return this.webElement.getCssValue("color");
	}

}
