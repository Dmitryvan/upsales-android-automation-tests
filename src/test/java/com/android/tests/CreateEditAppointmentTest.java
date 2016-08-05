package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(com.android.util.ScreenshotTaker.class)
public class CreateEditAppointmentTest extends BaseTest {

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
    private final String titleCreate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "titleCreate");
    private final String appointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "appointmentType");
    private final String defaultAppointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "defaultAppointmentType");
    private final String startDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startDate");
    private final String startHours = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startHours");
    private final String startMinutes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startMinutes");
    private final String startAmPm = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startAmPm");
    private final String endDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endDate");
    private final String endHours = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endHours");
    private final String endMinutes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endMinutes");
    private final String endAmPm = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endAmPm");
    private final String location = PropertyLoader.loadProperty(createAppointmentPropertyPath, "location");
    private final String startDateTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startDateTime");
    private final String endDateTime = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endDateTime");
    private final String newStartDate = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartDate");
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
    private final String appointmentTypes = PropertyLoader.loadProperty(createAppointmentPropertyPath, "appointmentTypes");
    private final String labelContact = PropertyLoader.loadProperty(createAppointmentPropertyPath, "labelContact");
    private final String defaultContact = PropertyLoader.loadProperty(createAppointmentPropertyPath, "defaultContact");
    private final String defaultOpportunity = PropertyLoader.loadProperty(createAppointmentPropertyPath, "defaultOpportunity");
    private final String newAppointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newAppointmentType");
    private final String newLocation = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newLocation");
    private final String labelAppointmentType = PropertyLoader.loadProperty(createAppointmentPropertyPath, "labelAppointmentType");
    private final String startMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startMonth");
    private final String startDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startDay");
    private final String startYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "startYear");
    private final String endMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endMonth");
    private final String endDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endDay");
    private final String endYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "endYear");
    private final String newStartMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartMonth");
    private final String newStartDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartDay");
    private final String newStartYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newStartYear");
    private final String newEndMonth = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndMonth");
    private final String newEndDay = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndDay");
    private final String newEndYear = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newEndYear");
    private final String labelStarts = PropertyLoader.loadProperty(createAppointmentPropertyPath, "labelStarts");
    private final String labelEnds = PropertyLoader.loadProperty(createAppointmentPropertyPath, "labelEnds");
    private final String hoursInPreparation = PropertyLoader.loadProperty(createAppointmentPropertyPath, "hoursInPreparation");
    private final String newHoursInPreparation = PropertyLoader.loadProperty(createAppointmentPropertyPath, "newHoursInPreparation");

    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickAppointment();
        AppointmentManipulationsPage.hideKeyboard();
        AppointmentManipulationsPage.setAppointmentName();
        description = AppointmentManipulationsPage.getAppointmentName();
    }

    @Test(priority = 1)
    public void softContentOfCreateAppointmentPage() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ActivityManipulationsPage.checkPageTitle(titleCreate);
        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        softAssert.assertEquals(ActivityManipulationsPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(ActivityManipulationsPage.getLabelSave(), labelSave);
        softAssert.assertEquals(defaultLabelDescription, BasePage.getLabelDescription());
        softAssert.assertEquals(labelAppointmentType, AppointmentManipulationsPage.getLabelAppointmentType());
        softAssert.assertEquals(defaultAppointmentType, AppointmentManipulationsPage.getAppointmentType());
        AppointmentManipulationsPage.clickAppointmentType();
        softAssert.assertEquals(appointmentTypes, AppointmentManipulationsPage.getAllAppointmentTypes());
        AppointmentManipulationsPage.closePopUp();
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppStartDate(), AppointmentManipulationsPage.getStartDate() + " " + AppointmentManipulationsPage.getStartTime());
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppEndDate(), AppointmentManipulationsPage.getEndDate() + " " + AppointmentManipulationsPage.getEndTime());
        softAssert.assertEquals(AppointmentManipulationsPage.getLabelStartDateTime(), labelStarts);
        softAssert.assertEquals(AppointmentManipulationsPage.getLabelEndDateTime(), labelEnds);
        softAssert.assertEquals(labelAccount, AppointmentManipulationsPage.getLabelAccount());
        softAssert.assertEquals(defaultAccount, AppointmentManipulationsPage.getAccount());
        AppointmentManipulationsPage.clickAccount();
        softAssert.assertEquals(titleSelectAccount, AddSelectEntityPage.getTitle());
        softAssert.assertEquals(labelSearch, AddSelectEntityPage.getSearchFieldValue());
        softAssert.assertEquals(labelCancel, AddSelectEntityPage.getLabelCancel());
        softAssert.assertEquals(labelResults, AddSelectEntityPage.getResultsLabelValue());
        AddSelectEntityPage.clickBack();
        softAssert.assertEquals(labelContact, AppointmentManipulationsPage.getLabelContact());
        softAssert.assertEquals(defaultContact, AppointmentManipulationsPage.getContact());
        softAssert.assertEquals(labelOpportunity, AppointmentManipulationsPage.getLabelOpportunity());
        softAssert.assertEquals(defaultOpportunity, AppointmentManipulationsPage.getOpportunity());
        softAssert.assertEquals(labelUser, AppointmentManipulationsPage.getLabelUser());
        softAssert.assertEquals(defaultUser, AppointmentManipulationsPage.getUser());
        softAssert.assertEquals(labelCampaign, AppointmentManipulationsPage.getLabelCampaign());
        softAssert.assertEquals(defaultCampaign, AppointmentManipulationsPage.getCampaign());
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.checkPageTitle(titleAddCampaign);
        softAssert.assertEquals(labelSearch, AddSelectEntityPage.getSearchFieldValue());
        softAssert.assertEquals(labelCancel, AddSelectEntityPage.getLabelCancel());
        softAssert.assertEquals(labelResults, AddSelectEntityPage.getResultsLabelValue());
        AddSelectEntityPage.clickBack();
        AppointmentManipulationsPage.scrollToLabel(labelOtherInfo);
        softAssert.assertEquals(labelNotes, AppointmentManipulationsPage.getLabelNotes());
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo);
        softAssert.assertEquals(labelOtherInfo, AppointmentManipulationsPage.getLabelOtherInfo());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void softCreateAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
