package com.ss.ita.greencity.ui.pages.econews;

import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.elements.Label;
import com.ss.ita.greencity.ui.locators.CreateNewsPageLocators;
import com.ss.ita.greencity.ui.locators.EcoNewsLocators;
import com.ss.ita.greencity.ui.pages.BasePage;
import com.ss.ita.greencity.ui.pages.CreateNewsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

import java.text.BreakIterator;

import static com.ss.ita.greencity.ui.locators.EcoNewsLocators.*;

public class EcoNewsPage extends BasePage {

    private Label mainHeader;
    private Label createdNewsTitle;
    private Button createNewsButton;
    private Button filterByNews;
    private Button changeViewButton;
    private Label newsTitle;
    private Button newsButton;
    private EcoNewsListComponent news;
    private EcoNewsPage scroll;


    public EcoNewsListComponent getNews() {
        if (news == null) {
            news = new EcoNewsListComponent(driver);
        }
        return news;
    }

    public EcoNewsPage(WebDriver driver) {
        super(driver);
    }

    public Label getMainHeader() {
        if (mainHeader == null) {
            mainHeader = new Label(driver, ECO_NEWS_MAIN_HEADER);
        }
        return mainHeader;
    }

    public Label getCreatedNewsTitle() {
        if (createdNewsTitle == null) {
            createdNewsTitle = new Label(driver, TEST_NEWS_TITLE);
        }
        return createdNewsTitle;
    }

    public Button getCreateNewsButton() {
        if (createNewsButton == null) {
            createNewsButton = new Button(driver, CREATE_NEWS_BUTTON);

        }
        return createNewsButton;
    }

    public CreateNewsPage clickCreateNewsButton() {
        WebElement createNewsButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(CreateNewsPageLocators.CREATE_BUTTON.getPath()));
        getCreateNewsButton().clickButton();
        return new CreateNewsPage(driver);
    }

    public Button getFilterByNews() {
        if (filterByNews == null) {
            filterByNews = new Button(driver, FILTER_BY_NEWS);
        }
        return filterByNews;
    }

    public EcoNewsPage clickFilterByNews() {
        getFilterByNews().clickButton();
        return new EcoNewsPage(driver);
    }

    public Label getNewsTitle() {
        if (newsTitle == null) {
            newsTitle = new Label(driver, TEST_NEWS_TITLE);
        }

        return newsTitle;
    }

    public Button getChangeViewButton() {
        if (changeViewButton == null) {
            changeViewButton = new Button(driver, CHANGE_VIEW_BUTTON);

        }
        return changeViewButton;
    }

    public EcoNewsPage clickChangeViewButton() {
        getChangeViewButton().clickButton();
        return this;
    }

    public Button getNewsButton() {
        if (newsButton == null) {
            newsButton = new Button(driver, TEST_NEWS_TITLE);
        }

        return newsButton;
    }

    public NewsPage clickNewsButton() {
        getNewsButton().clickButton();
        return new NewsPage(driver);
    }
    public EcoNewsPage getScroll() {
        driver.findElement(FOOTER.getPath());
        return new EcoNewsPage(driver);
    }
    public EcoNewsPage scrollPageToTheBottom() {
        WebElement scrollPage = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-wrapper")));
        while (true) {
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
            try {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                WebElement circle = (new WebDriverWait(driver, 5)).until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[name()='circle' and contains(@cx,'50%')]")));
            }
            catch(Throwable breakIterator) {
                break;
            }
            // wait till sircle dissapear
        }
        return new EcoNewsPage(driver);
    }
}
