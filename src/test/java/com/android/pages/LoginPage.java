package com.android.pages;

import com.android.util.PropertyLoader;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    private static final String pathToProperty = "src/test/resources/app.properties";
    private static final String login = PropertyLoader.loadProperty(pathToProperty, "login");
    private static final String password = PropertyLoader.loadProperty(pathToProperty, "password");

    private static final By fieldEmail = MobileBy.id("email");
    private static final By fieldPassword = MobileBy.id("password");
    private static final By buttonLogin =  MobileBy.id("login");
    private static final By labelIncorrectLogin = MobileBy.id("text");
//    private static final By buttonContinue = MobileBy.IosUIAutomation(".buttons()[\"Continue\"]");

    private static final String lastLoginLetter = PropertyLoader.loadProperty("src/test/resources/app.properties", "lastLoginLetter");

//    public static void clickContinue() {
//        find(buttonContinue).click();
//    }

    public static void enterEmail(String email) {
        wait(fieldEmail);
        find(fieldEmail).sendKeys(email + "m");
//        IOSElement element = (IOSElement) find(fieldEmail);
//        element.setValue(email);
//        element.sendKeys(lastLoginLetter);
    }

    public static void enterPassword(String password) {
//        IOSElement element = (IOSElement) find(fieldPassword);
//        element.setValue(password);
        find(fieldPassword).sendKeys(password);
    }

    public static void clickLogin() {
        find(buttonLogin).click();
    }

    public static boolean checkPasswordFieldHasDefaultValue() {
        return getText(fieldPassword).equals("");
    }

    public static boolean checkLoginFieldHasDefaultValue() {
        return getText(fieldEmail).equals("E-mail");
    }

    public static String getLabelIncorrectLogin() {
        return getText(labelIncorrectLogin);
    }

    public static boolean checkLoginButtonEnabled() {
        return find(buttonLogin).isEnabled();
    }

    public static boolean checkLoginButton() {
        return find(buttonLogin).isDisplayed();
    }

    public static void clearLoginField() {
        find(fieldEmail).clear();
    }

    public static void clearPasswordField() {
        find(fieldPassword).clear();
    }

    public static void login() {
//        LoginPage.clickContinue();
        LoginPage.enterEmail(login);
        LoginPage.enterPassword(password);
        LoginPage.clickLogin();
    }
}
