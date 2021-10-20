package com.ss.ita.greencity.ui.pages.econews;


import com.ss.ita.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.greencity.ui.locators.NewsLocators.*;

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

    public String getCommentsCount() {
        return driver.findElement(COMMENTS_COUNT_LABEL.getPath()).getAttribute("textContent");
    }
}
