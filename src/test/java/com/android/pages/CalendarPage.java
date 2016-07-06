package com.android.pages;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CalendarPage extends BasePage {

    private static final String todayDate = calendarTodayDate();
    private static final String firstDateInTable = "Wednesday 30 Sep 2015";

    private static final By buttonListView = MobileBy.id("list");
    private static final By buttonCalendarView = MobileBy.id("calendar");

    private static final By calendarView = MobileBy.id("calendar1");
    private static final By labelToday = MobileBy.xpath(
            "//*[@class='android.widget.TextView' and @text='" + todayDate + "']");

    private static final By visibleElements = MobileBy.id("dates");
    private static By monthOnCalendar = MobileBy.id("calendar_month_year_textview");
    private final static By tableCells = MobileBy.IosUIAutomation(".tableViews()[1].cells()");

    private static final DateFormat monthOnCalendarFormat = new SimpleDateFormat("MMMM YYYY");

    public static void clickListView() {
        find(buttonListView).click();
    }

    public static void clickCalendarView() {
        find(buttonCalendarView).click();
    }

    public static boolean checkTodayLabel() {
        System.out.println(todayDate);
        return checkIsVisible(labelToday);
    }

    public static boolean checkCalendarView() {
        return checkIsVisible(calendarView);
    }

    public static int checkVisibleCellsCount() {
//        wait(labelToday);
        return getTableSize(visibleElements);
    }

    private static boolean checkIsVisible(By item) {
        try {
            find(item);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void swipeLeft() {
        swipeLeft(calendarView);
    }

    public static void swipeRight() {
        swipeRight(calendarView);
    }

    public static String getMonthOnCalendar() throws InterruptedException {
        Thread.sleep(1500);
        return find(monthOnCalendar).getText();
    }

    public static String getPreviousMonth() {
        Calendar calendar = getCalendar();
        calendar.add(Calendar.MONTH, - 1);
        return monthOnCalendarFormat.format(calendar.getTime());
    }

    public static String getNextMonth() {
        Calendar calendar = getCalendar();
        calendar.add(Calendar.MONTH, + 1);
        return monthOnCalendarFormat.format(calendar.getTime());
    }

    public static int getCellsCount() throws InterruptedException {
        int total;
        int iterator;
        List<WebElement> list = getDriver().findElements(MobileBy.id("descriptionTxt"));
//        for (WebElement aList : list) {
//            System.out.println(aList.getText());
//        }
        total = iterator = list.size();
        int lastValue = iterator;
        String previousCampaign = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", lastValue, "]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
        String account;
        do {
            AndroidElement el = (AndroidElement) find(MobileBy.xpath(
                    "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[" +
                            (iterator - 1) + "]/android.widget.RelativeLayout[1]"));
            el.swipe(SwipeElementDirection.UP, 500);
            Thread.sleep(500);
            try {
                try {
                    account = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", (lastValue + 1), "]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
                }
                catch (Exception e) {
                    account = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", lastValue, "]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
                }
//                System.out.println(account);
                if (account.equals(previousCampaign)) {
                    continue;
                }
//                if (account.equals("app3")) {
//                    total++;
//                    break;
//                }
                total++;
//                System.out.println(total);
                previousCampaign = account;
            } catch (Exception e) {
                break;
            }
        } while (!account.equals("app3"));
//        System.out.println(iterator);
//        System.out.println(total);
        return total;
//        return getTableSize(tableCells);
    }

    public static void scrollToTheFirstRecord() {
        ((MobileDriver)getDriver()).scrollTo((firstDateInTable));
    }
}
