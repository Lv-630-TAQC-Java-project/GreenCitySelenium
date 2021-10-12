package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;

import com.ss.ita.greencity.ui.elements.TextArea;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ss.ita.econews.ui.data.UserSignInData;

public class CreateNewsTest extends TestRuner {
    @Test
    public void createNews() {
        CreateNewsPage createNewsPage = new HomePage(driver)
                .getHeader()
                .login(UserSignInData.TEST_USER.getEmail(), UserSignInData.TEST_USER.getPassword())
                .clickHomePageLink()
                .clickEcoNewsLink()
                .clickCreateNewsButton()
                .clickTagNewsButton();
        TextArea setTitleArea = new CreateNewsPage(driver).setTitleTextArea("Test News");
        TextArea setContentArea = new CreateNewsPage(driver).setContentArea();
        createNewsPage.clickPublishButton();
        EcoNewsPage clickFilterBy = new EcoNewsPage(driver).clickFilterByNews();
        String title = new EcoNewsPage(driver).getCreatedNewsTitle().getText();
        Assert.assertEquals(title, "Test News");
    }

    @Test
    public void createNewsVlad(){
        new HomePage(driver).getHeader().login("vladdmutriv@gmail.com","1203Vlad01*");
        EcoNewsPage ecoNewsPage = new HomePage(driver).getHeader().clickEcoNewsLink();
        ecoNewsPage.getHeader().clickCreateButton();
        new CreateNewsPage(driver).createNews();
        String title = ecoNewsPage.getNewsTitle().getText();
        Assert.assertEquals(title, "Test News");
    }
}
