package com.android.tests;

import com.android.pages.DashboardPage;
import com.android.pages.LoginPage;
import com.android.util.PropertyLoader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners(com.android.util.ScreenshotTaker.class)
public class LoginTest extends BaseTest{

    private final String loginPropertyPath = "src/test/resources/login.properties";
    private final String appPropertyPath = "src/test/resources/app.properties";
    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";

    private final String login = PropertyLoader.loadProperty(appPropertyPath, "login");
    private final String password = PropertyLoader.loadProperty(appPropertyPath, "password");
    private final String incorrectLogin = PropertyLoader.loadProperty(loginPropertyPath, "incorrectLogin");
    private final String incorrectPassword = PropertyLoader.loadProperty(loginPropertyPath, "incorrectPassword");
    private final String labelIncorrectLogin = PropertyLoader.loadProperty(loginPropertyPath, "labelIncorrectLogin");
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    @BeforeClass
    public void setUp() throws Exception {
        super.setUp();
    }

//    @Test(priority = 1)
//    public void LoginWithEmptyData() {
//        assertFalse(LoginPage.checkLoginButtonEnabled());
//    }

    @Test(priority = 2)
    public void LoginWithEmptyPassword() {
        LoginPage.enterEmail(login);
        LoginPage.clickLogin();
        assertTrue(LoginPage.checkPasswordFieldHasDefaultValue());
        assertEquals(LoginPage.getLabelIncorrectLogin(), "Password error");
    }

    @Test(priority = 3)
    public void LoginWithEmptyLogin() {
        LoginPage.clearLoginField();
        LoginPage.enterPassword(password);
        LoginPage.clickLogin();
        assertTrue(LoginPage.checkLoginFieldHasDefaultValue());
        assertEquals(LoginPage.getLabelIncorrectLogin(), "Email error");

    }

    @Test(priority = 4)
    public void LoginWihIncorrectDataTest() {
        LoginPage.enterEmail(incorrectLogin);
        LoginPage.clearPasswordField();
        LoginPage.enterPassword(password);
        LoginPage.clickLogin();
        assertEquals(labelIncorrectLogin, LoginPage.getLabelIncorrectLogin());
        LoginPage.clearLoginField();
        LoginPage.clearPasswordField();
        LoginPage.enterEmail(login);
        LoginPage.enterPassword(incorrectPassword);
        LoginPage.clickLogin();
        assertEquals(labelIncorrectLogin, LoginPage.getLabelIncorrectLogin());
    }

    @Test(priority = 5)
    public void SuccessLoginTest() {
        LoginPage.clearLoginField();
        LoginPage.enterEmail(login);
        LoginPage.clearPasswordField();
        LoginPage.enterPassword(password);
        LoginPage.clickLogin();
        DashboardPage.checkPageTitle(titleDashboard);
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
