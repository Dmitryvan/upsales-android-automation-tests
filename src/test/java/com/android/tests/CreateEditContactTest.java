package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.android.util.ScreenshotTaker.class)
public class CreateEditContactTest extends BaseTest {

    private String contactName;
    private String activityDescription;
    private String appointmentName;
    private String title = Helpers.generateString();
    private String newTitle = Helpers.generateString();

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String labelSave = PropertyLoader.loadProperty(commonPropertyPath, "labelSave");
    private final String labelCancel = PropertyLoader.loadProperty(commonPropertyPath, "labelCancel");
    private final String defaultWorksAt = PropertyLoader.loadProperty(commonPropertyPath, "defaultAccount");
    private final String titleSelectAccount = PropertyLoader.loadProperty(commonPropertyPath, "titleSelectAccount");
    private final String labelSearch = PropertyLoader.loadProperty(commonPropertyPath, "labelSearch");
    private final String labelResults = PropertyLoader.loadProperty(commonPropertyPath, "labelResults");
    private final String defaultCampaigns = PropertyLoader.loadProperty(commonPropertyPath, "labelNone");
    private final String labelNone = PropertyLoader.loadProperty(commonPropertyPath, "labelNone");
    private final String defaultCategories = PropertyLoader.loadProperty(commonPropertyPath, "labelNone");
    private final String labelNotes = PropertyLoader.loadProperty(commonPropertyPath, "labelNotes");
    private final String labelOtherInfo = PropertyLoader.loadProperty(commonPropertyPath, "labelOtherInfo");
    private final String titleAddCampaign = PropertyLoader.loadProperty(commonPropertyPath, "titleAddCampaign");
    private final String labelSelect = PropertyLoader.loadProperty(commonPropertyPath, "labelSelect");
    private final String account = PropertyLoader.loadProperty(commonPropertyPath, "account");
    private final String campaign = PropertyLoader.loadProperty(commonPropertyPath, "campaign");
    private final String newCampaign = PropertyLoader.loadProperty(commonPropertyPath, "newCampaign");
    private final String notes = PropertyLoader.loadProperty(commonPropertyPath, "notes");
    private final String newNotes = PropertyLoader.loadProperty(commonPropertyPath, "newNotes");
    private final String defaultUser = PropertyLoader.loadProperty(commonPropertyPath, "defaultUser");
    private final String dateToday = PropertyLoader.loadProperty(commonPropertyPath, "today");
    private final String currentUser = PropertyLoader.loadProperty(commonPropertyPath, "currentUser");
    private final String opportunity = PropertyLoader.loadProperty(commonPropertyPath, "opportunity");
    private final String newUser = PropertyLoader.loadProperty(commonPropertyPath, "newUser");
    private final String defaultCampaign = PropertyLoader.loadProperty(commonPropertyPath, "defaultCampaign");
    private final String titleOpportunity = PropertyLoader.loadProperty(commonPropertyPath, "labelOpportunity");

    private final String contactPropertyPath = "src/test/resources/contact.properties";
    private final String titleCreateContact = PropertyLoader.loadProperty(contactPropertyPath, "titleCreateContact");
    private final String defaultLabelContactName = PropertyLoader.loadProperty(contactPropertyPath, "defaultLabelContactName");
    private final String defaultLabelTitle = PropertyLoader.loadProperty(contactPropertyPath, "defaultLabelTitle");
    private final String labelWorksAt = PropertyLoader.loadProperty(contactPropertyPath, "labelWorksAt");
    private final String labelContactInformation = PropertyLoader.loadProperty(contactPropertyPath, "labelContactInformation");
    private final String labelCampaigns = PropertyLoader.loadProperty(contactPropertyPath, "labelCampaigns");
    private final String labelCategories = PropertyLoader.loadProperty(contactPropertyPath, "labelCategories");
    private final String category = PropertyLoader.loadProperty(contactPropertyPath, "category");
    private final String newCategory = PropertyLoader.loadProperty(contactPropertyPath, "newCategory");
    private final String phone = PropertyLoader.loadProperty(contactPropertyPath, "phone");
    private final String newPhone = PropertyLoader.loadProperty(contactPropertyPath, "newPhone");
    private final String mobile = PropertyLoader.loadProperty(contactPropertyPath, "mobile");
    private final String newMobile = PropertyLoader.loadProperty(contactPropertyPath, "newMobile");
    private final String email = PropertyLoader.loadProperty(contactPropertyPath, "email");
    private final String newEmail = PropertyLoader.loadProperty(contactPropertyPath, "newEmail");
    private final String extraID = PropertyLoader.loadProperty(contactPropertyPath, "extraID");
    private final String chanceOfSuccess = PropertyLoader.loadProperty(contactPropertyPath, "chanceOfSuccess");
    private final String newExtraID = PropertyLoader.loadProperty(contactPropertyPath, "newExtraID");
    private final String newChanceOfSuccess = PropertyLoader.loadProperty(contactPropertyPath, "newChanceOfSuccess");

