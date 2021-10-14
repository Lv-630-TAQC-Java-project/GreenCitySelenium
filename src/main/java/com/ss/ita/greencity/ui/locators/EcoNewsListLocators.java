package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum EcoNewsListLocators implements BaseLocator {

    ITEMS(By.cssSelector(".gallery-view-li-active"));


    private final By path;

    EcoNewsListLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
