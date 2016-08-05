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

    public static final By fieldExtraID = MobileBy.xpath("//android.widget.RelativeLayout[7]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]");
    public static final By fieldChanceOfSuccess = MobileBy.xpath("//android.widget.RelativeLayout[8]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]");

    private static final By buttonNoThanks = MobileBy.id("no_thanks");
    private static final By buttonActivity = MobileBy.id("activity");
    private static final By buttonAppointment = MobileBy.id("appointment");
    private static final By buttonOpportunity = MobileBy.id("opportunity");

    public static void clickNoThanks() {
        find(buttonNoThanks).click();
    }

    public static void clickActivity() {
        find(buttonActivity).click();
        waitByThread(2000);
    }

    public static void clickAppointment() {
        find(buttonAppointment).click();
    }

    public static void clickOpportunity() {
        find(buttonOpportunity).click();
    }

    public static String getDefaultLabelTitle() {
        return getText(fieldTitle);
    }

    public static void enterTitle(String title) {
        AndroidElement element = (AndroidElement) find(fieldTitle);
        element.click();
        element.clear();
        element.sendKeys(title);
        hideKeyboard();
    }

    public static String getLabelContactInformation() {
        return getText(labelContactInformation);
    }

    public static void enterPhone(String phone) {
        sendValues(phone, fieldPhone);
    }

    public static void enterMobile(String mobile) {
        sendValues(mobile, fieldMobile);
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
    }

    public static void typeIntoNotes(String note) {
        find(fieldNotes).clear();
        find(fieldNotes).sendKeys(note);
    }

    private static final By fieldNotes = MobileBy.id("notes");

}
