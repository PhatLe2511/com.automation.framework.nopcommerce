package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import nopCommerce.user.PageObject.*;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;
import utilities.Environment;

import java.lang.reflect.Method;
import java.util.Arrays;

public class NopCommerce_Wishlist_Compare extends BaseTest {
    WebDriver driver;

    Environment environment;
    HomePageObject homePage;
    RegisterPageObject registerPage;
    WishlistPageObject wishlistPage;
    NotebookPageObject noteBookPage;
    DashboardPageObject dashboardPage;

    RecentLyReviewedPO recentlyViewedPage;
    CompareListPageObject compareListPage;
    ShoppingCartPageObject shoppingCartPage;



    DetailedProductPageObject detailedProductPage;

    String url, firstName, lastName, email, password, productName, productPrice, productSKU;
    String firstProductImage, secondProductImage, firstProductName, secondProductName, firstProductPrice, secondProductPrice;
    private String productName1, productName2, productName3, productName4, productName5;

    @Parameters({"Browser", "env"})
    @BeforeClass
    public void BeforeClass(String browserName, String envName) {

        ConfigFactory.setProperty("env", envName);

        environment = ConfigFactory.create(Environment.class);

        driver = getBrowserName(browserName, environment.url());

        url = environment.url();

        DataHelper dataHelper = DataHelper.getDataHelper();
        firstName = dataHelper.getFirstNameData();
        lastName = dataHelper.getFirstNameData();
        email = dataHelper.getEmailData();
        password = dataHelper.getPasswordData();

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
        dashboardPage = PageGeneratorManager.getDasboardPageObject(driver);
        dashboardPage.openDemoUrl(url);

        ExtentTestManager.getTest().log(Status.INFO, "Click to Wishlist on the header");
        log.info("Click to Wishlist on the header");
        wishlistPage =  dashboardPage.clickToWishlistOnHeader();

        ExtentTestManager.getTest().log(Status.INFO, "Click to Check box of product");
        log.info("Click to Check box of product");
        wishlistPage.checkToProductCheckbox("HTC One M8 Android L 5.0 Lollipop");

        ExtentTestManager.getTest().log(Status.INFO, "Click to Add to cart");
        log.info("Click to Add to cart");
        shoppingCartPage = wishlistPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Verify products Wishlist is removed and shopping cart is added");
        log.info("Verify products Wishlist is removed and shopping cart is added");
        Assert.assertTrue(shoppingCartPage.isProductRemovedFromWishlist("0"));
        Assert.assertTrue(shoppingCartPage.isProductAddedToShoppingCart("1"));
    }

    @Test
    private void TC_03_Remove_Product_In_Wishlist_Page(Method method){
        ExtentTestManager.startTest(method.getName(), "Remove product in wishlist page");

        ExtentTestManager.getTest().log(Status.INFO, "Open demo page");
        log.info("Open demo page");
        dashboardPage = PageGeneratorManager.getDasboardPageObject(driver);
        dashboardPage.openDemoUrl(url);

        ExtentTestManager.getTest().log(Status.INFO, "Click to product to go to detailed page");
        log.info("Click to product to go to detailed page");
        detailedProductPage = dashboardPage.clickToProductName("HTC One M8 Android L 5.0 Lollipop");

        ExtentTestManager.getTest().log(Status.INFO, "Click to Add to wishlist");
        log.info("Click to Add to wishlist");
        detailedProductPage.clickToAddToWishlist();

        ExtentTestManager.getTest().log(Status.INFO, "Click to Wishlist on the header");
        log.info("Click to Wishlist on the header");
        wishlistPage = detailedProductPage.clickToWishlistOnHeader();

        ExtentTestManager.getTest().log(Status.INFO, "Click to Check box of product");
        log.info("Click to Check box of product");
        wishlistPage.checkToProductCheckbox("HTC One M8 Android L 5.0 Lollipop");

        ExtentTestManager.getTest().log(
                Status.INFO, "Click to remove button");
        log.info("Click to remove button");
        wishlistPage.clickOnRemoveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Verify empty message is displayed");
        log.info("Verify empty message is displayed");
        Assert.assertEquals(wishlistPage.getWishlistEmptyMessage(), "The wishlist is empty!");

        ExtentTestManager.getTest().log(Status.INFO, "Verify product is removed");
        log.info("Verify product is removed");
        Assert.assertTrue(wishlistPage.isProductUndisplayed());
    }

