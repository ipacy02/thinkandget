package constants.locators;

import java.util.regex.Pattern;

public final class WishlistLocators {

    private WishlistLocators() {}

    // --- NAVIGATION LOGIC ---
    public static final String WISHLIST_HEADER_ICON = "header a[href='/wishlist']";

    // --- PRODUCT CARD ACTIONS (HOME/SHOP GRID) ---
    public static final String HEART_ICON_BUTTON = "button:has(svg.lucide-heart)";

    // --- EMPTY STATE VIEW ELEMENTS ---
    public static final String EMPTY_STATE_TEXT     = "Your wishlist is empty";

    // --- ACTIONS & REDIRECTION EXPECTATIONS ---
    public static final String EXPLORE_PRODUCTS_BTN = "button:has-text('Explore Products'), a:has-text('Explore Products')";
    // Centralized URL validation pattern to remove inline hardcoding from the test file
    public static final Pattern EXPLORE_REDIRECT_URL_PATTERN = Pattern.compile("/products|/shop|/home");

    // --- POPULATED STATE ELEMENTS & ACTIONS ---
    public static final String REMOVE_ITEM_BTN      = "button:has(svg.lucide-trash2)";
}