package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerce.user.PageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public RegisterPageObject clickToRegisterHeaderButton() {
		waitForElementClickable(driver, HomePageUI.REGISTER_BUTTON);
		clickToElement(driver, HomePageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginButton() {
		waitForElementClickable(driver, HomePageUI.LOGIN_BUTTON);
		clickToElement(driver, HomePageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getLoginPageObject(driver);
	}

	public boolean isLogOutButtonDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_BUTTON);
		return getElement(driver, HomePageUI.LOGOUT_BUTTON).isDisplayed();
	}
	
}
