package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActivityManipulationsPage extends BasePage {

    private static String description;
    private static final String descriptionNamePrefix = "act_";

    private static final By buttonActivityType = MobileBy.id("activity_type_field");
    private static final By listActvityType = MobileBy.id("text1");
    private static final By buttonDueDate = MobileBy.id("date_field");

    private static final By buttonTime = MobileBy.id("time_field");
    private static final By buttonOpportunity = MobileBy.id("opportunity_field");
    private static final By buttonUser = MobileBy.id("user_field");

    private static final By activityType = MobileBy.xpath("//*[contains(@resource-id, 'activity_type_field')]//*[contains(@resource-id, 'select')]");
    private static final By date = MobileBy.xpath("//*[contains(@resource-id, 'date_field')]//*[contains(@resource-id, 'select')]");
    private static final By time = MobileBy.xpath("//*[contains(@resource-id, 'time_field')]//*[contains(@resource-id, 'select')]");
    private static final By user = MobileBy.xpath("//*[contains(@resource-id, 'user_field')]//*[contains(@resource-id, 'select')]");

    private static final By labelActivityType = MobileBy.xpath("//*[contains(@resource-id, 'activity_type_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelDueDate = MobileBy.xpath("//*[contains(@resource-id, 'date_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelTime = MobileBy.xpath("//*[contains(@resource-id, 'time_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelUser = MobileBy.xpath("//*[contains(@resource-id, 'user_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelNotes = MobileBy.xpath("//*[contains(@resource-id, 'notes_field_above')]//*[contains(@resource-id, 'name')]");

    private static final By fieldExpenses = MobileBy.xpath("//*[@text='Expenses']/..//*[contains(@resource-id, 'edit_field')]");

    public static void clickExpenses() {
        getDriver().getPageSource();
        find(fieldExpenses).click();
    }

    public static String getLabelActivityType() {
        return getText(labelActivityType);
    }

    public static String getLabelUser() {
        return getText(labelUser);
    }

    public static String getLabelTime() {
        return getText(labelTime);
    }

    public static String getLabelNotes() {
        return getText(labelNotes);
    }

    public static String getAllActivityTypes() {
        String string = "";
        List<WebElement> accTypes = getDriver().findElements(listActvityType);
        for (int i = 0, k = accTypes.size(); i < k; i++) {
            string += accTypes.get(i).getText();
            if (i < k - 1)
                string += ", ";
        }
        return string;
    }

    public static String getDueDate() {
        return getText(date);
    }

    public static void clickActivityType() {
        find(buttonActivityType).click();
    }

    public static void clickDueDate() {
        find(buttonDueDate).click();
    }

    public static void clickTime() {
        find(buttonTime).click();
    }

    public static void clickOpportunity() {
        find(buttonOpportunity).click();
    }

    public static void clickUser() {
        find(buttonUser).click();
    }

    public static String getActivityType() {
        waitToBeClickable(activityType);
        return getText(activityType);
    }

    public static String getLabelDueDate() {
        return getText(labelDueDate);
    }

    public static String getTime() {
        return getText(time);
    }

    public static String getUser() {
        return getText(user);
    }

    public static void setDescription() {
        description = generateName(descriptionNamePrefix);
    }

    public static String getDescription() {
        return description;
    }

    public static boolean getNotesStartsWith(String start) {
        return getNotes().startsWith(start);
    }

    public static String getExpenses() {
        return getText(fieldExpenses);
    }

    public static void enterExpenses(String value) {
        waitByThread(600);
        sendValues(value, fieldExpenses);
    }

    public static void clearExpenses() {
        find(fieldExpenses).clear();
    }
}