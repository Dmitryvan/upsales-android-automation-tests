package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(com.android.util.ScreenshotTaker.class)
public class CreateEditActivityTest extends BaseTest {

    private String description;

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String account = PropertyLoader.loadProperty(commonPropertyPath, "account");
    private final String contact = PropertyLoader.loadProperty(commonPropertyPath, "contact");
    private final String opportunity = PropertyLoader.loadProperty(commonPropertyPath, "opportunity");
    private final String user = PropertyLoader.loadProperty(commonPropertyPath, "user");
    private final String campaign = PropertyLoader.loadProperty(commonPropertyPath, "campaign");
    private final String notes = PropertyLoader.loadProperty(commonPropertyPath, "notes");
    private final String newContact = PropertyLoader.loadProperty(commonPropertyPath, "newContact");
    private final String newUser = PropertyLoader.loadProperty(commonPropertyPath, "newUser");
    private final String newCampaign = PropertyLoader.loadProperty(commonPropertyPath, "newCampaign");
    private final String newNotes = PropertyLoader.loadProperty(commonPropertyPath, "newNotes");
    private final String defaultLabelDescription = PropertyLoader.loadProperty(commonPropertyPath, "defaultDescription");
    private final String labelAccount = PropertyLoader.loadProperty(commonPropertyPath, "labelAccount");
    private final String defaultAccount = PropertyLoader.loadProperty(commonPropertyPath, "defaultAccount");
    private final String titleSelectAccount = PropertyLoader.loadProperty(commonPropertyPath, "titleSelectAccount");
    private final String titleAddCampaign = PropertyLoader.loadProperty(commonPropertyPath, "titleAddCampaign");
    private final String labelSearch = PropertyLoader.loadProperty(commonPropertyPath, "labelSearch");
    private final String labelCancel = PropertyLoader.loadProperty(commonPropertyPath, "labelCancel");
    private final String labelResults = PropertyLoader.loadProperty(commonPropertyPath, "labelResults");
    private final String labelOpportunity = PropertyLoader.loadProperty(commonPropertyPath, "labelOpportunity");
    private final String labelUser = PropertyLoader.loadProperty(commonPropertyPath, "labelUser");
    private final String defaultUser = PropertyLoader.loadProperty(commonPropertyPath, "defaultUser");
    private final String labelCampaign = PropertyLoader.loadProperty(commonPropertyPath, "labelCampaign");
    private final String defaultCampaign = PropertyLoader.loadProperty(commonPropertyPath, "defaultCampaign");
    private final String labelNone = PropertyLoader.loadProperty(commonPropertyPath, "labelNone");
    private final String labelNotes = PropertyLoader.loadProperty(commonPropertyPath, "labelNotes");
    private final String labelOtherInfo = PropertyLoader.loadProperty(commonPropertyPath, "labelOtherInfo");
    private final String labelSave = PropertyLoader.loadProperty(commonPropertyPath, "labelSave");
    private final String labelContact = PropertyLoader.loadProperty(commonPropertyPath, "labelContact");
    private final String today = PropertyLoader.loadProperty(commonPropertyPath, "today");

