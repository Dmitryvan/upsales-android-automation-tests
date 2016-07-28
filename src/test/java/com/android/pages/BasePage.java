package com.android.pages;

import com.android.util.Helpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasePage extends Helpers {

    private static final By buttonLeftMenu = MobileBy.xpath("//android.widget.ImageButton[1]");
    private static final By buttonCancel = MobileBy.id("cancel");
    private static final By buttonSave = MobileBy.id("save");
    private static final By buttonTools = MobileBy.id("save");
    private static final By buttonFilter = MobileBy.id("filter_icon");
    private static final By buttonBack = MobileBy.id("back");

    private static final By title = MobileBy.id("title");
    private static final By labelOtherInfo = MobileBy.xpath("//*[contains(@resource-id, 'title') and @index='0']");
    private static final By fieldNotes = MobileBy.xpath("//*[contains(@resource-id, 'notes') and @index='2']");
    private static final By fieldDescription = MobileBy.id("edit");

    private static final By buttonAccount = MobileBy.id("account_field");
    private static final By buttonCampaign = MobileBy.id("company_field");

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
        find(buttonBack).click();
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
        return getText(buttonSave);
    }

    public static String getLabelCancel() {
        return getText(buttonCancel);
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

    public static String getText(By locator) {
        return find(locator).getText();
    }

    protected static String getTextByPath(String start, int index, String end) {
        return find(MobileBy.xpath(start + index + end)).getText();
    }

    public static void clickTools() {
        find(buttonTools).click();
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

    public static void selectValueFromPopUp(String value) {
        waitByThread(500);
        find(MobileBy.xpath(
                "//*[@class='android.widget.CheckedTextView' and @text='" +
                        value + "']")).click();
    }

    public static void closePopUp() {
        try {
            ((AndroidDriver) getDriver()).tap(1, 100, 100, 1);
        } catch (WebDriverException e) {}
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickCampaign() {
        find(buttonCampaign).click();
    }

    public static String getLabelOtherInfo() {
        return getText(labelOtherInfo);
    }

    public static void typeIntoNotes(String note) {
        find(fieldNotes).clear();
        find(fieldNotes).sendKeys(note);
    }

    public static String getNotes() {
        return getText(fieldNotes);
    }

    public static void enterDescription (String description) {
        AndroidElement element = (AndroidElement) find(fieldDescription);
        element.click();
        element.clear();
        element.sendKeys(description);
        hideKeyboard();
    }

    public static String getLabelDescription() {
        return getText(fieldDescription);
    }
}
