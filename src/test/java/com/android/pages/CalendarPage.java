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
    private static final By buttonCalendarView = MobileBy.id("calendar_radio_button");

    private static final By calendarView = MobileBy.id("calendar1");
    private static final By labelToday = MobileBy.xpath(
            "//*[@class='android.widget.TextView' and @text='" + todayDate + "']");

    private static final By visibleElements = MobileBy.id("dates");
    private static By monthOnCalendar = MobileBy.id("calendar_month_year_textview");
    private static By datesInCells = MobileBy.id("toTxt");
    private final static By tableCells = MobileBy.IosUIAutomation(".tableViews()[1].cells()");

    private static final DateFormat monthOnCalendarFormat = new SimpleDateFormat("MMMM YYYY");

    public static void clickListView() {
        find(buttonListView).click();
    }

    public static void clickCalendarView() {
        find(buttonCalendarView).click();
    }

    public static boolean checkTodayLabel() {
//        System.out.println(todayDate);
        return checkIsDisplayed(labelToday);
    }

    public static boolean checkCalendarView() {
        return checkIsDisplayed(calendarView);
    }

    public static boolean checkButtonCalendarView() {
        return checkIsDisplayed(buttonCalendarView);
    }

    public static int checkVisibleCellsCount() {
//        wait(labelToday);
        return getTableSize(visibleElements);
    }

    public static void swipeLeft() {
        swipeLeft(calendarView);
    }

    public static void swipeRight() {
        swipeRight(calendarView);
    }

    public static int getTodayAppointmentsCount() {
        List<WebElement> appointments = getDriver().findElements(datesInCells);
        int todayAppCount = 0;
        for(WebElement el : appointments) {
            if(el.getText().contains("Today"))
                todayAppCount++;
        }
        return todayAppCount;
    }

    public static String getMonthOnCalendar() {
        getDriver().getPageSource();
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

//    public static int getTodayAppoinmetsCountOnCalendarView() {
//        List<WebElement> appointments = getDriver().findElements(datesInCells);
//        int count = appointments.size();
//        if(count < 4)
//            return count;
//        String appName = getText(MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));
//        String accName = getText(MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[2]"));
//
//
//    }

    public static int getCellsCount() {
        int total;
        int iterator;
        List<WebElement> list = getDriver().findElements(MobileBy.id("descriptionTxt"));
//        for (WebElement aList : list) {
//            System.out.println(aList.getText());
//        }
        total = iterator = list.size();
        int lastValue = iterator;
        if(lastValue == 5) {
            ((AndroidElement)list.get(3)).swipe(SwipeElementDirection.UP, 500);
        }
        String previousActivity = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", lastValue, "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
        String previousAccount = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", lastValue, "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
        String activity;
        String account;
        int counter = 0;
        do {
            AndroidElement el = (AndroidElement) find(MobileBy.xpath(
                    "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[" +
                            (iterator - 1) + "]/android.widget.FrameLayout[1]"));
            el.swipe(SwipeElementDirection.UP, 500);
            waitByThread(500);
            try {
                try {
                    activity = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", (lastValue + 1), "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
                    account = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", (lastValue + 1), "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
                }
                catch (Exception e) {
                    activity = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", lastValue, "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
                    account = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[", lastValue, "]android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
                }
//                System.out.println(account);
                if (account.equals(previousAccount) && activity.equals(previousActivity)) {
                    counter ++;
                    continue;
                }
//                if (account.equals("app3")) {
//                    total++;
//                    break;
//                }
                total++;
//                System.out.println(total);
                previousAccount = account;
                previousActivity = activity;
            } catch (Exception e) {
                break;
            }
        } while (counter < 3);
//        System.out.println(iterator);
//        System.out.println(total);
        return total;
//        return getTableSize(tableCells);
    }

    public static void scrollToTheFirstRecord() {
        scrollToLabel((firstDateInTable));
    }
}
