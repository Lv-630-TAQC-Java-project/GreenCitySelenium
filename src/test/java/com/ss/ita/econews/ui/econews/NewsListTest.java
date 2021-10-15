package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.locators.EcoNewsLocators;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsListComponent;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsListItemComponent;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NewsListTest extends TestRuner {

    @Test
    public void testFirstNews() throws InterruptedException {
        EcoNewsPage ecoNewsPage = new HomePage(driver).
                getHeader().clickEcoNewsLink();
        driver.navigate().refresh();
        Thread.sleep(5000);

        ecoNewsPage.scrollPageToTheBottom();
        int count = driver.findElements(
                By.cssSelector(".list.gallery-view-active > .gallery-view-li-active")).size();
        System.out.println("Count: " + count);
        String total_Items = driver.findElement(
                By.cssSelector("div[class='main-wrapper'] app-remaining-count div h2")).getText();
        String[] splited = total_Items.split(" ");
        Assert.assertEquals(count, Integer.parseInt(splited[0]));
        }
}
