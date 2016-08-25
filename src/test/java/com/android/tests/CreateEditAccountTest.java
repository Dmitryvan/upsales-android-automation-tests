package com.android.tests;

import com.android.pages.*;
import com.android.util.Helpers;
import com.android.util.PropertyLoader;
import com.android.util.SoftAssertExtended;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

@Listeners(com.android.util.ScreenshotTaker.class)
public class CreateEditAccountTest extends BaseTest {

    private String accountName;
    private String appointmentName;
    private String activityDescription;
    private String opportunityDescription;
    private String contactName;

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String dashboardTitle = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String defaultUser = PropertyLoader.loadProperty(commonPropertyPath, "defaultUser");
    private final String user = PropertyLoader.loadProperty(commonPropertyPath, "user");
    private final String currentUser = PropertyLoader.loadProperty(commonPropertyPath, "currentUser");
    private final String titleOpportunity = PropertyLoader.loadProperty(commonPropertyPath, "labelOpportunity");
    private final String defaultCampaign = PropertyLoader.loadProperty(commonPropertyPath, "defaultCampaign");
    private final String oppUser = PropertyLoader.loadProperty(commonPropertyPath, "newUser");
    private final String oppNewCampaign = PropertyLoader.loadProperty(commonPropertyPath, "newCampaign");
    private final String notes = PropertyLoader.loadProperty(commonPropertyPath, "notes");
    private final String campaign = PropertyLoader.loadProperty(commonPropertyPath, "campaign");
    private final String newNotes = PropertyLoader.loadProperty(commonPropertyPath, "newNotes");
    private final String lblSearch = PropertyLoader.loadProperty(commonPropertyPath, "labelSearch");
    private final String lblCancel = PropertyLoader.loadProperty(commonPropertyPath, "labelCancel");
    private final String lblSelect = PropertyLoader.loadProperty(commonPropertyPath, "labelSelect");
    private final String lblNotes = PropertyLoader.loadProperty(commonPropertyPath, "labelNotes");
    private final String lblNone = PropertyLoader.loadProperty(commonPropertyPath, "labelNone");
    private final String addCampaignTitle = PropertyLoader.loadProperty(commonPropertyPath, "titleAddCampaign");
    private final String labelOtherInfo = PropertyLoader.loadProperty(commonPropertyPath, "labelOtherInfo");
    private final String lblResults = PropertyLoader.loadProperty(commonPropertyPath, "labelResults");

    private final String activitiesPropertyPath = "src/test/resources/createEditActivity.properties";
    private final String defaultActivityType = PropertyLoader.loadProperty(activitiesPropertyPath, "defaultActivityType");
    private final String defaultTime = PropertyLoader.loadProperty(activitiesPropertyPath, "defaultTime");
    private final String defaultContact = PropertyLoader.loadProperty(activitiesPropertyPath, "defaultContact");
    private final String defaultOpportunity = PropertyLoader.loadProperty(activitiesPropertyPath, "defaultOpportunity");
    private final String createActivityTitle = PropertyLoader.loadProperty(activitiesPropertyPath, "titleCreate");
    private final String activityType = PropertyLoader.loadProperty(activitiesPropertyPath, "activityType");
    private final String dueDateMonth = PropertyLoader.loadProperty(activitiesPropertyPath, "dueDateMonth");
    private final String dueDateDay = PropertyLoader.loadProperty(activitiesPropertyPath, "dueDateDay");
    private final String dueDateYear = PropertyLoader.loadProperty(activitiesPropertyPath, "dueDateYear");
    private final String dueDate = PropertyLoader.loadProperty(activitiesPropertyPath, "date");
    private final String timeHours = PropertyLoader.loadProperty(activitiesPropertyPath, "timeHours");
    private final String timeMinutes = PropertyLoader.loadProperty(activitiesPropertyPath, "timeMinutes");
    private final String timeAmPm = PropertyLoader.loadProperty(activitiesPropertyPath, "timeAmPm");
    private final String time = PropertyLoader.loadProperty(activitiesPropertyPath, "time");
    private final String expenses = PropertyLoader.loadProperty(activitiesPropertyPath, "expenses");
    private final String newExpenses = PropertyLoader.loadProperty(activitiesPropertyPath, "newExpenses");

    private final String createAccountPropertyPath = "src/test/resources/createEditAccount.properties";
    private final String editPageTitle = PropertyLoader.loadProperty(createAccountPropertyPath, "editPageTitle");
    private final String createPageTitle = PropertyLoader.loadProperty(createAccountPropertyPath, "createPageTitle");
    private final String parentAccountTitle = PropertyLoader.loadProperty(createAccountPropertyPath, "addParentAccountTitle");

    private final String createAppPropertyPath = "src/test/resources/createEditAppointment.properties";
    private final String appEditTitle = PropertyLoader.loadProperty(createAppPropertyPath, "titleEdit");
    private final String appType = PropertyLoader.loadProperty(createAppPropertyPath, "appointmentType");
    private final String appCreateTitle = PropertyLoader.loadProperty(createAppPropertyPath, "titleCreate");
    private final String appDefaultType = PropertyLoader.loadProperty(createAppPropertyPath, "defaultAppointmentType");
    private final String newAppointmentType = PropertyLoader.loadProperty(createAppPropertyPath, "newAppointmentType");
    private final String appDefaultContact = PropertyLoader.loadProperty(createAppPropertyPath, "defaultContact");
    private final String appDefaultOpp = PropertyLoader.loadProperty(createAppPropertyPath, "defaultOpportunity");
    private final String location = PropertyLoader.loadProperty(createAppPropertyPath, "location");
    private final String newLocation = PropertyLoader.loadProperty(createAppPropertyPath, "newLocation");
    private final String newStartDate = PropertyLoader.loadProperty(createAppPropertyPath, "newStartDate");
    private final String newStartHours = PropertyLoader.loadProperty(createAppPropertyPath, "newStartHours");
    private final String newStartMinutes = PropertyLoader.loadProperty(createAppPropertyPath, "newStartMinutes");
    private final String newStartAmPm = PropertyLoader.loadProperty(createAppPropertyPath, "newStartAmPm");
    private final String newEndDate = PropertyLoader.loadProperty(createAppPropertyPath, "newEndDate");
    private final String newEndHours = PropertyLoader.loadProperty(createAppPropertyPath, "newEndHours");
    private final String newEndMinutes = PropertyLoader.loadProperty(createAppPropertyPath, "newEndMinutes");
    private final String newEndAmPm = PropertyLoader.loadProperty(createAppPropertyPath, "newEndAmPm");
    private final String newStartFullDate = PropertyLoader.loadProperty(createAppPropertyPath, "newStartFullDate");
    private final String newStartTime = PropertyLoader.loadProperty(createAppPropertyPath, "newStartTime");
    private final String newEndFullDate = PropertyLoader.loadProperty(createAppPropertyPath, "newEndFullDate");
    private final String newEndTime = PropertyLoader.loadProperty(createAppPropertyPath, "newEndTime");
    private final String newStartMonth = PropertyLoader.loadProperty(createAppPropertyPath, "newStartMonth");
    private final String newStartDay = PropertyLoader.loadProperty(createAppPropertyPath, "newStartDay");
    private final String newStartYear = PropertyLoader.loadProperty(createAppPropertyPath, "newStartYear");
    private final String newEndMonth = PropertyLoader.loadProperty(createAppPropertyPath, "newEndMonth");
    private final String newEndDay = PropertyLoader.loadProperty(createAppPropertyPath, "newEndDay");
    private final String newEndYear = PropertyLoader.loadProperty(createAppPropertyPath, "newEndYear");
    private final String hoursInPreparation = PropertyLoader.loadProperty(createAppPropertyPath, "hoursInPreparation");
    private final String newHoursInPreparation = PropertyLoader.loadProperty(createAppPropertyPath, "newHoursInPreparation");

