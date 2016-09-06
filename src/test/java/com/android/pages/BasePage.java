package com.android.pages;

import com.android.util.Helpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasePage extends Helpers {

    public static final int DELETE_KEYCODE = 67;

    //headers
    private static final By buttonLeftMenu = MobileBy.id("left_icon");
    protected static final By buttonCancel = MobileBy.id("cancel");
    protected static final By buttonSave = MobileBy.id("save");
    private static final By buttonTools = MobileBy.id("save");
    private static final By buttonFilter = MobileBy.id("filter_icon");
    private static final By buttonBack = MobileBy.id("back");

    private static final By title = MobileBy.id("header_title");
    private static final By subTitle = MobileBy.id("sub_title");

    //cells
    private static final By buttonAccount = MobileBy.id("account_field");
    private static final By buttonCampaign = MobileBy.id("company_field");
    private static final By buttonContact = MobileBy.id("contact_field");
    private static final By buttonCategories = MobileBy.id("category_field");

    //fields
    private static final By fieldNotes = MobileBy.id("notes");
    private static final By fieldDescription = MobileBy.id("edit");

    //labels
    private static final By labelOtherInfo = MobileBy.xpath("//*[contains(@resource-id, 'list_custom_field')]//*[contains(@resource-id, 'title')]");
    private static final By labelAccount = MobileBy.xpath("//*[contains(@resource-id, 'account_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelContact = MobileBy.xpath("//*[contains(@resource-id, 'contact_field')]//*[contains(@resource-id, 'name')]");
    private static final By contactOnView = MobileBy.xpath("//*[contains(@resource-id, 'contact_root')]//*[contains(@resource-id, 'title')]");
    private static final By labelOpportunity = MobileBy.xpath("//*[contains(@resource-id, 'opportunity_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelCampaign = MobileBy.xpath("//*[contains(@resource-id, 'company_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelNotes = MobileBy.xpath("//*[contains(@resource-id, 'note_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelCategories = MobileBy.xpath("//*[contains(@resource-id, 'category_field')]//*[contains(@resource-id, 'name')]");

    //values
    private static final By account = MobileBy.xpath("//*[contains(@resource-id, 'account_field')]//*[contains(@resource-id, 'select')]");
    private static final By contact = MobileBy.xpath("//*[contains(@resource-id, 'contact_field')]//*[contains(@resource-id, 'select')]");
    private static final By opportunity = MobileBy.xpath("//*[contains(@resource-id, 'opportunity_field')]//*[contains(@resource-id, 'select')]");
    private static final By campaign = MobileBy.xpath("//*[contains(@resource-id, 'company_field')]//*[contains(@resource-id, 'select')]");
    private static final By categories = MobileBy.xpath("//*[contains(@resource-id, 'category_field')]//*[contains(@resource-id, 'select')]");
    private static final By description = MobileBy.xpath("//*[contains(@resource-id, 'container_header')]//*[contains(@resource-id, 'header_title')]");

    //work with headers
    public static String getTitle() {
        wait(title);
        return getText(title);
    }

    public static String getSubTitle() {
        wait(subTitle);
        return getText(subTitle);
    }

    public static String getTitleOnView() {
        return findElements(title).get(0).getText();
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

    public static void clickTools() {
        find(buttonTools).click();
    }

    //common methods
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

    public static void selectValueFromPopUp(String value) {
        waitByThread(500);
        scrollToLabel(value);
        find(MobileBy.xpath(
                "//*[@class='android.widget.CheckedTextView' and @text='" +
                        value + "']")).click();
    }

    public static void closePopUp() {
        try {
            ((AndroidDriver) getDriver()).tap(1, 100, 100, 1);
        } catch (WebDriverException e) {}
    }

    //swipes
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

    //work with fields
    public static void typeIntoNotes(String note) {
        find(fieldNotes).clear();
        find(fieldNotes).sendKeys(note);
        hideKeyboard();
    }

    // work with cells
    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickCampaign() {
        find(buttonCampaign).click();
    }

    public static void clickCategories() {
        find(buttonCategories).click();
    }

    public static void clickContact() {
        waitByThread(1000);
        find(buttonContact).click();
    }

    public static String getContactOnView() {
        return getText(contactOnView);
    }

    //work with labels
    public static String getLabelOtherInfo() {
        return getText(labelOtherInfo);
    }

    public static String getNotes() {
        wait(fieldNotes);
        return getText(fieldNotes);
    }

    public static void enterDescription (String description) {
        clearAndType(description, fieldDescription);
//        AndroidElement element = (AndroidElement) find(fieldDescription);
//        element.click();
//        element.clear();
//        element.sendKeys(description);
//        hideKeyboard();
    }

    public static String getLabelDescription() {
        return getText(fieldDescription);
    }

    public static String getLabelCampaign() {
        return getText(labelCampaign);
    }

    public static String getLabelCategories() {
        return getText(labelCategories);
    }

    public static String getCategories() {
        return getText(categories);
    }

    public static String getLabelNotes() {
        return getText(labelNotes);
    }

    public static String getLabelAccount() {
        return getText(labelAccount);
    }

    public static String getLabelOpportunity() {
        return getText(labelOpportunity);
    }

    public static String getLabelContact() {
        return getText(labelContact);
    }

    //work with values
    public static String getAccount() {
        return getText(account);
    }

    public static String getDescriptionOnView() {
        return getText(description);
    }

    public static String getContact() {
        return getText(contact);
    }

    public static String getOpportunity() {
        return getText(opportunity);
    }

    public static String getCampaign() {
        wait(campaign);
        return getText(campaign);
    }

    //need to remove
    public static String getValue(By by) {
        return find(by).getAttribute("value");
    }

    public static String getLabel(By by) {
        return find(by).getAttribute("label");
    }

    public static String getName(By by) {
        return find(by).getAttribute("name");
    }

}
