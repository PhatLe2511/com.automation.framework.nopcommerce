package nopCommerce.user.PageObject;

import org.openqa.selenium.WebDriver;

import nopCommerce.user.PageUIs.MyProdReviewsPageUI;

public class MyProdReviewsPO extends SideBarPageObject{
		
		WebDriver driver;
		
	public MyProdReviewsPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getProductReview() {
		waitForElementVisible(driver, MyProdReviewsPageUI.REVIEW_INFO);
		return getElementText(driver, MyProdReviewsPageUI.REVIEW_INFO);
	}

}
