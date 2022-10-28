package com.nopcommerce.user;


import java.lang.reflect.Method;

import nopCommerce.user.PageObject.DashboardPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import nopCommerce.user.PageObject.HomePageObject;
import nopCommerce.user.PageObject.PageGeneratorManager;
import nopCommerce.user.PageObject.RegisterPageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;


public class NopCommerce_Register extends BaseTest{
 
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;

	DashboardPageObject dashboardPage;
	String firstName, lastName, email, email_2, password;
	
	@Parameters({"Browser", "url"})  
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		  DataHelper fakeData = new DataHelper();
		  driver = getBrowserName(browserName, url);
		  homePage = PageGeneratorManager.getHomePageObject(driver);
		  firstName = fakeData.getFirstNameData();
		  lastName = fakeData.getLastNameData();
		  email = fakeData.getEmailData();
		  password = fakeData.getPasswordData();
		  email_2 = fakeData.getEmailData();
		  
	}
  
  	@Test
	public void TC_01_Register_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register with Empty data and get all required messages");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to navigate to Register");
		log.info("Click to Register on the header");
		registerPage = homePage.clickToRegisterHeaderButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to show required messages ");
		log.info("Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Required message of Firstname field");
		log.info("Verify Required message of Firstname field");
		Assert.assertEquals(registerPage.getRequiredMessageOfFirstName(), "First name is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Required message of Lastname field");
		log.info("Verify Required message of Lastname field");
		Assert.assertEquals(registerPage.getRequiredMessageOfLastName(), "Last name is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Required message of Email field");
		log.info("Verify Required message of Email field");
		Assert.assertEquals(registerPage.getRequiredMessageOfEmail(), "Email is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Required message of Password field");
		log.info("Verify Required message of Password field");
		Assert.assertEquals(registerPage.getRequiredMessageOfPassword(), "Password is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Required message of Confirm Password field");
		log.info("Verify Required message of Confirm Password field");
		Assert.assertEquals(registerPage.getRequiredMessageOfConfirmPassword(), "Password is required.");
	}
  	
  	@Test
  	public void TC_02_Register_With_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register with invalid email");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to navigate to Register");
		log.info("Click to Register on the header");
		registerPage = homePage.clickToRegisterHeaderButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Select gender in checkbox");
		log.info("Select gender in checkbox");
		registerPage.selectGender("Male");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Firstname textbox with: " + firstName);
		log.info("Input valid value into Firstname text box with: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Lastname textbox with: " + lastName);
		log.info("Input valid value into Lastname text box with: " + lastName);
		registerPage.inputToTextBoxByID(driver,"LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Date of birthday");
		registerPage.selectDateOfBirthDay("25");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Month of birthday");
		log.info("Select Month of birthday");
		registerPage.selectMonthOfBirthDay("November");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Year of birthday");
		registerPage.selectYearOfBirthDay("1996");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input invalid email to email text box");
		log.info("Input invalid email to email text box");
		registerPage.inputToTextBoxByID(driver, "Email", "thanhphat123");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into password text box with: " + password);
		log.info("Input valid value into password text box with: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into confirm password text box with: " + password);
		log.info("Input valid value into confirm password text box with: " + password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to show error messages ");
		log.info("Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message about invalid email");
		log.info("Verify error message about invalid email");
		Assert.assertEquals(registerPage.getInvalidEmailMessage(), "Wrong email");
	}
  	
  	@Test
  	public void TC_03_Register_With_All_Valid_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register with all valid data");
				
		ExtentTestManager.getTest().log(Status.INFO, "Select gender in checkbox");
		log.info("Select gender in checkbox");
		registerPage.selectGender("Male");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Firstname text box with: " + firstName);
		log.info("Input valid value into Firstname textbox with: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Lastname text box with: " + lastName);
		log.info("Input valid value into Lastname textbox with: " + lastName);
		registerPage.inputToTextBoxByID(driver,"LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Date of birthday");
		registerPage.selectDateOfBirthDay("25");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Month of birthday");
		log.info("Select Month of birthday");
		registerPage.selectMonthOfBirthDay("November");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Year of birthday");
		registerPage.selectYearOfBirthDay("1996");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid email to email textbox with: " + email);
		log.info("Input valid email to email textbox with: " + email);
		registerPage.inputToTextBoxByID(driver, "Email", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into password textbox with: " + password);
		log.info("Input valid value into password textbox with: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into confirm password textbox with: " + password);
		log.info("Input valid value into confirm password textbox with: " + password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to show error messages ");
		log.info("Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify success message about valid email");
		log.info("Verify success message about valid email");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Continue buton to return to homepage");
		log.info("Click on Continue buton to return to homepage");
		dashboardPage = registerPage.clickToContinueButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Log out button");
		log.info("Click on Log out button");
		homePage = dashboardPage.clickToLogOutButton();
	}
  	
  	@Test
  	public void TC_04_Register_With_Exist_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register with Exist Email");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to navigate to Register");
		log.info("Click to Register on the header");
		registerPage = homePage.clickToRegisterHeaderButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Firstname textbox with: " + firstName);
		log.info("Input valid value into Firstname textbox with: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Lastname textbox with: " + lastName);
		log.info("Input valid value into Lastname textbox with: " + lastName);
		registerPage.inputToTextBoxByID(driver,"LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Date of birthday");
		registerPage.selectDateOfBirthDay("25");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Month of birthday");
		log.info("Select Month of birthday");
		registerPage.selectMonthOfBirthDay("November");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Year of birthday");
		registerPage.selectYearOfBirthDay("1996");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input exist email to email textbox with: " + email);
		log.info("Input exist email to email textbox with: " + email);
		registerPage.inputToTextBoxByID(driver, "Email", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into password textbox with: " + password);
		log.info("Input valid value into password textbox with: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into confirm password textbox with: " + password);
		log.info("Input valid value into confirm password textbox with: " + password);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to show error messages ");
		log.info("Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message about invalid email");
		log.info("Verify error message about invalid email");
		Assert.assertEquals(registerPage.getExistEmailErrorMessage(), "The specified email already exists");	
	}
  	
  	@Test
  	public void TC_05_Register_With_Less_Than_Six_Chars_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register with password less than 6 characters");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Firstname textbox with: " + firstName);
		log.info("Input valid value into Firstname textbox with: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Lastname textbox with: " + lastName);
		log.info("Input valid value into Lastname textbox with: " + lastName);
		registerPage.inputToTextBoxByID(driver,"LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Date of birthday");
		registerPage.selectDateOfBirthDay("25");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Month of birthday");
		log.info("Select Month of birthday");
		registerPage.selectMonthOfBirthDay("November");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Year of birthday");
		registerPage.selectYearOfBirthDay("1996");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid email to email textbox with: " + email_2);
		log.info("Input valid email to email textbox with: " + email_2);
		registerPage.inputToTextBoxByID(driver, "Email", email_2);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input less-than-6-chars value into password textbox with");
		log.info("Input less-than-6-chars value into password textbox with");
		registerPage.inputToTextBoxByID(driver, "Password", "12345");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input less-than-6-chars value into password textbox with");
		log.info("Input less-than-6-chars value into confirm password textbox with");
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", "12345");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to show error messages ");
		log.info("Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message about invalid password");
		log.info("Verify error message about invalid password");
		Assert.assertEquals(registerPage.getPasswordFirstLine(), "Password must meet the following rules:");
		Assert.assertEquals(registerPage.getPasswordSecondLine(), "must have at least 6 characters");
	}
  	
  	@Test
  	public void TC_06_Register_With_Not_Matched_Confirm_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register with confirm password is not the same with password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Firstname textbox with: " + firstName);
		log.info("Input valid value into Firstname textbox with: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into Lastname textbox with: " + lastName);
		log.info("Input valid value into Lastname textbox with: " + lastName);
		registerPage.inputToTextBoxByID(driver,"LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Date of birthday");
		registerPage.selectDateOfBirthDay("25");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Month of birthday");
		log.info("Select Month of birthday");
		registerPage.selectMonthOfBirthDay("November");
		
		ExtentTestManager.getTest().log(Status.INFO, "Select Date of birthday");
		log.info("Select Year of birthday");
		registerPage.selectYearOfBirthDay("1996");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid email to email textbox with: " + email_2);
		log.info("Input valid email to email textbox with: " + email_2);
		registerPage.inputToTextBoxByID(driver, "Email", email_2);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input valid value into password textbox with: " + password);
		log.info("Input valid value into password textbox with: " + password);
		registerPage.inputToTextBoxByID(driver, "Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input not-matched confirm password into confirm password textbox");
		log.info("Input not-matched confirm password into confirm password textbox");
		registerPage.inputToTextBoxByID(driver, "Password", "1234567890");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Register button to show error messages");
		log.info("Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message about not-matched password");
		log.info("Verify error message about not-matched password");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match."); 
	}
  	
  @AfterClass
  	public void afterClass() {
	 driver.quit();
  }

}
