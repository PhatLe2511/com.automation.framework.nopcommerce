package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerce.user.PageUIs.DetailedProductPageUI;

public class DetailedProductPageObject extends BasePage{
	
	public DetailedProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void clickToAddReviewButton() {
		waitForElementClickable(driver, DetailedProductPageUI.ADD_REVIEW_BUTTON);
		clickToElement(driver, DetailedProductPageUI.ADD_REVIEW_BUTTON);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, DetailedProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, DetailedProductPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public CustomerInfoPageObject clickToMyAccount() {
		waitForElementClickable(driver, DetailedProductPageUI.MY_ACCOUNT_BUTTON);
		clickToElement(driver, DetailedProductPageUI.MY_ACCOUNT_BUTTON);
		return PageGeneratorManager.getCustomerInfoPageObject(driver);
	}

    public String getProductName() {
		waitForElementVisible(driver, DetailedProductPageUI.PRODUCT_NAME);
		return getElementText(driver, DetailedProductPageUI.PRODUCT_NAME);
    }

	public String getProductPrice() {
		waitForElementVisible(driver, DetailedProductPageUI.PRODUCT_PRICE);
		return getElementText(driver, DetailedProductPageUI.PRODUCT_PRICE).trim();
	}

	public String getProductSKU() {
		waitForElementVisible(driver, DetailedProductPageUI.PRODUCT_SKU);
		return getElementText(driver, DetailedProductPageUI.PRODUCT_SKU);
	}

	public void clickToAddToWishlist() {
		waitForElementClickable(driver, DetailedProductPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, DetailedProductPageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public String getHeaderSuccessMessage() {
		waitForElementVisible(driver, DetailedProductPageUI.SUCCESS_MESSAGE_ON_HEADER);
		return getElementText(driver, DetailedProductPageUI.SUCCESS_MESSAGE_ON_HEADER);
	}

	public WishlistPageObject clickToWishlistOnHeader() {
		waitForElementClickable(driver, DetailedProductPageUI.WISHLIST_HYPERLINK);
		clickToElement(driver, DetailedProductPageUI.WISHLIST_HYPERLINK);
		return PageGeneratorManager.getWishlistPageObject(driver);
	}
}
