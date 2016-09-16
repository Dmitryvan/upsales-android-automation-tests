package com.android.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpportunitiesPage extends BasePage {

    private final static By tableOpportunitiesCells = MobileBy.id("swipe_layout");
    private static final By firstOppName = MobileBy.id("name");
    private static final By firstOppCell = MobileBy.id("swipe_layout");

    private static final String elementPathStart = "//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[";
    private static final String activityDatePathEnd = "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    private static final String activityNamePathEnd = "]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]";


    public static void clickFirstOppCell() {
        find(firstOppCell).click();
    }

    public static String getFirstOppName() {
        wait(firstOppName);
        return getText(firstOppName);
    }

    public static boolean searchOpportunity(String opportunity, String date) {
        int counter = 0;
        int lastValue;
        int cellHeight;
        int windowHeight = getDriver().manage().window().getSize().getWidth();
        String oppName;
        String oppDate;

        List<WebElement> list = getDriver().findElements(MobileBy.id("name"));
        for (WebElement aList : list) {
            if(aList.getText().equals(opportunity))
                return true;
        }
        lastValue = list.size();

        String previousDate = getTextByPath(elementPathStart, lastValue, activityDatePathEnd);
        String previousOpp = getTextByPath(elementPathStart, lastValue, activityNamePathEnd);

        AndroidElement el = (AndroidElement) find(MobileBy.id("activity_item"));
        cellHeight = el.getSize().height + 2;
        do {
            ((MobileDriver)getDriver()).swipe(0, windowHeight, 0, windowHeight - cellHeight, 500);
            try{ Thread.sleep(500); } catch (Exception e) {}
            try {
                try {
                    oppDate = getTextByPath(elementPathStart, (lastValue + 1), activityDatePathEnd);
                    oppName = getTextByPath(elementPathStart, (lastValue + 1), activityNamePathEnd);
                }
                catch (Exception e) {
                    oppDate = getTextByPath(elementPathStart, lastValue, activityDatePathEnd);
                    oppName = getTextByPath(elementPathStart, lastValue, activityNamePathEnd);
                }
                if (oppName.equals(previousOpp)) {
                    counter++;
                    continue;
                } else {
                    counter = 0;
                }
                if (oppName.equals(opportunity) && oppDate.contains(date)) {
                    return true;
                }
                previousDate = oppDate;
                previousOpp = oppName;
            } catch (Exception e) {
                break;
            }
        } while (counter < 2);
        return false;
    }

    public static int countOpportunities() {
        waitByThread(2000);
        return getTableSize(tableOpportunitiesCells);
    }
}
