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
        // Pinpoints the specific container layout wrapper for all filter items
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

    public ShopPage selectSize(String sizeText) {
        // Tightens the search path: look specifically for a button whose exact inner text matches your size
        Locator sizeButton = page.locator("button")
                .filter(new Locator.FilterOptions().setHasText(("^" + sizeText + "$")))
                .first();

        sizeButton.waitFor();
        sizeButton.click();
        return this;
    }

    public ShopPage selectColor(String colorName) {
        // 1. Target the color layout block area safely without fragile parent links
        Locator colorSection = page.locator("div.space-y-6").filter(new Locator.FilterOptions().setHasText("COLOR"));

        // 2. Find the circle button using standard Pattern flag compilation parameters
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