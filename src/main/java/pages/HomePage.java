package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import constants.HomeLocators; // Imported home selectors

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void addToCart() {
        Locator productCard = page.locator(HomeLocators.PRODUCT_CARD_CONTAINER).first();

        productCard.hover();

        Locator quickAddButton = productCard.getByRole(AriaRole.BUTTON,
                new Locator.GetByRoleOptions().setName(HomeLocators.QUICK_ADD_BUTTON_TEXT));

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
}