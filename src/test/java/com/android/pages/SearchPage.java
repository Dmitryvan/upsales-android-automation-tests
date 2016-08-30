package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;

import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    private static final By fieldSearch = MobileBy.id("search");
    private static final By labelFirstSearchResult = MobileBy.id("account");

    public static void search(String value) {
        sendValues(value, fieldSearch);
        waitByThread(2000);
    }

    public static String getFirstSearchResult() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return getText(labelFirstSearchResult);
    }

    public static void clickOnFirstSearchResult() {
        waitByThread(2000);
        WebElement element = find(labelFirstSearchResult);
        Point point = ((Locatable)element).getCoordinates().onPage();
        new TouchAction((MobileDriver)getDriver()).tap(point.getX(), point.getY()).perform();
        waitByThread(4000);
    }
}
