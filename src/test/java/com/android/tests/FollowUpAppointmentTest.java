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
public class FollowUpAppointmentTest extends BaseTest {

    private String description;

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String account = PropertyLoader.loadProperty(commonPropertyPath, "account");
    private final String contact = PropertyLoader.loadProperty(commonPropertyPath, "contact");
    private final String opportunity = PropertyLoader.loadProperty(commonPropertyPath, "opportunity");
    private final String user = PropertyLoader.loadProperty(commonPropertyPath, "user");
    private final String yourUser = PropertyLoader.loadProperty(commonPropertyPath, "currentUser");
    private final String campaign = PropertyLoader.loadProperty(commonPropertyPath, "campaign");
    private final String notes = PropertyLoader.loadProperty(commonPropertyPath, "notes");
    private final String newContact = PropertyLoader.loadProperty(commonPropertyPath, "newContact");
    private final String newCampaign = PropertyLoader.loadProperty(commonPropertyPath, "newCampaign");
    private final String newNotes = PropertyLoader.loadProperty(commonPropertyPath, "newNotes");
    private final String labelNone = PropertyLoader.loadProperty(commonPropertyPath, "labelNone");
    private final String defaultLabelDescription = PropertyLoader.loadProperty(commonPropertyPath, "defaultDescription");
    private final String labelAccount = PropertyLoader.loadProperty(commonPropertyPath, "labelAccount");
    private final String defaultAccount = PropertyLoader.loadProperty(commonPropertyPath, "defaultAccount");
    private final String labelOpportunity = PropertyLoader.loadProperty(commonPropertyPath, "labelOpportunity");
    private final String labelUser = PropertyLoader.loadProperty(commonPropertyPath, "labelUser");
    private final String defaultUser = PropertyLoader.loadProperty(commonPropertyPath, "defaultUser");
    private final String labelCampaign = PropertyLoader.loadProperty(commonPropertyPath, "labelCampaign");
    private final String defaultCampaign = PropertyLoader.loadProperty(commonPropertyPath, "defaultCampaign");
    private final String labelNotes = PropertyLoader.loadProperty(commonPropertyPath, "labelNotes");
    private final String titleSelectAccount = PropertyLoader.loadProperty(commonPropertyPath, "titleSelectAccount");
    private final String labelSearch = PropertyLoader.loadProperty(commonPropertyPath, "labelSearch");
    private final String labelCancel = PropertyLoader.loadProperty(commonPropertyPath, "labelCancel");
    private final String labelResults = PropertyLoader.loadProperty(commonPropertyPath, "labelResults");
    private final String labelOtherInfo = PropertyLoader.loadProperty(commonPropertyPath, "labelOtherInfo");
    private final String titleAddCampaign = PropertyLoader.loadProperty(commonPropertyPath, "titleAddCampaign");
    private final String labelSave = PropertyLoader.loadProperty(commonPropertyPath, "labelSave");

