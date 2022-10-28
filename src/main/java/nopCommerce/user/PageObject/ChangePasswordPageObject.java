package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import nopCommerce.user.PageUIs.ChangePasswordPageUI;

public class ChangePasswordPageObject extends SideBarPageObject{
	
	WebDriver driver;
	
	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public boolean isSuccessNotificationDisplayed() {
		waitForElementVisible(driver, ChangePasswordPageUI.SUCCESS_CHANGE_PASSWORD_NOTIFICATION);
		return isElementDisplayed(driver, ChangePasswordPageUI.SUCCESS_CHANGE_PASSWORD_NOTIFICATION);
	}

	public void clickToNotificationCloseButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CLOSE_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_BUTTON);
		sleepInSecond(2);
	}

	public HomePageObject clickToLogOutButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.LOGOUT_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

}
