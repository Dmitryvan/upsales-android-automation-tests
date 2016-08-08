package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class OpportunityPage extends BasePage {

    private static final By leftMenuOnCreatedOpp = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[0]");

    private static final By description = MobileBy.id("header_title");
    private static final By account = MobileBy.id("account_name");
    private static final By stage = MobileBy.xpath("//*[contains(@resource-id, 'stage_order_field')]//*[contains(@resource-id, 'select')]");
    private static final By user = MobileBy.xpath("//*[contains(@resource-id, 'user')]//*[contains(@resource-id, 'user_name')]");
    private static final By contact = MobileBy.xpath("//*[contains(@resource-id, 'contact_field')]//*[contains(@resource-id, 'select')]");
    private static final By campaign = MobileBy.xpath("//*[contains(@resource-id, 'company_field')]//*[contains(@resource-id, 'select')]");
    private static final By product = MobileBy.xpath("//*[contains(@resource-id, 'order_content')]//*[contains(@resource-id, 'name')]");
    private static final By notes = MobileBy.id("notes");
    private static final By closeDateInOpportunity = MobileBy.xpath("//android.widget.LinearLayout[@index='4']//android.widget.TextView[@index='0']");
    private static final By closeDateInOrder = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[5]");
    private static final By quantityPrice = MobileBy.id("formula");
    private static final By buttonStage = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0]");

    private static final By popoverEditOpportunity = MobileBy.id("item_edit");
    private static final By popoverAddProductRow = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[0]");
    private static final By popoverDeleteOpportunity = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[2]");
    private static final By popoverEditSale = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[0]");
    private static final By popoverDeleteSale = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[1]");

    public static void clickEditOpportunity() {
        find(popoverEditOpportunity).click();
    }

    public static void clickEditSale() {
        find(popoverEditSale).click();
    }

    public static void clickDeleteSale() {
        find(popoverDeleteSale).click();
    }

    public static void clickAddProductRow() {
        find(popoverAddProductRow).click();
    }

    public static void clickDeleteOpportunity() {
        find(popoverDeleteOpportunity).click();
    }

    public static String getCloseDateInOpportunity() {
        return getText(closeDateInOpportunity);
    }

    public static String getCloseDateInOrder() {
        return getValue(closeDateInOrder);
    }

    public static String getNotes() {
        return getText(notes);
    }

    public static String getContact() {
        return getText(contact);
    }

    public static String getCampaign() {
        return getText(campaign);
    }

    public static String getProduct() {
        return getText(product);
    }

    public static void clickLeftMenuOnCreatedOpp() {
        find(leftMenuOnCreatedOpp).click();
    }

    public static void clickAccount() {
        find(account).click();
    }

    public static String getDescription() {
        return findElements(description).get(0).getText();
    }

    public static String getAccount() {
        return getText(account);
    }

    public static String getStage() {
        return getText(stage);
    }

    public static String getUser() {
        return getText(user);
    }

    public static String getQuantity() {
        String value = getText(quantityPrice);
        return value.substring(0, 1);
    }

    public static String getPrice() {
        String value = getText(quantityPrice);
        return value.substring(4, 6);
    }

    public static void clickStage() {
        wait(buttonStage);
        find(buttonStage).click();
    }
}
