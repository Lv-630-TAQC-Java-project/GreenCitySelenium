package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.Label;
import com.ss.ita.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static com.ss.ita.greencity.ui.locators.NewsListCommentsLocators.*;

public class NewsListCommentComponent extends BasePage {

    private WebElement root;
    private Label content;

    public NewsListCommentComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public NewsListCommentComponent clickReplyButton(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(REPLY_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent createAndPublicReply(String replyText) {
        new NewsPage(driver)
                .setReplyText(replyText)
                .clickPublishReplyButton();
        return this;
    }

    public NewsListCommentComponent deleteComment(){
        clickDeleteCommentButton().clickApproveDeletingCommentButton();
        return this;
    }

    public NewsListCommentComponent clickDeleteCommentButton(){
        driver.findElement(DELETE_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent clickApproveDeletingCommentButton(){
        driver.findElement(APPROVE_DELETING_COMMENT_BUTTON.getPath()).click();
        return this;
    }
}