    private final String createActivityPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String titleCreate = PropertyLoader.loadProperty(createActivityPropertyPath, "titleCreate");
    private final String titleEdit = PropertyLoader.loadProperty(createActivityPropertyPath, "titleEdit");
    private final String activityType = PropertyLoader.loadProperty(createActivityPropertyPath, "activityType");
    private final String dueDateMonth = PropertyLoader.loadProperty(createActivityPropertyPath, "dueDateMonth");
    private final String dueDateDay = PropertyLoader.loadProperty(createActivityPropertyPath, "dueDateDay");
    private final String dueDateYear = PropertyLoader.loadProperty(createActivityPropertyPath, "dueDateYear");
    private final String timeHours = PropertyLoader.loadProperty(createActivityPropertyPath, "timeHours");
    private final String timeMinutes = PropertyLoader.loadProperty(createActivityPropertyPath, "timeMinutes");
    private final String timeAmPm = PropertyLoader.loadProperty(createActivityPropertyPath, "timeAmPm");
    private final String newActivityType = PropertyLoader.loadProperty(createActivityPropertyPath, "newActivityType");
    private final String newDueDateMonth = PropertyLoader.loadProperty(createActivityPropertyPath, "newDueDateMonth");
    private final String newDueDateDay = PropertyLoader.loadProperty(createActivityPropertyPath, "newDueDateDay");
    private final String newDueDateYear = PropertyLoader.loadProperty(createActivityPropertyPath, "newDueDateYear");
    private final String newHours = PropertyLoader.loadProperty(createActivityPropertyPath, "newHours");
    private final String newMinutes = PropertyLoader.loadProperty(createActivityPropertyPath, "newMinutes");
    private final String newDate = PropertyLoader.loadProperty(createActivityPropertyPath, "newDate");
    private final String newTime = PropertyLoader.loadProperty(createActivityPropertyPath, "newTime");
    private final String dueDate = Helpers.dateLabelValue(dueDateMonth, dueDateDay, dueDateYear);
    private final String time = Helpers.timeLabelValue(timeHours, timeMinutes, timeAmPm);
    private final String defaultActivityType = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultActivityType");
    private final String defaultOpportunity = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultOpportunity");
    private final String activityTypes = PropertyLoader.loadProperty(createActivityPropertyPath, "activityTypes");
    private final String defaultContact = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultContact");
    private final String labelDueDate = PropertyLoader.loadProperty(createActivityPropertyPath, "labelDueDate");
    private final String defaultTime = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultTime");
    private final String labelTime = PropertyLoader.loadProperty(createActivityPropertyPath, "labelTime");

    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickActivity();
        ActivityManipulationsPage.setDescription();
        description = ActivityManipulationsPage.getDescription();
    }

    @Test(priority = 1) //CASE 2
    public void softContentOfCreateActivityPage() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ActivityManipulationsPage.checkPageTitle(titleCreate);
        softAssert.assertEquals(ActivityManipulationsPage.getLabelSave(), labelSave);
        softAssert.assertEquals(ActivityManipulationsPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(defaultLabelDescription, ActivityManipulationsPage.getDefaultLabelDescription());
        softAssert.assertEquals(defaultActivityType, ActivityManipulationsPage.getActivityType());
        ActivityManipulationsPage.clickActivityType();
        softAssert.assertEquals(activityTypes, ActivityManipulationsPage.getAllActivityTypes());
        ActivityManipulationsPage.closeActivityTypeList();
        softAssert.assertEquals(labelDueDate, ActivityManipulationsPage.getLabelDueDate());
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
        softAssert.assertEquals(defaultTime, ActivityManipulationsPage.getTime());
        assertEquals(labelTime, ActivityManipulationsPage.getLabelTime());
        softAssert.assertEquals(labelAccount, ActivityManipulationsPage.getLabelAccount());
        softAssert.assertEquals(defaultAccount, ActivityManipulationsPage.getAccount());
        ActivityManipulationsPage.clickAccount();
        softAssert.assertEquals(labelResults, AddSelectEntityPage.getResultsLabelValue());
        softAssert.assertEquals(titleSelectAccount, AddSelectEntityPage.getTitle());
        softAssert.assertEquals(labelSearch, AddSelectEntityPage.getSearchFieldValue());
        softAssert.assertEquals(labelCancel, AddSelectEntityPage.getLabelCancel());
        AddSelectEntityPage.clickBack();
        softAssert.assertEquals(labelContact, ActivityManipulationsPage.getLabelContact());
        softAssert.assertEquals(defaultContact, ActivityManipulationsPage.getContact());
        softAssert.assertEquals(labelOpportunity, ActivityManipulationsPage.getLabelOpportunity());
        softAssert.assertEquals(defaultOpportunity, ActivityManipulationsPage.getOpportunity());
        softAssert.assertEquals(labelUser, ActivityManipulationsPage.getLabelUser());
        softAssert.assertEquals(defaultUser, ActivityManipulationsPage.getUser());
        softAssert.assertEquals(labelCampaign, ActivityManipulationsPage.getLabelCampaign());
        softAssert.assertEquals(defaultCampaign, ActivityManipulationsPage.getCampaign());
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.checkPageTitle(titleAddCampaign);
        softAssert.assertEquals(labelSearch, AddSelectEntityPage.getSearchFieldValue());
        softAssert.assertEquals(labelCancel, AddSelectEntityPage.getLabelCancel());
        softAssert.assertEquals(labelResults, AddSelectEntityPage.getResultsLabelValue());
        AddSelectEntityPage.clickBack();
        softAssert.assertEquals(labelNotes, ActivityManipulationsPage.getLabelNotes());
        ActivityManipulationsPage.scrollToOtherInfo(labelOtherInfo);
        softAssert.assertEquals(labelOtherInfo, ActivityManipulationsPage.getLabelOtherInfo());
        softAssert.assertAll();
    }

    @Test(priority = 2) //CASE 3
    public void softCreateActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ActivityManipulationsPage.enterDescription(description);
        ActivityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        softAssert.assertEquals(account, ActivityManipulationsPage.getAccount());
        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(description, ActivityPage.getActivityDescription());
        softAssert.assertEquals(account, ActivityPage.getAccountName());
