package com.ss.ita.greencity.ui.elements;

import org.openqa.selenium.WebDriver;
import com.ss.ita.greencity.ui.locators.BaseLocator;

public class ListItem extends BaseWebElement {

	public ListItem(WebDriver driver, BaseLocator locator) {
		super(driver, locator);
		
	}
	
	public void clickListItem() {
		this.webElement.click();
	}

}
