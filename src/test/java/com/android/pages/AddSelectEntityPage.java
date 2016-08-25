package com.android.pages;

import com.android.util.Helpers;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AddSelectEntityPage extends BasePage{

    private static final By buttonBack = MobileBy.id("back");
    private static final By fieldSearch = MobileBy.id("edit");
    private static final By labelResults = MobileBy.xpath("//*[@class='android.widget.TextView' and @text='Results']");
    private static final By buttonSelect = MobileBy.id("select");
    private static final By labelNone = MobileBy.xpath("//*[@class='android.widget.CheckBox' and @index='0']");
    private static final By buttonCancel = MobileBy.id("cancel");

    public static String getTitle() {
        return BasePage.getTitle();
    }

    public static String getTrimTitle() {
        return Helpers.trimFirstTwoChars(BasePage.getTitle());
    }

    public static String getSearchFieldValue() {
        return getText(fieldSearch);
    }

    public static String getResultsLabelValue() {
        wait(labelResults);
        return getText(labelResults);
    }

    public static String getSelectButtonValue() {
        return getText(buttonSelect);
    }

    public static void search(String value) {
        find(fieldSearch).sendKeys(value);
    }

    public static void select(String value) {
        waitByThread(1000);
        hideKeyboard();
        scrollToLabel(value);
        find(MobileBy.xpath("//*[contains(@resource-id, 'item') and @text='" + value + "']")).click();
        waitByThread(1000);
    }

    public static void unselect(String value) {
        waitByThread(1000);
        hideKeyboard();
        scrollToLabel(value);
        find(MobileBy.xpath("//*[contains(@resource-id, 'item') and @text='" + value + "']")).click();
        waitByThread(1000);
    }

    public static void clickResultsLabel() {
        find(labelResults).click();
    }

    public static void clickBack() {
        hideKeyboard();
        find(buttonBack).click();
    }

    public static void clickSelect() {
        find(buttonSelect).click();
    }

    public static String getLabelNone() {
        return getText(labelNone);
    }

    public static String getCancelButtonValue() {
        return getText(buttonCancel);
    }
}
