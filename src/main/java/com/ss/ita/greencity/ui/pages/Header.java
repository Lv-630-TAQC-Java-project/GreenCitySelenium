package com.ss.ita.greencity.ui.pages;

import com.ss.ita.greencity.ui.elements.Button;
import com.ss.ita.greencity.ui.elements.LanguageSwitcher;
import com.ss.ita.greencity.ui.elements.Link;
import com.ss.ita.greencity.ui.elements.ListItem;
import com.ss.ita.greencity.ui.elements.UnorderedList;
import com.ss.ita.greencity.ui.locators.CreateNewsPageLocators;
import com.ss.ita.greencity.ui.locators.HeaderLocators;
import com.ss.ita.greencity.ui.pages.econews.EcoNewsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.ss.ita.greencity.ui.locators.HeaderLocators.LOG_IN_FORM;


public class Header extends BasePage {

    private Link CreateNewsButton;
    private Link ecoNewsLink;
    private LanguageSwitcher lngSwitcher;
    private Button signInButton;
    private UnorderedList profileOptions;
    private ListItem signOut;

    public Header(WebDriver driver) {
        super(driver);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Link CreateNewsButton() {
        if (CreateNewsButton == null) {
            CreateNewsButton = new Link(driver, CreateNewsPageLocators.CREATE_NEWS_BUTTON);
        }
        return CreateNewsButton;
    }

    public CreateNewsPage clickCreateButton() {
        CreateNewsButton().click();
        return new CreateNewsPage(driver);
    }

    public Link getEcoNewsLink() {
        if (ecoNewsLink == null) {
            ecoNewsLink = new Link(driver, HeaderLocators.ECO_NEWS_LINK);
        }
        return ecoNewsLink;
    }

    public EcoNewsPage clickEcoNewsLink() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getEcoNewsLink().click();
        return new EcoNewsPage(driver);
    }

    public LanguageSwitcher getLngSwitcher() {
        lngSwitcher = new LanguageSwitcher(driver, HeaderLocators.LANGUAGE_SWITCHER);
        return lngSwitcher;
    }

    public Header clickLanguageSwitcher() {
        getLngSwitcher().click();
        return new Header(driver);
    }

    public LanguageSwitcher getLngSwitcherEn() {
        lngSwitcher = new LanguageSwitcher(driver, HeaderLocators.LANGUAGE_SWITCHER_EN);
        return lngSwitcher;
    }

    public Header changeLanguageEn() {
    	clickLanguageSwitcher().getLngSwitcherEn().click();
        return new Header(driver);
    }

    public Button getSignInButton() {
        signInButton = new Button(driver, HeaderLocators.SIGN_IN_BUTTON);
        return signInButton;
    }

    public SignInPage goToSignPage() {
        getSignInButton().clickButton();
        return new SignInPage(driver);

    }


    public MySpacePage login(String email, String password) {
        getHeader()
                .goToSignPage()
                .setEmail(email)
                .setPassword(password)
                .goToMySpacePage();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LOG_IN_FORM.getPath()));

        return new MySpacePage(driver);
    }

    public HomePage logout() {
    	getHeader().getUnorderedList().clickUnorderedList();
    	getHeader().getListItemOut().clickListItem();
    	return new HomePage(driver);

    }

	public UnorderedList getUnorderedList() {
		if (profileOptions == null) {
			profileOptions = new UnorderedList(driver, HeaderLocators.PROFILE_OPTIONS);
		}
		return profileOptions;
	}
	public ListItem getListItemOut() {
		if (signOut == null) {
			signOut = new ListItem(driver, HeaderLocators.SIGN_OUT);
		}
		return signOut;
	}

}
