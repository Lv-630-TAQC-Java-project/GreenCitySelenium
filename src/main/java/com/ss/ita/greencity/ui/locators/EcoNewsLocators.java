package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum EcoNewsLocators implements BaseLocator {
    ECO_NEWS_MAIN_HEADER(By.cssSelector("#main-content > div > div:nth-child(1) > div > h1")),
    CREATE_NEW_BUTTON(By.id("create-button")),
    TEST_NEWS_TITLE(By.xpath("(//h3[contains(text(),'Test News')])[1]")),
    FILTER_BY_NEWS(By.xpath(("//a[normalize-space()='News']")));
    CREATE_NEW_BUTTON(By.id("create-button")),
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
