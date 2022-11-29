package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static CustomerInfoPageObject getCustomerInfoPageObject(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	
	public static DashboardPageObject getDasboardPageObject(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static AddressPageObject getAdressesPageObject(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPageObject(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static DetailedProductPageObject getDetailedProductPageObject(WebDriver driver) {
		return new DetailedProductPageObject(driver);
	}

	public static MyProdReviewsPO getMyProdReviewsPageObject(WebDriver driver) {
		return new MyProdReviewsPO(driver);
	}

	public static SearchPageObject getSearchPageObject(WebDriver driver) {
		return new SearchPageObject(driver);
	}

	public static NotebookPageObject getNotebookPageObject(WebDriver driver) {
		return new NotebookPageObject(driver);
	}

	public static WishlistPageObject getWishlistPageObject(WebDriver driver) {
		return new WishlistPageObject(driver);
	}
	public static ShoppingCartPageObject getShoppingCartPageObject(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}


}
