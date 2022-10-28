package nopCommerce.user.PageObject;

import commons.BasePage;
import nopCommerce.user.PageUIs.SearchPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPageObject extends BasePage {
    WebDriver driver;


    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public String getEmptyWarningMessage() {
        waitForElementVisible(driver, SearchPageUI.EMPTY_WARNING_MESSAGE);
        return getElementText(driver, SearchPageUI.EMPTY_WARNING_MESSAGE);
    }

    public void inputToSearchTextBox(String itemText) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXT_BOX);
        sendKeysToElement(driver, SearchPageUI.SEARCH_TEXT_BOX, itemText);
    }

    public String getNoResultMessage() {
        waitForElementVisible(driver, SearchPageUI.NO_RESULT_MESSAGE);
        return getElementText(driver, SearchPageUI.NO_RESULT_MESSAGE);
    }

    public int getSearchProductSize(){
        List<WebElement> productItems = getElements(driver, SearchPageUI.PRODUCT_TITLE);
        return productItems.size();
    }

    public boolean getExpectedSearchProduct(String expectedProduct){
        boolean status = true;
        List<WebElement> productItems = getElements(driver, SearchPageUI.PRODUCT_TITLE);
        ArrayList<String> listProducts = new ArrayList<String>();

        for (WebElement products: productItems) {
            listProducts.add(products.getText());
        }

        for (String actualProduct : listProducts){
            if (actualProduct.equals(expectedProduct)) {
                status = true;
                break;
            }else{
                status = false;
            }
        }
        return status;
    }


    public void checkToAdvancedSearch() {
        waitForElementVisible(driver, SearchPageUI.ADVANCED_SEARCH_CHECK_BOX);
        checkToCheckBox(driver, SearchPageUI.ADVANCED_SEARCH_CHECK_BOX);
    }

    public void selectValueAtCategoryDropdown(String itemText) {
        waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectValueOfDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, itemText);
    }

    public void checkToSubCategory() {
        waitForElementVisible(driver, SearchPageUI.SUB_CATEGORY_CHECK_BOX);
        checkToCheckBox(driver, SearchPageUI.SUB_CATEGORY_CHECK_BOX);
    }

    public void selectValueAtManufacturerDropdown(String itemText) {
        waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectValueOfDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, itemText);
    }
}
