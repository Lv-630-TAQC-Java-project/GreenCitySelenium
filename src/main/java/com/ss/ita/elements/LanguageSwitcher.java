package com.ss.ita.elements;

import org.openqa.selenium.WebDriver;

import com.ss.ita.locators.BaseLocator;

public class LanguageSwitcher extends BaseWebElement {
	public LanguageSwitcher(WebDriver driver, BaseLocator locator) {
		super(driver, locator);
	}

	public void click() {
		this.webElement.click();
	}
}
