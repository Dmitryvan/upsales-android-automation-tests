package com.android.tests;

import com.android.pages.*;
import com.android.util.Helpers;
import com.android.util.PropertyLoader;
import com.android.util.SoftAssertExtended;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.android.util.ScreenshotTaker.class)
public class SalesOpportunityTransformationTest extends BaseTest {

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String testAccount = PropertyLoader.loadProperty(commonPropertyPath, "testAccount");
    private final String opportunityTitle = PropertyLoader.loadProperty(commonPropertyPath, "labelOpportunity");
    private final String titleAccount = PropertyLoader.loadProperty(commonPropertyPath, "labelAccount");

    private final String orderPropertyPath = "src/test/resources/opportunity.properties";
    private final String titleOrders = PropertyLoader.loadProperty(orderPropertyPath, "titleOrders");
    private final String zeroStage = PropertyLoader.loadProperty(orderPropertyPath, "zeroStage");
    private final String titleOpps = PropertyLoader.loadProperty(orderPropertyPath, "titleOpps");
    private final String orderStage = PropertyLoader.loadProperty(orderPropertyPath, "newOrderStage");
    private final String titleOrder2 = PropertyLoader.loadProperty(orderPropertyPath, "titleOrder2");
    private final String orderStage2 = PropertyLoader.loadProperty(orderPropertyPath, "orderStage");
    private final String titleOrder = PropertyLoader.loadProperty(orderPropertyPath, "titleOrder");

    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(testAccount);
        SearchPage.clickOnFirstSearchResult();

    }

    @Test(priority = 1) //CASE 1
    public void softSalesTransformationToOpportunity() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountPage.clickTabSales();
        softAssert.assertEquals(OrdersPage.getSubTitle() + " " + OrdersPage.getTitle(),
                testAccount + " Sales");
        String orderName = OrdersPage.getFirstOppName();
        OrdersPage.clickFirstOppCell();
        OpportunityPage.clickStage();
        OpportunityPage.selectValueFromPopUp(zeroStage);
        Thread.sleep(2000);
        softAssert.assertEquals(OpportunityPage.getTitleOnView(), opportunityTitle.toUpperCase());
        softAssert.assertEquals(OpportunityPage.getAccount(), testAccount);
        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), orderName);
        softAssert.assertAll();
    }

    @Test(priority = 2) //CASE 3
    public void softOpportunityTransformationToSales() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountPage.clickTabOpportunities();
        softAssert.assertEquals(OrdersPage.getSubTitle() + " " + OrdersPage.getTitle(),
                testAccount + " Opportunities");
        String oppName = OpportunitiesPage.getFirstOppName();
        OpportunitiesPage.clickFirstOppCell();
        OpportunityPage.clickStage();
        OpportunityPage.selectValueFromPopUp(orderStage);
        Thread.sleep(2000);
        softAssert.assertEquals(OpportunityPage.getOrderName(), oppName);
        softAssert.assertEquals(OpportunityPage.getAccount(), testAccount);
        softAssert.assertEquals(OpportunityPage.getTitleOnView(), titleOrder2.toUpperCase());
        softAssert.assertAll();
    }

    @Test(priority = 3) // CASE 2
    public void softSalesTransformationToOpportunityAndCheckAccountPage() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountPage.clickTabOpportunities();
        int startOpp = OpportunitiesPage.countOpportunities();
        OpportunityPage.clickBack();
        AccountPage.clickTabSales();
        OrdersPage.clickFirstOppCell();
        OpportunityPage.clickStage();
        OpportunityPage.selectValueFromPopUp(zeroStage);
        Thread.sleep(2000);
        OpportunityPage.clickBack();
//        softAssert.assertEquals(SalesPage.getSubTitle() + " " + SalesPage.getTitle(),
//                testAccount + " Sales");
        AccountPage.clickTabOpportunities();
        softAssert.assertTrue(OpportunitiesPage.countOpportunities() > startOpp);
        softAssert.assertAll();
    }

    @Test(priority = 4) //CASE 4
    public void softOpportunityTransformationToSales2() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountPage.clickTabOpportunities();
        String oppName = OpportunitiesPage.getFirstOppName();
        OpportunitiesPage.clickFirstOppCell();
        OpportunityPage.clickStage();
        OpportunityPage.selectValueFromPopUp(orderStage2);
        Thread.sleep(2000);
        softAssert.assertEquals(OpportunityPage.getOrderName(), oppName);
        softAssert.assertEquals(OpportunityPage.getAccount(), testAccount);
        OpportunityPage.checkPageTitle(titleOrder.toUpperCase());
        softAssert.assertAll();
    }

    @Test(priority = 5) //CASE 5
    public void softOpportunityTransformationToSalesAndCheckAccountPage() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountPage.clickTabSales();
        int startSales = OrdersPage.countOpportunities();
        OrdersPage.clickBack();
        AccountPage.clickTabOpportunities();
        OpportunitiesPage.clickFirstOppCell();
        OpportunityPage.clickStage();
        OpportunityPage.selectValueFromPopUp(orderStage2);
        Thread.sleep(2000);
        OpportunityPage.clickBack();
//        softAssert.assertEquals(OpportunitiesPage.getSubTitle() + " " + OpportunitiesPage.getTitle(),
//                testAccount + " Opportunities");
        AccountPage.clickTabSales();
        softAssert.assertTrue(OrdersPage.countOpportunities() > startSales);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