//        AppointmentManipulationsPage.scrollToLabel("Hours");
//        AppointmentManipulationsPage.clickHoursInPreparation();
//        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);
        AppointmentManipulationsPage.clickSave();
        softAssert.assertEquals(AppointmentPage.getAccountName(), account);
        softAssert.assertEquals(AppointmentPage.getAppointmentDescription(), description);
//        AppointmentManipulationsPage.scrollToLabel("Logged");
//        softAssert.assertEquals(AppointmentPage.getHoursOfPreparation(), hoursInPreparation);
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void softCancelAppointmentBeforeSave() {
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        AppointmentManipulationsPage.clickCancel();
        assertTrue(LeftMenuPage.checkSearch());
        assertEquals(LeftMenuPage.getHiddenPageTitle(), titleDashboard);
    }

    @Test(priority = 4)
    public void softCancelAfterSelectEditAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
//        AppointmentManipulationsPage.scrollToLabel("Hours");
//        AppointmentManipulationsPage.clickHoursInPreparation();
//        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);
        AppointmentManipulationsPage.clickSave();
        AppointmentPage.clickTools();
        AppointmentPage.clickEditAppointment();
        AppointmentManipulationsPage.setAppointmentName();
        String newDescription = AppointmentManipulationsPage.getAppointmentName();
        AppointmentManipulationsPage.enterDescription(newDescription);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.selectValueFromPopUp(newAppointmentType);
        AppointmentManipulationsPage.clickContacts();
        AddSelectEntityPage.select(contact);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.selectValueFromPopUp(opportunity);
        AppointmentManipulationsPage.clickCancel();
        softAssert.assertEquals(account, AppointmentPage.getAccountName());
        softAssert.assertEquals(description, AppointmentPage.getAppointmentDescription());
        softAssert.assertEquals(defaultAppointmentType.toUpperCase(), AppointmentPage.getTitle());
        softAssert.assertEquals(labelNone, AppointmentPage.getCampaign());
        softAssert.assertEquals(labelNone, AppointmentPage.getOpportunity());
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void softEditAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.selectValueFromPopUp(appointmentType);
        softAssert.assertEquals(appointmentType, AppointmentManipulationsPage.getAppointmentType());

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
        softAssert.assertEquals(startDateTime, AppointmentManipulationsPage.getStartDate() + " " + AppointmentManipulationsPage.getStartTime());
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
        softAssert.assertEquals(endDateTime, AppointmentManipulationsPage.getEndDate() + " " + AppointmentManipulationsPage.getEndTime());

        AppointmentManipulationsPage.clickLocation();
        AppointmentManipulationsPage.enterLocation(location);
        softAssert.assertEquals(location, AppointmentManipulationsPage.getLocation());
        AppointmentManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        softAssert.assertEquals(account, AppointmentManipulationsPage.getAccount());
        AppointmentManipulationsPage.clickContacts();
        AddSelectEntityPage.select(contact);
        AddSelectEntityPage.clickSelect();
        softAssert.assertEquals(contact, AppointmentManipulationsPage.getContact());
        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.selectValueFromPopUp(opportunity);
        softAssert.assertEquals(opportunity, AppointmentManipulationsPage.getOpportunity());
        AppointmentManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        AddSelectEntityPage.unselect(yourUser);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo);
        AppointmentManipulationsPage.typeIntoNotes(notes);

        AppointmentManipulationsPage.scrollToLabel("Hours");
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);
        AppointmentManipulationsPage.clickSave();

        AppointmentPage.clickTools();
        AppointmentPage.clickEditAppointment();
        AppointmentManipulationsPage.setAppointmentName();
        String newDescription = AppointmentManipulationsPage.getAppointmentName();
        AppointmentManipulationsPage.enterDescription(newDescription);
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
        AppointmentManipulationsPage.clickContacts();
        AddSelectEntityPage.select(newContact);
        AddSelectEntityPage.unselect(contact);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        AddSelectEntityPage.unselect(yourUser);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo);
        AppointmentManipulationsPage.typeIntoNotes(newNotes);

