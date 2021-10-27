package com.ss.ita.econews.ui.econews;

import com.ss.ita.econews.ui.runner.TestRuner;
import com.ss.ita.greencity.ui.elements.Label;
import com.ss.ita.greencity.ui.pages.HomePage;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsListItemComponent;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;


public class ItemViewTest extends TestRuner {
    @Test
    public void itemViewTest() {

        EcoNewsListItemComponent ecoNewsItem = new HomePage(driver).
                getHeader()
                .clickEcoNewsLink()
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
        softAssert.assertEquals(ecoNewsItem.getTitle().getText(),"Name");
        softAssert.assertTrue(ecoNewsItem.getContent().isDisplayed());
        softAssert.assertEquals(ecoNewsItem.getContent().getText(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        softAssert.assertEquals(ecoNewsItem.getAuthor().getText(),"Oleg Postolovskyi");
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
