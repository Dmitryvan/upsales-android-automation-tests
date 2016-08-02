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

    private static final By labelAppointmentType = MobileBy.xpath("//*[contains(@resource-id, 'appointment_type_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelStartDateTime = MobileBy.xpath("//*[contains(@resource-id, 'starts_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelEndDateTime = MobileBy.xpath("//*[contains(@resource-id, 'ends_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelLocation = MobileBy.xpath("//*[contains(@resource-id, 'location')]//*[contains(@resource-id, 'name')]");
    private static final By labelUser = MobileBy.xpath("//*[contains(@resource-id, 'user_field')]//*[contains(@resource-id, 'name')]");

    private static final By startDate = MobileBy.xpath("//*[contains(@resource-id, 'starts_field')]//*[contains(@resource-id, 'date')]");
    private static final By endDate = MobileBy.xpath("//*[contains(@resource-id, 'ends_field')]//*[contains(@resource-id, 'date')]");

    private static final By startTime = MobileBy.xpath("//*[contains(@resource-id, 'starts_field')]//*[contains(@resource-id, 'time')]");
    private static final By endTime = MobileBy.xpath("//*[contains(@resource-id, 'ends_field')]//*[contains(@resource-id, 'time')]");

    private static final By appointmentType = MobileBy.xpath("//*[contains(@resource-id, 'appointment_type_field')]//*[contains(@resource-id, 'select')]");
    private static final By user = MobileBy.xpath("//*[contains(@resource-id, 'user_field')]//*[contains(@resource-id, 'select')]");

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
        return getText(labelAppointmentType);
    }

    public static String getLabelStartDateTime() {
        return getText(labelStartDateTime);
    }

    public static String getAppointmentType() {
        return find(appointmentType).getText();
    }

    public static String getLabelEndDateTime() {
        return getText(labelEndDateTime);
    }

    public static String getLabelLocation() {
        return getText(labelLocation);
    }

    public static String getUser() {
        return find(user).getText();
    }

    public static String getMotesalternativ() {
        return getValue(motesalternativ);
    }

    public static String getMotetCustomfalt() {
        return getValue(motetCustomfalt);
    }

    public static String getLabelUser() {
        return getText(labelUser);
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
