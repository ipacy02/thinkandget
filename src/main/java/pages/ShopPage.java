package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ShopPage extends BasePage {

    private final Locator sortSelectDropdown;
    private final Locator sidebarContainer;

    public ShopPage(Page page) {
        super(page);
        this.sortSelectDropdown = page.locator("div.relative select");
        // Targets the sidebar filter menu container
        this.sidebarContainer = page.locator("aside, .w-64, div:has-text('CATEGORY')").first();
    }


    public ShopPage selectCategory(String categoryName) {
        Locator categoryButton = sidebarContainer.locator("button, a")
                .filter(new Locator.FilterOptions().setHasText(categoryName))
                .first();

        categoryButton.waitFor();
        categoryButton.click();
        return this;
    }


    public ShopPage selectSortOption(String targetValue) {
        sortSelectDropdown.waitFor();
        sortSelectDropdown.selectOption(targetValue);
        return this;
    }
}