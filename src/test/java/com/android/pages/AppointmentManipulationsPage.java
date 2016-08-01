package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentManipulationsPage extends BasePage {

    private static String appointmentName;
    private static final String namePrefix = "app_";

    private static final By listAppointmentType = MobileBy.id("text1");

    private static final By buttonAppointmentType = MobileBy.id("appointment_type_field");
    private static final By fieldLocation = MobileBy.xpath("//android.widget.RelativeLayout[@index='7']//android.widget.EditText[@index='0']");
    private static final By buttonContacts = MobileBy.id("contact_field");
    private static final By buttonOpportunity = MobileBy.id("opportunity_field");
    private static final By buttonUser = MobileBy.id("user_field");

    private static final List<WebElement> labels = findElements(MobileBy.id("name"));
    private static final WebElement labelAppointmentType = labels.get(0);
    private static final WebElement labelStartDateTime = labels.get(1);
    private static final WebElement labelEndDateTime = labels.get(2);
    private static final WebElement labelLocation = labels.get(3);
    private static final WebElement labelAccount = labels.get(4);
    private static final WebElement labelContact = labels.get(5);
    private static final WebElement labelOpportunity = labels.get(6);
    private static final WebElement labelUser = labels.get(7);
    private static final WebElement labelCampaign = labels.get(8);

//    private static final List<WebElement> dates = findElements(MobileBy.id("date"));
    private static final By startDate = MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By endDate = MobileBy.xpath("//android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");

//    private static final List<WebElement> times = findElements(MobileBy.id("time"));
    private static final By startTime = MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By endTime = MobileBy.xpath("//android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");

//    private static final List<WebElement> values = findElements(MobileBy.id("select"));
    private static final By appointmentType = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By account = MobileBy.xpath("//android.widget.RelativeLayout[6]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By contact = MobileBy.xpath("//android.widget.RelativeLayout[7]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By opportunity = MobileBy.xpath("//android.widget.RelativeLayout[8]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By user = MobileBy.xpath("//android.widget.RelativeLayout[9]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By campaign = MobileBy.xpath("//android.widget.RelativeLayout[10]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");

    private static final By pickerWheelOpportunity = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].pickers()[0].wheels()[0]");

    private static final By buttonInsertSignature = MobileBy.IosUIAutomation(".tableViews()[0].cells()[10].staticTexts()[1]");
    private static final By startDateForAcc = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By endDateForAcc = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[1]");

    private static final By motesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11].staticTexts()[0]");
    private static final By labelMotesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11].staticTexts()[1]");
    private static final By pickerWheelMotesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].pickers()[0].wheels()[0]");
    private static final By motetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].staticTexts()[0]");
    private static final By labelMotetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].staticTexts()[0]");
    private static final By fieldMotetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].textViews()[0]");

    public static String getStartDate() {
        return find(startDate).getText();
    }

    public static String getStartTime() {
        return find(startTime).getText();
    }

    public static String getEndTime() {
        return find(endTime).getText();
    }

    public static String getEndDateForAcc() {
        return getValue(endDateForAcc);
    }

    public static String getStartDateForAcc() {
        return getValue(startDateForAcc);
    }

    public static String getEndDate() {
        return find(endDate).getText();
    }

    public static String getLocation() {
        return getText(fieldLocation);
    }

    public static void clickStartsDate() {
        find(startDate).click();
    }

    public static void clickStartsTime() {
        find(startTime).click();
    }

    public static void clickEndsDate() {
        find(endDate).click();
    }

    public static void clickEndsTime() {
        find(endTime).click();
    }

    public static void clickLocation() {
        find(fieldLocation).click();
    }

    public static void enterLocation(String location) {
        WebElement el = find(fieldLocation);
        el.clear();
        el.sendKeys(location);
        hideKeyboard();
    }

    public static void clickContacts() {
        wait(buttonContacts);
        find(buttonContacts).click();
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

    public static void clickInsertSignature() {
        find(buttonInsertSignature).click();
    }

    public static void clickMotesalternativ() {
        find(labelMotesalternativ).click();
    }

    public static void spinMotesalternativWheelTo(String value) {
        find(pickerWheelMotesalternativ).sendKeys(value);
    }

    public static void clickMotetCustomfalt() {
        find(labelMotetCustomfalt).click();
    }

    public static void enterMotetCustomfalt(String value) {
        sendValues(value, fieldMotetCustomfalt);
    }

    public static void clickAppointmentType() {
        find(buttonAppointmentType).click();
    }

    public static String getLabelAppointmentType() {
        return labelAppointmentType.getText();
    }

    public static String getLabelStartDateTime() {
        return labelStartDateTime.getText();
    }

    public static String getAppointmentType() {
        return find(appointmentType).getText();
    }

    public static String getLabelEndDateTime() {
        return labelEndDateTime.getText();
    }

    public static String getLabelLocation() {
        return labelLocation.getText();
    }

    public static String getAccount() {
        return find(account).getText();
    }

    public static String getContact() {
        return find(contact).getText();
    }

    public static String getOpportunity() {
        return find(opportunity).getText();
    }

    public static String getUser() {
        return find(user).getText();
    }

    public static String getCampaign() {
        return find(campaign).getText();
    }

    public static String getMotesalternativ() {
        return getValue(motesalternativ);
    }

    public static String getMotetCustomfalt() {
        return getValue(motetCustomfalt);
    }

    public static String getLabelAccount() {
        return labelAccount.getText();
    }

    public static String getLabelContact() {
        return labelContact.getText();
    }

    public static String getLabelNotes() {
        By labelNotes = MobileBy.xpath("//android.widget.RelativeLayout[6]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
        return getText(labelNotes);
    }

    public static String getLabelCampaign() {
        return labelCampaign.getText();
    }

    public static String getLabelUser() {
        return labelUser.getText();
    }

    public static String getLabelOpportunity() {
        return labelOpportunity.getText();
    }

    public static void spinWheelToAppointmentType(String appointmentType) {
//        find(pickerWheelAppointmentType).sendKeys(appointmentType);
    }

    public static String getAllAppointmentTypes() {
        String string = "";
        List<WebElement> accTypes = getDriver().findElements(listAppointmentType);
        for (int i = 0, k = accTypes.size(); i < k; i++) {
            string += accTypes.get(i).getText();
            if (i < k - 1)
                string += ", ";
        }
        return string;
    }

    public static void setAppointmentName() {
        appointmentName = generateName(namePrefix);
    }

    public static String getAppointmentName() {
        return appointmentName;
    }
}
