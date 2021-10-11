package com.ss.ita.econews;

import org.testng.annotations.Test;

import com.ss.ita.pages.CreateNewsPage;
import com.ss.ita.pages.EcoNewsPage;
import com.ss.ita.pages.HomePage;

public class InputContentTest extends TestRuner {

	@Test
	public void contentTest() {
		CreateNewsPage createNewsPage = new HomePage(driver)
				.getHeader()
				.login()
				.clickHomePageLink()
				.clickEcoNewsLink()
				.clickCreateNewsButton();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // ONLY FOR PRESENTATION!!!!!

	}

}
