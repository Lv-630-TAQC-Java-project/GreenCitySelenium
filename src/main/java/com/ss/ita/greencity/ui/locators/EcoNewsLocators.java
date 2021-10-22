package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum EcoNewsLocators  implements BaseLocator {
    ECO_NEWS_MAIN_HEADER(By.cssSelector("#main-content > div > div:nth-child(1) > div > h1")),
    TEST_NEWS_TITLE(By.xpath("(//h3[contains(text(),'Test News')])[1]")),
    FILTER_BY_NEWS(By.xpath(("//a[normalize-space()='News']"))),
    FILTER_BY_NEWS_TAG(By.xpath("//*[contains(@class, 'ul-eco-buttons') and (text()=' News ')]")),
    CHANGE_VIEW_BUTTON(By.cssSelector("#main-content > div > div.main-wrapper > app-change-view-button > div > span.btn-bars > em")),
    CREATE_NEWS_BUTTON(By.id("create-button")),
    SINGLE_NEW_BUTTON(By.xpath("//h3[text()=' 1634820793193 ']"));
    private final By path;

    EcoNewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
