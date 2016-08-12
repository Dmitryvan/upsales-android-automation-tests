package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ActivityPage extends BasePage {

    private static final By buttonLeftMenu = MobileBy.className("android.widget.ImageButton");

    private static final By buttonAccount = MobileBy.id("account_name");
    private static final By userValue = MobileBy.id("user_name");
    private static final By dateValue = MobileBy.id("date");
    private static final By timeValue = MobileBy.id("time");
    private static final By fieldNotesValue = MobileBy.id("notes");
    private static final By buttonContact = MobileBy.id("contact_root");

    private static final By popoverLabelEditActivity = MobileBy.xpath("//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']");

    private static final By popoverEditActivity = MobileBy.id("item_edit");
    private static final By popoverFollowUpActivity = MobileBy.id("item_follow");

    private static final By labelShowMore = MobileBy.IosUIAutomation(".scrollViews()[0].tableViews()[0].cells()[5]");

    private static final By fieldExpanses = MobileBy.xpath("//android.widget.RelativeLayout[@index='8']//android.widget.EditText[@index='0']");

    public static String getExpenses() {
        return getText(fieldExpanses);
    }

    public static void clickShowMore() {
        find(labelShowMore).click();
    }

    public static void clickLeftMenu() {
        find(buttonLeftMenu).click();
    }

    public static void clickFollowUpActivity() {
        find(popoverFollowUpActivity).click();
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickDateTime() {
        find(dateValue).click();
    }

    public static void clickEditActivity() {
        waitByThread(500);
        find(popoverEditActivity).click();
    }

    public static String getAccountName() {
        return getText(buttonAccount);
    }

    public static String getContact() {
        List<WebElement> users = findElements(MobileBy.id("user_title"));
        return users.get(1).getText();
    }

    public static String getUserName() {
        return getText(userValue);
    }

    public static String getDate() {
        return getText(dateValue);
    }

    public static String getTime() {
        return getText(timeValue);
    }

    public static String getNotes() {
        return getText(fieldNotesValue);
    }

    public static String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("EEEE d MMM YYYY");
        Date date = new Date();
        return df.format(date);
    }

    public static boolean getNotesStartsWith(String start) {
        return getText(fieldNotesValue).startsWith(start);
    }

    public static String getTextEditActivity() {
        return getText(popoverLabelEditActivity);
    }

    public static boolean checkThereIsNoContact() {
        return checkIsDisplayed(buttonContact);
    }
}

