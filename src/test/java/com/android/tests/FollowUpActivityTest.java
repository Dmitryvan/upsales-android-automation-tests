package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.android.util.ScreenshotTaker.class)
public class FollowUpActivityTest extends BaseTest {

    private String description;
    private String title = Helpers.generateString();

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String account = PropertyLoader.loadProperty(commonPropertyPath, "account");
    private final String contact = PropertyLoader.loadProperty(commonPropertyPath, "contact");
    private final String opportunity = PropertyLoader.loadProperty(commonPropertyPath, "opportunity");
    private final String user = PropertyLoader.loadProperty(commonPropertyPath, "user");
    private final String campaign = PropertyLoader.loadProperty(commonPropertyPath, "campaign");
    private final String notes = PropertyLoader.loadProperty(commonPropertyPath, "notes");
    private final String defaultLabelDescription = PropertyLoader.loadProperty(commonPropertyPath, "defaultDescription");
    private final String defaultUser = PropertyLoader.loadProperty(commonPropertyPath, "defaultUser");
    private final String today = PropertyLoader.loadProperty(commonPropertyPath, "today");
    private final String testAccount4 = PropertyLoader.loadProperty(commonPropertyPath, "testAccount4");
    private final String testAccount2 = PropertyLoader.loadProperty(commonPropertyPath, "testAccount2");

    private final String testOpp2 = PropertyLoader.loadProperty(commonPropertyPath, "testOpp2");
    private final String testOpp4 = PropertyLoader.loadProperty(commonPropertyPath, "testOpp4");
    private final String testOpp = PropertyLoader.loadProperty(commonPropertyPath, "testOpp");
    private final String currentUser = PropertyLoader.loadProperty(commonPropertyPath, "currentUser");
    private final String labelOtherInfo = PropertyLoader.loadProperty(commonPropertyPath, "labelOtherInfo");

    private final String createActivityPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String activityType = PropertyLoader.loadProperty(createActivityPropertyPath, "activityType");
    private final String dueDateMonth = PropertyLoader.loadProperty(createActivityPropertyPath, "dueDateMonth");
    private final String dueDateDay = PropertyLoader.loadProperty(createActivityPropertyPath, "dueDateDay");
    private final String dueDateYear = PropertyLoader.loadProperty(createActivityPropertyPath, "dueDateYear");
    private final String dueDate = Helpers.dateLabelValue(dueDateMonth, dueDateDay, dueDateYear);
    private final String timeHours = PropertyLoader.loadProperty(createActivityPropertyPath, "timeHours");
    private final String timeMinutes = PropertyLoader.loadProperty(createActivityPropertyPath, "timeMinutes");
    private final String timeAmPm = PropertyLoader.loadProperty(createActivityPropertyPath, "timeAmPm");
    private final String newDueDateMonth = PropertyLoader.loadProperty(createActivityPropertyPath, "newDueDateMonth");
    private final String newDueDateDay = PropertyLoader.loadProperty(createActivityPropertyPath, "newDueDateDay");
    private final String newDueDateYear = PropertyLoader.loadProperty(createActivityPropertyPath, "newDueDateYear");
    private final String newHours = PropertyLoader.loadProperty(createActivityPropertyPath, "newHours");
    private final String newMinutes = PropertyLoader.loadProperty(createActivityPropertyPath, "newMinutes");
    private final String newDate = PropertyLoader.loadProperty(createActivityPropertyPath, "newDate");
    private final String newTime = PropertyLoader.loadProperty(createActivityPropertyPath, "newTime");
    private final String time = Helpers.timeLabelValue(timeHours, timeMinutes, timeAmPm);
    private final String selectOpportunity = PropertyLoader.loadProperty(createActivityPropertyPath, "selectOpportunity");
    private final String defaultOpportunity = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultOpportunity");
    private final String defaultContact = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultContact");
    private final String selectContact = PropertyLoader.loadProperty(createActivityPropertyPath, "selectContact");
    private final String defaultTime = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultTime");
    private final String labelSelectOpportunity = PropertyLoader.loadProperty(createActivityPropertyPath, "labelSelectOpportunity");
    private final String customEttTill = PropertyLoader.loadProperty(createActivityPropertyPath, "customEttTill");
    private final String testActivityType4 = PropertyLoader.loadProperty(createActivityPropertyPath, "testActivityType4");
    private final String testEttTill = PropertyLoader.loadProperty(createActivityPropertyPath, "testEttTill");
    private final String testActivityType = PropertyLoader.loadProperty(createActivityPropertyPath, "testActivityType");
    private final String testActivityDescription2 = PropertyLoader.loadProperty(createActivityPropertyPath, "testActivityDescription2");
    private final String testActivityDescription4 = PropertyLoader.loadProperty(createActivityPropertyPath, "testActivityDescription4");
    private final String testContact2 = PropertyLoader.loadProperty(createActivityPropertyPath, "testContact2");
    private final String testCampaign = PropertyLoader.loadProperty(createActivityPropertyPath, "testCampaign");
    private final String testNoteStart2 = PropertyLoader.loadProperty(createActivityPropertyPath, "testNoteStart2");
    private final String testEttTill2 = PropertyLoader.loadProperty(createActivityPropertyPath, "testEttTill2");
    private final String expenses = PropertyLoader.loadProperty(createActivityPropertyPath, "expenses");
    private final String newExpenses = PropertyLoader.loadProperty(createActivityPropertyPath, "newExpenses");

