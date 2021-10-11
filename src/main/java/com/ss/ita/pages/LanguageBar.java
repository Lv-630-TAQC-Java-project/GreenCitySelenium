package com.ss.ita.pages;

import com.ss.ita.elements.Label;
import org.openqa.selenium.WebDriver;

import static com.ss.ita.locators.HeaderLocators.ENGLISH_LANGUAGE_BUTTON;
import static com.ss.ita.locators.HeaderLocators.UKRAINE_LANGUAGE_BUTTON;

public class LanguageBar extends BasePage{
    private Label engLang;
    private Label ukrLang;
    public LanguageBar(WebDriver driver) {
        super(driver);
    }
    public Label getEnglishBar(){
        if(engLang==null){
            engLang = new Label(driver,ENGLISH_LANGUAGE_BUTTON);
        }
        return engLang;
    }
    public Label getUkrainianBar(){
        if(ukrLang==null){
            ukrLang = new Label(driver,UKRAINE_LANGUAGE_BUTTON);
        }
        return ukrLang;
    }
    public void clickOnChangingLanguageButtons(){
        getEnglishBar().click();
        getUkrainianBar().click();
    }

}
