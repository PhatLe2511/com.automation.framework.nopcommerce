package nopCommerce.common;

import nopCommerce.user.PageObject.DashboardPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import commons.BaseTest;
import nopCommerce.user.PageObject.HomePageObject;
import nopCommerce.user.PageObject.PageGeneratorManager;
import nopCommerce.user.PageObject.RegisterPageObject;
import utilities.DataHelper;

public class Register_Common extends BaseTest{
	WebDriver driver;
	public static String email, password;
	HomePageObject homePage;
	RegisterPageObject registerPage;

	DashboardPageObject dashboardPage;

	String firstName, lastName;
	
	@Parameters({"Browser", "url"})
	@BeforeTest
	public void BeforeTest(String browserName, String url) {
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
		
		log.info("Input valid value into Firstname textbox with: " + firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("Input valid value into Lastname textbox with: " + lastName);
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
		
		driver.quit();
	}
}
