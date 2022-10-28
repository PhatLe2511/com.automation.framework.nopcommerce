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
import nopCommerce.user.PageObject.DashboardPageObject;
import nopCommerce.user.PageObject.HomePageObject;
import nopCommerce.user.PageObject.LoginPageObject;
import nopCommerce.user.PageObject.PageGeneratorManager;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

public class NopCommerce_Login extends BaseTest{
		WebDriver driver;
		HomePageObject homePage;
		LoginPageObject loginPage;
		DashboardPageObject dashboardPage;
		String email, password;
		
	@Parameters({"Browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String url) {
		DataHelper faker = new DataHelper();
		driver = getBrowserName(browserName, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		email = faker.getEmailData();
		password = faker.getPasswordData();
	}
			
	@Test
	public void TC_01_Login_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login with empty data");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to login button on the header to navigate to login page");
		log.info("Click to login button on the header to navigate to login page");
		loginPage = homePage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Log in button in login page to show required message at email");
		log.info("Click to Log in button in login page to show required message at email");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify required message at email textbox");
		log.info("Verify required message at email textbox");
		Assert.assertEquals(loginPage.getEmailRequiredMessage(), "Please enter your email");
	}
	
	@Test
	public void TC_02_Login_With_Invalid_Email(Method method) {
		
		ExtentTestManager.getTest().log(Status.INFO, "Input invalid email to Email textbox");
		log.info("Input invalid email to Email textbox");
		loginPage.inputToTextBoxByID(driver , "Email", "thanhphat");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to password textbox");
		log.info("Input to password textbox");
		loginPage.inputToTextBoxByID(driver , "Password", "123456789");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Log in button in login page to show error message at email");
		log.info("Click to Log in button in login page to show error message at email");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message at email textbox");
		log.info("Verify error message at email textbox");
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Wrong email");
	}
	
	@Test
	public void TC_03_Login_With_Not_Exist_Email(Method method) {
		
		ExtentTestManager.getTest().log(Status.INFO, "Input not-existed email to Email textbox with: " + email);
		log.info("Input not-existed email to Email textbox with: " + email);
		loginPage.inputToTextBoxByID(driver , "Email", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input to password textbox");
		log.info("Input to password textbox");
		loginPage.inputToTextBoxByID(driver , "Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Log in button in login page to show error message at email");
		log.info("Click to Log in button in login page to show error message at email");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message with non-existed mail");
		log.info("Verify error message with non-existed mail");
		Assert.assertEquals(loginPage.getNotExistedErrorMessageLineOne(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found");
	}
	
	@Test
	public void TC_04_Login_With_Exist_Email_But_Empty_Password(Method method) {
		
		ExtentTestManager.getTest().log(Status.INFO, "Input existed email to Email textbox with:  but not input password" + Register_Common.email);
		log.info("Input existed email to Email textbox with:  but not input password" + Register_Common.email);
		loginPage.inputToTextBoxByID(driver , "Email", Register_Common.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Log in button in login page to show error message at email");
		log.info("Click to Log in button in login page to show error message at email");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message with empty password");
		log.info("Verify error message with empty password");
		Assert.assertEquals(loginPage.getNotExistedErrorMessageLineOne(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}
	
	@Test
	public void TC_05_Login_With_Exist_Email_But_Incorrect_Password(Method method) {
		
		ExtentTestManager.getTest().log(Status.INFO, "Input existed email to Email textbox with:  but Incorrect password" + Register_Common.email);
		log.info("Input existed email to Email textbox with:  but Incorrect password" + Register_Common.email);
		loginPage.inputToTextBoxByID(driver , "Email", Register_Common.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input incorrect password to password textbox");
		log.info("Input incorrect password to password textbox");
		loginPage.inputToTextBoxByID(driver , "Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Log in button in login page to show error message at email");
		log.info("Click to Log in button in login page to show error message at email");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message with incorrect password");
		log.info("Verify error message with incorrect password");
		Assert.assertEquals(loginPage.getNotExistedErrorMessageLineOne(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}
	
	@Test
	public void TC_06_Login_With_All_Valid_data(Method method) {
		
		ExtentTestManager.getTest().log(Status.INFO, "Input existed email to Email textbox with:  but Incorrect password" + Register_Common.email);
		log.info("Input valid email to Email text box with: " + Register_Common.email);
		loginPage.inputToTextBoxByID(driver , "Email", Register_Common.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input correct password to password textbox");
		log.info("Input correct password to password text box");
		loginPage.inputToTextBoxByID(driver , "Password", Register_Common.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to Log in button in login page to show error message at email");
		log.info("Click to Log in button in login page to show error message at email");
		dashboardPage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify home page is displayed");
		log.info("Verify home page is displayed");
		verifyTrue(homePage.isLogOutButtonDisplayed());
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
