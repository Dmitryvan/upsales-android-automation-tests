package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.android.util.ScreenshotTaker.class)
public class CreateEditOpportunityTest extends BaseTest {

    private String opportunityName;

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    private final String newOrderPropertyPath = "src/test/resources/newOrder.properties";
    private final String titleNewOrderRow = PropertyLoader.loadProperty(newOrderPropertyPath, "title");
    private final String labelProduct = PropertyLoader.loadProperty(newOrderPropertyPath, "labelProduct");
    private final String defaultProductName = PropertyLoader.loadProperty(newOrderPropertyPath, "defaultProductName");
    private final String labelQuantity = PropertyLoader.loadProperty(newOrderPropertyPath, "labelQuantity");
    private final String defaultQuantity = PropertyLoader.loadProperty(newOrderPropertyPath, "defaultQuantity");
    private final String labelPrice = PropertyLoader.loadProperty(newOrderPropertyPath, "labelPrice");
    private final String defaultPrice = PropertyLoader.loadProperty(newOrderPropertyPath, "defaultPrice");
    private final String titleAddProduct = PropertyLoader.loadProperty(newOrderPropertyPath, "titleAddProduct");
    private final String labelAdd = PropertyLoader.loadProperty(newOrderPropertyPath, "labelAdd");
    private final String product = PropertyLoader.loadProperty(newOrderPropertyPath, "product");

    private final String commonPropertyPath = "src/test/resources/common.properties";
    private final String defaultLabelDescription = PropertyLoader.loadProperty(commonPropertyPath, "defaultDescription");
    private final String defaultUser = PropertyLoader.loadProperty(commonPropertyPath, "defaultUser");
    private final String yourUser = PropertyLoader.loadProperty(commonPropertyPath, "currentUser");
    private final String labelAccount = PropertyLoader.loadProperty(commonPropertyPath, "labelAccount");
    private final String defaultAccount = PropertyLoader.loadProperty(commonPropertyPath, "defaultAccount");
    private final String titleSelectAccount = PropertyLoader.loadProperty(commonPropertyPath, "titleSelectAccount");
    private final String labelSearch = PropertyLoader.loadProperty(commonPropertyPath, "labelSearch");
    private final String labelCancel = PropertyLoader.loadProperty(commonPropertyPath, "labelCancel");
    private final String labelResults = PropertyLoader.loadProperty(commonPropertyPath, "labelResults");
    private final String labelCampaign = PropertyLoader.loadProperty(commonPropertyPath, "labelCampaign");
    private final String defaultCampaign = PropertyLoader.loadProperty(commonPropertyPath, "defaultCampaign");
    private final String titleAddCampaign = PropertyLoader.loadProperty(commonPropertyPath, "titleAddCampaign");
    private final String labelNone = PropertyLoader.loadProperty(commonPropertyPath, "labelNone");
    private final String labelOtherInfo = PropertyLoader.loadProperty(commonPropertyPath, "labelOtherInfo");
    private final String labelNotes = PropertyLoader.loadProperty(commonPropertyPath, "labelNotes");
    private final String labelSave = PropertyLoader.loadProperty(commonPropertyPath, "labelSave");
    private final String account = PropertyLoader.loadProperty(commonPropertyPath, "account");
    private final String titleOpportunity = PropertyLoader.loadProperty(commonPropertyPath, "labelOpportunity");
    private final String contact = PropertyLoader.loadProperty(commonPropertyPath, "contact");
    private final String notes = PropertyLoader.loadProperty(commonPropertyPath, "notes");
    private final String firstUser = PropertyLoader.loadProperty(commonPropertyPath, "newUser");
    private final String campaign = PropertyLoader.loadProperty(commonPropertyPath, "campaign");
    private final String newContact = PropertyLoader.loadProperty(commonPropertyPath, "newContact");
    private final String newCampaign = PropertyLoader.loadProperty(commonPropertyPath, "newCampaign");
    private final String newNotes = PropertyLoader.loadProperty(commonPropertyPath, "newNotes");
    private final String labelContact = PropertyLoader.loadProperty(commonPropertyPath, "labelContact");
    private final String today = PropertyLoader.loadProperty(commonPropertyPath, "today");

