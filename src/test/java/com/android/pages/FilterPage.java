package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class FilterPage extends BasePage {

    private static final By labelFilter = MobileBy.xpath(
            "//*[@class='android.widget.TextView' and @text='Filter']");

    private static final By buttonClose = MobileBy.id("close");
    private static final By buttonUsers = MobileBy.id("users_selected");
    private static final By buttonUsersOnCalendar = MobileBy.IosUIAutomation(
            ".tableViews()[2].cells()[0]");
    private static final By buttonAppointmentsType = MobileBy.id("appointment_types");
    private static final By buttonActivityType = MobileBy.IosUIAutomation(
            ".tableViews()[1].cells()[1]");
    private static final By buttonDate = MobileBy.id("dates");
    private static final By buttonDatePeriod = MobileBy.IosUIAutomation(
            ".tableViews()[1].cells()[\"Date period\"]");
    private static final By buttonArchived = MobileBy.IosUIAutomation(
            ".tableViews()[1].cells()[\"Archived\"]");
    private static final By buttonTemplate = MobileBy.IosUIAutomation(
            ".tableViews()[1].cells()[\"Template\"]");
    private static final By buttonStages = MobileBy.IosUIAutomation(
            ".tableViews()[1].cells()[\"Stages\"]");
    private static final By buttonBack = MobileBy.id("back");
    private static final By buttonSearchClearText = MobileBy.IosUIAutomation(
            ".searchBars()[0].buttons()[0]");
    private static final By tableFilterValues = MobileBy.id("user");
    private static final By fieldSearch = MobileBy.id("search");

    private static final By labelUserValue = MobileBy.id("users_selected");
    private static final By labelUserOnCalendarValue = MobileBy.IosUIAutomation(
            ".tableViews()[2].cells()[0].staticTexts()[1]");
    private static final By labelActivityTypeValue = MobileBy.id("activity_type_selected");
    private static final By labelDateValue = MobileBy.id("date_selected");
    private static final By labelDatePeriodValue = MobileBy.id("period_selected");
    private static final By labelStagesValue = MobileBy.id("stages_selected");
    private static final By labelAppointmentsTypeValue = MobileBy.id("appointment_type_selected");
    private static final By labelFirstSearchResult = MobileBy.xpath(
            "//*[@class='android.widget.CheckBox' and @index='0']");
    private static final By labelCategoriesValue = MobileBy.IosUIAutomation(
            ".tableViews()[2].cells()[1].staticTexts()[1]");
    private static final By labelCampaignValue = MobileBy.IosUIAutomation(
            ".tableViews()[2].cells()[2].staticTexts()[1]");
    private static final By labelArchivedValue = MobileBy.IosUIAutomation(
            ".tableViews()[1].cells()[\"Archived\"].staticTexts()[1]");
    private static final By labelTemplateValue = MobileBy.IosUIAutomation(
            ".tableViews()[1].cells()[\"Template\"].staticTexts()[1]");

    private static String firstSearchResultValue;

    public static void clickClose() {
        find(buttonClose).click();
    }

    public static void clickUsers() {
        find(buttonUsers).click();
    }

    public static void clickUsersOnCalendar() {
        find(buttonUsersOnCalendar).click();
    }

    public static void clickAppointmentsType() {
        find(buttonAppointmentsType).click();
    }

    public static void clickActivityType() {
        find(labelActivityTypeValue).click();
    }

    public static void clickDate() {
        find(buttonDate).click();
    }

    public static void clickDatePeriod() {
        find(buttonDatePeriod).click();
    }

    public static void clickStages() {
        find(buttonStages).click();
    }

    public static void clickBack() {
        find(buttonBack).click();
    }

    public static void clickSearchClear() {
        find(fieldSearch).clear();
    }

    public static String getCurrentUserLabelValue() {
        return getText(labelUserValue);
    }

    public static String getCurrentActivityTypeLabelValue() {
        return getText(labelActivityTypeValue);
    }

    public static String getCurrentAppointmentsTypeLabelValue() {
        return getText(labelAppointmentsTypeValue);
    }

    public static String getCurrentDateValue() {
        return getText(labelDateValue);
    }

    public static String getCurrentDatePeriodValue() {
        return getText(labelDatePeriodValue);
    }

    public static String getCurrentStagesValue() {
        return getText(labelStagesValue);
    }

    public static String getArchivedValue() {
        return getValue(labelArchivedValue);
    }

    public static String getTemplateValue() {
        return getValue(labelTemplateValue);
    }

    public static void select(String value) {
        wait(buttonBack);
//        String name = value;
//        String path = "//*[@class='android.widget.CheckBox' and @text='" + name + "']";
//        List<WebElement> elements = getDriver().findElements(MobileBy.xpath("//*[@class='android.widget.CheckBox']"));
//        for (WebElement el : elements)
//            System.out.println(el.getText());
        try {
            find(MobileBy.xpath("//*[@class='android.widget.CheckBox' and @text='" + value + "']")).click();
        } catch (NoSuchElementException e) {
            find(MobileBy.xpath("//*[@class='android.widget.RadioButton' and @text='" + value + "']")).click();
        }
    }

    public static void selectOnCalendar(String value) {
        find(MobileBy.IosUIAutomation(".tableViews()[2].cells()[\"" + value + "\"]")).click();
    }

    public static void search(String value) {
        find(fieldSearch).sendKeys(value);
    }

    public static boolean checkFirstSearchResultContains(String value) {
        return containsIgnoreCase(getText(labelFirstSearchResult), value);
    }

    public static void selectFirstSearchResult() {
        find(labelFirstSearchResult).click();
    }

    public static void saveFirstSearchResultValue() {
        firstSearchResultValue = getText(labelFirstSearchResult);
    }

    public static String getFirstSearchResultValue() {
        return firstSearchResultValue;
    }

    private static List<WebElement> getTableValues(By table) {
        return getDriver().findElements(table);
    }

    public static boolean checkSearchResultsContains(String value) {
        for(WebElement el : getTableValues(tableFilterValues)) {
            if (!containsIgnoreCase(el.getText(), value))
                return false;
        }
        return true;
    }

    public static boolean checkFilter() {
        waitByThread(200);
        return checkIsDisplayed(labelFilter);
    }

    public static String getCurrentCategories() {
        return getValue(labelCategoriesValue);
    }

    public static String getCurrentCampaign() {
        return getValue(labelCampaignValue);
    }
}