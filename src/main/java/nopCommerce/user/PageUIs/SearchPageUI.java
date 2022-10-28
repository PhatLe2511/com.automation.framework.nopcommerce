package nopCommerce.user.PageUIs;

public class SearchPageUI {
    public static final String SEARCH_TEXT_BOX= "css=input.search-text";

    public static final String ADVANCED_SEARCH_CHECK_BOX= "css=input#advs";

    public static final String SUB_CATEGORY_CHECK_BOX= "css=input#isc";
    public static final String SEARCH_BUTTON= "xpath=//div[@class='search-input']//button[text()='Search']";
    public static final String EMPTY_WARNING_MESSAGE = "css=div.warning";
    public static final String NO_RESULT_MESSAGE= "css=div.no-result";

    public static final  String PRODUCT_TITLE = "css=h2.product-title>a";

    public static final String CATEGORY_DROPDOWN = "xpath=//label[text()='Category:']/following-sibling::select";

    public static final String MANUFACTURER_DROPDOWN = "xpath=//label[text()='Manufacturer:']/following-sibling::select";
}
