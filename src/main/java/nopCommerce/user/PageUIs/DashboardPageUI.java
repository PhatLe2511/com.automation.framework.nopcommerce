package nopCommerce.user.PageUIs;

public class DashboardPageUI {
	public static final String MY_ACCOUNT_BUTTON ="xpath=//a[text()='My account']";
	public static final String LOGOUT_BUTTON="xpath=//a[text()='Log out']";
	public static final String SEARCH_BUTTON ="xpath=//a[text()='Search']";
	public static final String COMPUTER_BUTTON ="xpath=//div[@class='header-menu']/ul[@class='top-menu notmobile']//a[text()='Computers ']";
	public static final String NOTEBOOK_BUTTON ="xpath=//div[@class='header-menu']/ul[@class='top-menu notmobile']//a[text()='Notebooks ']";

	public static final String PRODUCT_NAME="xpath=//h2[@class='product-title']/a[text()='%s']";

	public static final String WISHLIST_HYPERLINK = "css=div.header-links a.ico-wishlist";
	public static final String COMPARE_BUTTON = "XPATH=//a[text()='%s']/parent::h2/following-sibling::div//button[text()='Add to compare list']";
	public static final String PRODUCT_IMAGE = "XPATH=//div[@class='picture']//img[@alt='Picture of %s']";
	public static final String PRODUCT_PRICE = "XPATH=//a[text()='%s']/parent::h2/following-sibling::div//div[@class='prices']/span";
	public static final String COMPARED_PRODUCT_MESSAGE = "css=div[class*='bar-notification']>p";

	public static final String PRODUCT_COMPARISON_HYPERLINK = "css=div[class*='bar-notification'] a";



}
