package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardPage extends BasePage {

    private static final int cellsOnScreenSize = 6;
    private static ArrayList<float[]> usersValuesStorage = new ArrayList<>();
    private static float[] salesAndPipelineValues = new float[2];

    private static final By buttonMonth = MobileBy.id("month");
    private static final By buttonQuarter = MobileBy.id("quarter");
    private static final By buttonYear = MobileBy.id("year");

    private static final By labelSales = MobileBy.id("sales_title");
    private static final By labelPipeline = MobileBy.id("pipeline_title");

    private static final By labelSalesValue = MobileBy.id("sales_value");
    private static final By labelPipelineValue = MobileBy.id("pipeline_value");

    private static final By salesWidget = MobileBy.id("sales_view");
    private static final By pipelineWidget = MobileBy.id("pipeline_view");
    private static final List<WebElement> date = findElements(MobileBy.id("date"));

    private static final By labelShowMore = MobileBy.id("show_more");

    private static final List<WebElement> labelsTodayEvents = findElements(MobileBy.id("text"));
    private static final List<WebElement> cells = findElements(MobileBy.id("content"));

    private static final By labelMyAppointmentsToday = MobileBy.xpath("//*[starts-with(@text, \"MY APPOINTMENTS\")]");
    private static final By labelMyActivitiesToday = MobileBy.xpath("//*[starts-with(@text, \"MY OPEN\")]");
    private static final By entityTable = MobileBy.IosUIAutomation(".tableViews()[0].cells()");
    private static final By salesPipelinePanel = MobileBy.xpath("//android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]");
    private static final By labelShowAllActivities = MobileBy.id("show_all_activities");

    private static final By buttonDelete = MobileBy.id("trash");

    public static String getLabelSales() {
        return getText(labelSales);
    }

    public static String getLabelPipeline() {
        return getText(labelPipeline);
    }

    public static boolean checkSalesWidget() {
        return checkIsDisplayed(salesWidget);
    }

    public static boolean checkPipelineWidget() {
        return checkIsDisplayed(pipelineWidget);
    }

    public static String getLabelMonth() {
        return getText(buttonMonth);
    }

    public static String getLabelQuarter() {
        return find(buttonQuarter).getText();
    }

    public static String getLabelYear() {
        return find(buttonYear).getText();
    }

    public static String getLabelShowMore() {
        return getText(labelShowMore);
    }

    public static String getMyAppointmentsTodayLabel() {
        return getText(labelMyAppointmentsToday);
    }

    public static int getMyAppointmentsTodayCount() {
        wait(labelMyAppointmentsToday);
        return Integer.parseInt(getMyAppointmentsTodayLabel().replaceAll("\\D", ""));
    }

    public static String getMyActivitiesTodayLabel() {
        scrollToLabel("MY OPEN");
        return getText(labelMyActivitiesToday);
    }

    public static int getMyOpenActivitiesCount() {
        return Integer.parseInt(getMyActivitiesTodayLabel().replaceAll("\\D", ""));
    }

    public static void clickShowMore() {
        find(labelShowMore).click();
    }

    public static void clickMonth() {
        find(buttonMonth).click();
    }

    public static void clickQuarter() {
        find(buttonQuarter).click();
    }

    public static void clickYear() {
        find(buttonYear).click();
    }

    public static void clickLabelSales() {
        find(labelSales).click();
    }

    public static void clickLabelPipeline() {
        find(labelPipeline).click();
    }

    public static void clickDelete() {
        find(buttonDelete).click();
    }

    public static void saveCurrentSalesAndPipelineValues() throws InterruptedException {
        Thread.sleep(2000);
//        System.out.println(getText(labelSalesValue));
//        System.out.println(getText(labelPipelineValue));
        String[] stringArray = {getText(labelSalesValue),
                getText(labelPipelineValue)};
        salesAndPipelineValues = stringToFloatArrayConverter(stringArray);
    }

    private static float[] getSavedSalesAndPipelineValues() {
        return salesAndPipelineValues;
    }

    public static float[] getCurrentSalesAndPipelineValues() throws InterruptedException {
        Thread.sleep(2000);
//        System.out.println(getText(labelSalesValue));
//        System.out.println(getText(labelPipelineValue));
        String[] stringValues = {getText(labelSalesValue),
                getText(labelPipelineValue)};
        return stringToFloatArrayConverter(stringValues);
    }

    public static boolean compareSavedAndCurrentValues() throws InterruptedException {
        return Arrays.equals(getSavedSalesAndPipelineValues(), getCurrentSalesAndPipelineValues());
    }

    public static void addUserValuesToStorage() throws InterruptedException {
        usersValuesStorage.add(getCurrentSalesAndPipelineValues());
    }

    public static float[] getUsersValuesStorageSum() {
        float[] tempArr = new float[salesAndPipelineValues.length];
        for(int i = 0; i < tempArr.length; i++) {
            tempArr[i] = 0;
            for(float[] f : usersValuesStorage)
                tempArr[i] += f[i];
        }
        return tempArr;
    }

    public static ArrayList<String> getAppointmentsList() {
        ArrayList<String> names = new ArrayList<>();
        int appointmentsCount = getMyAppointmentsTodayCount();
        for(int i = 0; i < appointmentsCount; i++) {
            if(i < cellsOnScreenSize)
                names.add(find(MobileBy.IosUIAutomation(
                        ".tableViews()[0].cells()[" + i +"]")).getAttribute("name"));
            else
                names.add(find(MobileBy.IosUIAutomation(
                        ".tableViews()[0].cells()[" + i +"].staticTexts()[2]")).getAttribute("name"));
        }

//        for (String name : names)
//            System.out.println(name);

        return names;
    }

    public static ArrayList<String> getActivitiesList() {
        ArrayList<String> names = new ArrayList<>();
        int appointmentsCount = getMyAppointmentsTodayCount();
        int tableSize = getTableSize(entityTable);
        for(int i = appointmentsCount; i <  tableSize; i++) {
            names.add(find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i +"]")).getAttribute("name"));
        }

