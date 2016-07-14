package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners(com.android.util.ScreenshotTaker.class)
public class LeftMenuTest extends BaseTest {

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String salesPropertyPath = "src/test/resources/sales.properties";
    private final String pipelinePropertyPath = "src/test/resources/pipeline.properties";
    private final String activitiesPropertyPath = "src/test/resources/createEditActivity.properties";

    private final String titleSales = PropertyLoader.loadProperty(salesPropertyPath, "title");
    private final String titlePipeline = PropertyLoader.loadProperty(pipelinePropertyPath, "title");
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");
    private final String titleActivities = PropertyLoader.loadProperty(activitiesPropertyPath, "titleActivities");

    private final String createMenuPropertyPath = "src/test/resources/createMenu.properties";
    private final String labelHeader = PropertyLoader.loadProperty(createMenuPropertyPath, "labelHeader");
    private final String labelActivity = PropertyLoader.loadProperty(createMenuPropertyPath, "labelActivity");
    private final String labelOrder = PropertyLoader.loadProperty(createMenuPropertyPath, "labelOrder");
    private final String labelAppointment = PropertyLoader.loadProperty(createMenuPropertyPath, "labelAppointment");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String labelAccount = PropertyLoader.loadProperty(commonPropertyPath, "labelAccount");
    private final String labelOpportunity = PropertyLoader.loadProperty(commonPropertyPath, "labelOpportunity");
    private final String labelContact = PropertyLoader.loadProperty(commonPropertyPath, "labelContact");

    @BeforeClass
    public void setUp () throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
    }

    @Test(priority = 1)
    public void switchToDashboard() {
        LeftMenuPage.clickDashboard();
        DashboardPage.checkPageTitle(titleDashboard);
        BasePage.clickLeftMenu();
        assertTrue(LeftMenuPage.checkSearch());
    }

    @Test(priority = 2)
    public void switchToCalendar() {
        LeftMenuPage.clickCalendar();
        assertTrue(CalendarPage.checkButtonCalendarView());
        CalendarPage.clickCalendarView();
        BasePage.clickLeftMenu();
        assertTrue(LeftMenuPage.checkSearch());
    }

    @Test(priority = 3)
    public void switchToActivities() {
        LeftMenuPage.clickActivities();
        ActivitiesPage.checkPageTitle(titleActivities);
        BasePage.clickLeftMenu();
        assertTrue(LeftMenuPage.checkSearch());
    }

    @Test(priority = 4)
    public void switchToSales() {
        LeftMenuPage.clickSales();
        SalesPage.checkPageTitle(titleSales);
        BasePage.clickLeftMenu();
        assertTrue(LeftMenuPage.checkSearch());
    }

    @Test(priority = 5)
    public void switchToPipeline() {
        LeftMenuPage.clickPipeline();
        PipelinePage.checkPageTitle(titlePipeline);
        BasePage.clickLeftMenu();
        assertTrue(LeftMenuPage.checkSearch());
    }

    @Test(priority = 6)
    public void softPopoverListOfCreateButtonInTheSideMenu() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        LeftMenuPage.clickCreate();
        softAssert.assertEquals(labelHeader, CreateMenuPage.getLabelHeader());
        softAssert.assertEquals(labelActivity, CreateMenuPage.getLabelActivity());
        softAssert.assertEquals(labelAppointment, CreateMenuPage.getLabelAppointment());
        softAssert.assertEquals(labelOpportunity, CreateMenuPage.getLabelOpportunity());
        softAssert.assertEquals(labelOrder, CreateMenuPage.getLabelOrder());
        softAssert.assertEquals(labelContact, CreateMenuPage.getLabelContact());
        softAssert.assertEquals(labelAccount, CreateMenuPage.getLabelAccount());
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
