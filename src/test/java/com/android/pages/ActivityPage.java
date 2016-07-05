package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityPage extends BasePage {

    private static final By buttonLeftMenu = MobileBy.IosUIAutomation(".navigationBar().buttons()[1]");

    private static final By labelActivityDescriptionValue = MobileBy.IosUIAutomation(".staticTexts()[0]");
    private static final By buttonTools = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[\"Right Icon\"]");
    private static final By buttonAccount = MobileBy.IosUIAutomation(".buttons()[0]");
    private static final By labelUserValue = MobileBy.IosUIAutomation(".staticTexts()[2]");
    private static final By labelDateValue = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[0].textFields()[0]");
    private static final By labelTimeValue = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[0].staticTexts()[1]");
    private static final By buttonContact = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[1].textFields()[0]");
    private static final By labelContactTitle = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[1]");
    private static final By labelCampaignValue = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By labelCampaignWithoutContact = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By labelCampaignWithoutContactAndTime = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By labelOpportunityValue = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[3].staticTexts()[1]");
    private static final By labelOpportunityWithoutContact = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By labelOpportunityWithoutContactAndTime = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By fieldNotesValue = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[4].textViews()[0]");
    private static final By fieldNotesWithoutContact = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[3].textViews()[0]");;
    private static final By fieldNotesWithoutContactAndTime = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].textViews()[0]");;
    private static final By labelEttTillValueWithoutContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7].staticTexts()[1]");
    private static final By labelEttTillValue = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[6].staticTexts()[2]");

    private static final By popoverEditActivity = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[0].staticTexts()[1]");
    private static final By popoverCloseActivity = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[3].staticTexts()[1]");
    private static final By popoverFollowUpActivity = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[3]");

    private static final By thirdCellValue = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[1]");

    private static final By labelShowMore = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[5]");

    public static void clickShowMore() {
        find(labelShowMore).click();
    }

    public static void clickLeftMenu() {
        find(buttonLeftMenu).click();
    }

    public static void clickFollowUpActivity() {
        find(popoverFollowUpActivity).click();
    }

    public static String getThirdCellValue() {
        return getName(thirdCellValue);
    }

    public static void clickTools() {
        wait(buttonTools);
        find(buttonTools).click();
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickDateTime() {
        find(labelDateValue).click();
    }

    public static void clickContact() {
        find(buttonContact).click();
    }


    public static void clickEditActivity() {
        wait(popoverEditActivity);
        find(popoverEditActivity).click();
    }


    public static String getActivityDescription() {
        wait(buttonTools);
        return getValue(labelActivityDescriptionValue);
    }

    public static String getAccountName() {
        return getLabel(buttonAccount);
    }

    public static String getContact() {
        return getValue(buttonContact);
    }

    public static String getUserName() {
        return getValue(labelUserValue);
    }

    public static String getDate() {
        return getValue(labelDateValue);
    }

    public static String getTime() {
        return getValue(labelTimeValue);
    }

    public static String getCampaign() {
        return getValue(labelCampaignValue);
    }

    public static String getCampaignWithoutContact() {
        return getValue(labelCampaignWithoutContact);
    }

    public static String getCampaignWithoutContactAndTime() {
        return getValue(labelCampaignWithoutContactAndTime);
    }

    public static String getOpportunity() {
        return getValue(labelOpportunityValue);
    }

    public static String getOpportunityWithoutContactAndTime() {
        return getValue(labelOpportunityWithoutContactAndTime);
    }

    public static String getOpportunityWithoutContact() {
        return getValue(labelOpportunityWithoutContact);
    }

    public static String getNotes() {
        return getValue(fieldNotesValue);
    }

    public static String getNotesWithoutContact() {
        return getValue(fieldNotesWithoutContact);
    }

    public static String getNotesWithoutContactAndTime() {
        return getValue(fieldNotesWithoutContactAndTime);
    }

    public static boolean checkThereIsNoContact() {
        boolean res = false;
        String thirdValue = getThirdCellValue();
//        System.out.println(thirdValue);
        if (thirdValue.equals("Campaign")) {
            res = true;
        }
        return res;
    }

//    public static String getContact() {
//        return getValue(buttonContact);
//    }

    public static String getContactTitle() {
        return getValue(labelContactTitle);
    }

    public static String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("EEEE d MMM YYYY");
        Date date = new Date();
        return df.format(date);
    }

    public static String getCustomWheelEttTillWithoutContact() {
        return getValue(labelEttTillValueWithoutContact);
    }

    public static String getCustomWheelEttTill() {
        return getValue(labelEttTillValue);
    }

    public static boolean getNotesStartsWith(String start) {
        return getValue(fieldNotesValue).startsWith(start);
    }

    public static String getTextEditActivity() {
        return getValue(popoverEditActivity);
    }
}
