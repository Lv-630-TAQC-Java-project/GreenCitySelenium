package com.ss.ita.econews.ui.econews;

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
		singleNews = new HomePage(driver)
				.getHeader()
				.login(TEST_ACCOUNT.getEmail(), TEST_ACCOUNT.getPassword())
				.clickHomePageLink()
				.clickEcoNewsLink()
				.getNews()
				.get(0)
				.click();
	}
 
	@Test
	public void verifyLikeDislikeComment() {
		
		int likesAmount = Integer.parseInt(singleNews.getCommentByIndex(0).getLikesCount());
		singleNews.getCommentByIndex(0).pressLikeButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // FOR PRESENTATION ONLY!

		softAssert.assertEquals(Integer.parseInt(singleNews.getCommentByIndex(0).getLikesCount()), likesAmount + 1);
		singleNews.getCommentByIndex(0).pressLikeButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // FOR PRESENTATION ONLY!

		likesAmount = Integer.parseInt(singleNews.getCommentByIndex(0).getLikesCount());
		softAssert.assertEquals(Integer.parseInt(singleNews.getCommentByIndex(0).getLikesCount()), likesAmount - 1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // FOR PRESENTATION ONLY!
	}
	

}