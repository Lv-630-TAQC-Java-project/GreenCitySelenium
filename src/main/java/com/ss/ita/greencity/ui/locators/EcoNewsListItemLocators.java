package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

import static java.lang.String.format;

public enum EcoNewsListItemLocators implements BaseLocator {

    TITLE_LABEL(By.xpath("//div[1]/h3")),
    CONTENT_LABEL(By.xpath("//div[2]/p"));


    private final By path;

    public String TITLE_OF_NEWS_TEMPLATE = "//h3[contains(text(),'%s')]";

    EcoNewsListItemLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
