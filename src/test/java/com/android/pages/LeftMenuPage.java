package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LeftMenuPage extends BasePage {

    private static final By buttonDashboard = MobileBy.id("dashboard");
    private static final By buttonCalendar = MobileBy.id("calendar");
    private static final By buttonActivities = MobileBy.id("activities");
    private static final By buttonSales = MobileBy.id("sales");
    private static final By buttonPipeline = MobileBy.id("pipeline");
    private static final By buttonAccAndCon = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Accounts & Contacts'\")");
    private static final By buttonForms = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Forms'\")");
    private static final By buttonGroupMail = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].name=='Group mail'\")");
    private static final By buttonCreate = MobileBy.id("create");
    private static final By buttonSettings = MobileBy.IosUIAutomation(".buttons()[1]");

    private static final By buttonSignOut = MobileBy.id("sign_out");
    private static final By fieldSearch = MobileBy.id("search_backgraund");

    private static final By hiddenPageTitle = MobileBy.id("title");

    public static boolean checkSearch() {
        try {
            return find(fieldSearch).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static String getHiddenPageTitle() {
        return getText(hiddenPageTitle);
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

    public static void clickCreate() throws InterruptedException {
        find(buttonCreate).click();
        Thread.sleep(200);
    }
}