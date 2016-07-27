package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class OpportunitiesPage extends BasePage {

    private final static By tableOpportunitiesCells = MobileBy.IosUIAutomation(".tableViews()[0].cells()");
    private static final By firstOppName = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0].staticTexts()[2]");
    private static final By firstOppCell = MobileBy.IosUIAutomation(".tableViews()[0].cells()[0]");

    public static void clickFirstOppCell() {
        find(firstOppCell).click();
    }

    public static String getFirstOppName() {
        return getValue(firstOppName);
    }

    public static boolean searchOpportunity(String activity, String date) {
        for(int i = 0; i < getTableSize(tableOpportunitiesCells); i++) {
            String opportunityName = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[2]")).getAttribute("value");
            String dateValue = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[0]")).getAttribute("value");
            if(opportunityName.equals(activity) && dateValue.equals(date)) {
                return true;
            }
        }
        return false;
    }

    public static int countOpportunities() {
        int rowCount = 0;
        for (int i = 0; i < getTableSize(tableOpportunitiesCells); i++) {
            rowCount++;
        }
        return rowCount;
    }
}
