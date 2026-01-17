package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest3 {
    static void main(String[] args) {

        HomePage homePage = new HomePage(CHROME);
        String userName = homePage.goToLoginPage().doLoginWith("yejor31268@noihse.com", "Kishor@123").getUserName();
        System.out.println("userName: " + userName);
    }
}
