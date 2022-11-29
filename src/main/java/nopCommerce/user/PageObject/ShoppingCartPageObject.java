package nopCommerce.user.PageObject;

import commons.BasePage;
import nopCommerce.user.PageUIs.ShoppingCartPageUI;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageObject extends BasePage {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductRemovedFromWishlist(String expectedProductQuantity) {
        boolean condition = false;
        String actualProductQuantity = getElementText(driver, ShoppingCartPageUI.WISHLIST_QUANTITY);

        if(actualProductQuantity.replace("(", "").replace(")", "").equals(expectedProductQuantity)){
            condition = true;
        }
        return condition;
    }


    public boolean isProductAddedToShoppingCart(String expectedProductQuantity) {
        boolean condition = false;
        String actualProductQuantity = getElementText(driver, ShoppingCartPageUI.SHOPPING_CART_QUANTITY);

        if(actualProductQuantity.replace("(", "").replace(")", "").equals(expectedProductQuantity)){
            condition = true;
        }
        return condition;
    }
}
