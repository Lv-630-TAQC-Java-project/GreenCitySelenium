package com.ss.ita.econews.ui;

import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.econews.ui.runner.TestRuner;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void createNews() throws InterruptedException {
        new HomePage(driver).getHeader().login("vladdmutriv@gmail.com","1203Vlad01*");
        EcoNewsPage ecoNewsPage = new HomePage(driver).getHeader().clickEcoNewsLink();
        ecoNewsPage.getHeader().clickCreateButton();
        new CreateNewsPage(driver).createNews();
        String title = ecoNewsPage.getNewsTitle().getText();
        Assert.assertEquals(title, "Test News");
    }
}
