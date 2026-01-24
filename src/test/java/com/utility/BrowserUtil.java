package com.utility;

import com.constants.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserUtil {
    private WebDriver driver;
    Logger logger = LogManager.getLogger(this.getClass());

    public BrowserUtil(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserUtil(Browser browserName) {
        logger.info("Launching browser for '" + browserName.toString() + "'");

        if (browserName == Browser.CHROME) {
            driver = new ChromeDriver();
        } else if (browserName == Browser.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browserName == Browser.EDGE) {
            driver = new FirefoxDriver();
        } else {
            logger.error("Browser has not been initialized");
        }
        maximizeWindow();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void goToWebSite(String webSiteUrl) {
        logger.info("Visiting the website: " + webSiteUrl);
        driver.get(webSiteUrl);
    }

    public void maximizeWindow() {
        logger.info("Maximizing the browser Window ");
        driver.manage().window().maximize();
    }

    public void clickOnWebElement(By locator) {
        logger.info("Finding the element by locator: " + locator);
        driver.findElement(locator).click();
        logger.info("Element Found and now performing Click");

    }

    public void enterText(By locator, String textToEnter) {
        logger.info("Finding Element by locator: " + locator);
        driver.findElement(locator).sendKeys(textToEnter);
        logger.info("Element Found and now performing enter text: " + textToEnter);
    }

    public String getVisibleText(By locator) {
        logger.info("Finding Element by locator: " + locator);
        WebElement element = driver.findElement(locator);
        logger.info("Element found and not returning the visible text: " + element.getText());
        return element.getText();
    }
}
