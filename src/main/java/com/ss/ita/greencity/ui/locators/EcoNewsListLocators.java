package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum EcoNewsListLocators implements BaseLocator {

    ITEMS(By.cssSelector(".gallery-view-li-active")),
    TOTAL_ITEMS(By.cssSelector("div[class='main-wrapper'] app-remaining-count div h2")),
    LOADING_CIRCLE(By.cssSelector("mat-spinner[role='progressbar']"));


    private final By path;

    EcoNewsListLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
