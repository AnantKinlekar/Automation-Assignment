package com.ui.pages;

import com.constants.Browser;
import static com.constants.Environment.*;
import com.utility.BrowserUtil;
import static com.utility.PropertiesUtil.*;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtil {
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), \"Sign in\")]");

    public HomePage(Browser browser) {
        super(browser);
        goToWebSite(readProperty(QA, "URL"));
    }

    public LoginPage goToLoginPage(){ //page functions
        clickOnWebElement(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }
}
