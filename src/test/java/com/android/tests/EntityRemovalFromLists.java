package com.android.tests;

import com.android.pages.DashboardPage;
import com.android.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class EntityRemovalFromLists extends BaseTest {

    private static final String ACTIVITY_1 = "Saddest";
    private static final String APPOINTMENT_1 = "testapp";

    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
    }

    @Test // Case 1
    public void deleteActivityFunctionWithoutRemovalFromDashboard() {
        int activitiesCount = DashboardPage.getMyOpenActivitiesCount();
        DashboardPage.scrollToLabel(ACTIVITY_1);
        DashboardPage.swipeActivity(ACTIVITY_1);
        DashboardPage.clickDelete();
        DashboardPage.alertCancel();
        assertEquals(DashboardPage.getMyOpenActivitiesCount(), activitiesCount);
        assertTrue(DashboardPage.checkActiviyIsPresent(ACTIVITY_1));
    }

    @Test // Case 2
    public void deleteActivityFromDashboard() {
        int activitiesCount = DashboardPage.getMyOpenActivitiesCount();
        DashboardPage.scrollToLabel(ACTIVITY_1);
        DashboardPage.swipeActivity(ACTIVITY_1);
        DashboardPage.clickDelete();
        DashboardPage.alertConfirm();
        assertEquals(DashboardPage.getMyOpenActivitiesCount(), activitiesCount - 1);
        assertFalse(DashboardPage.checkActiviyIsPresent(ACTIVITY_1));
    }

    @Test // Case 3
    public void deleteAppointmentFunctionWithoutRemovalFromDashboard() {
        int activitiesCount = DashboardPage.getMyAppointmentsTodayCount();
        DashboardPage.scrollToLabel(APPOINTMENT_1);
        DashboardPage.swipeActivity(APPOINTMENT_1);
        DashboardPage.clickDelete();
        DashboardPage.alertCancel();
        assertEquals(DashboardPage.getMyAppointmentsTodayCount(), activitiesCount);
        assertTrue(DashboardPage.checkActiviyIsPresent(APPOINTMENT_1));
    }

    @Test // Case 4
    public void deleteAppointmentFromDashboard() {
        int activitiesCount = DashboardPage.getMyAppointmentsTodayCount();
        DashboardPage.scrollToLabel(APPOINTMENT_1);
        DashboardPage.swipeActivity(APPOINTMENT_1);
        DashboardPage.clickDelete();
        DashboardPage.alertConfirm();
        assertEquals(DashboardPage.getMyAppointmentsTodayCount(), activitiesCount - 1);
        assertFalse(DashboardPage.checkActiviyIsPresent(APPOINTMENT_1));
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
