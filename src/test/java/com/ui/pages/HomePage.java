package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtil;
import com.utility.JSONUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtil {
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), \"Sign in\")]");
    Logger logger = LogManager.getLogger(this.getClass());

    public HomePage(Browser browser) {
        super(browser);
        goToWebSite(JSONUtil.readJson(QA).getUrl());
    }

    public LoginPage goToLoginPage(){
        logger.info("Trying to perform 'Click to Go to Sign In Page'");//page functions
        clickOnWebElement(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }
}
