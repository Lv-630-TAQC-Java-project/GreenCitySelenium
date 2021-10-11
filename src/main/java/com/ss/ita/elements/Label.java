package com.ss.ita.elements;

import com.ss.ita.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class Label extends BaseWebElement {
    public Label(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public String getText() {
        return this.webElement.getText();
    }
    
}
