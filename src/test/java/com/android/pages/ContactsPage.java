package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class ContactsPage extends BasePage {

    private final static By tableContactCells = MobileBy.IosUIAutomation(".tableViews()[0].cells()");
    private static final By fieldSearch = MobileBy.id("search");
    private static final By labelFirstSearchResult = MobileBy.xpath("//*[contains(@resource-id, 'text_container')]//*[contains(@resource-id, 'header_title')]");

    public static void search(String value) {
//        IOSElement element = (IOSElement) find(fieldSearch);
//        element.setValue(value);
        sendValues(value, fieldSearch);
    }

    public static String getFirstSearchResult() {
        return getText(labelFirstSearchResult);
    }

    public static void clickSearch() {
        find(fieldSearch).click();
    }

    public static boolean searchContactThroughAllCells(String contact) {
        for(int i = 0; i < getTableSize(tableContactCells); i++) {
            String contactName = find(MobileBy.IosUIAutomation(
                    ".tableViews()[0].cells()[" + i + "].staticTexts()[0]")).getAttribute("value");
            if(contactName.equals(contact)) {
                return true;
            }
        }
        return false;
    }

    public static void selectContact(String contact) {
        find(MobileBy.IosUIAutomation(
                ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[0].label=='" + contact + "'\")")).click();
    }
}
