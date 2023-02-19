package nopCommerce.user.PageObject;

import commons.BasePage;
import nopCommerce.user.PageUIs.NotebookPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotebookPageObject extends BasePage {
    WebDriver driver;

    public NotebookPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectValueInSortDropDown(String itemText) {
        waitForElementVisible(driver, NotebookPageUI.SORT_BY_DROP_DOWN);
        selectInDefaultDropDown(driver, NotebookPageUI.SORT_BY_DROP_DOWN, itemText);
        sleepInSecond(2);
    }

    public boolean isProductNameSortedFromAToZ() {
        ArrayList<String> productUIList = new ArrayList<String>();

        List<WebElement> productList = getElements(driver, NotebookPageUI.PRODUCT_TITLE);

        for (WebElement product : productList) {
            productUIList.add(product.getText().trim());
        }

        ArrayList<String> productSortList = new ArrayList<String>();

        for (String notSortProduct : productUIList) {
            productSortList.add(notSortProduct);
        }

        Collections.sort(productSortList);

        return productSortList.equals(productUIList);
    }

    public boolean isProductNameSortedFromZToA() {
        ArrayList<String> productUIList = new ArrayList<String>();

        List<WebElement> productList = getElements(driver, NotebookPageUI.PRODUCT_TITLE);

        for (WebElement product : productList) {
            productUIList.add(product.getText().trim());
        }

        ArrayList<String> productSortList = new ArrayList<String>();

        for (String notSortProduct : productUIList) {
            productSortList.add(notSortProduct);
        }

        Collections.sort(productSortList);
        Collections.reverse(productSortList);

        return productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortedFromLowToHigh() {
        ArrayList<Float> productUILists = new ArrayList<Float>();

        List<WebElement> productPrices = getElements(driver, NotebookPageUI.PRODUCT_PRICE);

        for (WebElement product : productPrices) {
            productUILists.add(Float.parseFloat(product.getText().replace("$", "").replace(",", "")));
        }

        ArrayList<Float> productSortedLists = new ArrayList<Float>();

        for (Float sortedProducts :
                productUILists) {
            productSortedLists.add(sortedProducts);
        }

        Collections.sort(productSortedLists);


        return productSortedLists.equals(productUILists);
    }

    public boolean isProductPriceSortedFromHighToLow() {
        ArrayList<Float> productUILists = new ArrayList<Float>();

        List<WebElement> productPrices = getElements(driver, NotebookPageUI.PRODUCT_PRICE);

        for (WebElement product : productPrices) {
            productUILists.add(Float.parseFloat(product.getText().replace("$", "").replace(",", "")));
        }

        ArrayList<Float> productSortedLists = new ArrayList<Float>();

        for (Float sortedProducts :
                productUILists) {
            productSortedLists.add(sortedProducts);
        }

        Collections.sort(productSortedLists);
        Collections.reverse(productSortedLists);

        return productSortedLists.equals(productUILists);
    }

    public void selectValueInDisplayDropDown(String itemText) {
        waitForElementVisible(driver, NotebookPageUI.DISPLAY_DROP_DOWN);
        selectValueOfDefaultDropdown(driver, NotebookPageUI.DISPLAY_DROP_DOWN, itemText);
        sleepInSecond(2);
    }

    public boolean isProductDisplayed(int items) {
        boolean condition = true;
        List<WebElement> products = getElements(driver, NotebookPageUI.PRODUCT_TITLE);

        if(products.size() <= items) {
            condition = true;
            System.out.println("There are " + items + " products in the list");
        } else{
            condition = false;
            System.out.println("There are not " + items + " products in the list");
        }
        return condition;
    }

    public boolean isPagingNavigationUndisplayed(String pageNavigation) {
        waitForElementInvisibleNotInDOM(driver, NotebookPageUI.DYNAMIC_PAGING_NAVIGATION, pageNavigation);
        return isElementUndisplayed(driver, NotebookPageUI.DYNAMIC_PAGING_NAVIGATION, pageNavigation);
    }

    public boolean isPagingNavigationDisplayed(String pageNavigation) {
        waitForElementVisible(driver, NotebookPageUI.DYNAMIC_PAGING_NAVIGATION, pageNavigation);
        return isElementDisplayed(driver, NotebookPageUI.DYNAMIC_PAGING_NAVIGATION, pageNavigation);
    }

    public void clickToPagingNumber(String pageNumber) {
        waitForElementClickable(driver, NotebookPageUI.DYNAMIC_PAGING_NUMBER, pageNumber);
        clickToElement(driver, NotebookPageUI.DYNAMIC_PAGING_NUMBER, pageNumber);
    }

    public DetailedProductPageObject clickOnProductByName(String productName) {
        waitForElementClickable(driver, NotebookPageUI.PRODUCT_NAME, productName);
        clickToElement(driver, NotebookPageUI.PRODUCT_NAME, productName);
        return PageGeneratorManager.getDetailedProductPageObject(driver);
    }

    public RecentLyReviewedPO clickOnRecentlyViewedHyperlink() {
        waitForElementClickable(driver, NotebookPageUI.RECENTLY_VIEWED_HYPERLINK);
        clickToElement(driver, NotebookPageUI.RECENTLY_VIEWED_HYPERLINK);
        return PageGeneratorManager.getRecentlyViewedPage(driver);
    }
}
