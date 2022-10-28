package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerce.user.PageUIs.LoginPageUI;

public class LoginPageObject extends BasePage{
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public DashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDasboardPageObject(driver);
	}

	public String getEmailRequiredMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_REQUIRED_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_REQUIRED_MESSAGE);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_REQUIRED_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_REQUIRED_MESSAGE);
	}

	public String getNotExistedErrorMessageLineOne() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_LINE_ONE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_LINE_ONE);
	}
	
}
