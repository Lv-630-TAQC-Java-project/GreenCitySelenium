package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum NewsLocators implements BaseLocator {
    COMMENT_TEXT_AREA(By.xpath("//textarea[@formcontrolname='content']")),
    COMMENT_BUTTON(By.xpath("//button[@class='primary-global-button']")),
    COMMENTS_COUNT_LABEL(By.xpath(".//app-comments-container//p[2]")), ///text()[normalize-space()][1]
    COMMENTS_LIST(By.xpath(".//app-comments-list"));


    private final By path;

    NewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}