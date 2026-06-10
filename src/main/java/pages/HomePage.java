package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import constants.locators.HomeLocators;
import constants.locators.WishlistLocators;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void addToCart() {
        Locator productCard = page.locator(HomeLocators.PRODUCT_CARD_CONTAINER).first();

        productCard.hover();

        Locator quickAddButton = productCard.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName(HomeLocators.QUICK_ADD_BUTTON_TEXT));

        quickAddButton.waitFor();
        quickAddButton.click();
    }

    public ShopPage clickShopLink() {
        Locator shopLink = page.locator(HomeLocators.SHOP_LINK_HREF).first();
        shopLink.waitFor();
        shopLink.click();
        return new ShopPage(page);
    }

    public FlashPage clickFlashLink() {
        Locator flashLink = page.locator(HomeLocators.FLASH_LINK_HREF);
        flashLink.waitFor();
        flashLink.click();
        return new FlashPage(page);
    }

    public FeaturedPage clickFeatureLink() {
        Locator featuredLink = page.locator(HomeLocators.FEATURED_LINK_HREF);
        featuredLink.waitFor();
        featuredLink.click();
        return new FeaturedPage(page);
    }

    public void addItemToWishlist() {
        Locator productCard = page.locator(HomeLocators.PRODUCT_CARD_CONTAINER).first();

        productCard.hover();

        page.waitForTimeout(300);

        Locator heartButton = productCard.locator(WishlistLocators.HEART_ICON_BUTTON).first();

        heartButton.waitFor();
        heartButton.click();

        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public WishlistPage navigateToWishlistPage() {
        page.locator(WishlistLocators.WISHLIST_HEADER_ICON).first().click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return new WishlistPage(page);
    }
}