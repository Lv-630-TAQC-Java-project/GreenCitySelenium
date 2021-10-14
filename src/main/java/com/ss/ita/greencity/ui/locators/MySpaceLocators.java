package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum MySpaceLocators implements BaseLocator {
    HOME_PAGE_LINK(By.cssSelector("img.logo"));

    private final By path;

    MySpaceLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
