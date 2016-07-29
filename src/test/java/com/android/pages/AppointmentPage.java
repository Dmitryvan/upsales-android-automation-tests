package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentPage extends BasePage {

    private static final By buttonLeftMenu = MobileBy.IosUIAutomation(".navigationBar().buttons()[2]");
    private static final By buttonLeftMenuInFollowUp = MobileBy.IosUIAutomation(".navigationBar().buttons()[1]");

    private static final By appointmentDescriptionValue = MobileBy.id("activity_title");
    private static final By buttonAccount = MobileBy.id("activity_contact");
    private static final By userValue = MobileBy.id("user_name");
    private static final By locationValue = MobileBy.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
    private static final By notes = MobileBy.id("notes");
    private static final By labelShowMore = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8]");

    private static final By motesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].staticTexts()[1]");
    private static final By motetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[9].textFields()[0]");

    private static final By popoverEditAppointment = MobileBy.id("item_edit");
    private static final By popoverFollowUpActivity = MobileBy.id("item_follow");
    private static final By popoverFollowUpAppointment = MobileBy.id("item_follow_appointment");

    private static final By popoverLabelEditAppointment = MobileBy.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']");

    private static final By fifththCellValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4]");

    private static final By campaign = MobileBy.xpath("//android.support.v4.view.ViewPager[1]//android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By opportunity = MobileBy.xpath("//android.support.v4.view.ViewPager[1]//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");

    private static final By date = MobileBy.id("date");
    private static final By time = MobileBy.id("time");

    public static String getFifthCellValue() {
        return getValue(fifththCellValue);
    }

    public static void clickLeftMenu() {
        find(buttonLeftMenu).click();
    }

    public static void clickLeftMenuInFollowUp() {
        find(buttonLeftMenuInFollowUp).click();
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickEditAppointment() {
        find(popoverEditAppointment).click();
    }

    public static void clickShowMore() {
        find(labelShowMore).click();
    }

    public static void clickFollowUpActivity() {
        find(popoverFollowUpActivity).click();
    }

    public static void clickFollowUpAppointment() {
        find(popoverFollowUpAppointment).click();
    }

    public static String getAppointmentDescription() {
        return getText(appointmentDescriptionValue);
    }

    public static String getAccountName() {
        return getText(buttonAccount);
    }

    public static String getContact() {
        List<WebElement> users = findElements(MobileBy.id("user_title"));
        return users.get(1).getText();
    }

    public static String getUserName() {
        return getText(userValue);
    }

    public static String getStartDate() {
        return findElements(date).get(0).getText();
    }

    public static String getEndDate() {
        return findElements(date).get(1).getText();
    }

    public static String getStartTime() {
        return findElements(time).get(0).getText();
    }

    public static String getEndTime() {
        return findElements(time).get(1).getText();
    }

    public static String getCampaign() {
        return getText(campaign);
    }

    public static String getLocation() {
        return getText(locationValue);
    }

    public static String getNotes() {
        return getText(notes);
    }

    public static String getOpportunity() {
        return getText(opportunity);
    }

    public static String getMotesalternativ() {
        return getValue(motesalternativ);
    }

    public static String getMotetCustomfalt() {
//        ((IOSDriver)getDriver()).scrollTo("OTHER INFO");
        return getValue(motetCustomfalt);
    }

    public static String getTextEditAppointment() {
        return getText(popoverLabelEditAppointment);
    }
}
