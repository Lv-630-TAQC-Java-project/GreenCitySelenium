package com.ss.ita.greencity.ui.elements;

import com.ss.ita.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class ImageArea extends BaseWebElement {

    public ImageArea(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public String getBackgroundColour() {
        return this.webElement.getCssValue("background-color");
    }
}
