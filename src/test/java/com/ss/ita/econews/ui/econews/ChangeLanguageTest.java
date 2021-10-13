package com.ss.ita.econews.ui.econews;

import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.econews.ui.runner.TestRuner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLanguageTest extends TestRuner {
    @Test
    public void changeLanguageToUkr(){
        HomePage homePage = new HomePage(driver).getLanguageBar()
                .clickOnLanguageSwitcher()
                .clickOnUkrLanguage();

        String homePageTitle = homePage.getHomePageTitle().getText();
        Assert.assertEquals(homePageTitle,"Новий спосіб виховати в собі корисні звички");
    }
}
