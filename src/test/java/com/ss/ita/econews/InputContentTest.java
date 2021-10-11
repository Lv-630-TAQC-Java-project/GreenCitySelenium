package com.ss.ita.econews;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ss.ita.pages.CreateNewsPage;
import com.ss.ita.pages.EcoNewsPage;
import com.ss.ita.pages.HomePage;
import static com.ss.ita.data.UserSignInData.* ;

public class InputContentTest extends TestRuner {

	@DataProvider
    public static Object[][] dpInputContentTest() {
        return new Object[][]{
                {"Test string"}};            
       
    }
	@Test
	public void contentTest() {
		CreateNewsPage createNewsPage = new HomePage(driver)
				.getHeader()
				.login(TARAS_KRASITSKYI.getEmail(), TARAS_KRASITSKYI.getPassword())
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
