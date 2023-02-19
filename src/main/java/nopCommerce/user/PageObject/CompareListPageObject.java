package nopCommerce.user.PageObject;

import commons.BasePage;
import nopCommerce.user.PageUIs.CompareListPageUI;
import nopCommerce.user.PageUIs.DashboardPageUI;
import org.openqa.selenium.WebDriver;

public class CompareListPageObject extends BasePage {
    WebDriver driver;
    public CompareListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductImage(String attributeName) {
        waitForElementVisible(driver, CompareListPageUI.PRODUCT_IMAGE, attributeName);
        return getAttributeValue(driver,CompareListPageUI.PRODUCT_IMAGE, "alt", attributeName);
    }

    public String getProductName(String productName) {
        waitForElementVisible(driver, CompareListPageUI.PRODUCT_NAME, productName);
        return getElementText(driver, CompareListPageUI.PRODUCT_NAME, productName);
    }

    public String getProductPrice(String productPrice) {
        waitForElementVisible(driver, CompareListPageUI.PRODUCT_PRICE, productPrice);
        return getElementText(driver, CompareListPageUI.PRODUCT_PRICE, productPrice);
    }

    public void clickToClearListButton() {
        waitForElementClickable(driver, CompareListPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareListPageUI.CLEAR_LIST_BUTTON);
    }

    public String getCompareMessage() {
        waitForElementVisible(driver, CompareListPageUI.NO_ITEMS_COMPARE_MESSAGE);
        return getElementText(driver, CompareListPageUI.NO_ITEMS_COMPARE_MESSAGE);
    }

    public boolean isProductImageUndisplayed(String attributeName) {
        return isElementUndisplayed(driver, CompareListPageUI.PRODUCT_IMAGE, attributeName);
    }

    public boolean isProductNameUndisplayed(String productName) {
        return isElementUndisplayed(driver, CompareListPageUI.PRODUCT_NAME, productName);
    }

    public boolean isProductPriceUndisplayed(String productPrice) {
        return isElementUndisplayed(driver, CompareListPageUI.PRODUCT_PRICE, productPrice);
    }
}
