package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static java.util.regex.Pattern.compile;

public class ShopPage extends BasePage {

    private final Locator sortSelectDropdown;
    private final Locator sidebarContainer;

    public ShopPage(Page page) {
        super(page);
        this.sortSelectDropdown = page.locator("div.relative select");
        this.sidebarContainer = page.locator("div.space-y-6 div.space-y-1");
    }

    // --- CATEGORY FILTERING ---
    public ShopPage selectCategory(String categoryName) {
        Locator categoryButton = sidebarContainer.locator("button")
                .filter(new Locator.FilterOptions().setHasText(categoryName))
                .first();

        categoryButton.waitFor();
        categoryButton.click();
        return this;
    }

    // --- DROPDOWN SORTING ---
    public ShopPage selectSortOption(String targetValue) {
        sortSelectDropdown.waitFor();
        sortSelectDropdown.selectOption(targetValue);
        return this;
    }

    // --- PRESET PRICE CAPSULE FILTERING ---
    public ShopPage selectPriceRangePreset(String rangeText) {
        Locator rangeButton = sidebarContainer.locator("button")
                .filter(new Locator.FilterOptions().setHasText(rangeText))
                .first();

        rangeButton.waitFor();
        rangeButton.click();
        return this;
    }

    //--- SIZE SORTING
    public ShopPage selectSize(String sizeText) {
        Locator sizeButton = page.locator("button")
                .filter(new Locator.FilterOptions().setHasText(("^" + sizeText + "$")))
                .first();

        sizeButton.waitFor();
        sizeButton.click();
        return this;
    }

    //--- COLOR SORTING
    public ShopPage selectColor(String colorName) {
        Locator colorSection = page.locator("div.space-y-6").filter(new Locator.FilterOptions().setHasText("COLOR"));

        Locator colorButton = colorSection.locator("button")
                .filter(new Locator.FilterOptions().setHasText(
                        compile("^" + colorName + "$", java.util.regex.Pattern.CASE_INSENSITIVE)
                ))
                .or(colorSection.locator("button[title='" + colorName + "']"))
                .or(colorSection.locator("button[value='" + colorName + "']"))
                .or(colorSection.locator("button[class*='bg-" + colorName.toLowerCase() + "']"))
                .first();

        colorButton.waitFor();
        colorButton.click();
        return this;
    }
}