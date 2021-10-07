package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum HomePageLocators implements BaseLocator {
    HOME_PAGE_TITLE(By.xpath("//h1[text()='Новий спосіб виховати в собі корисні звички']"));

    private final By path;

    HomePageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
