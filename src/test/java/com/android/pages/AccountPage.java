package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {

    private static final By buttonLeftMenu = MobileBy.xpath("//android.view.ViewGroup[1]/android.widget.ImageButton[1]");

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

    private static final By labelAccountName = MobileBy.xpath("//*[contains(@resource-id, 'container_header')]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By labelParent = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[1]");
    private static final By labelAccountManager = MobileBy.id("user_title");
    private static final By labelAccountManagerValue = MobileBy.xpath("//*[contains(@resource-id, 'user_container')]//*[contains(@resource-id, 'user')]//*[contains(@resource-id, 'subTitle')]");
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
    private static final By website = MobileBy.id("website");
    private static final By labelAddresses = MobileBy.IosUIAutomation(".tableViews()[0].groups()[0].staticTexts()[0]");
    private static final By labelCampaignsValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[1]");
    private static final By labelCategoriesValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].staticTexts()[1]");

    private static final By tabHome = MobileBy.xpath(".tabBars()[0].buttons()[0]");
    private static final By tabContacts = MobileBy.xpath("//*[contains(@resource-id, 'root_tab')]//*[@text='Contacts']/..");
    private static final By tabActivity = MobileBy.xpath("//*[contains(@resource-id, 'root_tab')]//*[@text='Activities']/..");
    private static final By tabOpportunities = MobileBy.xpath("//*[@text='Opportunities' and contains(@resource-id, 'title_text')]/..");
    private static final By tabSales = MobileBy.xpath("//*[contains(@resource-id, 'title_text') and @text='Sales']/..");

    public static String getAccountName() {
        wait(labelAccountName);
        return getText(labelAccountName);
    }

    public static String getAccountMangerLabel() {
        return getText(labelAccountManager);
    }

    public static String getAccountManagerValue() {
        return getText(labelAccountManagerValue);
    }

    public static String getWebsite() {
        return getText(website);
    }

    public static void clickLeftMenu() {
        find(buttonLeftMenu).click();
    }

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
        clickTab(tabContacts);
    }

    public static void clickTabActivities() {
        clickTab(tabActivity);
    }

    public static void clickTabOpportunities() {
        clickTab(tabOpportunities);
    }

    public static void clickTabSales() {
        clickTab(tabSales);
    }

    private static void clickTab(By tab) {
        waitByThread(1500);
        waitToBeClickable(tab);
        find(tab).click();
    }
}