//        AppointmentManipulationsPage.scrollToLabel("Hours");
//        AppointmentManipulationsPage.clickHoursInPreparation();
//        AppointmentManipulationsPage.clearHoursInPreparation();
//        AppointmentManipulationsPage.enterHoursInPreparation(newHoursInPreparation);

        AppointmentManipulationsPage.clickSave();

        softAssert.assertEquals(account, AppointmentPage.getAccountName());
        softAssert.assertEquals(newDescription, AppointmentPage.getAppointmentDescription());
        softAssert.assertEquals(AppointmentPage.getTitle(), newAppointmentType.toUpperCase());
        softAssert.assertEquals(yourUser, AppointmentPage.getUserName());
        softAssert.assertEquals(newStartFullDate, AppointmentPage.getStartDate());
        softAssert.assertEquals(newStartTime, AppointmentPage.getStartTime());
        softAssert.assertEquals(newEndFullDate, AppointmentPage.getEndDate());
        softAssert.assertEquals(newEndTime, AppointmentPage.getEndTime());
        softAssert.assertEquals(newLocation, AppointmentPage.getLocation());
        softAssert.assertEquals(newContact, AppointmentPage.getContact());
        softAssert.assertEquals(newCampaign, AppointmentPage.getCampaign());
        softAssert.assertEquals(opportunity, AppointmentPage.getOpportunity());
        AppointmentPage.scrollToLabel(labelOtherInfo);
        softAssert.assertEquals(newNotes, AppointmentPage.getNotes());
//        AppointmentManipulationsPage.scrollToLabel("Logged");
//        softAssert.assertEquals(AppointmentPage.getHoursOfPreparation(), newHoursInPreparation);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