    private final String activitiesPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String defaultActivityType = PropertyLoader.loadProperty(activitiesPropertyPath, "defaultActivityType");
    private final String defaultDescription = PropertyLoader.loadProperty(activitiesPropertyPath, "defaultDescription");
    private final String labelSelectOpportunity = PropertyLoader.loadProperty(activitiesPropertyPath, "labelSelectOpportunity");
    private final String titleCreate = PropertyLoader.loadProperty(activitiesPropertyPath, "titleCreate");
    private final String activityType = PropertyLoader.loadProperty(activitiesPropertyPath, "activityType");
    private final String dueDateMonth = PropertyLoader.loadProperty(activitiesPropertyPath, "dueDateMonth");
    private final String dueDateDay = PropertyLoader.loadProperty(activitiesPropertyPath, "dueDateDay");
    private final String dueDateYear = PropertyLoader.loadProperty(activitiesPropertyPath, "dueDateYear");
    private final String timeHours = PropertyLoader.loadProperty(activitiesPropertyPath, "timeHours");
    private final String timeMinutes = PropertyLoader.loadProperty(activitiesPropertyPath, "timeMinutes");
    private final String timeAmPm = PropertyLoader.loadProperty(activitiesPropertyPath, "timeAmPm");
    private final String time = PropertyLoader.loadProperty(activitiesPropertyPath, "time");
    private final String date = PropertyLoader.loadProperty(activitiesPropertyPath, "date");
    private final String expenses = PropertyLoader.loadProperty(activitiesPropertyPath, "expenses");
    private final String newExpenses = PropertyLoader.loadProperty(activitiesPropertyPath, "newExpenses");

