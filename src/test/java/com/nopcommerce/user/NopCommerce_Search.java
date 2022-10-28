package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import nopCommerce.user.PageObject.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import commons.BaseTest;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

import java.lang.reflect.Method;

public class NopCommerce_Search extends BaseTest{
		WebDriver driver;
		
		DashboardPageObject dashboardPage;

		SearchPageObject searchPage;
		HomePageObject homePage;
		RegisterPageObject registerPage;
		String firstName, lastName, email, password;
		
		@Parameters({"Browser", "url"})
		@BeforeClass
		public void BeforeTest (String browserName, String url) {
			driver = getBrowserName(browserName, url);
			
			homePage = PageGeneratorManager.getHomePageObject(driver);
			
			DataHelper fakeData = new DataHelper();

			firstName = fakeData.getFirstNameData();
			lastName = fakeData.getLastNameData();
			email = fakeData.getEmailData();
			password = fakeData.getPasswordData();

			log.info("Click to Register on the header");
			registerPage = homePage.clickToRegisterHeaderButton();

			log.info("Select gender in checkbox");
			registerPage.selectGender("Male");

			log.info("Input valid value into Firstname text box with: " + firstName);
			registerPage.inputToTextBoxByID(driver, "FirstName", firstName);

			log.info("Input valid value into Lastname text box with: " + lastName);
			registerPage.inputToTextBoxByID(driver,"LastName", lastName);

			log.info("Select Date of birthday");
			registerPage.selectDateOfBirthDay("25");

			log.info("Select Month of birthday");
			registerPage.selectMonthOfBirthDay("November");

			log.info("Select Year of birthday");
			registerPage.selectYearOfBirthDay("1996");

			log.info("Input valid email to email text box with: " + email);
			registerPage.inputToTextBoxByID(driver, "Email", email);

			log.info("Input valid value into password text box with: " + password);
			registerPage.inputToTextBoxByID(driver, "Password", password);

			log.info("Input valid value into confirm password text box with: " + password);
			registerPage.inputToTextBoxByID(driver, "ConfirmPassword", password);

			log.info("Click to Register button");
			registerPage.clickToRegisterButton();

			log.info("Click on Continue button to return to homepage");
			dashboardPage = registerPage.clickToContinueButton();
		}

		@Test
		private void TC_01_Search_With_Empty_Data(Method method){
			ExtentTestManager.startTest(method.getName(), "Search with empty data");
			
			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button at footer");
			log.info("Click on Search button at footer");
			searchPage = dashboardPage.clickOnSearchHyperLink();

			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
			log.info("Click on Search button");
			searchPage.clickToSearchButton();

			ExtentTestManager.getTest().log(Status.INFO, "Verify the warning message when search is empty");
			log.info("Verify the warning message when search is empty");
			Assert.assertEquals(searchPage.getEmptyWarningMessage(), "Search term minimum length is 3 characters");
		}

		@Test
		private void TC_02_Search_With_Non_Existed_Data(Method method){
			ExtentTestManager.startTest(method.getName(), "Search with non-existed data");

			ExtentTestManager.getTest().log(Status.INFO, "Input to search keyword text box");
			log.info("Input to search keyword text box");
			searchPage.inputToSearchTextBox("Macbook pro 2050");

			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
			log.info("Click on Search button");
			searchPage.clickToSearchButton();

			ExtentTestManager.getTest().log(Status.INFO, "Verify the no-result message when search has no result");
			log.info("Verify the no-result message when search has no result");
			Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
		}

		@Test
		private void TC_03_Search_With_Approx_Product_Name(Method method){
			ExtentTestManager.startTest(method.getName(), "Search with approx product name");

			ExtentTestManager.getTest().log(Status.INFO, "Input to search keyword text box");
			log.info("Input to search keyword text box");
			searchPage.inputToSearchTextBox("Lenovo");

			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
			log.info("Click on Search button");
			searchPage.clickToSearchButton();

			ExtentTestManager.getTest().log(Status.INFO, "Verify that two products are displayed");
			log.info("Verify that 2 products are displayed");
			Assert.assertEquals(searchPage.getSearchProductSize(), 2);

			log.info("Verify that lenovo 1 products are displayed");
			Assert.assertTrue(searchPage.getExpectedSearchProduct("Lenovo IdeaCentre 600 All-in-One PC"));

			log.info("Verify that lenovo 2 products are displayed");
			Assert.assertTrue(searchPage.getExpectedSearchProduct("Lenovo Thinkpad X1 Carbon Laptop"));
		}

		@Test
		private void TC_04_Search_With_Specific_Product_Name(Method method){
			ExtentTestManager.startTest(method.getName(), "Search with specific product name");

			ExtentTestManager.getTest().log(Status.INFO, "Input to search keyword text box");
			log.info("Input to search keyword text box");
			searchPage.inputToSearchTextBox("ThinkPad X1 Carbon");

			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
			log.info("Click on Search button");
			searchPage.clickToSearchButton();

			ExtentTestManager.getTest().log(Status.INFO, "Verify that two products are displayed");
			log.info("Verify that 2 products are displayed");
			Assert.assertEquals(searchPage.getSearchProductSize(), 1);

			ExtentTestManager.getTest().log(Status.INFO, "Verify that only one lenovo products are displayed");
			log.info("Verify that only one lenovo products are displayed");
			Assert.assertTrue(searchPage.getExpectedSearchProduct("Lenovo Thinkpad X1 Carbon Laptop"));
		}