    private final String createOppPropertyPath = "src/test/resources/opportunity.properties";
    private final String oppCreateTitle = PropertyLoader.loadProperty(createOppPropertyPath, "titleCreate");
    private final String defaultProbability = PropertyLoader.loadProperty(createOppPropertyPath, "defaultProbability");
    private final String oppDefaultContact = PropertyLoader.loadProperty(createOppPropertyPath, "defaultContact");
    private final String oppNoContacts = PropertyLoader.loadProperty(createOppPropertyPath, "noContacts");
    private final String oppStage = PropertyLoader.loadProperty(createOppPropertyPath, "stage");
    private final String probability = PropertyLoader.loadProperty(createOppPropertyPath, "newProbability");
    private final String stageInOpp = PropertyLoader.loadProperty(createOppPropertyPath, "stageInOpp");
    private final String oppNewStage = PropertyLoader.loadProperty(createOppPropertyPath, "newStage");
    private final String oppNewMonth = PropertyLoader.loadProperty(createOppPropertyPath, "newMonth");
    private final String oppNewDay = PropertyLoader.loadProperty(createOppPropertyPath, "newDay");
    private final String oppNewYear = PropertyLoader.loadProperty(createOppPropertyPath, "newYear");
    private final String oppNewProduct = PropertyLoader.loadProperty(createOppPropertyPath, "newProduct");
    private final String oppNewCloseDate = PropertyLoader.loadProperty(createOppPropertyPath, "newCloseDate");
    private final String oppNewStageValue = PropertyLoader.loadProperty(createOppPropertyPath, "newStageInOpp");
    private final String newChangedStageInOpp = PropertyLoader.loadProperty(createOppPropertyPath, "newChangedStageInOpp");

    private final String newOrderPropertyPath = "src/test/resources/newOrder.properties";
    private final String product = PropertyLoader.loadProperty(newOrderPropertyPath, "product");

    private final String contactPropertyPath = "src/test/resources/contact.properties";
    private final String contactPageTitle = PropertyLoader.loadProperty(contactPropertyPath, "titleContact");
    private final String contactTitle = PropertyLoader.loadProperty(contactPropertyPath, "title");
    private final String contactPhone = PropertyLoader.loadProperty(contactPropertyPath, "phone");
    private final String contactMobile = PropertyLoader.loadProperty(contactPropertyPath, "mobile");
    private final String contactEmail = PropertyLoader.loadProperty(contactPropertyPath, "email");
    private final String contactNewTitle = PropertyLoader.loadProperty(contactPropertyPath, "newTitle");
    private final String contactNewPhone = PropertyLoader.loadProperty(contactPropertyPath, "newPhone");
    private final String contactNewMobile = PropertyLoader.loadProperty(contactPropertyPath, "newMobile");
    private final String contactNewEmail = PropertyLoader.loadProperty(contactPropertyPath, "newEmail");
    private final String contactCategory = PropertyLoader.loadProperty(contactPropertyPath, "category");
    private final String contactNewCategory = PropertyLoader.loadProperty(contactPropertyPath, "newCategory");
    private final String extraID = PropertyLoader.loadProperty(contactPropertyPath, "extraID");
    private final String chanceOfSuccess = PropertyLoader.loadProperty(contactPropertyPath, "chanceOfSuccess");
    private final String newExtraID = PropertyLoader.loadProperty(contactPropertyPath, "newExtraID");
    private final String newChanceOfSuccess = PropertyLoader.loadProperty(contactPropertyPath, "newChanceOfSuccess");
    private final String lblCategories = PropertyLoader.loadProperty(contactPropertyPath, "labelCategories");

    private final String defaultDescription = PropertyLoader.loadProperty(createAccountPropertyPath, "defaultDescription");
    private final String lblAccountName = PropertyLoader.loadProperty(createAccountPropertyPath, "lblAccountName");

