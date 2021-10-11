package com.ss.ita.pages;

import com.ss.ita.elements.Link;
import org.openqa.selenium.WebDriver;


import static com.ss.ita.locators.HeaderLocators.ECO_NEWS_LINK;


public class Header extends BasePage {
    private Link ecoNewsLink;

    public Header(WebDriver driver) {
        super(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Link getEcoNewsLink(){
        if (ecoNewsLink == null){
            ecoNewsLink = new Link(driver, ECO_NEWS_LINK);
        }
        return ecoNewsLink;
    }


    public EcoNewsPage clickEcoNewsLink(){
        getEcoNewsLink().click();
        return new EcoNewsPage(driver);
    }

}
