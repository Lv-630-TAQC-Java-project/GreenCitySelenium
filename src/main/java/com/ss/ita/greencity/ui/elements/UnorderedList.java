package com.ss.ita.greencity.ui.elements;

import org.openqa.selenium.WebDriver;
import com.ss.ita.greencity.ui.locators.BaseLocator;

public class UnorderedList extends BaseWebElement {

	public UnorderedList(WebDriver driver, BaseLocator locator) {
		super(driver, locator);
		
	}
	public void clickUnorderedList() {
		this.webElement.click();
	}

}
