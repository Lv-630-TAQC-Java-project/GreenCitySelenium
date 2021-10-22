package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.elements.Input;
import com.ss.ita.greencity.ui.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ss.ita.greencity.ui.locators.SingleNewLocators.*;

public class SingleNewPage extends BasePage {
    public SingleNewPage(WebDriver driver) {
        super(driver);
    }

    private Input reply;
    private Button editCommentButton;
    private Button replyCommentButton;
    private Button acceptReply;
    private Label viewReplies;
    private Input editReplyHolder;
    private Button editReplyButton;
    private Button saveChangesButton;
    private Label editedReplyMessage;

    public Input getEditReplyHolder() {
        if (editReplyHolder == null) {
            editReplyHolder = new Input(driver, EDIT_REPLY_HOLDER);
        }
        return editReplyHolder;
    }

    public void clickOnEditReplyHolder(){
        getEditReplyHolder().clickInput();
    }

    public String getTextFromReply(){
        if(editedReplyMessage == null){
            editedReplyMessage = new Label(driver,EDITED_REPLY_MESSAGE);
        }
        return editedReplyMessage.getText();
    }
    public Button getReplyButton() {
        if (replyCommentButton == null) {
            replyCommentButton = new Button(driver, REPLY_BUTTON);
        }
        return replyCommentButton;
    }

    public Button getSaveChangesButton() {
        if (saveChangesButton == null) {
            saveChangesButton = new Button(driver, SAVE_CHANGES_BUTTON);
        }
        return saveChangesButton;
    }

    public void clickOnSaveChangesButton(){
        getSaveChangesButton().clickButton();
    }

    public Label getViewReplies() {
        if (viewReplies == null) {
            viewReplies = new Label(driver, VIEW_REPLIES);
        }
        return viewReplies;
    }

    public void clickOnGetViewReplies(){
        getViewReplies().click();
    }

    public Input getReplyHolder() {
        if (reply == null) {
            reply = new Input(driver, REPLY_HOLDER);
        }
        return reply;
    }

    public void clickOnGetReplyHolder(){
        getReplyHolder().clickInput();
    }

    public Button getApproveReplyButton() {
        if (acceptReply == null) {
            acceptReply = new Button(driver, ACCEPT_REPLY_HOLDER);
        }
        return acceptReply;
    }

    public void clickOnGetApproveReplyButton(){
        getApproveReplyButton().clickButton();
    }

    public Button getEditReplyButton() {
        if (editReplyButton == null) {
            editReplyButton = new Button(driver, EDIT_REPLY_BUTTON);
        }
        return editReplyButton;
    }
    public void clickOnEditReplyButton(){
            getEditReplyButton().clickButton();
    }

    public void clickOnReplyButton() {
        getReplyButton().clickButton();
    }

    public SingleNewPage setReply(String replyMessage) {
        clickOnGetViewReplies();
        clickOnReplyButton();
        clickOnGetReplyHolder();
        getReplyHolder().sendKeys(replyMessage);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//form[contains(@class,'ng-valid')]")));
        clickOnGetApproveReplyButton();
        return this;
    }

    public SingleNewPage editReply(String editMessage) {
        clickOnEditReplyButton();
        clickOnEditReplyHolder();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'wrapper-reply')]//textarea[contains(@class,'edit-text-input')]")));
        getEditReplyHolder()
                .sendKeys(editMessage);
        clickOnSaveChangesButton();

        return this;
    }
}