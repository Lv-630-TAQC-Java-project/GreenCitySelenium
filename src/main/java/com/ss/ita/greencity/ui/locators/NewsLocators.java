package com.ss.ita.greencity.ui.locators;

import com.ss.ita.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum NewsLocators implements BaseLocator {
    COMMENT_TEXT_AREA(By.xpath("//textarea")),
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