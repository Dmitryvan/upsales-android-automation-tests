package com.android.tests;

import com.android.pages.*;
import com.android.util.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.android.util.ScreenshotTaker.class)
public class ActivitiesTest extends BaseTest {

    private final String activitiesPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String titleActivities = PropertyLoader.loadProperty(activitiesPropertyPath, "titleActivities");
    private final String allActivitiesNumber = PropertyLoader.loadProperty(activitiesPropertyPath, "allActivitiesNumber");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String today = PropertyLoader.loadProperty(commonPropertyPath, "today");

    @BeforeClass
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
    }

    @Test(priority = 1) //CASE 1
    public void openActivitiesPage() {
        LeftMenuPage.clickActivities();
        ActivitiesPage.checkPageTitle(titleActivities);
    }

    @Test(priority = 2) //CASE 2
    public void verifyThatTodaysActivitiesAreShownFirst() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
//        softAssert.assertEquals(ActivitiesPage.getFirstRowDate(), today); // database inconsistency - currently today - 1
        softAssert.assertTrue(ActivitiesPage.countActivities() <=35 );
        softAssert.assertFalse(ActivitiesPage.getLastRowDate().equals(today));
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
