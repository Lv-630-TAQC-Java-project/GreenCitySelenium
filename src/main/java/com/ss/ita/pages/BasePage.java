package com.ss.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public void waitVisibilityOfElement(long timeToWait, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Header getHeader() {
        return new Header(driver);
    }
    public LanguageBar getLanguageBar() {
        return new LanguageBar(driver);
    }
}
