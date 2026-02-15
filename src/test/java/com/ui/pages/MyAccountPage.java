package com.ui.pages;

import com.utility.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtil {
    private static final By USERNAME_LOCATOR = By.xpath("//a[@title= 'View my customer account']");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUsernameText(){
        return getVisibleText(USERNAME_LOCATOR);
    }
}