    private final String followUpActivityPropertyPath = "src/test/resources/followUpActivity.properties";
    private final String testActivityDescription = PropertyLoader.loadProperty(followUpActivityPropertyPath, "accName");
    private final String testContact = PropertyLoader.loadProperty(followUpActivityPropertyPath, "accContact");
    private final String newCampaign = PropertyLoader.loadProperty(followUpActivityPropertyPath, "accType");
    private final String testNoteStart = PropertyLoader.loadProperty(followUpActivityPropertyPath, "accNotes");

    private final String contactPropertyPath = "src/test/resources/contact.properties";
    private final String extraID = PropertyLoader.loadProperty(contactPropertyPath, "extraID");
    private final String chanceOfSuccess = PropertyLoader.loadProperty(contactPropertyPath, "chanceOfSuccess");

    private final String createAccountPropertyPath = "src/test/resources/createEditAccount.properties";
    private final String website = PropertyLoader.loadProperty(createAccountPropertyPath, "website");

    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        ActivityManipulationsPage.setDescription();
        description = ActivityManipulationsPage.getDescription();
    }

    @Test(priority = 1) //CASE 1
    public void softFollowUpActivityFromSideMenu() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickActivity();
        ActivityManipulationsPage.enterDescription(description);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectValueFromPopUp(activityType);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(dueDateYear);
        ActivityManipulationsPage.selectDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDateDay(dueDateDay);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickTime();
//        ActivityManipulationsPage.selectTimeHours(timeHours);
//        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
////        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
//        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        ActivityManipulationsPage.clickContact();
        AddSelectEntityPage.select(contact);
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectValueFromPopUp(opportunity);
        ActivityManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.typeIntoNotes(notes);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();
        ActivityPage.clickTools();
        ActivityPage.clickFollowUpActivity();
        ActivityPage.alertConfirm();
        ActivityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), activityType);
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), account);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), contact);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), labelSelectOpportunity);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), user);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), campaign);
        ActivityManipulationsPage.setDescription();
        String newDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(newDescription);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(newDueDateYear);
        ActivityManipulationsPage.selectDateMonth(newDueDateMonth);
        ActivityManipulationsPage.selectDateDay(newDueDateDay);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickTime();
//        ActivityManipulationsPage.selectTimeHours(newHours);
//        ActivityManipulationsPage.selectTimeMinutes(newMinutes);
////        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
//        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectValueFromPopUp(opportunity);
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityManipulationsPage.getNotes(), notes);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.clearExpenses();
        ActivityManipulationsPage.enterExpenses(newExpenses);
        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(newDescription, ActivityPage.getDescriptionOnView());
        softAssert.assertEquals(ActivityPage.getTitleOnView(), activityType.toUpperCase());
        softAssert.assertEquals(ActivityPage.getDate(), newDate);
