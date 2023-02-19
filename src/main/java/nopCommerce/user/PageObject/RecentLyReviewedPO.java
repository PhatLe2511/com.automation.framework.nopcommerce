package nopCommerce.user.PageObject;

import commons.BasePage;
import nopCommerce.user.PageUIs.RecentViewedPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecentLyReviewedPO extends BasePage {
    WebDriver driver;


    public RecentLyReviewedPO(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isLast3ProductsDisplayed(String[] listProduct) {
        ArrayList<String> listClickProduct = new ArrayList<String>();
        for(int i = 0; i <= listProduct.length - 1; i++){
            listClickProduct.add(listProduct[i]);
        }
        Collections.reverse(listClickProduct);

        ArrayList<String> listRecentProduct = new ArrayList<String>();
        List<WebElement> listRecentProducts = getElements(driver, RecentViewedPageUI.PRODUCT_NAME);

        for (WebElement product: listRecentProducts
             ) {
            listRecentProduct.add(product.getText().trim());
        }
        return listRecentProduct.equals(listClickProduct);
    }
}
