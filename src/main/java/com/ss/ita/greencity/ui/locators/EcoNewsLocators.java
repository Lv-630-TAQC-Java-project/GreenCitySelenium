package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum EcoNewsLocators implements BaseLocator {
    ECO_NEWS_MAIN_HEADER(By.cssSelector("#main-content > div > div:nth-child(1) > div > h1")),
    TEST_NEWS_TITLE(By.xpath("(//h3[contains(text(),'Test News')][1]")),
    FFFFFFFFFF_NEWS_TITLE(By.xpath("//h3[contains(text(),' ffffffffffffffffff ')]")),
    CREATE_NEWS_BUTTON(By.id("create-button")),
    FILTER_BY_NEWS(By.xpath(("//a[normalize-space()='News']"))),
    CHANGE_VIEW_BUTTON(By.cssSelector("#main-content > div > div.main-wrapper > app-change-view-button > div > span.btn-bars > em")),
    NEWS_LIST_VIEW(By.cssSelector("#main-content > div > div.list-wrapper > ul > li:nth-child(1) > app-news-list-list-view > div > div"));

    private final By path;

    EcoNewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
