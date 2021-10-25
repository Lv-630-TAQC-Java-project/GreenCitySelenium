package com.ss.ita.greencity.ui.pages.news;

import com.ss.ita.greencity.ui.elements.*;
import com.ss.ita.greencity.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.greencity.ui.locators.NewsListCommentsLocators.*;
import static java.lang.String.format;

public class NewsListCommentComponent extends BasePage {

    private WebElement root;
    private Label content;
    private TextArea replyInput;
    private Button postReply;
    private TextArea editCommentField;

    public NewsListCommentComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public NewsListCommentComponent clearReplyTextArea() {
        getReplyInput().clickTextArea();
        getReplyInput().clearTextArea();
        return this;
    }

    public int numberOfReplies() {
        int count = driver.findElements(By.xpath("//div[contains(@class,'comment-body-wrapper wrapper-reply')]")).size();
        return count;
    }

    public NewsListCommentComponent clickViewReplyButton() {
        driver.findElement(VIEW_REPLY_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent clickReplyButton() {
        driver.findElement(REPLY_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent createAndPublicReply(String replyText) {
        new NewsListCommentComponent(driver, root)
                .setReplyText(replyText)
                .clickPublishReplyButton();
        return this;
    }

    public NewsListCommentComponent setReplyText(String replyText) {
        getReplyInput().clickTextArea();
        getReplyInput().sendKeysTextArea(replyText);
        return this;
    }

    public TextArea getReplyInput() {
        if (replyInput == null) {
            replyInput = new TextArea(driver, REPLY_TEXT_AREA);
        }
        return replyInput;
    }

    public NewsListCommentComponent clickPublishReplyButton() {
        driver.findElement(PUBLISH_REPLY_BUTTON.getPath()).click();
        return this;
    }

    public NewsPage deleteFirstComment() {
        clickDeleteCommentButton().clickApproveDeletingCommentButton();
        driver.navigate().refresh();
        return new NewsPage(driver);
    }

    public NewsListCommentComponent clickDeleteCommentButton() {
        driver.findElement(DELETE_FIRST_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public NewsListCommentComponent clickApproveDeletingCommentButton() {
        driver.findElement(APPROVE_DELETING_COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public Button getPublishReplyButton() {
        if (postReply == null){
            postReply = new Button(driver, PUBLISH_REPLY_BUTTON);
        }
        return postReply;
    }

    // Edit methods

    public NewsListCommentComponent clickEditComment() {
        new Button(driver, EDIT_COMMENT_BUTTON).clickButton();
        editCommentField = new TextArea(driver, EDIT_COMMENT_FIELD);
        return this;
    }

    public NewsListCommentComponent setEditFieldText(String text) {
        if (editCommentField == null) clickEditComment();

        editCommentField.sendKeysTextArea(text);
        return this;
    }

    public NewsListCommentComponent clickSaveChangesButton() {
        new Button(driver, EDIT_SAVE_COMMENT_BUTTON).clickButton();
        return this;
    }

    // general method
    public NewsListCommentComponent editComment(String newText) {
        return clickEditComment()
                .setEditFieldText(newText)
                .clickSaveChangesButton();
    }
}