		@Test
		private void TC_05_Search_With_Parent_Categories(Method method){
			ExtentTestManager.startTest(method.getName(), "Search with parent categories");

			ExtentTestManager.getTest().log(Status.INFO, "Input to search keyword text box");
			log.info("Input to search keyword text box");
			searchPage.inputToSearchTextBox("Apple macbook pro");

			ExtentTestManager.getTest().log(Status.INFO, "Check to Advanced search");
			log.info("Check to Advanced search");
			searchPage.checkToAdvancedSearch();

			ExtentTestManager.getTest().log(Status.INFO, "Select Computers at Category dropdown");
			log.info("Select Computers at Category dropdown");
			searchPage.selectValueAtCategoryDropdown("Computers");

			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
			log.info("Click on Search button");
			searchPage.clickToSearchButton();

			ExtentTestManager.getTest().log(Status.INFO, "Verify the no-result message when search has no result");
			log.info("Verify the no-result message when search has no result");
			Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
		}

		@Test
		private void TC_06_Search_With_Sub_Categories(Method method){
			ExtentTestManager.startTest(method.getName(), "Search with sub categories");

			ExtentTestManager.getTest().log(Status.INFO, "Input to search keyword text box");
			log.info("Input to search keyword text box");
			searchPage.inputToSearchTextBox("Apple macbook pro");

			ExtentTestManager.getTest().log(Status.INFO, "Check to Advanced search");
			log.info("Check to Advanced search");
			searchPage.checkToAdvancedSearch();

			ExtentTestManager.getTest().log(Status.INFO, "Select Computers at Category dropdown");
			log.info("Select Computers at Category dropdown");
			searchPage.selectValueAtCategoryDropdown("Computers");

			ExtentTestManager.getTest().log(Status.INFO, "Check to Automatically search sub categories");
			log.info("Check to Automatically search sub categories");
			searchPage.checkToSubCategory();

			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
			log.info("Click on Search button");
			searchPage.clickToSearchButton();

			ExtentTestManager.getTest().log(Status.INFO, "Verify that only 1 product are displayed");
			log.info("Verify that only 1 product are displayed");
			Assert.assertEquals(searchPage.getSearchProductSize(), 1);

			ExtentTestManager.getTest().log(Status.INFO, "Verify that only one products are displayed");
			log.info("Verify that only one products are displayed");
			Assert.assertTrue(searchPage.getExpectedSearchProduct("Apple MacBook Pro 13-inch"));
		}

		@Test
		private void TC_07_Search_With_Incorrect_Manufacturer(Method method) {
			ExtentTestManager.startTest(method.getName(), "Search with incorrect manufacturer");

			ExtentTestManager.getTest().log(Status.INFO, "Input to search keyword text box");
			log.info("Input to search keyword text box");
			searchPage.inputToSearchTextBox("Apple macbook pro");

			ExtentTestManager.getTest().log(Status.INFO, "Check to Advanced search");
			log.info("Check to Advanced search");
			searchPage.checkToAdvancedSearch();

			ExtentTestManager.getTest().log(Status.INFO, "Select Computers at Category dropdown");
			log.info("Select Computers at Category dropdown");
			searchPage.selectValueAtCategoryDropdown("Computers");

			ExtentTestManager.getTest().log(Status.INFO, "Check to Automatically search sub categories");
			log.info("Check to Automatically search sub categories");
			searchPage.checkToSubCategory();

			ExtentTestManager.getTest().log(Status.INFO, "Select HP at Manufacturer");
			log.info("Select HP at Manufacturer");
			searchPage.selectValueAtManufacturerDropdown("HP");

			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
			log.info("Click on Search button");
			searchPage.clickToSearchButton();

			ExtentTestManager.getTest().log(Status.INFO, "Verify the no-result message when search has no result");
			log.info("Verify the no-result message when search has no result");
			Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
		}

		@Test
		private void TC_08_Search_With_Correct_Manufacturer(Method method){
			ExtentTestManager.startTest(method.getName(), "Search with correct manufacturer");

			ExtentTestManager.getTest().log(Status.INFO, "Input to search keyword text box");
			log.info("Input to search keyword text box");
			searchPage.inputToSearchTextBox("Apple macbook pro");

			ExtentTestManager.getTest().log(Status.INFO, "Check to Advanced search");
			log.info("Check to Advanced search");
			searchPage.checkToAdvancedSearch();

			ExtentTestManager.getTest().log(Status.INFO, "Select Computers at Category dropdown");
			log.info("Select Computers at Category dropdown");
			searchPage.selectValueAtCategoryDropdown("Computers");

			ExtentTestManager.getTest().log(Status.INFO, "Check to Automatically search sub categories");
			log.info("Check to Automatically search sub categories");
			searchPage.checkToSubCategory();

			ExtentTestManager.getTest().log(Status.INFO, "Select Apple at Manufacturer");
			log.info("Select Apple at Manufacturer");
			searchPage.selectValueAtManufacturerDropdown("Apple");

			ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
			log.info("Click on Search button");
			searchPage.clickToSearchButton();

			ExtentTestManager.getTest().log(Status.INFO, "Verify that only one products are displayed");
			log.info("Verify that only one products are displayed");
			Assert.assertTrue(searchPage.getExpectedSearchProduct("Apple MacBook Pro 13-inch"));
		}

		@AfterClass
		public void AfterClass(){
			driver.quit();
		}
}
