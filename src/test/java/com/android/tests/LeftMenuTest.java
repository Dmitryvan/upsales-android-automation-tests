package com.android.tests;//package com.ios.tests;
//
//import com.ios.pages.BasePage;
//import com.ios.pages.CalendarPage;
//import com.ios.pages.LeftMenuPage;
//import com.ios.util.Helpers;
//import org.testng.annotations.*;
//
//import static org.junit.Assert.assertTrue;
//
//@Listeners(com.ios.util.ScreenshotTaker.class)
//public class LeftMenuTest extends BaseTest {
//
//    @BeforeMethod
//    public void setUp () throws Exception{
//        super.setUp();
//        Helpers.login();
//    }
//
//    @Test
//    public void switchToDashboard() {
//        BasePage.clickLeftMenu();
//        LeftMenuPage.clickDashboard();
//        Helpers.checkPageLabel("Dashboard");
//        BasePage.clickLeftMenu();
//        assertTrue(LeftMenuPage.isSearch());
//    }
//
//    @Test
//    public void switchToCalendar() {
//        BasePage.clickLeftMenu();
//        LeftMenuPage.clickCalendar();
//        assertTrue(CalendarPage.isCalendarView());
//        CalendarPage.clickCalendarView();
//        BasePage.clickLeftMenu();
//        assertTrue(LeftMenuPage.isSearch());
//    }
//
//    @Test
//    public void switchToActivities() {
//        BasePage.clickLeftMenu();
//        LeftMenuPage.clickActivities();
//        Helpers.checkPageLabel("Activities");
//        BasePage.clickLeftMenu();
//        assertTrue(LeftMenuPage.isSearch());
//    }
//
//    @Test
//    public void switchToSales() {
//        BasePage.clickLeftMenu();
//        LeftMenuPage.clickSales();
//        Helpers.checkPageLabel("Sales");
//        BasePage.clickLeftMenu();
//        assertTrue(LeftMenuPage.isSearch());
//    }
//
//    @Test
//    public void switchToPipeline() {
//        BasePage.clickLeftMenu();
//        LeftMenuPage.clickPipeline();
//        Helpers.checkPageLabel("Pipeline");
//        BasePage.clickLeftMenu();
//        assertTrue(LeftMenuPage.isSearch());
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//}
