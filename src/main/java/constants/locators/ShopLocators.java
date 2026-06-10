package constants.locators;

public final class ShopLocators {

    private ShopLocators() {}

    // --- SEARCH INTERFACE SELECTORS ---
    public static final String SEARCH_TOGGLE_BUTTON  = "header button svg, button:has(svg)";
    public static final String SEARCH_INPUT_FIELD    = "input[placeholder*='Search products']";
    public static final String SEARCH_RESULTS_HEADER = "h1, h2, div";
    public static final String SEARCH_RESULTS_TEXT   = "Results for";

    // --- SORTING & FILTER CONTAINER SELECTORS ---
    public static final String SORT_SELECT_DROPDOWN  = "div.relative select";

    // Core structural anchors
    public static final String BASE_SIDEBAR_GROUP    = "div.space-y-6";
    public static final String SIDEBAR_CONTAINER     = "div.space-y-6 >> div.space-y-1";
    public static final String PRICE_SECTION_CONTAINER = "div.flex.flex-wrap.gap-1\\.5";
    public static final String GENERIC_BUTTON        = "button";
    public static final String PRODUCT_CARD_ANCHOR   = "a.group.card-hover.block";

    // --- EMPTY STATE CONTROLS ---
    public static final String NO_PRODUCTS_MESSAGE   = "text=No products found";

    // --- DYNAMIC COLOR ATTRIBUTE TEMPLATES ---
    public static final String COLOR_TITLE_TEMPLATE  = "button[title='%s']";
    public static final String COLOR_VALUE_TEMPLATE  = "button[value='%s']";
    public static final String COLOR_CLASS_TEMPLATE  = "button[class*='bg-%s']";

    // --- IDENTIFIER TEXT EXHAUSTION BANNER CONTROLS ---
    public static final String COLOR_SECTION_TEXT    = "COLOR";
    public static final String SIZE_SECTION_TEXT     = "SIZE";
}