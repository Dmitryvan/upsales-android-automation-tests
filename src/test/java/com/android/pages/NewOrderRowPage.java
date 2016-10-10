package com.android.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewOrderRowPage extends BasePage {

    private static final By buttonAdd = MobileBy.id("save");
    private static final By buttonProduct = MobileBy.id("product_field");
    private static final By buttonQuantity = MobileBy.id("quantity_field");
    private static final By buttonPrice = MobileBy.id("price_field");

    private static final By labelProduct = MobileBy.xpath("//*[contains(@resource-id, 'product_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelQuantity = MobileBy.xpath("//*[contains(@resource-id, 'quantity_field')]//*[contains(@resource-id, 'name')]");
    private static final By labelPrice = MobileBy.xpath("//*[contains(@resource-id, 'price_field')]//*[contains(@resource-id, 'name')]");

    private static final By product = MobileBy.xpath("//*[@text='Product']/../..//*[contains(@resource-id, 'select')]");

    private static final By labelOtherInfo = MobileBy.xpath("//*[contains(@resource-id, 'list_custom_field')]//*[contains(@resource-id, 'header_title')]");

    private static final By quantity = MobileBy.xpath("//android.widget.RelativeLayout[@index='2']//android.widget.EditText[@index='0']");
    private static final By price = MobileBy.xpath("//android.widget.RelativeLayout[@index='3']//android.widget.EditText[@index='0']");

    private static final By labelRowTotal = MobileBy.id("view");
    private static final By buttonRemoveOrderRow = MobileBy.id("remove_order_row");
    private static final By popupRemove = MobileBy.id("remove");

    public static String getLabelRowTotal() {
        return getText(labelRowTotal);
    }

    public static String getLabelProduct() {
        waitToBeClickable(labelProduct);
        return getText(labelProduct);
    }

    public static String getProductName() {
        wait(product);
        return getText(product);
    }

    public static void clickProduct() {
        wait(buttonProduct);
        find(buttonProduct).click();
    }

    public static String getLabelQuantity() {
        return getText(labelQuantity);
    }

    public static String getLabelPrice() {
        return getText(labelPrice);
    }

    public static String getPrice() {
        return getText(price);
    }

    public static String getLabelOtherInfo() {
        wait(labelOtherInfo);
        return getText(labelOtherInfo);
    }

    public static void clickQuantity() {
        find(quantity).click();
    }

    public static void clickPrice() {
        find(buttonPrice).click();
    }

    public static void clickAdd() {
        find(buttonAdd).click();
    }

    public static void clickRemoveOrderRow() {
        find(buttonRemoveOrderRow).click();
    }

    public static void clickPopupRemove() {
        find(popupRemove).click();
    }

    public static void enterPrice(String value) {
        sendValues(value, price);
    }

    public static String getQuantity() {
        return getText(quantity);
    }

    public static String getLabelAdd() {
        return getName(buttonAdd);
    }

    public static void enterQuantity(String value) {
        sendValues(value, quantity);
    }
}
