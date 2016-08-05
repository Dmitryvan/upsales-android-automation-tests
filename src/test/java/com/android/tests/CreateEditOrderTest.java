package com.android.tests;

import com.android.pages.*;
import com.android.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.android.util.ScreenshotTaker.class)
public class CreateEditOrderTest extends BaseTest {

    private String orderName;

    private final String dashboardPropertyPath = "src/test/resources/dashboard.properties";
    private final String titleDashboard = PropertyLoader.loadProperty(dashboardPropertyPath, "title");

    private final String newOrderPropertyPath = "src/test/resources/newOrder.properties";
    private final String titleNewOrderRow = PropertyLoader.loadProperty(newOrderPropertyPath, "title");
    private final String titleAddProduct = PropertyLoader.loadProperty(newOrderPropertyPath, "titleAddProduct");
    private final String labelAdd = PropertyLoader.loadProperty(newOrderPropertyPath, "labelAdd");
    private final String product = PropertyLoader.loadProperty(newOrderPropertyPath, "product");
    private final String labelProduct = PropertyLoader.loadProperty(newOrderPropertyPath, "labelProduct");
    private final String defaultProductName = PropertyLoader.loadProperty(newOrderPropertyPath, "defaultProductName");
    private final String labelQuantity = PropertyLoader.loadProperty(newOrderPropertyPath, "labelQuantity");
    private final String defaultQuantity = PropertyLoader.loadProperty(newOrderPropertyPath, "defaultQuantity");
    private final String labelPrice = PropertyLoader.loadProperty(newOrderPropertyPath, "labelPrice");
    private final String defaultPrice = PropertyLoader.loadProperty(newOrderPropertyPath, "defaultPrice");

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
    private final String contact = PropertyLoader.loadProperty(commonPropertyPath, "contact");
    private final String notes = PropertyLoader.loadProperty(commonPropertyPath, "notes");
    private final String firstUser = PropertyLoader.loadProperty(commonPropertyPath, "newUser");
    private final String campaign = PropertyLoader.loadProperty(commonPropertyPath, "campaign");
    private final String newContact = PropertyLoader.loadProperty(commonPropertyPath, "newContact");
    private final String newCampaign = PropertyLoader.loadProperty(commonPropertyPath, "newCampaign");
    private final String newNotes = PropertyLoader.loadProperty(commonPropertyPath, "newNotes");
    private final String labelContact = PropertyLoader.loadProperty(commonPropertyPath, "labelContact");
    private final String today = PropertyLoader.loadProperty(commonPropertyPath, "today");

    private final String orderPropertyPath = "src/test/resources/opportunity.properties";
    private final String titleCreate = PropertyLoader.loadProperty(orderPropertyPath, "titleCreateOrder");
    private final String labelUser = PropertyLoader.loadProperty(orderPropertyPath, "labelUser");
    private final String labelStage = PropertyLoader.loadProperty(orderPropertyPath, "labelStage");
    private final String defaultStage = PropertyLoader.loadProperty(orderPropertyPath, "defaultStage");
    private final String allStages = PropertyLoader.loadProperty(orderPropertyPath, "allOrderStages");
    private final String labelProbability = PropertyLoader.loadProperty(orderPropertyPath, "labelProbability");
    private final String defaultProbability = PropertyLoader.loadProperty(orderPropertyPath, "defaultOrderProbability");
    private final String labelCloseDate = PropertyLoader.loadProperty(orderPropertyPath, "labelCloseDate");
    private final String defaultContact = PropertyLoader.loadProperty(orderPropertyPath, "defaultContact");
    private final String labelOrdersRow = PropertyLoader.loadProperty(orderPropertyPath, "labelOrdersRow");
    private final String labelNewOrderRow = PropertyLoader.loadProperty(orderPropertyPath, "labelNewOrderRow");
    private final String orderStage = PropertyLoader.loadProperty(orderPropertyPath, "orderStage");
    private final String titleOrder = PropertyLoader.loadProperty(orderPropertyPath, "titleOrder");
    private final String stageInOrder = PropertyLoader.loadProperty(orderPropertyPath, "stageInOrder");
    private final String secondUser = PropertyLoader.loadProperty(orderPropertyPath, "secondUser");
    private final String newOrderStage = PropertyLoader.loadProperty(orderPropertyPath, "newOrderStage");
    private final String month = PropertyLoader.loadProperty(orderPropertyPath, "month");
    private final String day = PropertyLoader.loadProperty(orderPropertyPath, "day");
    private final String year = PropertyLoader.loadProperty(orderPropertyPath, "year");
    private final String newMonth = PropertyLoader.loadProperty(orderPropertyPath, "newMonth");
    private final String newDay = PropertyLoader.loadProperty(orderPropertyPath, "newDay");
    private final String newYear = PropertyLoader.loadProperty(orderPropertyPath,"newYear");
    private final String newProduct = PropertyLoader.loadProperty(orderPropertyPath, "newProduct");
    private final String closeDate = PropertyLoader.loadProperty(orderPropertyPath, "closeDate");
    private final String newCloseDate = PropertyLoader.loadProperty(orderPropertyPath, "newCloseDate");
    private final String newStageInOrder = PropertyLoader.loadProperty(orderPropertyPath, "newStageInOrder");
    private final String labelRowTotal = PropertyLoader.loadProperty(orderPropertyPath, "labelRowTotal");
    private final String closeDateInOpps = PropertyLoader.loadProperty(orderPropertyPath, "closeDateInOpps");
    private final String newProbability = PropertyLoader.loadProperty(orderPropertyPath, "newProbability");
    private final String probability = PropertyLoader.loadProperty(orderPropertyPath, "probability");

