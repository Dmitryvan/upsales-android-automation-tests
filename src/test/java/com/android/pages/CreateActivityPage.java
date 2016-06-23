package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.Arrays;


public class CreateActivityPage extends BasePage {

    private static final String offsetDown = "0.65";
    private static final String offsetUp = "0.35";

    private static final String cellIndexActivityType = "2";
    private static final String cellIndexContact = "6";
    private static final String cellIndexOpportunity = "7";
    private static final String cellIndexUser = "8";

    private static final By buttonCancel = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[1]");
    private static final By buttonSave = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[2]");
    private static final By fieldDesctiption = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0].textViews()[0]");
    private static final By buttonActivityType = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1]");
    private static final By pickerWheelActvityType = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].pickers()[0].wheels()");
    private static final By buttonDueDate = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2]");
    private static final By pickerWheelDueDateMonth = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[0]");
    private static final By pickerWheelDueDateDay = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[1]");
    private static final By pickerWheelDueDateYear = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[2]");
    private static final By buttonTime = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3]");
    private static final By pickerWheelTimeHours = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[0]");
    private static final By pickerWheelTimeMinutes = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[1]");
    private static final By pickerWheelTimeAmPm = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[2]");
    private static final By buttonAccount = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4]");
    private static final By buttonContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[5]");
    private static final By pickerWheelContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6].pickers()[0].wheels()[0]");
    private static final By buttonOpportunity = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6]");
    private static final By pickerWheelOpportunity = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7].pickers()[0].wheels()[0]");
    private static final By buttonUser = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7]");
    private static final By pickerWheelUser = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].pickers()[0].wheels()[0]");
    private static final By buttonCampaign = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8]");
    private static final By fieldNotes = MobileBy.IosUIAutomation(".tableViews()[0].cells()[9].textViews()[0]");

    private static final By labelActivityType = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].staticTexts()[1]");
    private static final By labelDueDate = MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].staticTexts()[2]");
    private static final By labelTime = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].staticTexts()[2]");
    private static final By labelAccount = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].staticTexts()[2]");
    private static final By labelContact = MobileBy.IosUIAutomation(".tableViews()[0].cells()[5].staticTexts()[2]");
    private static final By labelOpportunity = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6].staticTexts()[2]");
    private static final By labelUser = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7].staticTexts()[2]");

    private static final By labelCreatedActivityName = MobileBy.xpath("" +
            "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAStaticText[1]");

    public static void clickCancel() {
        find(buttonCancel).click();
    }

    public static void clickSave() {
        find(buttonSave).click();
    }

    public static void enterDescription (String description) {
        find(fieldDesctiption).sendKeys(description);
    }

    public static void clickActivityType() {
        find(buttonActivityType).click();
    }

    public static void selectActivityType(String activityType) {
        find(pickerWheelActvityType).sendKeys(activityType);
//        getDriver().findElements(By.className("UIAPickerWheel")).get(0).sendKeys(activityType);
    }

    public static void spinActivityTypeWheelTo(String value) {
        spinWheel(value, pickerWheelActvityType, cellIndexActivityType);
    }

    public static void spinContactWheelTo(String value) {
        spinWheel(value, pickerWheelContact, cellIndexContact);
    }


    public static void spinUserWheelTo(String value) {
        spinWheel(value, pickerWheelUser, cellIndexUser);
    }


    public static void spinOpportunityWheelTo(String value) {
        spinWheel(value, pickerWheelOpportunity, cellIndexOpportunity);
    }

    public static void spinWheel(String value, By wheel, String cellIndex) {
        String yOffset;

        String st = find(wheel).getAttribute("values");
        st = st.substring(1, st.length() - 1);
        ArrayList<String> values = new ArrayList<>(Arrays.asList(st.split(", ")));

        String currentValue = find(wheel).getAttribute("value");
        String previousValue;

        int indexOfCurrentValue = values.indexOf(currentValue);
        int indexOfTargetValue = values.indexOf(value);
        int stepsAmount = Math.abs(indexOfTargetValue - indexOfCurrentValue);

        if(indexOfTargetValue > indexOfCurrentValue) {
            yOffset = offsetDown;
        } else {
            yOffset = offsetUp;
        }

        for(int i = 0; i < stepsAmount; i++)
        {
            ((JavascriptExecutor) getDriver()).executeScript(
                    "au.mainWindow().tableViews()[0].cells()[" + cellIndex +
                            "].pickers()[0].wheels()[0].tapWithOptions({tapOffset:{x:0.05, y:" + yOffset + "}});"
            );
        }

//        while (!currentValue.equals(value)) {
//            ((JavascriptExecutor) getDriver()).executeScript(
//                    "au.mainWindow().tableViews()[0].cells()[" + cellIndex + "].pickers()[0].wheels()[0].tapWithOptions({tapOffset:{x:0.05, y:" + yOffset + "}});"
//            );
//            previousValue = currentValue;
//            currentValue = find(wheel).getAttribute("value");
//            if (previousValue.equals(currentValue))
//                break;
//        }
    }

    public static void clickDueDate() {
        find(buttonDueDate).click();
    }

    public static void selectDueDateMonth(String month) {
        getDriver().findElements(By.className("UIAPickerWheel")).get(0).sendKeys(month);
    }

    public static void selectDueDateDay(String day) {
        find(pickerWheelDueDateDay).sendKeys(day);
    }

    public static void selectDueDateYear(String year) {
        find(pickerWheelDueDateYear).sendKeys(year);
    }

    public static void clickTime() {
        find(buttonTime).click();
    }

    public static void selectTimeHours(String hours) {
        getDriver().findElements(By.className("UIAPickerWheel")).get(0).sendKeys(hours);
    }

    public static void selectTimeMinutes(String minutes) {
        find(pickerWheelTimeMinutes).sendKeys(minutes);
    }

    public static void selectTimeAmPm(String aMpM) {
        getDriver().findElements(By.className("UIAPickerWheel")).get(2).sendKeys(aMpM);
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

//    public static void selectAccount(String name) {
//        findByName(name).click();
//    }

    public static void clickContact() {
        find(buttonContact).click();
    }

    public static void selectContact(String contact) {
        getDriver().findElements(By.className("UIAPickerWheel")).get(0).sendKeys(contact);
    }

    public static void clickOpportunity() {
        find(buttonOpportunity).click();
    }

    public static void selectOpportunity(String opportunity) {
        getDriver().findElements(By.className("UIAPickerWheel")).get(0).sendKeys(opportunity);
    }

    public static void clickUser() {
        find(buttonUser).click();
    }

    public static void selectUser(String user) {
        find(pickerWheelUser).sendKeys(user);
    }

    public static void clickCampaign() {
        find(buttonCampaign).click();
    }

    public static void typeIntoNotes(String note) {
        find(fieldNotes).sendKeys(note);
    }

    public static boolean checkActivityTypeLabelValue(String activityType) {
        return find(labelActivityType).getAttribute("value").equals(activityType);
    }

    public static boolean checkDueDateLabelValue(String dueDate) {
        return find(labelDueDate).getAttribute("value").equals(dueDate);
    }

    public static boolean checkTimeLabelValue(String time) {
        return find(labelTime).getAttribute("value").equals(time);
    }

    public static boolean checkAccountLabelValue(String account) {
        return find(labelAccount).getAttribute("value").equals(account);
    }

    public static boolean checkContactLabelValue(String contact) {
        return find(labelContact).getAttribute("value").equals(contact);
    }

    public static boolean checkOpportunityLabelValue(String opportunity) {
        return find(labelOpportunity).getAttribute("value").equals(opportunity);
    }

    public static boolean checkUserLabelValue(String user) {
        return find(labelUser).getAttribute("value").equals(user);
    }
}
