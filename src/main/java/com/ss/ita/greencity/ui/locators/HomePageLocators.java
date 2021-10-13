package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum HomePageLocators implements BaseLocator {
    HOME_PAGE_TITLE_UKR(By.xpath("//h1[text()='Новий спосіб виховати в собі корисні звички']"));

    private final By path;

    HomePageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