    @Test
    private void TC_04_Add_Product_To_Compare(Method method){
        ExtentTestManager.startTest(method.getName(), "Add Product to compare");

        ExtentTestManager.getTest().log(Status.INFO, "Open demo page");
        log.info("Open demo page");
        dashboardPage = PageGeneratorManager.getDasboardPageObject(driver);
        dashboardPage.openDemoUrl(url);

        ExtentTestManager.getTest().log(Status.INFO, "Get product information");
        log.info("Get product information");
        //firstProductImage = dashboardPage.getProductImage("HTC One M8 Android L 5.0 Lollipop");
        secondProductImage = dashboardPage.getProductImage("$25 Virtual Gift Card");
        firstProductName = dashboardPage.getProductName("HTC One M8 Android L 5.0 Lollipop");
        secondProductName = dashboardPage.getProductName("$25 Virtual Gift Card");
        firstProductPrice = dashboardPage.getProductPrice("HTC One M8 Android L 5.0 Lollipop");
        secondProductPrice = dashboardPage.getProductPrice("$25 Virtual Gift Card");

        ExtentTestManager.getTest().log(Status.INFO, "Click on compare button at product");
        log.info("Click on compare button at product");
        dashboardPage.clickOnCompareButtonAtProduct("HTC One M8 Android L 5.0 Lollipop");
        dashboardPage.clickOnCompareButtonAtProduct("$25 Virtual Gift Card");


        ExtentTestManager.getTest().log(Status.INFO, "Verify message informed products are added to compare list");
        log.info("Verify message informed products are added to compare list");
        Assert.assertEquals(dashboardPage.getCompareMessage(), "The product has been added to your product comparison");

        ExtentTestManager.getTest().log(Status.INFO, "Go to Compare list page by clicking on product comparison hyperlink");
        log.info("Go to Compare list page by clicking on product comparison hyperlink");
        compareListPage = dashboardPage.clickToProductComparison();

        ExtentTestManager.getTest().log(Status.INFO, "Verify product information is displayed");
        log.info("Verify product information is displayed");
        //Assert.assertEquals(compareListPage.getProductImage("HTC One M8 Android L 5.0 Lollipop"), firstProductImage);
        Assert.assertEquals(compareListPage.getProductImage("$25 Virtual Gift Card"), secondProductImage);
        Assert.assertEquals(compareListPage.getProductName("HTC One M8 Android L 5.0 Lollipop"), firstProductName);
        Assert.assertEquals(compareListPage.getProductName("$25 Virtual Gift Card"), secondProductName);
        Assert.assertEquals(compareListPage.getProductPrice("$245.00"), firstProductPrice);
        Assert.assertEquals(compareListPage.getProductPrice("$25.00"), secondProductPrice);

        ExtentTestManager.getTest().log(Status.INFO, "Click on clear list button");
        log.info("Click on clear list button");
        compareListPage.clickToClearListButton();

        ExtentTestManager.getTest().log(Status.INFO, "Verify message: " + "You have no items to compare");
        log.info("Verify message: " + "You have no items to compare");
        Assert.assertEquals(compareListPage.getCompareMessage(), "You have no items to compare.");

        ExtentTestManager.getTest().log(Status.INFO, "Verify product image, name and price are removed");
        log.info("Verify product image, name and price are removed");
        //Assert.assertTrue(compareListPage.isProductImageUndisplayed("HTC One M8 Android L 5.0 Lollipop"));
        Assert.assertTrue(compareListPage.isProductImageUndisplayed("$25 Virtual Gift Card"));
        Assert.assertTrue(compareListPage.isProductNameUndisplayed("HTC One M8 Android L 5.0 Lollipop"));
        Assert.assertTrue(compareListPage.isProductNameUndisplayed("$25 Virtual Gift Card"));
        Assert.assertTrue(compareListPage.isProductPriceUndisplayed("$245.00"));
        Assert.assertTrue(compareListPage.isProductPriceUndisplayed("$25.00"));
    }

    @Test
    private void TC_05_Recently_Viewed_Products(Method method){
        ExtentTestManager.startTest(method.getName(), "Add Product to compare");

        ExtentTestManager.getTest().log(Status.INFO, "Open demo page");
        log.info("Open demo page");
        dashboardPage = PageGeneratorManager.getDasboardPageObject(driver);
        dashboardPage.openDemoUrl(url);

        ExtentTestManager.getTest().log(Status.INFO, "Hover to Computers");
        log.info("Hover to Computers");
        dashboardPage.hoverToComputer();

        ExtentTestManager.getTest().log(Status.INFO, "Click to Notebook to navigate to the page");
        log.info("Click to Notebook to navigate to the page");
        noteBookPage = dashboardPage.clickToNoteBook();

        ExtentTestManager.getTest().log(Status.INFO, "Click on Product name 1");
        log.info("Click on Product name 1");
        detailedProductPage = noteBookPage.clickOnProductByName("HP Envy 6-1180ca 15.6-Inch Sleekbook");
        productName1 = detailedProductPage.getProductName();
        noteBookPage = detailedProductPage.backToNoteBookPage();

        ExtentTestManager.getTest().log(Status.INFO, "Click on Product name 2");
        log.info("Click on Product name 2");
        detailedProductPage = noteBookPage.clickOnProductByName("Apple MacBook Pro 13-inch");
        productName2 = detailedProductPage.getProductName();
        noteBookPage = detailedProductPage.backToNoteBookPage();

        ExtentTestManager.getTest().log(Status.INFO, "Click on Product name 3");
        log.info("Click on Product name 3");
        detailedProductPage = noteBookPage.clickOnProductByName("Asus N551JK-XO076H Laptop");
        productName3 = detailedProductPage.getProductName();
        noteBookPage = detailedProductPage.backToNoteBookPage();

        ExtentTestManager.getTest().log(Status.INFO, "Click on Product name 4");
        log.info("Click on Product name 4");
        detailedProductPage = noteBookPage.clickOnProductByName("Lenovo Thinkpad X1 Carbon Laptop");
        productName4 = detailedProductPage.getProductName();
        noteBookPage = detailedProductPage.backToNoteBookPage();

        ExtentTestManager.getTest().log(Status.INFO, "Click on Product name 5");
        log.info("Click on Product name 5");
        detailedProductPage = noteBookPage.clickOnProductByName("Samsung Series 9 NP900X4C Premium Ultrabook");
        productName5 = detailedProductPage.getProductName();
        noteBookPage = detailedProductPage.backToNoteBookPage();

        String[] listProduct = {productName3, productName4, productName5};

        ExtentTestManager.getTest().log(Status.INFO, "Go to Recent viewed page");
        log.info("Go to Recent viewed page");
        recentlyViewedPage = noteBookPage.clickOnRecentlyViewedHyperlink();

        ExtentTestManager.getTest().log(Status.INFO, "Verify only 3 recently viewed products are displayed");
        log.info("Verify only 3 recently viewed products are displayed");
        Assert.assertTrue(recentlyViewedPage.isLast3ProductsDisplayed(listProduct));

    }

    @AfterClass
    public void AfterClass(){
        driver.quit();
    }
}
