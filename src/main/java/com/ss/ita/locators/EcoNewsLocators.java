package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum EcoNewsLocators implements BaseLocator {
    ECO_NEWS_MAIN_HEADER(By.cssSelector("#main-content > div > div:nth-child(1) > div > h1"));


    private final By path;

    EcoNewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