    private final String lblAccountManagers = PropertyLoader.loadProperty(createAccountPropertyPath, "lblAccountManagers");
    private final String lblAccountManagersDefault = PropertyLoader.loadProperty(createAccountPropertyPath, "lblAccountManagersDefault");
    private final String addAccountManagersTitle = PropertyLoader.loadProperty(createAccountPropertyPath, "addAccountManagersTitle");
    private final String lblContactInformation = PropertyLoader.loadProperty(createAccountPropertyPath, "lblContactInformation");
    private final String lblPhone = PropertyLoader.loadProperty(createAccountPropertyPath, "lblPhone");
    private final String lblWebsite = PropertyLoader.loadProperty(createAccountPropertyPath, "lblWebsite");
    private final String lblAddress = PropertyLoader.loadProperty(createAccountPropertyPath, "lblAddress");
    private final String lblPostal = PropertyLoader.loadProperty(createAccountPropertyPath, "lblPostal");
    private final String lblStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "lblStreet");
    private final String lblZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "lblZipcode");
    private final String lblCity = PropertyLoader.loadProperty(createAccountPropertyPath, "lblCity");
    private final String lblCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "lblCountry");
    private final String lblVisit = PropertyLoader.loadProperty(createAccountPropertyPath, "lblVisit");
    private final String lblBilling = PropertyLoader.loadProperty(createAccountPropertyPath, "lblBilling");
    private final String lblDelivery = PropertyLoader.loadProperty(createAccountPropertyPath, "lblDelivery");
    private final String lblOther = PropertyLoader.loadProperty(createAccountPropertyPath, "lblOther");
    private final String lblInsertSignature = PropertyLoader.loadProperty(createAccountPropertyPath, "lblInsertSignature");
    private final String lblCampaigns = PropertyLoader.loadProperty(createAccountPropertyPath, "lblCampaigns");
    private final String categoriesTitle = PropertyLoader.loadProperty(createAccountPropertyPath, "categoriesTitle");
    private final String lblOtherInfo = PropertyLoader.loadProperty(createAccountPropertyPath, "lblOtherInfo");
    private final String dateToday = PropertyLoader.loadProperty(createAccountPropertyPath, "dateToday");

    private final String parentAccount = PropertyLoader.loadProperty(createAccountPropertyPath, "parentAccount");
    private final String phone = PropertyLoader.loadProperty(createAccountPropertyPath, "phone");
    private final String website = PropertyLoader.loadProperty(createAccountPropertyPath, "website");
    private final String postalStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "postalStreet");
    private final String postalZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "postalZipcode");
    private final String postalCity = PropertyLoader.loadProperty(createAccountPropertyPath, "postalCity");
    private final String postalCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "postalCountry");
    private final String visitStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "visitStreet");
    private final String visitZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "visitZipcode");
    private final String visitCity = PropertyLoader.loadProperty(createAccountPropertyPath, "visitCity");
    private final String visitCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "visitCountry");
    private final String billingStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "billingStreet");
    private final String billingZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "billingZipcode");
    private final String billingCity = PropertyLoader.loadProperty(createAccountPropertyPath, "billingCity");
    private final String billingCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "billingCountry");
    private final String deliveryStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "deliveryStreet");
    private final String deliveryZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "deliveryZipcode");
    private final String deliveryCity = PropertyLoader.loadProperty(createAccountPropertyPath, "deliveryCity");
    private final String deliveryCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "deliveryCountry");
    private final String otherStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "otherStreet");
    private final String otherZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "otherZipcode");
    private final String otherCity = PropertyLoader.loadProperty(createAccountPropertyPath, "otherCity");
    private final String otherCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "otherCountry");
    private final String category = PropertyLoader.loadProperty(createAccountPropertyPath, "category");

    private final String newAccountName = PropertyLoader.loadProperty(createAccountPropertyPath, "newAccountName");
    private final String newParentAccount = PropertyLoader.loadProperty(createAccountPropertyPath, "newParentAccount");
    private final String newPhone = PropertyLoader.loadProperty(createAccountPropertyPath, "newPhone");
    private final String newWebsite = PropertyLoader.loadProperty(createAccountPropertyPath, "newWebsite");
    private final String newPostalStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "newPostalStreet");
    private final String newPostalZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "newPostalZipcode");
    private final String newPostalCity = PropertyLoader.loadProperty(createAccountPropertyPath, "newPostalCity");
    private final String newPostalCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "newPostalCountry");
    private final String newVisitStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "newVisitStreet");
    private final String newVisitZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "newVisitZipcode");
    private final String newVisitCity = PropertyLoader.loadProperty(createAccountPropertyPath, "newVisitCity");
    private final String newVisitCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "newVisitCountry");
    private final String newBillingStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "newBillingStreet");
    private final String newBillingZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "newBillingZipcode");
    private final String newBillingCity = PropertyLoader.loadProperty(createAccountPropertyPath, "newBillingCity");
    private final String newBillingCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "newBillingCountry");
    private final String newDeliveryStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "newDeliveryStreet");
    private final String newDeliveryZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "newDeliveryZipcode");
    private final String newDeliveryCity = PropertyLoader.loadProperty(createAccountPropertyPath, "newDeliveryCity");
    private final String newDeliveryCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "newDeliveryCountry");
    private final String newOtherStreet = PropertyLoader.loadProperty(createAccountPropertyPath, "newOtherStreet");
    private final String newOtherZipcode = PropertyLoader.loadProperty(createAccountPropertyPath, "newOtherZipcode");
    private final String newOtherCity = PropertyLoader.loadProperty(createAccountPropertyPath, "newOtherCity");
    private final String newOtherCountry = PropertyLoader.loadProperty(createAccountPropertyPath, "newOtherCountry");
    private final String newCampaign = PropertyLoader.loadProperty(createAccountPropertyPath, "newCampaign");
    private final String newCategory = PropertyLoader.loadProperty(createAccountPropertyPath, "newCategory");


    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickAccount();
        AccountManipulationsPage.hideKeyboard();
        AccountManipulationsPage.setAccountName();
        accountName = AccountManipulationsPage.getAccountName();
    }

    @Test(priority = 1) // Case 1
    public void softContentOfCreateAccountPage() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.checkPageTitle(createPageTitle);
        softAssert.assertTrue(AccountManipulationsPage.checkSaveButton());
        softAssert.assertTrue(AccountManipulationsPage.checkCancelButton());
        softAssert.assertEquals(AccountManipulationsPage.getAccountNameValue(), lblAccountName);
        AccountManipulationsPage.clickParentAccount();
        softAssert.assertEquals(AddSelectEntityPage.getTitle(), parentAccountTitle);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), lblSearch);
        softAssert.assertEquals(AddSelectEntityPage.getCancelButtonValue(), lblCancel);
        softAssert.assertEquals(AddSelectEntityPage.getResultsLabelValue(), lblResults);
        AddSelectEntityPage.clickBack();
        softAssert.assertEquals(AccountManipulationsPage.getAccountManagersLabelValue(), lblAccountManagers);
        softAssert.assertEquals(AccountManipulationsPage.getAccountManagersValue(), lblAccountManagersDefault);
        AccountManipulationsPage.clickAccountManagers();
        softAssert.assertEquals(AddSelectEntityPage.getTitle(), addAccountManagersTitle);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), lblSearch);
        softAssert.assertEquals(AddSelectEntityPage.getCancelButtonValue(), lblCancel);
        softAssert.assertEquals(AddSelectEntityPage.getSelectButtonValue(), lblSelect);
        softAssert.assertEquals(AddSelectEntityPage.getResultsLabelValue(), lblResults);
        AddSelectEntityPage.clickBack();
        softAssert.assertEquals(AccountManipulationsPage.getContactInformationLabelValue(), lblContactInformation);
        softAssert.assertEquals(AccountManipulationsPage.getPhoneFieldDefaultValue(),lblPhone);
        softAssert.assertEquals(AccountManipulationsPage.getWebsiteFieldDefaultValue(), lblWebsite);

        softAssert.assertEquals(AccountManipulationsPage.getAddressLabelValue(), lblAddress);
        softAssert.assertEquals(AccountManipulationsPage.getPostalTabValue(), lblPostal);
        softAssert.assertEquals(AccountManipulationsPage.getStreetLabelValue(), lblStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeLabelValue(), lblZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityLabelValue(), lblCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryLabelValue(), lblCountry);

        AccountManipulationsPage.clickVisit();
        softAssert.assertEquals(AccountManipulationsPage.getVisitTabValue(), lblVisit);
        softAssert.assertEquals(AccountManipulationsPage.getStreetLabelValue(), lblStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeLabelValue(), lblZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityLabelValue(), lblCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryLabelValue(), lblCountry);

        AccountManipulationsPage.clickBilling();
        softAssert.assertEquals(AccountManipulationsPage.getBillingTabValue(), lblBilling);
        softAssert.assertEquals(AccountManipulationsPage.getStreetLabelValue(), lblStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeLabelValue(), lblZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityLabelValue(), lblCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryLabelValue(), lblCountry);

        AccountManipulationsPage.clickDelivery();
        softAssert.assertEquals(AccountManipulationsPage.getDeliveryTabValue(), lblDelivery);
        softAssert.assertEquals(AccountManipulationsPage.getStreetLabelValue(), lblStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeLabelValue(), lblZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityLabelValue(), lblCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryLabelValue(), lblCountry);

        AccountManipulationsPage.clickOther();
        softAssert.assertEquals(AccountManipulationsPage.getOtherTabValue(), lblOther);
        softAssert.assertEquals(AccountManipulationsPage.getStreetLabelValue(), lblStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeLabelValue(), lblZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityLabelValue(), lblCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryLabelValue(), lblCountry);

        AccountManipulationsPage.scrollToLabel(lblNotes);

        softAssert.assertEquals(AccountManipulationsPage.getLabelNotes(), lblNotes);
        softAssert.assertEquals(AccountManipulationsPage.getInsertSignatureValue(), lblInsertSignature);

        softAssert.assertEquals(AccountManipulationsPage.getLabelCampaign(), lblCampaigns);
        softAssert.assertEquals(AccountManipulationsPage.getCampaign(), lblNone);

        AccountManipulationsPage.clickCampaign();
        softAssert.assertEquals(AddSelectEntityPage.getTitle(), addCampaignTitle);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), lblSearch);
        softAssert.assertEquals(AddSelectEntityPage.getCancelButtonValue(), lblCancel);
        softAssert.assertEquals(AddSelectEntityPage.getSelectButtonValue(), lblSelect);
        softAssert.assertEquals(AddSelectEntityPage.getResultsLabelValue(), lblResults);
        AddSelectEntityPage.clickBack();

        softAssert.assertEquals(AccountManipulationsPage.getLabelCategories(), lblCategories);
        softAssert.assertEquals(AccountManipulationsPage.getCategories(), lblNone);

        AccountManipulationsPage.clickCategories();
        softAssert.assertEquals(AddSelectEntityPage.getTitle(), categoriesTitle);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), lblSearch);
        softAssert.assertEquals(AddSelectEntityPage.getCancelButtonValue(), lblCancel);
        softAssert.assertEquals(AddSelectEntityPage.getSelectButtonValue(), lblSelect);
        softAssert.assertEquals(AddSelectEntityPage.getResultsLabelValue(), lblResults);
        AddSelectEntityPage.clickBack();

        softAssert.assertAll();
    }

    @Test(priority = 2) // Case 2
    public void softCreateAccount() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpNoThanx();
        softAssert.assertEquals(AccountPage.getAccountName(), accountName);
        softAssert.assertEquals(AccountPage.getAccountManagerValue(), currentUser);
        AccountPage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(accountName);
        softAssert.assertEquals(SearchPage.getFirstSearchResult(), accountName);
        softAssert.assertAll();
    }

    @Test(priority = 3) // Case 3
    public void cancelAccountBeforeSave() {
        AccountManipulationsPage.clickCancel();
        assertTrue(LeftMenuPage.checkSearch());
        assertEquals(LeftMenuPage.getHiddenPageTitle(), dashboardTitle);
    }

    @Test(priority = 4) // Case 4
    public void softEditAccountWithHelpPopover() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickParentAccount();
        AddSelectEntityPage.select(parentAccount);
        AccountManipulationsPage.enterPhone(phone);
        AccountManipulationsPage.enterWebsite(website);
        AccountManipulationsPage.enterStreet(postalStreet);
        AccountManipulationsPage.enterZipcode(postalZipcode);
        AccountManipulationsPage.enterCity(postalCity);
        AccountManipulationsPage.enterCountry(postalCountry);
        AccountManipulationsPage.clickVisit();
        AccountManipulationsPage.enterStreet(visitStreet);
        AccountManipulationsPage.enterZipcode(visitZipcode);
        AccountManipulationsPage.enterCity(visitCity);
        AccountManipulationsPage.enterCountry(visitCountry);
        AccountManipulationsPage.clickBilling();
        AccountManipulationsPage.enterStreet(billingStreet);
        AccountManipulationsPage.enterZipcode(billingZipcode);
        AccountManipulationsPage.enterCity(billingCity);
        AccountManipulationsPage.enterCountry(billingCountry);
        AccountManipulationsPage.clickDelivery();
        AccountManipulationsPage.enterStreet(deliveryStreet);
        AccountManipulationsPage.enterZipcode(deliveryZipcode);
        AccountManipulationsPage.enterCity(deliveryCity);
        AccountManipulationsPage.enterCountry(deliveryCountry);
        AccountManipulationsPage.clickOther();
        AccountManipulationsPage.enterStreet(otherStreet);
        AccountManipulationsPage.enterZipcode(otherZipcode);
        AccountManipulationsPage.enterCity(otherCity);
        AccountManipulationsPage.enterCountry(otherCountry);
        AccountManipulationsPage.scrollToLabel(lblCampaigns);
        AccountManipulationsPage.typeIntoNotes(notes);
        AccountManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickCategories();
        AddSelectEntityPage.select(category);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpNoThanx();
        AccountPage.clickTools();
        AccountPage.clickPopoverEdit();

        AccountManipulationsPage.hideKeyboard();
        softAssert.assertEquals(AccountManipulationsPage.getTitle(), editPageTitle);
        softAssert.assertEquals(AccountManipulationsPage.getAccountNameValue(), accountName);
        softAssert.assertEquals(AccountManipulationsPage.getParentAccountValue(), parentAccount);
        softAssert.assertEquals(AccountManipulationsPage.getPhoneFieldValue(), phone);
        softAssert.assertEquals(AccountManipulationsPage.getWebsiteFieldValue(), website);
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), postalStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), postalZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), postalCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), postalCountry);
        AccountManipulationsPage.clickVisit();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), visitStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), visitZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), visitCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), visitCountry);
        AccountManipulationsPage.clickBilling();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), billingStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), billingZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), billingCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), billingCountry);
        AccountManipulationsPage.clickDelivery();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), deliveryStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), deliveryZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), deliveryCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), deliveryCountry);
        AccountManipulationsPage.clickOther();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), otherStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), otherZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), otherCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), otherCountry);
        AccountManipulationsPage.scrollToLabel(lblOtherInfo);
        softAssert.assertEquals(AccountManipulationsPage.getNotes(), notes);
        softAssert.assertEquals(AccountManipulationsPage.getCampaign(), campaign);
        softAssert.assertEquals(AccountManipulationsPage.getCategories(), category);

        AccountManipulationsPage.setAccountName();
        accountName = AccountManipulationsPage.getAccountName();
        AccountManipulationsPage.scrollToTheTop();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickParentAccount();
        AddSelectEntityPage.select(newParentAccount);
        AccountManipulationsPage.enterPhone(newPhone);
        AccountManipulationsPage.enterWebsite(newWebsite);
        AccountManipulationsPage.clickVisit();
        AccountManipulationsPage.clickPostal();
        AccountManipulationsPage.enterStreet(newPostalStreet);
        AccountManipulationsPage.enterZipcode(newPostalZipcode);
        AccountManipulationsPage.enterCity(newPostalCity);
        AccountManipulationsPage.enterCountry(newPostalCountry);
        AccountManipulationsPage.clickVisit();
        AccountManipulationsPage.enterStreet(newVisitStreet);
        AccountManipulationsPage.enterZipcode(newVisitZipcode);
        AccountManipulationsPage.enterCity(newVisitCity);
        AccountManipulationsPage.enterCountry(newVisitCountry);
        AccountManipulationsPage.clickBilling();
        AccountManipulationsPage.enterStreet(newBillingStreet);
        AccountManipulationsPage.enterZipcode(newBillingZipcode);
        AccountManipulationsPage.enterCity(newBillingCity);
        AccountManipulationsPage.enterCountry(newBillingCountry);
        AccountManipulationsPage.clickDelivery();
        AccountManipulationsPage.enterStreet(newDeliveryStreet);
        AccountManipulationsPage.enterZipcode(newDeliveryZipcode);
        AccountManipulationsPage.enterCity(newDeliveryCity);
        AccountManipulationsPage.enterCountry(newDeliveryCountry);
        AccountManipulationsPage.clickOther();
        AccountManipulationsPage.enterStreet(newOtherStreet);
        AccountManipulationsPage.enterZipcode(newOtherZipcode);
        AccountManipulationsPage.enterCity(newOtherCity);
        AccountManipulationsPage.enterCountry(newOtherCountry);
        AccountManipulationsPage.scrollToLabel(lblOtherInfo);
        AccountManipulationsPage.typeIntoNotes(newNotes);
        AccountManipulationsPage.clickCampaign();
        AddSelectEntityPage.clickResultsLabel();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.select(newCampaign);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickCategories();
        AddSelectEntityPage.select(category);
        AddSelectEntityPage.select(newCategory);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickSave();

        softAssert.assertEquals(AccountPage.getAccountName(), accountName);
        AccountPage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(accountName);
        softAssert.assertEquals(SearchPage.getFirstSearchResult(), accountName);
        SearchPage.clickOnFirstSearchResult();

        softAssert.assertEquals(AccountPage.getAccountName(), accountName);
        AccountPage.clickTools();
        AccountPage.clickPopoverEdit();

        AccountManipulationsPage.hideKeyboard();
        softAssert.assertEquals(AccountManipulationsPage.getTitle(), editPageTitle);
        softAssert.assertEquals(AccountManipulationsPage.getAccountNameValue(), accountName);
        softAssert.assertEquals(AccountManipulationsPage.getParentAccountValue(), newParentAccount);
        softAssert.assertEquals(AccountManipulationsPage.getPhoneFieldValue(), newPhone);
        softAssert.assertEquals(AccountManipulationsPage.getWebsiteFieldValue(), newWebsite);
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), newPostalStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), newPostalZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), newPostalCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), newPostalCountry);
        AccountManipulationsPage.clickVisit();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), newVisitStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), newVisitZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), newVisitCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), newVisitCountry);
        AccountManipulationsPage.clickBilling();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), newBillingStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), newBillingZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), newBillingCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), newBillingCountry);
        AccountManipulationsPage.clickDelivery();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), newDeliveryStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), newDeliveryZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), newDeliveryCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), newDeliveryCountry);
        AccountManipulationsPage.clickOther();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), newOtherStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), newOtherZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), newOtherCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), newOtherCountry);
        AccountManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(AccountManipulationsPage.getNotes(), newNotes);
        softAssert.assertEquals(AccountManipulationsPage.getCampaign(), newCampaign);
        softAssert.assertEquals(AccountManipulationsPage.getCategories(), newCategory);
        softAssert.assertAll();
    }

    @Test(priority = 5) // Case 41
    public void softCancelAfterSelectEditAccount() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickParentAccount();
        AddSelectEntityPage.select(parentAccount);
        AccountManipulationsPage.enterPhone(phone);
        AccountManipulationsPage.enterWebsite(website);
        AccountManipulationsPage.enterStreet(postalStreet);
        AccountManipulationsPage.enterZipcode(postalZipcode);
        AccountManipulationsPage.enterCity(postalCity);
        AccountManipulationsPage.enterCountry(postalCountry);
        AccountManipulationsPage.clickVisit();
        AccountManipulationsPage.enterStreet(visitStreet);
        AccountManipulationsPage.enterZipcode(visitZipcode);
        AccountManipulationsPage.enterCity(visitCity);
        AccountManipulationsPage.enterCountry(visitCountry);
        AccountManipulationsPage.clickBilling();
        AccountManipulationsPage.enterStreet(billingStreet);
        AccountManipulationsPage.enterZipcode(billingZipcode);
        AccountManipulationsPage.enterCity(billingCity);
        AccountManipulationsPage.enterCountry(billingCountry);
        AccountManipulationsPage.clickDelivery();
        AccountManipulationsPage.enterStreet(deliveryStreet);
        AccountManipulationsPage.enterZipcode(deliveryZipcode);
        AccountManipulationsPage.enterCity(deliveryCity);
        AccountManipulationsPage.enterCountry(deliveryCountry);
        AccountManipulationsPage.clickOther();
        AccountManipulationsPage.enterStreet(otherStreet);
        AccountManipulationsPage.enterZipcode(otherZipcode);
        AccountManipulationsPage.enterCity(otherCity);
        AccountManipulationsPage.enterCountry(otherCountry);
        AccountManipulationsPage.scrollToLabel(lblCampaigns);
        AccountManipulationsPage.typeIntoNotes(notes);
        AccountManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickCategories();
        AddSelectEntityPage.select(category);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpNoThanx();

        AccountPage.clickTools();
        AccountPage.clickPopoverEdit();

        AccountManipulationsPage.hideKeyboard();
        softAssert.assertEquals(AccountManipulationsPage.getTitle(), editPageTitle);
        softAssert.assertEquals(AccountManipulationsPage.getAccountNameValue(), accountName);
        softAssert.assertEquals(AccountManipulationsPage.getParentAccountValue(), parentAccount);
        softAssert.assertEquals(AccountManipulationsPage.getPhoneFieldValue(), phone);
        softAssert.assertEquals(AccountManipulationsPage.getWebsiteFieldValue(), website);
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), postalStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), postalZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), postalCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), postalCountry);
        AccountManipulationsPage.clickVisit();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), visitStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), visitZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), visitCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), visitCountry);
        AccountManipulationsPage.clickBilling();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), billingStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), billingZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), billingCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), billingCountry);
        AccountManipulationsPage.clickDelivery();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), deliveryStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), deliveryZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), deliveryCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), deliveryCountry);
        AccountManipulationsPage.clickOther();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), otherStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), otherZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), otherCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), otherCountry);
        AccountManipulationsPage.scrollToLabel(lblCampaigns);
        softAssert.assertEquals(AccountManipulationsPage.getNotes(), notes);
        softAssert.assertEquals(AccountManipulationsPage.getCampaign(), campaign);
        softAssert.assertEquals(AccountManipulationsPage.getCategories(), category);

        AccountManipulationsPage.scrollToTheTop();
        AccountManipulationsPage.enterAccountName(newAccountName);
        AccountManipulationsPage.clickParentAccount();
        AddSelectEntityPage.select(newParentAccount);
        AccountManipulationsPage.enterPhone(newPhone);
        AccountManipulationsPage.enterWebsite(newWebsite);
        AccountManipulationsPage.clickVisit();
        AccountManipulationsPage.clickPostal();
        AccountManipulationsPage.enterStreet(newPostalStreet);
        AccountManipulationsPage.enterZipcode(newPostalZipcode);
        AccountManipulationsPage.enterCity(newPostalCity);
        AccountManipulationsPage.enterCountry(newPostalCountry);
        AccountManipulationsPage.clickVisit();
        AccountManipulationsPage.enterStreet(newVisitStreet);
        AccountManipulationsPage.enterZipcode(newVisitZipcode);
        AccountManipulationsPage.enterCity(newVisitCity);
        AccountManipulationsPage.enterCountry(newVisitCountry);
        AccountManipulationsPage.clickBilling();
        AccountManipulationsPage.enterStreet(newBillingStreet);
        AccountManipulationsPage.enterZipcode(newBillingZipcode);
        AccountManipulationsPage.enterCity(newBillingCity);
        AccountManipulationsPage.enterCountry(newBillingCountry);
        AccountManipulationsPage.clickDelivery();
        AccountManipulationsPage.enterStreet(newDeliveryStreet);
        AccountManipulationsPage.enterZipcode(newDeliveryZipcode);
        AccountManipulationsPage.enterCity(newDeliveryCity);
        AccountManipulationsPage.enterCountry(newDeliveryCountry);
        AccountManipulationsPage.clickOther();
        AccountManipulationsPage.enterStreet(newOtherStreet);
        AccountManipulationsPage.enterZipcode(newOtherZipcode);
        AccountManipulationsPage.enterCity(newOtherCity);
        AccountManipulationsPage.enterCountry(newOtherCountry);
        AccountManipulationsPage.scrollToLabel(lblCampaigns);
        AccountManipulationsPage.typeIntoNotes(newNotes);
        AccountManipulationsPage.clickCampaign();
        AddSelectEntityPage.clickResultsLabel();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.select(newCampaign);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickCategories();
        AddSelectEntityPage.select(category);
        AddSelectEntityPage.select(newCategory);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickCancel();

        assertEquals(AccountPage.getAccountName(), accountName);
        AccountPage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(accountName);
        assertEquals(SearchPage.getFirstSearchResult(), accountName);
        SearchPage.clickOnFirstSearchResult();

        assertEquals(AccountPage.getAccountName(), accountName);
        AccountPage.clickTools();
        AccountPage.clickPopoverEdit();

        AccountManipulationsPage.hideKeyboard();
        softAssert.assertEquals(AccountManipulationsPage.getTitle(), editPageTitle);
        softAssert.assertEquals(AccountManipulationsPage.getAccountNameValue(), accountName);
        softAssert.assertEquals(AccountManipulationsPage.getParentAccountValue(), parentAccount);
        softAssert.assertEquals(AccountManipulationsPage.getPhoneFieldValue(), phone);
        softAssert.assertEquals(AccountManipulationsPage.getWebsiteFieldValue(), website);
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), postalStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), postalZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), postalCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), postalCountry);
        AccountManipulationsPage.clickVisit();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), visitStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), visitZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), visitCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), visitCountry);
        AccountManipulationsPage.clickBilling();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), billingStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), billingZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), billingCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), billingCountry);
        AccountManipulationsPage.clickDelivery();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), deliveryStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), deliveryZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), deliveryCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), deliveryCountry);
        AccountManipulationsPage.clickOther();
        softAssert.assertEquals(AccountManipulationsPage.getStreetFieldValue(), otherStreet);
        softAssert.assertEquals(AccountManipulationsPage.getZipcodeFieldValue(), otherZipcode);
        softAssert.assertEquals(AccountManipulationsPage.getCityFieldValue(), otherCity);
        softAssert.assertEquals(AccountManipulationsPage.getCountryFieldValue(), otherCountry);
        AccountManipulationsPage.scrollToLabel(lblCampaigns);
        softAssert.assertEquals(AccountManipulationsPage.getCampaign(), campaign);
        softAssert.assertEquals(AccountManipulationsPage.getCategories(), category);
        softAssert.assertEquals(AccountManipulationsPage.getNotes(), notes);
        softAssert.assertAll();
    }

    @Test(priority = 6) // Case 42
    public void softCreateAccountAndCreateActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpActivity();

        AccountManipulationsPage.hideKeyboard();
        softAssert.assertEquals(ActivityManipulationsPage.getActivityType(), defaultActivityType);
        softAssert.assertEquals(ActivityManipulationsPage.getCurrentDate(), ActivityManipulationsPage.getDueDate());
        softAssert.assertEquals(ActivityManipulationsPage.getTime(), defaultTime);
        softAssert.assertEquals(ActivityManipulationsPage.getAccount(), accountName);
        softAssert.assertEquals(ActivityManipulationsPage.getContact(), defaultContact);
        softAssert.assertEquals(ActivityManipulationsPage.getOpportunity(), defaultOpportunity);
        softAssert.assertEquals(ActivityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(ActivityManipulationsPage.getCampaign(), defaultCampaign);

        ActivityManipulationsPage.scrollToLabel("Expenses");
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);
        ActivityManipulationsPage.clickSave();

        softAssert.assertEquals(BasePage.getDescriptionOnView(), defaultDescription);
        softAssert.assertEquals(ActivityPage.getTitleOnView(), defaultActivityType.toUpperCase());
        softAssert.assertEquals(ActivityPage.getAccountName(), accountName);
        softAssert.assertEquals(ActivityPage.getUserName(), currentUser);
        softAssert.assertEquals(ActivityPage.getDate(), ActivityPage.getCurrentDate());
        softAssert.assertEquals(ActivityPage.getCampaign(), lblNone);
        softAssert.assertEquals(ActivityPage.getOpportunity(), lblNone);

