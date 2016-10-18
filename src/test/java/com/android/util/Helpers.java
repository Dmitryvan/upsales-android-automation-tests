package com.android.util;

import com.android.pages.BasePage;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helpers {

    private static WebDriver driver;
    private static WebDriverWait driverWait;

    private static String appDefaultStartDate;
    private static String appDefaultEndDate;

    private static final String UP = "up";
    private static final String DOWN = "down";

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

    private static final By pickerYear = MobileBy.id("date_picker_year");
    private static final By wheelYear = MobileBy.id("month_text_view");

    private static final By pickerMonth = MobileBy.id("date_picker_month");
    private static final By wheelMonth = MobileBy.xpath("//*[contains(@resource-id, 'animator')]/android.widget.ListView[1]");

    protected static final By pickerSecondField = MobileBy.xpath("//android.widget.NumberPicker[2]/android.widget.EditText[1]");
    protected static final By pickerFirstField = MobileBy.xpath("//android.widget.NumberPicker[1]/android.widget.EditText[1]");
    protected static final By pickerThirdField = MobileBy.xpath("//android.widget.NumberPicker[3]/android.widget.EditText[1]");
    protected static final By pickerAmPmField = MobileBy.xpath("//android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.EditText[1]");
    protected static final By pickerOK = MobileBy.id("ok");
    protected static final By pickerTimeOK = MobileBy.id("button1");


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

    public static WebElement waitToBeClickable(By locator) {
        return driverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitToBeClickable(WebElement element) {
        return driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public static boolean checkIsDisplayed(By locator) {
        try {
            wait(locator);
            find(locator);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
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
        else if (minutes > 45){
            calendar.set(Calendar.MINUTE, 0);
            calendar.add(Calendar.HOUR, 1);
        } else {
            calendar.set(Calendar.MINUTE, 0);
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

    public static String getAppEndDate() {
        Calendar calendar = getCalendar();
        DateFormat df = new SimpleDateFormat("d MMM yyyy");
        calendar.add(Calendar.HOUR, 1);
        return df.format(calendar.getTime());
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

    private static String getYear() {
        return find(pickerYear).getText();
    }

    private static void clickYear() {
        find(pickerYear).click();
    }

    public static void closePicker() {
        try {
            find(pickerOK).click();
        } catch (NoSuchElementException e) {
            find(pickerTimeOK).click();
        }
    }

    public static void selectDateMonth(String month) {
        String currentMonth = find(pickerMonth).getText();
        DateFormat currentDateFormat = new SimpleDateFormat("MMM");
        DateFormat aimDateFormat = new SimpleDateFormat("MMMM");
        DateFormat monthInYear = new SimpleDateFormat("M");


        try {
            Date currentDate = currentDateFormat.parse(currentMonth);
            Date aimDate = aimDateFormat.parse(month);
            int currentMonthIndex = Integer.parseInt(monthInYear.format(currentDate));
            int aimMonthIndex = Integer.parseInt(monthInYear.format(aimDate));

            if (currentMonthIndex != aimMonthIndex) {
                int steps = defineSteps(currentMonthIndex, aimMonthIndex);

                String direction = defineSpinDirection(currentMonthIndex, aimMonthIndex);

                spinMonthWheel(direction, steps);
            }
        } catch (ParseException e) {}

//        while(true) {
//            MobileElement el = (MobileElement) find(wheelMonth);
//            el.swipe(SwipeElementDirection.DOWN, 5, 70, 500);
//        }
//        MobileElement el = (MobileElement) find(pickerFirstField);
//        while (!el.getText().equals(month)) {
//            el.swipe(SwipeElementDirection.UP, 500);
//            waitByThread(200);
//        }
    }

    public static void selectDateDay(String day) {
        waitByThread(200);
        find(MobileBy.xpath(
                "//*[contains(@resource-id, 'animator')]/android.widget.ListView[1]/android.view.View[1]/android.view.View["
                        + day + "]")).click();
//        MobileElement el = (MobileElement) find(pickerSecondField);
//        spinNumericField(el, day);
//        el.enterExpenses();
//        el.sendKeys(day);
    }

    public static void selectDateYear(String year) {
        int currentValue = Integer.parseInt(getYear());
        int aimValue = Integer.parseInt(year);
        int steps = defineSteps(currentValue, aimValue);
        if(currentValue != aimValue) {
            clickYear();
            String direction = defineSpinDirection(currentValue, aimValue);
            spinYearWheel(direction, steps, aimValue);
        }
//        MobileElement el = (MobileElement) find(pickerThirdField);
//        spinNumericField(el, year);
    }

    private static int defineSteps(int currentValue, int aimValue) {
        return Math.abs(currentValue - aimValue);
    }

    private static String defineSpinDirection(int current, int aim) {
        if(current < aim) {
            return UP;
        } else {
            return DOWN;
        }
    }

    private static void spinYearWheel(String direction, int steps, int aimValue) {
        MobileElement el = (MobileElement) find(wheelYear);
        for(int i = 0; i < steps; i++) {
            if (direction.equals(UP))
                el.swipe(SwipeElementDirection.UP, 500);
            else if (direction.equals(DOWN))
                el.swipe(SwipeElementDirection.DOWN, 500);
        }
        find(MobileBy.xpath("//*[contains(@resource-id, 'month_text_view') and @text='" + aimValue + "']")).click();
    }

    private static void spinMonthWheel(String direction, int steps) {
        MobileElement el = (MobileElement) find(wheelMonth);
        for(int i = 0; i < steps; i++) {
            if (direction.equals(UP)) {
                el.swipe(SwipeElementDirection.UP, 30, 50, 1000);
                waitByThread(150);
            } else if (direction.equals(DOWN)) {
                el.swipe(SwipeElementDirection.DOWN, 30, 50, 1000);
                waitByThread(150);
            }
        }
    }

    public static void selectTimeHours(String hours) {

        WebElement el = find(By.id("time_picker"));

        int xP = el.getLocation().getX();
        int yP = el.getLocation().getY();

        int x = 0, y = 0;

        TouchAction action = new TouchAction((AndroidDriver)getDriver());

        switch (hours) {
            case "1":
                x = 444; y = 244;
                break;
            case "2":
                x = 510; y = 300;
                break;
            case "3":
                x = 534; y = 393;
                break;
            case "4":
                x = 510; y = 483;
                break;
            case "5":
                x = 444; y = 549;
                break;
            case "6":
                x = 354; y = 573;
                break;
            case "7":
                x = 261; y = 549;
                break;
            case "8":
                x = 195; y = 483;
                break;
            case "9":
                x = 171; y = 393;
                break;
            case "10":
                x = 198; y = 300;
                break;
            case "11":
                x = 261; y = 244;
                break;
            case "12":
                x = 354; y = 213;
                break;
            case "13":
                x = 480; y = 174;
                break;
            case "14":
                x = 570; y = 267;
                break;
            case "15":
                x = 606; y = 393;
                break;
            case "16":
                x = 570; y = 516;
                break;
            case "17":
                x = 480; y = 609;
                break;
            case "18":
                x = 354; y = 642;
                break;
            case "19":
                x = 228; y = 609;
                break;
            case "20":
                x = 138; y = 516;
                break;
            case "21":
                x = 102; y = 393;
                break;
            case "22":
                x = 138; y = 267;
                break;
            case "23":
                x = 228; y = 174;
                break;
            case "00":
            case "24":
                x = 354; y = 141;
                break;
        }

        action.tap(xP + x, yP + y).release().perform();

//        find(MobileBy.xpath(
//                "//android.widget.RadialTimePickerView.RadialPickerTouchHelper["
//                        + (Integer.parseInt(hours) + 1) + "]")).click();
////        MobileElement el = (MobileElement) find(pickerFirstField);
////        spinNumericField(el, hours);
////        el.enterExpenses();
////        el.sendKeys(hours);
    }

    public static void selectTimeMinutes(String minutes) {
        WebElement el = find(By.id("time_picker"));

        int xP = el.getLocation().getX();
        int yP = el.getLocation().getY();

        int x = 0, y = 0;

        TouchAction action = new TouchAction((AndroidDriver)getDriver());

        switch (minutes) {
            case "00":
                x = 354; y = 141;
                break;
            case "15":
                x = 606; y = 393;
                break;
            case "30":
                x = 354; y = 642;
                break;
            case "45":
                x = 102; y = 393;
                break;
        }

        action.tap(xP + x, yP + y).release().perform();
//        find(MobileBy.xpath(
//                "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[contains(@content-desc, '"
//                        + minutes + "')]")).click();
////        MobileElement el = (MobileElement) find(pickerSecondField);
////        spinNumericField(el, minutes);
////        el.enterExpenses();
////        el.sendKeys(minutes);
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

    protected static void clearAndType(String text, By locator) {
        WebElement element = find(locator);
        element.click();
        clearField(element);
        element.sendKeys(text);
        hideKeyboard();
    }

    public static void clearField(WebElement element) {
        int textLength = element.getText().length();
        if(textLength != 0) {
            waitToBeClickable(element);
            element.click();
            for (int i = 0, j = textLength + 1; i < j; i++) {
                ((AndroidDriver) getDriver()).pressKeyCode(BasePage.DELETE_KEYCODE);
            }
        }
    }
}