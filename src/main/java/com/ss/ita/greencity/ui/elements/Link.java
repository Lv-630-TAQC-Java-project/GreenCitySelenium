package com.ss.ita.greencity.ui.elements;

import com.ss.ita.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class Link extends BaseWebElement {
    public Link(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public void click() {
        this.webElement.click();
    }
}
