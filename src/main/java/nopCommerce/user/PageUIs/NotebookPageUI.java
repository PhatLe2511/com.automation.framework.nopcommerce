package nopCommerce.user.PageUIs;

public class NotebookPageUI {
    public static final String SORT_BY_DROP_DOWN="xpath=//span[text()='Sort by']/following-sibling::select";
    public static final String DISPLAY_DROP_DOWN="xpath=//span[text()='Display']/following-sibling::select";
    public static final  String PRODUCT_TITLE = "css=h2.product-title>a";
    public static final  String PRODUCT_PRICE = "css=div.add-info>div.prices>span";
    public static final String DYNAMIC_PAGING_NAVIGATION = "xpath=//li/a[text()='%s']";
    public static final String DYNAMIC_PAGING_NUMBER = "xpath=//li[@class='individual-page']/a[text()='%s']";
    public static final String PRODUCT_NAME = "xpath=//h2[@class='product-title']/a[text()='%s']";
    public static final String RECENTLY_VIEWED_HYPERLINK = "xpath=//a[text()='Recently viewed products']";
}