    private final String createAppointmentPropertyPath = "src/test/resources/createEditAppointment.properties";
    private final String titleCreateAppointment = PropertyLoader.loadProperty(createAppointmentPropertyPath, "titleCreate");
    private final String appointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "appointmentType");
    private final String defaultAppointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "defaultAppointmentType");
    private final String startDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startDate");
    private final String startMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startMonth");
    private final String startDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startDay");
    private final String startYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startYear");
    private final String startHours = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startHours");
    private final String startMinutes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startMinutes");
    private final String startAmPm = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startAmPm");
    private final String endDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endDate");
    private final String endMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endMonth");
    private final String endDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endDay");
    private final String endYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endYear");
    private final String endHours = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endHours");
    private final String endMinutes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endMinutes");
    private final String endAmPm = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endAmPm");
    private final String location = PropertyLoader.loadProperty(createAppointmentPropertyPath, "location");
    private final String startDateTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startDateTime");
    private final String endDateTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endDateTime");
    private final String startFullDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startFullDate");
    private final String startTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startTime");
    private final String endFullDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endFullDate");
    private final String endTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endTime");
    private final String newStartDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartDate");
    private final String newStartMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartMonth");
    private final String newStartDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartDay");
    private final String newStartYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartYear");
    private final String newEndMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndMonth");
    private final String newEndDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndDay");
    private final String newEndYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndYear");
    private final String newStartHours = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartHours");
    private final String newStartMinutes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartMinutes");
    private final String newStartAmPm = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartAmPm");
    private final String newEndDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndDate");
    private final String newEndHours = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndHours");
    private final String newEndMinutes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndMinutes");
    private final String newEndAmPm = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndAmPm");
    private final String newStartFullDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartFullDate");
    private final String newStartTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartTime");
    private final String newEndFullDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndFullDate");
    private final String newEndTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndTime");
    private final String labelContact = PropertyLoader.loadProperty(createAppointmentPropertyPath, "labelContact");
    private final String defaultContact = PropertyLoader.loadProperty(createAppointmentPropertyPath, "defaultContact");
    private final String defaultOpportunity = PropertyLoader.loadProperty(createAppointmentPropertyPath, "defaultOpportunity");
    private final String defaultOpportunityWithAcc = PropertyLoader.loadProperty(createAppointmentPropertyPath, "defaultOpportunityWithAcc");
    private final String newAppointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newAppointmentType");
    private final String newLocation = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newLocation");
    private final String hoursInPreparation = PropertyLoader.loadProperty(createAppointmentPropertyPath, "hoursInPreparation");
    private final String motesalternativ = PropertyLoader.loadProperty(createAppointmentPropertyPath, "motesalternativ");
    private final String motetCustomfalt = PropertyLoader.loadProperty(createAppointmentPropertyPath, "motetCustomfalt");

    private final String createActivityPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String titleCreateActivity = PropertyLoader.loadProperty(createActivityPropertyPath, "titleCreate");
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
//    private final String defaultOpportunity = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultOpportunity");
    private final String activityTypes = PropertyLoader.loadProperty(createActivityPropertyPath, "activityTypes");
