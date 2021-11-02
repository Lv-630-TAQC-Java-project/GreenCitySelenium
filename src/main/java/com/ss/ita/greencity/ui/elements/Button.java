package com.ss.ita.greencity.ui.elements;

import com.ss.ita.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class Button extends BaseWebElement {

    public Button(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public Button(WebDriver driver, WebElement element, BaseLocator locator) {
        super(driver, element, locator);
    }

    public void clickButton() {
        this.webElement.click();
    }

    public boolean isEnabled() {
        return this.webElement.isEnabled();
    }

    public String getBackgroundHexColor() {
        String color = this.webElement.getCssValue("background-color");
        return Color.fromString(color).asHex();
    }

    public String getText() {
        return this.webElement.getText();
    }

}
