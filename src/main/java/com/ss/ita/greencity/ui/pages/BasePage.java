package com.ss.ita.greencity.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected Header header;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public BasePage goToUrl(String url) {
        driver.get(url);
        return this;
    }

    public Header getHeader() {
        return new Header(driver);
    }

    public LanguageBar getLanguageBar() {
        return new LanguageBar(driver);
    }

    public boolean isClickable(WebElement webElement) {
        try {
            WebDriverWait element = new WebDriverWait(driver, 1);
            element.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public boolean isVisible(By webElement) {
        try {
            WebDriverWait element = new WebDriverWait(driver, 1);
            element.until(ExpectedConditions.visibilityOfElementLocated(webElement));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }
}
