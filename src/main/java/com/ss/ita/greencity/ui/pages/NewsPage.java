package com.ss.ita.greencity.ui.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.ss.ita.greencity.ui.locators.NewsLocators.*;

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public int CommentNumber(){

        int count = driver.findElements(By.xpath("//p[contains(@class,'comment-text')]")).size();
        return count;
    }

    public NewsPage setComment(String comment) {
        driver.findElement(COMMENT_TEXT_AREA.getPath()).sendKeys(comment);
        return this;
    }

    public NewsPage clickCommentButton() {
        driver.findElement(COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public String getFirstCommentText(){
        return driver.findElement(FIRST_COMMENT_TEXT.getPath()).getText();
    }
}