//    private final String defaultContact = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultContact");
    private final String activityDate = PropertyLoader.loadProperty(createActivityPropertyPath, "date");
    private final String defaultTime = PropertyLoader.loadProperty(createActivityPropertyPath, "defaultTime");
    private final String labelTime = PropertyLoader.loadProperty(createActivityPropertyPath, "labelTime");
    private final String expenses = PropertyLoader.loadProperty(createActivityPropertyPath, "expenses");

    private final String filterPropertyPath = "src/test/resources/filter.properties";
    private final String dateOneYear = PropertyLoader.loadProperty(filterPropertyPath, "dateOneYear");

    private final String followUpAppointmentPropertyPath = "src/test/resources/followUpAppointment.properties";
    private final String appName = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "dashName");
    private final String appType = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "dashType");
    private final String appAccount = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "dashAccount");
    private final String appContact = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "dashContact");
    private final String appOpportunity = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "dashOpportunity");
    private final String appOpportunityOnWheel = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "dashOpportunityOnWheel");

    private final String appActAccount = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "accAccount");
    private final String appActAppointment = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "accAppointment");
    private final String appActType = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "accType");
    private final String appActContact = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "accContact");
    private final String appActCampaign = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "accCampaign");
    private final String appActNotes = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "accNotes");
    private final String appActMotesalternativ = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "accMotesalternativ");
    private final String appActMotetCustomfalt = PropertyLoader.loadProperty(followUpAppointmentPropertyPath, "accMotetCustomfalt");

    @BeforeMethod
    public void setUp () throws Exception{
        super.setUp();
        LoginPage.login();
        AppointmentManipulationsPage.setAppointmentName();
        description = AppointmentManipulationsPage.getAppointmentName();
    }

    @Test(priority = 1) // Case 7
    public void softFollowUpAppointmentFromSideMenu() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickAppointment();
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.selectValueFromPopUp(appointmentType);
        AppointmentManipulationsPage.clickStartsDate();
        AppointmentManipulationsPage.selectDateMonth(startMonth);
        AppointmentManipulationsPage.selectDateDay(startDay);
        AppointmentManipulationsPage.selectDateYear(startYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickStartsTime();
        AppointmentManipulationsPage.selectTimeHours(startHours);
        AppointmentManipulationsPage.selectTimeMinutes(startMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(startAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsDate();
        AppointmentManipulationsPage.selectDateMonth(endMonth);
        AppointmentManipulationsPage.selectDateDay(endDay);
        AppointmentManipulationsPage.selectDateYear(endYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsTime();
        AppointmentManipulationsPage.selectTimeHours(endHours);
        AppointmentManipulationsPage.selectTimeMinutes(endMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(endAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickLocation();
        AppointmentManipulationsPage.enterLocation(location);
        AppointmentManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        AppointmentManipulationsPage.clickContacts();
        AddSelectEntityPage.select(contact);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.selectValueFromPopUp(opportunity);
        AppointmentManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        AddSelectEntityPage.select(yourUser);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AppointmentManipulationsPage.scrollToLabel(labelOtherInfo);
        AppointmentManipulationsPage.typeIntoNotes(notes);
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);
        AppointmentManipulationsPage.clickSave();

        AppointmentPage.clickTools();
        AppointmentPage.clickFollowUpAppointment();
        AppointmentPage.alertConfirm();

        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        AppointmentManipulationsPage.hideKeyboard();
        softAssert.assertEquals(AppointmentManipulationsPage.getTitle(), titleCreateAppointment);
        softAssert.assertEquals(AppointmentManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(AppointmentManipulationsPage.getAppointmentType(), appointmentType);
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppStartDate(),
                AppointmentManipulationsPage.getStartDate() + " " + AppointmentManipulationsPage.getStartTime());
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppEndDate(),
                AppointmentManipulationsPage.getEndDate() + " " + AppointmentManipulationsPage.getEndTime());
        softAssert.assertEquals(AppointmentManipulationsPage.getAccount(), account);
        softAssert.assertEquals(AppointmentManipulationsPage.getContact(), contact);
        softAssert.assertEquals(AppointmentManipulationsPage.getOpportunity(), defaultOpportunityWithAcc);
        softAssert.assertEquals(AppointmentManipulationsPage.getUser(), user);
        softAssert.assertEquals(AppointmentManipulationsPage.getCampaign(), campaign);
        AppointmentManipulationsPage.scrollToLabel(labelOtherInfo);
        softAssert.assertEquals(AppointmentManipulationsPage.getNotes(), notes);
        softAssert.assertEquals(AppointmentManipulationsPage.getHoursInPreparation(), hoursInPreparation);

        AppointmentManipulationsPage.setAppointmentName();
        description = AppointmentManipulationsPage.getAppointmentName();

        AppointmentManipulationsPage.scrollToLabel("Description");
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickLocation();
        AppointmentManipulationsPage.enterLocation(newLocation);
        AppointmentManipulationsPage.clickStartsDate();
        AppointmentManipulationsPage.selectDateMonth(newStartMonth);
        AppointmentManipulationsPage.selectDateDay(newStartDay);
        AppointmentManipulationsPage.selectDateYear(newStartYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickStartsTime();
        AppointmentManipulationsPage.selectTimeHours(newStartHours);
        AppointmentManipulationsPage.selectTimeMinutes(newStartMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(newStartAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsDate();
        AppointmentManipulationsPage.selectDateMonth(newEndMonth);
        AppointmentManipulationsPage.selectDateDay(newEndDay);
        AppointmentManipulationsPage.selectDateYear(newEndYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsTime();
        AppointmentManipulationsPage.selectTimeHours(newEndHours);
        AppointmentManipulationsPage.selectTimeMinutes(newEndMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(newEndAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.selectValueFromPopUp(newAppointmentType);
        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.selectValueFromPopUp(opportunity);
        AppointmentManipulationsPage.clickSave();

        softAssert.assertEquals(AppointmentPage.getTitleOnView(), newAppointmentType.toUpperCase());
        softAssert.assertEquals(AppointmentPage.getDescriptionOnView(), description);
        softAssert.assertEquals(AppointmentPage.getAccountName(), account);
        softAssert.assertEquals(AppointmentPage.getUserName(), user);
        softAssert.assertEquals(AppointmentPage.getStartDate(), newStartFullDate);
        softAssert.assertEquals(AppointmentPage.getStartTime(), newStartTime);
        softAssert.assertEquals(AppointmentPage.getEndDate(), newEndFullDate);
        softAssert.assertEquals(AppointmentPage.getEndTime(), newEndTime);
        softAssert.assertEquals(AppointmentPage.getLocation(), newLocation);
        softAssert.assertEquals(AppointmentPage.getContactOnView(), contact);
        softAssert.assertEquals(AppointmentPage.getCampaign(), campaign);
//        softAssert.assertEquals(AppointmentPage.getOpportunity(), opportunity);
        softAssert.assertEquals(AppointmentPage.getNotes(), notes);
//        AppointmentPage.scrollToLabel("Hours");
        AppointmentPage.swipeFromBottomToTop();
        softAssert.assertEquals(AppointmentPage.getHoursInPreparation(), hoursInPreparation);
        softAssert.assertAll();
    }

    @Test(priority = 2) // Case 8
    public void softFollowUpActivityFromSideMenu() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickAppointment();
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.selectValueFromPopUp(appointmentType);
        AppointmentManipulationsPage.clickStartsDate();
        AppointmentManipulationsPage.selectDateMonth(startMonth);
        AppointmentManipulationsPage.selectDateDay(startDay);
        AppointmentManipulationsPage.selectDateYear(startYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickStartsTime();
        AppointmentManipulationsPage.selectTimeHours(startHours);
        AppointmentManipulationsPage.selectTimeMinutes(startMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(startAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsDate();
        AppointmentManipulationsPage.selectDateMonth(endMonth);
        AppointmentManipulationsPage.selectDateDay(endDay);
        AppointmentManipulationsPage.selectDateYear(endYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsTime();
        AppointmentManipulationsPage.selectTimeHours(endHours);
        AppointmentManipulationsPage.selectTimeMinutes(endMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(endAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        AppointmentManipulationsPage.clickContacts();
        AddSelectEntityPage.select(contact);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.selectValueFromPopUp(opportunity);
        AppointmentManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        AddSelectEntityPage.select(yourUser);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AppointmentManipulationsPage.scrollToLabel(labelOtherInfo);
        AppointmentManipulationsPage.typeIntoNotes(notes);
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);
        AppointmentManipulationsPage.clickSave();

        AppointmentPage.clickTools();
        AppointmentPage.clickFollowUpActivity();
        AppointmentPage.alertConfirm();

        ActivityPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getTitle(), titleCreateActivity);
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), defaultActivityType);
        softAssert.assertEquals(ActivityManipulationsPage.getDueDate(), ActivityManipulationsPage.getCurrentDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), account);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), contact);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), defaultOpportunityWithAcc);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), user);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), campaign);
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo);
        softAssert.assertEquals(ActivityManipulationsPage.getNotes(), notes);

        ActivityManipulationsPage.setDescription();
        String activityDescription = ActivityManipulationsPage.getDescription();
        AccountManipulationsPage.scrollToLabel("Description");
        ActivityManipulationsPage.enterDescription(activityDescription);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectValueFromPopUp(activityType);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDateDay(dueDateDay);
        ActivityManipulationsPage.selectDateYear(dueDateYear);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(timeHours);
        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.selectValueFromPopUp(opportunity);
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo);
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();

        softAssert.assertEquals(ActivityPage.getTitleOnView(), activityType.toUpperCase());
        softAssert.assertEquals(BasePage.getDescriptionOnView(), activityDescription);
        softAssert.assertEquals(ActivityPage.getUserName(), user);
        softAssert.assertEquals(ActivityPage.getDate(), activityDate);
        softAssert.assertEquals(ActivityPage.getContact(), contact);
        softAssert.assertEquals(ActivityPage.getCampaign(), campaign);
        softAssert.assertEquals(ActivityPage.getOpportunity(), opportunity);
        softAssert.assertEquals(ActivityPage.getNotes(), notes);
        ActivityPage.swipeFromBottomToTop();
        ActivityPage.scrollToLabel("Expenses");
        softAssert.assertEquals(ActivityPage.getExpenses(), expenses + " SEK");

        ActivityPage.clickBack();
