package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class PipelinePage extends BasePage {

    private static final By buttonFilter = MobileBy.IosUIAutomation(".navigationBars()[0].buttons()[2]");
    private static final By tabSales = MobileBy.id(
            "sales");
    private static final By tableStages = MobileBy.IosUIAutomation(".tableViews()[0].groups()");
    private static final By tableFallback = MobileBy.IosUIAutomation(".tableViews()[0].cells()");

    private static final By labelFallback = MobileBy.IosUIAutomation(".tableViews()[0].groups()[0].staticTexts()[0]");
    private static final By labelFallbackCount = MobileBy.IosUIAutomation(".tableViews()[0].groups()[0].staticTexts()[1]");
    private static final By labelFallbackSum = MobileBy.IosUIAutomation(".tableViews()[0].groups()[0].staticTexts()[2]");
    private static final By labelProspect1 = MobileBy.IosUIAutomation(".tableViews()[0].groups()[1].staticTexts()[0]");
    private static final By labelProspect1Count = MobileBy.IosUIAutomation(".tableViews()[0].groups()[1].staticTexts()[1]");
    private static final By labelProspect1Sum = MobileBy.IosUIAutomation(".tableViews()[0].groups()[1].staticTexts()[2]");
    private static final By labelProspect2 = MobileBy.IosUIAutomation(".tableViews()[0].groups()[2].staticTexts()[0]");
    private static final By labelProspect2Count = MobileBy.IosUIAutomation(".tableViews()[0].groups()[2].staticTexts()[1]");
    private static final By labelProspect2Sum = MobileBy.IosUIAutomation(".tableViews()[0].groups()[2].staticTexts()[2]");
    private static final By labelMuntlig = MobileBy.IosUIAutomation(".tableViews()[0].groups()[3].staticTexts()[0]");
    private static final By labelMuntligCount = MobileBy.IosUIAutomation(".tableViews()[0].groups()[3].staticTexts()[1]");
    private static final By labelMuntligSum = MobileBy.IosUIAutomation(".tableViews()[0].groups()[3].staticTexts()[2]");
    private static final By pipelineTotalValue = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[1]");
    private static final By weightedWidgetValue = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[2]");
    private static final By averageWidgetValue = MobileBy.IosUIAutomation(".tableViews()[0].staticTexts()[5]");

    public static void clickTabSales() {
        find(tabSales).click();
    }

    public static void clickFilter() {
        find(buttonFilter).click();
    }

    public static void clickFallback() {
        find(labelFallback).click();
    }

    public static void clickProspect1() {
        find(labelProspect1).click();
    }

    public static void clickProspect2() {
        find(labelProspect2).click();
    }

    public static void clickMuntlig() {
        find(labelMuntlig).click();
    }

    public static String getFallbackLabelValue() {
        return getValue(labelFallback);
    }

    public static int getFallbackCountValue() {
        return getIntValue(labelFallbackCount);
    }

    public static int getFallbackSumValue() {
        return getIntValue(labelFallbackSum);
    }

    public static String getProspect1LabelValue() {
        return getValue(labelProspect1);
    }

    public static int getProspect1CountValue() {
        return getIntValue(labelProspect1Count);
    }

    public static float getProspect1SumValue() {
        return getFloatValue(labelProspect1Sum);
    }

    public static String getProspect2LabelValue() {
        return getValue(labelProspect2);
    }

    public static int getProspect2CountValue() {
        return getIntValue(labelProspect2Count);
    }

    public static int getProspect2SumValue() {
        return Integer.parseInt(getValue(labelProspect2Sum));
    }

    public static String getMuntligLabelValue() {
        return getValue(labelMuntlig);
    }

    public static int getMuntligCountValue() {
        return getIntValue(labelMuntligCount);
    }

    public static int getMuntligSumValue() {
        return Integer.parseInt(getValue(labelMuntligSum));
    }

    public static boolean checkStagesTableContainsOnly(String stage) {
        for(int i = 0; i < getTableSize(tableStages); i++) {
            String stageLabel = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].groups()[" + i + "].staticTexts()[0]")).getAttribute("value");
            if(!stage.equals(stageLabel))
                return false;
        }
        return true;
    }

    public static boolean checkOpportunitiesTableContainsOnly(String userName) {
        for(int i = 0; i < getTableSize(tableFallback); i++) {
            String userLabel = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[1]")).getAttribute("value");
            if(!userLabel.contains(userName))
                return false;
        }
        return true;
    }

    public static float getTotalPipelineValue() {
        return getFloatValue(pipelineTotalValue);
    }

    public static float getWeightedWidgetValue() {
        return getFloatValue(weightedWidgetValue);
    }

    public static int getAverageWidgetValue() {
        return getIntValue(averageWidgetValue);
    }

    public static int getTableStagesSize() {
        return getTableSize(tableStages);
    }

    public static boolean checkProspect1Sum() {
        return checkValuesSum(labelProspect1Sum);
    }
}