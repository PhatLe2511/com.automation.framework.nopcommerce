package com.nopcommerce.user;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import nopCommerce.common.Register_Common;
import nopCommerce.user.PageObject.AddressPageObject;
import nopCommerce.user.PageObject.ChangePasswordPageObject;
import nopCommerce.user.PageObject.CustomerInfoPageObject;
import nopCommerce.user.PageObject.DashboardPageObject;
import nopCommerce.user.PageObject.DetailedProductPageObject;
import nopCommerce.user.PageObject.HomePageObject;
import nopCommerce.user.PageObject.LoginPageObject;
import nopCommerce.user.PageObject.MyProdReviewsPO;
import nopCommerce.user.PageObject.PageGeneratorManager;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

public class NopCommerce_MyAccount extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	AddressPageObject addressPage;
	DashboardPageObject dashboardPage;
	MyProdReviewsPO myProductReviewPage;
	CustomerInfoPageObject customerInfoPage;
	ChangePasswordPageObject changePasswordPage;
	DetailedProductPageObject detailedProductPage;
	String firstName, lastName, email, companyName, address, city, zipcode, phoneNumber, newPassword, productName;
	
	@Parameters({"Browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		
		DataHelper data = new DataHelper();
		
		email = data.getEmailData();
		firstName = data.getFirstNameData();
		lastName = data.getLastNameData();
		companyName = data.getUSCompanyNameData();
		address = data.getUSAddressData();
		zipcode = data.getUSZipCodeData();
		phoneNumber = data.getUSPhoneNumberData();
		city = data.getUSCityData();
		newPassword = data.getPasswordData();
		productName = "HTC One M8 Android L 5.0 Lollipop";
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		log.info("Click to login button on the header to navigate to login page");
		loginPage = homePage.clickToLoginButton();
		
		log.info("Pre-condition - Input valid email with: " + Register_Common.email);
		loginPage.inputToTextBoxByID(driver , "Email", Register_Common.email);
		
		log.info("Pre-condition - Input to password text box");
		loginPage.inputToTextBoxByID(driver , "Password", Register_Common.password);
		
		log.info("Pre-condition - Click to Log in button");
		dashboardPage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void TC_01_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Change Password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to My Account button on the header");
		log.info("Click to My Account button on the header");
		dashboardPage.clickToMyAccountLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Change password button");
		log.info("Click to Change password button");
		changePasswordPage = dashboardPage.openChangePasswordPage("Change password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to old password field with: " + Register_Common.password);
		log.info("Input to old password field with: " + Register_Common.password);
		changePasswordPage.inputToTextBoxByID(driver, "OldPassword", Register_Common.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to new password field with: " + newPassword);
		log.info("Input to new password field with: " + newPassword);
		changePasswordPage.inputToTextBoxByID(driver, "NewPassword", newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to confirm password field with: " + newPassword);
		log.info("Input to confirm password field with: " + newPassword);
		changePasswordPage.inputToTextBoxByID(driver, "ConfirmNewPassword", newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Change password button");
		log.info("Click on Change password button");
		changePasswordPage.clickToChangePasswordButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify display of success notification");
		log.info("Verify display of success notification");
		Assert.assertTrue(changePasswordPage.isSuccessNotificationDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on close button at Notification");
		log.info("Click on close button at Notification");
		changePasswordPage.clickToNotificationCloseButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Log out button");
		log.info("Click on Log out button");
		homePage = changePasswordPage.clickToLogOutButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Log in button");
		log.info("Click to login button");
		loginPage = homePage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to email button");
		log.info("Pre-condition - Input valid email with: " + Register_Common.email);
		loginPage.inputToTextBoxByID(driver , "Email", Register_Common.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to password button");
		log.info("Input to password textbox");
		loginPage.inputToTextBoxByID(driver , "Password", newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Log in button");
		log.info("Click to Log in button");
		dashboardPage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify log out button is displayed");
		log.info("Verify log out button is displayed");
		Assert.assertTrue(dashboardPage.isLogOutButtonDisplay());
	}
	
	@Test
	public void TC_02_Edit_Customer_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit customer information");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to My Account button");
		log.info("Click to My Account button on the header");
		dashboardPage.clickToMyAccountLink();
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Customer info button");
		log.info("Click to Customer info button");
		customerInfoPage = changePasswordPage.openCusTomerInfoPage("Customer info");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Female checkbox");
		log.info("Click to Female checkbox");
		customerInfoPage.clickToCheckBoxByLabel("Female");
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit First name textbox with: " + firstName);
		log.info("Edit First name textbox with: " + firstName);
		customerInfoPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit Last name textbox with: " + lastName);
		log.info("Edit Last name textbox with: " + lastName);
		customerInfoPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Date of birthday");
		customerInfoPage.selectDateOfBirthDay("20");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Month of birthday");
		log.info("Select Month of birthday");
		customerInfoPage.selectMonthOfBirthDay("December");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Year of birthday");
		customerInfoPage.selectYearOfBirthDay("1996");
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit email textbox with: " + email);
		log.info("Edit email textbox with: " + email);
		customerInfoPage.inputToTextBoxByID(driver, "Email", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to save button");
		log.info("Click to save button");
		customerInfoPage.clickToSaveButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify firstname display correctly with: " + firstName);
		log.info("Verify firstname display correctly with: " + firstName);
		Assert.assertEquals(customerInfoPage.getAttributeValueOfFirstNameField("value", "FirstName"), firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify lastname display correctly with: " + lastName);
		log.info("Verify lastname display correctly with: " + lastName);
		Assert.assertEquals(customerInfoPage.getAttributeValueOfLastNameField("value", "LastName"), lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify email display correctly with: " + email);
		log.info("Verify email display correctly with: " + email);
		Assert.assertEquals(customerInfoPage.getCssOfEmailField("value", "Email"), email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify date of birth display correctly");
		log.info("Verify date of birth display correctly");
		Assert.assertEquals(customerInfoPage.getSelectedDateOfBirth(), "20");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify month of birth display correctly");
		log.info("Verify month of birth display correctly");
		Assert.assertEquals(customerInfoPage.getSelectedMonthOfBirth(), "December");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify year of birth display correctly");
		log.info("Verify year of birth display correctly");
		Assert.assertEquals(customerInfoPage.getSelectedYearOfBirth(), "1996");
	}
	
	@Test
	public void TC_03_Add_Address_Customer(Method method) {
		ExtentTestManager.startTest(method.getName(), "Add Customer address");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Adresses button");
		log.info("Click to Adresses button");
		addressPage = customerInfoPage.openAddressPage("Addresses");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to add new button");
		log.info("Click to add new button");
		addressPage.clickToAddNewButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to Firstname textbox with: " + firstName);
		log.info("Input to Firstname textbox with: " + firstName);
		addressPage.inputToTextBoxByID(driver, "Address_FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to Lastname textbox with: " + lastName);
		log.info("Input to Lastname textbox with: " + lastName);
		addressPage.inputToTextBoxByID(driver, "Address_LastName", lastName);
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to email textbox with: " + email);
		log.info("Input to email textbox with: " + email);
		addressPage.inputToTextBoxByID(driver, "Address_Email", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to company textbox with: " + companyName);
		log.info("Input to company textbox with: " + companyName);
		addressPage.inputToTextBoxByID(driver, "Address_Company", companyName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Select value in Country dropdown");
		log.info("Select value in Country dropdown");
		addressPage.selectCountryDropdown("United States");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select value in State dropdown");
		log.info("Select value in State dropdown");
		addressPage.selectStateDropdown("Alabama");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to city textbox with: " + city);
		log.info("Input to city textbox with: " + city);
		addressPage.inputToTextBoxByID(driver, "Address_City", city);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to Adress 1 textbox with: " + address);
		log.info("Input to Adress 1 textbox with: " + address);
		addressPage.inputToTextBoxByID(driver, "Address_Address1", address);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to Zipcode textbox with: " + zipcode);
		log.info("Input to Zipcode textbox with: " + zipcode);
		addressPage.inputToTextBoxByID(driver, "Address_ZipPostalCode", zipcode);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to Phone number textbox with: " + phoneNumber);
		log.info("Input to Phone number textbox with: " + phoneNumber);
		addressPage.inputToTextBoxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click To Save button");
		log.info("Click To Save button");
		addressPage.clickToSaveButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify value of name with: " + firstName + " " + lastName);
		log.info("Verify value of name with: " + firstName + " " + lastName);
		Assert.assertEquals(addressPage.getNameOfAddress("name"), firstName + " " + lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify value of email with: " + email);
		log.info("Verify value of email with: " + email);
		Assert.assertEquals(addressPage.getEmailOfAddress("email"), "Email: " + email); 
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify value of Phone number with: " + phoneNumber);
		log.info("Verify value of Phone number with: " + phoneNumber);
		Assert.assertEquals(addressPage.getPhoneNumberOfAddress("phone"),"Phone number: " + phoneNumber);
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify value of Address 1 with: " + address);
		log.info("Verify value of Address 1 with: " + address);
		Assert.assertEquals(addressPage.getValueOfAddress1("address1"), address);
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify value of city, state and zipcode with: " + city + ", " + "Alabama, " + zipcode);
		log.info("Verify value of city, state and zipcode with: " + city + ", " + "Alabama, " + zipcode);
		Assert.assertEquals(addressPage.getCityStateZip("city-state-zip"), city + ", " + "Alabama, " + zipcode);
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify value of Country");
		log.info("Verify value of Country");
		Assert.assertEquals(addressPage.getValueOfCountry("country"), "United States");
	}
	
	@Test
	public void TC_04_Add_Product_Review(Method method) {
		ExtentTestManager.startTest(method.getName(), "Add product review");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to header image");
		log.info("Click to header image");
		dashboardPage = addressPage.clickToHeaderImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to product to go to detailed page");
		log.info("Click to product to go to detailed page");
		detailedProductPage = dashboardPage.clickToProductName(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Add your review button");
		log.info("Click to Add your review button");
		detailedProductPage.clickToAddReviewButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to Review title field");
		log.info("Input to Review title field");
		detailedProductPage.inputToTextBoxByID(driver, "AddProductReview_Title", "test");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to Review text field");
		log.info("Input to Review text field");
		detailedProductPage.inputToTextBoxByID(driver, "AddProductReview_ReviewText", "test test");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Submit Review button");
		log.info("Click to Submit Review button");
		detailedProductPage.clickToSubmitReviewButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to My account on the header");
		log.info("Click to My account on the header");
		customerInfoPage = detailedProductPage.clickToMyAccount();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to My product review button");
		log.info("Click to My product review button");
		myProductReviewPage = customerInfoPage.openProductReviewPage("My product reviews");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Product review is displayed");
		log.info("Verify Product review is displayed");
		Assert.assertEquals(myProductReviewPage.getProductReview(), productName); 
	}
	
	@AfterClass()
	public void AfterClass() {
		driver.quit();
	}
}