package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.ss.ita.greencity.ui.locators.NewsLocators.*;

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    private TextArea commentInput;

    public int CommentNumber() {

        int count = driver.findElements(By.xpath("//p[contains(@class,'comment-text')]")).size();
        return count;
    }

    public NewsPage clickCommentButton() {
        driver.findElement(COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public String getFirstCommentText() {
        return driver.findElement(FIRST_COMMENT_TEXT.getPath()).getText();
    }

    public TextArea getCommentInput(){
        if(commentInput==null){
            commentInput=new TextArea(driver,COMMENT_TEXT_AREA);
        }
        return commentInput;
    }
    public NewsPage setComment(String comment) {
        getCommentInput().sendKeysTextArea(comment);
        return this;
    }

    public NewsPage clickComment() {
        driver.findElement(COMMENT_BUTTON.getPath()).click();
        return this;
    }

    public String getCommentsCount() {
        return driver.findElement(COMMENTS_COUNT_LABEL.getPath()).getAttribute("textContent");
    }

    public List<WebElement> getComments(){
        return driver.findElements(COMMENTS_LIST.getPath());
    }

}