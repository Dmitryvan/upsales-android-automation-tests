package com.android.pages;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class CalendarPage extends BasePage {

    private static final By buttonListView = MobileBy.IosUIAutomation(".navigationBar().buttons()[2]");
    private static final By buttonCalendarView = MobileBy.IosUIAutomation(".navigationBar().buttons()[3]");

    public static void clickListView() {
        find(buttonListView).click();
    }

    public static void clickCalendarView() {
        find(buttonCalendarView).click();
    }

    public static boolean isCalendarView() {
        return find(buttonCalendarView).isDisplayed();
    }
}
