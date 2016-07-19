package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ActivityPage extends BasePage {

    private static final By buttonLeftMenu = MobileBy.IosUIAutomation(".navigationBar().buttons()[1]");

    private static final By labelActivityDescriptionValue = MobileBy.id("activity_title");
    private static final By buttonTools = MobileBy.id("save");
    private static final By buttonAccount = MobileBy.id("activity_contact");
    private static final By labelUserValue = MobileBy.id("user_name");
    private static final By dateValue = MobileBy.id("date");
    private static final By timeValue = MobileBy.id("time");
    private static final By fieldNotesValue = MobileBy.id("notes");

    private static final List<WebElement> users = findElements(MobileBy.id("user_title"));
    private static final WebElement contactValue = users.get(1);

    private static final List<WebElement> values = findElements(MobileBy.id("select"));
    private static final WebElement campaignValue = values.get(0);
    private static final WebElement opportunityValue = values.get(1);


    private static final By labelContactTitle = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[1]");
    private static final By labelCampaignWithoutContact = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By labelCampaignWithoutContactAndTime = MobileBy.xpath("//android.support.v4.view.ViewPager[1]//android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By labelOpportunityWithoutContact = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By labelOpportunityWithoutContactAndTime = MobileBy.xpath("//android.support.v4.view.ViewPager[1]//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By fieldNotesWithoutContact = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[3].textViews()[0]");;
    private static final By fieldNotesWithoutContactAndTime = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].textViews()[0]");;
    private static final By labelEttTillValueWithoutContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7].staticTexts()[1]");
    private static final By labelEttTillValue = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[6].staticTexts()[2]");

    private static final By popoverEditActivity = MobileBy.id("item_edit");
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
        find(buttonTools).click();
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickDateTime() {
        find(dateValue).click();
    }

    public static void clickEditActivity() {
        waitByThread(1000);
//        ((AndroidDriver)getDriver()).tap(1, 790, 300, 1);
        find(popoverEditActivity).click();
    }

    public static String getActivityDescription() {
        wait(buttonTools);
        return getText(labelActivityDescriptionValue);
    }

    public static String getAccountName() {
        return getText(buttonAccount);
    }

    public static String getContact() {
        return contactValue.getText();
    }

    public static String getUserName() {
        return getText(labelUserValue);
    }

    public static String getDate() {
        return getText(dateValue);
    }

    public static String getTime() {
        return getText(timeValue);
    }

    public static String getCampaign() {
        return campaignValue.getText();
    }

    public static String getCampaignWithoutContact() {
        return getValue(labelCampaignWithoutContact);
    }

    public static String getCampaignWithoutContactAndTime() {
        return getText(labelCampaignWithoutContactAndTime);
    }

    public static String getOpportunity() {
        return opportunityValue.getText();
    }

    public static String getOpportunityWithoutContactAndTime() {
        return getText(labelOpportunityWithoutContactAndTime);
    }

    public static String getOpportunityWithoutContact() {
        return getValue(labelOpportunityWithoutContact);
    }

    public static String getNotes() {
        return getText(fieldNotesValue);
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
//        return getValue(contactValue);
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

