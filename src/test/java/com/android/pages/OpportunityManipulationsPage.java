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

    private static final By probability = MobileBy.xpath("//*[contains(@resource-id, 'probability_field')]//*[contains(@resource-id, 'edit_field')]");

    private static final By labels = MobileBy.id("name");
    private static final By values = MobileBy.id("select");
    private static final By labelOrdersRow = MobileBy.xpath("//*[contains(@resource-id, 'order_field')]//*[contains(@resource-id, 'header_title')]");
    private static final By listStages = MobileBy.id("text1");
    private static final By labelNotes = MobileBy.xpath("//*[contains(@resource-id, 'notes_field_below')]//*[contains(@resource-id, 'name')]");

    private static final By buttonUser = MobileBy.id("sales_representative_field");
    private static final By buttonStage = MobileBy.id("stage_field");
    private static final By buttonCloseDate = MobileBy.id("date_field");
    private static final By buttonNewOrderRow = MobileBy.id("new_oredr");

    private static final By labelProduct = MobileBy.id("order_content");

    public static void clickLabelProduct() {
        find(labelProduct).click();
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
        wait(buttonStage);
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
        find(probability).click();
        find(probability).clear();
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

    public static String getLabelOrdersRow() {
        return getText(labelOrdersRow);
    }

    public static void clickNewOrderRow() {
        getDriver().getPageSource();
        find(buttonNewOrderRow).click();
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

    public static void setOpportunityName() {
        opportunityName = generateName(namePrefix);
    }

    public static String getOpportunityName() {
        return opportunityName;
    }

    public static void enterProbability(String value) {
        sendValues(value, probability);
        hideKeyboard();
    }

    public static String getLabelNotesInOppotunity() {
        return getText(labelNotes);
    }
}


