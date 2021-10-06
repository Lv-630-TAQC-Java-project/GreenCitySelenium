package com.ss.ita.elements;

import com.ss.ita.locators.BaseLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Link extends BaseWebElement{
    public Link(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public void click() {
        this.webElement.click();
    }
}
