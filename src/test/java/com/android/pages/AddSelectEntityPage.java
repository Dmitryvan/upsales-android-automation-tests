package com.android.pages;

import com.android.util.Helpers;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AddSelectEntityPage extends BasePage{

    private static final By buttonBack = MobileBy.id("back");
    private static final By fieldSearch = MobileBy.id("edit");
    private static final By labelResults = MobileBy.xpath("//*[@class='android.widget.TextView' and @text='Results']");
    private static final By buttonSelect = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[2]");
    private static final By labelNone = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0].staticTexts()[0]");

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
        return getLabel(buttonSelect);
    }

    public static void search(String value) {
        find(fieldSearch).sendKeys(value);
    }

    public static void select(String value) {
        find(MobileBy.xpath("//*[@class='android.widget.CheckBox' and @text='" + value + "']")).click();
    }

    public static void clickResultsLabel() {
        find(labelResults).click();
    }

    public static void clickBack() {
        find(buttonBack).click();
    }

    public static void clickSelect() {
        find(buttonSelect).click();
    }

    public static void clickCancel() {
        find(buttonCancel).click();
    }

    public static String getLabelNone() {
        return getValue(labelNone);
    }
}
