package com.ss.ita.locators;

import org.openqa.selenium.By;

public enum HeaderLocators implements BaseLocator {
    ECO_NEWS_LINK(By.xpath("//a[text()=' Eco news ']")),
    SIGN_IN(By.xpath("//a[normalize-space()='Sign in']")),
    EMAIL(By.id("email")),
    PASSWORD(By.id("password")),
    SIGN_IN_IN_WINDOW(By.xpath("//button[@type='submit']")),
    LANGUAGE_SWITCHER(By.xpath("//*[@alt='language switcher']")),
    UKRAINE_LANGUAGE_BUTTON(By.xpath("//*[@aria-label='ukrainian']")),
    LANGUAGE_SWITCHER_EN(By.cssSelector("li[aria-label=english]")),
    SIGN_IN_BUTTON(By.cssSelector("a.header_sign-in-link.tertiary-global-button"));

    HeaderLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
