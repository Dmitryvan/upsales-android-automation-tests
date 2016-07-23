package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.*;

import static org.testng.Assert.*;

@Listeners(com.android.util.ScreenshotTaker.class)
public class SalesPipelineTest extends BaseTest {

    private final String salesPropertyPath = "src/test/resources/sales.properties";
    private final String startOrdersCount = PropertyLoader.loadProperty(salesPropertyPath, "startOrdersCount");
    private final String endOrdersCount = PropertyLoader.loadProperty(salesPropertyPath, "endOrdersCount");
    private final String startAverageValue = PropertyLoader.loadProperty(salesPropertyPath, "startAverageValue");
    private final String endAverageValue = PropertyLoader.loadProperty(salesPropertyPath, "endAverageValue");
    private final String startSalesPerUserCount = PropertyLoader.loadProperty(salesPropertyPath, "startSalesPerUserCount");
    private final String endSalesPerUserCount = PropertyLoader.loadProperty(salesPropertyPath, "endSalesPerUserCount");
    private final String startSumOfFirstUser = PropertyLoader.loadProperty(salesPropertyPath, "startSumOfFirstUser");
    private final String endSumOfFirstUser = PropertyLoader.loadProperty(salesPropertyPath, "endSumOfFirstUser");
    private final String startSumOfLisaSales = PropertyLoader.loadProperty(salesPropertyPath, "startSumOfLisaSales");
    private final String endSumOfLisaSales = PropertyLoader.loadProperty(salesPropertyPath, "endSumOfLisaSales");
    private final String startTotalSalesValue = PropertyLoader.loadProperty(salesPropertyPath, "startTotalSalesValue");
    private final String endTotalSalesValue = PropertyLoader.loadProperty(salesPropertyPath, "endTotalSalesValue");
    private final String visibleOrdersSum = PropertyLoader.loadProperty(salesPropertyPath, "visibleOrdersSum");

    private final String pipelinePropertyPath = "src/test/resources/pipeline.properties";
    private final String titlePipeline = PropertyLoader.loadProperty(pipelinePropertyPath, "title");
    private final String startTotalPipelineValue = PropertyLoader.loadProperty(pipelinePropertyPath, "startTotalPipelineValue");
    private final String endTotalPipelineValue = PropertyLoader.loadProperty(pipelinePropertyPath, "endTotalPipelineValue");
    private final String startWeightedWidgetValue = PropertyLoader.loadProperty(pipelinePropertyPath, "startWeightedWidgetValue");
    private final String endWeightedWidgetValue = PropertyLoader.loadProperty(pipelinePropertyPath, "endWeightedWidgetValue");
    private final String startAverageWidgetValue = PropertyLoader.loadProperty(pipelinePropertyPath, "startAverageWidgetValue");
    private final String endAverageWidgetValue = PropertyLoader.loadProperty(pipelinePropertyPath, "endAverageWidgetValue");
    private final String stagesRows = PropertyLoader.loadProperty(pipelinePropertyPath, "stagesRows");
    private final String startProspect1Sum = PropertyLoader.loadProperty(pipelinePropertyPath, "startProspect1Sum");
    private final String endProspect1Sum = PropertyLoader.loadProperty(pipelinePropertyPath, "endProspect1Sum");
    private final String startFallbackSum = PropertyLoader.loadProperty(pipelinePropertyPath, "startFallbackSum");
    private final String endFallbackSum = PropertyLoader.loadProperty(pipelinePropertyPath, "endFallbackSum");

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String labelAll = PropertyLoader.loadProperty(filterPropertyPath, "labelAll");
    private final String dateCurrentMonth = PropertyLoader.loadProperty(filterPropertyPath, "dateCurrentMonth");