//        for (String name : names)
//            System.out.println(name);

        return names;
    }

    public static void deleteAllAppointments() {
        ArrayList<String> appointments = getAppointmentsList();
        for (String name : appointments) {
            deleteEntity(name);
        }
    }

    public static void selectAppointment(String app) {
        wait(labelMyAppointmentsToday);
        scrollToLabel(app);
        find(MobileBy.xpath("//*[contains(@resource-id, 'description') and @text='" + app + "']")).click();
//        try {
//            find(MobileBy.IosUIAutomation(".tableViews()[0].cells()['" + app + "']")).click();
//        }
//        catch(NoSuchElementException e) {
//            find(MobileBy.IosUIAutomation(
//                    ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[2].value=='" + app + "'\")")).click();
//        }
    }

    public static void selectActivity(String act) {
        wait(labelMyAppointmentsToday);
        scrollToLabel(act);
        find(MobileBy.xpath("//*[contains(@resource-id, 'description') and @text='" + act + "']")).click();
    }

    public static float getSalesValue() {
        return getFloatValue(labelSalesValue);
    }

    public static float getPipelineValue() {
        return getFloatValue(labelPipelineValue);
    }

    public static boolean checkAllAppointmentsAreForToday(String today) {
        int appointmentsCount = getMyAppointmentsTodayCount();
        for (int i = 0; i < appointmentsCount; i++) {
            String appDate = date.get(i).getText().substring(6);
            if (appDate.equals(today)) return true;
        }
        return false;
    }

    public static void swipeLeft() {
        swipeLeft(salesPipelinePanel);
    }
    //    public static String getLastAppType() {
//        int appointmentsCount = getMyAppointmentsTodayCount();
//        find(MobileBy.IosUIAutomation(".tableViews()[0].cells()[" + (appointmentsCount - 1) + "]")).click();
//        AppointmentPage.clickTools();
//        return AppointmentPage.getTextEditAppointment();
//    }
//
//    public static String getFirstActivityType() {
//        int appointmentsCount = getMyAppointmentsTodayCount();
//        find(MobileBy.IosUIAutomation(".tableViews()[0].cells()[" + appointmentsCount + "]")).click();
//        ActivityPage.clickTools();
//        return ActivityPage.getTextEditActivity();
//    }

    public static String getLabelShowAllActivities() {
        return getText(labelShowAllActivities);
    }

    public static boolean checkShowAllActivitiesVisibility() {
        return find(labelShowAllActivities).isDisplayed();
    }

    public static String getLastAppType(int count) {
//        cells.get(count - 1).click();
        scrollToLabel("MY OPEN");
        find(MobileBy.xpath("//*[starts-with(@text, \"MY OPEN\")]/../preceding-sibling::android.widget.RelativeLayout[1]")).click();
        AppointmentPage.clickTools();
        return AppointmentPage.getTextEditAppointment();
    }

    public static String getFirstActivityType(int count) {
//        cells.get(count).click();
        swipeFromBottomToTop();
        scrollToLabel("MY OPEN");
        find(MobileBy.xpath("//*[starts-with(@text, \"MY OPEN\")]/../following-sibling::android.widget.RelativeLayout[1]")).click();
        ActivityPage.clickTools();
        return ActivityPage.getTextEditActivity();
    }

    public static void swipeActivity(String name) {
        AndroidElement activity = (AndroidElement) find(MobileBy.xpath("//*[contains(resoirce-id, dashboard_item)]//*[@text='" + name + "']/.."));
        activity.swipe(SwipeElementDirection.LEFT, 500);
    }

    public static boolean checkActiviyIsPresent(String name) {
        try {
            find(MobileBy.xpath("//*[contains(resoirce-id, dashboard_item)]//*[@text='" + name + "']/.."));
            return true;
        } catch (Exception e1) {
            try {
                swipeFromBottomToTop();
                find(MobileBy.xpath("//*[contains(resoirce-id, dashboard_item)]//*[@text='" + name + "']/.."));
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }
}
