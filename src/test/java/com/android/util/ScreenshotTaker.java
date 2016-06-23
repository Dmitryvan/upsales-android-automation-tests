package com.android.util;

import com.android.tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTaker extends BaseTest implements ITestListener {

    private static File failedTestsResultsDir = new File("target/failedTestsScreenshots");
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");

    public static void takeScreenShot(String filename) {
        if (BaseTest.driver != null) {
            try {
                File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile,
                        new File(failedTestsResultsDir.getAbsolutePath(), filename));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver is null");
        }
    }

    @Override()
    public void onTestFailure(ITestResult result) {
        String filename = result.getName().trim() + dateFormat.format(new Date()) + ".png";
        takeScreenShot(filename);
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
