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

    private static final List<WebElement> labels = findElements(MobileBy.id("name"));
    private static final WebElement labelProduct = labels.get(0);
    private static final WebElement labelQuantity = labels.get(1);
    private static final WebElement labelPrice = labels.get(2);

    private static final List<WebElement> values = findElements(MobileBy.id("select"));
    private static final WebElement product = values.get(0);

    private static final List<WebElement> titles = findElements(MobileBy.id("title"));
    private static final WebElement labelOtherInfo = titles.get(1);

    private static final By quantity = MobileBy.xpath("//android.widget.RelativeLayout[@index='2']//android.widget.EditText[@index='0']");
    private static final By price = MobileBy.xpath("//android.widget.RelativeLayout[@index='3']//android.widget.EditText[@index='0']");

    private static final By labelRowTotal = MobileBy.IosUIAutomation(".staticTexts()[0]");
    private static final By buttonRemoveOrderRow = MobileBy.IosUIAutomation(
            ".tableViews()[0].cells().firstWithPredicate(\"staticTexts[1].label=='Remove order row'\")");
    private static final By popupRemove = MobileBy.IosUIAutomation(
            "target.frontMostApp().actionSheet().collectionViews()[0].cells()[0].buttons()[0]");

    public static String getLabelRowTotal() {
        return getValue(labelRowTotal);
    }

    public static String getLabelProduct() {
        return labelProduct.getText();
    }

    public static String getProductName() {
        return product.getText();
    }

    public static void clickProduct() {
        wait(buttonProduct);
        find(buttonProduct).click();
    }

    public static String getLabelQuantity() {
        return labelQuantity.getText();
    }

    public static String getLabelPrice() {
        return labelPrice.getText();
    }

    public static String getPrice() {
        return getText(price);
    }

    public static String getLabelOtherInfo() {
        return labelOtherInfo.getText();
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
        find(price).clear();
        sendValues(value, price);
    }

    public static String getQuantity() {
        return getText(quantity);
    }

    public static String getLabelAdd() {
        return getName(buttonAdd);
    }

    public static void enterQuantity(String value) {
        find(quantity).clear();
        sendValues(value, quantity);
    }
}
