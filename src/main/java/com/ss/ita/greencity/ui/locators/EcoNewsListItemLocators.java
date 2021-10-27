package com.ss.ita.greencity.ui.locators;

import org.openqa.selenium.By;

public enum EcoNewsListItemLocators implements BaseLocator {

    TITLE_LABEL(By.xpath("//div[1]/h3")),
    CONTENT_LABEL(By.xpath("//div[2]/p")),
    TAG_LABEL(By.xpath("//*[@id=\"main-content\"]/div/div[4]/ul/li[1]/app-news-list-gallery-view/div/div/div[1]/div")),
    DATA_LABEL(By.xpath("//div[3]/p[1]")),
    IMAGE_LABEL(By.xpath("//div/img")),
    AUTHOR_LABEL(By.xpath("//div[3]/p[2]"));


    private final By path;

    EcoNewsListItemLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