//        softAssert.assertEquals(ActivityPage.getTime(), newTime);
        softAssert.assertEquals(ActivityPage.getUserName(), user);
        softAssert.assertEquals(ActivityPage.getAccountName(), account);
        softAssert.assertEquals(ActivityPage.getContact(), contact);
        softAssert.assertEquals(ActivityPage.getCampaign(), campaign);
        softAssert.assertEquals(ActivityPage.getNotes(), notes);
        softAssert.assertEquals(ActivityPage.getOpportunity(), opportunity);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityPage.getExpenses(), newExpenses + " SEK");
        ActivityPage.clickBack();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(account);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabActivities();
        ActivitiesPage.searchActivity(description, today);
        ActivitiesPage.searchActivityByName(newDescription);
        softAssert.assertAll();
    }

    @Test(priority = 2) //CASE 2
    public void softFollowUpActivityFromActivitiesList() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        LeftMenuPage.clickActivities();
        ActivitiesPage.selectActivity(testActivityDescription4);
        ActivityPage.clickTools();
        ActivityPage.clickFollowUpActivity();
        ActivityPage.alertConfirm();
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        ActivityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), testActivityType4);
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), testAccount4);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), testContact2);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), labelSelectOpportunity);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), testCampaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertTrue(ActivityManipulationsPage.getNotesStartsWith(testNoteStart2));
        ActivityManipulationsPage.setDescription();
        String newDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.scrollToLabel("Description");
        ActivityManipulationsPage.enterDescription(newDescription);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(newDueDateYear);
        ActivityManipulationsPage.selectDateMonth(newDueDateMonth);
        ActivityManipulationsPage.selectDateDay(newDueDateDay);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickTime();
//        ActivityManipulationsPage.selectTimeHours(newHours);
//        ActivityManipulationsPage.selectTimeMinutes(newMinutes);
////        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
//        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectValueFromPopUp(testOpp4);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(newDescription, ActivityPage.getDescriptionOnView());
        softAssert.assertEquals(ActivityPage.getTitleOnView(), testActivityType4.toUpperCase());
        softAssert.assertEquals(ActivityPage.getDate(), newDate);
//        softAssert.assertEquals(ActivityPage.getTime(), newTime);
        softAssert.assertEquals(ActivityPage.getAccountName(), testAccount4);
        softAssert.assertEquals(ActivityPage.getContact(), testContact2);
        softAssert.assertEquals(ActivityPage.getOpportunity(), testOpp4);
        softAssert.assertEquals(ActivityPage.getCampaign(), testCampaign);
        softAssert.assertEquals(ActivityPage.getUserName(), currentUser);
//        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertTrue(ActivityPage.getNotesStartsWith(testNoteStart2));
//        ActivityPage.clickBack();   ???
//        ActivityPage.swipeFromTopToBottom();
//        ActivityPage.swipeFromTopToBottom();
        ActivityPage.clickAccount();
        AccountPage.clickTabActivities();
        softAssert.assertTrue(ActivitiesPage.searchActivityByName(testActivityDescription4));
        softAssert.assertTrue(ActivitiesPage.searchActivityByName(newDescription));
        softAssert.assertAll();
    }

    @Test(priority = 3, enabled = false) //CASE 3
    public void softFollowUpActivityFromDashboard() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        LeftMenuPage.clickDashboard();
        DashboardPage.selectActivity(testActivityDescription4);
        ActivityPage.clickTools();
        ActivityPage.clickFollowUpActivity();
        ActivityPage.alertConfirm();
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        ActivityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), testActivityType4);
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), testAccount4);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), testContact2);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), labelSelectOpportunity);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), testCampaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertTrue(ActivityManipulationsPage.getNotesStartsWith(testNoteStart2));
        ActivityManipulationsPage.swipeFromTopToBottom();
        ActivityManipulationsPage.swipeFromTopToBottom();
        ActivityManipulationsPage.setDescription();
        String newDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(newDescription);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(newDueDateYear);
        ActivityManipulationsPage.selectDateMonth(newDueDateMonth);
        ActivityManipulationsPage.selectDateDay(newDueDateDay);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(newHours);
        ActivityManipulationsPage.selectTimeMinutes(newMinutes);
