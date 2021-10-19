package com.ss.ita.greencity.ui.pages;

import org.openqa.selenium.WebDriver;

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
}