    private final String createAppointmentPropertyPath = "src/test/resources/createEditAppointment.properties";
    private final String defaultAppointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "defaultAppointmentType");
    private final String appType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "appointmentType");
    private final String titleCreateApp = PropertyLoader.loadProperty(createAppointmentPropertyPath, "titleCreate");
    private final String location = PropertyLoader.loadProperty(createAppointmentPropertyPath, "location");
    private final String appEditTitle = PropertyLoader.loadProperty(createAppointmentPropertyPath, "titleEdit");
    private final String newAppointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newAppointmentType");
    private final String newStartHours = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartHours");
    private final String newStartMinutes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartMinutes");
    private final String newStartAmPm = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartAmPm");
    private final String newStartMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartMonth");
    private final String newStartDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartDay");
    private final String newStartYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartYear");
    private final String newEndMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndMonth");
    private final String newEndDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndDay");
    private final String newEndYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndYear");
    private final String newEndHours = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndHours");
    private final String newEndMinutes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndMinutes");
    private final String newEndAmPm = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndAmPm");
    private final String newStartFullDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartFullDate");
    private final String newStartTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartTime");
    private final String newEndFullDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndFullDate");
    private final String newEndTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndTime");
    private final String hoursInPreparation = PropertyLoader.loadProperty(createAppointmentPropertyPath, "hoursInPreparation");
    private final String newHoursInPreparation = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newHoursInPreparation");

    private final String opportunityPropertyPath = "src/test/resources/opportunity.properties";
    private final String stage = PropertyLoader.loadProperty(opportunityPropertyPath, "stage");
    private final String oppCreateTitle = PropertyLoader.loadProperty(opportunityPropertyPath, "titleCreate");
    private final String stageInOpp = PropertyLoader.loadProperty(opportunityPropertyPath, "stageInOpp");
    private final String secondUser = PropertyLoader.loadProperty(opportunityPropertyPath, "secondUser");
    private final String newMonth = PropertyLoader.loadProperty(opportunityPropertyPath, "newMonth");
    private final String newDay = PropertyLoader.loadProperty(opportunityPropertyPath, "newDay");
    private final String newYear = PropertyLoader.loadProperty(opportunityPropertyPath, "newYear");
    private final String newProduct = PropertyLoader.loadProperty(opportunityPropertyPath, "newProduct");
    private final String newStage = PropertyLoader.loadProperty(opportunityPropertyPath, "newStage");
    private final String newCloseDate = PropertyLoader.loadProperty(opportunityPropertyPath, "newCloseDate");
    private final String newStageInOpp = PropertyLoader.loadProperty(opportunityPropertyPath, "newStageInOpp");

    private final String newOrderPropertyPath = "src/test/resources/newOrder.properties";
    private final String product = PropertyLoader.loadProperty(newOrderPropertyPath, "product");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        LoginPage.login();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickContact();
        ContactManipulationPage.hideKeyboard();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
    }

    @Test(priority = 1) //CASE 22
    public void softContentOfCreateContactPage() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.checkPageTitle(titleCreateContact);
        softAssert.assertEquals(ContactManipulationPage.getLabelSave(), labelSave);
        softAssert.assertEquals(ContactManipulationPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(ContactManipulationPage.getLabelDescription(), defaultLabelContactName);
        softAssert.assertEquals(ContactManipulationPage.getDefaultLabelTitle(), defaultLabelTitle);
        softAssert.assertEquals(ContactManipulationPage.getLabelAccount(), labelWorksAt);
        softAssert.assertEquals(ContactManipulationPage.getAccount(), labelNone);
        ContactManipulationPage.clickAccount();
        softAssert.assertEquals(AddSelectEntityPage.getTitle(), titleSelectAccount);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), labelSearch);
        softAssert.assertEquals(AddSelectEntityPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(AddSelectEntityPage.getResultsLabelValue(), labelResults);
        AddSelectEntityPage.clickBack();
        ContactManipulationPage.hideKeyboard();
        softAssert.assertEquals(ContactManipulationPage.getLabelContactInformation(), labelContactInformation.toUpperCase());
        softAssert.assertEquals(ContactManipulationPage.getLabelCampaign(), labelCampaigns);
        softAssert.assertEquals(ContactManipulationPage.getCampaign(), defaultCampaigns);
        ContactManipulationPage.clickCampaign();
        softAssert.assertEquals(AddSelectEntityPage.getTitle(), titleAddCampaign);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), labelSearch);
        softAssert.assertEquals(AddSelectEntityPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(AddSelectEntityPage.getResultsLabelValue(), labelResults);
        softAssert.assertEquals(AddSelectEntityPage.getSelectButtonValue(), labelSelect);
        softAssert.assertEquals(AddSelectEntityPage.getLabelNone(), labelNone);
        AddSelectEntityPage.clickBack();
        ContactManipulationPage.hideKeyboard();
        softAssert.assertEquals(ContactManipulationPage.getLabelCategories(), labelCategories);
        softAssert.assertEquals(ContactManipulationPage.getCategories(), defaultCategories);
        ContactManipulationPage.clickCategories();
        softAssert.assertEquals(AddSelectEntityPage.getTitle(), labelCategories);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), labelSearch);
        softAssert.assertEquals(AddSelectEntityPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(AddSelectEntityPage.getResultsLabelValue(), labelResults);
        softAssert.assertEquals(AddSelectEntityPage.getSelectButtonValue(), labelSelect);
        softAssert.assertEquals(AddSelectEntityPage.getLabelNone(), labelNone);
        AddSelectEntityPage.clickBack();
        ContactManipulationPage.hideKeyboard();
        softAssert.assertEquals(ContactManipulationPage.getLabelNotes(), labelNotes);
        ContactManipulationPage.scrollToLabel(labelOtherInfo);
        softAssert.assertEquals(ContactManipulationPage.getLabelOtherInfo(), labelOtherInfo);
        softAssert.assertAll();
    }

    @Test(priority = 2) //CASE 23
    public void softCreateContact() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickNoThanks();
        softAssert.assertEquals(ContactPage.getContactName(), contactName);
        softAssert.assertEquals(ContactPage.getAccount(), account);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        softAssert.assertEquals(ContactPage.getExtraID(), extraID);
        softAssert.assertEquals(ContactPage.getChanceOfSuccess(), chanceOfSuccess + "%");
        ContactPage.scrollToLabel("Campaign");
        ContactManipulationPage.swipeFromTopToBottom();
        ContactPage.clickAccount();
        AccountPage.clickTabContacts();
        ContactsPage.clickSearch();
        ContactsPage.search(contactName);
        softAssert.assertEquals(ContactsPage.getFirstSearchResult(), contactName);
        softAssert.assertAll();
    }

    @Test(priority = 3) //CASE 24
    public void softCancelContactBeforeSave() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.scrollToLabel("Chance");
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickCancel();
        softAssert.assertTrue(LeftMenuPage.checkSearch());
        softAssert.assertEquals(LeftMenuPage.getHiddenPageTitle(), titleDashboard);
        softAssert.assertAll();
    }

    @Test(priority = 4) //CASE 25
    public void softEditContactWithHelpPopover() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.enterTitle(title);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterPhone(phone);
        ContactManipulationPage.enterMobile(mobile);
        ContactManipulationPage.enterEmail(email);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(category);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(notes);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickNoThanks();
        ContactManipulationPage.clickTools();
        ContactPage.clickEditContact();
        ContactManipulationPage.setContactName();
        String newContactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(newContactName);
        ContactManipulationPage.enterTitle(newTitle);
        ContactManipulationPage.enterPhone(newPhone);
        ContactManipulationPage.enterMobile(newMobile);
        ContactManipulationPage.enterEmail(newEmail);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        AddSelectEntityPage.unselect(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(newCategory);
        AddSelectEntityPage.unselect(category);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(newNotes);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.clearExtraID();
        ContactManipulationPage.enterExtraID(newExtraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.clearChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(newChanceOfSuccess);

        ContactManipulationPage.clickSave();
        softAssert.assertEquals(ContactPage.getContactName(), newContactName);
        softAssert.assertEquals(ContactPage.getAccount(), account);
        softAssert.assertEquals(ContactPage.getContactTitle(), newTitle.toUpperCase());
        softAssert.assertEquals(ContactPage.getPhone(), newPhone);
        softAssert.assertEquals(ContactPage.getMobile(), newMobile);
        softAssert.assertEquals(ContactPage.getEmail(), newEmail);
        softAssert.assertEquals(ContactPage.getCampaign(), newCampaign);
        softAssert.assertEquals(ContactPage.getCategory(), newCategory);
//        ContactPage.clickShowNotes();
        softAssert.assertEquals(ContactPage.getNotes(), newNotes);
//        ContactPage.clickShowMore();
        ContactPage.swipeFromBottomToTop();
        ContactPage.swipeFromBottomToTop();
        softAssert.assertEquals(ContactPage.getExtraID(), newExtraID);
        softAssert.assertEquals(ContactPage.getChanceOfSuccess(), newChanceOfSuccess + "%");
//        ContactPage.clickShowLess();
        ContactPage.scrollToLabel("Campaign");
        ContactPage.clickAccount();
        AccountPage.clickTabContacts();
        ContactsPage.clickSearch();
        ContactsPage.search(newContactName);
        softAssert.assertEquals(ContactsPage.getFirstSearchResult(), newContactName);
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void softEditContactWithHelpAddContactInfoForNameButton() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickNoThanks();
        ContactPage.clickAddContactInfo();
        ContactManipulationPage.setContactName();
        String newContactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(newContactName);
        ContactManipulationPage.enterTitle(newTitle);
        ContactManipulationPage.enterPhone(phone);
        ContactManipulationPage.enterMobile(mobile);
        ContactManipulationPage.enterEmail(email);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(category);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(notes);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.clearExtraID();
        ContactManipulationPage.enterExtraID(newExtraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.clearChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(newChanceOfSuccess);

        ContactManipulationPage.clickSave();
        softAssert.assertEquals(ContactPage.getContactName(), newContactName);
        softAssert.assertEquals(ContactPage.getAccount(), account);
        softAssert.assertEquals(ContactPage.getContactTitle(), newTitle.toUpperCase());
        softAssert.assertEquals(ContactPage.getPhone(), phone);
        softAssert.assertEquals(ContactPage.getMobile(), mobile);
        softAssert.assertEquals(ContactPage.getEmail(), email);
        softAssert.assertEquals(ContactPage.getCampaign(), campaign);
        softAssert.assertEquals(ContactPage.getCategory(), category);
        softAssert.assertEquals(ContactPage.getNotes(), notes);
        ContactPage.swipeFromBottomToTop();
        ContactPage.swipeFromBottomToTop();
        softAssert.assertEquals(ContactPage.getExtraID(), newExtraID);
        softAssert.assertEquals(ContactPage.getChanceOfSuccess(), newChanceOfSuccess + "%");
        ContactPage.scrollToLabel("Campaign");
        ContactPage.clickAccount();
        AccountPage.clickTabContacts();
        ContactsPage.clickSearch();
        ContactsPage.search(newContactName);
        softAssert.assertEquals(ContactsPage.getFirstSearchResult(), newContactName);
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void softCancelAfterSelectEditContact() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);
        ContactManipulationPage.enterPhone(newPhone);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickNoThanks();
        ContactManipulationPage.clickTools();
        ContactPage.clickEditContact();
        ContactManipulationPage.setContactName();
        String newContactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(newContactName);
        ContactManipulationPage.enterTitle(newTitle);
        ContactManipulationPage.enterPhone(phone);
        ContactManipulationPage.enterMobile(mobile);
        ContactManipulationPage.enterEmail(email);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(category);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(notes);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.clearExtraID();
        ContactManipulationPage.enterExtraID(newExtraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.clearChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(newChanceOfSuccess);

        ContactManipulationPage.clickCancel();
        softAssert.assertEquals(ContactPage.getContactName(), contactName);
        softAssert.assertEquals(ContactPage.getContactTitle(), title.toUpperCase());
        softAssert.assertEquals(ContactPage.getPhone(), newPhone);
        softAssert.assertEquals(ContactPage.getCampaign(), labelNone);
        softAssert.assertEquals(ContactPage.getCategory(), labelNone);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        softAssert.assertEquals(ContactPage.getExtraID(), extraID);
        softAssert.assertEquals(ContactPage.getChanceOfSuccess(), chanceOfSuccess + "%");

        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void softCreateContactAndCreateActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickActivity();
        ContactManipulationPage.hideKeyboard();
        softAssert.assertEquals(defaultActivityType, ActivityManipulationsPage.getActivityType());
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
        softAssert.assertEquals(account, ActivityManipulationsPage.getAccount());
        softAssert.assertEquals(contactName, ActivityManipulationsPage.getContact());
        softAssert.assertEquals(defaultUser, ActivityManipulationsPage.getUser());
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), labelSelectOpportunity);

        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);

        ActivityManipulationsPage.clickSave();
        softAssert.assertEquals(ActivityPage.getDescriptionOnView(), defaultDescription);
        softAssert.assertEquals(ActivityPage.getTitleOnView(), defaultActivityType.toUpperCase());
        softAssert.assertEquals(ActivityPage.getAccountName(), account);
        softAssert.assertEquals(ActivityPage.getUserName(), currentUser);
        softAssert.assertEquals(ActivityPage.getDate(), ActivityPage.getCurrentDate());
        softAssert.assertEquals(ActivityPage.getContact(), contactName);
        softAssert.assertEquals(ActivityPage.getCampaign(), campaign);
        softAssert.assertEquals(ActivityPage.getOpportunity(), labelNone);

        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityPage.getExpenses(), expenses + " SEK");

        ActivityPage.clickLeftMenu();
        LeftMenuPage.clickActivities();
        softAssert.assertTrue(ActivitiesPage.searchActivity(defaultDescription, dateToday));
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void softCreateContactAndCreateActivityAndCancel() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickActivity();
        ContactManipulationPage.hideKeyboard();
        ActivityManipulationsPage.checkPageTitle(titleCreate);
        ActivityManipulationsPage.clickCancel();
        softAssert.assertTrue(LeftMenuPage.checkSearch());
        softAssert.assertEquals(LeftMenuPage.getHiddenPageTitle(), titleDashboard);
        LeftMenuPage.clickSearch();
        SearchPage.search(account);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabContacts();
        ContactsPage.clickSearch();
        ContactsPage.search(contactName);
        softAssert.assertEquals(ContactsPage.getFirstSearchResult(), contactName);
        softAssert.assertAll();
    }

    @Test(priority = 9)
    public void softCreateContactAndCreateActivityAndEditActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickActivity();
        ActivityManipulationsPage.setDescription();
        activityDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(activityDescription);
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);

        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);

        ActivityManipulationsPage.clickSave();

        ActivityPage.clickTools();
        ActivityPage.clickEditActivity();
        ActivityManipulationsPage.setDescription();
        activityDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(activityDescription);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectValueFromPopUp(activityType);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateYear(dueDateYear);
        ActivityManipulationsPage.selectDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDateDay(dueDateDay);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(timeHours);
        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
