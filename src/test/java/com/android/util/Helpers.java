package com.android.util;

import com.android.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helpers {

    private static WebDriver driver;
    private static WebDriverWait driverWait;

    private static String appDefaultStartDate;
    private static String appDefaultEndDate;

    private static final String pathToProperty = "src/test/resources/app.properties";
    private static final String login = PropertyLoader.loadProperty(pathToProperty, "login");
    private static final String password = PropertyLoader.loadProperty(pathToProperty, "password");

    public static final By tableWithSEK = MobileBy.id("salesTxt");

    private static final By buttonDoneOnKeyboard = MobileBy.IosUIAutomation("target.frontMostApp().windows()[1].toolbars()[0].buttons()[\"Done\"]");

    private static final String offsetDown = "0.63";
    private static final String offsetUp = "0.35";

    private static final DateFormat nameDateFormat = new SimpleDateFormat("MMdd_HHmm");
    private static final DateFormat appDateFormat = new SimpleDateFormat("d MMM YYYY HH:mm");
    private static final DateFormat appDateFormatWithDoW = new SimpleDateFormat("EEEE d MMM YYYY HH:mm");
    private static final DateFormat calendarDateFormat = new SimpleDateFormat("EEEE d MMM YYYY");
    protected static final DateFormat formAndMailDateFormat = new SimpleDateFormat("YYYY-MM-dd");

    protected static final By pickerSecondField = MobileBy.xpath("//android.widget.NumberPicker[2]/android.widget.EditText[1]");
    protected static final By pickerFirstField = MobileBy.xpath("//android.widget.NumberPicker[1]/android.widget.EditText[1]");
    protected static final By pickerThirdField = MobileBy.xpath("//android.widget.NumberPicker[3]/android.widget.EditText[1]");
    protected static final By pickerAmPmField = MobileBy.xpath("//android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.EditText[1]");
    protected static final By pickerDone = MobileBy.id("button1");

    private static final String charList = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ1234567890";
    private static final int randomStringLength = 8;

    public static final By keyboard = MobileBy.xpath("//UIAKeyboard[1]");
    private static final By clearOnKeyboard = MobileBy.IosUIAutomation("target.frontMostApp().keyboard().keys()[12]");

    private static final By alertNo = MobileBy.id("no");
    private static final By alertYes = MobileBy.id("yes");

    public static void init(AppiumDriver webDriver) {
        driver = webDriver;
        int timeoutInSeconds = 60;
        driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebElement wait(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement wait(WebElement element) {
        return driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public static boolean checkIsDisplayed(By locator) {
        try {
            find(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//*
// work with Date and Time
//*

    protected static Calendar getCalendar() {
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    protected static void waitByThread(int duration) {
        try {
            Thread.sleep(duration);
        } catch (Exception e) {}
    }

    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy", Locale.ENGLISH);
        return sdf.format(date);
    }

    public static String getCurrentMonth() {
        DateFormat df = new SimpleDateFormat("MMMM");
        Date date = new Date();
        return df.format(date);
    }

    public static String getCurrentQuarter() {
        return "Q" + (getCalendar().get(Calendar.MONTH)/3 + 1);
    }

    public static String getCurrentYear() {
        int year = getCalendar().get(Calendar.YEAR);
        return Integer.toString(year);
    }

    public static String dateLabelValue(String month, String day, String year) {
        String trimmedMonth = month.substring(0, 3);
        return (day + " " + trimmedMonth + " " + year);
    }

    public static String timeLabelValue(String hours, String minutes, String aMpM) {
        int intHours = Integer.parseInt(hours);

        if(aMpM.equals("AM") && intHours < 10)
            return ("0" + hours + ":" + minutes);
        else if(aMpM.equals("AM") && intHours >= 10)
            return (hours + ":" + minutes);
        else
            return ((intHours + 12) + ":" + minutes);
    }

    private static String generateDate() {
        Date date = new Date();
        return nameDateFormat.format(date);
    }

    public static void setDefaultAppStartEndDates() {
        appDefaultStartDate =  appDateFormat.format(minutesRounding().getTime());

        Calendar calendar = minutesRounding();
        calendar.add(Calendar.HOUR, 1);
        appDefaultEndDate = appDateFormat.format(calendar.getTime());
    }

    public static String getDefaultAppStartDate() {
        return appDefaultStartDate;
    }

    public static String getDefaultAppEndDate() {
        return appDefaultEndDate;
    }

    private static Calendar minutesRounding() {
        int minutes;
        Calendar calendar = getCalendar();
        minutes = calendar.get(Calendar.MINUTE);

        if (minutes > 0 && minutes <= 15)
            calendar.set(Calendar.MINUTE, 15);
        else if (minutes > 15 && minutes <= 30)
            calendar.set(Calendar.MINUTE, 30);
        else if (minutes > 30 && minutes <= 45)
            calendar.set(Calendar.MINUTE, 45);
        else {
            calendar.set(Calendar.MINUTE, 0);
            calendar.add(Calendar.HOUR, 1);
        }
        return calendar;
    }

    public static String appStartDateWithDoW() {
        return appDateFormatWithDoW.format(minutesRounding().getTime());
    }

    public static String appEndDateWithDoW() {
        Calendar calendar = minutesRounding();
        calendar.add(Calendar.HOUR, 1);
        return appDateFormatWithDoW.format(calendar.getTime());
    }

    public static String calendarTodayDate() {
        Date date = new Date();
        return ("Today " + calendarDateFormat.format(date));
    }

    public static String expectedDateInFormsAndMail() {
        Calendar calendar = getCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, - 4);
        return formAndMailDateFormat.format(calendar.getTime());
    }

//*
//work with date&time wheels
//*

    public static void closePicker() {
        find(pickerDone).click();
    }

    public static void selectDateMonth(String month) {
        MobileElement el = (MobileElement) find(pickerFirstField);
        while (!el.getText().equals(month)) {
            el.swipe(SwipeElementDirection.UP, 500);
            waitByThread(200);
        }
//        el.enterExpenses();
//        el.sendKeys(month);
    }

    public static void selectDateDay(String day) {
        MobileElement el = (MobileElement) find(pickerSecondField);
        spinNumericField(el, day);
//        el.enterExpenses();
//        el.sendKeys(day);
    }

    public static void selectDateYear(String year) {
        MobileElement el = (MobileElement) find(pickerThirdField);
        spinNumericField(el, year);
//        el.enterExpenses();
//        el.sendKeys(year);
//        hideKeyboard();
    }

    public static void selectTimeHours(String hours) {
        MobileElement el = (MobileElement) find(pickerFirstField);
        spinNumericField(el, hours);
//        el.enterExpenses();
//        el.sendKeys(hours);
    }

    public static void selectTimeMinutes(String minutes) {
        MobileElement el = (MobileElement) find(pickerSecondField);
        spinNumericField(el, minutes);
//        el.enterExpenses();
//        el.sendKeys(minutes);
    }

    public static void selectTimeAmPm(String aMpM) {
        MobileElement el = (MobileElement) find(pickerAmPmField);
        String currentValue = el.getText().toLowerCase();
        if (currentValue.startsWith("a") && aMpM.toLowerCase().startsWith("p"))
            el.swipe(SwipeElementDirection.UP, 500);
        else if (currentValue.startsWith("p") && aMpM.toLowerCase().startsWith("a"))
            el.swipe(SwipeElementDirection.DOWN, 500);
//        el.enterExpenses();
//        el.sendKeys(aMpM);
//        hideKeyboard();
    }

    protected static void spinNumericField(MobileElement el, String value) {
        int currentValue = Integer.parseInt(el.getText());
        int aimValue = Integer.parseInt(value);
        while (currentValue != aimValue) {
            if (currentValue < aimValue) {
                el.swipe(SwipeElementDirection.UP, 500);
            } else {
                el.swipe(SwipeElementDirection.DOWN, 500);
            }
            waitByThread(200);
            currentValue = Integer.parseInt(el.getText());
        }
    }

//*
// work with Strings
//*

    protected static float[] stringToFloatArrayConverter(String[] values) {
        float[] tempArr = new float[values.length];
        for(int i = 0; i < values.length; i++) {
            values[i] = values[i].replaceAll("[^0-9.]", "");
            tempArr[i] = Float.parseFloat(values[i]);
        }
        return tempArr;
    }

    protected static String trimFirstTwoChars(String stringToTrim) {
        return stringToTrim.substring(2, stringToTrim.length());
    }

    protected static String trimFirstFourChars(String stringToTrim) {
        return stringToTrim.substring(4, stringToTrim.length());
    }

    protected static String deleteSpaces(String s) {
        return s.replaceAll(" ", "");
    }

//*
// work with numbers
//*

    public static int getNumberFromCell(String number) {
        if (number.contains("M")) {
            if (number.length() > 2) {
                return Integer.parseInt(number.replaceAll("[^0-9]", "").concat("00000"));
            } else {
                return Integer.parseInt(number.replaceAll("[^0-9]", "").concat("000000"));
            }
        } else {
            return Integer.parseInt(number.replaceAll("[^0-9]", ""));
        }
    }

    public static int countValuesInSales() {
        int total = 0;

        List<WebElement> list = getDriver().findElements(tableWithSEK);

        for (int i = 0, k = list.size() ; i < k; i++) {
            total = total + getNumberFromCell(list.get(i).getText());
        }
        return total;
    }

    public static int countValuesInStages() throws InterruptedException {
        int total = 0;
        int iterator = 0;
        List<WebElement> list = getDriver().findElements(tableWithSEK);
        for (WebElement aList : list) {
            total = total + getNumberFromCell(aList.getText());
            iterator++;
        }
        int lastValue = iterator + 2;
        String previousCampaign = find(MobileBy.xpath(
                "//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[" +
                        lastValue +
                        "]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).getText();
        while(true) {
            AndroidElement el = (AndroidElement) find(MobileBy.xpath(
                    "//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[" +
                            (iterator - 3) + "]/android.widget.RelativeLayout[1]"));
            el.swipe(SwipeElementDirection.UP, 500);
            Thread.sleep(500);
            try {
                String account = find(MobileBy.xpath(
                        "//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[" +
                                lastValue +
                                "]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).getText();
                if(account.equals(previousCampaign)) {
                    continue;
                }
                if(account.equals("Prospect 2"))
                    break;
                String value = find(MobileBy.xpath(
                        "//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[" +
                                lastValue +
                                "]/android.widget.RelativeLayout[1]/android.widget.TextView[2]")).getText();
                total += getNumberFromCell(value);
                previousCampaign = account;
            } catch (Exception e) {
                break;
            }
        }
        return total;
    }

    public static boolean checkValuesSumInStages(By numberLocator) throws InterruptedException {
        int sum = getNumberFromCell(BasePage.getText(numberLocator));
        int count = countValuesInStages();
        if (sum >= 1000000) {
            count = (int) (Math.round((double) count / 100000)) * 100000;
        }
//        System.out.println("sum: " + sum + "\ncount: " + count);
        return sum == count;
    }

    public static boolean checkValuesSumInSales(By numberLocator) {
        int sum = getNumberFromCell(BasePage.getText(numberLocator));
        int count = countValuesInSales();
        if (sum >= 1000000) {
            count = (int) (Math.round((double) count / 100000)) * 100000;
        }
//        System.out.println("sum: " + sum + "\ncount: " + count);
        return sum == count;
    }

    public static int getIntValue(By locator) {
        String str = BasePage.getText(locator).replaceAll("[^0-9]", "");
        return Integer.parseInt(str);
    }

    public static int getIntValue(String str) {
        str = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(str);
    }

    public static float getFloatValue(By locator) {
        String str = BasePage.getText(locator).replaceAll("[^0-9.]", "");
        return Float.parseFloat(str);
    }

//*
// work with generated data
//*

    protected static String generateName(String namePrefix) {
        return namePrefix + generateDate();
    }

    public static String generateString() {
        char[] chars = charList.toCharArray();
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < randomStringLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            str.append(c);
        }
        return str.toString();
    }

//*
// work with keyboard
//*

    public static void enterValueFromKeyboard(String value) {
        for (int i = 0; i < value.length(); i++) {
            String key = value.substring(i, i + 1);
            if (key.equals(" "))
                key = "space";
            find(MobileBy.IosUIAutomation(
                    "target.frontMostApp().keyboard().keys().firstWithPredicate(\"name=='" + key + "'\")")).click();
        }
    }

    public static void hideKeyboard() {
        try {
            ((AppiumDriver) getDriver()).hideKeyboard();
        } catch (Exception e) {}
    }

    public static void clickClearOnKeyBoard() {
        find(clearOnKeyboard).click();
    }

    public static boolean checkKeyboard() {
        return checkIsDisplayed(keyboard);
    }

//*
// entity deletion methods
//*

    public static void deleteEntity(String name) {
        IOSElement element = (IOSElement) find(MobileBy.IosUIAutomation(".tableViews()[0].cells()['" + name + "']"));
        element.swipe(SwipeElementDirection.LEFT, 500);

        ((JavascriptExecutor) getDriver()).executeScript(
                "au.mainWindow().tableViews()[0].cells()['" + name + "'].tapWithOptions({tapOffset:{x:0.85, y:0.05}});");
    }

    public static void alertCancel() {
        find(alertNo).click();
    }

    public static void alertConfirm() {
        find(alertYes).click();
    }

//*
// other methods
//*

    protected static List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    public static void scrollToLabel(String text) {
        ((AndroidDriver)getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        +text+"\").instance(0))");
//        ((AndroidDriver)getDriver()).scrollTo(text);
    }

    protected static void clearAndType(String accountName, By locator) {
        find(locator).clear();
        find(locator).sendKeys(accountName);
        hideKeyboard();
    }
}