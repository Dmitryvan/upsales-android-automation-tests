package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppointmentManipulationsPage extends BasePage {

    private static String appointmentName;
    private static final String namePrefix = "app_";

    private static final By defaultLabelDescription = MobileBy.id("text_input");
    private static final By fieldDescription = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0].textViews()[0]");
    private static final By buttonAppointmentType = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='1']");
    private static final By labelAppointmentType = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By pickerWheelAppointmentType = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].pickers()[0].wheels()");
    private static final By buttonAccount = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='7']");
    private static final By buttonStarts = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='2']");
    private static final By buttonEnds = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='4']");
    private static final By buttonLocation = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4]");
    private static final By buttonContacts = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='9']");
    private static final By buttonOpportunity = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='11']");
    private static final By buttonUser = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='13']");
    private static final By buttonCampaign = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='16']");
    private static final By fieldNotes = MobileBy.IosUIAutomation(".tableViews()[0].cells()[10].textViews()[0]");
    private static final By fieldLocation = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].textFields()[0]");
    private static final By buttonSelectUser = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[2]");
    private static final By pickerWheelOpportunity = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].pickers()[0].wheels()[0]");
    private static final By pickerWheelStartDate = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[0]");
    private static final By pickerWheelStartHours = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[1]");
    private static final By pickerWheelStartMinutes = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[2]");
    private static final By pickerWheelStartAmPm = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[3]");
    private static final By pickerWheelEndDate = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[0]");
    private static final By pickerWheelEndHours = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[1]");
    private static final By pickerWheelEndMinutes = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[2]");
    private static final By pickerWheelEndAmPm = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[3]");
    private static final By labelStartDateTime = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[2]");
    private static final By labelEndDateTime = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[2]");
    private static final By labelLocation = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].staticTexts()[0]");
    private static final By labelAccount = MobileBy.IosUIAutomation(".tableViews()[0].cells()[5].staticTexts()[1]");
    private static final By labelContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6].staticTexts()[1]");
    private static final By labelOpportunity = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7].staticTexts()[1]");
    private static final By labelUser = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].staticTexts()[1]");
    private static final By labelCampaign = MobileBy.IosUIAutomation(".tableViews()[0].cells()[9].staticTexts()[0]");
    private static final By labelNotes = MobileBy.IosUIAutomation(".tableViews()[0].cells()[10].staticTexts()[\"Notes\"]");
    private static final By account = MobileBy.IosUIAutomation(".tableViews()[0].cells()[5].staticTexts()[2]");
    private static final By contact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6].staticTexts()[2]");
    private static final By opportunity = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7].staticTexts()[2]");
    private static final By user = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].staticTexts()[2]");
    private static final By campaign = MobileBy.IosUIAutomation(".tableViews()[0].cells()[9].staticTexts()[1]");
    private static final By buttonInsertSignature = MobileBy.IosUIAutomation(".tableViews()[0].cells()[10].staticTexts()[1]");
    private static final By startDate = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[2]");
    private static final By endDate = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[2]");
    private static final By labelOtherInfo = MobileBy.IosUIAutomation(".tableViews()[0].groups()[4].staticTexts()[0]");
    private static final By startDateForAcc = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By endDateForAcc = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[1]");

    private static final By motesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11].staticTexts()[0]");
    private static final By labelMotesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11].staticTexts()[1]");
    private static final By pickerWheelMotesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].pickers()[0].wheels()[0]");
    private static final By motetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].staticTexts()[0]");
    private static final By labelMotetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].staticTexts()[0]");
    private static final By fieldMotetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].textViews()[0]");

    private static final String cellIndexAppointmentType = "2";

    public static String getLabelOtherInfo() {
        return getValue(labelOtherInfo);
    }

    public static String getStartDate() {
        return getValue(startDate);
    }

    public static String getEndDateForAcc() {
        return getValue(endDateForAcc);
    }

    public static String getStartDateForAcc() {
        return getValue(startDateForAcc);
    }

    public static String getEndDate() {
        return getValue(endDate);
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickStarts() {
        find(buttonStarts).click();
    }

    public static void selectStartDate(String date) {
        find(pickerWheelStartDate).sendKeys(date);
    }

    public static void selectStartHours(String hours) {
        find(pickerWheelStartHours).sendKeys(hours);
    }

    public static void selectStartMinutes(String minutes) {
        find(pickerWheelStartMinutes).sendKeys(minutes);
    }

    public static void selectStartAmPm(String value) {
        find(pickerWheelStartAmPm).sendKeys(value);
    }

    public static void clickEnds() {
        find(buttonEnds).click();
    }

    public static void selectEndDate(String date) {
        find(pickerWheelEndDate).sendKeys(date);
    }

    public static void selectEndHours(String hours) {
        find(pickerWheelEndHours).sendKeys(hours);
    }

    public static void selectEndMinutes(String minutes) {
        find(pickerWheelEndMinutes).sendKeys(minutes);
    }

    public static void selectEndAmPm(String value) {
        find(pickerWheelEndAmPm).sendKeys(value);
    }

    public static void clickLocation() {
//        find(buttonLocation).click();
        WebElement el = find(buttonLocation);
        el.click();
        el.click();
    }

    public static void enterLocation(String location) {
        sendValues(location, fieldLocation);
        hideKeyboard();
    }

    public static void clickContacts() {
        wait(buttonContacts);
        find(buttonContacts).click();
    }

    public static void clickButtonSelect() {
        find(buttonSelectUser).click();
    }

    public static void clickOpportunity() {
        find(buttonOpportunity).click();
    }

    public static void spinOpportunityWheelTo(String value) {
//        spinWheel(value, pickerWheelOpportunity, cellIndexOpportunity);
        find(pickerWheelOpportunity).sendKeys(value);
    }

    public static void clickUser() {
        find(buttonUser).click();
    }

    public static void clickCampaign() {
        find(buttonCampaign).click();
    }

    public static void typeIntoNotes(String note) {
        setValues(note, fieldNotes);
    }

    public static void clickInsertSignature() {
        find(buttonInsertSignature).click();
    }

    public static void clickMotesalternativ() {
        find(labelMotesalternativ).click();
    }

    public static void spinMotesalternativWheelTo(String value) {
//        spinWheel(value, pickerWheelOpportunity, cellIndexOpportunity);
        find(pickerWheelMotesalternativ).sendKeys(value);
    }

    public static void clickMotetCustomfalt() {
        find(labelMotetCustomfalt).click();
    }

    public static void enterMotetCustomfalt(String value) {
        sendValues(value, fieldMotetCustomfalt);
    }

    public static void enterDescription (String description) {
        wait(labelAppointmentType);
        IOSElement element = (IOSElement) find(fieldDescription);
        element.click();
        element.clear();
        element.setValue(description);
        hideKeyboard();
    }

    public static String getDefaultLabelDescription() {
        return getText(defaultLabelDescription);
    }

    public static void clickAppointmentType() {
        find(buttonAppointmentType).click();
    }

    public static String getLabelAppointmentType() {
        return getText(labelAppointmentType);
    }

    public static String getLabelStartDateTime() {
        return getValue(labelStartDateTime);
    }

    public static String getLabelEndDateTime() {
        return getValue(labelEndDateTime);
    }

    public static String getLabelLocation() {
        return getValue(labelLocation);
    }

    public static String getAccount() {
        return getValue(account);
    }

    public static String getContact() {
        return getValue(contact);
    }

    public static String getOpportunity() {
        return getValue(opportunity);
    }

    public static String getUser() {
        return getValue(user);
    }

    public static String getNotes() {
        return getValue(fieldNotes);
    }

    public static String getCampaign() {
        return getValue(campaign);
    }

    public static String getMotesalternativ() {
        return getValue(motesalternativ);
    }

    public static String getMotetCustomfalt() {
        return getValue(motetCustomfalt);
    }

    public static String getLabelAccount() {
        return getValue(labelAccount);
    }

    public static String getLabelContact() {
        return getValue(labelContact);
    }

    public static String getLabelNotes() {
        return getValue(labelNotes);
    }

    public static String getLabelCampaign() {
        return getValue(labelCampaign);
    }

    public static String getLabelUser() {
        return getValue(labelUser);
    }

    public static String getLabelOpportunity() {
        return getValue(labelOpportunity);
    }

    public static void spinWheelToAppointmentType(String appointmentType) {
//        find(pickerWheelAppointmentType).sendKeys(appointmentType);
        spinWheel(appointmentType, pickerWheelAppointmentType, cellIndexAppointmentType);
    }

    public static String getAllAppointmentTypes() {
        return  find(pickerWheelAppointmentType).getAttribute("values");
    }

    public static void setAppointmentName() {
        appointmentName = generateName(namePrefix);
    }

    public static String getAppointmentName() {
        return appointmentName;
    }
}
