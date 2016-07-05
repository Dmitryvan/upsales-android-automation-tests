package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ActivitiesPage extends BasePage {

    private final static By buttonFilter = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[2]");
    private final static By tableEmptyList = MobileBy.IosUIAutomation(".tableViews()[\"Empty list\"]");
    private final static By rowFirstActivity = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0]");
    private final static By tableActivity = MobileBy.IosUIAutomation(".tableViews()[0]");
    private final static By tableActivityCells = MobileBy.IosUIAutomation(".tableViews()[0].cells()");
    private final static By firstRowDate = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0].staticTexts()[2]");
    private final static By lastRowDate = MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[11]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");

    private static final DateFormat activityDate = new SimpleDateFormat("d MMM");

    public static String getFirstRowDate() {
        return getValue(firstRowDate);
    }

    public static String getLastRowDate() {
        return getText(lastRowDate);
    }

    public static void clickFilter() {
        wait(buttonFilter);
        find(buttonFilter).click();
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
        try {
            find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[0].name=='" + activity + "'\")"));
            return true;
        } catch (NoSuchElementException e) {
            try {
                find(MobileBy.IosUIAutomation(
                        ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[2].name=='" + activity + "'\")"));
                return true;
            } catch (NoSuchElementException ex) {
                return false;
            }
        }
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

    public static int countActivities() throws InterruptedException {
        int total;
        int iterator;
        List<WebElement> list = getDriver().findElements(MobileBy.id("name"));
        for (WebElement aList : list) {
            System.out.println(aList.getText());
        }
        total = iterator = list.size();
        int lastValue = iterator;
        String previousCampaign = find(MobileBy.xpath(
                "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[" +
                        lastValue +
                        "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]" +
                        "/android.widget.LinearLayout[2]/android.widget.TextView[2]")).getText();
        String account;
        do {
            AndroidElement el = (AndroidElement) find(MobileBy.id("activity_item"));
//                    "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[" +
//                            (iterator - 1) + "]/android.widget.FrameLayout[1]" +
//                            "/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]"));
            el.swipe(SwipeElementDirection.UP, 500);
            try{ Thread.sleep(500); } catch (Exception e) {}
            try {
                try {
                    account = find(MobileBy.xpath(
                            "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[" +
                                    (lastValue + 1) +
                                    "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]" +
                                    "/android.widget.LinearLayout[2]/android.widget.TextView[2]")).getText();
                }
                catch (Exception e) {
                    account = find(MobileBy.xpath(
                            "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[" +
                                    lastValue +
                                    "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]" +
                                    "/android.widget.LinearLayout[2]/android.widget.TextView[2]")).getText();
                }
                System.out.println(account);
                if (account.equals(previousCampaign)) {
                    continue;
                }
//                if (account.equals("app3")) {
//                    total++;
//                    break;
//                }
                total++;
                System.out.println(total);
                previousCampaign = account;
            } catch (Exception e) {
                break;
            }
        } while (!account.equals("H & M Hennes & Mauritz Sverige AB"));
//        System.out.println(iterator);
        System.out.println(total);
        return total;
//        return getTableSize(tableCells);
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
