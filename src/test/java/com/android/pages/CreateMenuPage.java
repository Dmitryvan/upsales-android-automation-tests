package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class CreateMenuPage extends BasePage {

    private static final By buttonActivity = MobileBy.IosUIAutomation(
            ".popover().tableViews()[0].cells()[1].staticTexts()[1]");

    public static void clickActivity() {
        find(buttonActivity).click();
    }
}
