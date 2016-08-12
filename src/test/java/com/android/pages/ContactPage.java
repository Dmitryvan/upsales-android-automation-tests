package com.android.pages;

import com.android.tests.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class ContactPage extends BasePage {

    private static final By account = MobileBy.id("account_name");
    private static final By title = MobileBy.id("header_subtitle");
    private static final By phone = MobileBy.id("phone");
    private static final By mobile = MobileBy.id("mobile");
    private static final By email = MobileBy.id("email");

    private static final By campaign = MobileBy.xpath("//android.support.v4.view.ViewPager[1]//android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By category = MobileBy.xpath("//android.support.v4.view.ViewPager[1]//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");

    private static final By campaignWithoutContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By campaignWithPhone = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By categoryWithoutContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By notes = MobileBy.id("notes");
    private static final By notesWithoutContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].textViews()[0]");
    private static final By buttonAddContactInfo = MobileBy.id("add_contact_info_title");
    private static final By categoryWithPhone = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[1]");
    private static final By extraIDWithoutData = MobileBy.xpath("//android.widget.RelativeLayout[@index='8']//android.widget.EditText[@index='0']");
    private static final By chanceOfSuccessWithoutData = MobileBy.xpath("//android.widget.RelativeLayout[@index='9']//android.widget.EditText[@index='0']");
    private static final By extraID = MobileBy.xpath("//android.widget.RelativeLayout[@index='6']//android.widget.RelativeLayout[@index='8']//android.widget.EditText[@index='0']");
    private static final By chanceOfSuccess = MobileBy.xpath("//android.widget.RelativeLayout[@index='6']//android.widget.RelativeLayout[@index='9']//android.widget.EditText[@index='0']");
    private static final By labelShowMore = MobileBy.IosUIAutomation(".tableViews()[0].cells().firstWithPredicate(\"staticTexts[0].name=='Show more (2)'\")");
    private static final By labelShowNotes = MobileBy.IosUIAutomation(".tableViews()[0].cells().firstWithPredicate(\"staticTexts[0].name=='Notes'\").buttons()[0]");
    private static final By labelShowLess = MobileBy.IosUIAutomation(".tableViews()[0].cells().firstWithPredicate(\"staticTexts[0].name=='Show less'\")");

    private static final By popoverEditContact = MobileBy.id("item_edit");

    private static final By bottomPopoverCall = MobileBy.xpath("//UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
    private static final By bottomPopoverCancel = MobileBy.xpath("//UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIAButton[1]");
    private static final By bottomPopoverMessage = MobileBy.xpath("//UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[2]");

    public static String getChanceOfSuccess() {
        return getText(chanceOfSuccess);
    }

    public static String getExtraID() {
        return getText(extraID);
    }

    public static String getExtraIDWithoutData() {
        return getText(extraIDWithoutData);
    }

    public static String getChanceOfSuccessWithoutData() {
        return getText(chanceOfSuccessWithoutData);
    }

    public static void clickBottomPopoverCancel() {
        wait(bottomPopoverCancel);
        find(bottomPopoverCancel).click();
    }

    public static void clickBottomPopoverCall() {
        wait(bottomPopoverCall);
        find(bottomPopoverCall).click();
    }

    public static void clickBottomPopoverMessage() {
        find(bottomPopoverMessage).click();
        getDriver().switchTo().alert().accept();
    }

    public static void clickEditContact() {
        find(popoverEditContact).click();
    }

    public static void clickAddContactInfo() {
        find(buttonAddContactInfo).click();
    }

    public static String getPhone() {
        return getText(phone);
    }

    public static String getMobile() {
        return getText(mobile);
    }

    public static String getEmail() {
        return getText(email);
    }

    public static void clickPhone() {
        find(phone).click();
        find(phone).click();
    }

    public static void clickMobile() {
        find(mobile).click();
        find(mobile).click();
    }

    public static void clickEmail() {
        find(email).click();
        find(email).click();
    }

    public static String getContactName() {
        return getDescriptionOnView();
    }

    public static String getAccount() {
        return getText(account);
    }

    public static void clickAccount() {
        find(account).click();
    }

    public static String getContactTitle() {
        return getText(title);
    }

    public static String getCampaign() {
        return getText(campaign);
    }

    public static String getCampaignWithPhone() {
        return getValue(campaignWithPhone);
    }

    public static String getCategoryWithPhone() {
        return getValue(categoryWithPhone);
    }

    public static String getCategory() {
        return getText(category);
    }

    public static String getNotes() {
        return getText(notes);
    }

    public static String getCampaignWithoutContact() {
        return getValue(campaignWithoutContact);
    }

    public static String getCategoryWithoutContact() {
        return getValue(categoryWithoutContact);
    }

    public static String getNotesWithoutContact() {
        return getValue(notesWithoutContact);
    }

    public static boolean checkTitle() {
        return checkIsDisplayed(title);
    }

    public static void clickShowMore() {
        find(labelShowMore).click();
    }

    public static void clickShowNotes() {
//        ((IOSDriver)getDriver()).scrollTo("Show");
        find(labelShowNotes).click();
    }

    public static void clickShowLess() {
        find(labelShowLess).click();
    }

    public static void swipeFromTopToBottom() {
        Dimension size = BaseTest.driver.manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        BaseTest.driver.swipe(startx, endy, startx, starty, 500);
    }

    public static String getAlertTitle() {
        waitByThread(1000);
        return find(MobileBy.id("title")).getText();
    }

    public static void clickBackOnDevice() {
        waitByThread(1000);
        getDriver().navigate().back();
    }
}
