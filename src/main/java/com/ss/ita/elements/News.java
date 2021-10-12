package com.ss.ita.elements;

import com.ss.ita.locators.BaseLocator;
import org.openqa.selenium.WebDriver;

public class News extends BaseWebElement{
    public News(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public String getNewsClass(){
        return this.webElement.getAttribute("class");
    }
}
