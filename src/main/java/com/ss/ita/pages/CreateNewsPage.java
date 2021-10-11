package com.ss.ita.pages;

import org.openqa.selenium.WebDriver;

import static com.ss.ita.locators.CreateNewsLocators.*;


public class CreateNewsPage extends BasePage {


    public CreateNewsPage(WebDriver driver) {
        super(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createNews() throws InterruptedException {
        driver.findElement(TITLE_AREA.getPath()).sendKeys("Test News");
        driver.findElement(NEWS_BUTTON.getPath()).click();
        driver.findElement(ADS_BUTTON.getPath()).click();
        driver.findElement(EVENTS_BUTTON.getPath()).click();
        driver.findElement(CONTENT_AREA.getPath()).sendKeys("Description for test news");
        driver.findElement(PUBLISH_BUTTON.getPath()).click();
        Thread.sleep(10000);
    }

    public CreateNewsPage setTitle(String title) {
        driver.findElement(TITLE_AREA.getPath()).sendKeys(title);
        return this;
    }

    public CreateNewsPage setSource(String source) {
        driver.findElement(SOURCE_AREA.getPath()).sendKeys(source);
        return this;
    }

    public CreateNewsPage setContent(String content) {
        driver.findElement(CONTENT_AREA.getPath()).sendKeys(content);
        return this;
    }

    public PreviewPage clickPreviewButton(){
        driver.findElement(PREVIEW_BUTTON.getPath()).click();
        return new PreviewPage(driver);
    }
}