//        AppointmentPage.clickLeftMenu();
//        LeftMenuPage.clickActivities();
//        ActivitiesPage.clickFilter();
//        FilterPage.clickUsers();
//        FilterPage.select(yourUser);
//        FilterPage.select(user);
//        FilterPage.clickBack();
//        FilterPage.clickDate();
//        FilterPage.select(dateOneYear);
//        FilterPage.clickClose();
//        softAssert.assertTrue(ActivitiesPage.searchActivityByName(activityDescription));
        softAssert.assertAll();
    }

    @Test(priority = 3) // Case 13
    public void softFollowUpAppointmentFromDashboard() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        Thread.sleep(2000);
        DashboardPage.selectAppointment(appName);
        AppointmentPage.clickTools();
        AppointmentPage.clickFollowUpAppointment();
        AppointmentPage.alertConfirm();

        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        AppointmentManipulationsPage.hideKeyboard();
        softAssert.assertEquals(AppointmentManipulationsPage.getTitle(), titleCreateAppointment);
        softAssert.assertEquals(AppointmentManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(AppointmentManipulationsPage.getAppointmentType(), appType);
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppStartDate(),
                AppointmentManipulationsPage.getStartDate() + " " + AppointmentManipulationsPage.getStartTime());
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppEndDate(),
                AppointmentManipulationsPage.getEndDate() + " " + AppointmentManipulationsPage.getEndTime());
        softAssert.assertEquals(AppointmentManipulationsPage.getAccount(), appAccount);
        softAssert.assertEquals(AppointmentManipulationsPage.getContact(), appContact);
        softAssert.assertEquals(AppointmentManipulationsPage.getOpportunity(), defaultOpportunity);
        softAssert.assertEquals(AppointmentManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(AppointmentManipulationsPage.getCampaign(), defaultCampaign);
        AppointmentManipulationsPage.scrollToLabel(labelOtherInfo);
        softAssert.assertTrue(AppointmentManipulationsPage.getNotes().startsWith(yourUser));

        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        AppointmentManipulationsPage.scrollToLabel("Description");
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickLocation();
        AppointmentManipulationsPage.enterLocation(newLocation);
        AppointmentManipulationsPage.clickStartsDate();
        AppointmentManipulationsPage.selectDateMonth(startMonth);
        AppointmentManipulationsPage.selectDateDay(startDay);
        AppointmentManipulationsPage.selectDateYear(startYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickStartsTime();
        AppointmentManipulationsPage.selectTimeHours(startHours);
        AppointmentManipulationsPage.selectTimeMinutes(startMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(startAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsDate();
        AppointmentManipulationsPage.selectDateMonth(endMonth);
        AppointmentManipulationsPage.selectDateDay(endDay);
        AppointmentManipulationsPage.selectDateYear(endYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsTime();
        AppointmentManipulationsPage.selectTimeHours(endHours);
        AppointmentManipulationsPage.selectTimeMinutes(endMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(endAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.selectValueFromPopUp(newAppointmentType);
        AppointmentManipulationsPage.scrollToLabel("Hours in");
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);
//        AppointmentManipulationsPage.clickOpportunity();
//        AppointmentManipulationsPage.spinOpportunityWheelTo(appOpportunityOnWheel);
//        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.clickSave();

        softAssert.assertEquals(AppointmentPage.getTitle(), newAppointmentType.toUpperCase());
        softAssert.assertEquals(AppointmentPage.getDescriptionOnView(), description);
        softAssert.assertEquals(AppointmentPage.getAccountName(), appAccount);
        softAssert.assertEquals(AppointmentPage.getUserName(), yourUser);
        softAssert.assertEquals(AppointmentPage.getStartDate(), startFullDate);
        softAssert.assertEquals(AppointmentPage.getStartTime(), startTime);
        softAssert.assertEquals(AppointmentPage.getEndDate(), endFullDate);
        softAssert.assertEquals(AppointmentPage.getEndTime(), endTime);
        softAssert.assertEquals(AppointmentPage.getLocation(), newLocation);
        softAssert.assertEquals(AppointmentPage.getContactOnView(), appContact);
        softAssert.assertEquals(AppointmentPage.getCampaign(), labelNone);
//        softAssert.assertEquals(AppointmentPage.getOpportunity(), labelNone);
        softAssert.assertTrue(AppointmentPage.getNotes().startsWith(yourUser));
        AppointmentPage.swipeFromBottomToTop();
        AppointmentPage.swipeFromBottomToTop();
        softAssert.assertEquals(AppointmentPage.getHoursInPreparation(), hoursInPreparation);
        softAssert.assertAll();
    }

    @Test(priority = 4) // Case 14
    public void softFollowUpActivityFromDashboard() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        Thread.sleep(2000);
        DashboardPage.selectAppointment(appName);
        AppointmentPage.clickTools();
        AppointmentPage.clickFollowUpActivity();
        AppointmentPage.alertConfirm();

        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        AppointmentManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getTitle(), titleCreateActivity);
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), defaultActivityType);
        softAssert.assertEquals(ActivityManipulationsPage.getDueDate(), ActivityManipulationsPage.getCurrentDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), appAccount);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), " " + appContact);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), defaultOpportunity);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), " " + defaultUser);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), defaultCampaign);
        softAssert.assertTrue(ActivityManipulationsPage.getNotes().startsWith(yourUser));

        ActivityManipulationsPage.setDescription();
        String activityDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(activityDescription);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectValueFromPopUp(activityType);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDateDay(dueDateDay);
        ActivityManipulationsPage.selectDateYear(dueDateYear);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(timeHours);
        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickOpportunity();
