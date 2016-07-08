package com.android.tests;

import com.android.pages.*;
import com.android.util.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.android.util.ScreenshotTaker.class)
public class SalesPipelineNavigationTest extends BaseTest {

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    private final String salesPropertyPath = "src/test/resources/sales.properties";
    private final String titleSales = PropertyLoader.loadProperty(salesPropertyPath, "title");
    private final String labelSalesTotal = PropertyLoader.loadProperty(salesPropertyPath, "salesTotal");
    private final String labelSalesOnDiagram = PropertyLoader.loadProperty(salesPropertyPath, "salesOnDiagram");
    private final String labelQuotaLeftOnDiagram = PropertyLoader.loadProperty(salesPropertyPath, "quotaLeftOnDiagram");
    private final String labelSalesTab = PropertyLoader.loadProperty(salesPropertyPath, "tabSales");
    private final String labelPipelineTab = PropertyLoader.loadProperty(salesPropertyPath, "tabPipeline");

    private final String pipelinePropertyPath = "src/test/resources/pipeline.properties";
    private final String titlePipeline = PropertyLoader.loadProperty(pipelinePropertyPath, "title");

    @BeforeMethod
    public void setUp () throws Exception{
        super.setUp();
        LoginPage.login();
    }

    @Test
    public void switchFromPipelineToSales() {
        DashboardPage.clickLabelPipeline();
        PipelinePage.checkPageTitle(titlePipeline);
        PipelinePage.clickTabSales();
        SalesPage.checkPageTitle(titleSales);
        SalesPage.clickBack();
        DashboardPage.checkPageTitle(titleDashboard);
    }

    @Test
    public void switchFromSalesToPipelineTest() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        DashboardPage.clickLabelSales();
        SalesPage.checkPageTitle(titleSales);
        softAssert.assertEquals(labelSalesTotal, SalesPage.getLabelSalesTotal());
        softAssert.assertEquals(labelSalesOnDiagram, SalesPage.getLabelSalesOnDiagram());
        softAssert.assertEquals(labelQuotaLeftOnDiagram, SalesPage.getLabelQuotaLeftOnDiagram());
        softAssert.assertEquals(labelSalesTab, SalesPage.getLabelSalesTab());
        softAssert.assertEquals(labelPipelineTab, SalesPage.getLabelPipelineTab());
        SalesPage.clickTabPipeline();
        PipelinePage.checkPageTitle(titlePipeline);
        PipelinePage.clickBack();
        DashboardPage.checkPageTitle(titleDashboard);
        softAssert.assertAll();
    }

    @Test
    public void showMoreTest() {
        DashboardPage.clickShowMore();
        SalesPage.checkPageTitle(titleSales);
        SalesPage.clickTabPipeline();
        PipelinePage.checkPageTitle(titlePipeline);
        BasePage.clickBack();
        DashboardPage.checkPageTitle(titleDashboard);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