//        ActivityPage.clickShowMore();
        ActivityPage.scrollToLabel("Expenses");
        softAssert.assertEquals(ActivityPage.getExpenses(), expenses + " SEK");

        ActivityPage.clickLeftMenu();
//        AccountManipulationsPage.clickBack();
        LeftMenuPage.clickActivities();
        softAssert.assertTrue(ActivitiesPage.searchActivity(defaultDescription, dateToday));
        softAssert.assertAll();
    }

    @Test(priority = 7) // Case 43
    public void createAccountAndCreateActivityAndCancel() {
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpActivity();
        assertEquals(ActivityPage.getTitle(), createActivityTitle);
        ActivityManipulationsPage.clickCancel();
//        AccountPage.clickBack();
        LeftMenuPage.clickSearch();
        SearchPage.search(accountName);
        assertEquals(SearchPage.getFirstSearchResult(), accountName);
    }

    @Test(priority = 8) // Case 44
    public void softCreateAccountCreateActivityEditActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickParentAccount();
        AddSelectEntityPage.select(parentAccount);
        AccountManipulationsPage.scrollToLabel(lblOtherInfo);
        AccountManipulationsPage.typeIntoNotes(notes);
        AccountManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickCategories();
        AddSelectEntityPage.select(category);
        AddSelectEntityPage.clickSelect();
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpActivity();
        ActivityManipulationsPage.setDescription();
        activityDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(activityDescription);

        ActivityManipulationsPage.scrollToLabel("Expenses");
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
        ActivityManipulationsPage.selectDateMonth(dueDateMonth);
        ActivityManipulationsPage.selectDateDay(dueDateDay);
        ActivityManipulationsPage.selectDateYear(dueDateYear);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(timeHours);
        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo.toUpperCase());
        ActivityManipulationsPage.typeIntoNotes(notes);

        ActivityManipulationsPage.scrollToLabel("Expenses");
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(newExpenses);
        ActivityManipulationsPage.clickSave();

        softAssert.assertEquals(ActivityPage.getTitleOnView(), activityType.toUpperCase());
        softAssert.assertEquals(BasePage.getDescriptionOnView(), activityDescription);
        softAssert.assertEquals(ActivityPage.getAccountName(), accountName);
        softAssert.assertEquals(ActivityPage.getUserName(), user);
        softAssert.assertEquals(ActivityPage.getDate(), dueDate);
        softAssert.assertEquals(ActivityPage.getTime(), time);