//        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectValueFromPopUp(opportunity);
        ActivityManipulationsPage.clickUser();
        AddSelectEntityPage.select(newUser);
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo.toUpperCase());
        ActivityManipulationsPage.typeIntoNotes(notes);

        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(newExpenses);

        ActivityManipulationsPage.clickSave();

        softAssert.assertEquals(ActivityPage.getTitleOnView(), activityType.toUpperCase());
        softAssert.assertEquals(ActivityPage.getDescriptionOnView(), activityDescription);
        softAssert.assertEquals(ActivityPage.getAccountName(), account);
        softAssert.assertEquals(ActivityPage.getUserName(), newUser);
        softAssert.assertEquals(ActivityPage.getDate(), date);
        softAssert.assertEquals(ActivityPage.getTime(), time);
        softAssert.assertEquals(ActivityPage.getContact(), contactName);
        softAssert.assertEquals(ActivityPage.getCampaign(), newCampaign);
        softAssert.assertEquals(ActivityPage.getOpportunity(), opportunity);
        softAssert.assertEquals(ActivityPage.getNotes(), notes);

        ActivityPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityPage.getExpenses(), newExpenses + " SEK");
        softAssert.assertAll();
    }

    @Test(priority = 10)
    public void softCreateContactAndCreateAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickAppointment();
        ContactManipulationPage.hideKeyboard();
        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        softAssert.assertEquals(defaultAppointmentType, AppointmentManipulationsPage.getAppointmentType());
        softAssert.assertEquals(AppointmentManipulationsPage.getCurrentDate(), AppointmentManipulationsPage.getStartDate());
        softAssert.assertEquals(AppointmentManipulationsPage.getAppEndDate(), AppointmentManipulationsPage.getEndDate());
        softAssert.assertEquals(AppointmentManipulationsPage.getAccount(), account);
        softAssert.assertEquals(AppointmentManipulationsPage.getContact(), contactName);
        softAssert.assertEquals(AppointmentManipulationsPage.getUser(), defaultUser);

        AppointmentManipulationsPage.swipeFromBottomToTop();
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);

        AppointmentManipulationsPage.clickSave();
        softAssert.assertEquals(AppointmentPage.getTitleOnView(), defaultAppointmentType.toUpperCase());
        softAssert.assertEquals(AppointmentPage.getDescriptionOnView(), defaultDescription);
        softAssert.assertEquals(AppointmentPage.getAccountName(), account);
        softAssert.assertEquals(AppointmentPage.getContactOnView(), contactName);
        AppointmentManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(AppointmentPage.getHoursInPreparation(), hoursInPreparation);
        softAssert.assertAll();
    }

    @Test(priority = 11)
    public void softCreateContactAndCreateAppointmentAndCancel() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickAppointment();
        AppointmentManipulationsPage.checkPageTitle(titleCreateApp);
        AppointmentManipulationsPage.clickCancel();
        softAssert.assertTrue(LeftMenuPage.checkSearch());
        softAssert.assertEquals(LeftMenuPage.getHiddenPageTitle(), titleDashboard);
        LeftMenuPage.clickSearch();
        SearchPage.search(account);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabContacts();
        ContactsPage.clickSearch();
        ContactsPage.search(contactName);
        softAssert.assertEquals(ContactsPage.getFirstSearchResult(), contactName);
        softAssert.assertAll();
    }

    @Test(priority = 12)
    public void softCreateContactAndCreateAppointmentAndEditAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickAppointment();
        ContactManipulationPage.hideKeyboard();
        AppointmentManipulationsPage.setAppointmentName();
        appointmentName = AppointmentManipulationsPage.getAppointmentName();
        AppointmentManipulationsPage.enterDescription(appointmentName);

        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.selectValueFromPopUp(opportunity);
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        AppointmentManipulationsPage.typeIntoNotes(notes);

        AppointmentManipulationsPage.swipeFromBottomToTop();
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);

        AppointmentManipulationsPage.clickSave();

        AppointmentPage.clickTools();
        AppointmentPage.clickEditAppointment();
        softAssert.assertEquals(AppointmentManipulationsPage.getTitle(), appEditTitle);
        AppointmentManipulationsPage.setAppointmentName();
        appointmentName = AppointmentManipulationsPage.getAppointmentName();
        AppointmentManipulationsPage.enterDescription(appointmentName);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.selectValueFromPopUp(newAppointmentType);

        AppointmentManipulationsPage.clickStartsDate();
        AppointmentManipulationsPage.selectDateMonth(newStartMonth);
        AppointmentManipulationsPage.selectDateDay(newStartDay);
        AppointmentManipulationsPage.selectDateYear(newStartYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.selectTimeHours(newStartHours);
        AppointmentManipulationsPage.selectTimeMinutes(newStartMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(newStartAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsDate();
        AppointmentManipulationsPage.selectDateMonth(newEndMonth);
        AppointmentManipulationsPage.selectDateDay(newEndDay);
        AppointmentManipulationsPage.selectDateYear(newEndYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.selectTimeHours(newEndHours);
        AppointmentManipulationsPage.selectTimeMinutes(newEndMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(newEndAmPm);
        AppointmentManipulationsPage.closePicker();

        AppointmentManipulationsPage.clickLocation();
        AppointmentManipulationsPage.enterLocation(location);

        AppointmentManipulationsPage.clickUser();
        AddSelectEntityPage.select(currentUser);
        AddSelectEntityPage.select(newUser);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        ActivityManipulationsPage.swipeFromBottomToTop();
        AppointmentManipulationsPage.typeIntoNotes(newNotes);

        AppointmentManipulationsPage.swipeFromBottomToTop();
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(newHoursInPreparation);

        AppointmentManipulationsPage.clickSave();

        softAssert.assertEquals(AppointmentPage.getTitleOnView(), newAppointmentType.toUpperCase());
        softAssert.assertEquals(AppointmentPage.getDescriptionOnView(), appointmentName);
        softAssert.assertEquals(AppointmentPage.getAccountName(), account);
        softAssert.assertEquals(AppointmentPage.getUserName(), newUser);
        softAssert.assertEquals(AppointmentPage.getStartDate(), newStartFullDate);
        softAssert.assertEquals(AppointmentPage.getStartTime(), newStartTime);
        softAssert.assertEquals(AppointmentPage.getEndDate(), newEndFullDate);
        softAssert.assertEquals(AppointmentPage.getEndTime(), newEndTime);
        softAssert.assertEquals(AppointmentPage.getLocation(), location);
        softAssert.assertEquals(AppointmentPage.getContactOnView(), contactName);
        softAssert.assertEquals(AppointmentPage.getCampaign(), newCampaign);
        softAssert.assertEquals(AppointmentPage.getOpportunity(), opportunity);
        ActivityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(AppointmentPage.getNotes(), newNotes);
        AppointmentManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(AppointmentPage.getHoursInPreparation(), newHoursInPreparation);

        softAssert.assertAll();
    }

    @Test(priority = 13)
    public void softCreateContactAndCreateOpportunity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickOpportunity();
        softAssert.assertEquals(OpportunityManipulationsPage.getTitle(), oppCreateTitle);
        OpportunityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(OpportunityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(OpportunityManipulationsPage.getCloseDate(), Helpers.getCurrentDate());
        softAssert.assertEquals(OpportunityManipulationsPage.getAccount(), account);
        softAssert.assertEquals(OpportunityManipulationsPage.getContact(), contactName);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(stage);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickSave();
        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), defaultDescription);
        softAssert.assertEquals(OpportunityPage.getAccount(), account);
        softAssert.assertEquals(OpportunityPage.getUser(), currentUser);
        softAssert.assertEquals(OpportunityPage.getTitleOnView(), titleOpportunity.toUpperCase());
        softAssert.assertEquals(OpportunityPage.getCloseDateInOpportunity(), Helpers.getCurrentDate());
        softAssert.assertEquals(OpportunityPage.getStage(), stageInOpp);
        softAssert.assertEquals(OpportunityPage.getContact(), contactName);
        softAssert.assertEquals(OpportunityPage.getCampaign(), defaultCampaign);
        OpportunityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(OpportunityPage.getProduct(), product);
        softAssert.assertAll();
    }

    @Test(priority = 14)
    public void softCreateContactAndCreateOpportunityAndCancel() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickOpportunity();
        OpportunityManipulationsPage.hideKeyboard();
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(stage);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickCancel();
        softAssert.assertTrue(LeftMenuPage.checkSearch());
        softAssert.assertEquals(LeftMenuPage.getHiddenPageTitle(), titleDashboard);
        softAssert.assertAll();
    }

    @Test(priority = 15)
    public void softCreateContactAndCreateOpportunityAndEditOpportunity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        OpportunityManipulationsPage.hideKeyboard();
        ContactManipulationPage.clickOpportunity();
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(stage);
        OpportunityManipulationsPage.hideKeyboard();
        OpportunityManipulationsPage.scrollToLabel(labelOtherInfo);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickSave();
        OpportunityPage.clickTools();
        OpportunityPage.clickEditOpportunity();
        OpportunityManipulationsPage.setOpportunityName();
        String newOppName = OpportunityManipulationsPage.getOpportunityName();
        OpportunityManipulationsPage.enterDescription(newOppName);
        OpportunityManipulationsPage.clickUser();
        OpportunityManipulationsPage.selectValueFromPopUp(secondUser);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(newStage);
        OpportunityManipulationsPage.clickCloseDate();
        OpportunityManipulationsPage.selectDateYear(newYear);
        OpportunityManipulationsPage.selectDateMonth(newMonth);
        OpportunityManipulationsPage.selectDateDay(newDay);
        OpportunityManipulationsPage.closePicker();
        OpportunityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        OpportunityManipulationsPage.clickLabelProduct();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(newProduct);
        NewOrderRowPage.clickSave();
        OpportunityManipulationsPage.swipeFromBottomToTop();
        OpportunityManipulationsPage.typeIntoNotes(newNotes);
        OpportunityManipulationsPage.clickSave();
        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), newOppName);
        softAssert.assertEquals(OpportunityPage.getAccount(), account);
        softAssert.assertEquals(OpportunityPage.getUser(), secondUser);
        softAssert.assertEquals(OpportunityPage.getStage(), newStageInOpp);
        softAssert.assertEquals(OpportunityPage.getCloseDateInOpportunity(), newCloseDate);
        softAssert.assertEquals(OpportunityPage.getContact(), contactName);
        softAssert.assertEquals(OpportunityPage.getCampaign(), newCampaign);
        OpportunityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(OpportunityPage.getNotes(), newNotes);
        softAssert.assertEquals(OpportunityPage.getProduct(), newProduct);
        softAssert.assertAll();
    }

    @Test(priority = 16)
    public void softCreateContactCallAndSendMessage() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(account);
        ContactManipulationPage.enterTitle(title);

        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);

        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickNoThanks();
        ContactPage.clickAddContactInfo();
        ContactManipulationPage.enterPhone(phone);
        ContactManipulationPage.enterMobile(mobile);
        ContactManipulationPage.enterEmail(email);
        ContactManipulationPage.clickSave();
        ContactPage.clickPhone();
        ContactPage.clickBackOnDevice();
//        ContactPage.clickBackOnDevice();
//        ContactPage.clickBackOnDevice();
        Thread.sleep(1000);
        ContactPage.clickMobile();
        ContactPage.clickBackOnDevice();
//        ContactPage.clickBackOnDevice();
//        ContactPage.clickBackOnDevice();
        Thread.sleep(1000);
        ContactPage.clickEmail();
        softAssert.assertEquals(ContactPage.getAlertTitle(), "Share with");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
