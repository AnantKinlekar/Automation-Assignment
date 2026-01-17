package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtil;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtil {
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), \"Sign in\")]");

    public HomePage(Browser browser) {
        super(browser);
        goToWebSite("http://www.automationpractice.pl/index.php");
    }

    public LoginPage goToLoginPage(){ //page functions
        clickOnWebElement(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }
}
