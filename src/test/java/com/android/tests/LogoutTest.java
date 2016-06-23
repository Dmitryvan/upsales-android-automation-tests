package com.android.tests;

import com.android.pages.BasePage;
import com.android.pages.LeftMenuPage;
import com.android.pages.LoginPage;
import com.android.util.PropertyLoader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(com.android.util.ScreenshotTaker.class)
public class LogoutTest extends BaseTest{

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String labelSettings = PropertyLoader.loadProperty(commonPropertyPath, "labelSettings");

    @BeforeClass
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
    }

    @Test(priority = 1)
    public void logOutCancel() {
        BasePage.clickLeftMenu();
        LeftMenuPage.clickSignOut();
        LeftMenuPage.alertCancel();
        assertTrue(LeftMenuPage.checkSearch());
    }

    @Test(priority = 2)
    public void logOut() {
        LeftMenuPage.clickSignOut();
        LeftMenuPage.alertConfirm();
        assertTrue(LoginPage.checkLoginButton());
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
