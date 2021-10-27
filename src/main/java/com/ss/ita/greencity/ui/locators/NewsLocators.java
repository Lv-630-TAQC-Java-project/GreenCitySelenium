package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum NewsLocators implements BaseLocator {
    COMMENT_TEXT_AREA(By.xpath("//textarea")),
    COMMENT_BUTTON(By.xpath("//button[@class='primary-global-button']")),
    COMMENT_TEXT(By.xpath("//p[contains(@class,'comment-text')]")),
    COMMENTS_COUNT_LABEL(By.xpath(".//app-comments-container//p[2]")), ///text()[normalize-space()][1]
    COMMENTS_LIST(By.xpath(".//app-comments-list/div"));

    private final By path;

    NewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}