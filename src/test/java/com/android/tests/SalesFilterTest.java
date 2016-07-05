package com.android.tests;

import com.android.pages.*;
import com.android.util.PropertyLoader;
import com.android.util.SoftAssertExtended;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Listeners(com.android.util.ScreenshotTaker.class)
public class SalesFilterTest extends BaseTest {

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String labelAll = PropertyLoader.loadProperty(filterPropertyPath, "labelAll");
    private final String dateCurrentMonth = PropertyLoader.loadProperty(filterPropertyPath, "dateCurrentMonth");
    private final String dateCurrentYear = PropertyLoader.loadProperty(filterPropertyPath, "dateCurrentYear");
    private final String user1 = PropertyLoader.loadProperty(filterPropertyPath, "user1");
    private final String currentUser = PropertyLoader.loadProperty(filterPropertyPath, "currentUser");


    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        LoginPage.login();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickSales();
        SalesPage.clickFilter();
    }

    @Test(priority = 1) // Case 2
    public void setUserFilter() {
        FilterPage.clickUsers();
        FilterPage.select(currentUser);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
    }

    @Test(priority = 2) // Case 3
    public void softVerifySalesValuesAfterFilterSet() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        FilterPage.clickUsers();
        FilterPage.select(currentUser);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        FilterPage.clickClose();
        float salesTotalSum = SalesPage.getSEKNumericValueWithM();
        softAssert.assertTrue(salesTotalSum >= 1.3 && salesTotalSum <= 1.8);
        softAssert.assertEquals(SalesPage.getSalesPerUserCountCells(), 1);
        int orders = SalesPage.getLabelOrdersNumericValue();
        softAssert.assertTrue(orders >= 5 && orders <= 9);
        int average = SalesPage.getAverageValueNumeric();
        softAssert.assertTrue(average >= 190000 && average <= 250000);
        softAssert.assertAll();
    }

    @Test(priority = 3) // Case 4
    public void verifyPipelineValuesAfterFilterSet() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        FilterPage.clickUsers();
        FilterPage.select(currentUser);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
        SalesPage.clickTabPipeline();
        float pipelineTotalSum = PipelinePage.getTotalPipelineValue();
        softAssert.assertTrue(pipelineTotalSum >= 1.5 && pipelineTotalSum <= 2);
        float weighted = PipelinePage.getWeightedWidgetValue();
        softAssert.assertTrue(weighted >= 600000 && weighted <= 10000000);
        float average = PipelinePage.getAverageWidgetValue();
        softAssert.assertTrue(average >= 50000 && average <= 80000);
        float prospect1 = PipelinePage.getProspect1SumValue();
        softAssert.assertTrue(prospect1 >= 700000 && prospect1 <= 900000);
        float fallback = PipelinePage.getFallbackSumValue();
        softAssert.assertTrue(fallback >= 0 && fallback <= 12000);
        softAssert.assertAll();
    }

    @Test
    public void selectUser() {
        FilterPage.clickUsers();
        FilterPage.select(user1);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), user1);
        assertEquals(FilterPage.getCurrentDatePeriodValue(), dateCurrentMonth);
        assertEquals(FilterPage.getCurrentStagesValue(), labelAll);
        FilterPage.clickClose();
        SalesPage.checkTableContainsOnly(user1);
        SalesPage.clickFirstUserInSalesTable();
//        assertTrue(SalesPage.checkTotalSales());
        assertEquals(SalesPage.getOrdersTableCount(), SalesPage.getLabelOrdersNumericValue());
        assertEquals(SalesPage.getAverageValueNumeric(), SalesPage.countAverageValue());
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
