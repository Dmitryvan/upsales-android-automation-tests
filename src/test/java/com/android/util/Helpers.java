package com.android.util;

import com.android.pages.BasePage;
import com.android.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.SwipeElementDirection;
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

    private static final String charList = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ1234567890";
    private static final int randomStringLength = 8;

    public static final By keyboard = MobileBy.xpath("//UIAKeyboard[1]");
    private static final By clearOnKeyboard = MobileBy.IosUIAutomation("target.frontMostApp().keyboard().keys()[12]");

    private static final By alertNo = MobileBy.id("no");
    private static final By alertYes = MobileBy.id("yes");

    public static void init(AppiumDriver webDriver) {
        driver = webDriver;
        int timeoutInSeconds = 30;
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
            find(locator).isDisplayed();
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
        return ("TODAY " + calendarDateFormat.format(date).toUpperCase());
    }

    public static String expectedDateInFormsAndMail() {
        Calendar calendar = getCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, - 4);
        return formAndMailDateFormat.format(calendar.getTime());
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

    public static int countValuesWithSEKandM() {
        int total = 0;

        List<WebElement> list = getDriver().findElements(tableWithSEK);

        for (int i = 0, k = list.size() ; i < k; i++) {
            total = total + getNumberFromCell(list.get(i).getText());
        }
        return total;
    }

    public static boolean checkValuesSum(By numberLocator) {
        int count = countValuesWithSEKandM();
        int sum = getNumberFromCell(BasePage.getText(numberLocator));
        if (sum >= 1000000) {
            count = (int) (Math.round((double) count / 100000)) * 100000;
        }
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

    public static void clickDoneOnKeyboard() {
        find(buttonDoneOnKeyboard).click();
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

    public static void spinWheel(String value, By wheel, String cellIndex) {
        String yOffset;

        String st = find(wheel).getAttribute("values");
        st = st.substring(1, st.length() - 1);
//        System.out.println(st);
        ArrayList<String> values = new ArrayList<>(Arrays.asList(st.split(", ")));

        String currentValue = find(wheel).getAttribute("value");

        int indexOfCurrentValue = values.indexOf(currentValue);
        int indexOfTargetValue = values.indexOf(value);
        int stepsAmount = Math.abs(indexOfTargetValue - indexOfCurrentValue);

        if (indexOfTargetValue > indexOfCurrentValue) {
            yOffset = offsetDown;
        } else {
            yOffset = offsetUp;
        }

        for (int i = 0; i < stepsAmount; i++) {
            ((JavascriptExecutor) getDriver()).executeScript(
                    "au.mainWindow().tableViews()[0].cells()[" + cellIndex +
                            "].pickers()[0].wheels()[0].tapWithOptions({tapOffset:{x:0.05, y:" + yOffset + "}});"
            );
        }
    }

    protected static int getTableSize(By elementPath) {
        List<WebElement> list = getDriver().findElements(elementPath);
//        System.out.println(list.size());
//        System.out.println(activity);
//        byte[] b = activity.getBytes("UTF-8");
//        for (byte bb : b) {
//            System.out.print(bb + " ");
//        }
//        System.out.println();
        return list.size();
    }

    protected static List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }
}