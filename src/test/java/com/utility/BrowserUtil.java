package com.utility;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserUtil {
    private WebDriver driver;

    public BrowserUtil(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserUtil(Browser browserName) {
        if (browserName == Browser.CHROME) {
            driver = new ChromeDriver();
        } else if (browserName == Browser.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browserName == Browser.EDGE) {
            driver = new FirefoxDriver();
        } else {
            System.err.println("Browser Type Not Supported");
        }
        maximizeWindow();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void goToWebSite(String webSiteUrl) {
        driver.get(webSiteUrl);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void clickOnWebElement(By locator) {
        driver.findElement(locator).click();
    }

    public void enterText(By locator, String textToEnter) {
        driver.findElement(locator).sendKeys(textToEnter);
    }

    public String getVisibleText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}
