package com.ss.ita.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.locators.BaseLocator;

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
