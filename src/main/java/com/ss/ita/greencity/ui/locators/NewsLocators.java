package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum NewsLocators implements BaseLocator {
    COMMENT_TEXT_AREA(By.xpath("//textarea")),
    COMMENT_BUTTON(By.xpath("//button[@class='primary-global-button']")),
    COMMENT_TEXT(By.xpath("//p[contains(@class,'comment-text')]")),
    COMMENTS_COUNT_LABEL(By.xpath(".//app-comments-container//p[2]")), ///text()[normalize-space()][1]
    COMMENTS_LIST(By.xpath(".//app-comments-list/div")),
    FIRST_COMMENT_TEXT(By.xpath("//p[contains(@class,'comment-text')][1]")),
    REPLY_BUTTON(By.xpath("//span[text()=' Reply ']")),
    REPLY_HOLDER(By.xpath("//textarea[@placeholder='Add a reply']")),
    ACCEPT_REPLY_HOLDER(By.xpath("//button[text()=' Reply ']")),
    VIEW_REPLIES(By.xpath("//span[text()='View ']")),
    VIEW_REPLY(By.xpath("//button[@class='cta-btn view ng-star-inserted']")),
    EDIT_REPLY_BUTTON(By.xpath("//div[contains(@class,'wrapper-reply')]//button[@class='cta-btn edit']")),
    EDIT_REPLY_HOLDER(By.xpath("//div[contains(@class,'wrapper-reply')]//textarea[contains(@class,'edit-text-input')]")),
    SAVE_CHANGES_BUTTON(By.xpath("//span[text() =' Save changes ']")),
    EDITED_REPLY_MESSAGE(By.xpath("//p[text() ='edited']")),
    LIKE_COUNT(By.cssSelector("span.like-amount")),
    LIKE_BUTTON(By.cssSelector("button.cta-btn.like"));

    private final By path;

    NewsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}