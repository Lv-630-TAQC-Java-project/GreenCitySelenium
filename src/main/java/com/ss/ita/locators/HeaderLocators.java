package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum HeaderLocators implements BaseLocator {
    ECO_NEWS_LINK(By.xpath("/html/body/app-root/app-main/app-header/header/div/div/div/nav/ul/li[1]/a")),
    LANGUAGE_SWITCHER(By.xpath("//*[@alt='language switcher']")),
    UKRAINE_LANGUAGE_BUTTON(By.xpath("//*[@aria-label='ukrainian']"));

    private final By path;

    HeaderLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
