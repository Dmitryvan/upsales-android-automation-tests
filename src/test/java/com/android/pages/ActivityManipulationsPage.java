package com.android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActivityManipulationsPage extends BasePage {

    private static String description;
    private static final String descriptionNamePrefix = "act_";

    private static final By fieldDescription = MobileBy.xpath("//TextInputLayout[1]/android.widget.EditText[1]");
    private static final By buttonActivityType = MobileBy.id("activity_type_field");
    private static final By listActvityType = MobileBy.id("text1");
    private static final By buttonDueDate = MobileBy.id("date_field");

    private static final By buttonTime = MobileBy.id("time_field");
    private static final By buttonAccount = MobileBy.id("account_field");
    private static final By buttonContact = MobileBy.id("contact_field");
    private static final By buttonOpportunity = MobileBy.id("opportunity_field");
    private static final By buttonUser = MobileBy.id("user_field");
    private static final By buttonCampaign = MobileBy.id("company_field");
    private static final By fieldNotes = MobileBy.id("notes");
    private static final By defaultLabelDescription = MobileBy.id("text_input");
    private static final By labelOtherInfo = MobileBy.xpath("//android.widget.RelativeLayout[9]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By customFieldWheelEttTill = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11]");
    private static final By customFieldPickerWheel = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].pickers()[0].wheels()[0]");
    private static final By customFieldEttTillValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11].staticTexts()[0]");

    private static final List<WebElement> values = findElements(MobileBy.id("select"));
    private static final WebElement activityType = values.get(0);
    private static final WebElement date = values.get(1);
    private static final WebElement time = values.get(2);
    private static final WebElement account = values.get(3);
    private static final WebElement contact = values.get(4);
    private static final WebElement opportunity = values.get(5);
    private static final WebElement user = values.get(6);
    private static final WebElement campaign = values.get(7);

    private static final List<WebElement> labels = findElements(MobileBy.id("name"));
    private static final WebElement labelActivityType = labels.get(0);
    private static final WebElement labelDueDate = labels.get(1);
    private static final WebElement labelTime = labels.get(2);
    private static final WebElement labelAccount = labels.get(3);
    private static final WebElement labelContact = labels.get(4);
    private static final WebElement labelOpportunity = labels.get(5);
    private static final WebElement labelUser = labels.get(6);
    private static final WebElement labelCampaign = labels.get(7);
    private static final WebElement labelNotes = labels.get(8);


    public static void clickCustomFieldEttTill() {
        find(customFieldWheelEttTill).click();
    }

    public static void spinCustomWheelEttTill(String value) {
//        spinWheel(value, customFieldPickerWheel, cellIndexCustom);
        find(customFieldPickerWheel).sendKeys(value);
    }

    public static String getCustomFieldEttTill() {
        return getText(customFieldEttTillValue);
    }

    public static String getLabelActivityType() {
        return labelActivityType.getText();
    }

    public static String getLabelCampaign() {
        return labelCampaign.getText();
    }

    public static String getLabelOtherInfo() {
        return getText(labelOtherInfo);
    }

    public static String getLabelNotes() {
        return labelNotes.getText();
    }

    public static String getLabelAccount() {
        return labelAccount.getText();
    }

    public static String getLabelUser() {
        return labelUser.getText();
    }

    public static String getLabelOpportunity() {
        return labelOpportunity.getText();
    }

    public static String getLabelTime() {
        return labelTime.getText();
    }

    public static String getLabelContact() {
        return labelContact.getText();
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
        return date.getText();
    }

    public static void enterDescription (String description) {
        AndroidElement element = (AndroidElement) find(fieldDescription);
        element.click();
        element.clear();
        element.sendKeys(description);
        hideKeyboard();
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

    public static void clickAccount() {
        find(buttonAccount).click();
    }

    public static void clickContact() {
        waitByThread(1000);
        find(buttonContact).click();
    }

    public static void clickOpportunity() {
        find(buttonOpportunity).click();
    }

    public static void clickUser() {
        find(buttonUser).click();
    }

    public static void clickCampaign() {
        find(buttonCampaign).click();
    }

    public static void typeIntoNotes(String note) {
        find(fieldNotes).clear();
        find(fieldNotes).sendKeys(note);
//        hideKeyboard();
    }

    public static String getActivityType() {
        return activityType.getText();
    }

    public static String getLabelDueDate() {
        return labelDueDate.getText();
    }

    public static String getTime() {
        return time.getText();
    }

    public static String getAccount() {
        return account.getText();
    }

    public static String getContact() {
        return contact.getText();
    }

    public static String getOpportunity() {
        return opportunity.getText();
    }

    public static String getUser() {
        return user.getText();
    }

    public static String getCampaign() {
        return campaign.getText();
    }

    public static String getDefaultLabelDescription() {
        return getText(defaultLabelDescription);
    }

    public static void setDescription() {
        description = generateName(descriptionNamePrefix);
    }

    public static String getDescription() {
        return description;
    }

    public static String getNotes() {
        return getText(fieldNotes);
    }

    public static boolean getNotesStartsWith(String start) {
        return getText(fieldNotes).startsWith(start);
    }
}