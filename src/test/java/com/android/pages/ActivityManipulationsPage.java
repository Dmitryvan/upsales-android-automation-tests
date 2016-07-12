package com.android.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActivityManipulationsPage extends BasePage {

    private static String description;
    private static final String descriptionNamePrefix = "act_";

    private static final By fieldDescription = MobileBy.xpath("//TextInputLayout[1]/android.widget.EditText[1]");
    private static final By buttonActivityType = MobileBy.id("item_select");
    private static final By listActvityType = MobileBy.id("text1");
    private static final By buttonDueDate = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='2']");
    private static final By pickerFirstField = MobileBy.xpath("//android.widget.NumberPicker[1]/android.widget.EditText[1]");
    private static final By pickerSecondField = MobileBy.xpath("//android.widget.NumberPicker[2]/android.widget.EditText[1]");
    private static final By pickerThirdField = MobileBy.xpath("//android.widget.NumberPicker[3]/android.widget.EditText[1]");
    private static final By pickerDone = MobileBy.id("button1");
    private static final By buttonTime = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='3']");
    private static final By pickerWheelTimeHours = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[0]");
    private static final By pickerWheelTimeMinutes = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[1]");
    private static final By pickerWheelTimeAmPm = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].pickers()[0].wheels()[2]");
    private static final By buttonAccount = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='6']");
    private static final By buttonContact = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='8']");
    private static final By buttonOpportunity = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='10']");
    private static final By buttonUser = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='12'");
    private static final By buttonCampaign = MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='15']");
    private static final By fieldNotes = MobileBy.id("notes");
    private static final By activityType = MobileBy.id("values");
    private static final By labelDueDate = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
    private static final By time = MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By account = MobileBy.xpath("//android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By contact = MobileBy.xpath("//android.widget.RelativeLayout[5]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By opportunity = MobileBy.xpath("//android.widget.RelativeLayout[6]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By user = MobileBy.xpath("//android.widget.RelativeLayout[7]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By campaign = MobileBy.xpath("//android.widget.RelativeLayout[8]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By defaultLabelDescription = MobileBy.id("title_container");
    private static final By date = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By labelAccount = MobileBy.xpath("//android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By labelTime = MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By labelContact = MobileBy.xpath("//android.widget.RelativeLayout[5]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By labelOpportunity = MobileBy.xpath("//android.widget.RelativeLayout[6]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By labelUser = MobileBy.xpath("//android.widget.RelativeLayout[7]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By labelCampaign = MobileBy.xpath("//android.widget.RelativeLayout[8]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By labelNotes = MobileBy.xpath("//android.widget.RelativeLayout[9]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
    private static final By labelOtherInfo = MobileBy.xpath("//android.widget.RelativeLayout[9]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By customFieldWheelEttTill = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11]");
    private static final By customFieldPickerWheel = MobileBy.IosUIAutomation(".tableViews()[0].cells()[12].pickers()[0].wheels()[0]");
    private static final By customFieldEttTillValue = MobileBy.IosUIAutomation(".tableViews()[0].cells()[11].staticTexts()[0]");

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

    public static String getLabelCampaign() {
        return getText(labelCampaign);
    }

    public static String getLabelOtherInfo() {
        return getText(labelOtherInfo);
    }

    public static String getLabelNotes() {
        return getText(labelNotes);
    }

    public static String getLabelAccount() {
        return getText(labelAccount);
    }

    public static String getLabelUser() {
        return getText(labelUser);
    }

    public static String getLabelOpportunity() {
        return getText(labelOpportunity);
    }

    public static String getLabelTime() {
        return getText(labelTime);
    }

    public static String getLabelContact() {
        return getText(labelContact);
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

    public static void enterDescription (String description) {
        AndroidElement element = (AndroidElement) find(fieldDescription);
        element.click();
        element.clear();
        element.sendKeys(description);
        ((AppiumDriver) getDriver()).hideKeyboard();
    }

    public static void clickActivityType() {
        find(buttonActivityType).click();
    }

    public static void closeActivityTypeList() {
        try {
            ((AndroidDriver) getDriver()).tap(1, 100, 100, 1);
        } catch (WebDriverException e) {}
    }

    public static void selectActivityType(String value) {
        find(MobileBy.xpath(
                "//*[@class='android.widget.CheckedTextView' and @text='" +
                        value + "']")).click();
    }

    public static void selectOpportunity(String value) {
        find(MobileBy.xpath(
                "//*[@class='android.widget.CheckBox' and @text='" +
                        value + "']")).click();
    }

    public static void clickDueDate() {
        find(buttonDueDate).click();
    }

    public static void closePicker() {
        find(pickerDone).click();
    }

    public static void selectDueDateMonth(String month) {
        WebElement el = find(pickerFirstField);
        el.click();
        el.sendKeys(month);
    }

    public static void selectDueDateDay(String day) {
        find(pickerSecondField).sendKeys(day);
    }

    public static void selectDueDateYear(String year) {
        find(pickerThirdField).sendKeys(year);
    }

    public static void clickTime() {
        find(buttonTime).click();
    }

    public static void selectTimeHours(String hours) {
        find(pickerFirstField).sendKeys(hours);
    }

    public static void selectTimeMinutes(String minutes) {
        find(pickerSecondField).sendKeys(minutes);
    }

    public static void selectTimeAmPm(String aMpM) {
        find(pickerThirdField).sendKeys(aMpM);
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

    public static void scrollToOtherInfo(String text) {
        ((AndroidDriver)getDriver()).scrollTo(text);
    }

    public static String getActivityType() {
        return getText(activityType);
    }

    public static String getLabelDueDate() {
        return getText(labelDueDate);
    }

    public static String getTime() {
        return getText(time);
    }

    public static String getAccount() {
        return getText(account);
    }

    public static String getContact() {
        return getText(contact);
    }

    public static String getOpportunity() {
        return getText(opportunity);
    }

    public static String getUser() {
        return getText(user);
    }

    public static String getCampaign() {
        return getText(campaign);
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