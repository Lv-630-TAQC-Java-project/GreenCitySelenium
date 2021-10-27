package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum CreateNewsPageLocators implements BaseLocator {
    CONTENT_TEXT_AREA(By.name("main-area")),
    TEXT_AREA_DESCRIPTION(By.cssSelector("p.textarea-description")),
    TITLE_TEXT_AREA(By.xpath("//textarea[@placeholder='e.g. Coffee takeaway with 20% discount']")),
    NEWS_TAG_BUTTON(By.xpath("//button[normalize-space()='News']")),
    SELECTED_NEWS_TAG_BUTTON(By.xpath("//button[contains (@class, 'tag-news filters-color') and (text()=' News ')]")),
    ADS_TAG_BUTTON(By.xpath("//button[normalize-space()='Ads']")),
    EVENTS_TAG_BUTTON(By.xpath("//button[normalize-space()='Events']")),
    INITIATIVES_TAG_BUTTON(By.xpath("//button[normalize-space()='Initiatives']")),
    EDUCATION_TAG_BUTTON(By.xpath("//button[normalize-space()='Education']")),
    SOURCE_AREA(By.xpath("//input[@placeholder='link to external source']")),
    CONTENT_AREA(By.name("main-area")),
    PUBLISH_BUTTON(By.cssSelector("button.submit")),
    CREATE_BUTTON(By.id("create-button")),
    CREATE_NEWS_BUTTON(By.id("create-button-text")),
    TITLE_AREA(By.xpath("//textarea[@placeholder='e.g. Coffee takeaway with 20% discount']")),
    NEWS_BUTTON(By.xpath("//button[normalize-space()='News']")),
    ADS_BUTTON(By.xpath("//button[normalize-space()='Ads']")),
    EVENTS_BUTTON(By.xpath("//button[normalize-space()='Events']")),
    INITIATIVES_BUTTON(By.xpath("//button[normalize-space()='Initiatives']")),
    EDUCATION_BUTTON(By.xpath("//button[normalize-space()='Education']")),
    PREVIEW_BUTTON(By.xpath("//button[@class='preview']")),
    PREVIEW_CREATE_BUTTON(By.cssSelector("button[type='submit']"));


    private final By path;

    CreateNewsPageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
