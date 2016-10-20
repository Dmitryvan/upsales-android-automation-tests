package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SalesPage extends BasePage {

    private static final By tabPipeline = MobileBy.id("pipeline");
    private static final By labelTabPipeline = MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By labelTabSales = MobileBy.xpath("//android.support.v4.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    private static final By labelSalesTotal = MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
    private static final By labelTotalSalesValue = MobileBy.id("salesTotal");
    private static final By labelSalesOnDiagram = MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]");
    private static final By labelQuotaLeftOnDiagram = MobileBy.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]");
    private static final By tableSalesPerUserCells = MobileBy.id("avatarImg");
    private static final By tableSalesFirstRow = MobileBy.id("nameTxt");
    private static final By labelOrdersCount = MobileBy.id("orderNum");
    private static final By labelAverageValueNums = MobileBy.id("averageValue");
    private static final By labelSumOfLisaSales = MobileBy.IosUIAutomation(".tableViews()[0].groups()[5].staticTexts()[1]");
    private static final By visibleOrders = MobileBy.id("companyTxt");

    private static List<WebElement> usersSum = findElements(MobileBy.id("resultTxt"));
    private static final By labelSumOfFirstUser = MobileBy.id("resultTxt");

    private static List<WebElement> usersNames;

    public static String getLabelSalesOnDiagram() {
        return find(labelSalesOnDiagram).getText();
    }

    public static String getLabelQuotaLeftOnDiagram() {
        return find(labelQuotaLeftOnDiagram).getText();
    }

    public static String getLabelSalesTotal() {
        return find(labelSalesTotal).getText();
    }

    public static String getLabelPipelineTab() {
        return find(labelTabPipeline).getText();
    }

    public static String getLabelSalesTab() {
        return find(labelTabSales).getText();
    }

    public static int getAverageValueNumeric() {
        return getIntValue(labelAverageValueNums);
    }

    public static int countAverageValue() {
        scrollToLabel("SALES TOTAL");
        int sec = getIntValue(labelTotalSalesValue);
        int orders = getLabelOrdersNumericValue();
        float avr = (float) sec / orders;
        return Math.round(avr);
    }

    public static void clickTabPipeline() {
        find(tabPipeline).click();
    }

    public static void clickFirstUserInSalesTable() {
        find(tableSalesFirstRow).click();
    }

    public static boolean checkTableContainsOnly(String user) {
        for(int i = 0; i < getTableSize(tableSalesPerUserCells); i++) {
            String activityName = getTextByPath("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[", (i + 1), "]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
            if(!activityName.contains(user)) {
                return false;
            }
        }
        return true;
    }

    public static int getSalesPerUserCountCells() {
        wait(labelTotalSalesValue);
        swipeFromBottomToTop();
        return getTableSize(tableSalesPerUserCells);
    }

    public static int getLabelOrdersNumericValue() {
        return getIntValue(labelOrdersCount);
    }

    public static int getOrdersTableCount() {
        waitByThread(500);
        return getTableSize(tableWithSEK);
    }

    public static float getLabelSumOfFirstUser() {
        return getFloatValue(labelSumOfFirstUser);
    }

    public static int countVisibleOrders() {
        return  getTableSize(visibleOrders);
    }

    public static float getSEKNumericValueWithM() {
        return getFloatValue(labelTotalSalesValue);
    }

    public static boolean checkFirstUserSum() throws InterruptedException {
        return checkValuesSumInSales(labelSumOfFirstUser);
    }

    public static boolean checkTotalSales() {
        return checkValuesSumInSales(labelTotalSalesValue);
    }

    private static int getUserIndex(String name) {
        usersNames = findElements(MobileBy.id("nameTxt"));
        for(int i = 0, k = usersNames.size(); i < k; i++) {
            if(usersNames.get(i).getText().equals(name))
                return i;
        }
        return -1;
    }

    public static int findSumByUserName(String name) {
        usersSum = findElements(MobileBy.id("resultTxt"));
        int index = getUserIndex(name);
        return getNumberFromCell(usersSum.get(index).getText());
    }

    public static boolean verifySumForEachUser() {
        usersNames = findElements(MobileBy.id("nameTxt"));
        for (WebElement el : usersNames) {
            String name = el.getText();
            int userSum = findSumByUserName(el.getText());
            find(MobileBy.xpath("//*[@text='" + name + "']")).click();
            int count = countValuesInSales();
            find(MobileBy.xpath("//*[@text='" + name + "']")).click();
            if((userSum != count) && !name.equals("Gustav Pettersson"))
                return false;
        }
        return true;
    }

    public static void clickBackOnSales() {
        find(MobileBy.id("left_icon")).click();
    }
}
