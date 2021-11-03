package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.CredentialProperties;
import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.elements.Label;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsListItemComponent;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import com.ss.ita.greencity.ui.pages.news.NewsPage;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import static com.ss.ita.econews.ui.data.UserSignInData.VLAD_DMYTRIV;


public class ItemViewTest extends TestRuner {

    @Test
    public void itemViewTest() {

        CreateNewsPage createNewsPage  = new HomePage(driver)
                .getHeader()
                .login(new CredentialProperties().getNastiaSydorLogin(),
                        new CredentialProperties().getNastiaSydorPassword())
                .getHeader()
                .clickEcoNewsLink()
                .clickCreateNewsButton();
        createNewsPage.setTitleTextArea("Title");
        createNewsPage.clickTagNewsButton();
        createNewsPage.setContentArea();
        createNewsPage.clickPublishButton();

        EcoNewsListItemComponent ecoNewsItem = new EcoNewsPage(driver)
                .getNews()
                .get(0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.US);
        boolean valid;
        try {
            LocalDate.parse((ecoNewsItem.getData().getText()), formatter);
            valid = true;
        } catch (DateTimeParseException e) {
            valid = false;
        }

        softAssert.assertTrue(ecoNewsItem.getImage().isDisplayed());
        softAssert.assertTrue(ecoNewsItem.getTag().isDisplayed());
        softAssert.assertTrue(ecoNewsItem.getTitle().isDisplayed());
        softAssert.assertEquals(ecoNewsItem.getTitle().getText(),"Title");
        softAssert.assertTrue(ecoNewsItem.getContent().isDisplayed());
        softAssert.assertEquals(ecoNewsItem.getContent().getText(),"Description for test Create News");
        softAssert.assertEquals(ecoNewsItem.getAuthor().getText(),"Nastia");
        softAssert.assertTrue(valid);
        softAssert.assertTrue(checkElementPosition(ecoNewsItem.getData(), ecoNewsItem.getAuthor()));
        softAssert.assertAll();

    }

    public boolean checkElementPosition(Label leftElement, Label rightElement) {

        Point leftElementPoint = leftElement.getLocation();
        Point pointAuthorPoint = rightElement.getLocation();
        int leftElementX = leftElementPoint.getX();
        int rightElementX = pointAuthorPoint.getX();
        if (leftElementX < rightElementX) {
            return true;
        } else return false;
    }

}
