package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;


import nopCommerce.user.PageUIs.DashboardPageUI;

public class DashboardPageObject extends SideBarPageObject{
		
	
	public DashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

		WebDriver driver;

		public void clickToMyAccountLink() {
			waitForElementClickable(driver, DashboardPageUI.MY_ACCOUNT_BUTTON);
			clickToElement(driver, DashboardPageUI.MY_ACCOUNT_BUTTON);
		}

		public boolean isLogOutButtonDisplay() {
			waitForElementVisible(driver, DashboardPageUI.LOGOUT_BUTTON);
			return isElementDisplayed(driver, DashboardPageUI.LOGOUT_BUTTON);
		}

    	public SearchPageObject clickOnSearchHyperLink() {
			waitForElementClickable(driver, DashboardPageUI.SEARCH_BUTTON);
			clickToElement(driver, DashboardPageUI.SEARCH_BUTTON);
			return PageGeneratorManager.getSearchPageObject(driver);
		}

	public HomePageObject clickToLogOutButton() {
		waitForElementClickable(driver, DashboardPageUI.LOGOUT_BUTTON);
		clickToElement(driver, DashboardPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

    public NotebookPageObject clickToNoteBook() {
		waitForElementClickable(driver, DashboardPageUI.NOTEBOOK_BUTTON);
		clickToElement(driver, DashboardPageUI.NOTEBOOK_BUTTON);
		return PageGeneratorManager.getNotebookPageObject(driver);
    }

	public void hoverToComputer() {
		waitForElementVisible(driver, DashboardPageUI.COMPUTER_BUTTON);
		hoverToElement(driver, DashboardPageUI.COMPUTER_BUTTON);
	}

	public DetailedProductPageObject clickToProductName(String productName) {
		waitForElementClickable(driver, DashboardPageUI.PRODUCT_NAME, productName);
		clickToElement(driver, DashboardPageUI.PRODUCT_NAME, productName);
		return PageGeneratorManager.getDetailedProductPageObject(driver);
	}

	public WishlistPageObject clickToWishlistOnHeader() {
		waitForElementClickable(driver, DashboardPageUI.WISHLIST_HYPERLINK);
		clickToElement(driver, DashboardPageUI.WISHLIST_HYPERLINK);
		return PageGeneratorManager.getWishlistPageObject(driver);
	}

	public void openDemoUrl(String url) {
			openURL(driver, url);
	}

    public void clickOnCompareButtonAtProduct(String productName) {
		waitForElementClickable(driver, DashboardPageUI.COMPARE_BUTTON, productName);
		clickToElement(driver, DashboardPageUI.COMPARE_BUTTON, productName);
		sleepInSecond(2);
    }

	public String getProductImage(String attributeName) {
		waitForElementVisible(driver, DashboardPageUI.PRODUCT_IMAGE, attributeName);
		return getAttributeValue(driver,DashboardPageUI.PRODUCT_IMAGE, "alt", attributeName);
	}

	public String getProductName(String productName) {
		waitForElementVisible(driver, DashboardPageUI.PRODUCT_NAME, productName);
		return getElementText(driver, DashboardPageUI.PRODUCT_NAME, productName);
	}

	public String getProductPrice(String productPrice) {
		waitForElementVisible(driver, DashboardPageUI.PRODUCT_PRICE, productPrice);
		return getElementText(driver, DashboardPageUI.PRODUCT_PRICE, productPrice);
	}

	public String getCompareMessage() {
		waitForElementVisible(driver, DashboardPageUI.COMPARED_PRODUCT_MESSAGE);
		return getElementText(driver, DashboardPageUI.COMPARED_PRODUCT_MESSAGE);
	}

	public CompareListPageObject clickToProductComparison() {
		waitForElementClickable(driver, DashboardPageUI.PRODUCT_COMPARISON_HYPERLINK);
		clickToElement(driver, DashboardPageUI.PRODUCT_COMPARISON_HYPERLINK);
		return PageGeneratorManager.getCompareListPageObject(driver);
	}


}
