package com.ss.ita.greencity.ui.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.greencity.ui.locators.BaseLocator;

public class Input extends BaseWebElement {

	public Input(WebDriver driver, BaseLocator locator) {
		super(driver, locator);
	}
	
	public void clickInput() {
		this.webElement.click();
	}
	
	public void clearInput() {
		this.webElement.clear();
	}
	
	public void sendKeys(String txt) {
		this.webElement.sendKeys(txt);
	}

}
