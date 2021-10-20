package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLanguageTest extends TestRuner {
    @Test
    public void changeLanguageFromDefaultToUkr() {
        HomePage homePage = new HomePage(driver).getLanguageBar()
                .changeLanguageToUkr();

        String homePageTitle = homePage.getHomePageTitleUkr().getText();
        Assert.assertEquals(homePageTitle, "Новий спосіб виховати в собі корисні звички");
    }
}
