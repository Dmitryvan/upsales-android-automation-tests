package com.android.pages;

import com.android.util.Helpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasePage extends Helpers {

    protected static final By buttonLeftMenu = MobileBy.xpath("//android.widget.ImageButton[1]");
    protected static final By buttonCancel = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[1]");
    protected static final By buttonSave = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[2]");
    private static final By buttonFilter = MobileBy.id("filter_icon");
    private static final By arrowBack = MobileBy.xpath("//android.widget.ImageButton[1]");

    private static final By title = MobileBy.id("title");

    public static String getTitle() {
        wait(title);
        return getName(title);
    }

    public static void clickFilter() {
        find(buttonFilter).click();
    }

    public static void checkPageTitle(String title) {
        assertEquals(title, getTitle());
    }

    public static void clickBack() {
        find(arrowBack).click();
    }

    public static void clickLeftMenu() {
        find(buttonLeftMenu).click();
    }

    public static void clickCancel() {
        find(buttonCancel).click();
    }

    public static void clickSave() {
        find(buttonSave).click();
    }

    protected static int getTableSize(By elementPath) {
        List<WebElement> list = findElements(elementPath);
//        System.out.println(list.size());
//        System.out.println(activity);
//        byte[] b = activity.getBytes("UTF-8");
//        for (byte bb : b) {
//            System.out.print(bb + " ");
//        }
//        System.out.println();
        return list.size();
    }

    public static String getLabelSave() {
        return getLabel(buttonSave);
    }

    public static String getLabelCancel() {
        return getLabel(buttonCancel);
    }

    public static String getValue(By by) {
        return find(by).getAttribute("value");
    }

    public static String getLabel(By by) {
        return find(by).getAttribute("label");
    }

    public static String getName(By by) {
        return find(by).getAttribute("name");
    }

    protected static void sendValues(String value, By locator) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected static void setValues(String value, By locator) {
        IOSElement element = (IOSElement) find(locator);
        element.clear();
        element.setValue(value);
    }

    public static String getText(By locator) {
        return find(locator).getText();
    }

    protected static String getTextByPath(String start, int index, String end) {
        return find(MobileBy.xpath(start + index + end)).getText();
    }

    public static void swipeFromTopToBottom() {
        Dimension size = getDriver().manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        ((AppiumDriver)getDriver()).swipe(startx, endy, startx, starty, 3000);
    }

    public static void swipeFromBottomToTop() {
        Dimension size = getDriver().manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        ((AppiumDriver)getDriver()).swipe(startx, starty, startx, endy, 3000);
    }

    protected static void swipeLeft(By locator) {
        MobileElement element = (MobileElement)  find(locator);
        element.swipe(SwipeElementDirection.LEFT, 70, 70, 500);
    }

    protected static void swipeRight(By locator) {
        MobileElement element = (MobileElement)  find(locator);
        element.swipe(SwipeElementDirection.RIGHT, 70, 70, 500);
    }
}