    @BeforeMethod
    public void setUp() throws Exception{
        super.setUp();
        LoginPage.login();
        BasePage.clickLeftMenu();
        LeftMenuPage.clickCreate();
        CreateMenuPage.clickOrder();
        OpportunityManipulationsPage.setOpportunityName();
        orderName = OpportunityManipulationsPage.getOpportunityName();
    }

    @Test(priority = 1) //CASE 17
    public void softContentOfNewOrderPage() {
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
        softAssert.assertEquals(OpportunityManipulationsPage.getCloseDate(), Helpers.getCurrentDate());
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
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelNotes(), labelNotes);
        OpportunityManipulationsPage.scrollToLabel(labelOtherInfo);
        softAssert.assertEquals(OpportunityManipulationsPage.getLabelOtherInfo(), labelOtherInfo);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.checkPageTitle(titleNewOrderRow);
        softAssert.assertEquals(NewOrderRowPage.getLabelCancel(), labelCancel);
        softAssert.assertEquals(NewOrderRowPage.getLabelAdd(), labelAdd);
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
        AddSelectEntityPage.select(product);
        softAssert.assertEquals(NewOrderRowPage.getLabelRowTotal(), labelRowTotal);
        softAssert.assertAll();
    }

    @Test (priority = 2) //CASE 18
    public void softCreateOrder() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.enterDescription(orderName);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(orderStage);
//        OpportunityManipulationsPage.clickAccount();
//        AddSelectEntityPage.select(account);
//        OpportunityManipulationsPage.clickNewOrderRow();
//        NewOrderRowPage.clickProduct();
//        AddSelectEntityPage.select(product);
//        NewOrderRowPage.clickAdd();
//        OpportunityManipulationsPage.clickSave();
//        softAssert.assertEquals(OpportunityPage.getAccount(), account);
//        softAssert.assertEquals(OpportunityPage.getStage(), stageInOrder);
//        softAssert.assertEquals(OpportunityPage.getDescription(), orderName);
//        OpportunityPage.checkPageTitle(titleOrder.toUpperCase());
//        OpportunityPage.clickLeftMenu();
//        LeftMenuPage.clickSearch();
//        SearchPage.search(account);
//        SearchPage.clickOnFirstSearchResult();
//        AccountPage.clickTabSales();
//        softAssert.assertTrue(OpportunitiesPage.searchOpportunity(orderName, today.toUpperCase()));
        softAssert.assertAll();
    }

    @Test(priority = 3) //CASE 19
    public void softCancelOrderBeforeSave() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.enterDescription(orderName);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(orderStage);
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

    @Test(priority = 4) //CASE 21
    public void softCancelAfterSelectEditOrder() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.enterDescription(orderName);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(orderStage);
        OpportunityManipulationsPage.clickAccount();
        AddSelectEntityPage.select(account);
        OpportunityManipulationsPage.clickContact();
        AddSelectEntityPage.select(contact);
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(product);
        NewOrderRowPage.clickAdd();
//        OpportunityManipulationsPage.typeIntoNotes(notes);
        OpportunityManipulationsPage.clickSave();
        OpportunityPage.clickTools();
        OpportunityPage.clickEditSale();
        OpportunityManipulationsPage.setOpportunityName();
        String newOrderName = OpportunityManipulationsPage.getOpportunityName();
        OpportunityManipulationsPage.enterDescription(newOrderName);
