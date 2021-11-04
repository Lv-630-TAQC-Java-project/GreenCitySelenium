package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.CredentialProperties;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.ss.ita.greencity.ui.locators.HeaderLocators.LOG_IN_FORM;


public class CreateNewsWithPDFInsteadOfImgTest extends TestRuner {

    @Test
    public void createNewsWithPDFInsteadOfImgTest() {
        CreateNewsPage createNewsPage = new HomePage(driver)
                .getHeader()
                .login(new CredentialProperties().getNastiaSydorLogin(),
                        new CredentialProperties().getNastiaSydorPassword())
                .getHeader()
                .clickEcoNewsLink()
                .clickCreateNewsButton();

        WebElement element= driver.findElement(By.xpath("//*[@id='upload']"));
        element.sendKeys("D:/SoftServe/GreenCitySelenium/src/test/resources/TestData/Tests.pdf");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main-content']/div/div[2]/form/div[1]/div[2]/app-drag-and-drop/div/span")));

    }
}
