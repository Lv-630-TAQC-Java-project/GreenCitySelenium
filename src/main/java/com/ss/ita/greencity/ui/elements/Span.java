package com.ss.ita.greencity.ui.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.WebElement;


public class Span extends BaseWebElement {

	public Span(WebDriver driver, BaseLocator locator) {
		super(driver, locator);
		
	}
	public Span(WebDriver driver, WebElement element, BaseLocator locator) {
		super(driver, element, locator);

	}
	
	public String getText() {
		return this.webElement.getText();
		
	}
	

	

}