//        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectValueFromPopUp(testOpp4);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(newDescription, ActivityPage.getDescriptionOnView());
        softAssert.assertEquals(ActivityPage.getTitle(), testActivityType4.toUpperCase());
        softAssert.assertEquals(ActivityPage.getDate(), newDate);
        softAssert.assertEquals(ActivityPage.getTime(), newTime);
        softAssert.assertEquals(ActivityPage.getAccountName(), testAccount4);
        softAssert.assertEquals(ActivityPage.getContact(), testContact2);
        softAssert.assertEquals(ActivityPage.getOpportunity(), testOpp4);
        softAssert.assertEquals(ActivityPage.getCampaign(), testCampaign);
        softAssert.assertEquals(ActivityPage.getUserName(), currentUser);
        softAssert.assertTrue(ActivityPage.getNotesStartsWith(testNoteStart2));
        ActivityPage.clickAccount();
        AccountPage.clickTabActivities();
        ActivitiesPage.searchActivityByName(testActivityDescription4);
        ActivitiesPage.searchActivityByName(newDescription);
        softAssert.assertAll();
    }

    @Test(priority = 4) //CASE 4
    public void softFollowUpActivityFromAccount() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        LeftMenuPage.clickSearch();
        SearchPage.search(testAccount4);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabActivities();
        ActivitiesPage.selectActivity(testActivityDescription);
        ActivityPage.clickTools();
        ActivityPage.clickFollowUpActivity();
        ActivityPage.alertConfirm();
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        ActivityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), testActivityType);
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), testAccount4);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), testContact);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), labelSelectOpportunity);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), newCampaign);
        ActivityManipulationsPage.setDescription();
        String newDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(newDescription);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(newDueDateYear);
        ActivityManipulationsPage.selectDateMonth(newDueDateMonth);
        ActivityManipulationsPage.selectDateDay(newDueDateDay);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickTime();
//        ActivityManipulationsPage.selectTimeHours(newHours);
//        ActivityManipulationsPage.selectTimeMinutes(newMinutes);
////        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
//        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.hideKeyboard();
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectValueFromPopUp(testOpp4);
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertTrue(ActivityManipulationsPage.getNotesStartsWith(testNoteStart));
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(newDescription, BasePage.getDescriptionOnView());
        softAssert.assertEquals(ActivityPage.getTitleOnView(), testActivityType.toUpperCase());
        softAssert.assertEquals(ActivityPage.getDate(), newDate);
//        softAssert.assertEquals(ActivityPage.getTime(), newTime);
        softAssert.assertEquals(ActivityPage.getAccountName(), testAccount4);
        softAssert.assertEquals(ActivityPage.getContact(), testContact);
        softAssert.assertEquals(ActivityPage.getOpportunity(), testOpp4);
        softAssert.assertEquals(ActivityPage.getCampaign(), newCampaign);
        softAssert.assertEquals(ActivityPage.getUserName(), currentUser);
//        ActivityPage.swipeFromBottomToTop();
        softAssert.assertTrue(ActivityPage.getNotesStartsWith(testNoteStart));
        ActivityPage.clickAccount();
//        ActivityPage.clickBack();
        AccountPage.clickTabActivities();
        softAssert.assertTrue(ActivitiesPage.searchActivityByName(testActivityDescription));
        softAssert.assertTrue(ActivitiesPage.searchActivityByName(newDescription));
        softAssert.assertAll();
    }

    @Test(priority = 5) //CASE 5
    public void softFollowUpActivityFromSideMenuAccountAndActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickAccount();
        AccountManipulationsPage.setAccountName();
        String accountName = AccountManipulationsPage.getAccountName();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.enterWebsite(website);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpActivity();
        ActivityManipulationsPage.enterDescription(description);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectValueFromPopUp(activityType);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(dueDateYear);
        ActivityManipulationsPage.selectDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDateDay(dueDateDay);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickTime();
//        ActivityManipulationsPage.selectTimeHours(timeHours);
//        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
////        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
//        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.typeIntoNotes(notes);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();
        ActivityPage.clickTools();
        ActivityPage.clickFollowUpActivity();
        ActivityPage.alertConfirm();
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), activityType);
        ActivityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), accountName);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), "No contacts");
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), defaultOpportunity);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), user);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), campaign);
        ActivityManipulationsPage.setDescription();
        String newDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(newDescription);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(newDueDateYear);
        ActivityManipulationsPage.selectDateMonth(newDueDateMonth);
        ActivityManipulationsPage.selectDateDay(newDueDateDay);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickTime();
