package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import commons.BaseTest;
import nopCommerce.common.Register_Common;
import nopCommerce.user.PageObject.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

import java.lang.reflect.Method;

public class Nopcommerce_Sort_Display_Paging extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    DashboardPageObject dashboardPage;
    NotebookPageObject notebookPage;

    String firstName, lastName, email, password;

    @Parameters({"Browser", "url"})
    @BeforeClass
    private void BeforeTest(String browser, String url){
        driver = getBrowserName(browser, url);

        DataHelper fakeData = new DataHelper();

        firstName = fakeData.getFirstNameData();
        lastName = fakeData.getLastNameData();
        email = fakeData.getEmailData();
        password = fakeData.getPasswordData();

        homePage = PageGeneratorManager.getHomePageObject(driver);

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
    private void TC_01_Sort_From_A_To_Z(Method method){
        ExtentTestManager.startTest(method.getName(), "Sort Product name from A to Z");

        ExtentTestManager.getTest().log(Status.INFO, "Hover to Computers");
        log.info("Hover to Computers");
        dashboardPage.hoverToComputer();

        ExtentTestManager.getTest().log(Status.INFO, "Click to Notebook to navigate to the page");
        log.info("Click to Notebook to navigate to the page");
        notebookPage = dashboardPage.clickToNoteBook();

        ExtentTestManager.getTest().log(Status.INFO, "Select sort A to Z");
        log.info("Select sort A to Z");
        notebookPage.selectValueInSortDropDown("Name: A to Z");

        ExtentTestManager.getTest().log(Status.INFO, "Verify products are sorted from A to Z");
        log.info("Verify products are sorted from A to Z");
        Assert.assertTrue(notebookPage.isProductNameSortedFromAToZ());
    }

    @Test
    private void TC_02_Sort_From_Z_To_A(Method method){
        ExtentTestManager.startTest(method.getName(), "Sort Product name from Z to A");

        ExtentTestManager.getTest().log(Status.INFO, "Select sort Z to A");
        log.info("Select sort A to Z");
        notebookPage.selectValueInSortDropDown("Name: Z to A");

        ExtentTestManager.getTest().log(Status.INFO, "Verify products are sorted from Z to A");
        log.info("Verify products are sorted from Z to A");
        Assert.assertTrue(notebookPage.isProductNameSortedFromZToA());
    }

    @Test
    private void TC_03_Sort_Price_From_Low_To_High(Method method){
        ExtentTestManager.startTest(method.getName(), "Sort product price from low to high");

        ExtentTestManager.getTest().log(Status.INFO, "Select sort low to high");
        log.info("Select sort low to high");
        notebookPage.selectValueInSortDropDown("Price: Low to High");

        ExtentTestManager.getTest().log(Status.INFO, "Verify products price are sorted from low to high");
        log.info("Verify products price are sorted from low to high");
        Assert.assertTrue(notebookPage.isProductPriceSortedFromLowToHigh());
    }

    @Test
    private void TC_04_Sort_Price_From_High_To_Low(Method method){
        ExtentTestManager.startTest(method.getName(), "Sort product price from high to low");

        ExtentTestManager.getTest().log(Status.INFO, "Select sort from high to low");
        log.info("Select sort from high to low");
        notebookPage.selectValueInSortDropDown("Price: High to Low");

        ExtentTestManager.getTest().log(Status.INFO, "Verify products price are sorted from high to low");
        log.info("Verify products price are sorted from high to low");
        Assert.assertTrue(notebookPage.isProductPriceSortedFromHighToLow());
    }

    @Test
    private void TC_05_Display_With_Three_Products(Method method){
        ExtentTestManager.startTest(method.getName(), "Verify display with 3 products");

        ExtentTestManager.getTest().log(Status.INFO, "Select display with 3 products");
        log.info("Select display with 3 products");
        notebookPage.selectValueInDisplayDropDown("3");

        ExtentTestManager.getTest().log(Status.INFO, "Verify there are 3 or less than 3 products are displayed");
        log.info("Verify there are 3 or less than 3 products are displayed");
        Assert.assertTrue(notebookPage.isProductDisplayed(3));

        ExtentTestManager.getTest().log(Status.INFO, "Verify next button at pagination is displayed");
        log.info("Verify next button at pagination is displayed");
        Assert.assertTrue(notebookPage.isPagingNavigationDisplayed("Next"));

        ExtentTestManager.getTest().log(Status.INFO, "Click to paging 2");
        log.info("Click to paging 2");
        notebookPage.clickToPagingNumber("2");

        ExtentTestManager.getTest().log(Status.INFO, "Verify previous button at pagination is displayed");
        log.info("Verify previous button at pagination is displayed");
        Assert.assertTrue(notebookPage.isPagingNavigationDisplayed("Previous"));
    }

    @Test
    private void TC_06_Display_With_Six_Products(Method method){
        ExtentTestManager.startTest(method.getName(), "Verify display with 6 products");

        ExtentTestManager.getTest().log(Status.INFO, "Select display with 6 products");
        log.info("Select display with 6 products");
        notebookPage.selectValueInDisplayDropDown("6");

        ExtentTestManager.getTest().log(Status.INFO, "Verify there are 6 or less than 6 products are displayed");
        log.info("Verify there are 6 or less than 6 products are displayed");
        Assert.assertTrue(notebookPage.isProductDisplayed(6));

        ExtentTestManager.getTest().log(Status.INFO, "Verify next button at pagination is displayed");
        log.info("Verify next button at pagination is displayed");
        Assert.assertTrue(notebookPage.isPagingNavigationUndisplayed("Next"));

        ExtentTestManager.getTest().log(Status.INFO, "Verify previous button at pagination is displayed");
        log.info("Verify previous button at pagination is displayed");
        Assert.assertTrue(notebookPage.isPagingNavigationUndisplayed("Previous"));
    }

    @Test
    private void TC_07_Display_With_Nine_Products(Method method){
        ExtentTestManager.startTest(method.getName(), "Verify display with 9 products");

        ExtentTestManager.getTest().log(Status.INFO, "Select display with 9 products");
        log.info("Select display with 9 products");
        notebookPage.selectValueInDisplayDropDown("9");

        ExtentTestManager.getTest().log(Status.INFO, "Verify there are 9 or less than 9 products are displayed");
        log.info("Verify there are 9 or less than 9 products are displayed");
        Assert.assertTrue(notebookPage.isProductDisplayed(9));

        ExtentTestManager.getTest().log(Status.INFO, "Verify next button at pagination is displayed");
        log.info("Verify next button at pagination is displayed");
        Assert.assertTrue(notebookPage.isPagingNavigationUndisplayed("Next"));

        ExtentTestManager.getTest().log(Status.INFO, "Verify previous button at pagination is displayed");
        log.info("Verify previous button at pagination is displayed");
        Assert.assertTrue(notebookPage.isPagingNavigationUndisplayed("Previous"));
    }

    @AfterClass
    private void AfterClass(){
        driver.quit();
    }
}