//        ActivityManipulationsPage.spinOpportunityWheelTo(appOpportunity);
//        ActivityManipulationsPage.clickOpportunity();
        ActivityPage.scrollToLabel("Expenses");
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();

        softAssert.assertEquals(ActivityPage.getTitle(), activityType.toUpperCase());
        softAssert.assertEquals(BasePage.getDescriptionOnView(), activityDescription);
        softAssert.assertEquals(ActivityPage.getAccountName(), appAccount);
        softAssert.assertEquals(ActivityPage.getUserName(), yourUser);
        softAssert.assertEquals(ActivityPage.getDate(), activityDate);
        softAssert.assertEquals(ActivityPage.getContact(), appContact);
        softAssert.assertEquals(ActivityPage.getCampaign(), labelNone);
        softAssert.assertEquals(ActivityPage.getOpportunity(), labelNone);
        softAssert.assertTrue(ActivityPage.getNotes().startsWith(yourUser));
        ActivityPage.swipeFromBottomToTop();
        ActivityPage.swipeFromBottomToTop();
        ActivityPage.scrollToLabel("Expenses");
        softAssert.assertEquals(ActivityPage.getExpenses(), expenses);

        ActivityPage.clickBack();
//        AppointmentPage.clickLeftMenuInFollowUp();
//        DashboardPage.clickLeftMenu();
//        LeftMenuPage.clickActivities();
////        ActivitiesPage.clickFilter();
////        FilterPage.clickDate();
////        FilterPage.select(dateOneYear);
////        FilterPage.clickClose();
//        softAssert.assertTrue(ActivitiesPage.searchActivityByName(activityDescription));

        softAssert.assertAll();
    }

    @Test(priority = 5) // Case 15
    public void softFollowUpAppointmentFromAccount() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(appActAccount);
        SearchPage.clickOnFirstSearchResult();
        Thread.sleep(500);
        AccountPage.clickTabActivities();
        Thread.sleep(500);
        ActivitiesPage.selectActivity(appActAppointment);
        AppointmentPage.clickTools();
        AppointmentPage.clickFollowUpAppointment();
        AppointmentPage.alertConfirm();

        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        AppointmentManipulationsPage.hideKeyboard();
        softAssert.assertEquals(AppointmentManipulationsPage.getTitle(), titleCreateAppointment);
        softAssert.assertEquals(AppointmentManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(AppointmentManipulationsPage.getAppointmentType(), appActType);
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppStartDate(),
                AppointmentManipulationsPage.getStartDate() + " " + AppointmentManipulationsPage.getStartTime());
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppEndDate(),
                AppointmentManipulationsPage.getEndDate() + " " + AppointmentManipulationsPage.getEndTime());
        softAssert.assertEquals(AppointmentManipulationsPage.getAccount(), appActAccount);
        softAssert.assertEquals(AppointmentManipulationsPage.getContact(), appActContact);
        softAssert.assertEquals(AppointmentManipulationsPage.getOpportunity(), defaultOpportunityWithAcc);
        softAssert.assertEquals(AppointmentManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(AppointmentManipulationsPage.getCampaign(), appActCampaign);
        AppointmentManipulationsPage.scrollToLabel("Notes");
        softAssert.assertTrue(AppointmentManipulationsPage.getNotes().startsWith(appActNotes));

        AppointmentManipulationsPage.setAppointmentName();
        description = AppointmentManipulationsPage.getAppointmentName();

        AppointmentManipulationsPage.scrollToLabel("Description");
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.selectValueFromPopUp(newAppointmentType);
        AppointmentManipulationsPage.clickStartsDate();
        AppointmentManipulationsPage.selectDateMonth(newStartMonth);
        AppointmentManipulationsPage.selectDateDay(newStartDay);
        AppointmentManipulationsPage.selectDateYear(newStartYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickStartsTime();
        AppointmentManipulationsPage.selectTimeHours(newStartHours);
        AppointmentManipulationsPage.selectTimeMinutes(newStartMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(newStartAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsDate();
        AppointmentManipulationsPage.selectDateMonth(newEndMonth);
        AppointmentManipulationsPage.selectDateDay(newEndDay);
        AppointmentManipulationsPage.selectDateYear(newEndYear);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickEndsTime();
        AppointmentManipulationsPage.selectTimeHours(newEndHours);
        AppointmentManipulationsPage.selectTimeMinutes(newEndMinutes);
        AppointmentManipulationsPage.selectTimeAmPm(newEndAmPm);
        AppointmentManipulationsPage.closePicker();
        AppointmentManipulationsPage.clickLocation();
        AppointmentManipulationsPage.enterLocation(newLocation);
//        AppointmentManipulationsPage.clickOpportunity();
//        AppointmentManipulationsPage.spinOpportunityWheelTo(opportunity);
//        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.scrollToLabel("Hours in");
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);
        AppointmentManipulationsPage.clickSave();

        softAssert.assertEquals(AppointmentPage.getTitleOnView(), newAppointmentType.toUpperCase());
        softAssert.assertEquals(AppointmentPage.getDescriptionOnView(), description);
        softAssert.assertEquals(AppointmentPage.getAccountName(), appActAccount);
        softAssert.assertEquals(AppointmentPage.getUserName(), yourUser);
        softAssert.assertEquals(AppointmentPage.getStartDate(), newStartFullDate);
        softAssert.assertEquals(AppointmentPage.getStartTime(), newStartTime);
        softAssert.assertEquals(AppointmentPage.getEndDate(), newEndFullDate);
        softAssert.assertEquals(AppointmentPage.getEndTime(), newEndTime);
        softAssert.assertEquals(AppointmentPage.getLocation(), newLocation);
        softAssert.assertEquals(AppointmentPage.getContactOnView(), appActContact);
        softAssert.assertEquals(AppointmentPage.getCampaign(), appActCampaign);
//        softAssert.assertEquals(AppointmentPage.getOpportunity(), labelNone);
        softAssert.assertTrue(AppointmentPage.getNotes().startsWith(appActNotes));
        AppointmentPage.swipeFromBottomToTop();
        AppointmentPage.swipeFromBottomToTop();
        AppointmentPage.scrollToLabel("Hours in");
        softAssert.assertEquals(AppointmentPage.getHoursInPreparation(), hoursInPreparation);

        softAssert.assertAll();
    }

    @Test(priority = 6) // Case 16
    public void softFollowUpActivityFromAccount() throws InterruptedException {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(appActAccount);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabActivities();
        Thread.sleep(1000);
        ActivitiesPage.selectActivity(appActAppointment);
        AppointmentPage.clickTools();
        AppointmentPage.clickFollowUpActivity();
        AppointmentPage.alertConfirm();

        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        ActivityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getTitle(), titleCreateActivity);
        softAssert.assertEquals(ActivityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), defaultActivityType);
        softAssert.assertEquals(ActivityManipulationsPage.getDueDate(), ActivityManipulationsPage.getCurrentDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), appActAccount);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), appActContact);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), defaultOpportunityWithAcc);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), appActCampaign);
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo);
        softAssert.assertTrue(ActivityManipulationsPage.getNotes().startsWith(appActNotes));

        ActivityManipulationsPage.setDescription();
        String activityDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.scrollToLabel("Description");
        ActivityManipulationsPage.enterDescription(activityDescription);
        ActivityManipulationsPage.clickActivityType();
        ActivityManipulationsPage.selectValueFromPopUp(activityType);
        ActivityManipulationsPage.clickDueDate();
        ActivityManipulationsPage.selectDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDateDay(dueDateDay);
        ActivityManipulationsPage.selectDateYear(dueDateYear);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(timeHours);
        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
        ActivityManipulationsPage.closePicker();