    @BeforeMethod
    public void setUp () throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        LeftMenuPage.clickSales();
    }

    @Test(priority = 1, enabled = false) //CASE 4 + CASE 2 obsolete
    public void softWidgetSalesVerification() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        Float totalSalesValue = SalesPage.getSEKNumericValueWithM();
        Integer orders = SalesPage.getLabelOrdersNumericValue();
        Integer average = SalesPage.getAverageValueNumeric();
        softAssert.assertTrue(totalSalesValue >= Float.parseFloat(startTotalSalesValue) && totalSalesValue <= Float.parseFloat(endTotalSalesValue));
        softAssert.assertTrue(orders >= Integer.parseInt(startOrdersCount) && orders <= Integer.parseInt(endOrdersCount));
        softAssert.assertTrue(average >= Integer.parseInt(startAverageValue) && average <= Integer.parseInt(endAverageValue));
        softAssert.assertAll();
    }

    @Test(priority = 2) //CASE 3
    public void softSalesPerUserVerification() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        softAssert.assertEquals(SalesPage.getSalesPerUserCountCells(), 8);
        SalesPage.verifySumForEachUser();
        softAssert.assertAll();
    }

    @Test(priority = 3) // Case 4
    public void softSalesFilterNavigateAndVerification() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        SalesPage.clickFilter();
        softAssert.assertTrue(FilterPage.checkFilter());
        softAssert.assertEquals(FilterPage.getCurrentUserLabelValue(), labelAll);
        softAssert.assertEquals(FilterPage.getCurrentDatePeriodValue(), dateCurrentMonth);
        softAssert.assertEquals(FilterPage.getCurrentStagesValue(), labelAll);
        FilterPage.clickClose();
        softAssert.assertFalse(FilterPage.checkFilter());
        softAssert.assertAll();

    }

    @Test(priority = 4, enabled = false) //CASE 6 obsolete
    public void softSalesPerUserNavigation() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        SalesPage.clickFirstUserInSalesTable();
        softAssert.assertTrue(SalesPage.countVisibleOrders() >= Integer.parseInt(visibleOrdersSum));
        softAssert.assertTrue(SalesPage.checkFirstUserSum());
        softAssert.assertAll();
    }

    @Test(priority = 5) //CASE 5
    public void softPipelineNavigation() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        SalesPage.clickTabPipeline();
        PipelinePage.checkPageTitle(titlePipeline);
        softAssert.assertAll();
    }

    @Test(priority = 6, enabled = false) //CASE 8 + CASE 7 obsolete
    public void softWidgetPipelineVerification() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        Float totalPipeline = PipelinePage.getTotalPipelineValue();
        Float weightedValue = PipelinePage.getWeightedWidgetValue();
        Integer average = PipelinePage.getAverageWidgetValue();
        softAssert.assertTrue(totalPipeline >= Float.parseFloat(startTotalPipelineValue) && totalPipeline <= Float.parseFloat(endTotalPipelineValue));
        softAssert.assertTrue(weightedValue >= Float.parseFloat(startWeightedWidgetValue) && weightedValue <= Float.parseFloat(endWeightedWidgetValue));
        softAssert.assertTrue(average >= Integer.parseInt(startAverageWidgetValue) && average <= Integer.parseInt(endAverageWidgetValue));
        softAssert.assertAll();
    }

    @Test(priority = 7) //CASE 9
    public void softOpportunitiesPerStageVerification() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        SalesPage.clickTabPipeline();
        softAssert.assertEquals(PipelinePage.getTableStagesSize(), Integer.parseInt(stagesRows));
        Float sumProspect1 = PipelinePage.getProspect1SumValue();
        Integer sumFallback = PipelinePage.getFallbackSumValue();
        softAssert.assertTrue(sumProspect1 >= Float.parseFloat(startProspect1Sum) && sumProspect1 <= Float.parseFloat(endProspect1Sum));
        softAssert.assertTrue(sumFallback >= Integer.parseInt(startFallbackSum) && sumFallback <= Integer.parseInt(endFallbackSum));
        softAssert.assertAll();
    }

    @Test(priority = 8, enabled = false) //CASE 10 obsolete
    public void softOpportunitiesPerStageNavigation() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        PipelinePage.clickProspect1();
        softAssert.assertTrue(PipelinePage.checkProspect1Sum());
        softAssert.assertAll();
    }

    @Test(priority = 9) //CASE 8
    public void softFilterNavigateAndVerify() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        SalesPage.clickTabPipeline();
        PipelinePage.clickFilter();
        softAssert.assertEquals(FilterPage.getCurrentUserLabelValue(), labelAll);
        softAssert.assertEquals(FilterPage.getCurrentDatePeriodValue(), dateCurrentMonth);
        softAssert.assertEquals(FilterPage.getCurrentStagesValue(), labelAll);
        FilterPage.clickClose();
        softAssert.assertFalse(FilterPage.checkFilter());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
