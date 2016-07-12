package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CreateMenuPage extends BasePage {

    private static final By buttonActivity = MobileBy.id("activity");
    private static final By buttonAppointment = MobileBy.IosUIAutomation(
            ".popover().tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By buttonOpportunity = MobileBy.IosUIAutomation(
            ".popover().tableViews()[0].cells()[3].staticTexts()[1]");
    private static final By buttonOrder = MobileBy.IosUIAutomation(
            ".popover().tableViews()[0].cells()[4].staticTexts()[1]");
    private static final By buttonContact = MobileBy.IosUIAutomation(
            ".popover().tableViews()[0].cells()[5].staticTexts()[1]");
    private static final By buttonAccount = MobileBy.IosUIAutomation(
            ".popover().tableViews()[0].cells()[6].staticTexts()[1]");
    private static final By labelHeader = MobileBy.IosUIAutomation(
            ".popover().tableViews()[0].cells()[0].staticTexts()[0]");

    public static String getLabelHeader() {
        return find(labelHeader).getText();
    }

    public static String getLabelActivity() {
        return find(buttonActivity).getText();
    }

    public static String getLabelAppointment() {
        return find(buttonAppointment).getText();
    }

    public static String getLabelOpportunity() {
        return find(buttonOpportunity).getText();
    }

    public static String getLabelOrder() {
        return find(buttonOrder).getText();
    }

    public static String getLabelAccount() {
        return find(buttonAccount).getText();
    }

    public static String getLabelContact() {
        return find(buttonContact).getText();
    }

    public static void clickActivity() {
//        ((AndroidDriver)getDriver()).tap(1, 500, 860, 1);
        find(buttonActivity).click();
    }

    public static void clickAppointment() {
        find(buttonAppointment).click();
    }

    public static void clickOpportunity() {
        find(buttonOpportunity).click();
    }

    public static void clickOrder() {
        find(buttonOrder).click();
    }

    public static void clickContact() {
        ((AndroidDriver)getDriver()).tap(1, 168, 1380, 1);
//        find(buttonContact).click();
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }
}