//        softAssert.assertEquals(ActivityPage.getContact(), "Hans Christer Zaar");
        softAssert.assertEquals(ActivityPage.getCampaign(), campaign);
        softAssert.assertEquals(ActivityPage.getOpportunity(), lblNone);
//        ActivityPage.clickShowMore();
        ActivityManipulationsPage.scrollToLabel("Expenses");
        softAssert.assertEquals(ActivityPage.getExpenses(), newExpenses + " SEK");
        softAssert.assertEquals(ActivityPage.getNotes(), notes);
        softAssert.assertAll();
    }

    @Test(priority = 9) // Case 45
    public void softCreateAccountCreateAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpAppointment();
        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        AppointmentManipulationsPage.hideKeyboard();
        softAssert.assertEquals(AppointmentManipulationsPage.getTitle(), appCreateTitle);
        softAssert.assertEquals(AppointmentManipulationsPage.getAppointmentType(), appDefaultType);
        softAssert.assertEquals(AppointmentManipulationsPage.getStartDate() + " " + AppointmentManipulationsPage.getStartTime(),
                AppointmentManipulationsPage.getDefaultAppStartDate());
        softAssert.assertEquals(AppointmentManipulationsPage.getEndDate() + " " + AppointmentManipulationsPage.getEndTime(),
                AppointmentManipulationsPage.getDefaultAppEndDate());
        softAssert.assertEquals(AppointmentManipulationsPage.getAccount(), accountName);
        softAssert.assertEquals(AppointmentManipulationsPage.getContact(), appDefaultContact);
        softAssert.assertEquals(AppointmentManipulationsPage.getOpportunity(), appDefaultOpp);
        softAssert.assertEquals(AppointmentManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(AppointmentManipulationsPage.getCampaign(), defaultCampaign);
        AppointmentManipulationsPage.scrollToLabel("Hours");
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);
        AppointmentManipulationsPage.clickSave();
        softAssert.assertEquals(AppointmentPage.getTitleOnView(), appDefaultType.toUpperCase());
        softAssert.assertEquals(AppointmentPage.getDescriptionOnView(), defaultDescription);
        softAssert.assertEquals(AppointmentPage.getAccountName(), accountName);
