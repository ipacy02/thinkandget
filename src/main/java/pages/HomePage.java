package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void addToCart() {
        Locator productCard = page.locator("a.group.card-hover.block").first();

        productCard.hover();

        Locator quickAddButton = productCard.getByRole(AriaRole.BUTTON,
                new Locator.GetByRoleOptions().setName("Quick Add"));

        quickAddButton.waitFor();
        quickAddButton.click();
    }

    public ShopPage clickShopLink() {
        Locator shopLink = page.locator("a[href='/products']").first();
        shopLink.waitFor();
        shopLink.click();
        return new ShopPage(page);
    }

    public FlashPage clickFlashLink() {
        Locator flashLink = page.locator("a[href*='flash_sale=true']");
        flashLink.waitFor();
        flashLink.click();
        return new FlashPage(page);
    }

    public FeaturedPage clickFeatureLink() {
        Locator featuredLink = page.locator("a[href*='featured=true']");
        featuredLink.waitFor();
        featuredLink.click();
        return new FeaturedPage(page);
    }
}