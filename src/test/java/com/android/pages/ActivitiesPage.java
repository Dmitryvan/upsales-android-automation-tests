package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ActivitiesPage extends BasePage {

    private final static By tableEmptyList = MobileBy.IosUIAutomation(".tableViews()[\"Empty list\"]");
    private final static By rowFirstActivity = MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]");
    private final static By tableActivity = MobileBy.IosUIAutomation(".tableViews()[0]");
    private final static By tableActivityCells = MobileBy.IosUIAutomation(".tableViews()[0].cells()");
    private final static By firstRowDate = MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private final static By lastRowDate = MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[11]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");

    private static final DateFormat activityDate = new SimpleDateFormat("d MMM");
    private static final String elementPathStart = "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[";
    private static final String activityNamePathEnd = "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]";
    private static final String accountNamePathEnd = "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]";

    public static String getFirstRowDate() {
        return getText(firstRowDate);
    }

    public static String getLastRowDate() {
        return getText(lastRowDate);
    }

    public static void clickFirstActivity() {
        find(rowFirstActivity).click();
    }

    public static boolean isTableEmpty() {
        return (find(tableActivity).getAttribute("name").equals("Empty list"));
    }

    public static boolean checkTableContainsOnly(String activity) {
        for(int i = 0; i < getTableSize(tableActivityCells); i++) {
            String activityName = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[1]")).getAttribute("value");
//            System.out.println(activityName);
//            byte[] bbb = activityName.getBytes("UTF-8");
//            for(byte bbbb : bbb)
//                System.out.print(bbbb + " ");
//            System.out.println();
            if(!activityName.contains(activity)) {
//                System.out.println(true);
                return false;
            }
        }
        return true;
    }

    public static boolean searchActivity(String activity, String date) {
        for(int i = 0; i < getTableSize(tableActivityCells); i++) {
            String activityName = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[0]")).getAttribute("value");
            String dateValue = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[2]")).getAttribute("value");
            if(activityName.equals(activity) && dateValue.equals(date)) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchActivity(String activity, String date, String time) {
        for(int i = 0; i < getTableSize(tableActivityCells); i++) {
            String activityName = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[0]")).getAttribute("value");
//            System.out.print(activityName + " ");
            String timeValue = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[2]")).getAttribute("value");
//            System.out.print(timeValue + " ");
            if(timeValue.equals(time) && activityName.equals(activity)) {
                try {
                    String dateValue = find(MobileBy.IosUIAutomation(
                             ".tableViews()[0].cells()[" + i + "].staticTexts()[3]")).getAttribute("value");
//                    System.out.println(dateValue);
                    if (dateValue.equals(date))
                    return true;
                } catch (NoSuchElementException e) {
                    continue;
                }
            }
        }
        return false;
    }

    public static boolean searchActivityByName(String activity) {
        int counter = 0;
        int lastValue;
        int cellHeight;
        int windowHeight = getDriver().manage().window().getSize().getWidth();
        String activityName;
        String accountName;

        List<WebElement> list = getDriver().findElements(MobileBy.id("description"));
        for (WebElement aList : list) {
            if(aList.getText().equals(activity))
                return true;
        }
        lastValue = list.size();

        String previousActivity = getTextByPath(elementPathStart, lastValue, activityNamePathEnd);
        String previousAccount = getTextByPath(elementPathStart, lastValue, accountNamePathEnd);

        AndroidElement el = (AndroidElement) find(MobileBy.id("activity_item"));
        cellHeight = el.getSize().height + 2;
        do {
            ((MobileDriver)getDriver()).swipe(0, windowHeight, 0, windowHeight - cellHeight, 500);
            try{ Thread.sleep(500); } catch (Exception e) {}
            try {
                try {
                    activityName = getTextByPath(elementPathStart, (lastValue + 1), activityNamePathEnd);
                    accountName = getTextByPath(elementPathStart, (lastValue + 1), accountNamePathEnd);
                }
                catch (Exception e) {
                    activityName = getTextByPath(elementPathStart, lastValue, activityNamePathEnd);
                    accountName = getTextByPath(elementPathStart, lastValue, accountNamePathEnd);
                }
                if (activityName.equals(previousActivity) && accountName.equals(previousAccount)) {
                    counter++;
                    continue;
                } else {
                    counter = 0;
                }
                if (activityName.equals(activity)) {
                    return true;
                }
                previousActivity = activityName;
                previousAccount = accountName;
            } catch (Exception e) {
                break;
            }
        } while (counter < 2);
        return false;
    }

    public static void selectActivity(String activity) {
//        ((IOSDriver)getDriver()).scrollTo(activity);
        try {
            find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[0].name=='" + activity + "'\")")).click();
        } catch (NoSuchElementException e) {
            find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[2].name=='" + activity + "'\")")).click();
        }
    }

//    public static boolean countActivities(String num) {
//        if (getTableSize(tableActivityCells) <= Integer.parseInt(num)) {
//            return true;
//        }
//        return false;
//    }

    public static int countActivities() {
        int total;
        int lastValue;
        int cellHeight;
        int windowHeight = getDriver().manage().window().getSize().getWidth();

        List<WebElement> list = getDriver().findElements(MobileBy.id("name"));
//        for (WebElement aList : list) {
//            System.out.println(aList.getText());
//        }
        total = lastValue = list.size();
        String previousAccount = getTextByPath(elementPathStart, lastValue, accountNamePathEnd);
        String account;
        AndroidElement el = (AndroidElement) find(MobileBy.id("activity_item"));
//                    "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[" +
//                            (iterator - 1) + "]/android.widget.FrameLayout[1]" +
//                            "/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]"));
        cellHeight = el.getSize().height + 2;
//        System.out.println(cellHeight);
//        System.out.println(windowHeight);
        do {
            ((MobileDriver)getDriver()).swipe(0, windowHeight, 0, windowHeight - cellHeight, 500);
            try{ Thread.sleep(500); } catch (Exception e) {}
            try {
                account = getTextByPath(elementPathStart, lastValue, accountNamePathEnd);
                if(account.equals(previousAccount)) {
                    try {
                        account = getTextByPath(elementPathStart, (lastValue + 1), accountNamePathEnd);
                    } catch (Exception e) { }
                }
//                System.out.println(account);
                if (account.equals(previousAccount)) {
                    continue;
                }
                total++;
//                System.out.println(total);
                previousAccount = account;
            } catch (Exception e) {
                break;
            }
        } while (!account.equals("H & M Hennes & Mauritz Sverige AB"));
//        System.out.println(iterator);
//        System.out.println(total);
        return total;
    }

    public static int countActivitiesByDate(String date) {
        int count = 0;
        for(int i = 0; i < getTableSize(tableActivityCells); i++) {
            try {
                String dateValue = find(MobileBy.IosUIAutomation(
                        ".tableViews()[0].cells()[" + i + "].staticTexts()[3]")).getAttribute("value");
                if (dateValue.equals(date))
                    count++;
            } catch (NoSuchElementException e) {
                String dateValue = find(MobileBy.IosUIAutomation(
                        ".tableViews()[0].cells()[" + i + "].staticTexts()[2]")).getAttribute("value");
                if (dateValue.equals(date))
                    count++;
            }
        }
        return count;
    }

    public static String dateYesterday() {
        Calendar calendar = getCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, - 1);
        return activityDate.format(calendar.getTime());
    }
}
