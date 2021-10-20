package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum EcoNewsListLocators implements BaseLocator {
    ITEMS(By.xpath("//*[@id='main-content']/div/div[4]/ul/*")),
    NEWS_LIST_VIEW(By.cssSelector("#main-content > div > div.list-wrapper > ul > li:nth-child(1) > app-news-list-list-view > div > div"));


    private final By path;

    EcoNewsListLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
