package com.ss.ita.econews;

import com.ss.ita.pages.EcoNewsPage;
import com.ss.ita.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends TestRuner{

    @Test
    public void goToEconews(){
        EcoNewsPage ecoNewsPage =  new HomePage(driver).
                getHeader().
                clickEcoNewsLink();
        String title = ecoNewsPage.getMainHeader().getText();
        Assert.assertEquals(title, "Eco news");
    }
    @Test
    public void changeLanguageFromEnToUkr(){
        new HomePage(driver)
                .getLanguageBar()
                .clickOnChangingLanguageButtons();

        HomePage homePage =new HomePage(driver);
        String homePageTitle = homePage.getHomePageTitle().getText();
        Assert.assertEquals(homePageTitle,"Новий спосіб виховати в собі корисні звички");
    }
}