//        AppointmentPage.clickBack();
//        AccountManipulationsPage.clickBack();
//        LeftMenuPage.clickDashboard();
        softAssert.assertAll();
    }

    @Test(priority = 10) // Case 46
    public void createAccountCreateAppointmentCancel() {
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpAppointment();
        assertEquals(AppointmentManipulationsPage.getTitle(), appCreateTitle);
        AppointmentManipulationsPage.clickCancel();
//        AccountManipulationsPage.clickBack();
        assertTrue(LeftMenuPage.checkSearch());
        LeftMenuPage.clickSearch();
        SearchPage.search(accountName);
        assertEquals(SearchPage.getFirstSearchResult(), accountName);
    }

    @Test(priority = 11) // Case 47
    public void softCreateAccountCreateAppointmentEditAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpAppointment();
        AppointmentManipulationsPage.setAppointmentName();
        appointmentName = AppointmentManipulationsPage.getAppointmentName();
        AppointmentManipulationsPage.enterDescription(appointmentName);
        AppointmentManipulationsPage.clickLocation();
        AppointmentManipulationsPage.enterLocation(location);
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AppointmentManipulationsPage.scrollToLabel(lblOtherInfo);
        AppointmentManipulationsPage.typeIntoNotes(notes);

        AppointmentManipulationsPage.scrollToLabel("Hours");
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
        AppointmentManipulationsPage.clickUser();
        AddSelectEntityPage.select(currentUser);
        AddSelectEntityPage.select(user);
        AddSelectEntityPage.clickSelect();
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        AppointmentManipulationsPage.scrollToLabel(labelOtherInfo);
        AppointmentManipulationsPage.typeIntoNotes(newNotes);

        AppointmentManipulationsPage.scrollToLabel("Hours");
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(newHoursInPreparation);

        AppointmentManipulationsPage.clickSave();

        softAssert.assertEquals(AppointmentPage.getTitleOnView(), newAppointmentType.toUpperCase());
        softAssert.assertEquals(AppointmentPage.getDescriptionOnView(), appointmentName);
        softAssert.assertEquals(AppointmentPage.getAccountName(), accountName);
        softAssert.assertEquals(AppointmentPage.getUserName(), user);
        softAssert.assertEquals(AppointmentPage.getStartDate(), newStartFullDate);
        softAssert.assertEquals(AppointmentPage.getStartTime(), newStartTime);
        softAssert.assertEquals(AppointmentPage.getEndDate(), newEndFullDate);
        softAssert.assertEquals(AppointmentPage.getEndTime(), newEndTime);
        softAssert.assertEquals(AppointmentPage.getLocation(), newLocation);
        softAssert.assertEquals(AppointmentPage.getCampaign(), newCampaign);
        softAssert.assertEquals(AppointmentPage.getOpportunity(), lblNone);
        softAssert.assertEquals(AppointmentPage.getNotes(), newNotes);

        AppointmentPage.scrollToLabel("Hours");
        softAssert.assertEquals(AppointmentPage.getHoursInPreparation(), newHoursInPreparation);
        softAssert.assertAll();
    }

    @Test(priority = 12) // Case 48
    public void softCreateAccountCreateOpportunity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpOpportunity();
        OpportunityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(OpportunityManipulationsPage.getTitle(), oppCreateTitle);
        softAssert.assertEquals(OpportunityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(OpportunityManipulationsPage.getProbability(), defaultProbability);
        softAssert.assertEquals(OpportunityManipulationsPage.getCloseDate(), Helpers.getCurrentDate());
        softAssert.assertEquals(OpportunityManipulationsPage.getAccount(), accountName);
        softAssert.assertEquals(OpportunityManipulationsPage.getContact(), oppNoContacts);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(oppStage);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickSave();
        softAssert.assertEquals(OpportunityPage.getTitle(), titleOpportunity.toUpperCase());
        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), defaultDescription);
        softAssert.assertEquals(OpportunityPage.getAccount(), accountName);
        softAssert.assertEquals(OpportunityPage.getUser(), currentUser);
        softAssert.assertEquals(OpportunityPage.getCloseDateInOpportunity(), Helpers.getCurrentDate());
        softAssert.assertEquals(OpportunityPage.getStage(), stageInOpp);
        softAssert.assertEquals(OpportunityPage.getContact(), oppDefaultContact);
        softAssert.assertEquals(OpportunityPage.getCampaign(), defaultCampaign);
        softAssert.assertEquals(OpportunityPage.getProduct(), product);
        softAssert.assertAll();
    }

    @Test(priority = 13) // Case 49
    public void createAccountCreateOpportunityCancel() {
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpOpportunity();
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(oppStage);
        OpportunityManipulationsPage.clickCancel();
        LeftMenuPage.checkSearch();
        LeftMenuPage.clickSearch();
        SearchPage.search(accountName);
        assertEquals(SearchPage.getFirstSearchResult(), accountName);
    }

    @Test(priority = 14) // Case 50
    public void softCreateAccountCreateOpportunityEditOpportunity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpOpportunity();

        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(oppStage);
        OpportunityManipulationsPage.hideKeyboard();
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickSave();
        OpportunityPage.clickTools();
        OpportunityPage.clickEditOpportunity();
        OpportunityManipulationsPage.setOpportunityName();
        opportunityDescription = OpportunityManipulationsPage.getOpportunityName();
        OpportunityManipulationsPage.enterDescription(opportunityDescription);
        OpportunityManipulationsPage.clickUser();
        OpportunityManipulationsPage.selectValueFromPopUp(oppUser);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(oppNewStage);
        OpportunityManipulationsPage.clickProbability();
        OpportunityManipulationsPage.enterProbability(probability);
        OpportunityManipulationsPage.clickCloseDate();
        OpportunityManipulationsPage.selectDateMonth(oppNewMonth);
        OpportunityManipulationsPage.selectDateDay(oppNewDay);
        OpportunityManipulationsPage.selectDateYear(oppNewYear);
        OpportunityManipulationsPage.closePicker();
        OpportunityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(oppNewCampaign);
        OpportunityManipulationsPage.clickLabelProduct();
        NewOrderRowPage.clickRemoveOrderRow();
        NewOrderRowPage.clickPopupRemove();
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(oppNewProduct);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.scrollToLabel(labelOtherInfo);
        OpportunityManipulationsPage.typeIntoNotes(notes);
        OpportunityManipulationsPage.clickSave();

        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), opportunityDescription);
        softAssert.assertEquals(OpportunityPage.getAccount(), accountName);
        softAssert.assertEquals(OpportunityPage.getUser(), oppUser);
        softAssert.assertEquals(OpportunityPage.getCloseDateInOpportunity(), oppNewCloseDate);
        softAssert.assertEquals(OpportunityPage.getStage(), newChangedStageInOpp);
        softAssert.assertEquals(OpportunityPage.getContact(), oppDefaultContact);
        softAssert.assertEquals(OpportunityPage.getCampaign(), oppNewCampaign);
        OpportunityPage.scrollToLabel(labelOtherInfo);
        softAssert.assertEquals(OpportunityPage.getProduct(), oppNewProduct);
        softAssert.assertEquals(OpportunityPage.getNotes(), notes);
        softAssert.assertAll();
    }

    @Test(priority = 15) // Case 51
    public void createAccountCreateContact() {
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.hideKeyboard();
        assertEquals(ContactManipulationPage.getAccount(), accountName);
        ContactManipulationPage.scrollToLabel("Chance");
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickNoThanks();
        assertEquals(ContactPage.getAccount(), accountName);
        assertEquals(ContactPage.getContactName(), contactName);
    }

    @Test(priority = 16) // Case 52
    public void createAccountCreateContactCancel() {
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        assertEquals(ContactManipulationPage.getAccount(), accountName);
        ContactManipulationPage.clickCancel();
//        AccountManipulationsPage.clickBack();
        assertTrue(LeftMenuPage.checkSearch());
        LeftMenuPage.clickSearch();
        SearchPage.search(accountName);
        assertEquals(SearchPage.getFirstSearchResult(), accountName);
    }

    @Test(priority = 17) // Case 53
    public void softCreateAccountCreateContactEditContact() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        assertEquals(ContactManipulationPage.getAccount(), accountName);
        ContactManipulationPage.enterTitle(contactTitle);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(parentAccount);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(contactCategory);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(notes);
        ContactManipulationPage.hideKeyboard();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickNoThanks();

        ContactPage.clickTools();
        ContactPage.clickEditContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.enterTitle(contactNewTitle);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.select(newCampaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(contactCategory);
        AddSelectEntityPage.select(contactNewCategory);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(newNotes);
        ContactPage.swipeFromBottomToTop();
        ContactPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(newExtraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(newChanceOfSuccess);
        ContactManipulationPage.clickSave();
        ContactPage.clickAddContactInfo();
        ContactManipulationPage.enterPhone(contactPhone);
        ContactManipulationPage.enterMobile(contactMobile);
        ContactManipulationPage.enterEmail(contactEmail);
        ContactManipulationPage.clickSave();

        ContactPage.checkPageTitle(contactPageTitle);
        softAssert.assertEquals(ContactPage.getContactName(), contactName);
        softAssert.assertEquals(ContactPage.getContactTitle(), contactNewTitle);
        softAssert.assertEquals(ContactPage.getAccount(), parentAccount);
        softAssert.assertEquals(ContactPage.getPhone(), contactPhone);
        softAssert.assertEquals(ContactPage.getMobile(), contactMobile);
        softAssert.assertEquals(ContactPage.getEmail(), contactEmail);
        softAssert.assertEquals(ContactPage.getCampaign(), newCampaign);
        softAssert.assertEquals(ContactPage.getCategory(), contactNewCategory);
        softAssert.assertEquals(ContactPage.getNotes(), newNotes);
        ContactPage.swipeFromBottomToTop();
        ContactPage.swipeFromBottomToTop();
        softAssert.assertEquals(ContactPage.getExtraID(), newExtraID);
        softAssert.assertEquals(ContactPage.getChanceOfSuccess(), newChanceOfSuccess + "%");
        softAssert.assertAll();
    }

    @Test(priority = 18) // Case 54
    public void softCreateAccountCreateContactEditContactCancel() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();
        AccountManipulationsPage.clickPopUpContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.enterTitle(contactTitle);
        assertEquals(ContactManipulationPage.getAccount(), accountName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(parentAccount);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(contactCategory);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(notes);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickSave();
        ContactManipulationPage.clickNoThanks();

        ContactPage.clickTools();
        ContactPage.clickEditContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.enterTitle(contactNewTitle);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.select(newCampaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(contactCategory);
        AddSelectEntityPage.select(contactNewCategory);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(newNotes);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(newExtraID);
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(newChanceOfSuccess);
        ContactManipulationPage.clickSave();

        ContactPage.clickAddContactInfo();
        ContactManipulationPage.enterPhone(contactPhone);
        ContactManipulationPage.enterMobile(contactMobile);
        ContactManipulationPage.enterEmail(contactEmail);
        ContactManipulationPage.clickCancel();

        ContactPage.checkPageTitle(contactPageTitle);
        softAssert.assertEquals(ContactPage.getContactName(), contactName);
        softAssert.assertEquals(ContactPage.getContactTitle(), contactNewTitle);
        softAssert.assertEquals(ContactPage.getAccount(), parentAccount);
        softAssert.assertEquals(ContactPage.getCampaign(), newCampaign);
        softAssert.assertEquals(ContactPage.getCategory(), contactNewCategory);
        softAssert.assertEquals(ContactPage.getNotes(), newNotes);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        softAssert.assertEquals(ContactPage.getExtraIDWithoutData(), newExtraID);
        softAssert.assertEquals(ContactPage.getChanceOfSuccessWithoutData(), newChanceOfSuccess + "%");
        softAssert.assertAll();
    }

    @Test(priority = 19) // Case 55
    public void softCreateAccountCreateContactCreateActivity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();

        AccountManipulationsPage.clickPopUpContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        ContactManipulationPage.enterTitle(contactTitle);
        assertEquals(ContactManipulationPage.getAccount(), accountName);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(parentAccount);
        ContactManipulationPage.enterPhone(contactPhone);
        ContactManipulationPage.enterMobile(contactMobile);
        ContactManipulationPage.enterEmail(contactEmail);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(contactCategory);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(notes);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickSave();

        ContactManipulationPage.clickActivity();
        ActivityManipulationsPage.setDescription();
        activityDescription = ActivityManipulationsPage.getDescription();
        ActivityManipulationsPage.enterDescription(activityDescription);
        ActivityManipulationsPage.clickTime();
        ActivityManipulationsPage.selectTimeHours(timeHours);
        ActivityManipulationsPage.selectTimeMinutes(timeMinutes);
        ActivityManipulationsPage.selectTimeAmPm(timeAmPm);
        ActivityManipulationsPage.closePicker();
        ActivityManipulationsPage.clickUser();
        AddSelectEntityPage.select(user);
        ActivityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        ActivityManipulationsPage.scrollToLabel(labelOtherInfo);
        ActivityManipulationsPage.typeIntoNotes(notes);
        ActivityManipulationsPage.swipeFromBottomToTop();
        ActivityManipulationsPage.clickExpenses();
        ActivityManipulationsPage.enterExpenses(expenses);

        ActivityManipulationsPage.clickSave();

        softAssert.assertEquals(ActivityPage.getTitle(), defaultActivityType.toUpperCase());
        softAssert.assertEquals(ActivityPage.getDescriptionOnView(), activityDescription);
        softAssert.assertEquals(ActivityPage.getAccountName(), parentAccount);
        softAssert.assertEquals(ActivityPage.getUserName(), user);
        softAssert.assertEquals(ActivityPage.getDate(), ActivityPage.getCurrentDate());
        softAssert.assertEquals(ActivityPage.getTime(), time);
        softAssert.assertEquals(ActivityPage.getContact(), contactName);
//        softAssert.assertEquals(ActivityPage.getContactTitle(), contactTitle);
        softAssert.assertEquals(ActivityPage.getCampaign(), campaign);
        softAssert.assertEquals(ActivityPage.getOpportunity(), lblNone);
        softAssert.assertEquals(ActivityPage.getNotes(), notes);
        ActivityPage.swipeFromBottomToTop();
        softAssert.assertEquals(ActivityPage.getExpenses(), expenses + " SEK");

        ActivityPage.clickLeftMenu();
//        AccountManipulationsPage.clickBack();
        LeftMenuPage.clickSearch();
        SearchPage.search(parentAccount);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabActivities();
//        assertTrue(ActivitiesPage.searchActivityByName(activityDescription));
//        ActivitiesPage.selectActivity(activityDescription);
//        assertEquals(ActivityPage.getUserName(), user);
        softAssert.assertAll();
    }

    @Test(priority = 20) // Case 56
    public void softCreateAccountCreateContactCreateAppointment() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();

        AccountManipulationsPage.clickPopUpContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        assertEquals(ContactManipulationPage.getAccount(), accountName);
        ContactManipulationPage.enterTitle(contactTitle);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(parentAccount);
        ContactManipulationPage.enterPhone(contactPhone);
        ContactManipulationPage.enterMobile(contactMobile);
        ContactManipulationPage.enterEmail(contactEmail);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(contactCategory);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(notes);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickSave();

        ContactManipulationPage.clickAppointment();
        AppointmentManipulationsPage.setAppointmentName();
        AppointmentManipulationsPage.setDefaultAppStartEndDates();
        appointmentName = AppointmentManipulationsPage.getAppointmentName();
        AppointmentManipulationsPage.enterDescription(appointmentName);
        AppointmentManipulationsPage.clickLocation();
        AppointmentManipulationsPage.enterLocation(location);
        AppointmentManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AppointmentManipulationsPage.swipeFromBottomToTop();
        AppointmentManipulationsPage.typeIntoNotes(notes);
        AppointmentManipulationsPage.swipeFromBottomToTop();
        AppointmentManipulationsPage.clickHoursInPreparation();
        AppointmentManipulationsPage.enterHoursInPreparation(hoursInPreparation);

        AppointmentManipulationsPage.swipeFromTopToBottom();
        AppointmentManipulationsPage.swipeFromTopToBottom();
        softAssert.assertEquals(AppointmentManipulationsPage.getAppointmentType(), appDefaultType);
        softAssert.assertEquals(AppointmentManipulationsPage.getStartDate() + " " + AppointmentManipulationsPage.getStartTime(),
                AppointmentManipulationsPage.getDefaultAppStartDate());
        softAssert.assertEquals(AppointmentManipulationsPage.getEndDate() + " " + AppointmentManipulationsPage.getEndTime(),
                AppointmentManipulationsPage.getDefaultAppEndDate());
        softAssert.assertEquals(AppointmentManipulationsPage.getAccount(), parentAccount);
        softAssert.assertEquals(AppointmentManipulationsPage.getContact(), contactName);
        softAssert.assertEquals(AppointmentManipulationsPage.getUser(), defaultUser);
        AppointmentManipulationsPage.clickSave();

        softAssert.assertEquals(AppointmentPage.getTitle(), appDefaultType.toUpperCase());
        softAssert.assertEquals(AppointmentPage.getDescriptionOnView(), appointmentName);
        softAssert.assertEquals(AppointmentPage.getAccountName(), parentAccount);
        softAssert.assertEquals(AppointmentPage.getUserName(), currentUser);
        softAssert.assertEquals(AppointmentPage.getStartDate() + " " + AppointmentPage.getStartTime(),
                AppointmentPage.appStartDateWithDoW());
        softAssert.assertEquals(AppointmentPage.getEndDate() + " " + AppointmentPage.getEndTime(),
                AppointmentPage.appEndDateWithDoW());
        softAssert.assertEquals(AppointmentPage.getLocation(), location);
        softAssert.assertEquals(AppointmentPage.getContactOnView(), contactName);
//        softAssert.assertEquals(AppointmentPage.getContact(), contactTitle);
        softAssert.assertEquals(AppointmentPage.getCampaign(), campaign);
        softAssert.assertEquals(AppointmentPage.getOpportunity(), lblNone);
        AppointmentPage.swipeFromBottomToTop();
        softAssert.assertEquals(AppointmentPage.getNotes(), notes);

        ActivityPage.clickLeftMenu();
//        AccountManipulationsPage.clickBack();
        LeftMenuPage.clickSearch();
        SearchPage.search(parentAccount);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabContacts();

//        ContactsPage.selectContact(contactName);
        ContactPage.swipeFromTopToBottom();
        ContactsPage.clickSearch();
        ContactsPage.search(contactName);
        ContactsPage.selectContact(contactName);
        softAssert.assertEquals(ContactPage.getTitle(), contactPageTitle);
        softAssert.assertEquals(ContactPage.getContactName(), contactName);
        softAssert.assertEquals(ContactPage.getContactTitle(), contactTitle);
        softAssert.assertEquals(ContactPage.getAccount(), parentAccount);
        softAssert.assertEquals(ContactPage.getPhone(), contactPhone);
        softAssert.assertEquals(ContactPage.getMobile(), contactMobile);
        softAssert.assertEquals(ContactPage.getEmail(), contactEmail);
        softAssert.assertEquals(ContactPage.getCampaign(), campaign);
        softAssert.assertEquals(ContactPage.getCategory(), contactCategory);
        softAssert.assertEquals(ContactPage.getNotes(), notes);
        ContactPage.swipeFromBottomToTop();
        ContactPage.swipeFromBottomToTop();
        softAssert.assertEquals(ContactPage.getExtraID(), extraID);
        softAssert.assertEquals(ContactPage.getChanceOfSuccess(), chanceOfSuccess + "%");

        softAssert.assertAll();
    }

    @Test(priority = 21) // Case 57
    public void softCreateAccountCreateContactCreateOpportunity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        AccountManipulationsPage.enterAccountName(accountName);
        AccountManipulationsPage.clickSave();

        AccountManipulationsPage.clickPopUpContact();
        ContactManipulationPage.setContactName();
        contactName = ContactManipulationPage.getContactName();
        ContactManipulationPage.enterContactName(contactName);
        assertEquals(ContactManipulationPage.getAccount(), accountName);
        ContactManipulationPage.enterTitle(contactTitle);
        ContactManipulationPage.clickAccount();
        AddSelectEntityPage.select(parentAccount);
        ContactManipulationPage.enterPhone(contactPhone);
        ContactManipulationPage.enterMobile(contactMobile);
        ContactManipulationPage.enterEmail(contactEmail);
        ContactManipulationPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.clickCategories();
        AddSelectEntityPage.select(contactCategory);
        AddSelectEntityPage.clickSelect();
        ContactManipulationPage.typeIntoNotes(notes);
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.swipeFromBottomToTop();
        ContactManipulationPage.clickChanceOfSuccess();
        ContactManipulationPage.enterChanceOfSuccess(chanceOfSuccess);
        ContactManipulationPage.clickExtraID();
        ContactManipulationPage.enterExtraID(extraID);
        ContactManipulationPage.clickSave();

        ContactManipulationPage.clickOpportunity();
        OpportunityManipulationsPage.setOpportunityName();
        opportunityDescription = OpportunityManipulationsPage.getOpportunityName();

        OpportunityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(OpportunityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(OpportunityManipulationsPage.getCloseDate(), Helpers.getCurrentDate());
        softAssert.assertEquals(OpportunityManipulationsPage.getAccount(), parentAccount);
        softAssert.assertEquals(OpportunityManipulationsPage.getContact(), contactName);

        OpportunityManipulationsPage.enterDescription(opportunityDescription);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(oppStage);
        OpportunityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.swipeFromBottomToTop();
        OpportunityManipulationsPage.typeIntoNotes(notes);
        OpportunityManipulationsPage.clickSave();

        softAssert.assertEquals(OpportunityPage.getTitle(), titleOpportunity.toUpperCase());
        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), opportunityDescription);
        softAssert.assertEquals(OpportunityPage.getAccount(), parentAccount);
        softAssert.assertEquals(OpportunityPage.getUser(), currentUser);
        softAssert.assertEquals(OpportunityPage.getCloseDateInOpportunity(), Helpers.getCurrentDate());
        softAssert.assertEquals(OpportunityPage.getStage(), stageInOpp);
        softAssert.assertEquals(OpportunityPage.getContact(), contactName);
        softAssert.assertEquals(OpportunityPage.getCampaign(), campaign);
        OpportunityPage.swipeFromBottomToTop();
        softAssert.assertEquals(OpportunityPage.getProduct(), product);
        softAssert.assertEquals(OpportunityPage.getNotes(), notes);
        OpportunityPage.clickLeftMenu();

        LeftMenuPage.clickSearch();
        SearchPage.search(parentAccount);
        SearchPage.clickOnFirstSearchResult();

        AccountPage.clickTabContacts();
        ContactsPage.search(contactName);
//        ContactsPage.clickBack();
        AccountPage.clickTabOpportunities();
        OpportunitiesPage.searchOpportunity(opportunityDescription, dateToday);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}