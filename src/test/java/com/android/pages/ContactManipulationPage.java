package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactManipulationPage extends BasePage {

    private static String contactName;
    private static final String contactNamePrefix = "con_";

    private static final By defaultLabelContactName = MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/TextInputLayout[1]/android.widget.EditText[1]");
    private static final By defaultLabelTitle = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/TextInputLayout[1]/android.widget.EditText[1]");
    private static final By buttonCampaigns = MobileBy.id("company_field");
    private static final By buttonCategories = MobileBy.id("category_field");
    private static final By labelOtherInfo = MobileBy.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By buttonWorksAt = MobileBy.id("account_field");
    private static final By labelContactInformation = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");

    private static final By labels = MobileBy.id("name");
    private static final By values = MobileBy.id("select");

    private static final By fieldContactName = MobileBy.xpath("//TextInputLayout[1]/android.widget.EditText[1]");
    private static final By fieldTitle = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/TextInputLayout[1]/android.widget.EditText[1]");
    private static final By fieldPhone = MobileBy.id("phone");
    private static final By fieldMobile = MobileBy.id("mobile");
    private static final By fieldEmail = MobileBy.id("email");
    private static final By fieldNotes = MobileBy.id("notes");
    public static final By extraID = MobileBy.IosUIAutomation(".tableViews()[0].cells()[19]");
    public static final By fieldExtraID = MobileBy.IosUIAutomation(".tableViews()[0].cells()[19].textFields()[0]");
    public static final By chanceOfSuccess = MobileBy.IosUIAutomation(".tableViews()[0].cells()[10]");

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

    public static void enterContactName(String name) {
        AndroidElement element = (AndroidElement) find(fieldContactName);
        element.click();
        element.clear();
        element.sendKeys(name);
        hideKeyboard();
    }

    public static String getDefaultLabelContactName() {
        return getText(defaultLabelContactName);
    }

    public static String getDefaultLabelTitle() {
        return getText(defaultLabelTitle);
    }

    public static void enterTitle(String title) {
        AndroidElement element = (AndroidElement) find(fieldTitle);
        element.click();
        element.clear();
        element.sendKeys(title);
        hideKeyboard();
    }

    public static String getLabelWorksAt() {
        return findElements(labels).get(0).getText();
    }

    public static String getWorksAt() {
        return findElements(values).get(0).getText();
    }

    public static void clickWorksAt() {
        find(buttonWorksAt).click();
    }

    public static String getLabelContactInformation() {
        return getText(labelContactInformation);
    }

    public static void clickCampaigns() {
        find(buttonCampaigns).click();
    }

    public static void clickCategories() {
        find(buttonCategories).click();
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

    public static String getLabelCampaigns() {
        return findElements(labels).get(1).getText();
    }

    public static String getCampaigns() {
        return findElements(values).get(1).getText();
    }

    public static String getLabelCategories() {
        return findElements(labels).get(2).getText();
    }

    public static String getCategories() {
        return findElements(values).get(2).getText();
    }

    public static String getLabelNotes() {
        return findElements(labels).get(3).getText();
    }

    public static void typeIntoNotes(String note) {
        find(fieldNotes).clear();
        find(fieldNotes).sendKeys(note);
    }

    public static String getLabelOtherInfo() {
        return getText(labelOtherInfo);
    }

    public static void setContactName() {
        contactName = generateName(contactNamePrefix);
    }

    public static String getContactName() {
        return contactName;
    }

    public static void clickExtraID() {
        find(extraID).click();
    }

//    public static void enterExtraID(String id) {
//        setValues(id, fieldExtraID);
//        clickDoneOnKeyboard();
//    }

    public static void clickChanceOfSuccess() {
        find(chanceOfSuccess).click();
    }

}
