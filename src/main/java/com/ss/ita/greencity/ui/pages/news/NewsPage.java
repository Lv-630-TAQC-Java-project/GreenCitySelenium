package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.TextArea;
import com.ss.ita.greencity.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.greencity.ui.locators.NewsListCommentsLocators.*;
import static com.ss.ita.greencity.ui.locators.NewsLocators.*;

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    private TextArea commentInput;
    private TextArea replyInput;
    private NewsListComponent comments;

    public int NumbersOfComments() {

        int count = driver.findElements(By.xpath("//p[contains(@class,'comment-text')]")).size();
        return count;
    }

    public String getFirstCommentText() {
        return driver.findElement(FIRST_COMMENT_TEXT.getPath()).getText();
    }

    public NewsPage createAndPublicComment(String comentText){
        new NewsPage(driver)
                .setCommentText(comentText)
                .clickCommentButton();
        return this;
    }

    public TextArea getCommentInput(){
        if(commentInput==null){
            commentInput=new TextArea(driver,COMMENT_TEXT_AREA);
        }
        return commentInput;
    }

    public NewsPage setCommentText(String comment) {
        getCommentInput().sendKeysTextArea(comment);
        return this;
    }

    public NewsPage clickCommentButton() {
        driver.findElement(COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public String getCommentsCount() {
        return driver.findElement(COMMENTS_COUNT_LABEL.getPath()).getAttribute("textContent");
    }

    public TextArea getReplyInput(){
        if(replyInput==null){
            replyInput=new TextArea(driver,REPLY_TEXT_AREA);
        }
        return replyInput;
    }

    public NewsPage setReplyText(String replyText){
   getReplyInput().sendKeysTextArea(replyText);
        return this;
    }

    public NewsPage clickPublishReplyButton(){
        driver.findElement(PUBLISH_REPLY_BUTTON.getPath()).click();
        return this;
    }

    public NewsPage clickDeleteCommentButton(){
        driver.findElement(DELETE_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListComponent getComment() {
        if (comments == null) {
            comments = new NewsListComponent(driver);
        }
        return comments;
    }
}
