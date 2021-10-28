package com.ss.ita.greencity.ui.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.greencity.ui.locators.BaseLocator;


public class Span extends BaseWebElement {

	public Span(WebDriver driver, BaseLocator locator) {
		super(driver, locator);
		
	}
	
	public String getText() {
		return this.webElement.getText();
		
	}
	

	

}
