package com.ss.ita.greencity.ui.pages;


import org.openqa.selenium.WebDriver;

import static com.ss.ita.greencity.ui.locators.NewsLocators.COMMENT_BUTTON;
import static com.ss.ita.greencity.ui.locators.NewsLocators.COMMENT_TEXT_AREA;

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public NewsPage setComment(String comment) {
        driver.findElement(COMMENT_TEXT_AREA.getPath()).sendKeys(comment);
        return this;
    }

    public NewsPage clickComment() {
        driver.findElement(COMMENT_BUTTON.getPath()).click();
        return this;
    }
}
