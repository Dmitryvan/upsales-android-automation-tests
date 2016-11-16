package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountManipulationsPage extends BasePage {

    private static String accountName;
    private static final String namePrefix = "acc_";

    private static final By buttonNext = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[2]");
    private static final By fieldSearchAccountName = MobileBy.IosUIAutomation(".textFields()[0]");

    private static final By fieldAccountName = MobileBy.xpath("//*[contains(@resource-id, 'contact_name_field')]//*[contains(@resource-id, 'edit')]");
    private static final By buttonParentAccount = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]");
    private static final By fieldParentAccount = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By buttonAccountManagers = MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]");
    private static final By fieldPhone = MobileBy.id("phone");
    private static final By fieldWebsite = MobileBy.id("website");
    private static final By buttonPostal = MobileBy.xpath("//android.support.v7.app.ActionBar.Tab[1]/android.widget.TextView[1]");
    private static final By buttonVisit = MobileBy.xpath("//android.support.v7.app.ActionBar.Tab[2]/android.widget.TextView[1]");
    private static final By buttonBilling = MobileBy.xpath("//android.support.v7.app.ActionBar.Tab[3]/android.widget.TextView[1]");
    private static final By buttonDelivery = MobileBy.xpath("//android.support.v7.app.ActionBar.Tab[4]/android.widget.TextView[1]");
    private static final By buttonOther = MobileBy.xpath("//android.support.v7.app.ActionBar.Tab[5]/android.widget.TextView[1]");
    private static final By fieldStreet = MobileBy.id("street");
    private static final By fieldZipcode = MobileBy.id("zipcode");
    private static final By fieldCity = MobileBy.id("city");
    private static final By fieldCountry = MobileBy.id("country");
    private static final By wheelCountry = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].pickers()[0].wheels()[0]");
    private static final By buttonInsertSignature = MobileBy.id("insert");

    private static final By labelAccountName = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By labelAccountManagers = MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By labelAccountManagersValue = MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By labelContactInformation = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By labelPhone = MobileBy.id("phone_container");
    private static final By labelWebsite = MobileBy.id("text_input_website");
    private static final By labelAddress = MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By labelStreet = MobileBy.xpath("//*[contains(@resource-id, 'street')]/../..");
    private static final By labelZipcode = MobileBy.xpath("//*[contains(@resource-id, 'zipcode')]/../..");
    private static final By labelCity = MobileBy.xpath("//*[contains(@resource-id, 'city')]/../..");
    private static final By labelCountry = MobileBy.xpath("//*[contains(@resource-id, 'country')]/../..");

    private static final By popupLabelAccountName = MobileBy.IosUIAutomation(".staticTexts()[1]");
    private static final By popupLabelSuccessCreated = MobileBy.IosUIAutomation(".staticTexts()[2]");
    private static final By popupLabelAddInfo = MobileBy.IosUIAutomation(".staticTexts()[3]");
    private static final By popupButtonContact = MobileBy.id("contact");
    private static final By popupButtonActivity = MobileBy.id("activity");
    private static final By popupButtonAppointment = MobileBy.id("appointment");
    private static final By popupButtonOpportunity = MobileBy.id("opportunity");
    private static final By popupButtonNoThanx = MobileBy.id("no_thanks");

    public static void enterSearchAccountName (String accountName) {
        wait(fieldSearchAccountName);
        WebElement accName = find(fieldSearchAccountName);
        accName.click();
        accName.clear();
        accName.sendKeys(accountName);
    }

    public static void enterAccountName (String accountName) {
        clearAndType(accountName, fieldAccountName);
    }

    public static void scrollToTheTop() {
        scrollToLabel("Account name");
    }

    public static void enterPhone (String phone) {
        clearAndType(phone, fieldPhone);
    }

    public static void enterWebsite (String website) {
        clearAndType(website, fieldWebsite);
    }

    public static void enterStreet (String street) {
        clearAndType(street, fieldStreet);
    }

    public static void enterZipcode (String zipcode) {
        clearAndType(zipcode, fieldZipcode);
    }

    public static void enterCity (String city) {
        clearAndType(city, fieldCity);
    }

    public static void enterCountry (String country) {
        clearAndType(country, fieldCountry);
    }

    public static String getAccountNameLabelValue() {
        return getText(labelAccountName);
    }

    public static String getAccountNameValue() {
        return getText(fieldAccountName);
    }

    public static String getParentAccountValue() {
        return getText(fieldParentAccount);
    }

    public static String getAccountManagersLabelValue() {
        return getText(labelAccountManagers);
    }

    public static String getAccountManagersValue() {
        return getText(labelAccountManagersValue);
    }

    public static String getContactInformationLabelValue() {
        return getText(labelContactInformation);
    }

    public static String getPhoneFieldDefaultValue() {
        return getText(labelPhone);
    }

    public static String getWebsiteFieldDefaultValue() {
        return getText(labelWebsite);
    }

    public static String getPhoneFieldValue() {
        return getText(fieldPhone);
    }

    public static String getWebsiteFieldValue() {
        return getText(fieldWebsite);
    }

    public static String getAddressLabelValue() {
        getDriver().getPageSource();
        return getText(labelAddress);
    }

    public static String getPostalTabValue() {
        return getText(buttonPostal);
    }

    public static String getVisitTabValue() {
        return getText(buttonVisit);
    }

    public static String getBillingTabValue() {
        return getText(buttonBilling);
    }

    public static String getDeliveryTabValue() {
        return getText(buttonDelivery);
    }

    public static String getOtherTabValue() {
        return getText(buttonOther);
    }

    public static String getStreetLabelValue() {
        return getText(labelStreet);
    }

    public static String getZipcodeLabelValue() {
        return getText(labelZipcode);
    }

    public static String getCityLabelValue() {
        return getText(labelCity);
    }

    public static String getCountryLabelValue() {
        return getText(labelCountry);
    }

    public static String getStreetFieldValue() {
        return getText(fieldStreet);
    }

    public static String getZipcodeFieldValue() {
        return getText(fieldZipcode);
    }

    public static String getCityFieldValue() {
        return getText(fieldCity);
    }

    public static String getCountryFieldValue() {
        return getText(fieldCountry);
    }

    public static String getInsertSignatureValue() {
        return getText(buttonInsertSignature);
    }

    public static String getPopupAccountNameValue() {
        return getText(popupLabelAccountName);
    }

    public static String getPopupSuccesCreatedValue() {
        return getText(popupLabelSuccessCreated);
    }

    public static String getPopupAddInfoValue() {
        return getText(popupLabelAddInfo);
    }

    public static String getContactValue() {
        return getName(popupButtonContact);
    }

    public static String getActivityValue() {
        return getName(popupButtonActivity);
    }

    public static String getAppointmentValue() {
        return getName(popupButtonAppointment);
    }

    public static String getOpportunityValue() {
        return getName(popupButtonOpportunity);
    }

    public static String getNoThanxValue() {
        return getName(popupButtonNoThanx);
    }

    public static void clickNext() {
        find(buttonNext).click();
        wait(buttonNext);
    }

    public static void clickParentAccount() {
        find(buttonParentAccount).click();
    }

    public static void clickAccountManagers() {
        find(buttonAccountManagers).click();
    }

    public static void clickPostal() {
        find(buttonPostal).click();
    }

    public static void clickVisit() {
        find(buttonVisit).click();
    }

    public static void clickBilling() {
        find(buttonBilling).click();
    }

    public static void clickDelivery() {
        find(buttonDelivery).click();
    }

    public static void clickOther() {
        find(buttonOther).click();
    }

    public static void clickInsertSignature() {
        find(buttonInsertSignature).click();
    }

    public static void clickPopUpActivity() {
        find(popupButtonActivity).click();
    }

    public static void clickPopUpAppointment() {
        find(popupButtonAppointment).click();
    }

    public static void clickPopUpOpportunity() {
        find(popupButtonOpportunity).click();
    }

    public static void clickPopUpContact() {
        find(popupButtonContact).click();
    }

    public static void clickPopUpNoThanx() {
        find(popupButtonNoThanx).click();
    }

    public static boolean checkSaveButton() {
        return find(buttonSave).isDisplayed();
    }

    public static boolean checkCancelButton() {
        return find(buttonCancel).isDisplayed();
    }

    public static void setAccountName() {
        accountName = generateName(namePrefix);
    }

    public static String getAccountName() {
        return accountName;
    }
}
