package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import nopCommerce.user.PageUIs.AddressPageUI;

public class AddressPageObject extends SideBarPageObject{
	
	WebDriver driver;
	
	
	public AddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	public void clickToAddNewButton() {
		waitForElementVisible(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);
	}


	public void selectCountryDropdown(String itemText) {
		waitForElementVisible(driver, AddressPageUI.COUNTRY_DROPDOWN);
		selectInDefaultDropDown(driver, AddressPageUI.COUNTRY_DROPDOWN, itemText);
	}
	
	public void selectStateDropdown(String itemText) {
		waitForElementVisible(driver, AddressPageUI.STATE_DROPDOWN);
		selectInDefaultDropDown(driver, AddressPageUI.STATE_DROPDOWN, itemText);
	}


	public void clickToSaveButton() {
		waitForElementVisible(driver, AddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_BUTTON);
	}


	public String getNameOfAddress(String className) {
		waitForElementVisible(driver, AddressPageUI.FIELD_BY_CLASS, className);
		return getElementText(driver, AddressPageUI.FIELD_BY_CLASS, className);
	}


	public String getEmailOfAddress(String className) {
		waitForElementVisible(driver, AddressPageUI.FIELD_BY_CLASS, className);
		return getElementText(driver, AddressPageUI.FIELD_BY_CLASS, className);
	}


	public String getPhoneNumberOfAddress(String className) {
		waitForElementVisible(driver, AddressPageUI.FIELD_BY_CLASS, className);
		return getElementText(driver, AddressPageUI.FIELD_BY_CLASS, className);
	}


	public String getCityStateZip(String className) {
		waitForElementVisible(driver, AddressPageUI.FIELD_BY_CLASS, className);
		return getElementText(driver, AddressPageUI.FIELD_BY_CLASS, className);
	}


	public String getValueOfCountry(String className) {
		waitForElementVisible(driver, AddressPageUI.FIELD_BY_CLASS, className);
		return getElementText(driver, AddressPageUI.FIELD_BY_CLASS, className);
	}


	public String getValueOfAddress1(String className) {
		waitForElementVisible(driver, AddressPageUI.FIELD_BY_CLASS, className);
		return getElementText(driver, AddressPageUI.FIELD_BY_CLASS, className);
	}




}
