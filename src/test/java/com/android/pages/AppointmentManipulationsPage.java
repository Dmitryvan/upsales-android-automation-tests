package com.android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentManipulationsPage extends BasePage {

    private static String appointmentName;
    private static final String namePrefix = "app_";

    private static final By defaultLabelDescription = MobileBy.id("text_input");
    private static final By fieldDescription = MobileBy.xpath("//TextInputLayout[1]/android.widget.EditText[1]");
    private static final By listAppointmentType = MobileBy.id("text1");

    private static final By buttonAppointmentType = MobileBy.id("appointment_type_field");
    private static final By buttonAccount = MobileBy.id("account_field");
    private static final By buttonStarts = MobileBy.id("starts_field");
    private static final By buttonEnds = MobileBy.id("ends_field");
    private static final By buttonLocation = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4]");
    private static final By buttonContacts = MobileBy.id("contact_field");
    private static final By buttonOpportunity = MobileBy.id("opportunity_field");
    private static final By buttonUser = MobileBy.id("user_field");
    private static final By buttonCampaign = MobileBy.id("company_field");

    private static final List<WebElement> labels = findElements(MobileBy.id("name"));
    private static final WebElement labelAppointmentType = labels.get(0);
    private static final WebElement labelStartDateTime = labels.get(1);
    private static final WebElement labelEndDateTime = labels.get(2);
    private static final WebElement labelAccount = labels.get(3);
    private static final WebElement labelContact = labels.get(4);
    private static final WebElement labelOpportunity = labels.get(5);
    private static final WebElement labelUser = labels.get(6);
    private static final WebElement labelCampaign = labels.get(7);
    private static final WebElement labelNotes = labels.get(8);

    private static final List<WebElement> values = findElements(MobileBy.id("select"));
    private static final WebElement appointmentType = values.get(0);
    private static final WebElement startDate = values.get(1);
    private static final WebElement endDate = values.get(2);
    private static final WebElement account = values.get(3);
    private static final WebElement contact = values.get(4);
    private static final WebElement opportunity = values.get(5);
    private static final WebElement user = values.get(6);
    private static final WebElement campaign = values.get(7);

    private static final By pickerWheelAppointmentType = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].pickers()[0].wheels()");
    private static final By fieldNotes = MobileBy.id("notes");
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

    private static final By buttonInsertSignature = MobileBy.IosUIAutomation(".tableViews()[0].cells()[10].staticTexts()[1]");
    private static final By labelOtherInfo = MobileBy.xpath("//android.widget.RelativeLayout[7]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By startDateForAcc = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By endDateForAcc = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[1]");

    private static final By motesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11].staticTexts()[0]");
    private static final By labelMotesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11].staticTexts()[1]");
    private static final By pickerWheelMotesalternativ = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].pickers()[0].wheels()[0]");
    private static final By motetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].staticTexts()[0]");
    private static final By labelMotetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].staticTexts()[0]");
    private static final By fieldMotetCustomfalt = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].textViews()[0]");

    public static String getLabelOtherInfo() {
        return getText(labelOtherInfo);
    }

    public static String getStartDate() {
        return startDate.getText();
    }

    public static String getEndDateForAcc() {
        return getValue(endDateForAcc);
    }

    public static String getStartDateForAcc() {
        return getValue(startDateForAcc);
    }

    public static String getEndDate() {
        return endDate.getText();
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
        AndroidElement element = (AndroidElement) find(fieldDescription);
        element.click();
        element.clear();
        element.sendKeys(description);
        ((AppiumDriver) getDriver()).hideKeyboard();
    }

    public static String getDefaultLabelDescription() {
        return getText(defaultLabelDescription);
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
        return appointmentType.getText();
    }

    public static String getLabelEndDateTime() {
        return labelEndDateTime.getText();
    }

//    public static String getLabelLocation() {
//        return getValue(labelLocation);
//    }

    public static String getAccount() {
        return account.getText();
    }

    public static String getContact() {
        return contact.getText();
    }

    public static String getOpportunity() {
        return opportunity.getText();
    }

    public static String getUser() {
        return user.getText();
    }

    public static String getNotes() {
        return getValue(fieldNotes);
    }

    public static String getCampaign() {
        return campaign.getText();
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
        return labelNotes.getText();
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

    public static void closeAppointmentTypeList() {
        try {
            ((AndroidDriver) getDriver()).tap(1, 100, 100, 1);
        } catch (WebDriverException e) {}
    }

    public static void setAppointmentName() {
        appointmentName = generateName(namePrefix);
    }

    public static String getAppointmentName() {
        return appointmentName;
    }
}
