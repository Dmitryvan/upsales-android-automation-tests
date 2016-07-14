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

    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickAppointment();
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
        softAssert.assertEquals(defaultLabelDescription, ActivityManipulationsPage.getDefaultLabelDescription());
        softAssert.assertEquals(defaultAppointmentType, AppointmentManipulationsPage.getLabelAppointmentType());
        AppointmentManipulationsPage.clickAppointmentType();
        softAssert.assertEquals(appointmentTypes, AppointmentManipulationsPage.getAllAppointmentTypes());
        AppointmentManipulationsPage.clickAppointmentType();
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppStartDate(), AppointmentManipulationsPage.getStartDate());
        softAssert.assertEquals(AppointmentManipulationsPage.getDefaultAppEndDate(), AppointmentManipulationsPage.getEndDate());
        softAssert.assertEquals(labelAccount, AppointmentManipulationsPage.getLabelAccount());
        softAssert.assertEquals(defaultAccount, AppointmentManipulationsPage.getAccount());
        AppointmentManipulationsPage.clickAccount();
        softAssert.assertEquals(titleSelectAccount, AddSelectEntityPage.getTrimTitle());
        softAssert.assertEquals(labelSearch, AddSelectEntityPage.getSearchFieldValue());
        softAssert.assertEquals(labelCancel, AddSelectEntityPage.getLabelCancel());
        softAssert.assertEquals(labelResults.toUpperCase(), AddSelectEntityPage.getResultsLabelValue());
        AddSelectEntityPage.clickBack();
        softAssert.assertEquals(labelContact, AppointmentManipulationsPage.getLabelContact());
        softAssert.assertEquals(defaultContact, AppointmentManipulationsPage.getContact());
        softAssert.assertEquals(labelOpportunity, AppointmentManipulationsPage.getLabelOpportunity());
        softAssert.assertEquals(defaultOpportunity, AppointmentManipulationsPage.getOpportunity());
        softAssert.assertEquals(labelUser, AppointmentManipulationsPage.getLabelUser());
        softAssert.assertEquals(" " + defaultUser, AppointmentManipulationsPage.getUser());
        softAssert.assertEquals(labelCampaign, AppointmentManipulationsPage.getLabelCampaign());
        softAssert.assertEquals(defaultCampaign, AppointmentManipulationsPage.getCampaign());
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.checkPageTitle(titleAddCampaign);
        softAssert.assertEquals(labelSearch, AddSelectEntityPage.getSearchFieldValue());
        softAssert.assertEquals(labelCancel, AddSelectEntityPage.getLabelCancel());
        softAssert.assertEquals(labelResults.toUpperCase(), AddSelectEntityPage.getResultsLabelValue());
        AddSelectEntityPage.clickBack();
        softAssert.assertEquals(labelNotes, AppointmentManipulationsPage.getLabelNotes());
//        softAssert.assertEquals(labelOtherInfo.toUpperCase(), AppointmentManipulationsPage.getLabelOtherInfo());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void softCreateAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AppointmentManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        AppointmentManipulationsPage.clickSave();
        softAssert.assertEquals(account, AppointmentPage.getAccountName());
        softAssert.assertEquals(description, AppointmentPage.getAppointmentDescription());
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
        AppointmentManipulationsPage.clickSave();
        AppointmentPage.clickTools();
        AppointmentPage.clickEditAppointment();
        AppointmentManipulationsPage.setAppointmentName();
        String newDescription = AppointmentManipulationsPage.getAppointmentName();
        AppointmentManipulationsPage.enterDescription(newDescription);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.spinWheelToAppointmentType(newAppointmentType);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.clickContacts();
        AddSelectEntityPage.select(contact);
        AppointmentManipulationsPage.clickButtonSelect();
        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.spinOpportunityWheelTo(opportunity);
        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.clickCancel();
        softAssert.assertEquals(account, AppointmentPage.getAccountName());
        softAssert.assertEquals(description, AppointmentPage.getAppointmentDescription());
        AppointmentPage.checkPageTitle(defaultAppointmentType.toUpperCase());
        softAssert.assertFalse(AppointmentPage.checkThereIsNoContact());
        softAssert.assertEquals(labelNone, AppointmentPage.getOpportunityWithoutContact());
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void softEditAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        ActivityManipulationsPage.enterDescription(description);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.spinWheelToAppointmentType(appointmentType);
        AppointmentManipulationsPage.clickAppointmentType();
        softAssert.assertEquals(appointmentType, AppointmentManipulationsPage.getLabelAppointmentType());
        AppointmentManipulationsPage.clickStarts();
        AppointmentManipulationsPage.selectStartDate(startDate);
        AppointmentManipulationsPage.selectStartHours(startHours);
        AppointmentManipulationsPage.selectStartMinutes(startMinutes);
        AppointmentManipulationsPage.selectStartAmPm(startAmPm);
        AppointmentManipulationsPage.clickStarts();
        softAssert.assertEquals(startDateTime, AppointmentManipulationsPage.getLabelStartDateTime());
        AppointmentManipulationsPage.clickEnds();
        AppointmentManipulationsPage.selectEndDate(endDate);
        AppointmentManipulationsPage.selectEndHours(endHours);
        AppointmentManipulationsPage.selectEndMinutes(endMinutes);
        AppointmentManipulationsPage.selectEndAmPm(endAmPm);
        AppointmentManipulationsPage.clickEnds();
        softAssert.assertEquals(endDateTime, AppointmentManipulationsPage.getLabelEndDateTime());
