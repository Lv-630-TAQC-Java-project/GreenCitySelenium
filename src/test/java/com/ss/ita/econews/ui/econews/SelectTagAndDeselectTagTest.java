package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.CredentialProperties;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import org.testng.annotations.Test;

public class SelectTagAndDeselectTagTest extends TestRuner {

    @Test
    public void SelectAndDeselectTagTest() {
        CreateNewsPage createNewsPage = new HomePage(driver)
                .getHeader()
                .login(new CredentialProperties().getTestUserLogin(),
                        new CredentialProperties().getTestUserPassword())
                .clickHomePageLink()
                .clickEcoNewsLink()
                .clickCreateNewsButton();
        String colorSelected = createNewsPage
                .clickTagNewsButton()
                .getSelectedNewsTagButton()
                .getBackgroundHexColor();
        softAssert.assertEquals(colorSelected, "#13aa57");
        String colorDeselected = createNewsPage
                .clickSelectedNewsTagButton()
                .getTag_News_button()
                .getBackgroundHexColor();
        softAssert.assertEquals(colorDeselected, "#ffffff");
        softAssert.assertAll();
    }
}
