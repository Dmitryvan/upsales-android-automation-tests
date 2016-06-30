package com.android.tests;

import com.android.pages.*;
import com.android.util.PropertyLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners(com.android.util.ScreenshotTaker.class)
public class CalendarFilterTest extends BaseTest {

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String usersAll = PropertyLoader.loadProperty(filterPropertyPath, "labelAll");
    private final String user1= PropertyLoader.loadProperty(filterPropertyPath, "user1");
    private final String user2= PropertyLoader.loadProperty(filterPropertyPath, "user2");
    private final String user3= PropertyLoader.loadProperty(filterPropertyPath, "user3");
    private final String user4= PropertyLoader.loadProperty(filterPropertyPath, "user4");
    private final String user5= PropertyLoader.loadProperty(filterPropertyPath, "user5");
    private final String currentUser = PropertyLoader.loadProperty(filterPropertyPath, "currentUser");
    private final String threeUsersLabelValue = PropertyLoader.loadProperty(
            filterPropertyPath, "threeUsersLabelValue");
    private final String appointmentType1 = PropertyLoader.loadProperty(filterPropertyPath, "appointmentType1");
    private final String appointmentType2 = PropertyLoader.loadProperty(filterPropertyPath, "appointmentType2");
    private final String twoAppLabelValue = PropertyLoader.loadProperty(filterPropertyPath, "twoAppLabelValue");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        LoginPage.login();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickCalendar();
    }

    @Test // Case 2 without step 10
    public void setUserFilter() {
        CalendarPage.clickFilter();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        FilterPage.clickUsers();
        FilterPage.select(usersAll);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), usersAll);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
    }

    @Test // Case 3 without step 13
    public void setMultipleUserFilters() throws InterruptedException {
        CalendarPage.clickFilter();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        FilterPage.clickUsers();
        FilterPage.select(user1);
        FilterPage.select(user3);
        FilterPage.select(user4);
        FilterPage.select(currentUser);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), threeUsersLabelValue);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
        Thread.sleep(1000);
        CalendarPage.scrollToTheFirstRecord();
        Thread.sleep(500);
        int cellsCount = CalendarPage.getCellsCount();
        assertTrue(cellsCount >= 25 && cellsCount <= 35);
    }

    @Test // Case 4
    public void setAppointmentTypeAndVerify() {
        CalendarPage.clickFilter();
        assertEquals(FilterPage.getCurrentAppointmentsTypeLabelValue(), usersAll);
        FilterPage.clickAppointmentsType();
        FilterPage.select(appointmentType1);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentAppointmentsTypeLabelValue(), appointmentType1);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
        assertTrue(CalendarPage.checkVisibleCellsCount() <= 5);
    }

    @Test // Case 5
    public void setMultipleAppointmentTypesAndVerify() {
        CalendarPage.clickFilter();
        assertEquals(FilterPage.getCurrentAppointmentsTypeLabelValue(), usersAll);
        FilterPage.clickAppointmentsType();
        FilterPage.select(appointmentType1);
        FilterPage.select(appointmentType2);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentAppointmentsTypeLabelValue(), twoAppLabelValue);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
        assertTrue(CalendarPage.checkVisibleCellsCount() >= 7);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
