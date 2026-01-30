package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtil {
    private static ThreadLocal<WebDriver> driver;
    Logger logger = LogManager.getLogger(this.getClass());


    public BrowserUtil(WebDriver driver) {
        this.driver.set(driver);
    }

    public BrowserUtil(Browser browserName, boolean isHeadless) {
        logger.info("Launching browser for '" + browserName.toString() + "'");

        if (browserName == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
            } else {
                driver.set(new ChromeDriver());
                maximizeWindow();
            }
        } else if (browserName == Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window-size=1920,1080");
                driver.set(new FirefoxDriver(options));
            } else {
                driver.set(new FirefoxDriver());
                maximizeWindow();
            }
        } else if (browserName == Browser.EDGE) {
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window-size=1920,1080");
                driver.set(new EdgeDriver(options));
            } else {
                driver.set(new EdgeDriver());
                maximizeWindow();
            }
        } else {
            logger.error("Browser has not been initialized");
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void goToWebSite(String webSiteUrl) {
        logger.info("Visiting the website: " + webSiteUrl);
        driver.get().get(webSiteUrl);
    }

    public void maximizeWindow() {
        logger.info("Maximizing the browser Window ");
        driver.get().manage().window().maximize();
    }

    public void clickOnWebElement(By locator) {
        logger.info("Finding the element by locator: " + locator);
        driver.get().findElement(locator).click();
        logger.info("Element Found and now performing Click");

    }

    public void enterText(By locator, String textToEnter) {
        logger.info("Finding Element by locator: " + locator);
        driver.get().findElement(locator).sendKeys(textToEnter);
        logger.info("Element Found and now performing enter text: " + textToEnter);
    }

    public String getVisibleText(By locator) {
        logger.info("Finding Element by locator: " + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element found and not returning the visible text: " + element.getText());
        return element.getText();
    }

    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String timestamp = format.format(date);
        String path = System.getProperty("user.dir") + "\\screenshots\\" + name + "_" + timestamp + ".png";
        File screenShotData = screenshot.getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenShotData, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}
