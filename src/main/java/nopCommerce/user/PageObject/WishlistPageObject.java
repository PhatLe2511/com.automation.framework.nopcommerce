package nopCommerce.user.PageObject;

import commons.BasePage;
import nopCommerce.user.PageUIs.WishlistPageUI;
import org.openqa.selenium.WebDriver;

public class WishlistPageObject extends BasePage {
        WebDriver driver;

    public WishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductSKU() {
        waitForElementVisible(driver, WishlistPageUI.PRODUCT_SKU);
        return getElementText(driver, WishlistPageUI.PRODUCT_SKU);
    }

    public String getProductName() {
        waitForElementVisible(driver, WishlistPageUI.PRODUCT_NAME);
        return getElementText(driver, WishlistPageUI.PRODUCT_NAME);
    }

    public String getProductPrice() {
        waitForElementVisible(driver, WishlistPageUI.PRODUCT_PRICE);
        return getElementText(driver, WishlistPageUI.PRODUCT_PRICE);
    }

    public void clickToWishlistURL() {
        waitForElementClickable(driver, WishlistPageUI.SHARING_URL);
        clickToElement(driver, WishlistPageUI.SHARING_URL);
    }

    public String getWishlistHeader() {
        waitForElementVisible(driver, WishlistPageUI.SHARING_WISHLIST_PAGE_TITLE);
        return getElementText(driver, WishlistPageUI.SHARING_WISHLIST_PAGE_TITLE);
    }
}