//        assertEquals(location, AppointmentManipulationsPage.getLabelLocation());
        AppointmentManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        softAssert.assertEquals(account, AppointmentManipulationsPage.getAccount());
        AppointmentManipulationsPage.clickContacts();
        AddSelectEntityPage.select(contact);
        AppointmentManipulationsPage.clickButtonSelect();
        softAssert.assertEquals(" " + contact, AppointmentManipulationsPage.getContact());
        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.spinOpportunityWheelTo(opportunity);
        AppointmentManipulationsPage.clickOpportunity();
        softAssert.assertEquals(opportunity, AppointmentManipulationsPage.getOpportunity());
        AppointmentManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        AddSelectEntityPage.select(yourUser);
        AppointmentManipulationsPage.clickButtonSelect();
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AppointmentManipulationsPage.clickInsertSignature();
        AppointmentManipulationsPage.typeIntoNotes(notes);
        AppointmentManipulationsPage.clickSave();
        AppointmentPage.clickTools();
        AppointmentPage.clickEditAppointment();
        AppointmentManipulationsPage.setAppointmentName();
        String newDescription = AppointmentManipulationsPage.getAppointmentName();
        AppointmentManipulationsPage.enterDescription(newDescription);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.spinWheelToAppointmentType(newAppointmentType);
        AppointmentManipulationsPage.clickAppointmentType();
        AppointmentManipulationsPage.clickStarts();
        AppointmentManipulationsPage.selectStartDate(newStartDate);
        AppointmentManipulationsPage.selectStartHours(newStartHours);
        AppointmentManipulationsPage.selectStartMinutes(newStartMinutes);
        AppointmentManipulationsPage.selectStartAmPm(newStartAmPm);
        AppointmentManipulationsPage.clickStarts();
        AppointmentManipulationsPage.clickEnds();
        AppointmentManipulationsPage.selectEndDate(newEndDate);
        AppointmentManipulationsPage.selectEndHours(newEndHours);
        AppointmentManipulationsPage.selectEndMinutes(newEndMinutes);
        AppointmentManipulationsPage.selectEndAmPm(newEndAmPm);
        AppointmentManipulationsPage.clickEnds();
//        AppointmentManipulationsPage.clickLocation();
//        AppointmentManipulationsPage.enterLocation(newLocation);
        AppointmentManipulationsPage.clickContacts();
        AddSelectEntityPage.select(newContact);
        AddSelectEntityPage.select(contact);
        AppointmentManipulationsPage.clickButtonSelect();
//        AppointmentManipulationsPage.clickOpportunity();
//        AppointmentManipulationsPage.spinOpportunityWheelTo(newOpportunity);
//        AppointmentManipulationsPage.clickOpportunity();
        AppointmentManipulationsPage.clickUser();
        AddSelectEntityPage.select(yourUser);
        AddSelectEntityPage.select(user);
        AppointmentManipulationsPage.clickButtonSelect();
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        AppointmentManipulationsPage.clickInsertSignature();
        AppointmentManipulationsPage.typeIntoNotes(newNotes);
        AppointmentManipulationsPage.clickSave();
        softAssert.assertEquals(account, AppointmentPage.getAccountName());
        softAssert.assertEquals(newDescription, AppointmentPage.getAppointmentDescription());
        softAssert.assertEquals(AppointmentPage.getTitle(), newAppointmentType.toUpperCase());
        softAssert.assertEquals(yourUser, AppointmentPage.getUserName());
        softAssert.assertEquals(newStartFullDate, AppointmentPage.getStartDate());
        softAssert.assertEquals(newStartTime, AppointmentPage.getStartTime());
        softAssert.assertEquals(newEndFullDate, AppointmentPage.getEndDate());
        softAssert.assertEquals(newEndTime, AppointmentPage.getEndTime());
        softAssert.assertEquals(newContact, AppointmentPage.getContact());
        softAssert.assertEquals(newCampaign, AppointmentPage.getCampaign());
        softAssert.assertEquals(opportunity, AppointmentPage.getOpportunity());
        softAssert.assertEquals(newNotes, AppointmentPage.getNotes());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
