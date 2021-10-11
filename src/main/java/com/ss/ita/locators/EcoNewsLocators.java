package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum EcoNewsLocators implements BaseLocator {
    ECO_NEWS_MAIN_HEADER(By.cssSelector("#main-content > div > div:nth-child(1) > div > h1")),
    TEST_NEWS_TITLE(By.xpath("(//h3[contains(text(),'Test News')])[1]")),
    CREATE_NEWS_BUTTON(By.id("create-button"));

    private final By path;

    EcoNewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
