package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum NewsListLocators implements BaseLocator {
    COMMENTS(By.xpath("//*[@id='main-content']/descendant::app-comments-list/*"));


    private final By path;

    NewsListLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}