//        ActivityPage.clickAccount();
//        AccountPage.clickTabActivities();
//        ActivitiesPage.searchActivity(description, today);
        softAssert.assertAll();
    }

    @Test(priority = 3) //CASE 4
    public void softCancelActivityBeforeSave() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ActivityManipulationsPage.enterDescription(description);
        ActivityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        ActivityManipulationsPage.clickCancel();
        softAssert.assertTrue(LeftMenuPage.checkSearch());
        softAssert.assertEquals(LeftMenuPage.getHiddenPageTitle(), titleDashboard);
        softAssert.assertAll();
    }

    @Test(priority = 4) // CASE 6
    public void softCancelAfterSelectEditActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ActivityManipulationsPage.enterDescription(description);
        ActivityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        ActivityManipulationsPage.clickSave();
        ActivityPage.clickTools();
        ActivityPage.clickEditActivity();
        softAssert.assertEquals(ActivityManipulationsPage.getTitle(), titleEdit);
        ActivityManipulationsPage.setDescription();
        String newDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(newDescription);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectActivityType(newActivityType);
        ActivityManipulationsPage.clickContact();
        AddSelectEntityPage.select(contact);
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectOpportunity(opportunity);
        ActivityManipulationsPage.clickCancel();
        softAssert.assertEquals(description, ActivityPage.getActivityDescription());
        softAssert.assertEquals(account, ActivityPage.getAccountName());
//        softAssert.assertTrue(ActivityPage.checkThereIsNoContact());
        softAssert.assertEquals(labelNone, ActivityPage.getCampaignWithoutContactAndTime());
        softAssert.assertEquals(labelNone, ActivityPage.getOpportunityWithoutContactAndTime());
        ActivityPage.checkPageTitle(defaultActivityType.toUpperCase());
        softAssert.assertAll();
    }

    @Test(priority = 5) // CASE 5
    public void softEditActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ActivityManipulationsPage.enterDescription(description);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectActivityType(activityType);
        softAssert.assertEquals(activityType, ActivityManipulationsPage.getActivityType());
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDueDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDueDateDay(dueDateDay);
        ActivityManipulationsPage.selectDueDateYear(dueDateYear);
        ActivityManipulationsPage.closePicker();
        softAssert.assertEquals(dueDate, ActivityManipulationsPage.getDueDate());
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(timeHours);
        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
//        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
        ActivityManipulationsPage.closePicker();
        softAssert.assertEquals(time, ActivityManipulationsPage.getTime());
        ActivityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        softAssert.assertEquals(account, ActivityManipulationsPage.getAccount());
        ActivityManipulationsPage.clickContact();
        AddSelectEntityPage.select(contact);
        softAssert.assertEquals(contact, ActivityManipulationsPage.getContact());
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectOpportunity(opportunity);
        softAssert.assertEquals(opportunity, ActivityManipulationsPage.getOpportunity());
        ActivityManipulationsPage.clickUser();
//        AddSelectEntityPage.select(user);
//        softAssert.assertEquals(user, ActivityManipulationsPage.getUser());
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        softAssert.assertEquals(campaign, ActivityManipulationsPage.getCampaign());
        ActivityManipulationsPage.scrollToOtherInfo(labelOtherInfo);
        ActivityManipulationsPage.typeIntoNotes(notes);
        ActivityManipulationsPage.clickSave();
        ActivityPage.clickTools();
        ActivityPage.clickEditActivity();
        ActivityManipulationsPage.setDescription();
        String newDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(newDescription);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectActivityType(newActivityType);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDueDateMonth(newDueDateMonth);
        ActivityManipulationsPage.selectDueDateDay(newDueDateDay);
        ActivityManipulationsPage.selectDueDateYear(newDueDateYear);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(newHours);
        ActivityManipulationsPage.selectTimeMinutes(newMinutes);
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.clickContact();
        AddSelectEntityPage.select(newContact);
//        ActivityManipulationsPage.clickOpportunity();
//        ActivityManipulationsPage.selectOpportunity(opportunity);
//        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.clickUser();
        AddSelectEntityPage.select(newUser);
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        ActivityManipulationsPage.typeIntoNotes(newNotes);
        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(newDescription, ActivityPage.getActivityDescription());
        softAssert.assertEquals(ActivityPage.getTitle(), newActivityType.toUpperCase());
        softAssert.assertEquals(newUser, ActivityPage.getUserName());
        softAssert.assertEquals(account, ActivityPage.getAccountName());
        softAssert.assertEquals(newDate, ActivityPage.getDate());
        softAssert.assertEquals(newTime, ActivityPage.getTime());
        softAssert.assertEquals(newContact, ActivityPage.getContact());
        softAssert.assertEquals(newCampaign, ActivityPage.getCampaign());
        softAssert.assertEquals(opportunity, ActivityPage.getOpportunity());
        softAssert.assertEquals(newNotes, ActivityPage.getNotes());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
