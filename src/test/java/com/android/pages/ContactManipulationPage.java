package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class ContactManipulationPage extends BasePage {

    private static String contactName;
    private static final String contactNamePrefix = "con_";

    private static final By labelContactInformation = MobileBy.xpath("//android.widget.RelativeLayout[2]//android.widget.TextView[1]");

    private static final By fieldTitle = MobileBy.xpath("//android.widget.RelativeLayout[2]//android.widget.EditText[1]");
    private static final By fieldPhone = MobileBy.id("phone");
    private static final By fieldMobile = MobileBy.id("mobile");
    private static final By fieldEmail = MobileBy.id("email");

    public static final By fieldExtraID = MobileBy.xpath("//*[@text='extra ID']/..//*[contains(@resource-id, 'edit_field')]");
    public static final By fieldChanceOfSuccess = MobileBy.xpath("//*[@text='Chance of success']/..//*[contains(@resource-id, 'edit_field')]");

    private static final By buttonNoThanks = MobileBy.id("no_thanks");
    private static final By buttonActivity = MobileBy.id("activity");
    private static final By buttonAppointment = MobileBy.id("appointment");
    private static final By buttonOpportunity = MobileBy.id("opportunity");

    public static void clickNoThanks() {
        wait(buttonNoThanks);
        waitToBeClickable(buttonNoThanks);
        find(buttonNoThanks).click();
        waitByThread(2000);
    }

    public static void clickActivity() {
        find(buttonActivity).click();
        waitByThread(2000);
    }

    public static void clickAppointment() {
        find(buttonAppointment).click();
    }

    public static void clickOpportunity() {
        wait(buttonOpportunity);
        find(buttonOpportunity).click();
    }

    public static String getDefaultLabelTitle() {
        return getText(fieldTitle);
    }

    public static void enterTitle(String title) {
        AndroidElement element = (AndroidElement) find(fieldTitle);
        clearField(element);
        element.sendKeys(title);
        hideKeyboard();
    }

    public static String getLabelContactInformation() {
        return getText(labelContactInformation);
    }

    public static void enterPhone(String phone) {
        sendValues(phone, fieldPhone);
        hideKeyboard();
    }

    public static void enterMobile(String mobile) {
        sendValues(mobile, fieldMobile);
        hideKeyboard();
    }

    public static void enterEmail(String email) {
        sendValues(email, fieldEmail);
        hideKeyboard();
    }

    public static void setContactName() {
        contactName = generateName(contactNamePrefix);
    }

    public static String getContactName() {
        return contactName;
    }

    public static void clickExtraID() {
        getDriver().getPageSource();
        find(fieldExtraID).click();
    }

    public static void enterExtraID(String id) {
        sendValues(id, fieldExtraID);
        hideKeyboard();
    }

    public static void clearExtraID() {
        find(fieldExtraID).clear();
    }

    public static void clickChanceOfSuccess() {
        getDriver().getPageSource();
        find(fieldChanceOfSuccess).click();
    }

    public static void enterChanceOfSuccess(String value) {
        sendValues(value, fieldChanceOfSuccess);
    }

    public static void clearChanceOfSuccess() {
        find(fieldChanceOfSuccess).clear();
    }

    public static void enterContactName(String contactName) {
        enterDescription(contactName);
        hideKeyboard();
    }

    public static void typeIntoNotes(String note) {
        clearAndType(note, fieldNotes);
    }

    private static final By fieldNotes = MobileBy.id("notes");

}
