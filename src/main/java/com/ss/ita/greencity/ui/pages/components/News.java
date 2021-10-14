package com.ss.ita.greencity.ui.pages.components;

import com.ss.ita.greencity.ui.elements.BaseWebElement;
import com.ss.ita.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class News extends BaseWebElement {
    public News(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public String getNewsClass() {
        return this.webElement.getAttribute("class");
    }
}
