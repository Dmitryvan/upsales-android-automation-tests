package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {

    private static final By buttonTools = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[2]");
    private static final By buttonParentAccount = MobileBy.IosUIAutomation(".tableViews()[0].buttons()[0]");
    private static final By buttonCampaign = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[0]");
    private static final By buttonCateories = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].staticTexts()[0]");

    private static final By popoverEditAccount = MobileBy.id("item_edit");
    private static final By popoverDeleteAccount = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[1]");
    private static final By popoverLabelCreateNew = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[2]");
    private static final By popoverActivity = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[3]");
    private static final By popoverAppointment = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[4]");
    private static final By popoverOpportunity = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[5]");
    private static final By popoverOrder = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[6]");
    private static final By popoverContact = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[7]");

    private static final By labelAccountName = MobileBy.id("contact_name");
    private static final By labelParent = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[1]");
    private static final By labelAccountManager = MobileBy.id("user_title");
    private static final By labelAccountManagerValue = MobileBy.id("user_name");
    private static final By labelNextActivity = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[4]");
    private static final By labelNextActivityValue = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[6]");
    private static final By labelActivitiesCount = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[7]");
    private static final By labelActivities = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[8]");
    private static final By labelPipelineCount = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[9]");
    private static final By labelPipeline = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[10]");
    private static final By labelSalesCount = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[11]");
    private static final By labelSales = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[12]");
    private static final By labelCampaignsCount = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[13]");
    private static final By labelCampaigns = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[14]");
    private static final By labelPhone = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0].staticTexts()[1]");
    private static final By labelWebsite = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By labelAddresses = MobileBy.IosUIAutomation(".tableViews()[0].groups()[0].staticTexts()[0]");
    private static final By labelCampaignsValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[1]");
    private static final By labelCategoriesValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].staticTexts()[1]");

    private static final By tabHome = MobileBy.xpath(".tabBars()[0].buttons()[0]");
    private static final By tabContacts = MobileBy.xpath("//*[@class='android.widget.TextView' and @text='Contacts']");
    private static final By tabActivity = MobileBy.xpath("//*[@class='android.widget.TextView' and @text='Activities']");
    private static final By tabOppotunities = MobileBy.IosUIAutomation(".tabBars()[0].buttons()[\"Opportunities\"]");
    private static final By tabSales = MobileBy.IosUIAutomation(".tabBars()[0].buttons()[\"Sales\"]");

    public static String getAccountName() {
//        waitByThread(500);
        return getText(labelAccountName);
    }

    public static String getAccountMangerLabel() {
        return getText(labelAccountManager);
    }

    public static String getAccountManagerValue() {
        return getText(labelAccountManagerValue);
    }

//    public static void clickTools() {
//        wait(buttonTools);
//        find(buttonTools).click();
//    }

    public static void clickParentAccount() {
        find(buttonParentAccount).click();
    }

    public static void clickCampaign() {
        find(buttonCampaign).click();
    }

    public static void clickCateories() {
        find(buttonCateories).click();
    }

    public static void clickPopoverEdit() {
        find(popoverEditAccount).click();
    }

    public static void clickPopoverDelete() {
        find(popoverDeleteAccount).click();
    }

    public static void clickActivity() {
        find(popoverActivity).click();
    }

    public static void clickAppointment() {
        find(popoverAppointment).click();
    }

    public static void clickOpportunity() {
        find(popoverOpportunity).click();
    }

    public static void clickOrder() {
        find(popoverOrder).click();
    }

    public static void clickContact() {
        find(popoverContact).click();
    }

    public static void clickTabHome() {
        find(tabHome).click();
    }

    public static void clickTabContacts() {
        find(tabContacts).click();
    }

    public static void clickTabActivities() {
        wait(labelAccountName);
        find(tabActivity).click();
    }

    public static void clickTabOpportunities() {
        find(tabOppotunities).click();
    }

    public static void clickTabSales() {
        find(tabSales).click();
    }
}
