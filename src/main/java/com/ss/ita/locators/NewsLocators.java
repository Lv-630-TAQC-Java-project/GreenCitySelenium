package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum NewsLocators implements BaseLocator {
    COMMENT_TEXT_AREA(By.name("content")),
    COMMENT_BUTTON(By.xpath("//button[@class='primary-global-button']"));

    private final By path;

    NewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}