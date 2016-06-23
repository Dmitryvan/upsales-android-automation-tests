package com.android.tests;

import com.android.pages.*;
import com.android.util.PropertyLoader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.android.util.ScreenshotTaker.class)
public class PipelineTest extends BaseTest {

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String salesPropertyPath = "src/test/resources/sales.properties";
    private final String pipelinePropertyPath = "src/test/resources/pipeline.properties";

    private final String titleSales = PropertyLoader.loadProperty(salesPropertyPath, "title");
    private final String titlePipeline = PropertyLoader.loadProperty(pipelinePropertyPath, "title");
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    @BeforeClass
    public void setUp () throws Exception{
        super.setUp();
        LoginPage.login();
    }

    @Test
    public void switchFromPipelineToSales() {
        DashboardPage.clickLabelPipeline();
        DashboardPage.checkPageTitle(titleDashboard);
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
