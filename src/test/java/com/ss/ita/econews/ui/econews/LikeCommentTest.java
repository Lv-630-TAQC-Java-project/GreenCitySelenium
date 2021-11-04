package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.CredentialProperties;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import static com.ss.ita.econews.ui.data.UserSignInData.TEST_ACCOUNT;



public class LikeCommentTest extends TestRuner {
private NewsPage singleNews;

@BeforeClass
	public void goToSingleNews() {
	CredentialProperties prop = new CredentialProperties();
		singleNews = new HomePage(driver)
				.getHeader()
				.login(prop.getTestAccountLogin(), prop.getTestAccountPassword())
				.clickHomePageLink()
				.clickEcoNewsLink()
				.getNews()
				.get(0)
				.click();
	}
 
	@Test
	public void verifyLikeDislikeComment() {
        int likesAmount = Integer.parseInt(singleNews.getCommentByIndex(1).getLikesCount());
		singleNews.getCommentByIndex(1).pressLikeButton();
		new EcoNewsPage(driver).pause(2000);
		String actualLikeButtonText = singleNews.getCommentByIndex(1).getLikeButtonText();
		String expectedLikeButtonText = "Liked";
        softAssert.assertEquals(Integer.parseInt(singleNews.getCommentByIndex(1).getLikesCount()), likesAmount + 1);
		softAssert.assertEquals(actualLikeButtonText, expectedLikeButtonText);
        likesAmount = Integer.parseInt(singleNews.getCommentByIndex(1).getLikesCount());
        singleNews.getCommentByIndex(1).pressLikeButton();
        new EcoNewsPage(driver).pause(2000);
		actualLikeButtonText = singleNews.getCommentByIndex(1).getLikeButtonText();
		expectedLikeButtonText = "Like";
		softAssert.assertEquals(actualLikeButtonText, expectedLikeButtonText);
        softAssert.assertEquals(Integer.parseInt(singleNews.getCommentByIndex(1).getLikesCount()), likesAmount - 1);
        softAssert.assertAll();
	}

}
