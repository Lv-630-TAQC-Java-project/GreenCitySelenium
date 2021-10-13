package com.ss.ita.greencity.ui.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.greencity.ui.locators.BaseLocator;

public class Button extends BaseWebElement {

	public Button(WebDriver driver, BaseLocator locator) {
		super(driver, locator);

	}

	public void clickButton() {
		this.webElement.click();
	}

}
