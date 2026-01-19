package com.ui.tests;

import static com.constants.Browser.*;

import com.ui.pages.HomePage;

import static org.testng.Assert.*;

import com.ui.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    static HomePage homePage;

    @BeforeMethod(description = "Loading the homepage")
    public void setup() {
        homePage = new HomePage(CHROME);
    }

    @Test(description = "Verify if the valid user is able to login into the application.", groups = {"e2e", "sanity"}, dataProviderClass =  com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    static void loginTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Anant Kinlekar");
    }

    @Test(description = "Verify if the valid user is able to login into the application using CSV File Data.", groups = {"e2e", "sanity"}, dataProviderClass =  com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginCSVDataProvider")
    static void loginCSVTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Anant Kinlekar");
    }

    @Test(description = "Verify if the valid user is able to login into the application using Excel File Data.", groups = {"e2e", "sanity"}, dataProviderClass =  com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginExcelDataProvider")
    static void loginExcelTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Anant Kinlekar");
    }
}
