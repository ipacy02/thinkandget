package constants.locators;

public final class HomeLocators {

    private HomeLocators() {}

    // --- PRODUCT INTERACTION SELECTORS ---
    public static final String PRODUCT_CARD_CONTAINER = "a.group.card-hover.block";
    public static final String QUICK_ADD_BUTTON_TEXT  = "Quick Add";

    // --- NAVIGATION LINK SELECTORS ---
    public static final String SHOP_LINK_HREF         = "a[href='/products']";
    public static final String FLASH_LINK_HREF        = "a[href*='flash_sale=true']";
    public static final String FEATURED_LINK_HREF     = "a[href*='featured=true']";
}