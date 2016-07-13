package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AppointmentPage extends BasePage {

    private static final By buttonLeftMenu = MobileBy.IosUIAutomation(".navigationBar().buttons()[2]");
    private static final By buttonLeftMenuInFollowUp = MobileBy.IosUIAutomation(".navigationBar().buttons()[1]");

    private static final By labelAppointmentDescriptionValue = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[0]");
    private static final By buttonTools = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[\"Right Icon\"]");
    private static final By buttonAccount = MobileBy.IosUIAutomation(".tableViews()[0].buttons()[0]");
    private static final By labelUserValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0].staticTexts()[1]");
    private static final By labelStartDateValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].staticTexts()[0]");
    private static final By labelEndDateValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[0]");
    private static final By labelStartTimeValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By labelEndTimeValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By labelLocationValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[0]");
    private static final By labelCampaignValueWithoutContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].staticTexts()[1]");
    private static final By labelCampaignValueWithContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[5].staticTexts()[1]");
    private static final By labelOpportunityValueWithoutContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[5].staticTexts()[1]");
    private static final By labelOpportunityValueWithContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6].staticTexts()[1]");
    private static final By buttonContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].staticTexts()[0]");
    private static final By labelContactTitle = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].staticTexts()[1]");
    private static final By notes = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7].textViews()[0]");
    private static final By notesWithoutContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6].textViews()[0]");
    private static final By labelShowMore = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8]");

    private static final By motesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].staticTexts()[1]");
    private static final By labelMotesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].staticTexts()[1]");
    private static final By motetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[9].textFields()[0]");
    private static final By labelMotetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[9].staticTexts()[0]");


    private static final By popoverEditAppointment = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[0].staticTexts()[1]");
    private static final By popoverDeleteAppointment = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By popoverFollowUp = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[2].staticTexts()[0]");
    private static final By popoverFollowUpActivity = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[3].staticTexts()[1]");
    private static final By popoverFollowUpAppointment = MobileBy.IosUIAutomation(".popover().tableViews()[0].cells()[4].staticTexts()[1]");

    private static final By fifththCellValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4]");

    public static String getFifthCellValue() {
        return getValue(fifththCellValue);
    }

    public static void clickLeftMenu() {
        find(buttonLeftMenu).click();
    }

    public static void clickLeftMenuInFollowUp() {
        wait(buttonLeftMenuInFollowUp);
        find(buttonLeftMenuInFollowUp).click();
    }

    public static void clickTools() {
        wait(buttonTools);
        find(buttonTools).click();
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickContact() {
        find(buttonContact).click();
    }

    public static void clickEditAppointment() {
        find(popoverEditAppointment).click();
//        waitInvisibilityOfElement(popoverEditAppointment);
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
        return getValue(labelAppointmentDescriptionValue);
    }

    public static String getAccountName() {
        return getName(buttonAccount);
    }

    public static String getContact() {
        return getValue(buttonContact);
    }

    public static String getContactTitle() {
        return getValue(labelContactTitle);
    }

    public static String getUserName() {
        return getValue(labelUserValue);
    }

    public static String getStartDate() {
        return getValue(labelStartDateValue).substring(3);
    }

    public static String getEndDate() {
        return getValue(labelEndDateValue).substring(3);
    }

    public static String getStartTime() {
        return getValue(labelStartTimeValue).substring(3);
    }

    public static String getEndTime() {
        return getValue(labelEndTimeValue).substring(3);
    }

    public static String getCampaignWithoutContact() {
        return getValue(labelCampaignValueWithoutContact);
    }

    public static String getLocation() {
        return trimFirstFourChars(getValue(labelLocationValue));
//        return trimFirstTwoChars(getValue(labelLocationValue));
    }

    public static String getNotes() {
        return getValue(notes);
    }

    public static String getNotesWithoutContact() {
        return getValue(notesWithoutContact);
    }

    public static String getCampaign() {
        return getValue(labelCampaignValueWithContact);
    }

    public static String getOpportunity() {
        return getValue(labelOpportunityValueWithContact);
    }

    public static String getOpportunityWithoutContact() {
        return getValue(labelOpportunityValueWithoutContact);
    }

    public static String getMotesalternativ() {
        return getValue(motesalternativ);
    }

    public static String getMotetCustomfalt() {
//        ((IOSDriver)getDriver()).scrollTo("OTHER INFO");
        return getValue(motetCustomfalt);
    }

    public static boolean checkThereIsNoContact() {
        boolean res = false;
        String thirdValue = getFifthCellValue();
        if (thirdValue.equals("Campaign")) {
            res = true;
        }
        return res;
    }

    public static String getTextEditAppointment() {
        return getValue(popoverEditAppointment);
    }
}
