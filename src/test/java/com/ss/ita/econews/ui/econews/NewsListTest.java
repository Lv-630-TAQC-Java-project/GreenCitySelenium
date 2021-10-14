package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.locators.EcoNewsLocators;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsListItemComponent;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NewsListTest extends TestRuner {

    @Test
    public void testFirstNews() {
        EcoNewsPage ecoNewsItem = new HomePage(driver).
                getHeader()
                .clickEcoNewsLink()
                .scrollPageToTheBottom();
        int count = driver.findElements(
                By.cssSelector(".list.gallery-view-active > .gallery-view-li-active")).size();
        System.out.println("Count: " + count);
        String total_Items = driver.findElement(
                By.cssSelector("div[class='main-wrapper'] app-remaining-count div h2")).getText();
//        System.out.println("total_Items: " + total_Items);
        String[] splited = total_Items.split(" ");
        Assert.assertEquals(count, Integer.parseInt(splited[0]));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        softAssert.assertEquals(ecoNewsItem.getTitle().getText(), "Test News");
//        softAssert.assertEquals(ecoNewsItem.getContent().getText(), "Description for test news");
//        softAssert.assertAll();
        }
}
