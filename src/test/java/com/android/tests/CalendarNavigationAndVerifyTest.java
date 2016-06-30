package com.android.tests;

import com.android.pages.*;
import com.android.util.PropertyLoader;
import com.android.util.SoftAssertExtended;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners(com.android.util.ScreenshotTaker.class)
public class CalendarNavigationAndVerifyTest extends BaseTest {

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String labelAll = PropertyLoader.loadProperty(filterPropertyPath, "labelAll");
    private final String user = PropertyLoader.loadProperty(filterPropertyPath, "currentUser");
    private final int cellsOnScreen = 10;

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        LoginPage.login();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickCalendar();
    }

    @Test // Case 1
    public void loginAndOpenCalendarPage() {
        assertFalse(LeftMenuPage.checkSearch());
    }

    @Test // Case 2
    public void verifyTodayAppointmentsAreShownFirst() {
//        assertTrue(CalendarPage.checkTodayLabel());
        assertTrue(CalendarPage.checkVisibleCellsCount() <= cellsOnScreen);
    }

    @Test // Case 3
    public void filterNavigateAndVerification() {
        CalendarPage.clickFilter();
        assertEquals(FilterPage.getCurrentUserLabelValue(), user);
        assertEquals(FilterPage.getCurrentAppointmentsTypeLabelValue(), labelAll);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
    }

    @Test // Case 4
    public void softNavigateToCalendarViewAndVerify() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        softAssert.assertFalse(CalendarPage.checkCalendarView());
        CalendarPage.clickCalendarView();
        softAssert.assertTrue(CalendarPage.checkCalendarView());
        softAssert.assertTrue(CalendarPage.checkTodayLabel());
        softAssert.assertTrue(CalendarPage.checkVisibleCellsCount() <= cellsOnScreen);
        softAssert.assertAll();
    }

    @Test // Case 5
    public void calendarSwipe() throws InterruptedException {
        CalendarPage.clickCalendarView();
        assertTrue(CalendarPage.checkCalendarView());
        CalendarPage.swipeRight();
        assertEquals(CalendarPage.getPreviousMonth(), CalendarPage.getMonthOnCalendar());
        CalendarPage.swipeLeft();
        CalendarPage.swipeLeft();
        assertEquals(CalendarPage.getNextMonth(), CalendarPage.getMonthOnCalendar());
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
