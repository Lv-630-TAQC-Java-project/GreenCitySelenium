package com.ss.ita.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.locators.BaseLocator;

public class Button extends BaseWebElement {

	public Button(WebDriver driver, BaseLocator locator) {
		super(driver, locator);

	}

	public void clickButton() {
		this.webElement.click();
	}

}
