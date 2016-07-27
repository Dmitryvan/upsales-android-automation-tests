package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpportunityManipulationsPage extends BasePage {

    private static String opportunityName;
    private static final String namePrefix = "opp_";

    private static final By fieldDescription = MobileBy.xpath("//TextInputLayout[1]/android.widget.EditText[1]");
    private static final By probability = MobileBy.xpath("//android.widget.RelativeLayout[@index='5']//android.widget.EditText[@index='0']");

    private static final By labels = MobileBy.id("name");
    private static final By values = MobileBy.id("select");
    private static final By titles = MobileBy.id("title");
    private static final By listStages = MobileBy.id("text1");


    private static final By buttonUser = MobileBy.id("sales_representative_field");
    private static final By buttonStage = MobileBy.id("stage_field");
    private static final By buttonProbability = MobileBy.id("probability_field");
    private static final By buttonCloseDate = MobileBy.id("date_field");
    private static final By buttonAccount = MobileBy.id("account_field");
    private static final By buttonContact = MobileBy.id("contact_field");
    private static final By buttonCampaign = MobileBy.id("company_field");
    private static final By buttonNewOrderRow = MobileBy.id("new_oredr");

    private static final By fieldNotes = MobileBy.id("notes");

    private static final By pickerWheelStages = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].pickers()[0].wheels()");
    private static final By pickerWheelMonth = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[0]");
    private static final By pickerWheelDay = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[1]");
    private static final By pickerWheelYear = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].pickers()[0].wheels()[2]");
    private static final By labelProduct = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6].staticTexts()[0]");

    public static void clickLabelProduct() {
        find(labelProduct).click();
    }

    public static void selectMonth(String month) {
        find(pickerWheelMonth).sendKeys(month);
    }

    public static void selectDay(String day) {
        find(pickerWheelDay).sendKeys(day);
    }

    public static void selectYear(String year) {
        find(pickerWheelYear).sendKeys(year);
    }

    public static String getDescription() {
        return getText(fieldDescription);
    }

    public static String getLabelNewOrderRow() {
        return getText(buttonNewOrderRow);
    }

    public static String getLabelUser() {
        return findElements(labels).get(0).getText();
    }

    public static void clickUser() {
        find(buttonUser).click();
    }

    public static String getUser() {
        return findElements(values).get(0).getText();
    }

    public static void clickStage() {
        find(buttonStage).click();
        waitByThread(1000);
    }

    public static String getLabelStage() {
        return findElements(labels).get(1).getText();
}

    public static String getStage() {
        return findElements(values).get(1).getText();
    }

    public static String getLabelProbability() {
        return findElements(labels).get(2).getText();
    }

    public static void clickProbability() {
        WebElement el = find(buttonProbability);
        el.click();
        By clear = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].staticTexts()[1]");
        find(clear).click();
    }

    public static String getProbability() {
        return getText(probability);
    }

    public static void clickCloseDate() {
        find(buttonCloseDate).click();
    }

    public static String getLabelCloseDate() {
        return findElements(labels).get(3).getText();
    }

    public static String getCloseDate() {
        return findElements(values).get(2).getText();
    }

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static String getLabelAccount() {
        return findElements(labels).get(4).getText();
    }

    public static String getAccount() {
        return findElements(values).get(3).getText();
    }

    public static void clickContact() {
        find(buttonContact).click();
    }

    public static String getLabelContact() {
        return findElements(labels).get(5).getText();
    }

    public static String getContact() {
        return findElements(values).get(4).getText();
    }

    public static void clickCampaign() {
        find(buttonCampaign).click();
    }

    public static String getLabelCampaign() {
        return findElements(labels).get(6).getText();
    }

    public static String getCampaign() {
        return findElements(values).get(5).getText();
    }

    public static String getLabelOrdersRow() {
        return findElements(titles).get(1).getText();
    }

    public static void clickNewOrderRow() {
        find(buttonNewOrderRow).click();
    }

    public static String getLabelOtherInfo() {
        scrollToLabel("Other");
        return findElements(titles).get(2).getText();
    }

    public static void typeIntoNotes(String note) {
        scrollToLabel("Notes");
        sendValues(note, fieldNotes);
    }

    public static String getLabelNotes() {
        return findElements(labels).get(7).getText();
    }

    public static void enterDescription(String description) {
        AndroidElement element = (AndroidElement) find(fieldDescription);
        element.click();
        element.clear();
        element.sendKeys(description);
    }

    public static String getAllStages() {
        String string = "";
        List<WebElement> stages = getDriver().findElements(listStages);
        for (int i = 0, k = stages.size(); i < k; i++) {
            string += stages.get(i).getText();
            if (i < k - 1)
                string += ", ";
        }
        return string;
    }

//    public static void spinWheelToTheStage(String value) {
////        find(pickerWheelStages).sendKeys(value);
//        spinWheel(value, pickerWheelStages, cellIndexStage);
//    }
//
//    public static void selectUser(String user) {
////        find(pickerWheelUsers).sendKeys(user);
//        spinWheel(user, pickerWheelUsers, cellIndexUsers);
//    }
//
//    public static void spinWheelToTheContact(String contact) {
//        spinWheel(contact, pickerWheelContacts, cellIndexContact);
//    }

    public static void setOpportunityName() {
        opportunityName = generateName(namePrefix);
    }

    public static String getOpportunityName() {
        return opportunityName;
    }
}


