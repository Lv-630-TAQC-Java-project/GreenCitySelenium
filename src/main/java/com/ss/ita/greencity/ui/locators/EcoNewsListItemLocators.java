package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum EcoNewsListItemLocators implements BaseLocator {

   // TITLE_LABEL(By.xpath("//div[1]/h3")),
	TITLE_LABEL(By.cssSelector("div.title-list.word-wrap")),
    CONTENT_LABEL(By.xpath("//div[2]/p"));


    private final By path;

    EcoNewsListItemLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
