package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerce.user.PageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public Object getRequiredMessageOfFirstName() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_REQUIRED_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_REQUIRED_MESSAGE);
	}

	public Object getRequiredMessageOfLastName() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_REQUIRED_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_REQUIRED_MESSAGE);
	}

	public Object getRequiredMessageOfEmail() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public Object getRequiredMessageOfPassword() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_REQUIRED_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_REQUIRED_MESSAGE);
	}

	public Object getRequiredMessageOfConfirmPassword() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_REQUIRED_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_REQUIRED_MESSAGE);
	}

	public void selectGender(String gender) {
		waitForElementVisible(driver, RegisterPageUI.GENDER_CHECKBOX, gender);
		clickToElement(driver, RegisterPageUI.GENDER_CHECKBOX, gender);
	}

	public void selectDateOfBirthDay(String day) {
		waitForElementVisible(driver, RegisterPageUI.DATE_BIRTH_DROPDOWN);
		selectInDefaultDropDown(driver, RegisterPageUI.DATE_BIRTH_DROPDOWN, day);
	}

	public void selectMonthOfBirthDay(String month) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_BIRTH_DROPDOWN);
		selectInDefaultDropDown(driver, RegisterPageUI.MONTH_BIRTH_DROPDOWN, month);
	}

	public void selectYearOfBirthDay(String year) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_BIRTH_DROPDOWN);
		selectInDefaultDropDown(driver, RegisterPageUI.YEAR_BIRTH_DROPDOWN, year);
	}

	public String getInvalidEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESSFUL_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESSFUL_MESSAGE);
	}

	public DashboardPageObject clickToContinueButton() {
		waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
		sleepInSecond(2);
		return PageGeneratorManager.getDasboardPageObject(driver);
	}

	public String getExistEmailErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
	}

	public Object getPasswordFirstLine() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE_FIRST_LINE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE_FIRST_LINE);
	}

	public String getPasswordSecondLine() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE_SECOND_LINE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE_SECOND_LINE);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.NOT_MATCHED_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.NOT_MATCHED_PASSWORD_ERROR_MESSAGE);
	}


}