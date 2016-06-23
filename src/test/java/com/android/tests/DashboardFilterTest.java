package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Listeners(com.android.util.ScreenshotTaker.class)
public class DashboardFilterTest extends BaseTest {

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";

    private final String currentUser= PropertyLoader.loadProperty(filterPropertyPath, "currentUser");
    private final String user1= PropertyLoader.loadProperty(filterPropertyPath, "user1");
    private final String user2= PropertyLoader.loadProperty(filterPropertyPath, "user2");
    private final String user3= PropertyLoader.loadProperty(filterPropertyPath, "user3");
    private final String user4= PropertyLoader.loadProperty(filterPropertyPath, "user4");
    private final String user5= PropertyLoader.loadProperty(filterPropertyPath, "user5");
    private final String usersAll = PropertyLoader.loadProperty(filterPropertyPath, "labelAll");
    private final String searchValue = PropertyLoader.loadProperty(
            filterPropertyPath, "searchValue");
    private final String twoUsersSelected = PropertyLoader.loadProperty(
            filterPropertyPath, "twoUsersLabelValue");
    private final String twoUsersSelected2 = PropertyLoader.loadProperty(
            filterPropertyPath, "twoUsersLabelValue2");
    private final String threeUsersLabelValue = PropertyLoader.loadProperty(
            filterPropertyPath, "threeUsersLabelValue");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        LoginPage.login();
        DashboardPage.saveCurrentSalesAndPipelineValues();
        DashboardPage.clickFilter();
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
    public void verifyValuesAfterFilterSet() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        FilterPage.clickUsers();
        FilterPage.select(currentUser);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
        softAssert.assertEquals(DashboardPage.getLabelMonth(), DashboardPage.getCurrentMonth().toUpperCase());
        softAssert.assertTrue(DashboardPage.getSalesValue() >= 1.2 && DashboardPage.getSalesValue() <= 2);
        softAssert.assertTrue(DashboardPage.getPipelineValue() >= 1.5 && DashboardPage.getPipelineValue() <= 2);
        softAssert.assertAll();
    }

    @Test(priority = 3) // Case 4
    public void softNavigateAndVerifyValuesAfterFilterSet() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        FilterPage.clickUsers();
        FilterPage.select(currentUser);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), currentUser);
        FilterPage.clickClose();
        DashboardPage.swipeLeft();
        softAssert.assertEquals(DashboardPage.getLabelQuarter(), DashboardPage.getCurrentQuarter());
        softAssert.assertTrue(DashboardPage.getSalesValue() >= 1.5 && DashboardPage.getSalesValue() <= 2.5);
        softAssert.assertTrue(DashboardPage.getPipelineValue() >= 1.5 && DashboardPage.getPipelineValue() <= 2);
        DashboardPage.swipeLeft();
        softAssert.assertEquals(DashboardPage.getLabelYear(), DashboardPage.getCurrentYear());
        softAssert.assertTrue(DashboardPage.getSalesValue() >= 3 && DashboardPage.getSalesValue() <= 3.5);
        softAssert.assertTrue(DashboardPage.getPipelineValue() >= 2 && DashboardPage.getPipelineValue() <= 2.8);
        softAssert.assertAll();
    }

    @Test(priority = 4) // Case 5
    public void setMultipleUserFilters() {
        FilterPage.clickUsers();
        FilterPage.select(user1);
        FilterPage.select(user3);
        FilterPage.select(user4);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), threeUsersLabelValue);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
    }

    @Test(priority = 5) // Case 6
    public void softVerifyValuesAfterMultipleUsersSet() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        FilterPage.clickUsers();
        FilterPage.select(user1);
        FilterPage.select(user3);
        FilterPage.select(user4);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), threeUsersLabelValue);
        FilterPage.clickClose();
        softAssert.assertEquals(DashboardPage.getLabelMonth(), DashboardPage.getCurrentMonth().toUpperCase());
        softAssert.assertTrue(DashboardPage.getSalesValue() >= 150000 && DashboardPage.getSalesValue() <= 220000);
        softAssert.assertTrue(DashboardPage.getPipelineValue() >= 100000 && DashboardPage.getPipelineValue() <= 150000);
        softAssert.assertAll();
    }

    @Test(priority = 6) // Case 7
    public void softNavigateAndVerifyValuesAfterMultipleUsersSet() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        FilterPage.clickUsers();
        FilterPage.select(user1);
        FilterPage.select(user3);
        FilterPage.select(user4);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), threeUsersLabelValue);
        FilterPage.clickClose();
        DashboardPage.swipeLeft();
        softAssert.assertEquals(DashboardPage.getLabelQuarter(), DashboardPage.getCurrentQuarter());
        softAssert.assertTrue(DashboardPage.getSalesValue() >= 3.5 && DashboardPage.getSalesValue() <= 4.3);
        softAssert.assertTrue(DashboardPage.getPipelineValue() >= 400000 && DashboardPage.getPipelineValue() <= 800000);
        DashboardPage.swipeLeft();
        softAssert.assertEquals(DashboardPage.getLabelYear(), DashboardPage.getCurrentYear());
        softAssert.assertTrue(DashboardPage.getSalesValue() >= 15 && DashboardPage.getSalesValue() <= 20);
        softAssert.assertTrue(DashboardPage.getPipelineValue() >= 400000 && DashboardPage.getPipelineValue() <= 800000);
        softAssert.assertAll();
    }

    @Test(priority = 7) // Case 8
    public void toggleBetweenAllAndSelection() {
        assertEquals(FilterPage.getCurrentUserLabelValue(), usersAll);
        FilterPage.clickUsers();
        FilterPage.select(user5);
        FilterPage.select(user2);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), twoUsersSelected2);
        FilterPage.clickUsers();
        FilterPage.select(usersAll);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), usersAll);
        FilterPage.clickClose();
        assertFalse(FilterPage.checkFilter());
    }

    @Test(priority = 8)
    public void searchUser() throws InterruptedException {
        FilterPage.clickUsers();
        FilterPage.search(searchValue);
        FilterPage.checkFirstSearchResultContains(searchValue);
        FilterPage.saveFirstSearchResultValue();
        FilterPage.selectFirstSearchResult();
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), FilterPage.getFirstSearchResultValue());
        FilterPage.clickClose();
        assertFalse(DashboardPage.compareSavedAndCurrentValues());
    }

    @Test(priority = 9)
    public void differentUserSelection() throws InterruptedException {
        FilterPage.clickUsers();
        FilterPage.select(user2);
        FilterPage.clickBack();
        FilterPage.clickClose();
        assertFalse(DashboardPage.compareSavedAndCurrentValues());
        DashboardPage.saveCurrentSalesAndPipelineValues();
        DashboardPage.clickFilter();
        FilterPage.clickUsers();
        FilterPage.select(user3);
        FilterPage.clickBack();
        assertEquals(FilterPage.getCurrentUserLabelValue(), twoUsersSelected);
        FilterPage.clickClose();
        assertFalse(DashboardPage.compareSavedAndCurrentValues());
    }

    @Test(priority = 10)
    public void checkingSalesAndPipelineSum() throws InterruptedException {
        FilterPage.clickUsers();
        FilterPage.select(user2);
        FilterPage.clickBack();
        FilterPage.clickClose();
        DashboardPage.addUserValuesToStorage();
        DashboardPage.clickFilter();
        FilterPage.clickUsers();
        FilterPage.select(user2);
        FilterPage.select(user3);
        FilterPage.clickBack();
        FilterPage.clickClose();
        DashboardPage.addUserValuesToStorage();
        DashboardPage.clickFilter();
        FilterPage.clickUsers();
        FilterPage.select(user2);
        FilterPage.clickBack();
        FilterPage.clickClose();
        assertEquals(DashboardPage.getUsersValuesStorageSum(),
                DashboardPage.getCurrentSalesAndPipelineValues());
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