    private final String opportunityPropertyPath = "src/test/resources/opportunity.properties";
    private final String titleCreate = PropertyLoader.loadProperty(opportunityPropertyPath, "titleCreate");
    private final String labelUser = PropertyLoader.loadProperty(opportunityPropertyPath, "labelUser");
    private final String labelStage = PropertyLoader.loadProperty(opportunityPropertyPath, "labelStage");
    private final String defaultStage = PropertyLoader.loadProperty(opportunityPropertyPath, "defaultStage");
    private final String allStages = PropertyLoader.loadProperty(opportunityPropertyPath, "allStages");
    private final String labelProbability = PropertyLoader.loadProperty(opportunityPropertyPath, "labelProbability");
    private final String defaultProbability = PropertyLoader.loadProperty(opportunityPropertyPath, "defaultProbability");
    private final String labelCloseDate = PropertyLoader.loadProperty(opportunityPropertyPath, "labelCloseDate");
    private final String defaultContact = PropertyLoader.loadProperty(opportunityPropertyPath, "defaultContact");
    private final String labelOrdersRow = PropertyLoader.loadProperty(opportunityPropertyPath, "labelOrdersRow");
    private final String labelNewOrderRow = PropertyLoader.loadProperty(opportunityPropertyPath, "labelNewOrderRow");
    private final String stage = PropertyLoader.loadProperty(opportunityPropertyPath, "stage");
    private final String stageInOpp = PropertyLoader.loadProperty(opportunityPropertyPath, "stageInOpp");
    private final String secondUser = PropertyLoader.loadProperty(opportunityPropertyPath, "secondUser");
    private final String newStage = PropertyLoader.loadProperty(opportunityPropertyPath, "newStage");
    private final String month = PropertyLoader.loadProperty(opportunityPropertyPath, "month");
    private final String day = PropertyLoader.loadProperty(opportunityPropertyPath, "day");
    private final String year = PropertyLoader.loadProperty(opportunityPropertyPath, "year");
    private final String newMonth = PropertyLoader.loadProperty(opportunityPropertyPath, "newMonth");
    private final String newDay = PropertyLoader.loadProperty(opportunityPropertyPath, "newDay");
    private final String newYear = PropertyLoader.loadProperty(opportunityPropertyPath,"newYear");
    private final String newProduct = PropertyLoader.loadProperty(opportunityPropertyPath, "newProduct");
    private final String closeDate = PropertyLoader.loadProperty(opportunityPropertyPath, "closeDate");
    private final String newCloseDate = PropertyLoader.loadProperty(opportunityPropertyPath, "newCloseDate");
    private final String newStageInOpp = PropertyLoader.loadProperty(opportunityPropertyPath, "newStageInOpp");
    private final String newChangedStageInOpp = PropertyLoader.loadProperty(opportunityPropertyPath, "newChangedStageInOpp");
    private final String closeDateInOpps = PropertyLoader.loadProperty(opportunityPropertyPath, "closeDateInOpps");
    private final String quantity = PropertyLoader.loadProperty(opportunityPropertyPath, "quantity");
    private final String newQuantity = PropertyLoader.loadProperty(opportunityPropertyPath, "newQuantity");
    private final String price = PropertyLoader.loadProperty(opportunityPropertyPath, "price");
    private final String newPrice = PropertyLoader.loadProperty(opportunityPropertyPath, "newPrice");
    private final String probability = PropertyLoader.loadProperty(opportunityPropertyPath, "probability");
    private final String newProbability = PropertyLoader.loadProperty(opportunityPropertyPath, "newProbability");

    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        DashboardPage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickOpportunity();
        OpportunityManipulationsPage.setOpportunityName();
        opportunityName = OpportunityManipulationsPage.getOpportunityName();
    }

    @Test(priority = 1) // CASE 12
    public void softContentOfCreateOpportunityPage() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.checkPageTitle(titleCreate);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelSave(), labelSave);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelDescription(), defaultLabelDescription);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelUser(), labelUser);
        softAssert.assertEquals(OpportunityManipulationsPage.getUser(), defaultUser);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelStage(), labelStage);
        softAssert.assertEquals(OpportunityManipulationsPage.getStage(), defaultStage);
        OpportunityManipulationsPage.clickStage();
        softAssert.assertEquals(OpportunityManipulationsPage.getAllStages(), allStages);
        OpportunityManipulationsPage.closePopUp();
        OpportunityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelProbability(), labelProbability);
        softAssert.assertEquals(OpportunityManipulationsPage.getProbability(), defaultProbability);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelCloseDate(), labelCloseDate);
        softAssert.assertEquals(OpportunityManipulationsPage.getCloseDate(), OpportunityManipulationsPage.getCurrentDate());
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelAccount(), labelAccount);
        softAssert.assertEquals(OpportunityManipulationsPage.getAccount(), defaultAccount);
        OpportunityManipulationsPage.clickAccount();
        softAssert.assertEquals(AddSelectEntityPage.getTitle(), titleSelectAccount);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), labelSearch);
        softAssert.assertEquals(AddSelectEntityPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(AddSelectEntityPage.getResultsLabelValue(), labelResults);
        AddSelectEntityPage.clickBack();
        OpportunityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelContact(), labelContact);
        softAssert.assertEquals(OpportunityManipulationsPage.getContact(), defaultContact);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelCampaign(), labelCampaign);
        softAssert.assertEquals(OpportunityManipulationsPage.getCampaign(), defaultCampaign);
        OpportunityManipulationsPage.clickCampaign();
        AddSelectEntityPage.checkPageTitle(titleAddCampaign);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), labelSearch);
        softAssert.assertEquals(AddSelectEntityPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(AddSelectEntityPage.getLabelNone(), labelNone);
        AddSelectEntityPage.clickBack();
        OpportunityManipulationsPage.hideKeyboard();
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelOrdersRow(), labelOrdersRow);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelNewOrderRow(), labelNewOrderRow);
        OpportunityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelNotes(), labelNotes);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelOtherInfo(), labelOtherInfo);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.checkPageTitle(titleNewOrderRow);
        softAssert.assertEquals(NewOrderRowPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(NewOrderRowPage.getLabelSave(), labelAdd);
        softAssert.assertEquals(NewOrderRowPage.getLabelProduct(), labelProduct);
        softAssert.assertEquals(NewOrderRowPage.getProductName(), defaultProductName);
        softAssert.assertEquals(NewOrderRowPage.getLabelQuantity(), labelQuantity);
        softAssert.assertEquals(NewOrderRowPage.getQuantity(), defaultQuantity);
        softAssert.assertEquals(NewOrderRowPage.getLabelPrice(), labelPrice);
        softAssert.assertEquals(NewOrderRowPage.getPrice(), defaultPrice);
        softAssert.assertEquals(NewOrderRowPage.getLabelOtherInfo(), labelOtherInfo);
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.checkPageTitle(titleAddProduct);
        softAssert.assertEquals(AddSelectEntityPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(AddSelectEntityPage.getSearchFieldValue(), labelSearch);
        softAssert.assertAll();
    }

    @Test(priority = 2) // CASE 13
    public void softCreateOpportunity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.enterDescription(opportunityName);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(stage);
        OpportunityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickSave();
        softAssert.assertEquals(OpportunityPage.getAccount(), account);
        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), opportunityName);
        softAssert.assertEquals(OpportunityPage.getStage(), stageInOpp);
        softAssert.assertEquals(OpportunityPage.getTitleOnView(), titleOpportunity.toUpperCase());
        OpportunityPage.clickAccount();
        AccountPage.clickTabOpportunities();
        AccountPage.clickTabOpportunities();
        softAssert.assertTrue(OpportunitiesPage.searchOpportunity(opportunityName, today.toUpperCase()));
        softAssert.assertAll();
    }

    @Test(priority = 3) //CASE 14
    public void softCancelOpportunityBeforeSave() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.enterDescription(opportunityName);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(stage);
        OpportunityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickCancel();
        softAssert.assertTrue(LeftMenuPage.checkSearch());
        softAssert.assertEquals(LeftMenuPage.getHiddenPageTitle(), titleDashboard);
        softAssert.assertAll();
    }

    @Test(priority = 4) //CASE 16
    public void softCancelAfterSelectEditOpportunity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.enterDescription(opportunityName);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(stage);
        OpportunityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        OpportunityManipulationsPage.clickContact();
        AddSelectEntityPage.select(contact);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.scrollToLabel(labelOtherInfo);
        OpportunityManipulationsPage.typeIntoNotes(notes);
        OpportunityManipulationsPage.clickSave();
        OpportunityPage.clickTools();
        OpportunityPage.clickEditOpportunity();
        OpportunityManipulationsPage.setOpportunityName();
        String newOppName = OpportunityManipulationsPage.getOpportunityName();
        OpportunityManipulationsPage.enterDescription(newOppName);
        OpportunityManipulationsPage.clickUser();
        OpportunityManipulationsPage.selectValueFromPopUp(firstUser);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(newStage);
        OpportunityManipulationsPage.clickProbability();
        OpportunityManipulationsPage.enterProbability(newProbability);
        OpportunityManipulationsPage.clickCloseDate();
        OpportunityManipulationsPage.selectDateMonth(month);
        OpportunityManipulationsPage.selectDateDay(day);
        OpportunityManipulationsPage.selectDateYear(year);
        OpportunityManipulationsPage.closePicker();
        OpportunityManipulationsPage.clickContact();
        AddSelectEntityPage.select(newContact);
        OpportunityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        OpportunityManipulationsPage.scrollToLabel(labelOtherInfo);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(newProduct);
        NewOrderRowPage.clickQuantity();
        NewOrderRowPage.enterQuantity(newQuantity);
        NewOrderRowPage.clickPrice();
        NewOrderRowPage.enterPrice(newPrice);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickCancel();
        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), opportunityName);
        softAssert.assertEquals(OpportunityPage.getAccount(), account);
        softAssert.assertEquals(OpportunityPage.getUser(), yourUser);
        softAssert.assertEquals(OpportunityPage.getStage(), stageInOpp);
        softAssert.assertEquals(OpportunityPage.getCloseDateInOpportunity(), OpportunityPage.getCurrentDate());
        softAssert.assertEquals(OpportunityPage.getContact(), contact);
        softAssert.assertEquals(OpportunityPage.getCampaign(), defaultCampaign);
        OpportunityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(OpportunityPage.getProduct(), product);
        softAssert.assertEquals(OpportunityPage.getNotes(), notes);
        softAssert.assertAll();
    }

    @Test(priority = 5) //CASE 15
    public void softEditOpportunity() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.enterDescription(opportunityName);
        OpportunityManipulationsPage.clickUser();
        OpportunityManipulationsPage.selectValueFromPopUp(firstUser);
        softAssert.assertEquals(OpportunityManipulationsPage.getUser(), firstUser);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(stage);
        softAssert.assertEquals(OpportunityManipulationsPage.getStage(), stageInOpp);
        OpportunityManipulationsPage.clickProbability();
        OpportunityManipulationsPage.enterProbability(probability);
        OpportunityManipulationsPage.hideKeyboard();
        OpportunityManipulationsPage.clickCloseDate();
        OpportunityManipulationsPage.selectDateMonth(month);
        OpportunityManipulationsPage.selectDateDay(day);
        OpportunityManipulationsPage.selectDateYear(year);
        OpportunityManipulationsPage.closePicker();
        softAssert.assertEquals(OpportunityManipulationsPage.getCloseDate(), closeDate);
        OpportunityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        softAssert.assertEquals(OpportunityManipulationsPage.getAccount(), account);
        OpportunityManipulationsPage.clickContact();
        AddSelectEntityPage.select(contact);
        softAssert.assertEquals(OpportunityManipulationsPage.getContact(), contact);
        OpportunityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(campaign);
        softAssert.assertEquals(OpportunityManipulationsPage.getCampaign(), campaign);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        softAssert.assertEquals(NewOrderRowPage.getProductName(), product);
        NewOrderRowPage.clickQuantity();
        NewOrderRowPage.enterQuantity(quantity);
        NewOrderRowPage.clickPrice();
        NewOrderRowPage.enterPrice(price);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.scrollToLabel(labelOtherInfo);
        OpportunityManipulationsPage.typeIntoNotes(notes);
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
        OpportunityManipulationsPage.clickProbability();
        OpportunityManipulationsPage.enterProbability(newProbability);
        OpportunityManipulationsPage.clickCloseDate();
        OpportunityManipulationsPage.selectDateMonth(newMonth);
        OpportunityManipulationsPage.selectDateDay(newDay);
        OpportunityManipulationsPage.selectDateYear(newYear);
        OpportunityManipulationsPage.closePicker();
        OpportunityManipulationsPage.clickContact();
        AddSelectEntityPage.select(newContact);
        OpportunityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        OpportunityManipulationsPage.clickLabelProduct();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(newProduct);
        NewOrderRowPage.clickQuantity();
        NewOrderRowPage.enterQuantity(newQuantity);
        NewOrderRowPage.clickPrice();
        NewOrderRowPage.enterPrice(newPrice);
        NewOrderRowPage.clickSave();
        OpportunityManipulationsPage.scrollToLabel(labelOtherInfo);
        OpportunityManipulationsPage.typeIntoNotes(newNotes);
        OpportunityManipulationsPage.clickSave();
        softAssert.assertEquals(OpportunityPage.getDescriptionOnView(), newOppName);
        softAssert.assertEquals(OpportunityPage.getAccount(), account);
        softAssert.assertEquals(OpportunityPage.getUser(), secondUser);
        softAssert.assertEquals(OpportunityPage.getStage(), newChangedStageInOpp);
        softAssert.assertEquals(OpportunityPage.getCloseDateInOpportunity(), newCloseDate);
        softAssert.assertEquals(OpportunityPage.getContact(), newContact);
        softAssert.assertEquals(OpportunityPage.getCampaign(), newCampaign);
        softAssert.assertEquals(OpportunityPage.getProduct(), newProduct);
        softAssert.assertEquals(OpportunityPage.getQuantity(), newQuantity);
        softAssert.assertEquals(OpportunityPage.getPrice(), newPrice);
        OpportunityManipulationsPage.swipeFromBottomToTop();
        softAssert.assertEquals(OpportunityPage.getNotes(), newNotes);
        OpportunityPage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(account);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabOpportunities();
        softAssert.assertTrue(OpportunitiesPage.searchOpportunity(newOppName, closeDateInOpps));
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