//        ActivityManipulationsPage.selectTimeHours(newHours);
//        ActivityManipulationsPage.selectTimeMinutes(newMinutes);
////        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
//        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityManipulationsPage.getNotes(), notes);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.clearExpenses();
        ActivityManipulationsPage.enterExpenses(newExpenses);
        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(newDescription, ActivityPage.getDescriptionOnView());
        softAssert.assertEquals(ActivityPage.getTitleOnView(), activityType.toUpperCase());
        softAssert.assertEquals(ActivityPage.getDate(), newDate);
//        softAssert.assertEquals(ActivityPage.getTime(), newTime);
        softAssert.assertEquals(ActivityPage.getUserName(), user);
        softAssert.assertEquals(ActivityPage.getAccountName(), accountName);
        softAssert.assertEquals(ActivityPage.getCampaign(), campaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityPage.getNotes(), notes);
        ActivityManipulationsPage.swipeFromTopToBottom();
        ActivityPage.clickAccount();
        AccountPage.clickTabActivities();
        softAssert.assertTrue(ActivitiesPage.searchActivity(description, today));
        softAssert.assertTrue(ActivitiesPage.searchActivityByName(newDescription));
        softAssert.assertAll();
    }

    @Test(priority = 6) //CASE 6
    public void softFollowUpActivityFromSideMenuAccountContactActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickAccount();
        AccountManipulationsPage.setAccountName();
        String accountName = AccountManipulationsPage.getAccountName();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.enterWebsite(website);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpContact();
        ContactManipulationPage.setContactName();
        String contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.enterTitle(title);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickActivity();
        ActivityManipulationsPage.enterDescription(description);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectValueFromPopUp(activityType);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(dueDateYear);
        ActivityManipulationsPage.selectDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDateDay(dueDateDay);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickTime();
//        ActivityManipulationsPage.selectTimeHours(timeHours);
//        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
////        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
//        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.typeIntoNotes(notes);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();
        ActivityPage.clickTools();
        ActivityPage.clickFollowUpActivity();
        ActivityPage.alertConfirm();
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        ActivityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), activityType);
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
//        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), accountName);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), contactName);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), defaultOpportunity);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), user);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), campaign);
        ActivityManipulationsPage.setDescription();
        String newDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(newDescription);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(newDueDateYear);
        ActivityManipulationsPage.selectDateMonth(newDueDateMonth);
        ActivityManipulationsPage.selectDateDay(newDueDateDay);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickTime();
//        ActivityManipulationsPage.selectTimeHours(newHours);
//        ActivityManipulationsPage.selectTimeMinutes(newMinutes);
////        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
//        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityManipulationsPage.getNotes(), notes);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.clearExpenses();
        ActivityManipulationsPage.enterExpenses(newExpenses);
        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(newDescription, ActivityPage.getDescriptionOnView());
        softAssert.assertEquals(ActivityPage.getTitleOnView(), activityType.toUpperCase());
        softAssert.assertEquals(ActivityPage.getAccountName(), accountName);
        softAssert.assertEquals(ActivityPage.getDate(), newDate);
//        softAssert.assertEquals(ActivityPage.getTime(), newTime);
        softAssert.assertEquals(ActivityPage.getContact(), contactName);
        softAssert.assertEquals(ActivityPage.getUserName(), user);
        softAssert.assertEquals(ActivityPage.getCampaign(), campaign);
        ActivityPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityPage.getNotes(), notes);
        ActivityPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityPage.getExpenses(), newExpenses + " SEK");
        ActivityPage.swipeFromTopToBottom();
        ActivityPage.swipeFromTopToBottom();
        ActivityPage.clickAccount();
        AccountPage.clickTabActivities();
        softAssert.assertTrue(ActivitiesPage.searchActivityByName(description));
        softAssert.assertTrue(ActivitiesPage.searchActivityByName(newDescription));
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
