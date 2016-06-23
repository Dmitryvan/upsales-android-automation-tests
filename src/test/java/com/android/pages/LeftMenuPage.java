package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LeftMenuPage extends BasePage {

    private static final By buttonDashboard = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Dashboard'\")");
    //    firstWithPredicate("staticTexts[0].label
    private static final By buttonCalendar = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Calendar'\")");
    private static final By buttonActivities = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Activities'\")");
    private static final By buttonSales = MobileBy.xpath(
            "//*[@class='android.widget.TextView' and @text='Sales']");
    private static final By buttonPipeline = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Pipeline'\")");
    private static final By buttonAccAndCon = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Accounts & Contacts'\")");
    private static final By buttonForms = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Forms'\")");
    private static final By buttonGroupMail = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Group mail'\")");
    private static final By buttonCreate = MobileBy.IosUIAutomation(".buttons()[0]");
    private static final By buttonSettings = MobileBy.IosUIAutomation(".buttons()[1]");

    private static final By buttonSignOut = MobileBy.id("sign_out");
    private static final By fieldSearch = MobileBy.id("search_backgraund");

    private static final By hiddenPageTitle = MobileBy.IosUIAutomation(".navigationBars()[1].staticTexts()[0]");

    public static boolean checkSearch() {
        try {
            return find(fieldSearch).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static String getHiddenPageTitle() {
        return getValue(hiddenPageTitle);
    }

    public static void clickSettings() {
        find(buttonSettings).click();
    }

    public static void clickSignOut() {
        find(buttonSignOut).click();
    }

    public static void clickDashboard() {
        find(buttonDashboard).click();
    }

    public static void clickSearch() {
        find(fieldSearch).click();
    }

    public static void clickCalendar() {
        find(buttonCalendar).click();
    }

    public static void clickActivities() {
        find(buttonActivities).click();
    }

    public static void clickSales() {
        wait(fieldSearch);
        find(buttonSales).click();
    }

    public static void clickPipeline() {
        find(buttonPipeline).click();
    }

    public static void clickAccAndCon() {
        find(buttonAccAndCon).click();
    }
    public static void clickForms() {
        find(buttonForms).click();
    }

    public static void clickGroupMail() {
        find(buttonGroupMail).click();
    }

//    public static void clickAlertCancel() {
////        if(Helpers.getPlatformVersion() == 8)
////            getDriver().switchTo().alert().accept();
////        else
////            getDriver().switchTo().alert().dismiss();
//    }

    public static void clickCreate() {
        find(buttonCreate).click();
    }
}