//        OpportunityManipulationsPage.clickDoneOnKeyboard();
        OpportunityManipulationsPage.clickUser();
        OpportunityManipulationsPage.selectValueFromPopUp(firstUser);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(newOrderStage);
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
        OpportunityManipulationsPage.clickNewOrderRow();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(newProduct);
        NewOrderRowPage.clickAdd();
        OpportunityManipulationsPage.clickCancel();
        softAssert.assertEquals(OpportunityPage.getDescription(), orderName);
        softAssert.assertEquals(OpportunityPage.getAccount(), account);
        softAssert.assertEquals(OpportunityPage.getUser(), yourUser);
        softAssert.assertEquals(OpportunityPage.getStage(), stageInOrder);
        softAssert.assertEquals(OpportunityPage.getCloseDateInOrder(), Helpers.getCurrentDate());
        softAssert.assertEquals(OpportunityPage.getContact(), contact);
        softAssert.assertEquals(OpportunityPage.getCampaign(), labelNone);
        softAssert.assertEquals(OpportunityPage.getProduct(), product);
        softAssert.assertEquals(OpportunityPage.getNotes(), notes);
        softAssert.assertAll();
    }

    @Test(priority = 5) //CASE 20
    public void softEditOrder() {
        SoftAssertExtended softAssert = new SoftAssertExtended();
        OpportunityManipulationsPage.enterDescription(orderName);
        OpportunityManipulationsPage.clickUser();
        OpportunityManipulationsPage.selectValueFromPopUp(firstUser);
        softAssert.assertEquals(OpportunityManipulationsPage.getUser(), firstUser);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(orderStage);
        softAssert.assertEquals(OpportunityManipulationsPage.getStage(), stageInOrder);
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
        NewOrderRowPage.clickAdd();
//        OpportunityManipulationsPage.typeIntoNotes(notes);
        OpportunityManipulationsPage.clickSave();
        OpportunityPage.clickTools();
        OpportunityPage.clickEditSale();
        OpportunityManipulationsPage.setOpportunityName();
        String newOrderName = OpportunityManipulationsPage.getOpportunityName();
        OpportunityManipulationsPage.enterDescription(newOrderName);
//        OpportunityManipulationsPage.clickDoneOnKeyboard();
        OpportunityManipulationsPage.clickUser();
        OpportunityManipulationsPage.selectValueFromPopUp(secondUser);
        OpportunityManipulationsPage.clickStage();
        OpportunityManipulationsPage.selectValueFromPopUp(newOrderStage);
        OpportunityManipulationsPage.clickProbability();
        OpportunityManipulationsPage.enterProbability(newProbability);
        OpportunityManipulationsPage.clickCloseDate();
        OpportunityManipulationsPage.selectDateMonth(newMonth);
        OpportunityManipulationsPage.selectDateDay(newDay);
        OpportunityManipulationsPage.selectDateYear(newYear);
        OpportunityManipulationsPage.closePicker();
        OpportunityManipulationsPage.clickContact();
        OpportunityManipulationsPage.selectValueFromPopUp(newContact);
        OpportunityManipulationsPage.clickCampaign();
        AddSelectEntityPage.select(newCampaign);
        OpportunityManipulationsPage.clickLabelProduct();
        NewOrderRowPage.clickProduct();
        AddSelectEntityPage.select(newProduct);
        NewOrderRowPage.clickSave();
//        OpportunityManipulationsPage.typeIntoNotes(newNotes);
        OpportunityManipulationsPage.clickSave();
        softAssert.assertEquals(OpportunityPage.getDescription(), newOrderName);
        softAssert.assertEquals(OpportunityPage.getAccount(), account);
        softAssert.assertEquals(OpportunityPage.getUser(), secondUser);
        softAssert.assertEquals(OpportunityPage.getStage(), newStageInOrder);
        softAssert.assertEquals(OpportunityPage.getCloseDateInOrder(), newCloseDate);
        softAssert.assertEquals(OpportunityPage.getContact(), newContact);
        softAssert.assertEquals(OpportunityPage.getCampaign(), newCampaign);
        softAssert.assertEquals(OpportunityPage.getProduct(), newProduct);
        softAssert.assertEquals(OpportunityPage.getNotes(), newNotes);
        OpportunityPage.clickLeftMenu();
        LeftMenuPage.clickSearch();
        SearchPage.search(account);
        SearchPage.clickOnFirstSearchResult();
        AccountPage.clickTabSales();
        softAssert.assertTrue(OpportunitiesPage.searchOpportunity(newOrderName, closeDateInOpps));
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
