package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import constants.locators.WishlistLocators;

public class WishlistPage extends BasePage {

    private final Locator emptyStateMessage;
    private final Locator exploreProductsButton;

    public WishlistPage(Page page) {
        super(page);
        this.emptyStateMessage = page.getByText(WishlistLocators.EMPTY_STATE_TEXT).first();
        this.exploreProductsButton = page.locator(WishlistLocators.EXPLORE_PRODUCTS_BTN).first();
    }

    public Locator getEmptyStateMessage() {
        return this.emptyStateMessage;
    }

    public ShopPage clickExploreProducts() {
        exploreProductsButton.waitFor();
        exploreProductsButton.click();
        return new ShopPage(page);
    }

    public WishlistPage removeItemFromWishlist() {
        Locator removeButton = page.locator(WishlistLocators.REMOVE_ITEM_BTN).first();
        removeButton.waitFor();
        removeButton.click();
        return this;
    }
}