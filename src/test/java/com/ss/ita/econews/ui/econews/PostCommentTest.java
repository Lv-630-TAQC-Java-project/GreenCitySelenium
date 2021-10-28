package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.data.UserSignInData;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.greencity.ui.locators.NewsLocators.COMMENTS_LIST;

public class PostCommentTest extends TestRuner {
    @Test
    public void postComment() {
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
                .setCommentText("some comment")
                .clickCommentButton();

        // waiting for comment to appear
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(COMMENTS_LIST.getPath()));

        int commentsListSize = newsPage.numbersOfComments();
        int commentsCountInLabel = newsPage.getCommentsCountFromLabel();
        Assert.assertEquals(commentsCountInLabel, commentsListSize);
    }
}
