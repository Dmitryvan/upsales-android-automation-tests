package com.android.tests;

import com.android.pages.*;
import com.android.util.Helpers;
import com.android.util.PropertyLoader;
import com.android.util.SoftAssertExtended;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(com.android.util.ScreenshotTaker.class)
public class DashboardTest extends BaseTest {

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String title = PropertyLoader.loadProperty(dashboardPropertyPath, "title");
    private final String sales = PropertyLoader.loadProperty(dashboardPropertyPath, "sales");
    private final String pipeline = PropertyLoader.loadProperty(dashboardPropertyPath, "pipeline");
    private final String showMore = PropertyLoader.loadProperty(dashboardPropertyPath, "showMore");
    private final String startMonthSales = PropertyLoader.loadProperty(dashboardPropertyPath, "startMonthSales");
    private final String endMonthSales = PropertyLoader.loadProperty(dashboardPropertyPath, "endMonthSales");
    private final String startMonthPipeline = PropertyLoader.loadProperty(dashboardPropertyPath, "startMonthPipeline");
    private final String endMonthPipeline = PropertyLoader.loadProperty(dashboardPropertyPath, "endMonthPipeline");
    private final String startQuarterSales = PropertyLoader.loadProperty(dashboardPropertyPath, "startQuarterSales");
    private final String endQuarterSales = PropertyLoader.loadProperty(dashboardPropertyPath, "endQuarterSales");
    private final String startQuarterPipeline = PropertyLoader.loadProperty(dashboardPropertyPath, "startQuarterPipeline");
    private final String endQuarterPipeline = PropertyLoader.loadProperty(dashboardPropertyPath, "endQuarterPipeline");
    private final String startYearSales = PropertyLoader.loadProperty(dashboardPropertyPath, "startYearSales");
    private final String endYearSales = PropertyLoader.loadProperty(dashboardPropertyPath, "endYearSales");
    private final String startYearPipeline = PropertyLoader.loadProperty(dashboardPropertyPath, "startYearPipeline");
    private final String endYearPipeline = PropertyLoader.loadProperty(dashboardPropertyPath, "endYearPipeline");
    private final String labelShowAllActivities = PropertyLoader.loadProperty(dashboardPropertyPath, "labelShowAllActivities");

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String usersAll = PropertyLoader.loadProperty(filterPropertyPath, "labelAll");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String today = PropertyLoader.loadProperty(commonPropertyPath, "today");

    private final String activitiesPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String editActivity = PropertyLoader.loadProperty(activitiesPropertyPath, "editActivity");

    private final String createAppointmentPropertyPath = "src/test/resources/createEditAppointment.properties";
    private final String editAppointment = PropertyLoader.loadProperty(createAppointmentPropertyPath, "editAppointment");


    @BeforeClass
    public void setUp () throws Exception{
        super.setUp();
        LoginPage.login();
    }

    @Test(priority = 1) //CASE 1
    public void softLoginAndDashboardOpens() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        DashboardPage.checkPageTitle(title);
        softAssert.assertEquals(sales, DashboardPage.getLabelSales());
        softAssert.assertEquals(pipeline, DashboardPage.getLabelPipeline());
        softAssert.assertEquals(showMore, DashboardPage.getLabelShowMore());
        softAssert.assertAll();
    }

    @Test(priority = 2) //CASE 5
    public void filterNavigateAndVerification() {
        DashboardPage.clickFilter();
        assertEquals(FilterPage.getCurrentUserLabelValue(), usersAll);
        FilterPage.clickUsers();
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), usersAll);
        FilterPage.clickClose();
        DashboardPage.checkPageTitle(title);
    }

    @Test(priority = 3) //CASE 2
    public void softSalesAndPipelineWidgetVerification() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        softAssert.assertEquals(DashboardPage.getCurrentMonth().toUpperCase(), DashboardPage.getLabelMonth());
        softAssert.assertTrue(DashboardPage.checkSalesWidget());
        softAssert.assertTrue(DashboardPage.checkPipelineWidget());
        DashboardPage.swipeLeft();
        softAssert.assertEquals(DashboardPage.getCurrentQuarter(), DashboardPage.getLabelQuarter());
        softAssert.assertTrue(DashboardPage.checkSalesWidget());
        softAssert.assertTrue(DashboardPage.checkPipelineWidget());
        DashboardPage.swipeLeft();
        softAssert.assertEquals(DashboardPage.getCurrentYear(), DashboardPage.getLabelYear());
        softAssert.assertTrue(DashboardPage.checkSalesWidget());
        softAssert.assertTrue(DashboardPage.checkPipelineWidget());
//        Float salesValue = DashboardPage.getSalesValue();
//        Float pipelineValue = DashboardPage.getPipelineValue();
//        softAssert.assertTrue(salesValue >= Float.parseFloat(startMonthSales) && salesValue <= Float.parseFloat(endMonthSales));
//        softAssert.assertTrue(pipelineValue >= Float.parseFloat(startMonthPipeline) && pipelineValue <= Float.parseFloat(endMonthPipeline));
        softAssert.assertAll();
    }

    @Test(priority = 4) //CASE 3
    public void softMyAppointmentsTodayVerification() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        softAssert.assertTrue(DashboardPage.checkAllAppointmentsAreForToday(today));
        int appCount = DashboardPage.getMyAppointmentsTodayCount();
        softAssert.assertEquals(DashboardPage.getLastAppType(appCount), editAppointment);
        AppointmentPage.closePopUp();
        AppointmentPage.clickBack();
        softAssert.assertEquals(DashboardPage.getFirstActivityType(appCount), editActivity);
        ActivityPage.closePopUp();
        ActivityPage.clickBack();
        softAssert.assertAll();
    }

    @Test(priority = 5) //CASE 4
    public void softMyOpenActivitiesVerification() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        Helpers.scrollToLabel(labelShowAllActivities);
        softAssert.assertTrue(DashboardPage.checkShowAllActivitiesVisibility());
        softAssert.assertEquals(DashboardPage.getLabelShowAllActivities(), labelShowAllActivities);
        softAssert.assertAll();
    }

//    @Test(priority = 4) //CASE 6
//    public void softSalesAndPipelineWidgetNavigation() {
//        SoftAssertExtended softAssert = new SoftAssertExtended();
//        DashboardPage.swipeLeft();
//        softAssert.assertEquals(DashboardPage.getCurrentQuarter(), DashboardPage.getLabelQuarter());
//        Float salesValue = DashboardPage.getSalesValue();
//        Float pipelineValue = DashboardPage.getPipelineValue();
//        softAssert.assertTrue(salesValue >= 2.4 && salesValue <= 5.0);
//        softAssert.assertTrue(pipelineValue >= Float.parseFloat(startQuarterPipeline) && pipelineValue <= Float.parseFloat(endQuarterPipeline));
//        DashboardPage.swipeLeft();
//        softAssert.assertEquals(DashboardPage.getCurrentYear(), DashboardPage.getLabelYear());
//        salesValue = DashboardPage.getSalesValue();
//        pipelineValue = DashboardPage.getPipelineValue();
//        softAssert.assertTrue(salesValue >= Float.parseFloat(startYearSales) && salesValue <= Float.parseFloat(endYearSales));
//        softAssert.assertTrue(pipelineValue >= Float.parseFloat(startYearPipeline) && pipelineValue <= Float.parseFloat(endYearPipeline));
//        softAssert.assertAll();
//    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
