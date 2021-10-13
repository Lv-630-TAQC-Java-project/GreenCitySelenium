package com.ss.ita.greencity.ui.elements;

import com.ss.ita.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class Label extends BaseWebElement {
    public Label(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public String getText() {
        return this.webElement.getText();
    }

    public void click() {
        this.webElement.click();
    }
}