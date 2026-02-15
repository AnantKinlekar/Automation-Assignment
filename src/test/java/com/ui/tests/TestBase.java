package com.ui.tests;

import com.ui.pages.HomePage;
import com.utility.BrowserUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import static com.constants.Browser.CHROME;

public class TestBase {
    Logger logger = LogManager.getLogger(this.getClass());
    protected HomePage homePage;

    @BeforeMethod(description = "Loading the homepage")
    public void setup() {
        logger.info("Loading the homepage");
        homePage = new HomePage(CHROME, false);
    }

    public BrowserUtil getInstance(){
        return homePage;
    }
}