//        ActivityManipulationsPage.clickOpportunity();
//        ActivityManipulationsPage.spinOpportunityWheelTo(appOpportunity);
//        ActivityManipulationsPage.clickOpportunity();
        ActivityManipulationsPage.scrollToLabel("Expenses");
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();

        softAssert.assertEquals(ActivityPage.getTitleOnView(), activityType.toUpperCase());
        softAssert.assertEquals(BasePage.getDescriptionOnView(), activityDescription);
        softAssert.assertEquals(ActivityPage.getAccountName(), appActAccount);
        softAssert.assertEquals(ActivityPage.getUserName(), yourUser);
        softAssert.assertEquals(ActivityPage.getDate(), activityDate);
        softAssert.assertEquals(ActivityPage.getContact(), appActContact);
        softAssert.assertEquals(ActivityPage.getCampaign(), appActCampaign);
        softAssert.assertEquals(ActivityPage.getOpportunity(), labelNone);
        softAssert.assertTrue(ActivityPage.getNotes().startsWith(appActNotes));
        ActivityPage.swipeFromBottomToTop();
        ActivityPage.swipeFromBottomToTop();
        ActivityPage.scrollToLabel("Expenses");
        softAssert.assertEquals(ActivityPage.getExpenses(), expenses + " SEK");

        ActivityPage.clickBack();
//        AppointmentPage.clickLeftMenu();
//        ActivitiesPage.clickBack();
//        AccountPage.clickBack();
//        Thread.sleep(1000);
//        SearchPage.clickCancel();
//        LeftMenuPage.clickActivities();
//        ActivitiesPage.clickFilter();
//        FilterPage.clickDate();
//        FilterPage.select(dateOneYear);
//        FilterPage.clickClose();
////        softAssert.assertTrue(
////                ActivitiesPage.searchActivity(
////                        activityDescription,
////                        dueDateDay + " " + dueDateMonth.substring(0, 3),
////                        time));

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}