package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
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

public class NopCommerce_Wishlist_Compare extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    DashboardPageObject dashboardPage;
    DetailedProductPageObject detailedProductPage;
    WishlistPageObject wishlistPage;
    String firstName, lastName, email, password, productName, productPrice, productSKU;

    @Parameters({"Browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserName(browserName, url);

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
    private void TC_01_Add_To_Wishlist(Method method){
        ExtentTestManager.startTest(method.getName(), "Add to Wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Click to product to go to detailed page");
        log.info("Click to product to go to detailed page");
        detailedProductPage = dashboardPage.clickToProductName("HTC One M8 Android L 5.0 Lollipop");

        ExtentTestManager.getTest().log(Status.INFO, "Get product title, SKU and price");
        log.info("Get product title, SKU and price");
        productName = detailedProductPage.getProductName();
        productPrice = detailedProductPage.getProductPrice();
        productSKU = detailedProductPage.getProductSKU();

        ExtentTestManager.getTest().log(Status.INFO, "Click to Add to wishlist");
        log.info("Click to Add to wishlist");
        detailedProductPage.clickToAddToWishlist();

        ExtentTestManager.getTest().log(Status.INFO, "Verify Success message is displayed after adding to wishlist");
        log.info("Verify Success message is displayed after adding to wishlist");
        Assert.assertEquals(detailedProductPage.getHeaderSuccessMessage(), "The product has been added to your wishlist");

        ExtentTestManager.getTest().log(Status.INFO, "Click to Wishlist on the header");
        log.info("Click to Wishlist on the header");
        wishlistPage = detailedProductPage.clickToWishlistOnHeader();

        ExtentTestManager.getTest().log(Status.INFO, "Verify product is added to wishlist");
        log.info("Verify product is added to wishlist");
        Assert.assertEquals(wishlistPage.getProductSKU(), productSKU);
        Assert.assertEquals(wishlistPage.getProductName(), productName);
        Assert.assertEquals(wishlistPage.getProductPrice(), productPrice);

        ExtentTestManager.getTest().log(Status.INFO, "Click on Wishlist URL");
        log.info("Click on Wishlist URL");
        wishlistPage.clickToWishlistURL();

        ExtentTestManager.getTest().log(Status.INFO, "Verify user can wishlist from URL with: " + "Wishlist of " + firstName + " " + lastName);
        log.info("Verify user can wishlist from URL with: " + "Wishlist of " + firstName + " " + lastName);
        Assert.assertEquals(wishlistPage.getWishlistHeader(), "Wishlist of " + firstName + " " + lastName);
    }

    @Test
    private void TC_02_Add_Product_To_Cart(Method method){
        ExtentTestManager.startTest(method.getName(), "Add product to cart");

        ExtentTestManager.getTest().log(Status.INFO, "Open demo page");
        log.info("Open demo page");
        dashboardPage.openURL("");

        ExtentTestManager.getTest().log(Status.INFO, "Click to Wishlist on the header");
        log.info("Click to Wishlist on the header");
    }


    @AfterClass
    public void AfterClass(){
        driver.quit();
    }
}
