package com.android.tests;


import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Listeners(com.android.util.ScreenshotTaker.class)
public class ActivitiesFilterTest extends BaseTest {

    private final String dateYesterday = ActivitiesPage.dateYesterday();

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String currentUser = PropertyLoader.loadProperty(filterPropertyPath, "currentUser");
    private final String all = PropertyLoader.loadProperty(filterPropertyPath, "labelAll");
    private final String dateToday = PropertyLoader.loadProperty(filterPropertyPath, "dateToday");
    private final String searchString = PropertyLoader.loadProperty(filterPropertyPath, "searchString");
    private final String user1 = PropertyLoader.loadProperty(filterPropertyPath, "user1");
    private final String user2 = PropertyLoader.loadProperty(filterPropertyPath, "user2");
    private final String user3 = PropertyLoader.loadProperty(filterPropertyPath, "user3");
    private final String user4 = PropertyLoader.loadProperty(filterPropertyPath, "user4");
    private final String activityType1 = PropertyLoader.loadProperty(filterPropertyPath, "activityType1");
    private final String activityType2 = PropertyLoader.loadProperty(filterPropertyPath, "activityType2");
    private final String activityType3 = PropertyLoader.loadProperty(filterPropertyPath, "activityType3");
    private final String activityType4 = PropertyLoader.loadProperty(filterPropertyPath, "activityType4");
    private final String threeAccSelected = PropertyLoader.loadProperty(filterPropertyPath, "threeAccSelected");
    private final String threeUsersLabelValue = PropertyLoader.loadProperty(filterPropertyPath, "threeUsersLabelValue");

    private final String activityPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String activityName = PropertyLoader.loadProperty(activityPropertyPath, "activityName");
    private final String activityTime = PropertyLoader.loadProperty(activityPropertyPath, "activityTime");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        LoginPage.login();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickActivities();
        ActivitiesPage.clickFilter();
    }

    @Test(priority = 1) // Case 2
    public void setUserFilter() {
        FilterPage.clickUsers();
        FilterPage.select(all);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), all);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
        assertTrue(ActivitiesPage.searchActivityByName(activityName));
    }

    @Test(priority = 2) // Case 3
    public void setMultipleUserFilters() {
        FilterPage.clickUsers();
        FilterPage.select(user1);
        FilterPage.select(user3);
        FilterPage.select(user4);
        FilterPage.select(currentUser);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), threeUsersLabelValue);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
//        assertTrue(ActivitiesPage.searchActivity(activityName, ActivitiesPage.dateYesterday(), activityTime));
    }

    @Test(priority = 3) // Case 4
    public void setActivityTypeAndVerify() {
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), all);
        FilterPage.clickActivityType();
        FilterPage.select(activityType3);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), activityType3);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
//        assertTrue(ActivitiesPage.countActivitiesByDate(dateYesterday) == 1);
    }

    @Test(priority = 4) // Case 5
    public void setMultipleActivityTypesAndVerify() {
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), all);
        FilterPage.clickActivityType();
        FilterPage.select(activityType1);
        FilterPage.select(activityType2);
        FilterPage.select(activityType4);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), threeAccSelected);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
        assertTrue(ActivitiesPage.countActivities() == 26);
    }

    @Test(priority = 5)
    public void searchUser() {
        FilterPage.clickUsers();
        FilterPage.select(currentUser);
        FilterPage.search(searchString);
        assertTrue(FilterPage.checkSearchResultsContains(searchString));
        FilterPage.selectFirstSearchResult();
        FilterPage.saveFirstSearchResultValue();
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), FilterPage.getFirstSearchResultValue());
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), all);
        assertEquals(FilterPage.getCurrentDateValue(), dateToday);
    }

    @Test(priority = 6)
    public void searchUserCancel() {
        FilterPage.clickUsers();
        FilterPage.search(searchString);
        assertTrue(FilterPage.checkSearchResultsContains(searchString));
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), all);
        assertEquals(FilterPage.getCurrentDateValue(), dateToday);
    }

    @Test(priority = 7)
    public void searchUserCancelAfterUserSelection() {
        FilterPage.clickUsers();
        FilterPage.select(currentUser);
        FilterPage.select(user2);
        FilterPage.search(searchString);
        assertTrue(FilterPage.checkSearchResultsContains(searchString));
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), user2);
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), all);
        assertEquals(FilterPage.getCurrentDateValue(), dateToday);
    }

    @Test(priority = 8, enabled = false) // features are not fully implemented
    public void selectUserActivityType() {
        FilterPage.clickUsers();
        FilterPage.select(currentUser);
        FilterPage.select(user1);
        FilterPage.clickBack();
        FilterPage.clickActivityType();
        FilterPage.select(activityType2);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), user1);
        assertEquals(FilterPage.getCurrentActivityTypeLabelValue(), activityType2);
        assertEquals(FilterPage.getCurrentDateValue(), dateToday);
        FilterPage.clickClose();
        ActivitiesPage.clickFirstActivity();
        ActivityPage.checkPageTitle(activityType2.toUpperCase());
        assertEquals(ActivityPage.getUserName(), user1);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
