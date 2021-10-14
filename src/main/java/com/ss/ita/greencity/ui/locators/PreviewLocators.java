package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum PreviewLocators implements BaseLocator {
    TITLE_FIELD(By.xpath("//div[@class='news-title word-wrap']")),
    SOURCE_FIELD(By.xpath("//div[@class='source-text word-wrap']")),
    CONTENT_FIELD(By.xpath("//div[@class='news-text-content word-wrap']"));

    private final By path;

    PreviewLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
