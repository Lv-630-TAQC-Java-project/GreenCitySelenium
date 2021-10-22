package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum SingleNewLocators implements BaseLocator{
    REPLY_BUTTON(By.xpath("//span[text()=' Reply ']")),
    REPLY_HOLDER(By.xpath("//textarea[@placeholder='Add a reply']")),
    ACCEPT_REPLY_HOLDER(By.xpath("//button[text()=' Reply ']")),
    VIEW_REPLIES(By.xpath("//span[text()='View ']")),
    EDIT_REPLY_BUTTON(By.xpath("//div[contains(@class,'wrapper-reply')]//button[@class='cta-btn edit']")),
    EDIT_REPLY_HOLDER(By.xpath("//div[contains(@class,'wrapper-reply')]//textarea[contains(@class,'edit-text-input')]")),
    SAVE_CHANGES_BUTTON(By.xpath("//span[text() =' Save changes ']")),
    EDITED_REPLY_MESSAGE(By.xpath("//p[text() ='edited']"));
    private final By path;

    SingleNewLocators(By path) {
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
