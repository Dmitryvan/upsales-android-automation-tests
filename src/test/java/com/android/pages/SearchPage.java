package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;

public class SearchPage extends BasePage {

    private static final By fieldSearch = MobileBy.id("search");
    private static final By labelFirstSearchResult = MobileBy.id("account");

    public static void search(String value) {
        sendValues(value, fieldSearch);
    }

    public static String getFirstSearchResult() {
        return getText(labelFirstSearchResult);
    }

    public static void clickOnFirstSearchResult() {
        WebElement element = find(labelFirstSearchResult);
        Point point = ((Locatable)element).getCoordinates().onPage();
        new TouchAction((MobileDriver)getDriver()).tap(point.getX(), point.getY()).perform();
    }
}
