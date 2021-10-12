package com.ss.ita.econews.ui;

import com.ss.ita.greencity.ui.pages.components.News;
import com.ss.ita.greencity.ui.pages.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ss.ita.econews.ui.runner.TestRuner;
import org.testng.Assert;
import org.testng.annotations.Test;
import  com.ss.ita.greencity.ui.locators.*;


public class FirstTest extends TestRuner {


    @Test
    public void goToEconews(){
        EcoNewsPage ecoNewsPage =  new HomePage(driver).
                getHeader().
                clickEcoNewsLink();
        String title = ecoNewsPage.getMainHeader().getText();
        Assert.assertEquals(title, "Eco news");
    }
    @Test
    public void changeLanguageToUkr(){
        HomePage homePage = new HomePage(driver).getLanguageBar()
                .clickOnLanguageSwitcher()
                .clickOnUkrLanguage();

        String homePageTitle = homePage.getHomePageTitle().getText();
        Assert.assertEquals(homePageTitle,"Новий спосіб виховати в собі корисні звички");
    }

    @Test
    public void changeViewToList(){
        new HomePage(driver)
                .getHeader()
                .clickEcoNewsLink()
                .clickChangeViewButton();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#main-content > div > div.list-wrapper > ul > li:nth-child(1) > app-news-list-list-view > div > div")));
        News news = new News(driver, EcoNewsLocators.NEWS_LIST_VIEW);
        Assert.assertEquals(news.getNewsClass(),"eco-news_list-content");

    }

}
