package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CreateMenuPage extends BasePage {

    private static final By buttonActivity = MobileBy.id("activity");
    private static final By buttonAppointment = MobileBy.id("appointment");
    private static final By buttonOpportunity = MobileBy.id("opportunity");
    private static final By buttonOrder = MobileBy.id("order");
    private static final By buttonContact = MobileBy.id("contact");
    private static final By buttonAccount = MobileBy.id("account");

    private static final By labelHeader = MobileBy.xpath("//*[@class='android.widget.TextView' and @index='0']");
    private static final By labelActivity = MobileBy.xpath("" +
            "//android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By labelAppointment = MobileBy.xpath("" +
            "//android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
    private static final By labelOpportunity = MobileBy.xpath("" +
            "//android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[2]");
    private static final By labelOrder = MobileBy.xpath("" +
            "//android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[2]");
    private static final By labelContact = MobileBy.xpath("" +
            "//android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.TextView[2]");
    private static final By labelAccount = MobileBy.xpath("" +
            "//android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.TextView[2]");

    public static String getLabelHeader() {
        return find(labelHeader).getText();
    }

    public static String getLabelActivity() {
        return find(labelActivity).getText();
    }

    public static String getLabelAppointment() {
        return find(labelAppointment).getText();
    }

    public static String getLabelOpportunity() {
        return find(labelOpportunity).getText();
    }

    public static String getLabelOrder() {
        return find(labelOrder).getText();
    }

    public static String getLabelAccount() {
        return find(labelAccount).getText();
    }

    public static String getLabelContact() {
        return find(labelContact).getText();
    }

    public static void clickActivity() {
//        ((AndroidDriver)getDriver()).tap(1, 500, 860, 1);
        find(buttonActivity).click();
    }

    public static void clickAppointment() {
        find(buttonAppointment).click();
    }

    public static void clickOpportunity() {
        find(buttonOpportunity).click();
    }

    public static void clickOrder() {
        find(buttonOrder).click();
    }

    public static void clickContact() {
//        ((AndroidDriver)getDriver()).tap(1, 168, 1380, 1);
        find(buttonContact).click();
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }
}
