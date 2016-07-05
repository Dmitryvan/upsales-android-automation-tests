package com.android.tests;

import com.android.pages.*;
import com.android.util.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Listeners(com.android.util.ScreenshotTaker.class)
public class ActivitiesTest extends BaseTest {

    private final String activitiesPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String titleActivities = PropertyLoader.loadProperty(activitiesPropertyPath, "titleActivities");
    private final String allActivitiesNumber = PropertyLoader.loadProperty(activitiesPropertyPath, "allActivitiesNumber");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String today = PropertyLoader.loadProperty(commonPropertyPath, "today");

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String currentUser = PropertyLoader.loadProperty(filterPropertyPath, "currentUser");
    private final String all = PropertyLoader.loadProperty(filterPropertyPath, "labelAll");
    private final String dateToday = PropertyLoader.loadProperty(filterPropertyPath, "dateToday");


    @BeforeClass
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        LeftMenuPage.clickActivities();
    }

    @Test(priority = 1) //CASE 1
    public void openActivitiesPage() {
        ActivitiesPage.checkPageTitle(titleActivities);
    }

    @Test(priority = 2) //CASE 2
    public void verifyThatTodaysActivitiesAreShownFirst() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
//        softAssert.assertEquals(ActivitiesPage.getFirstRowDate(), today); // database inconsistency - currently today - 1
        softAssert.assertTrue(ActivitiesPage.countActivities() <= 35 );
        softAssert.assertFalse(ActivitiesPage.getLastRowDate().equals(today));
        softAssert.assertAll();
    }

    @Test(priority = 3) //CASE 3
    public void softCheckDefaultFilterValues() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ActivitiesPage.clickFilter();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), all);
        assertEquals(FilterPage.getCurrentDateValue(), dateToday);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
