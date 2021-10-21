package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.NewsPage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.ss.ita.greencity.ui.locators.NewsLocators.COMMENTS_LIST;

public class PostCommentTest extends TestRuner {
    @Test
    public void postComment(){
        CreateNewsPage createNewsPage = new HomePage(driver)
                .getHeader()
                .login(UserSignInData.TEST_USER.getEmail(), UserSignInData.TEST_USER.getPassword())
                .clickHomePageLink()
                .clickEcoNewsLink()
                .clickCreateNewsButton()
                .clickTagNewsButton();
        createNewsPage.setTitleTextArea(System.currentTimeMillis() + "");
        createNewsPage.setContentArea();
        createNewsPage.clickPublishButton();

        NewsPage newsPage = createNewsPage.getHeader().clickEcoNewsLink()
                .getNews().get(0).click()
                .setComment("some comment")
                .clickComment();

        // waiting for comment to appear
        while(newsPage.getComments().isEmpty());

        Assert.assertEquals(newsPage.getCommentsCount().replaceAll("\\D", ""), "1");
    }
}
