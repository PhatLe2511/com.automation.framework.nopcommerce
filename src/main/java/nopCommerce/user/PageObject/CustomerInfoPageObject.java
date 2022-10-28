package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import nopCommerce.user.PageUIs.BasePageUI;
import nopCommerce.user.PageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends SideBarPageObject{
	
	public CustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public void clickToCheckBoxByLabel(String checkboxName) {
		waitForElementClickable(driver, CustomerInfoPageUI.GENDER_CHECKBOX, checkboxName);
		clickToElement(driver, CustomerInfoPageUI.GENDER_CHECKBOX, checkboxName);
	}

	public void selectDateOfBirthDay(String day) {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_BIRTH_DROPDOWN);
		selectInDefaultDropDown(driver, CustomerInfoPageUI.DATE_BIRTH_DROPDOWN, day);
	}

	public void selectMonthOfBirthDay(String month) {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_BIRTH_DROPDOWN);
		selectInDefaultDropDown(driver, CustomerInfoPageUI.MONTH_BIRTH_DROPDOWN, month);
	}

	public void selectYearOfBirthDay(String year) {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_BIRTH_DROPDOWN);
		selectInDefaultDropDown(driver, CustomerInfoPageUI.YEAR_BIRTH_DROPDOWN, year);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public String getAttributeValueOfFirstNameField(String attributeValue, String fieldName) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_ID, fieldName);
		return getAttributeValue(driver, BasePageUI.TEXT_BOX_BY_ID, attributeValue, fieldName);
		
	}

	public String getAttributeValueOfLastNameField(String attributeValue, String fieldName) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_ID, fieldName);
		return getAttributeValue(driver, BasePageUI.TEXT_BOX_BY_ID, attributeValue, fieldName);
	}

	public String getCssOfEmailField(String attributeValue, String fieldName) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_ID, fieldName);
		return getAttributeValue(driver, BasePageUI.TEXT_BOX_BY_ID, attributeValue, fieldName);
	}
	
	public String getSelectedDateOfBirth() {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_BIRTH_DROPDOWN); 
		return getFirstSelectedItem(driver, CustomerInfoPageUI.DATE_BIRTH_DROPDOWN);
	}
	
	public String getSelectedMonthOfBirth() {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_BIRTH_DROPDOWN); 
		return getFirstSelectedItem(driver, CustomerInfoPageUI.MONTH_BIRTH_DROPDOWN);
	}
	
	public String getSelectedYearOfBirth() {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_BIRTH_DROPDOWN); 
		return getFirstSelectedItem(driver, CustomerInfoPageUI.YEAR_BIRTH_DROPDOWN);
	}
	
}
