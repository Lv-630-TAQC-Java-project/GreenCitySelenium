package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum NewsListCommentsLocators implements BaseLocator {
    REPLY_FIRST_COMMENT_BUTTON(By.xpath("//div[contains(@class,'comment-body-wrapper wrapper-comment')][1]/descendant::button[@class='cta-btn reply']")),
    REPLY_TEXT_AREA(By.xpath("//form[contains(@class, 'wrapper-reply')]/descendant::div/textarea")),
    PUBLISH_REPLY_BUTTON(By.xpath("//button[contains(text(),'Reply')]")),
    DELETE_FIRST_COMMENT_BUTTON(By.xpath("//span[contains(text(),' Delete ')][1]")),
    APPROVE_DELETING_COMMENT_BUTTON(By.xpath("//button[contains(text(),' Yes, delete ')]")),
    VIEW_REPLY_BUTTON(By.xpath("//button[@class='cta-btn view ng-star-inserted'][1]")),
    IS_COMMENT_POSTED(By.xpath("//p[@class='comment-text ng-star-inserted']"));

    private final By path;

    NewsListCommentsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
