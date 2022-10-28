package nopCommerce.user.PageObject;

import nopCommerce.user.PageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;


import nopCommerce.user.PageUIs.DashboardPageUI;

public class DashboardPageObject extends SideBarPageObject{
		
	
	public DashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

		WebDriver driver;

		public void clickToMyAccountLink() {
			waitForElementClickable(driver, DashboardPageUI.MYACCOUNT_BUTTON);
			clickToElement(driver, DashboardPageUI.MYACCOUNT_BUTTON);
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
}
