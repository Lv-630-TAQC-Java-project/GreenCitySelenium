package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.CredentialProperties;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.testng.annotations.Test;


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
        createNewsPage.setTitleTextArea("");
        createNewsPage.clickTagNewsButton();
        createNewsPage.setContentArea();
        createNewsPage.clickPublishButton();
        NewsPage newsPage = new EcoNewsPage(driver)
                .getNewsByIndex(0)
                .click();
        //return newsPage;
    }
}
