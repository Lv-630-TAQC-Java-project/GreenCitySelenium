package com.ss.ita.greencity.ui.pages.econews;

import com.ss.ita.greencity.ui.locators.EcoNewsListLocators;
import com.ss.ita.greencity.ui.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class EcoNewsListComponent extends BasePage {
    private List<EcoNewsListItemComponent> news;

    public EcoNewsListComponent(WebDriver driver) {
        super(driver);
        init();
    }

    public List<EcoNewsListItemComponent> init() {
        if (news == null) {
            news = new LinkedList<>();
            driver.findElements(EcoNewsListLocators.ITEMS.getPath())
                    .forEach(webElement -> news.add(new EcoNewsListItemComponent(driver, webElement)));
        }
        return news;
    }

    public EcoNewsListItemComponent get(int i) {
        return news.get(i);
    }
    
    public int sizeEcoNewsListComponent() {
    	return news.size();
    }

    public EcoNewsListComponent loadAllEcoNews() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        Actions scrollDown = new Actions(driver);
        while (true) {
            scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(EcoNewsListLocators.LOADING_CIRCLE.getPath()));
            } catch (TimeoutException exception) {
                break;
            }
        }
        pause(2000);
        for (int i = 0; i < 5; i++) {
            scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            pause(1000);
        }
        pause(2000);
        return new EcoNewsListComponent(driver);
    }

    public int countNewsFromLabel() {
        int count = 0;
        String textLabel = driver.findElement(By.xpath("//div[@class = 'main-wrapper']//h2")).getText();
        count = Integer.parseInt(textLabel.replaceAll("[^0123456789]", ""));
        return count;
    }
 }
