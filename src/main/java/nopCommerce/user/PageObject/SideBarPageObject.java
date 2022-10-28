package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerce.user.PageUIs.BasePageUI;

public class SideBarPageObject extends BasePage{
	
	public SideBarPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	
	public CustomerInfoPageObject openCusTomerInfoPage(String pageName) {
		waitForElementClickable(driver, BasePageUI.HYPER_LINK_BY_TEXT, pageName);
		clickToElement(driver, BasePageUI.HYPER_LINK_BY_TEXT, pageName);
		return PageGeneratorManager.getCustomerInfoPageObject(driver);
	}
	
	public AddressPageObject openAddressPage(String pageName) {
		waitForElementClickable(driver, BasePageUI.HYPER_LINK_BY_TEXT, pageName);
		clickToElement(driver, BasePageUI.HYPER_LINK_BY_TEXT, pageName);
		return PageGeneratorManager.getAdressesPageObject(driver);
	}
	
	public ChangePasswordPageObject openChangePasswordPage(String pageName) {
		waitForElementClickable(driver, BasePageUI.HYPER_LINK_BY_TEXT, pageName);
		clickToElement(driver, BasePageUI.HYPER_LINK_BY_TEXT, pageName);
		return PageGeneratorManager.getChangePasswordPageObject(driver);
	}
	
	public MyProdReviewsPO openProductReviewPage(String pageName) {
		waitForElementClickable(driver, BasePageUI.HYPER_LINK_BY_TEXT, pageName);
		clickToElement(driver, BasePageUI.HYPER_LINK_BY_TEXT, pageName);
		return PageGeneratorManager.getMyProdReviewsPageObject(driver);
	}
	
}
